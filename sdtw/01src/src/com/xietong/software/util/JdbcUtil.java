package com.xietong.software.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xietong.software.system.DbConnectionManager;

public class JdbcUtil {
	
	/**
	 * 获得连接
	 * @author Tlw
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DbConnectionManager.getConnection("jdbc/ds");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放连接
	 * @author Tlw
	 * @param rs
	 * @param stm
	 * @param conn
	 */
	public  static void release(ResultSet rs, Statement stm, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
