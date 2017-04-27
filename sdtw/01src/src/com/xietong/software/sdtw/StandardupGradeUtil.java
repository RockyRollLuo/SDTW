package com.xietong.software.sdtw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xietong.software.base.Power;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.Academy;
import com.xietong.software.sdtw.db.StandardupGrade_File;
import com.xietong.software.system.DbConnectionManager;

public class StandardupGradeUtil {
	
	public List getAcademyList(int aid) {
		List list = new ArrayList();
		List cdt = new ArrayList();
		if (aid!=-1) {
			cdt.add("id="+aid);
 		}
		//cdt.add("(Flag=1||Flag=2)");
		Academy v = new Academy();
		list = v.query(cdt);
		return list; 
	}
	public List getAcademyListFlag1(int aid) {
		List list = new ArrayList();
		List cdt = new ArrayList();
		if (aid!=-1) {
			cdt.add("id="+aid);
 		}
		cdt.add("Flag=1");
		Academy v = new Academy();
		list = v.query(cdt);
		return list; 
	}
	public List getAcademyListFlag(int aid) {
		List list = new ArrayList();
		List cdt = new ArrayList();
		if (aid!=-1) {
			cdt.add("id="+aid);
 		}
		cdt.add("(Flag=1||Flag=2)");
		Academy v = new Academy();
		list = v.query(cdt);
		return list; 
	}
	public Map getAcademyMap() {
		List list = new ArrayList();
		List cdt = new ArrayList();
		Map<String, String>map = new HashMap<String, String>();
		cdt.add("(Flag=1)");
		Academy v = new Academy();
		list = v.query(cdt);
		for (int i=0;i<list.size();i++) {
			v = (Academy) list.get(i);
			map.put(v.getId()+"", v.getAcademyName());
		}
		return map; 
	}
	/***
	 * 报名页面
	 * @param aid
	 * @param sid
	 * @param userInfo
	 * @return
	 */
	public Map getShangbaoListMap(int aid,int sid,UserInfo userInfo){
		StandardupGrade_File v = new StandardupGrade_File();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("StandardUpGradeName="+sid);
		cdt.add("Academy="+aid);
		if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)) { //团委  团委组织建设用只查看提交的 
			cdt.add("ChackFlag!=''");
		}
		list = v.query(cdt);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() > 0) {
			int nums = 0;//每个类别下人数和
			for (int i=0;i<list.size();i++) {
				List tmpList = new ArrayList();
				v = (StandardupGrade_File) list.get(i);
				if (map.get(v.getApplyLevelType())==null) {
					tmpList.add(v);
				} else {
					tmpList = (List) map.get(v.getApplyLevelType());
					tmpList.add(v);
				}
				map.put(v.getApplyLevelType(), tmpList);
				nums+=v.getZBNums();
			}
			map.put("levels", list.size());
			map.put("nums", nums);
		}
		return map;
	}
	/**
	 * 团委查看学院页面
	 * @param sid
	 * @param userInfo
	 * @return
	 */
	public Map getShangbaoListAcaMap(int sid){
		StandardupGrade_File v = new StandardupGrade_File();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("StandardUpGradeName="+sid);
		//cdt.add("Academy="+aid);
		cdt.add("ChackFlag!=''");
		list = v.query(cdt);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (list.size() > 0) {
			for (int i=0;i<list.size();i++) {
				int nums = 0;
				List tmpList = new ArrayList();
				v = (StandardupGrade_File) list.get(i);
				if (map.get(v.getAcademy())==null) {
					nums = 1;
				} else {
					nums =  map.get(v.getAcademy())+1;
				}
				map.put(v.getAcademy(), nums);
			}
		}
		return map;
	}

}
