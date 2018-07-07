package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService {
//    User findUserByName(String name);
//
//    int insert(String name,String eag);

    List<Map<String,String>> queryBa(String ids);
}
