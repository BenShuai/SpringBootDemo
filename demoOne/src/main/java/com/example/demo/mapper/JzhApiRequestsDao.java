package com.example.demo.mapper;

import com.example.demo.entity.JzhApiRequests;
import org.apache.ibatis.annotations.Mapper;

/**
 * 金账户发送请求表
 * 
 * @author sunshuai
 * @email sunshuai@szpyph.com
 * @date 2018-05-24
 */
 @Mapper
public interface JzhApiRequestsDao extends BaseDao {
    JzhApiRequests queryBySsn(String ssn);
}
