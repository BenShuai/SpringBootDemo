package com.it.common.base.controller;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.it.common.base.vo.response.BaseRespons;
import com.it.common.mongodb.LogMongodbDao;
import com.it.common.mongodb.model.InterfaceLog;
import com.it.common.uitl.exception.APPExCode;
import com.it.common.uitl.uitls.DateAndTimeUtil;
import com.it.common.uitl.uitls.IdGen;
public class BasesController {
	  /*@Autowired
	  private BaseRespons baseRespons;
 	  @Autowired
 	  LogMongodbDao logMongodbDao;
 	  
	  public BaseRespons success(List list,InterfaceLog interfaceLog) {
		      baseRespons.setData(BaseRespons.ok(list));
		      interfaceLog = baseEnd( interfaceLog );
		      logMongodbDao.insert(interfaceLog);
		      return baseRespons;
	   }
	   public BaseRespons success(PageInfo pageInfo,InterfaceLog interfaceLog) {
		      baseRespons.setData(BaseRespons.ok(pageInfo));
		      interfaceLog = baseEnd( interfaceLog ); 
		      logMongodbDao.insert(interfaceLog);
			  return baseRespons;
	   }
	   public BaseRespons success(String str,InterfaceLog interfaceLog) {
		   	  baseRespons.setData((str));
		      interfaceLog = baseEnd( interfaceLog ); 
		      logMongodbDao.insert(interfaceLog);
			  return baseRespons;
	   }
	   public BaseRespons success(Object object,InterfaceLog interfaceLog) {
		     
		     baseRespons.setData(BaseRespons.ok(object));
		     interfaceLog = baseEnd( interfaceLog ); 
		     logMongodbDao.insert(interfaceLog);
		     return baseRespons;
	   }
	   public BaseRespons RRException (String code,String mgs,Exception e,InterfaceLog interfaceLog) {
		   return  BaseRespons.RRException(code, mgs);
	   }
	   public BaseRespons defaultError (Exception e,InterfaceLog interfaceLog) { 
		   e.printStackTrace();
		   interfaceLog.setState(0);
		   interfaceLog = baseEnd( interfaceLog ); 
		   interfaceLog.setMgs(e.getMessage());
		   logMongodbDao.insert(interfaceLog);
		   return  BaseRespons.error(APPExCode.SYS_UNKNOWN_ERROR.getErrorCode(),APPExCode.SYS_UNKNOWN_ERROR.getErrorMsg());
	   }
       public BaseRespons defaultError () {
		   return  BaseRespons.error(APPExCode.SYS_UNKNOWN_ERROR.getErrorCode(),APPExCode.SYS_UNKNOWN_ERROR.getErrorMsg());
	   }
	   public BaseRespons userDefinedError (String code,String mgs,Exception e,InterfaceLog interfaceLog) {
		   e.printStackTrace();
		   interfaceLog = baseEnd( interfaceLog ); 
		   interfaceLog.setMgs(e.getMessage());
		   interfaceLog.setState(0);
		   logMongodbDao.insert(interfaceLog);
		   return  BaseRespons.error(code, mgs);
	   }
	   public BaseRespons userDefinedError (String code,String mgs,InterfaceLog interfaceLog) {
		   interfaceLog.setState(0);
		   interfaceLog = baseEnd( interfaceLog ); 
		   logMongodbDao.insert(interfaceLog);
		   return  BaseRespons.error(code, mgs);
	   }
	   public BaseRespons userDefinedError (String code,String mgs) {

		   return  BaseRespons.error(code, mgs);
	   }
	   public  boolean isEmpty(CharSequence str) { 
		   if (str == null || str.length() == 0) return true;
		   else return false; 
		} 
	   public  InterfaceLog baseStart(
			   String bizCode,
			   String operation,
			   int isAsynchronous,
			   String business,
			   String doc) {

		   InterfaceLog interfaceLog = new InterfaceLog();
		   interfaceLog.setBizCode(bizCode);
		   interfaceLog.setStartTime(System.currentTimeMillis());
		   interfaceLog.setRunTime(DateAndTimeUtil.getRunDateFormat());
		   interfaceLog.setId(IdGen.randomBase62(32));
		   interfaceLog.setOperation(operation);
		   interfaceLog.setState(1);
		   interfaceLog.setIsAsynchronous(isAsynchronous);
		   interfaceLog.setBusiness(business);
		   interfaceLog.setDoc(doc);
		   return interfaceLog;
	   }
	   public  InterfaceLog baseEnd(InterfaceLog interfaceLog ) {
		   interfaceLog.setEndTime(System.currentTimeMillis());
		   interfaceLog.setDuration((interfaceLog.getEndTime()-interfaceLog.getStartTime()));
		   return interfaceLog;
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
*/
}
