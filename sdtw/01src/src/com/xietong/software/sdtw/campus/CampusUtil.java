package com.xietong.software.sdtw.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.db.CampusActivity;
import com.xietong.software.sdtw.db.CampusParticipate;
import com.xietong.software.sdtw.db.ClubMembers;
import com.xietong.software.sdtw.db.Honor;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.util.Tool;

public class CampusUtil {
	
	public List getCampusActivity(BaseUserCode user,String ActivitykindType,HttpServletRequest request) {
		/**
		 * <option value="0">所有</option>
	  		<option value="1">已参加</option>
	  		<option value="2">未参加</option>
	  		selectType
		 * */
		UserInfo userInfo = Tool.getUserInfo(request);
		String flag = ParamUtils.getParameter(request, "flag","whhd");
		String selectType = ParamUtils.getParameter(request, "selectType","-1"); 
		String Academy = ParamUtils.getParameter(request, "Academy","-1");
		CampusActivity v = new CampusActivity();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("CONCAT(',',campus,',')  like  '%,"+user.getOrgId()+",%'");
		cdt.add("(ApplicationRange=0||(ApplicationRange=1 && CONCAT(',',Academy,',')  like '%,"+user.getDeptId()+",%'))");
		if(!"-1".equals(ActivitykindType.trim())) {
			cdt.add("ActivitykindType="+ActivitykindType);
		} else {
			if ("whhd".equals(flag)) {//文化活动
				cdt.add("ActivitykindType<=4");
			}
			if ("cxkj".equals(flag)) {//创新科技
				cdt.add("ActivitykindType=5");
			}
			if ("cyjy".equals(flag)) {//创业就业
				cdt.add("ActivitykindType=6");
			}
		}
		if ("1".equals(selectType) ||"2".equals(selectType) ) { //已参加 或未参加
			CampusParticipate c = new CampusParticipate();
			List cdt1 = new ArrayList();
			List list1 = new ArrayList();
			List uidList = new ArrayList();
			cdt1.add("StudentName="+userInfo.getId());
			list1 = c.query(cdt1);
			if (list1.size()>0) {
				for (int i=0;i<list1.size();i++) {
					c = (CampusParticipate) list1.get(i);
					uidList.add(c.getCampusActivityId()+"");
				}
			}
			if ("1".equals(selectType)) {
				if (uidList.size()>0) {
					cdt.add("id in("+Tool.join(",", uidList)+")");
				} else {
					cdt.add("1=-1");
				}
			}
			if ("2".equals(selectType)) { 
				if (uidList.size()>0) {
					cdt.add("id not in("+Tool.join(",", uidList)+")");
				}
			}
			
		}
		if (!"-1".equals(Academy)) {
			cdt.add("OrgacadeMy="+Academy);
		}
		/*
		 * List cids = new ArrayList();
		List clubList = new ArrayList();
		ClubMembers members = new ClubMembers();
		cdt.add("(CheckFlag=1 )&& MemberName="+uid+"");
		list = members.query(cdt);
		if(list.size()>0)
			for(int i=0;i<list.size();i++){
				members = (ClubMembers)list.get(i);
				cids.add(members.getMemberClubname());
			}
		cdt.clear();
		 * **/
		
		int currpage = ParamUtils.getIntParameter(request, "page", 1);
	    com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(v.getCount(cdt), currpage, 10);
	    request.setAttribute("PageControl", pc);
	    cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
		list = v.query(cdt);
		return list;
	}
	
	public int checkBm(int activityid,int uid){
		
		CampusParticipate cp = new CampusParticipate();
		List cdt = new ArrayList();
		int num = 0;
		cdt.add("CampusActivityId="+activityid);
		cdt.add("StudentName="+uid);
		return num = cp.getCount(cdt);
		
	}
	
	public List getHonorList(int HonorType,int activityId){
		Honor h = new Honor();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("HonorType="+HonorType);
		cdt.add("ActivityId="+activityId);
		return list = h.query(cdt);
	}
	
	public Map getCampusParticipate(int uid) {
		Map<String, Object>map = new HashMap<String, Object>();
		CampusParticipate v = new CampusParticipate();
		List list = new ArrayList();
		List cdt = new ArrayList();
		//cdt.add("StudentName="+uid);
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (CampusParticipate) list.get(i);
				map.put(v.getCampusActivityId()+"_Sname_"+v.getStudentName(), v);
				int num = 0;
				int num2 = 0;
				if(v.getCheckFlag()==1){//审核通过人数
					if(map.get(v.getCampusActivityId()+"_"+v.getCheckFlag())==null){
						map.put(v.getCampusActivityId()+"_"+v.getCheckFlag(), 1);
					} else {
						num = (Integer) map.get(v.getCampusActivityId()+"_"+v.getCheckFlag())+1;
						map.put(v.getCampusActivityId()+"_"+v.getCheckFlag(), num);
					} 
				}else if(v.getCheckFlag()==-1){//报名人数
					if(map.get(v.getCampusActivityId()+"_"+v.getCheckFlag())==null){
						map.put(v.getCampusActivityId()+"_"+v.getCheckFlag(), 1);
					} else {
						num2 = (Integer) map.get(v.getCampusActivityId()+"_"+v.getCheckFlag())+1;
						map.put(v.getCampusActivityId()+"_"+v.getCheckFlag(), num2);
					} 
				}
			}
		}
		return map;
	}
	
	public List getHonorNameoptions(int HonorType,int ActivityId){
		List list = new ArrayList();
		List cdt = new ArrayList();
		List hList = new ArrayList();
		Honor v = new Honor();
		cdt.add("HonorType="+HonorType);
		cdt.add("ActivityId="+ActivityId);
		list = v.query(cdt);
		if (list.size()>0) {
			for(int i=0;i<list.size();i++) {
				v = (Honor) list.get(i);
				hList.add(new OptionBean(v.getHonorName(),v.getId()+""));
			}
		}
		return hList;
		
	}
}
