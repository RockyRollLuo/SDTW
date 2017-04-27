<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.XtUtil"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeam"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeammember"%>
<%@page import="com.xietong.software.sdtw.db.PracticeReport"%>
<%@page import="com.xietong.software.sdtw.db.Grade"%>
<%@page import="com.xietong.software.sdtw.db.Academy"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.Practice_Declare_Teammember"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.Practice_Declare"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
UserInfo ui = Tool.getUserInfo(request);
UserInfo userInfo =null;
if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
	userInfo = ui;
}
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}%>
<%!
//个人
private synchronized int save(PracticeReport v ,HttpServletRequest request){
	UserInfo ui = Tool.getUserInfo(request);
	 int id = ParamUtils.getIntParameter(request, "Id", -1);
	    int num = 0;
	    if (id!=-1&&v.getById(id)!=null) {
	    	 v = v.getById(id);
	    } 
	    v.setDeclareId(ParamUtils.getIntParameter(request, "DeclareId", -1));
	    v.setType(ParamUtils.getIntParameter(request, "Type", -1));
	    v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
	    v.setSubmitFlag(ParamUtils.getIntParameter(request, "SubmitFlag", -1));
	    v.setReport3(ParamUtils.getParameter(request, "Report3", ""));
	    v.setAcademy(ui.getDeptId()+"");
	    if (id!=-1&&v.getById(id)!=null) {
        	num = v.update();
       } else {
    	   v.setAddaccount(ui.getId()+"");
    	   v.setAddtime(Tool.stringOfDateTime(new Date()));
    	   num = v.insert();
       }
	    PracticeDeclareTeammember member = new PracticeDeclareTeammember();
	    List cdt = new ArrayList();
	    List list = new ArrayList();
	    cdt.add("ReportId="+v.getId());
	    cdt.add("type2=2");
	    list = member.query(cdt);
	    if (list.size()>0) {
	    	member = (PracticeDeclareTeammember)list.get(0);
	    }
	    member.setPracticeId(v.getDeclareId()+"");//立项表id
	    member.setReportId(v.getId()+"");
	    member.setSno(ui.getName());
	    member.setSName(ui.getId()+"");
	    member.setSex(ui.getUserCode().getGender()+"");
	    member.setAcademy(ui.getDeptId()+"");
	    member.setGrade(ui.getUserCode().getGrade());
	    member.setIdentity("0");//本科学历
	    member.setType2(2);//个人
	    if (list.size()>0) {
	    	member = (PracticeDeclareTeammember)list.get(0);
	    	member.update();
	    } else {
	    	member.insert();
	    }
	    return num;
}
//集体
private synchronized int save(PracticeReport v ,HttpServletRequest request,String cmd){
	UserInfo ui = Tool.getUserInfo(request);
    int id = ParamUtils.getIntParameter(request, "Id", -1);
    int num = 0;
    if (id!=-1&&v.getById(id)!=null) {
    	 v = v.getById(id);
    } 
    v.setId(id);
    v.setAcademy(ui.getDeptId()+"");
    v.setDeclareId(ParamUtils.getIntParameter(request, "DeclareId", -1));
    v.setType(ParamUtils.getIntParameter(request, "Type", -1));
    v.setTeamId(ParamUtils.getParameter(request, "TeamId", ""));
    v.setMemberid(ParamUtils.getParameter(request, "Memberid", ""));
    v.setPracticeId(ParamUtils.getIntParameter(request, "PracticeId", -1));
   // v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
    v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
    v.setXyCheckFlag(ParamUtils.getIntParameter(request, "XyCheckFlag", -1));
    v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
    v.setSubmitFlag(ParamUtils.getIntParameter(request, "SubmitFlag", -1));
    v.setXyHonour(ParamUtils.getParameter(request, "XyHonour", ""));
   // v.setReport1(ParamUtils.getParameter(request, "Report1", ""));
    //v.setReport2(ParamUtils.getParameter(request, "Report2", ""));
    v.setReport3(ParamUtils.getParameter(request, "Report3", ""));
   // v.setReport4(ParamUtils.getParameter(request, "Report4", ""));
    v.setReport5(ParamUtils.getParameter(request, "Report5", ""));
    v.setReport6(ParamUtils.getParameter(request, "Report6", ""));
    v.setReport12(ParamUtils.getParameter(request, "Report12", ""));
    v.setReport13(ParamUtils.getParameter(request, "Report13", ""));
    v.setReport14(ParamUtils.getParameter(request, "Report14", ""));
    v.setReport15(ParamUtils.getParameter(request, "Report15", ""));
    v.setStartTime(ParamUtils.getParameter(request, "StartTime", ""));
    v.setEndTime(ParamUtils.getParameter(request, "EndTime", ""));
    v.setReport17(ParamUtils.getParameter(request, "Report17", ""));
    v.setReport18(ParamUtils.getParameter(request, "Report18", ""));
    v.setReport19(ParamUtils.getParameter(request, "Report19", ""));
    v.setReport20(ParamUtils.getParameter(request, "Report20", ""));
    v.setReport23(ParamUtils.getParameter(request, "Report23", ""));
    v.setReport24(ParamUtils.getParameter(request, "Report24", ""));
    v.setReport25(ParamUtils.getParameter(request, "Report25", ""));
    v.setReport26(ParamUtils.getParameter(request, "Report26", ""));
    v.setReport27(ParamUtils.getParameter(request, "Report27", ""));
    v.setReport28(ParamUtils.getParameter(request, "Report28", ""));
    v.setReport29(ParamUtils.getParameter(request, "Report29", ""));
    v.setReport30(ParamUtils.getParameter(request, "Report30", ""));
   // v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
    v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
    v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
    v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
    v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
    v.setRemark4(ParamUtils.getParameter(request, "Remark4", ""));
    v.setRemark5(ParamUtils.getParameter(request, "Remark5", ""));
    v.setRemark6(ParamUtils.getParameter(request, "Remark6", ""));
    v.setSubmitFlag(ParamUtils.getIntParameter(request, "SubmitFlag", -1));
        if (id!=-1&&v.getById(id)!=null) {
        	num = v.update();
       } else {
    	   v.setAddaccount(ui.getId()+"");
    	   v.setAddtime(Tool.stringOfDateTime(new Date()));
    	   num = v.insert();
       }
        int teamId = ParamUtils.getIntParameter(request,"Report1",-1);//团队id
        String Report1Name = ParamUtils.getParameter(request, "Report1Name", "");//团队名称
        String Report2 = ParamUtils.getParameter(request, "Report2", "");//学院
        String Report21 = ParamUtils.getParameter(request, "Report21", "");//团队活动小结
        String Report22 = ParamUtils.getParameter(request, "Report22", "");//团队主要成绩成果
        String Report4 = ParamUtils.getParameter(request, "Report4", "");//团队类别
        //String PracticeReportTeamType = ParamUtils.getParameter(request, "Report5", "");
       	PracticeDeclareTeam team1 = new PracticeDeclareTeam();
       	if (teamId!=-1 && team1.getById(teamId)!=null){
       		team1 = team1.getById(teamId);
       	}
       	team1.setPracticeId(v.getId()+"");
       	team1.setTeamName(Report1Name);
       	team1.setAcademy(Report2);
       	team1.setPracticeReportTeamType(Report4);
       	team1.setReport21(Report21);
       	team1.setReport22(Report22);
      // 	team1.setPracticeReportTeamType(PracticeReportTeamType);
       	if (teamId!=-1 && team1.getById(teamId)!=null){
       		team1.update();
       	} else {
       		team1.insert();
       	}
       	//v = v.getById(v.getId());
        v.setTeamId(team1.getId()+"");
        
        /**保存本科生*/
        List cdt = new ArrayList();
        PracticeDeclareTeammember member = new PracticeDeclareTeammember();
         String SId = ParamUtils.getParameter(request,"SId","");
        Map<String,PracticeDeclareTeammember> map = new HashMap<String,PracticeDeclareTeammember>();
        if (SId.length()>0) {
        	
       	cdt.clear();
        cdt.add("ReportId="+v.getId());
        cdt.add("type2=1");
        cdt.add("Identity=0");//本科
        cdt.add("SName not in("+SId+")");
        member.deleteByCondition(cdt);
        
        List list = new ArrayList();
        cdt.clear();
        cdt.add("ReportId="+v.getId());
        cdt.add("Identity=0");//本科
        cdt.add("type2=1");//集体
        cdt.add("SName in("+SId+")");
        list = member.query(cdt);
        if (list.size()>0) {
        	for (int i=0;i<list.size();i++) {
        		member = (PracticeDeclareTeammember)list.get(i);
        		map.put(member.getSName(),member);
        	}
        }
        String sidArr[] = SId.split(",");
        cdt.clear();
        cdt.add("id in("+SId+")");
        Map userMap = XtUtil.getBeanMapByCdt(cdt, BaseUserCode.class);
        for (int i=0;i<sidArr.length;i++) {
        	String SName = ParamUtils.getParameter(request,"SName"+sidArr[i],"");
        	String Sno = ParamUtils.getParameter(request,"Sno"+sidArr[i],"");
        	String Sex = ParamUtils.getParameter(request,"Sex"+sidArr[i],"");
        	String Academy = ParamUtils.getParameter(request,"Academy"+sidArr[i],"");
        	String Grade = ParamUtils.getParameter(request,"Grade"+sidArr[i],"");
        	//String IdCard = ParamUtils.getParameter(request,"IdCard"+sidArr[i],"");
        	//String Address = ParamUtils.getParameter(request,"Address"+sidArr[i],"");
        	String Phone = ParamUtils.getParameter(request,"Phone"+sidArr[i],"");
        	String Duty = ParamUtils.getParameter(request,"Duty"+sidArr[i],"");
        	PracticeDeclareTeammember team = new PracticeDeclareTeammember();
        	BaseUserCode user = (BaseUserCode)userMap.get(sidArr[i]);
        	if (map.get(SName)!=null) {
        		team = map.get(SName);
        	}
        	member.setTeamId(team1.getId());//团队id
        	member.setPracticeId(v.getDeclareId()+"");//立项表id
        	team.setReportId(v.getId()+"");
        	team.setSno(user.getName());
        	team.setSName(user.getId()+"");
        	team.setSex(user.getGender()+"");
        	team.setAcademy(user.getDeptId()+"");
        	team.setGrade(user.getGrade());
        	team.setIdentity("0");
        	//team.setIdCard(IdCard);
        	//team.setAddress(Address);
        	team.setPhone(Phone);
        	team.setDuty(Duty);
        	team.setType2(1);//集体申报
        	if (map.get(SName) ==null) {
	        	team.insert();
        	} else {
	        	team.update();
        	}
        }
        } else {
        	if ("update".equals(cmd)) {
        	cdt.clear();
            cdt.add("ReportId="+v.getId());
            cdt.add("type2=1");
            cdt.add("Identity=0");//本科
            member.deleteByCondition(cdt);
        	}
        }
        map.clear(); 
        /**保存研究生**/
        String Nums = ParamUtils.getParameter(request,"Nums","");
        if (Nums.length()>0) {
	     //   Nums = XtUtil.getIdsStr(Nums);
        	PracticeDeclareTeammember team = new PracticeDeclareTeammember();
        	List teamids = new ArrayList();
        	String NumsArr[] = Nums.split(",");
        	for (int i=0;i<NumsArr.length;i++) {
        		int Id = ParamUtils.getIntParameter(request,"Id_t"+NumsArr[i],-1);
        		teamids.add(Id+"");
        	}
        	cdt.clear();
        	cdt.add("id not in("+Tool.join(",",teamids)+")");
        	cdt.add("Identity=1");//学历
        	cdt.add("type2=1");//集体
        	cdt.add("ReportId="+v.getId());
        	team.deleteByCondition(cdt);
        	for (int i=0;i<NumsArr.length;i++) {
        		int Id = ParamUtils.getIntParameter(request,"Id_t"+NumsArr[i],-1);
        		String Sno = ParamUtils.getParameter(request,"Sno_t"+NumsArr[i],"");
        		String SName = ParamUtils.getParameter(request,"SName_t"+NumsArr[i],"");
        		String Sex = ParamUtils.getParameter(request,"Sex_t"+NumsArr[i],"");
        		String Academy = ParamUtils.getParameter(request,"Academy_t"+NumsArr[i],"");
        		String Identity = ParamUtils.getParameter(request,"Identity_t"+NumsArr[i],"");// 学历
        		String Grade = ParamUtils.getParameter(request,"Grade_t"+NumsArr[i],"");
        		String Phone = ParamUtils.getParameter(request,"Phone_t"+NumsArr[i],"");
        		String Duty = ParamUtils.getParameter(request,"Duty_t"+NumsArr[i],"");//0队长1成员
        		if(Id!=-1) {
        			team = team.getById(Id);
        		}
        		team.setSno(Sno);
        		team.setPracticeId(v.getDeclareId()+"");//立项表id
        		team.setReportId(v.getId()+"");
        		team.setTeamId(Tool.StrToInt(v.getTeamId()));
        		team.setSName(SName);
        		team.setSex(Sex);
        		team.setAcademy(Academy);
        		team.setIdentity(Identity);
        		team.setGrade(Grade);
        		team.setPhone(Phone);
        		team.setDuty(Duty);
        		team.setType2(1);//集体申报
        		team.setIdentity("1");
        		if(Id!=-1) {
        			team.update();
        		} else {
        			team.insert();
        		}
        	}
        }else {
        	if ("update".equals(cmd)) {
        	cdt.clear();
	        cdt.add("reportid="+id);
	        cdt.add("type2=1");
	        cdt.add("Identity=1");//研究生
	        PracticeDeclareTeammember team = new PracticeDeclareTeammember();
	        team.deleteByCondition(cdt);
        	}
        }
        List sids = new ArrayList();
        List list2 = new ArrayList();
        cdt.clear();
        PracticeDeclareTeammember team = new PracticeDeclareTeammember();
        cdt.add("reportid="+id);
        cdt.add("type2=1");
        list2 = team.query(cdt);
        if(list2.size()>0)
        	for(int i=0;i<list2.size();i++) {
        		team = (PracticeDeclareTeammember)list2.get(i);
        		sids.add(team.getId()+"");
        	}
        if(sids.size()>0){
       	 v.setMemberid(Tool.join(",",sids));
        }else{
        	v.setMemberid("");
        }
        v.update();
   return num;
}
%>

