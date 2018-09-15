package com.it.common.uitl.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DateTimeUtils extends DateUtils {
	private static final Logger log = LoggerFactory.getLogger(DateUtils.class);
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
	
	private final static Calendar calendar = Calendar.getInstance();
	
	public static final String LENGTH_DATE_FORMAT_PATTERN = "yyyyMMddHHmmss";
	/**
	 * 获得某年的最后一天.默认格式为"yyyy-MM-dd".
	 * @param dateStr 格式为"yyyy-MM-dd"
	 * @param year 据当前年的偏移量，如1,-3
	 * @return
	 */
	public static Date getLastDayOfYear(final String dateStr, final int year) {
		return getLastDayOfYear(dateStr, year, LENGTH_DATE_FORMAT_PATTERN);
	}
	/**
	 * 获得某年的最后一天.使用指定的格式解析时间.
	 * @param dateStr 日期字符串
	 * @param year 据当前年的偏移量，如1,-3
	 * @return
	 */
	public static Date getLastDayOfYear(final String dateStr, final int year, final String pattern) {
		Date date = parseDate(dateStr, pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, (calendar.get(Calendar.YEAR) + year));
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		return calendar.getTime();
	}

	/**
	 * 使用给定的格式解析日期.
	 * @param date 待解析的日期
	 * @param pattern 格式
	 * @return 解析后的日期
	 */
	public static Date parseDate(final String date, final String pattern) {
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(date, new String[]{pattern});
		} catch (ParseException e) {
			log.error("日期解析失败", e);
			return null;			
		}
	}
	
	private DateTimeUtils(){
	}
	
	/**
	 * 日期加法.
	 * 
	 * @param date 初始日期
	 * @param amount 带单位的日期. 后缀d/m/y分别表示日/月/年，例如10m表示10个月
	 * @return
	 */
	public static Date add(Date date, String addend) {
		int amount = Integer.valueOf(addend.substring(0, addend.length() - 1));
		char unit = addend.charAt(addend.length() - 1);
		switch (unit) {
		case 'y':
			return addYears(date, amount);
		case 'm':
			return addMonths(date, amount);
		case 'd':
			return addDays(date, amount);
		}
		throw new IllegalArgumentException("参数格式错误：" + addend);
	}
		
	/**
	 * 获得一个月的最后一天
	 * 时间格式：yyyyMM
	 * @param month
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static String getLastDayByMonth(String month) throws ParseException {
		
		calendar.setTime(SDF.parse(getFirstDayOnMonth(month)));
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = calendar.getTime();
		return SDF.format(lastDay);
	}

	/**
	 * 获得一个月的第一天
	 * 时间格式：yyyyMM
	 * @param month
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static String getFirstDayByMonth(String month) throws ParseException {
		return getFirstDayOnMonth(month);
	}

	
	/**
	 * 获得该月有几天
	 * 时间格式：yyyyMM
	 * @param month
	 * @return
	 * @throws ParseException
	 */
	public static int getDaysByMonth(final String month) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(SDF.parse(getFirstDayOnMonth(month)));
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 使用默认样式（yyyyMMdd）将字符串转换成的日期
	 * @param date 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(SDF.parse(date));
		return calendar.getTime();
	}
	
	public static java.util.Date parse(String dateString,String dateFormat) {
		return parse(dateString, dateFormat,java.util.Date.class);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends java.util.Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) {
		if(StringUtils.isEmpty(dateString)) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			java.util.Date t = targetResultType.getConstructor(long.class).newInstance(time);
			return (T)t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:"+dateFormat+" parse datestring:"+dateString;
			throw new IllegalArgumentException(errorInfo,e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"+targetResultType.getName(),e);
		}
	}
	
	public static String format(java.util.Date date,String dateFormat) {
		 if(date == null) {
			return null;
		}
		 DateFormat df = new SimpleDateFormat(dateFormat);
		 return df.format(date);
	}

	/**
	 * 获得某一天是星期几
	 * 使用自定义的时间格式
	 * @param dateStr 时间字符串
	 * @param pattern 时间样式
	 * @return
	 * @throws Exception
	 */
	public static int getWeekByDay(String dateStr, String pattern) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(dateStr));

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int yearCons = (14 - month) / 12;
		int yearConstant = year - yearCons;
		int monthConstant = month + 12 * yearCons - 2;
		return (day + yearConstant + yearConstant / 4 - yearConstant / 100 
				+ yearConstant / 400 + 31 * monthConstant / 12) % 7;

	}
	
	/**
	 * 获得某一天是星期几
	 * 使用默认的时间格式：yyyyMMdd
	 * @param dateStr 时间字符串
	 * @return
	 * @throws Exception
	 */
	public static int getWeekByDay(String dateStr) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(SDF.parse(dateStr));

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int yearCons = (14 - month) / 12;
		int yearConstant = year - yearCons;
		int monthConstant = month + 12 * yearCons - 2;
		return (day + yearConstant + yearConstant / 4 - yearConstant / 100 
				+ yearConstant / 400 + 31 * monthConstant / 12) % 7;
	}
	
	/**
	 * 获得一个月的第一天
	 * @param month
	 * @return
	 */
	private static String getFirstDayOnMonth(String month) {
		return month + "01";
	}

	
}
