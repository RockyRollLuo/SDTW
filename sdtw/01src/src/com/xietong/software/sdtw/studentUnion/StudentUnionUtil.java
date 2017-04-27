package com.xietong.software.sdtw.studentUnion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xietong.software.common.CEditConst;
import com.xietong.software.sdtw.XtUtil;
import com.xietong.software.sdtw.db.Classes;
import com.xietong.software.sdtw.db.StudentClassDuty;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.Tool;

public class StudentUnionUtil {
	public Map getStudentDutyMap(String academy,String xn,String classname) {
		Map<String, List> dutyMap = new HashMap<String, List>();
		StudentClassDuty v = new StudentClassDuty();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("academy="+academy);
		if(!"-1".equals(xn)&&!"".equals(xn))
		cdt.add("schoolyear='"+xn+"'");
		if(!"-1".equals(classname)&&!"".equals(classname)) {
			cdt.add("classname="+classname);
		}
		list = v.query(cdt);
		if(list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (StudentClassDuty) list.get(i);
				List tmpLlist = new ArrayList();
				String key = v.getClassname()+"_"+v.getSchoolYear();
				if (dutyMap.get(key)==null) {
					tmpLlist.add(v);
					dutyMap.put(key, tmpLlist);
				} else {
					tmpLlist = dutyMap.get(key);
					tmpLlist.add(v);
					dutyMap.put(key, tmpLlist);
				}
			}
		}
		
		return dutyMap;
	}
	
	public static List getYearOption(int endYear){
		int now = Tool.yearOfDate(new Date());
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		for(int i=now;i>=endYear;i--){
			OptionBean optionBean = new OptionBean(""+i + "~" + (i+1), ""+i + "~" + (i+1));
			list.add(optionBean);
		}
		return list;
	}
	
	public static List getStudentDutyOptions(){
		List list = new ArrayList();
		list.add(new OptionBean("班长", "0"));
		list.add(new OptionBean("团支书", "1"));
		list.add(new OptionBean("其他班委", "2"));
		return list;
	}
	public List getClassesNameOptions(List cdt) {
		List list = new ArrayList();
		List addList = new ArrayList();
		Classes v  = new Classes();
		Map GradeNameMap = CEditConst.getGradeNameMap(null);
		list = v.query(cdt);
		addList.add(new OptionBean("", "-1"));
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (Classes) list.get(i);
				String grade = (String) GradeNameMap.get(v.getGid()+"");
				addList.add(new OptionBean(grade+"_"+v.getName(), v.getId()+""));
			}
		}
		return addList;
	}
	public Map getClassesNameMap(List cdt) {
		List list = new ArrayList();
		Map<String, String> clsmap = new HashMap<String, String>();
		Classes v  = new Classes();
		Map GradeNameMap = CEditConst.getGradeNameMap(null);
		list = v.query(cdt);
		//addList.add(new OptionBean("", "-1"));
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (Classes) list.get(i);
				String grade = (String) GradeNameMap.get(v.getGid()+"");
				clsmap.put(v.getId()+"",grade+"_"+v.getName());
			}
		}
		return clsmap;
	}
	public List getStudentDutyList(String academy,String schoolyear,String classname){
		//_academy_="+academy+"&_schoolyear_="+schoolyear+"&_classname_="+classname
		List cdt = new ArrayList();
		List list = new ArrayList();
		StudentClassDuty v = new StudentClassDuty();
		cdt.add("academy="+academy);
		cdt.add("schoolyear='"+schoolyear+"'");
		cdt.add("classname="+classname);
		list = v.query(cdt);
		return list;
	}
}
