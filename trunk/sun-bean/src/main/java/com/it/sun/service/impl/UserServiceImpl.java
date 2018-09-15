package com.it.sun.service.impl;

import com.it.sun.entity.User;
import com.it.sun.mapper.BaseDao;
import com.it.sun.mapper.UserMapper;
import com.it.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseDao getBaseDao() {
        return  userMapper;
    }

//    @Override
//    public User findUserByName(String name) {
//        return blUserDao.findUserByName(name);
//    }
//
//    @Override
//    public int insert(String name,String eag) {
//        return blUserDao.insert(name,eag);
//    }

    @Override
    public List<Map<String, String>> queryBa(String ids) {
        return userMapper.queryBa(ids);
    }
}
