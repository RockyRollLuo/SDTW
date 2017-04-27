package com.xietong.software.sdtw.train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xietong.software.sdtw.db.TrainingArrangement;
import com.xietong.software.sdtw.db.TrainingParticipate;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.ParamUtils;

public class TrainUtil {
	
	public List getTrainArrangementList(HttpServletRequest request) {
		List list = new ArrayList();
		List cdt = new ArrayList();
		//cdt.add("starttime<=now()");
		//cdt.add("endtime>=now()");
		cdt.add("1=1 order by id desc");
		TrainingArrangement v = new TrainingArrangement();
		int currpage = ParamUtils.getIntParameter(request, "page", 1);
	    com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(v.getCount(cdt), currpage, 10);
	    request.setAttribute("PageControl", pc);
	    cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
		list = v.query(cdt);
		return list;
	}
	
	public Map getTrainingParticipateMap(int uid) {
		
		Map<String, TrainingParticipate> map = new HashMap<String , TrainingParticipate>();
		TrainingParticipate v = new TrainingParticipate();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("Sname="+uid);
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (TrainingParticipate) list.get(i);
				map.put(v.getProjectId()+"", v);
			}
		}
		return map;
	}
	
	public Map getAuditMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(-1, "未审核");
		map.put(0, "报名通过");
		map.put(1, "报名未通过");
		map.put(2, "作业通过");
		map.put(3, "作业未通过");
		map.put(4, "结题通过");
		map.put(5, "结题未通过");
		return map;
	}
	
	public List getAuditList() {
		List list = new ArrayList();
		list.add(new OptionBean("", ""));
		list.add(new OptionBean("未审核", "-1"));
		list.add(new OptionBean("报名通过", "0"));
		list.add(new OptionBean("报名未通过", "1"));
		list.add(new OptionBean("作业通过", "2"));
		list.add(new OptionBean("作业未通过", "3"));
		list.add(new OptionBean("结题通过", "4"));
		list.add(new OptionBean("结题未通过", "5"));
		return list;
	}
}
