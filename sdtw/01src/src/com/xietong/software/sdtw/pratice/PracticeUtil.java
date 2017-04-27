package com.xietong.software.sdtw.pratice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xietong.software.common.CEditConst;
import com.xietong.software.sdtw.db.AcademyMoneyNums;
import com.xietong.software.sdtw.db.Academy_Money_Nums;
import com.xietong.software.sdtw.db.Honor;
import com.xietong.software.sdtw.db.Practice;
import com.xietong.software.sdtw.db.PracticeDeclareTeam;
import com.xietong.software.sdtw.db.PracticeDeclareTeammember;
import com.xietong.software.sdtw.db.PracticeReport;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.ParamUtils;

public class PracticeUtil {
	public Map getAcademyMoneyNumsMap(String projectId) {
		AcademyMoneyNums v = new AcademyMoneyNums();
		Map<String, AcademyMoneyNums> map = new HashMap<String, AcademyMoneyNums>();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("remark="+projectId);
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (AcademyMoneyNums) list.get(i);
				map.put(v.getSno(), v);
			}
		}
		return map;
	}
	
	public List getCheckTypeOptions() {
		List list = new ArrayList();
		list.add(new OptionBean("学院审核及学校审核", "1"));
		list.add(new OptionBean("仅学校审核", "2"));
		return list;
	}
	
	public List getPracticeList(HttpServletRequest request) {
		Practice v= new Practice();
		List cdt = new ArrayList();
		List list = new ArrayList();
		/*cdt.add("Starttime<=now()");
		cdt.add("Endtime>=now()");*/
		int currpage = ParamUtils.getIntParameter(request, "page", 1);
	    com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(v.getCount(cdt), currpage, 10);
	    request.setAttribute("PageControl", pc);
	    cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
		list = v.query(cdt);
		return list;
		
	}
	/***
	 * 团队类别
	 * @return
	 */
	public List getTermTypeOptions() {
		List list = new ArrayList();
		list.add(new OptionBean("项目化团队", "1"));
		list.add(new OptionBean("体验式团队", "2"));
		list.add(new OptionBean("综合型团队", "3"));
		return list;
	}
	/***
	 * 立项类别
	 * @return
	 */
	public List getReport6Options() {
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		list.add(new OptionBean("重点立项", "1"));
		list.add(new OptionBean("一般立项", "2"));
		list.add(new OptionBean("自筹经费立项 ", "3"));
		return list;
	}
	/**
	 * 项目化团队
	 * 实践主题
	 * @return
	 */
	public List getPracticeThemeOptions1() {
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		list.add(new OptionBean("专题调研", "1"));
		list.add(new OptionBean("社会调查", "2"));
		list.add(new OptionBean("支农支教", "3"));
		list.add(new OptionBean("培训指导", "4"));
		list.add(new OptionBean("科普宣传", "5"));
		list.add(new OptionBean("科技指导", "6"));
		list.add(new OptionBean("科研攻关", "7"));
		list.add(new OptionBean("课题合作", "8"));
		list.add(new OptionBean("创新实践", "9"));
		list.add(new OptionBean("创业实践", "10"));
		list.add(new OptionBean("政策宣讲", "11"));
		list.add(new OptionBean("文化传播", "12"));
		list.add(new OptionBean("帮残助困", "13"));
		list.add(new OptionBean("法律援助", "14"));
		list.add(new OptionBean("医疗卫生服务", "15"));
		list.add(new OptionBean("其它", "16"));
		return list;
	}
	/***
	 * 体验式团队
	 * 实践主题
	 * 综合型团队
	 * @return
	 */
	public List getPracticeThemeOptions2() {
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		list.add(new OptionBean("专业型岗位体验 ", "1"));
		list.add(new OptionBean("非专业型岗位体验  ", "2"));
		list.add(new OptionBean("就业创业见习", "3"));
		list.add(new OptionBean("其它", "4"));
		return list;
	}
	
	/*public Map getPracticeDeclareMap(int uid) {
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String,PracticeDeclare>map = new HashMap<String, PracticeDeclare>();
		PracticeDeclare v = new PracticeDeclare();
		cdt.add("addaccount="+uid);
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (PracticeDeclare) list.get(i);
				map.put(v.getDeclareId()+"", v);
			}
		}
		return map;
	}*/
	public Map getPracticeReportMap(int uid) {
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String,PracticeReport>map = new HashMap<String, PracticeReport>();
		PracticeReport v = new PracticeReport();
		cdt.add("addaccount="+uid);
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (PracticeReport) list.get(i);
				map.put(v.getDeclareId()+"", v);
			}
		}
		return map;
	}
	/**
	 * checktype
	 * 1、学院审核及学校审核2、仅学校审核
	 * @param checktype
	 * @return
	 */
	public List getSubmitflagOPtions() {
		List list = new ArrayList();
		list.add(new OptionBean("-1", "已申请"));
		list.add(new OptionBean("1", "提交"));
		/*list.add(new OptionBean("2", "学院审核通过"));
		list.add(new OptionBean("3", "学院审核不通过"));
		list.add(new OptionBean("4", "学校审核通过"));
		list.add(new OptionBean("5", "学校审核不通过"));*/
		return list;
	}
	public Map getSubmitflagMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("-1", "已申请");
		map.put("1", "提交");
		/*map.put("2", "学院审核通过");
		map.put("3", "学院审核不通过");
		map.put("4", "学校审核不通过");
		map.put("5", "学校审核不通过");*/
		return map;
	}
	public List getDutyOPtions() {
		List list = new ArrayList();
		list.add(new OptionBean("队长", "0"));
		list.add(new OptionBean("成员", "1"));
		return list;
	}
	public Map getDutyMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "队长");
		map.put("1", "成员");
		return map;
	}
	/***
	 * type1集体
	 * type2个人
	 * Identity0本科
	 * Identity1研究生
	 * @param ReportId
	 * @param type
	 * @return
	 */
	public List getTeamList(int ReportId,String type,int Identity) {
		PracticeDeclareTeammember v = new PracticeDeclareTeammember();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("ReportId="+ReportId);
		cdt.add("type2="+type);
		cdt.add("Identity="+Identity);
		list = v.query(cdt);
		return list;
	}
	public PracticeDeclareTeam getTeamDetail(int PracticeId) {
		PracticeDeclareTeam v = new PracticeDeclareTeam();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("PracticeId="+PracticeId);
		list = v.query(cdt);
		if(list.size()>0) {
			v = (PracticeDeclareTeam)list.get(0);
		}
		return v;
	}
	
	public Map getPracticeDeclareTeamMap() {
		PracticeDeclareTeam v = new PracticeDeclareTeam();
		Map<String, String> map = new HashMap<String, String>();
		List cdt = new ArrayList();
		List list = v.query(cdt);
		if (list.size()>0) 
			for (int i=0;i<list.size();i++) {
				v = (PracticeDeclareTeam)list.get(i);
				map.put(v.getId()+"", v.getTeamName());
			}
		return map;
	}
	public List getHonorList(int DeclareId,int ReportId){
		//int ReportId = ParamUtils.getIntParameter(request,"ReportId",-1);//结题表id
		//int DeclareId = ParamUtils.getIntParameter(request,"DeclareId",-1);//立项表id
		Map<String, String>map = new HashMap<String, String>();
		Honor honor = new Honor();
		List listh = new ArrayList();
		List cdth = new ArrayList();
		cdth.add("activityId="+DeclareId);
		listh = honor.query(cdth);
		if (listh.size()>0) {
			for (int i=0;i<listh.size();i++) {
				honor = (Honor) listh.get(i);
				map.put(honor.getId()+"", honor.getHonorName());
			}
		}
		
		List honorlist = new ArrayList();
		PracticeDeclareTeammember m = new PracticeDeclareTeammember();
		Map UserCnNameMap = CEditConst.getUserCnNameMap(null);
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("ReportId in("+ReportId+")");
		list = m.query(cdt);
		if (list.size()>0) {
			honorlist.add("个人荣誉");
			for (int i=0;i<list.size();i++) {
				m = (PracticeDeclareTeammember) list.get(i);
				String sname = (String)(UserCnNameMap.get(m.getSName()))==null?"姓名："+m.getSName():"姓名："+(String)(UserCnNameMap.get(m.getSName()));
				String honorname = map.get(m.getHonor())==null?"":map.get(m.getHonor());
				honorlist.add(sname+"，"+honorname);
			}
		}
		if (honorlist.size()>0) {
			honorlist.add("<br/>");
		}
		cdt.clear();
		PracticeDeclareTeam t = new PracticeDeclareTeam();
		List listt = new ArrayList();
		cdt.add("PracticeId in("+ReportId+")");
		listt = t.query(cdt);
		if (listt.size()>0) {
			honorlist.add("集体荣誉");
			for (int i=0;i<listt.size();i++) {
				t = (PracticeDeclareTeam) listt.get(i);
				if (t.getHonor().length()>0) {
					String[]honorNameArr =  t.getHonor().split(",");
					for (int j=0;j<honorNameArr.length;j++) {
						String honorname = map.get(honorNameArr[j])==null?"":map.get(honorNameArr[j]);
						honorlist.add(honorname);
					}
				}
			}
		}
		map.clear();
		return honorlist;
	} 
}
