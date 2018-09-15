package com.it.sun.mapper;

import com.it.sun.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Mybatis的
 */
@Mapper
public interface UserMapper extends BaseDao {
//    @Select("SELECT * FROM User WHERE name = #{name} limit 1")
//    User findUserByName(@Param("name") String name);
//
//    @Insert("INSERT INTO User(name, age) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") String eag);

    List<Map<String,String>> queryBa(String ids);
}
