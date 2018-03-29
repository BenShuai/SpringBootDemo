package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mybatis的
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM User WHERE name = #{name} limit 1")
    User findUserByName(@Param("name") String name);

    @Insert("INSERT INTO User(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") String eag);
}
