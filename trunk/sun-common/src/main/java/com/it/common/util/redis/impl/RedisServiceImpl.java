package com.it.common.util.redis.impl;


import com.it.common.util.redis.RedisService;
import com.it.common.util.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("redisService")
@Transactional(rollbackFor = Exception.class)
public class RedisServiceImpl implements RedisService {
    private static int seconds=3600*24;

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    /**
     * 存储字段，永久有效
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    @Override
    public boolean set(final String key, final String value) throws Exception {
        Assert.hasText(key,"Key is not empty.");
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    /**
     * 存储字段，并且设置过期时间
     * @param key
     * @param value
     * @param validTime
     * @return
     * @throws Exception
     */
    @Override
    public boolean set(String key, String value, long validTime) throws Exception {
        Assert.hasText(key,"Key is not empty.");
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                connection.expire(serializer.serialize(key),validTime);//设置过期时间
                return true;
            }
        });
        return result;
    }
    @Override
    public String get(final String key) throws Exception {
        Assert.hasText(key,"Key is not empty.");
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }
    @Override
    public void del(final String key) throws Exception {
        Assert.hasText(key,"Key is not empty.");

        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection conn) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return conn.del(serializer.serialize(key));
            }
        });
    }

    /**
     * 设置某个KEY的过期时间，单位秒
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public <T> boolean setList(String key, List<T> list) throws Exception {
        Assert.hasText(key,"Key is not empty.");

        String value = JsonUtil.getJsonString(list);
        return set(key,value);
    }

    @Override
    public <T> List<T> getList(String key,Class<T> clz)  throws Exception{

        Assert.hasText(key,"Key is not empty.");

        String json = get(key);
        if(json!=null){
            List<T> list = JsonUtil.readJson2Array(json,clz);
            return list;
        }
        return null;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头
     * @param key
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public long lpush(final String key, Object obj)throws Exception {
        Assert.hasText(key,"Key is not empty.");

        final String value = JsonUtil.getJsonString(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。
     * @param key
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public long rpush(final String key, Object obj) throws Exception{
        Assert.hasText(key,"Key is not empty.");

        final String value = JsonUtil.getJsonString(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    /**
     * 返回redis中List类型的key的值
     * @param key
     * @return
     */
    @Override
    public List<Object> listRange(String key) throws Exception{
        return (List<Object>)redisTemplate.opsForList().range(key, 0, -1);
    }

    @Override
    public void hmset(String key, Object obj)  throws Exception{
        Assert.hasText(key,"Key is not empty.");

        Map<byte[], byte[]> data= JsonUtil.readJsonByteMap(JsonUtil.getJsonString(obj));
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.hMSet(serializer.serialize(key),data);
                return "";
            }
        });
    }

    @Override
    public <T> T hget(String key, Class<T> clz)  throws Exception{
        Assert.hasText(key,"Key is not empty.");

        return redisTemplate.execute(new RedisCallback<T>() {

            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                Map<String,Object> result;

                Map<byte[],byte[]> data=connection.hGetAll(serializer.serialize(key));
                result= new HashMap<>();
                for (Map.Entry<byte[], byte[]> entry: data.entrySet()) {
                    result.put(serializer.deserialize(entry.getKey()),serializer.deserialize(entry.getValue()));
                }

                return JsonUtil.json2Obj(JsonUtil.getJsonString(result),clz);
            }
        });
    }

    /**
     * 返回哈希表 key 中，所有的域和值。
     * @param key
     * @param clz
     * @param <T>
     * @return
     * @throws Exception
     */
    @Override
    public<T> List<T> hmGetAll(String key, Class<T> clz) throws Exception{
        Assert.hasText(key,"Key is not empty.");

        List<Map<String,Object>> dataList= new ArrayList<>();
        return redisTemplate.execute(new RedisCallback<List<T>>() {
            @Override
            public List<T> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                Set<String> keysSet=redisTemplate.keys(key);
                Map<byte[],byte[]> data;
                Map<String,Object> result;
                for(String newKey:keysSet) {
                    data=connection.hGetAll(serializer.serialize(newKey));
                    result= new HashMap<>();
                    for (Map.Entry<byte[], byte[]> entry: data.entrySet()) {
                        result.put(serializer.deserialize(entry.getKey()),serializer.deserialize(entry.getValue()));
                    }
                    dataList.add(result);
                }
                return JsonUtil.readJson2Array(JsonUtil.getJsonString(dataList),clz);
            }
        });
    }

    /**
     * 移除并返回列表 key 的头元素。
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    public String lpop(final String key) throws Exception{
        Assert.hasText(key,"Key is not empty.");

        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res =  connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }


    /**
     * 根据字符串模糊搜索相关key
     * @param pattern
     * @return
     * @throws Exception
     */
    @Override
    public Set<String> keys(String pattern) throws Exception {
        return redisTemplate.keys("*"+ pattern + "*");
    }

    /**
     * 计数器
     * @param key
     * @param add
     * @return
     */
    @Override
    public Long incr(String key, long add) {
        return redisTemplate.execute((RedisCallback<Long>) con -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            Long record = con.incrBy(serializer.serialize(key), add);
            return record == null ? 0L : record;
        });
    }
}
