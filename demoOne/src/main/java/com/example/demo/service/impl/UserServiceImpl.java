package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.BaseDao;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
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
