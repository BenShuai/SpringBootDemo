package com.it.common.uitl.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 解析excel
 * @author YBING
 * @date 2018/5/30
 */
public class ImportExcelUtil<T> {

    public List<T> importExcel(InputStream inputstream, Class<T> ss) {
        List<T> objectlist = new ArrayList<T>();
        HashMap<String, String> hashmap = new HashMap<>();
        HashMap<Integer, String> hashmapexcel = new HashMap<>();
        // 反射拿field
        Field[] field = ss.getDeclaredFields();
        Object objectsub = null;
        Class classsub = null;
        Field fieldtempannto = null;
        for (Field fieldtemp : field) {
            String s = "";
            s = (fieldtemp.getAnnotation(ExcelAnnotation.class) != null) ? fieldtemp.getAnnotation(ExcelAnnotation.class).ClassSubtName() : fieldtemp.getName().toLowerCase();
            // 基于注解
            if (!s.endsWith("") || s.equals("subClass"))
            {
                // Object object = (Page.class.getSimpleName())
                try {
                    fieldtempannto = fieldtemp;
                    classsub = fieldtemp.getType();
                    Field[] fieldsub = Class.forName(fieldtemp.getType().getName()).getDeclaredFields();
                    for (Field fieldsubtemp : fieldsub) {
                        hashmap.put(fieldsubtemp.getName().toLowerCase(), fieldsubtemp.getName());
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            hashmap.put(s, fieldtemp.getName());
        }
        Workbook wb = this.getExcelWorkBook(inputstream);
        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            Sheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();
            for (int j = 0; j < rows; j++) {
                T object = null;

                try {
                    if (classsub != null) {
                        objectsub = classsub.newInstance();
                    }
                    object = ss.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Row row = sheet.getRow(j);
                if (row == null) {
                    rows++;
                    continue;
                }
                int cells = row.getLastCellNum();
                for (int c = 0; c < cells; c++) {
                    if (j == 0) {
                        hashmapexcel.put(c, row.getCell(c).getStringCellValue().toLowerCase());
                    } else {
                        Object objtemp = null;
                        Object objsubtemp = null;
                        if (hashmap.containsKey(hashmapexcel.get(c))) {
                            try {

                                // EXCEL中 一般就2中类型 NUMBER 和 STRING 也就是文本类型
                                if (row.getCell(c) == null){
                                    continue;
                                }
                                switch (row.getCell(c).getCellType()) {
                                    case 0:
                                        // NUMBER类型中 有可能是时间类型
                                        if (DateUtil.isCellDateFormatted(row.getCell(c)))
                                        // 所以需要判断
                                        {
                                            objtemp = row.getCell(c).getDateCellValue();
                                            objsubtemp = row.getCell(c).getDateCellValue();

                                        } else {
                                            objtemp = String.valueOf(row.getCell(c).getNumericCellValue());
                                            objsubtemp = String.valueOf(row.getCell(c).getNumericCellValue());
                                            if (row.getCell(c).getNumericCellValue() % 1.0 == 0) {
                                                objtemp = String.valueOf((long) row.getCell(c).getNumericCellValue());
                                                objsubtemp = String.valueOf((long) row.getCell(c).getNumericCellValue());
                                            }
                                        }

                                        break;
                                    case 1:
                                        objtemp = row.getCell(c).getStringCellValue();
                                        objsubtemp = row.getCell(c).getStringCellValue();
                                        break;
                                    case 4:
                                        objtemp = row.getCell(c).getBooleanCellValue();
                                        objsubtemp = row.getCell(c).getBooleanCellValue();
                                        break;
                                }
                                BeanUtils.setProperty(object, hashmap.get(hashmapexcel.get(c)), objtemp);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            if (objsubtemp != null && objectsub != null) {
                                try {
                                    BeanUtils.setProperty(objectsub, hashmap.get(hashmapexcel.get(c)), objsubtemp);

                                    BeanUtils.setProperty(object, fieldtempannto.getName().toLowerCase(), objectsub);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                if (j != 0) {
                    objectlist.add(object);
                }
            }
        }
        return objectlist;
    }

    /**
     * 兼容2003 2007
     *
     * @param inputstream 文件流
     * @return EXCELworkbook @
     */
    public Workbook getExcelWorkBook(InputStream inputstream) {
        try {
            Workbook wb = WorkbookFactory.create(inputstream);
            inputstream.close();
            return wb;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputstream != null) {
                    inputstream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

