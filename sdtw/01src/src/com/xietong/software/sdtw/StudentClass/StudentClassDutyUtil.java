package com.xietong.software.sdtw.StudentClass;

import java.util.ArrayList;
import java.util.List;

import com.xietong.software.sdtw.db.Academy;

public class StudentClassDutyUtil {

	public List getAcademyList(int aid) {
		List list = new ArrayList();
		List cdt = new ArrayList();
		if (aid!=-1) {
			cdt.add("id="+aid);
 		}
		cdt.add("(Flag=1)");
		Academy v = new Academy();
		list = v.query(cdt);
		return list; 
	}
}
