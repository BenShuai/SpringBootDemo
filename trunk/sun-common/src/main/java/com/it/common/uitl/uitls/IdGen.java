/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.it.common.uitl.uitls;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

 
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @version 2016-09-15
 */
@Service
@Lazy(false)
public class IdGen  {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static int randomInt() {
		return Math.abs(random.nextInt(1000000));
	}
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static String randomString(Date dt) {
		String randomString = "";
		Calendar rightNow = Calendar.getInstance();  
	    int year = rightNow.get(Calendar.YEAR); 
	    randomString+=year;
	    
	    int month = rightNow.get(Calendar.MONTH) + 1;
	    if(month<10) {
	    	randomString+="0"+month;
	    }else {
	    	randomString+=month;
	    }
	    int day = rightNow.get(Calendar.DATE) ;
	    if(day<10) {
	    	randomString+="0"+day;
	    }else {
	    	randomString+=day;
	    }
	    int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	    if(hour<10) {
	    	randomString+="0"+hour;
	    }else {
	    	randomString+=hour;
	    }
	    int minute = rightNow.get(Calendar.MINUTE);
	    if(minute<10) {
	    	randomString+="0"+minute;
	    }else {
	    	randomString+=minute;
	    }
	    int second = rightNow.get(Calendar.SECOND);
	    if(minute<10) {
	    	randomString+="0"+second;
	    }else {
	    	randomString+=second;
	    }
	   // randomString+=rightNow.getTimeInMillis();
 
		int randomNum = Math.abs(random.nextInt(100000));
		if(randomNum<10000) {
			randomString+="0"+randomNum;
		}else if(randomNum<1000) {
			randomString+="00"+randomNum;
		}else if(randomNum<100) {
			randomString+="000"+randomNum;
		}else if(randomNum<10) {
			randomString+="0000"+randomNum;
		}else {
			randomString+=""+randomNum;
		}
		return randomString;
	}
	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}

	public static void main(String[] args) {
//		System.out.println(IdGen.uuid());
//		System.out.println(IdGen.uuid().length());
		 
		for (int i=0; i<1000; i++){
			System.out.println(IdGen.randomString(new Date()).length() );
		}
	}

}
