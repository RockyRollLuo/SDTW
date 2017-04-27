package com.xietong.software.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xietong.software.common.HeadConst;

/**
 * Properties文件的操作工具类
 * @author Tlw
 * @since 2010-12-01
 *
 */
public class PropUtil {
	//创建一个Property类的对象, 用于读取proprties文件
	private static Properties prop = new Properties();
	
	/**
	 * 加载prop对象
	 * @param propPath - Properties的物理路径
	 * @throws IOException 
	 */
	public static void loadProp(String propPath) throws IOException {
		InputStream in = PropUtil.class.getResourceAsStream(propPath);
		prop.load(in);
	}

	/**
	 * 读取默认配置文件中的配置信息 - 默认配置文件是/properties/config.properties文件
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String rtn = "";
		try {
			String propPath = "/properties/Config.properties";
			loadProp(propPath);
			rtn = prop.getProperty(key);
			if(rtn!=null) {
				rtn = new String(rtn.getBytes("ISO8859-1"),"utf-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return rtn;
		}
	}
	
	/**
	 * 根据key获得Properties中对应的value
	 * @param propPath - Properties的物理路径
	 * @param key - Properties中的key
	 * @return value - 返回key对应的值
	 */
	public static String getValue(String propPath, String key) {
		String rtn = "";
		try {
			loadProp(propPath);
			rtn = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return rtn;
		}
	}
	
	
	/*public static void main(String[] args) {
		HeadConst df;
		System.out.println("-------"+HeadConst.root_file_path+"/properties/Account.properties");
		String s = PropUtil.getValue("/properties/Account.properties","sms_username");
		System.out.println(s);
	}*/
}
