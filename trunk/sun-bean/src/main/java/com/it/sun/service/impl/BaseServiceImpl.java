package com.it.sun.service.impl;


import com.it.sun.mapper.BaseDao;
import com.it.sun.service.BaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

public  abstract  class BaseServiceImpl<T> implements BaseService<T> {
   public Log log = LogFactory.getLog(getClass());
   public abstract BaseDao getBaseDao();
	 
	@Override
	public int insert(T entity) {
		return getBaseDao().insert(entity);
	}
	@Override
	public int insert(Map<String, Object> map) {
		return getBaseDao().insert(map);
	}
	@Override
	public int batchInsert(List<T> entities) {
		return getBaseDao().batchInsert(entities);
	}
	
	@Override
	public int update(Map<String, Object> map) {
		return getBaseDao().update(map);
	}
	@Override
	public int update(T condition) {
		return getBaseDao().update(condition);
	}
	@Override
	public int batchUpdate(List<T> condition) {
		return getBaseDao().batchUpdate(condition);
	}

	@Override
	public int delete(Object condition) {
		return getBaseDao().delete(condition);
	}

	@Override
	public int delete(Map<String, Object> map) {
		return getBaseDao().delete(map);
	}

	@Override
	public int batchDelete(Object[] id) {
		return getBaseDao().batchDelete(id);
	}

	@Override
	public int count(T condition) {
		return getBaseDao().count(condition);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return getBaseDao().queryTotal(map);
	}

	@Override
	public List<T> query(T condition) {
		return getBaseDao().query(condition);
	}

	@Override
	public List<T> queryList(Map<String, Object> map) {
		return getBaseDao().queryList(map);
	}
	@Override
	public T queryObject(Object condition) {
		return  (T) getBaseDao().queryObject(condition);
	}

	@Override
	public T queryObject(Map<String, Object> map) {
		return (T) getBaseDao().queryObject(map);
	}

}
