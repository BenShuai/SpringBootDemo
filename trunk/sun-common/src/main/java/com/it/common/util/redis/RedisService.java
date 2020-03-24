package com.it.common.util.redis;

import java.util.List;
import java.util.Set;

public interface  RedisService {
    boolean set(String key, String value) throws Exception;

    boolean set(String key, String value,long validTime) throws Exception;

    String get(String key) throws Exception;

    boolean expire(String key, long expire) throws Exception;

    <T> boolean setList(String key, List<T> list) throws Exception;

    <T> List<T> getList(String key, Class<T> clz) throws Exception;

    long lpush(String key, Object obj) throws Exception;

    long rpush(String key, Object obj) throws Exception;

    List<Object> listRange(String key) throws Exception;

    void hmset(String key, Object obj) throws Exception;

    <T> T hget(String key, Class<T> clz) throws Exception;


    void del(String key) throws Exception;

    <T> List<T> hmGetAll(String key, Class<T> clz) throws Exception;

    String lpop(String key) throws Exception;

    Set<String> keys(String pattern) throws Exception;

    Long incr(String key, long add);
}
