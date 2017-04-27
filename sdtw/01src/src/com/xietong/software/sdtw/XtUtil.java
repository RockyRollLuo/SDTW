package com.xietong.software.sdtw;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import jxl.Cell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import org.apache.commons.lang.ArrayUtils;

import com.xietong.software.common.DaoBase;
import com.xietong.software.system.DbConnectionManager;
import com.xietong.software.util.ExpiringCache;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.Tool;

public class XtUtil {
	
	private static ExpiringCache cache = new ExpiringCache(2 * 60 * 1000, 60 * 1000, 60 * 1000, 60 * 1000);

	
	public static void setOpLog(Object object,String log){
		try {
			Method method = object.getClass().getMethod("setOpLog", new Class[]{String.class});
			Method getMethod = object.getClass().getMethod("getOpLog", null);
			String logs = (String)getMethod.invoke(object, null);
			String tmp = logs;
			tmp = tmp.concat(log);
			if(tmp.length()>500){
				logs = logs.substring(tmp.length()-500+1);
			}
			log = log.concat(logs);
			method.invoke(object, new Object[]{log});
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setOAOpLog(Object object,String log){
		try {
			Method method = object.getClass().getMethod("setOperLog", new Class[]{String.class});
			Method getMethod = object.getClass().getMethod("getOperLog", null);
			String logs = (String)getMethod.invoke(object, null);
			String tmp = logs;
			tmp = tmp.concat(log);
			if(tmp.length()>500){
				logs = logs.substring(tmp.length()-500+1);
			}
			log = log.concat(logs);
			method.invoke(object, new Object[]{log});
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setCzrz(Object object,String log){
		try {
			Method method = object.getClass().getMethod("setCzrz", new Class[]{String.class});
			Method getMethod = object.getClass().getMethod("getCzrz", null);
			String logs = (String)getMethod.invoke(object, null);
			String tmp = logs;
			tmp = tmp.concat(log);
			if(tmp.length()>500){
				logs = logs.substring(tmp.length()-500+1);
			}
			log = log.concat(logs);
			method.invoke(object, new Object[]{log});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static List getYearOption(int endYear){
		int now = Tool.yearOfDate(new Date());
		List list = new ArrayList();
		for(int i=now;i>=endYear;i--){
			OptionBean optionBean = new OptionBean(""+i + "-" + (i+1), i+"");
			list.add(optionBean);
		}
		return list;
	}
	
	public static List getYearOption(int endYear,boolean showEmpty){
		int now = Tool.yearOfDate(new Date());
		List list = new ArrayList();
		if(showEmpty){
			list.add(new OptionBean("", "-1"));
		}
		for(int i=now;i>=endYear;i--){
			OptionBean optionBean = new OptionBean(""+i + "-" + (i+1) , i+"");
			list.add(optionBean);
		}
		return list;
	}
	
	/**调用方法后程序中的map需要清空
	 * @param endYear
	 * @return
	 */
	public static Map getYearMap(int endYear){
		int now = Tool.yearOfDate(new Date());
		Map map = new HashMap();
		for(int i=now;i>=endYear;i--){
			map.put(i + "", ""+i + "-" + (i+1) );
		}
		return map;
	}
	
	/**获得
	 * @return
	 */
	public static Map getYearMap(){
		int endYear = 2010;
		int now = Tool.yearOfDate(new Date());
		Map map = (Map) cache.recover("Jspj_year");
		if (map == null) {
			map = new HashMap();
			for(int i=now;i>=endYear;i--){
				map.put(i + "", ""+i + "-" + (i+1) );
			}			
			cache.admit("Jspj_year", map);
		}
		return map;
	}
	
	public static Map getMapListByCdt(List cdt, String col, Class cls) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase) obj).query(cdt);

			for (int i = 0; i < list.size(); i++) {
				Method method = list.get(i).getClass()
						.getMethod("get" + col, null);
				List tmp = (List)re.get(method.invoke(list.get(i), null) + "");
				if(tmp == null){
					tmp = new ArrayList();
					re.put(method.invoke(list.get(i), null) + "", tmp);
				}
				tmp.add(list.get(i));
			}
			list.clear();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static Map getMapListByCdt(List cdt, String[] cols, Class cls) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase) obj).query(cdt);

			for (int i = 0; i < list.size(); i++) {
				String key = "";
				for (int j = 0; j < cols.length; j++) {
					key = key
							+ list.get(i).getClass()
									.getMethod("get" + cols[j], null)
									.invoke(list.get(i), null);
					if (j < cols.length - 1)
						key += "_";
				}
				List tmp = (List)re.get(key);
				if(tmp == null){
					tmp = new ArrayList();
					re.put(key, tmp);
				}
				tmp.add(list.get(i));
			}
			list.clear();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	/**根据cdt串获得指定列值得序列 以逗号分割
	 * @param cdt
	 * @param col
	 * @param cls
	 * @return
	 */
	public static String getColValusByCdt(List cdt,String col,Class cls){
		String re = "";
		StringBuffer sb = new StringBuffer();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				sb.append(method.invoke(list.get(i), null)+",");
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		re = sb.toString();
		if(re.lastIndexOf(",")>-1){
			re = re.substring(0,re.lastIndexOf(","));
		}
		return re;
	}
	
	/**
	 * 从查询结果list中获得列值的字串
	 * author: dyh
	 * @param list
	 * @param col
	 * @param cls
	 * @return
	 */
	public static String getColValusByList(List list,String col,Class cls){
		String re = "";
		StringBuffer sb = new StringBuffer();
		try {
			Object obj = cls.newInstance();
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				sb.append(method.invoke(list.get(i), null)+",");
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		re = sb.toString();
		if(re.lastIndexOf(",")>-1){
			re = re.substring(0,re.lastIndexOf(","));
		}
		return re;
	}
	
	/**根据cdt串获得指定列值得序列 以逗号分割
	 * @param cdt
	 * @param col
	 * @param cls
	 * @return
	 */
	public static String getColValusByIds(List cdt,String col,Class cls,String tableName){
		String re = "";
		StringBuffer sb = new StringBuffer();
		try {
			Object obj = cls.newInstance();
			if(!tableName.equals("")){
				((DaoBase)obj).setTableName(tableName);
			}
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				sb.append(method.invoke(list.get(i), null)+",");
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		re = sb.toString();
		if(re.lastIndexOf(",")>-1){
			re = re.substring(0,re.lastIndexOf(","));
		}
		return re;
	}
	
	/**根据ids串获得指定列值得序列 以逗号分割
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getColValuMapByIds(String ids,String col,Class cls){
		List cdt = new ArrayList();
		Map re = new HashMap();
		if(ids.equals(""))
			return re;
		try {
			Object obj = cls.newInstance();
			if(ids!=null&&!ids.equals(""))
			cdt.add("id in("+ids+")");
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				Method idMethod = list.get(i).getClass().getMethod("getId", null);
				re.put(idMethod.invoke(list.get(i), null)+"", method.invoke(list.get(i), null));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	/**根据ids串获得指定列值得序列 以逗号分割
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getColValuMapByCdt(List cdt,String col,Class cls){
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				Method idMethod = list.get(i).getClass().getMethod("getId", null);
				re.put(idMethod.invoke(list.get(i), null)+"", method.invoke(list.get(i), null));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static Map getColValuMapByCdt(List cdt, String col,
			String colIndex, Class cls) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase)obj).query(cdt);
			for (int i = 0; i < list.size(); i++) {
				Method method = list.get(i).getClass()
						.getMethod("get" + col, null);
				Method idMethod = list.get(i).getClass()
						.getMethod("get" + colIndex, null);
				re.put(idMethod.invoke(list.get(i), null) + "",
						method.invoke(list.get(i), null) + "");
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	

	public static Map getColValuMapByList(List list,String col,Class cls){
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				Method idMethod = list.get(i).getClass().getMethod("getId", null);
				re.put(idMethod.invoke(list.get(i), null)+"", method.invoke(list.get(i), null));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	
	/**根据cdt获得对象的map集合
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getBeanMapByCdt(List cdt,Class cls,String tableName){
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			if(!tableName.equals("")){
				((DaoBase)obj).setTableName(tableName);
			}
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method idMethod = list.get(i).getClass().getMethod("getId", null);
				re.put(idMethod.invoke(list.get(i), null)+"",list.get(i));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	/**
	 * 根据cdt获得对象的map集合
	 * 
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getBeanMapByCdt(List cdt,String col, Class cls, String tableName) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			if (!tableName.equals("")) {
				((DaoBase) obj).setTableName(tableName);
			}
			List list = ((DaoBase) obj).query(cdt);

			for (int i = 0; i < list.size(); i++) {
				Method method = list.get(i).getClass()
						.getMethod("get" + col, null);
				re.put(method.invoke(list.get(i), null) + "",list.get(i));
			}
			list.clear();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static Map getBeanMapByCdt(List cdt,String[] cols, Class cls) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase) obj).query(cdt);

			for (int i = 0; i < list.size(); i++) {
				String key = "";
				for (int j = 0; j < cols.length; j++) {
					key = key
							+ list.get(i).getClass()
									.getMethod("get" + cols[j], null)
									.invoke(list.get(i), null);
					if (j < cols.length - 1)
						key += "_";
				}
				re.put(key,list.get(i));
			}
			list.clear();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	/**根据cdt获得对象的map集合
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getBeanMapByCdt(List cdt,Class cls){
		return getBeanMapByCdt(cdt, cls, "");
	}
	
	/**根据指定的列获得类对象的map
	 * @param cdt
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getBeanMapByCdt(List cdt,String col,Class cls){
		return getBeanMapByCdt(cdt, col, cls,"");
	}
	
	/**根据ids串获得指定列值得序列 以逗号分割
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getColValuMapByIds(String ids,String col,Class cls,String tableName){
		List cdt = new ArrayList();
		Map re = new HashMap();
		if(ids.equals(""))
			return re;
		try {
			Object obj = cls.newInstance();
			if(!tableName.equals("")){
				((DaoBase)obj).setTableName(tableName);
			}
			if(ids!=null&&!ids.equals(""))
			cdt.add("id in("+ids+")");
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				Method idMethod = list.get(i).getClass().getMethod("getId", null);
				re.put(idMethod.invoke(list.get(i), null)+"", method.invoke(list.get(i), null));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	
	/**根据ids串获得指定列值得序列 以逗号分割
	 * @param ids
	 * @param col
	 * @param cls
	 * @return
	 */
	public static Map getColValuMapByIds(String ids,String col,String colIndex,Class cls,String tableName){
		List cdt = new ArrayList();
		Map re = new HashMap();
		if(ids.equals(""))
			return re;
		try {
			Object obj = cls.newInstance();
			if(!tableName.equals("")){
				((DaoBase)obj).setTableName(tableName);
			}
			if(ids!=null&&!ids.equals(""))
			cdt.add(colIndex+" in("+ids+")");
			List list = ((DaoBase)obj).query(cdt);
			
			for(int i=0;i<list.size();i++){
				Method method = list.get(i).getClass().getMethod("get"+col, null);
				Method idMethod = list.get(i).getClass().getMethod("get"+colIndex, null);
				re.put(idMethod.invoke(list.get(i), null)+"", method.invoke(list.get(i), null));
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static Map getColValuMapByCdt(List cdt, String col,String[] colIndex, Class cls) {
		Map re = new HashMap();
		try {
			Object obj = cls.newInstance();
			List list = ((DaoBase) obj).query(cdt);

			for (int i = 0; i < list.size(); i++) {
				Method method = list.get(i).getClass()
						.getMethod("get" + col, null);
				String key = "";
				for (int j = 0; j < colIndex.length; j++) {
					key = key
							+ list.get(i).getClass()
									.getMethod("get" + colIndex[j], null)
									.invoke(list.get(i), null);
					if (j < colIndex.length - 1)
						key += "_";
				}
				re.put(key, method.invoke(list.get(i), null) + "");
			}
			list.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static String dealIdx(String ids){
		if(ids.lastIndexOf(",")>-1&&ids.lastIndexOf(",")==ids.length()-1){
			ids = ids.substring(0,ids.lastIndexOf(","));
		}
		if(ids.indexOf(",")==0)
			ids = ids.substring(1);
		return ids;
	}
	
	/**
	 * 去除开始结束逗号
	 * @param str
	 * @return
	 * @author dyh
	 * @date 2014-3-28
	 */
	public static String cutHEComma(String str){
		if(str.startsWith(","))
			str = str.substring(1);
		if(str.endsWith(","))
			str = str.substring(0,str.length()-1);
		return str;
	}
	
	 /*
     * 生成一行数据的json格式数据
     */
    public static String getJsonFromRow(List row,String[] DicKeys){
        StringBuffer re = new StringBuffer("{");
        for(int i=0;i<row.size();i++){
            re.append("\""+DicKeys[i]+"\":\""+(row.get(i)==null?"":row.get(i))+"\",");
        }
        String tmp = dealIdx(re.toString());
        return tmp+"}";
    }
	
    public static String getColumnHeader(String[] discol,String[][] disval,String[] field){
        StringBuffer re = new StringBuffer();
        re.append("{");
        re.append("field:'Id',checkbox:true,width:23");
        re.append("},");
        for(int i=0;i<discol.length;i++){
            re.append("{");
            re.append("title:'"+disval[ArrayUtils.indexOf(field, discol[i])][1]+"',field:'"+discol[i]+"',width:fixWidth("+1.0/discol.length+",180)");
            re.append("}");
            if(i<discol.length-1)
                re.append(",\n");
        }
        return re.toString();
    }
    
    public static String getColumnHeader(String[] discol,String[][] disval,String[] field,int[] width){
        StringBuffer re = new StringBuffer();
        re.append("{");
        re.append("field:'Id',checkbox:true,width:23");
        re.append("},");
        for(int i=0;i<discol.length;i++){
            re.append("{");
            re.append("title:'"+disval[ArrayUtils.indexOf(field, discol[i])][1]+"',field:'"+discol[i]+"',width:"+width[i]);
            re.append("}");
            if(i<discol.length-1)
                re.append(",\n");
        }
        return re.toString();
    }
    
    /**
     * @param discol
     * @param disval
     * @param field
     * @param width 所有宽度和 不超过1
     * @return
     */
    public static String getColumnHeader(String[] discol,String[][] disval,String[] field,double[] widths){
        StringBuffer re = new StringBuffer();
        re.append("{");
        re.append("field:'Id',checkbox:true,width:23");
        re.append("},");
        for(int i=0;i<discol.length;i++){
            re.append("{");
            re.append("title:'"+disval[ArrayUtils.indexOf(field, discol[i])][1]+"',field:'"+discol[i]+"',width:fixWidth("+widths[i]+",180)");
            re.append("}");
            if(i<discol.length-1)
                re.append(",\n");
        }
        return re.toString();
    }
    
    /**
     * @param discol
     * @param disval
     * @param field
     * @param widths
     * @return
     */
    public static String getColumnHeader(String[] discol,String[][] disval,String[] field,String widths){
        StringBuffer re = new StringBuffer();
        re.append("{");
        re.append("field:'Id',checkbox:true,width:23");
        re.append("},");
        JSONObject jsonObject = JSONObject.fromObject(widths);
        int specialCol = jsonObject.size();
        double amount = 180;
        for(Iterator it = jsonObject.keySet().iterator(); it.hasNext();){
        	String key = (String)it.next();
        	amount += jsonObject.getDouble(key);
        }
        for(int i=0;i<discol.length;i++){
            re.append("{");
            re.append("title:'"+disval[ArrayUtils.indexOf(field, discol[i])][1]+"',field:'"+discol[i]);
            if(jsonObject.get(i+"")!=null){
            	re.append("',width:"+jsonObject.getDouble(i+""));
            }else{
            	re.append("',width:fixWidth("+1.0/(discol.length-specialCol)+","+amount+")");
            }
            re.append("}");
            if(i<discol.length-1)
                re.append(",\n");
        }
        return re.toString();
    }
    
    /**
     * @param discol
     * @param disval
     * @param field
     * @param width 所有宽度和 不超过1
     * @return
     */
    public static String getColumnHeader(String[] discol,String[][] disval,String[] field,double[] width,double screenSize){
        StringBuffer re = new StringBuffer();
        re.append("{");
        re.append("field:'Id',checkbox:true,width:23");
        re.append("},");
        for(int i=0;i<discol.length;i++){
            re.append("{");
            re.append("title:'"+disval[ArrayUtils.indexOf(field, discol[i])][1]+"',field:'"+discol[i]+"',width:"+width[i]*screenSize);
            re.append("}");
            if(i<discol.length-1)
                re.append(",\n");
        }
        return re.toString();
    }

    public static String getIdsStr(String ids){
    	if(ids.length()==0)
    		return "-1";
    	if(ids.indexOf(",")==0)
    		ids = ids.substring(1);
    	if(ids.lastIndexOf(",")==ids.length()-1){
    		ids = ids.substring(0,ids.length()-1);
    	}
    	ids = ids.replaceAll(",", "','");
    	return "'"+ids+"'";
    }
    
	/**获得汉语的首字母
	 * @param chines
	 * @return
	 */
	public static String getFirstSpell(String chines){
		String pinyinName = "";   
        char[] nameChar = chines.toCharArray();   
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);   
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
        if (nameChar.length>0) {   
            if (nameChar[0] > 128) {   
                try {   
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[0], defaultFormat)[0].charAt(0);   
                } catch (Exception e) {   
                    e.printStackTrace();   
                }
            }else{   
                pinyinName += nameChar[0];
            }   
        }   
        return pinyinName;  
	}
    
    public static String getSpell(String chines){
		
		String pinyinName = "";
		String tmp = chines;
		for(int i=0;i<tmp.length();i++){
			chines = tmp.substring(i,i+1);
	        char[] nameChar = chines.toCharArray();   
	        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
	        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);   
	        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
	        if (nameChar.length>0) {   
	            if (nameChar[0] > 128) {   
	                try {   
	                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[0], defaultFormat)[0];
	                    if(i < tmp.length())
	                    	pinyinName += " ";
	                } catch (Exception e) {   
	                    e.printStackTrace();   
	                }
	            }else{   
	                pinyinName += nameChar[0];
	            }   
	        }   
		}
        return pinyinName;  
	}
    
    public static String addSplit(String str,String split){
    	List list = new ArrayList();
    	for(int i = 0 ; i < str.length(); i++){
    		list.add(str.charAt(i)+"");
    	}
    	return Tool.join(split, list);
    }
    
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";   
        Random random = new Random();   
        StringBuffer sb = new StringBuffer();   
        for (int i = 0; i < length; i++) {   
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
        }   
        return sb.toString();   
     }  

    
    /**
	 * 字符转化为整数
	 * 如带小数 先截取
	 * @param str
	 * @return
	 */
	public static int StrToInt(String str){
		int rs = 0;
		if (str != null) {
			if(str.indexOf(".")>0)
				str = str.substring(0,str.indexOf("."));
			try {
				 rs = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				rs = 0;
			}
		}
		return rs;
	}
	
	public static Object invoke(DaoBase dao ,String col){
		Method method;
		Object object = null;
		try {
			method = dao.getClass().getMethod("get" + col, null);
			object = method.invoke(dao, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return object;
	}
	
	public static void invokeSet(DaoBase dao,String col,Object val){
		Method method;
		Object object = null;
		try {
			method = dao.getClass().getMethod("set" + col, new Class[]{getClass(val.getClass())});
			object = method.invoke(dao, new Object[]{val});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
    /**
     * 根据给定的类型返回类型 主要涉及java基本类型的转化
     * @param obj
     * @return
     */
    public static Class getClass(Class obj){
    	String name = obj.getName();
    	String[] types = {"java.lang.Integer","java.lang.Float","java.lang.String","java.util.Date","java.util.Double"};
    	if(name.equals(types[0])){
    		return Integer.TYPE;
    	}else if(name.equals(types[1])){
    		return Float.TYPE;
    	}else if(name.equals(types[2])){
    		return String.class;
    	}else if(name.equals(types[3])){
    		return Date.class;
    	}else{
    		return Double.TYPE;
    	}
    }
	
	public static int update(String sql) {
		int iResult = -1;
		Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                iResult = stmt.executeUpdate(sql);
            }
            catch( SQLException sqle ) {
                sqle.printStackTrace();
            }
            finally {
                if (stmt != null) {
                    try { stmt.close(); }
                    catch (Exception e) { e.printStackTrace(); }
                }
            }
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
	
	public static void format(DecimalFormat df,Map map){
		for(Iterator it = map.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			Object obj = map.get(key);
			if(obj instanceof Double) {
				map.put(key, df.format(obj));
			}else if(obj instanceof Map){
				format(df,(Map)obj);
			}
		}
	}
	

	/*
	 * re格式为{rows:[{'comcode':'37010200'},{'comcode':'37010000'}]} col
	 * 格式为"comcode:支公司,manager:部门";
	 */
	public static void writeExcel(String re, String col, String filename) {
		JSONObject jSONObject = JSONObject.fromObject(re);
		JSONArray json = jSONObject.getJSONArray("rows");
		ListIterator list = json.listIterator();
		Object[] objs = json.toArray();
		JSONArray sortedJArray = new JSONArray();
		for (Object obj : objs) {
			sortedJArray.add(obj);
		}
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("zh", "CN"));
			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					filename), ws);
			WritableSheet s1 = workbook.createSheet("Sheet1", 0);
			String[] cols = col.split(",");
			WritableFont font3 = new WritableFont(
					WritableFont.createFont("宋体"), 14, WritableFont.NO_BOLD);
			// 数据列样式
			jxl.write.NumberFormat nf = new jxl.write.NumberFormat("0.00");
			jxl.write.WritableCellFormat wf = new jxl.write.WritableCellFormat(
					nf);
			wf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			// 标头样式
			WritableCellFormat totalx2Format = new WritableCellFormat();
			totalx2Format.setVerticalAlignment(VerticalAlignment.CENTRE);
			totalx2Format.setAlignment(Alignment.CENTRE);
			totalx2Format.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			totalx2Format.setFont(font3);
			for (int k = 0; k < cols.length; k++) {
				Label lr = new Label(k, 0, cols[k].split(":")[1], totalx2Format);
				s1.setRowView(1, 400);// 设置行高
				s1.addCell(lr);
				s1.setColumnView(k, 15);// 设置列宽
			}

			for (int i = 0; i < sortedJArray.size(); i++) {
				JSONObject obj = sortedJArray.getJSONObject(i);
				Map map = obj;
				for (int k = 0; k < cols.length; k++) {
					String key = cols[k].split(":")[0];
					if (map.get(key) instanceof Integer) {
						jxl.write.Number number = new Number(k, i + 1,
								((Integer) map.get(key)).intValue(), wf);
						s1.addCell(number);
					} else if (map.get(key) instanceof Double) {
						jxl.write.Number number = new Number(k, i + 1,
								((Double) map.get(key)).doubleValue(), wf);
						s1.addCell(number);
					} else {
						Label lr = new Label(k, i + 1,
								map.get(key) == null ? "" : map.get(key) + "",
								wf);
						s1.addCell(lr);
					}
				}
			}
			jSONObject.clear();
			workbook.write();
			workbook.close();
		} catch (IOException e) {
		} catch (WriteException e) {
		}
	}
	
	public static void writeExcel(JSONArray sortedJArray, String col, int startRow,WritableSheet s1) {
		try {
			
			String[] cols = col.split(",");
			WritableFont font3 = new WritableFont(
					WritableFont.createFont("宋体"), 14, WritableFont.NO_BOLD);
			// 数据列样式
			jxl.write.NumberFormat nf = new jxl.write.NumberFormat("0.00");
			jxl.write.WritableCellFormat wf = new jxl.write.WritableCellFormat(
					nf);
			wf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			// 标头样式
			WritableCellFormat totalx2Format = new WritableCellFormat();
			totalx2Format.setVerticalAlignment(VerticalAlignment.CENTRE);
			totalx2Format.setAlignment(Alignment.CENTRE);
			totalx2Format.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			totalx2Format.setFont(font3);
			if(startRow == 0){
				for (int k = 0; k < cols.length; k++) {
					Label lr = new Label(k, 0, cols[k].split(":")[1], totalx2Format);
					s1.setRowView(1, 400);// 设置行高
					s1.addCell(lr);
					s1.setColumnView(k, 15);// 设置列宽
				}
			}

			for (int i = 0; i < sortedJArray.size(); i++) {
				JSONObject obj = sortedJArray.getJSONObject(i);
				Map map = obj;
				for (int k = 0; k < cols.length; k++) {
					String key = cols[k].split(":")[0];
					if (map.get(key) instanceof Integer) {
						jxl.write.Number number = new Number(k, i + 1 + startRow,
								((Integer) map.get(key)).intValue(), wf);
						s1.addCell(number);
					} else if (map.get(key) instanceof Double) {
						jxl.write.Number number = new Number(k, i + 1 + startRow,
								((Double) map.get(key)).doubleValue(), wf);
						s1.addCell(number);
					} else {
						Label lr = new Label(k, i + 1 + startRow,
								map.get(key) == null ? "" : map.get(key) + "",
								wf);
						s1.addCell(lr);
					}
				}
			}
			sortedJArray.clear();
		} catch (WriteException e) {
		}
	}
	
	public static void writeExcel(String re,String col,int start,Map option,WritableSheet s1) {
		JSONObject jSONObject = JSONObject.fromObject(re);
		JSONArray json = jSONObject.getJSONArray("rows");
		ListIterator list = json.listIterator();
		Object[] objs = json.toArray();
		JSONArray sortedJArray = new JSONArray();
		for (Object obj : objs) {
			sortedJArray.add(obj);
		}
		Boolean shownum = (Boolean)option.get("shownum");
		shownum = shownum == null ? false : shownum;
		String labelcol = (String)option.get("labelcol");
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("zh", "CN"));
			String[] cols = col.split(",");
			WritableFont font3 = new WritableFont(
					WritableFont.createFont("宋体"), 14, WritableFont.NO_BOLD);
			// 数据列样式
			jxl.write.NumberFormat nf = new jxl.write.NumberFormat("0.00");
			jxl.write.WritableCellFormat wf = new jxl.write.WritableCellFormat(
					nf);
			jxl.write.NumberFormat nfnum = new jxl.write.NumberFormat("0");
			jxl.write.WritableCellFormat wfnum = new jxl.write.WritableCellFormat(
					nfnum);
			wf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wfnum.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			// 标头样式
			WritableCellFormat totalx2Format = new WritableCellFormat();
			totalx2Format.setVerticalAlignment(VerticalAlignment.CENTRE);
			totalx2Format.setAlignment(Alignment.CENTRE);
			totalx2Format.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			totalx2Format.setFont(font3);
			int colindent = shownum ? 1 : 0;
			String replace = (String)option.get("repplace");
			if(replace != null){
				String reptext = (String)option.get("reptext");
				if(reptext != null){
					String[] replaces = replace.split(",");
					String[] texts = reptext.split(",");
					for(int ii = 0 ; ii < replaces.length ; ii ++){
						int c = Tool.StrToInt(replaces[ii].split(":")[0]),r=Tool.StrToInt(replaces[ii].split(":")[1]);
						Cell cell = s1.getCell( c, r);
					    CellFormat cf = cell.getCellFormat();
					    String txttmp = cell.getContents();
					    if(ii <= texts.length);
					    	txttmp = txttmp.replaceAll(texts[ii].split(":")[0], texts[ii].split(":")[1]);
				    	Label lr = new Label(c, r,
								txttmp,
										cf);
				    	s1.addCell(lr);
					}
				    
				}
			}
			for (int i = 0; i < sortedJArray.size(); i++) {
				JSONObject obj = sortedJArray.getJSONObject(i);
				Map map = obj;
				if(shownum){
					jxl.write.Number lr = new jxl.write.Number(0, i + 1 + start,
							(i + 1),
							wfnum);
					s1.addCell(lr);
				}
				for (int k = 0; k < cols.length; k++) {
					String key = cols[k].split(":")[0];
					if (map.get(key) instanceof Integer) {
						jxl.write.Number number = new Number(k + colindent, i + 1 + start,
								((Integer) map.get(key)).intValue(), wf);
						s1.addCell(number);
					} else if (map.get(key) instanceof Double) {
						jxl.write.Number number = new Number(k + colindent, i + 1 + start,
								((Double) map.get(key)).doubleValue(), wf);
						s1.addCell(number);
					} else {
						if(labelcol != null){
							String[] labelcols = labelcol.split(",");
							Arrays.sort(labelcols);
							if(Arrays.binarySearch(labelcols, key) < 0){
								jxl.write.Number number = new Number(k + colindent, i + 1 + start,
										Tool.StrToDouble((String) map.get(key)), wf);
								s1.addCell(number);
							}else{
								Label lr = new Label(k + colindent, i + 1 + start,
										map.get(key) == null ? "" : map.get(key) + "",
												wf);
								s1.addCell(lr);
							}
						}else{
							Label lr = new Label(k + colindent, i + 1 + start,
									map.get(key) == null ? "" : map.get(key) + "",
											wf);
							s1.addCell(lr);
						}
					}
				}
			}
			jSONObject.clear();
		} catch (WriteException e) {
		}
	}
}
