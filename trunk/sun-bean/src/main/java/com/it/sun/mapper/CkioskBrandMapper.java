package com.it.sun.mapper;

import com.it.sun.entity.CkioskBrand;
import com.it.sun.entity.example.CkioskBrandExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CkioskBrandMapper {
    int countByExample(CkioskBrandExample example);

    int deleteByExample(CkioskBrandExample example);

    int deleteByPrimaryKey(Integer ckioskBrandid);

    int insert(CkioskBrand record);

    int insertSelective(CkioskBrand record);

    List<CkioskBrand> selectByExample(CkioskBrandExample example);

    CkioskBrand selectByPrimaryKey(Integer ckioskBrandid);

    int updateByExampleSelective(@Param("record") CkioskBrand record, @Param("example") CkioskBrandExample example);

    int updateByExample(@Param("record") CkioskBrand record, @Param("example") CkioskBrandExample example);

    int updateByPrimaryKeySelective(CkioskBrand record);

    int updateByPrimaryKey(CkioskBrand record);

    List<Map<String, String>> queryBa(String ids);
}