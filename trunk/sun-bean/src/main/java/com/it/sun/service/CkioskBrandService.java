package com.it.sun.service;

import com.it.sun.entity.CkioskBrandExample;
import com.it.sun.mapper.CkioskBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CkioskBrandService {
    @Autowired
    private CkioskBrandMapper ckioskBrandMapper;


    public int countByExample(CkioskBrandExample example) {
        return ckioskBrandMapper.countByExample(example);
    }

}
