package com.it.common.uitl.excel;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;


/**
 * 导出excel
 * @author YBING
 * @date 2018/5/30
 */
public class ExportExcel<T> {

//    public static final String  fileName = "列表" + System.currentTimeMillis() + ".xls";

    public void exportExceltoStream(List<T> list, OutputStream output) throws Exception {
        try {
            ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
            if (list == null || list.size() <= 0) {
                return;
            }
            T t = list.get(0);
            Workbook workbook = ExcelExportUtil.exportExcel(params, t.getClass(), list);
            workbook.write(output);
        } catch (Exception e) {
            throw e;
        } finally {
            list = null;
        }
    }

//    //设置响应头
//    private static void setHeard(HttpServletResponse response) throws Exception {
//        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//        response.setHeader("Content-Disposition", "attachment;filename="
//                + new String((fileName.getBytes("GB2312")), "ISO8859-1"));
//    }

}
