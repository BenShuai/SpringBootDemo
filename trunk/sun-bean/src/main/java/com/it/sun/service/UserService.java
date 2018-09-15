package com.it.sun.service;

import com.it.sun.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService {
//    User findUserByName(String name);
//
//    int insert(String name,String eag);

    List<Map<String,String>> queryBa(String ids);
}
