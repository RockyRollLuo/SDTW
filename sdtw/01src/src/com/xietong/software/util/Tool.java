package com.xietong.software.util;

import javax.servlet.http.*;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import com.xietong.software.common.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.regexp.*;

import java.text.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Tool {
	private static Log log = LogFactory.getLog(Tool.class);

	private Tool() {
	}

	/**
	 *检查用户是否登陆
	 */
	public static final boolean checklogin(HttpSession session) {
		// TODO:remove comment at last time
		UserInfo ui = (UserInfo) session.getAttribute("UserInfo");
		if (ui == null) {
			// return false;
		}
		return true;
	}

	public static final boolean checklogin(HttpServletRequest request) {
		// TODO:remove comment at last time
		UserInfo ui = getUserInfo(request);
		if (ui == null) {
			return false;
		}
		return true;
	}

	public static final void checkLogin(HttpServletRequest request,
			javax.servlet.jsp.PageContext pageContext) {
		// TODO:remove comment at last time
		UserInfo ui = getUserInfo(request);
		if (ui == null) {
			try {
				pageContext.forward(HeadConst.root_url_path + "/logon.jsp");
			} catch (Throwable t) {
			}
		}
	}

	public static final boolean checkPower(HttpServletRequest request,
			String cmd) {
		UserInfo ui = getUserInfo(request);
		if (ui == null) {
			return false;
		}
		if (cmd.equals("admin")) {
			if (ui.getPower() > 1)
				return false;
		}
		return true;
	}

	/**
	 *以li分割str字符串，返回字符串数组
	 */
	public static String[] explode(String li, String str) {
		List rtn = new ArrayList();
		if (str != null) {
			String temp = str;
			for (int i = temp.indexOf(li); i > -1; i = temp.indexOf(li)) {
				rtn.add(temp.substring(0, i));
				temp = temp.substring(i + li.length());
			}
			rtn.add(temp);
		}
		return (String[]) rtn.toArray(new String[rtn.size()]);
	}

	/**
	 *以li分割str字符串，返回字符串数组
	 */
	public static String[] split(String li, String str) {
		if ((str == null) || (str.trim().length() == 0))
			str = null;
		return explode(li, str);
	}

	/**
	 *以li分割str字符串，返回字符串数组
	 */
	public static String[] explode_new(String li, String str) {
		StringTokenizer st = new StringTokenizer(str, li);
		int rssize = 0;
		if (str.startsWith(li))
			rssize++;
		if (str.endsWith(li))
			rssize++;
		String[] rs = new String[st.countTokens() + rssize];
		int i = 0;
		if (str.startsWith(li)) {
			rs[i] = "";
			i++;
		}
		while (st.hasMoreTokens()) {
			rs[i] = st.nextToken();
			i++;
		}
		if (str.endsWith(li)) {
			rs[i] = "";
		}
		return rs;
	}

	/**
	 * Joins the elements of the provided array into a single string containing
	 * a list of CSV elements.
	 * 
	 * @param list
	 *            The list of values to join together.
	 * @param separator
	 *            The separator character.
	 * @return The CSV text.
	 */
	public static String join(String separator, String[] list, int fromIndex,
			int toIndex, String quotes, String prefixStr) {
		if (list == null)
			list = new String[0];
		StringBuffer csv = new StringBuffer();
		for (int i = fromIndex; i < list.length && i <= toIndex; i++) {
			if (i > fromIndex) {
				csv.append(separator);
			}
			csv.append(quotes + prefixStr + list[i] + quotes);
		}
		return csv.toString();
	}
	public static String join(String separator, String[] list) {
		return join(separator, list, ""); 
	}
	public static String join(String separator, String[] list, String quotes) {
		return join(separator, list, quotes, ""); 
	}
	public static String join(String separator, String[] list, String quotes, String prefixStr) {
		if (list == null)
			list = new String[0];
		return join(separator, list, 0, list.length - 1, quotes, prefixStr);
	}

	public static String join(String separator, Collection list, int fromIndex,
			int toIndex, String quotes) {
		String[] arr = (String[]) list.toArray(new String[list.size()]);
		return join(separator, arr, fromIndex, toIndex, quotes, "");
	}
	public static String join(String separator, Collection list) {
		return join(separator,list, "");
	}
	public static String join(String separator, Collection list, String quotes) {
		if (list == null)
			list = new ArrayList();
		return join(separator, list, 0, list.size() - 1, quotes);
	}
	public static String join(String separator, Map map) {
		return join(separator, map, false);
	}
	public static String join(String separator, Map map, boolean isKey) {
		return join(separator, map, isKey, "");
	}
	public static String join(String separator, Map map, boolean isKey, String quotes) {
		if (map == null)
			map = new HashMap();
		StringBuffer csv = new StringBuffer();
		int i=0;
		for(Iterator it = map.keySet().iterator(); it.hasNext();){
			String key = (String)it.next();
			if (i > 0) {
				csv.append(separator);
			}
			if(isKey){
				csv.append(quotes + key +quotes);
			}else{
				csv.append(quotes + (String)map.get(key) + quotes);
			}
			i++;
		}
		return csv.toString();
	}

	/**
	 *将str字符串转换成数字
	 */
	public static int StrToInt(String str) {
		int rs = 0;
		if (str != null) {
			try {
				Integer in = new Integer(str);
				rs = in.intValue();
			} catch (NumberFormatException e) {
				rs = 0;
			}
		}
		return rs;
	}
	/**
	 *将str字符串转换成数字
	 */
	public static double StrToDouble(String str) {
		double rs = 0.0;
		if (str != null) {
			if(str.length()>0){
				try {
					String str2 = str;
					if(str.substring(str.length()-1, str.length()).equals("%")){
						str2 = str.substring(0, str.length()-1);
					}
					Double in = new Double(str2);
					rs = in.doubleValue();
					if(str.substring(str.length()-1, str.length()).equals("%")){
						rs = rs / 100;
					}
				} catch (NumberFormatException e) {
					rs = 0;
				}
			}
		}
		return rs;
	}

	/**
	 *格式化日期，如果不是两位，拼‘0’
	 */
	public static String getTwoDate(int rq) {
		String temp = "" + rq;
		if (rq >= 0 && rq < 10)
			temp = "0" + rq;
		return temp;
	}

	/**
	 *计算并返回两个日期之间的天数
	 */
	public static int subDate(java.util.Date d1, java.util.Date d2) {
		// GregorianCalendar gc1= new GregorianCalendar();
		// GregorianCalendar gc2= new GregorianCalendar();
		// gc1.setTime(d1);
		// gc2.setTime(d2);
		// gc1.computFields();
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		long ms = ss / 60;
		long hs = ms / 60;
		long ds = hs / 24;
		return (int) ds;
	}
	
	/**
	 * 计算返回两个日期之间的月份
	 * d1,d2 的值如  "2010-05","2010-03"  d1为结束时间  d2为开始时间
	 * @return
	 */
	public static int subMonthDate(String d1, String d2) {
		
		String[] strArr1 = Tool.split("-", d1);
		int year1 = Integer.parseInt(strArr1[0]);
		int mon1 = Integer.parseInt(strArr1[1]);
		Date dd1 = new Date(year1-1900,mon1,1);
		
		String[] strArr2 = Tool.split("-", d2);
		int year2 = Integer.parseInt(strArr2[0]);
		int mon2 = Integer.parseInt(strArr2[1]);
		Date dd2 = new Date(year2-1900,mon2,1);
		int y=dd1.getYear()-dd2.getYear();//年差
		int m=dd1.getMonth()-dd2.getMonth();//月差
		int num= y*12+m;
		return num;
	}
	
	// 从服务器上取得当前日期
	// 格式：2002年04月25日 星期四
	public static String getFullDateString() {
		return getFullDateString(new java.util.Date());
	}

	public static String getFullDateString(java.util.Date d) {
		String[] week = split(",", "日,一,二,三,四,五,六");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		return gc.get(Calendar.YEAR) + "年" + (gc.get(Calendar.MONTH) + 1) + "月"
				+ gc.get(Calendar.DAY_OF_MONTH) + "日 星期"
				+ week[gc.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY];
	}

	// 获得本年度第一天的日期
	public static String getFristDayOfYear(java.util.Date date) {
		String outStr = "";
		String[] strdate = Tool.stringOfDate(date).split("-");
		outStr = strdate[0] + "-01-01";
		return outStr;
	}

	// 获得本季度第一天的日期
	public static String getFristDayOfQuarter(java.util.Date date) {
		String outStr = "";
		String[] strdate = Tool.stringOfDate(date).split("-");
		//System.out.println("Tool getQuarter strdate.length=" + strdate.length);
		//System.out.println("Tool getQuarter strdate[1]=" + strdate[1]);
		int yue = Integer.parseInt(strdate[1]);
		if (yue <= 3)
			outStr = strdate[0] + "-01-01";
		else if (yue <= 6)
			outStr = strdate[0] + "-04-01";
		else if (yue <= 9)
			outStr = strdate[0] + "-07-01";
		else if (yue <= 12)
			outStr = strdate[0] + "-10-01";
		//System.out.println("Tool getQuarter outStr=" + outStr);
		return outStr;
	}

	// 获得本月度第一天的日期
	public static String getFristDayOfMonth(java.util.Date date) {
		String outStr = "";
		String[] strdate = Tool.stringOfDate(date).split("-");
		outStr = strdate[0] + "-" + strdate[1] + "-01";
		return outStr;
	}
	// 获得本月度 最后一天的日期
	public static String getLastDayOfMonth(java.util.Date date) {
		String outStr = "";
		String[] strdate = Tool.stringOfDate(date).split("-");
		if((yearOfDate(date)%4==0&&yearOfDate(date)%100!=0) || yearOfDate(date)%400==0){
			if(monthOfDate(date)==2){
				outStr = strdate[0] + "-" + strdate[1] + "-29";
			}
		}else if(monthOfDate(date)==2){
				outStr = strdate[0] + "-" + strdate[1] + "-28";
		}
			
	  if(monthOfDate(date)==4 || monthOfDate(date)==6 || monthOfDate(date)==9 || monthOfDate(date)==11){
			outStr = strdate[0] + "-" + strdate[1] + "-30";
		}
	  if(monthOfDate(date)==1 || monthOfDate(date)==3 || monthOfDate(date)==5 || monthOfDate(date)==7 || monthOfDate(date)==8 || monthOfDate(date)==10 || monthOfDate(date)==12){
			outStr = strdate[0] + "-" + strdate[1] + "-31";
		}
		return outStr;
	}
	// 获得本月度 最后一天的日
	public static int getLastDayofDate(java.util.Date date) {
		int outStr = 30;
		String[] strdate = Tool.stringOfDate(date).split("-");
		if((yearOfDate(date)%4==0&&yearOfDate(date)%100!=0) || yearOfDate(date)%400==0){
			if(monthOfDate(date)==2){
				outStr = 29;
			}
		}else if(monthOfDate(date)==2){
				outStr = 28;
		}
			
	  if(monthOfDate(date)==4 || monthOfDate(date)==6 || monthOfDate(date)==9 || monthOfDate(date)==11){
			outStr = 30;
		}
	  if(monthOfDate(date)==1 || monthOfDate(date)==3 || monthOfDate(date)==5 || monthOfDate(date)==7 || monthOfDate(date)==8 || monthOfDate(date)==10 || monthOfDate(date)==12){
			outStr = 31;
		}
		return outStr;
	}
	public static int getLastDayOfYearMonth(int year, int month){
		java.util.Date date = stringToDate(year + "-" + monthStrOfMonth(month) + "-01");
		return getLastDayofDate(date);
	}
	
	// 获得周一的日期
	public static Date getMondayOfWeek(java.util.Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return c.getTime();
	}

	// 获得周日的日期
	public static Date getSundayOfWeek(java.util.Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return addDateByDay(c.getTime(), 7);
	}

	// 获得年度的第几周
	public static int getWeekOfYear(java.util.Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.WEEK_OF_YEAR);
	}

	// 获得该月份的周信息。
	public static List getWeet(Date date) {
		List rtn = new ArrayList();

		// 周一日期
		Date WeekFrist = stringToDate(getFristDayOfMonth(date));

		// 周日日期
		Date WeekEnd = WeekFrist;

		for (; monthOfDate(WeekFrist) == monthOfDate(WeekEnd);) {
			WeekFrist = getMondayOfWeek(WeekFrist);
			WeekEnd = getSundayOfWeek(WeekFrist);
			rtn.add(stringOfDate(WeekFrist) + "~" + stringOfDate(WeekEnd));
			WeekFrist = addDateByDay(WeekEnd, 1);
		}
		return rtn;
	}

	public static String stringOfTime() {
		return stringOfTime(new java.util.Date());
	}

	public static String stringOfTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}

	// 将日期字符串转换为日期变量,如果有问题,返回当前日期
	public static java.util.Date stringToDateTime(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}

	public static java.util.Date stringToDate(String str) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (java.util.Date) formatter.parse(str);
		} catch (ParseException e) {
			return new java.util.Date();
		}
	}

	/**
	 *当前日期字符串
	 */
	public static String stringOfDateTime() {
		return stringOfDateTime(new java.util.Date());
	}
	public static String stringOfDateHMS(java.util.Date date) {
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(date);
	}
	public static String stringOfDateTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}
	public static String stringOfDateMonth(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}
	public static String stringOfDateHour(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:00");
		return formatter.format(date);
	}
	public static String stringOfDateMinute(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formatter.format(date);
	}

	// 无间隔
	public static String stringOfDateTime1(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}
	public static String stringOfDate1(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	/**
	 *当前日期字符串
	 */
	public static String stringOfCnDateTime() {
		return stringOfCnDateTime(new java.util.Date());
	}

	public static String stringOfCnDateTime(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy年M月d日 H时m分s秒");
		return formatter.format(date);
	}

	/**
	 *当前日期字符串
	 */
	public static String stringOfCnDate() {
		return stringOfCnDate(new java.util.Date());
	}

	public static String stringOfCnDate(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy年M月d日");
		return formatter.format(date);
	}

	/**
	 *当前日期字符串
	 */
	public static String stringOfDate() {
		return stringOfDate(new java.util.Date());
	}

	public static String stringOfDate(java.util.Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static String stringOfDate2(java.util.Date date) {
		Format formatter = new SimpleDateFormat("MM-dd");
		return formatter.format(date);
	}

	/**
	 *计算并返回日期中的星期几
	 */
	public static int weekOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 *计算并返回日期中的日
	 */
	public static int dayOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_MONTH);
	}
	public static String dayStrOfDay(int day){
		if(day<10){
			return "0" + day;
		}else{
			return "" + day;
		}
	}

	/**
	 *计算并返回日期中的月
	 */
	public static int monthOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MONTH) + 1;
	}
	/**
	 *计算并返回日期中的月
	 */
	public static String monthOfDateString(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		int month = gc.get(Calendar.MONTH) + 1;
		if(month<10)
			return "0"+month;
		return month+"";
	}
	public static String monthStrOfMonth(int month){
		if(month<10)
			return "0"+month;
		return month+"";
	}
	/**
	 * 根据月份获得季度
	 * @param aMonth
	 * @return
	 */
	public static int getQuarterInt(int aMonth){
		int aQuarterNum =1;
		if(aMonth>3 && aMonth<7) aQuarterNum = 2;
		else if(aMonth>6 && aMonth<10) aQuarterNum = 3;
		else if(aMonth>9 && aMonth<13) aQuarterNum = 4;
		return aQuarterNum;
	}

	/**
	 *计算并返回日期中的年
	 */
	public static int yearOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.YEAR);
	}
	public static int yearOfDate() {
		return yearOfDate(new java.util.Date());
	}

	/**
	 * 计算并返回日期中的年、月
	 */
	public static String ymOfDate(java.util.Date d1) {
		String ym = "";
		int year = yearOfDate(d1);
		int month = monthOfDate(d1);
		if(month<10){
			ym=year+"-"+0+month;
		}else{
			ym=year+"-"+month;
		}
		return ym;
	}
	public static int yearMonthOfDate(java.util.Date d1){
		int ym = 0;
		int year = yearOfDate(d1);
		int month = monthOfDate(d1);
		ym = year*100 + month;
		return ym;
	}
	
	/**
	 *计算并返回日期中的时
	 */
	public static int hourOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 *计算并返回日期中的分
	 */
	public static int minuteOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MINUTE);
	}

	/**
	 *计算并返回日期中的秒
	 */
	public static int secondOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.SECOND);
	}

	/**计算数年后的日期
	 * @param d
	 * @param year
	 * @return
	 */
	public static java.util.Date addDateByYear(java.util.Date d, int year) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.YEAR, year);
		//gc.add(Calendar.DATE, -1);
		return new java.util.Date(gc.getTime().getTime());
	}
	
	/**
	 *计算数月后的日期
	 */
	public static java.util.Date addDateByMonth(java.util.Date d, int mcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.MONTH, mcount);
		//gc.add(Calendar.DATE, -1);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 *计算数日后的日期
	 */
	public static java.util.Date addDateByDay(java.util.Date d, int dcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.DATE, dcount);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 *计算数秒后的日期
	 */
	public static java.util.Date addDateBySecond(java.util.Date d, int scount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.SECOND, scount);
		return gc.getTime();
	}
	
	/**
	 * 计算返回String型 的年月的上一个月
	 */
	public static String addymByMonth(String d1,int mm) {
		String ym="";
		String[] strArr = Tool.split("-", d1);
		int year = Integer.parseInt(strArr[0]);
		int mon = Integer.parseInt(strArr[1]);
		java.util.Date d = new java.util.Date(year-1900,mon,1);
		d.setMonth(d.getMonth()+mm-1);
		ym = ymOfDate(d);
		return ym;
	}

	/**
	 *  20040224 输入的字符转换为时间类型
	 */
	public static java.sql.Date isTime(String shijian) {
		java.sql.Date time = null;
		try {
			time = java.sql.Date.valueOf(shijian);
			return time;
		} catch (IllegalArgumentException myException) {
			return time;
		}
	}
	/**
	 *  准备当前年度获取截止至目标年度的下来列表
	 */
	public static List<String> getYearSelect(Date date,int Target){
		List<String> select=new ArrayList<String>();
		int nowyear=yearOfDate(date);
		for(int i=Target;i<=nowyear;i++){
			select.add(""+i);
		}
		return select;
	}
	/**
	 *  20040306 输入的字符为yyyy-MM-dd HH:mm:ss类型 转换为：java.util.Date
	 */

	public static java.util.Date isDateTime(String datestr) {
		// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// return formatter.format(date);
		java.util.Date rdatetime = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			// DateFormat formatter = new DateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			rdatetime = formatter.parse(datestr, pos);
			return rdatetime;
		} catch (IllegalArgumentException myException) {
			return rdatetime;
		}
	}

	/**
	 *将double类型的数值保留小数点后两位输出
	 */
	public static double round(double d) {
		DecimalFormat nf = new DecimalFormat("0.00");
		return Double.parseDouble(nf.format(d));
	}

	/*
	 * 将double四舍五入
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 *从Session中取出UserInfo
	 */
	public static UserInfo getUserInfo(HttpServletRequest request) {
		UserInfo ui = (UserInfo) request.getAttribute("Global_UserInfo");
		if (ui == null) {
			if (HeadConst.UserInfoInSession) {
				HttpSession session = request.getSession();
				UserInfo sui = (UserInfo) session.getAttribute("UserInfo");
				if (sui == null) {
					sui = UserInfo.getInstance(request);
					if (sui == null) {
						return null;
					}
					session.setAttribute("UserInfo", sui);
				}
				ui = sui.cloneMe();
			} else {
				ui = UserInfo.getInstance(request);
			}
			request.setAttribute("Global_UserInfo", ui);
		}
		return ui;
	}

	/*
	 * public static ClientInfo getClientInfo(HttpServletRequest request){
	 * ClientInfo ui = (ClientInfo)request.getAttribute("Global_ClientInfo"); if
	 * (ui == null) { if (HeadConst.UserInfoInSession) { HttpSession session =
	 * request.getSession(); ClientInfo sui =
	 * (ClientInfo)session.getAttribute("ClientInfo"); if (sui == null) { sui =
	 * ClientInfo.getInstance(request); if (sui == null) { return null; }
	 * session.setAttribute("ClientInfo", sui); } ui = sui.cloneMe(); } else {
	 * ui = ClientInfo.getInstance(request); }
	 * request.setAttribute("Global_ClientInfo", ui); } return ui; }
	 */

	public static java.util.Date getDate() {
		return new java.util.Date();
	}

	public static String[] getYearList(int startY, int len) {
		String[] list = new String[len];
		for (int i = startY; i < len + startY; i++)
			list[i - startY] = "" + (i + 1);
		return list;
	}

	public static String[] getMonDayList(int len) {
		String[] list = new String[len];
		for (int i = 0; i < len; i++) {
			if (i < 9)
				list[i] = "0" + (1 + i);
			else
				list[i] = "" + (1 + i);
		}
		return list;
	}

	public static String getDigest(String str) {
		try {
			// java.security.MessageDigest
			// alg=java.security.MessageDigest.getInstance("MD5");
			java.security.MessageDigest alga = java.security.MessageDigest
					.getInstance("SHA-1");
			alga.update(str.getBytes());
			byte[] digesta = alga.digest();
			return Base64.encodeBytes(digesta);
		} catch (java.security.NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String encrypt(String str) {
		try {
			byte[] keyBytes = "BLNKSOFT".getBytes();
			SecretKey key = new SecretKeySpec(keyBytes, "DES");

			// Create encrypter/decrypter class
			DesEncrypter encrypter = new DesEncrypter(key);

			// Encrypt
			return encrypter.encrypt(str);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return null;
	}

	public static String decrypt(String str) {
		try {
			byte[] keyBytes = "BLNKSOFT".getBytes();
			SecretKey key = new SecretKeySpec(keyBytes, "DES");

			// Create encrypter/decrypter class
			DesEncrypter encrypter = new DesEncrypter(key);

			// Decrypt
			return encrypter.decrypt(str);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return null;
	}

	public static boolean inArray(String str, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	public static String jsSpecialChars(String sDraft) {
		if (sDraft == null)
			return sDraft;
		StringBuffer sOutput = new StringBuffer(sDraft);
		for (int nCharPtr = 0; nCharPtr < sOutput.length();) {
			if (sOutput.charAt(nCharPtr) == '\r') {
				sOutput.replace(nCharPtr, nCharPtr + 1, "\\r");
				nCharPtr += 2;
			} else if (sOutput.charAt(nCharPtr) == '"') {
				sOutput.replace(nCharPtr, nCharPtr + 1, "\\\"");
				nCharPtr += 2;
			} else if (sOutput.charAt(nCharPtr) == '\n') {
				sOutput.replace(nCharPtr, nCharPtr + 1, "\\n");
				nCharPtr += 2;
			} else if (sOutput.charAt(nCharPtr) == '\\') {
				sOutput.replace(nCharPtr, nCharPtr + 1, "\\\\");
				nCharPtr += 2;
			} else if (sOutput.charAt(nCharPtr) == '\'') {
				if (sDraft.indexOf("http") < 0) {
					sOutput.replace(nCharPtr, nCharPtr + 1, "\\\'");
					nCharPtr += 2;
				} else {
					sOutput.replace(nCharPtr, nCharPtr + 1, "&#39;");
					nCharPtr += 4;
				}

			} else {
				nCharPtr++;
			}
		}

		return sOutput.toString();
	}

	public static String getFullDateTimeString(String dateStr) {
		String patternStr = "([0-9]{1,4})([-/]([0-9]{2})([-/]([0-9]{2})( ([0-9]{2})(:([0-9]{2})(:([0-9]{2}))*)*)*)*)*";
		List l = new ArrayList();

		RE pattern = null;
		try {
			pattern = new RE(patternStr);
		

		if (dateStr != null && pattern.match(dateStr)) {
			for (int i = 0; i < 12; i++) {
				String s = pattern.getParen(i);
				if (s == null)
					break;
				if (i % 2 == 1)
					l.add(s);
			}
		}
		} catch (RESyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] tmpDate = { "1970", "01", "01", "00", "00", "00" };
		for (int i = l.size(); i < tmpDate.length; i++) {
			l.add(tmpDate[i]);
		}
		return (String) l.get(0) + "-" + (String) l.get(1) + "-"
				+ (String) l.get(2) + " " + (String) l.get(3) + ":"
				+ (String) l.get(4) + ":" + (String) l.get(5);
	}
	/**
	 * 返回指定长度的字符串
	 * @param str 原字符串
	 * @param len  截取长度
	 * @param elide 省略符
	 * @return
	 */
	public static String truncate(String str, int len, String elide) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		int elideLen = (elide.trim().length() == 0) ? 0: elide.getBytes().length;
		if (len >= strLen || len < 1) {
			return str;
		}
		if (len - elideLen > 0) {
			len = len - elideLen;
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;
		}
		return new String(strByte, 0, len) + elide.trim();
	}
	public static boolean hasDigit(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(str);
		if (m.matches())
		flag = true;
		return flag;
		} 
	public static boolean hasLetter(String str) {
		boolean flag = false;
		for(int i=0 ; i<str.length() ; i++){ //循环遍历字符串   
            if(Character.isLetter(str.charAt(i))){   //用char包装类中的判断字母的方法判断每一个字符
            	flag = true;
            }
		}
		return flag;
		}
	/**
	 * 去掉用逗号隔开的字符串头部和尾部的逗号去掉
	 * @param str
	 * @return
	 */
	public static String removeHeadAndTail(String str){
		if(str.length()>0){
			str=str.replace("，", ",");
			if(str.startsWith(",")){
				str=str.substring(1,str.length());
			}
			if(str.endsWith(",")){
				str=str.substring(0,str.length()-1);
			}
		}
		return str;
	}
}