<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("AcademyOptions".equals(cmd)){
	Academy v = new Academy();
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("flag=1");
	list = v.query(cdt);
	StringBuffer sb = new StringBuffer();
	sb.append("<option value=-1></option>");
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			v = (Academy)list.get(i);
			sb.append("<option value="+v.getId()+">"+v.getAcademyName()+"</option>");
		}
	}
	out.print(sb.toString());
	return;
}
if("GradeOptions".equals(cmd)){
	Grade v = new Grade();
	List cdt = new ArrayList();
	List list = new ArrayList();
	//cdt.add("isEnable=1");
	list = v.query(cdt);
	StringBuffer sb = new StringBuffer();
	sb.append("<option value=-1></option>");
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			v = (Grade)list.get(i);
			sb.append("<option value="+v.getId()+">"+v.getName()+"</option>");
		}
	}
	out.print(sb.toString());
	return;
}
if("save".equals(cmd)||"update".equals(cmd)){
	PracticeReport v = new PracticeReport();
	int num = save(v,request,cmd);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/pratice/pratice-activity-list.jsp");
		return;
}
if ("shangbao".equals(cmd)) {
	int id = ParamUtils.getIntParameter(request,"id",-1);
	PracticeReport v = new PracticeReport();
	v = v.getById(id);
	v.setSubmitFlag(1);
	int num = v.update();
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/pratice/pratice-activity-list.jsp");
		return;
}
if ("savePersonal".equals(cmd)) {
	PracticeReport v = new PracticeReport();
	int num = save(v,request);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/pratice/pratice-activity-list.jsp");
		return;
}

%>