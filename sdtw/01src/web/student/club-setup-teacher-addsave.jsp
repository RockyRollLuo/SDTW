<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
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
private synchronized int save(ClubTeacher v ,HttpServletRequest request){
	int Id = ParamUtils.getIntParameter(request, "Id", -1);
	String ClubName = ParamUtils.getParameter(request,"ClubName","");
	String TeaName = ParamUtils.getParameter(request,"TeaName","-1");
	String TeaSex = ParamUtils.getParameter(request,"TeaSex","-1");
	String TeaAge = ParamUtils.getParameter(request,"TeaAge","");
	String TeaNation = ParamUtils.getParameter(request,"TeaNation","-1");
	String TeaPolitics = ParamUtils.getParameter(request,"TeaPolitics","-1");
	String TeaBirthplace = ParamUtils.getParameter(request,"TeaBirthplace","-1");
	String TeaDuty = ParamUtils.getParameter(request,"TeaDuty","-1");
	String TeaAcademy = ParamUtils.getParameter(request,"TeaAcademy","-1");
	String TeaTel = ParamUtils.getParameter(request,"TeaTel","-1");
	String TeaPhone = ParamUtils.getParameter(request,"TeaPhone","-1");
	String TeaEmail = ParamUtils.getParameter(request,"TeaEmail","-1");
	String TeaAcademic = ParamUtils.getParameter(request,"TeaAcademic","");
	
	 if(v.getById(Id)!=null){
		v = v.getById(Id);
	} 
	
	v.setClubName(ClubName);
	v.setTeaName(TeaName);
	v.setTeaSex(TeaSex);
	v.setTeaAge(TeaAge);
	v.setTeaNation(TeaNation);
	v.setTeaPolitics(TeaPolitics);
	v.setTeaBirthplace(TeaBirthplace);
	v.setTeaDuty(TeaDuty);
	v.setTeaAcademy(TeaAcademy);
	v.setTeaTel(TeaTel);
	v.setTeaPhone(TeaPhone);
	v.setTeaEmail(TeaEmail);
	v.setTeaAcademic(TeaAcademic);
	v.setGeneration(1);
	v.setCheckFlag(1);//教师可用
	v.setStartDate(new Date());
	int num = 0;
	if(v.getById(Id)==null){
		UserInfo ui = Tool.getUserInfo(request);
		UserInfo userInfo =null;
		if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
			userInfo = ui;
		}
		v.setAddPerson(ui.getId()+"");
		num = v.insert();
	}else{
		num = v.update();
	}
	Club club = new Club();
	club = club.getById(Tool.StrToInt(ClubName));
	club.setTeacher(v.getId()+"");
	club.update();
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("saveOrUpdate".equals(cmd)){
	ClubTeacher members = new ClubTeacher();
	int num = save(members,request);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/student/club-setup-list.jsp");
		return;
}

%>