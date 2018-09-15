package com.it.sun.service;

import java.util.List;
import java.util.Map;


public interface BaseService<T>{
	public int insert(T entity);
    public int insert(Map<String, Object> map);
    public int batchInsert(List<T> entities);
    
    public int update(T condition);
    public int update(Map<String, Object> map);
    public int batchUpdate(List<T> condition);
    
    public int delete(Object condition);
    public int delete(Map<String, Object> map);
    public int batchDelete(Object[] id);
    
    public int count(T condition);
    public int queryTotal(Map<String, Object> map);
    
    public List<T> query(T condition);
    public List<T> queryList(Map<String, Object> map);

    public T queryObject(Object condition);
    public T queryObject(Map<String, Object> map);
}
