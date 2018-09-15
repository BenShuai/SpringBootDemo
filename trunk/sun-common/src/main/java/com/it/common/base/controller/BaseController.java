package com.it.common.base.controller;

import java.lang.reflect.Field;
import java.util.List;

import com.it.common.uitl.exception.APPExCode;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.it.common.base.vo.response.BaseRespons;
 
 

public class BaseController {
	  @Autowired
	  private BaseRespons baseRespons;
//	  @Autowired
//	  LogMongodbDao logMongodbDao;
	  
	  public BaseRespons success(List list) {
		      baseRespons.setData(BaseRespons.ok(list));
		    //  logMongodbDao.insert(interfaceLog);
		      return baseRespons;
	   }
	   public BaseRespons success(PageInfo pageInfo) {
		      baseRespons.setData(BaseRespons.ok(pageInfo));
		     // logMongodbDao.insert(interfaceLog);
			  return baseRespons;
	   }
	   public BaseRespons success(String str) {
		   	  baseRespons.setData((str));
		   	//  logMongodbDao.insert(interfaceLog);
			  return baseRespons;
	   }
	   public BaseRespons success(Object object) {
		     baseRespons.setData(BaseRespons.ok(object));
		   //  logMongodbDao.insert(interfaceLog);
		     return baseRespons;
	   }
	   public BaseRespons RRException (String code,String mgs) {
		   return  BaseRespons.RRException(code, mgs);
	   }
	   public BaseRespons defaultError (Exception e) {
		   e.printStackTrace();
		   return  BaseRespons.error(APPExCode.SYS_UNKNOWN_ERROR.getErrorCode(),APPExCode.SYS_UNKNOWN_ERROR.getErrorMsg());
	   }
	   public BaseRespons userDefinedError (String code,String mgs) {
		   return  BaseRespons.error(code, mgs);
	   }
	   public  boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

		    boolean flag = false;
		    for(Field f : obj.getClass().getDeclaredFields()){
		        f.setAccessible(true);
		         
		        if(f.get(obj) == null){
		            flag = true;
		            return flag;
		        }
		    }
		    return flag;
		}
}
