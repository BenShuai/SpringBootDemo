package com.it.sun.service;

import com.it.sun.entity.example.CkioskBrandExample;
import com.it.sun.mapper.CkioskBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CkioskBrandService {
    @Autowired
    private CkioskBrandMapper ckioskBrandMapper;


    public int countByExample(CkioskBrandExample example) {
        return ckioskBrandMapper.countByExample(example);
    }

    public List<Map<String, String>> queryBa(String ids){
        return ckioskBrandMapper.queryBa(ids);
    }
}
