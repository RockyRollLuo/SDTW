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
private synchronized int save(ClubMembers v ,HttpServletRequest request){
	int MemId = ParamUtils.getIntParameter(request, "MemId", -1);
	String MemberClubname = ParamUtils.getParameter(request,"MemberClubname","-1");
	//String ClubId = ParamUtils.getParameter(request,"ClubId","-1");
	String MemberName = ParamUtils.getParameter(request,"MemberName","-1");//学生id（baseusercode表）
	String MemberSno = ParamUtils.getParameter(request,"MemberSno","");
	String MemberAcademy = ParamUtils.getParameter(request,"MemberAcademy","-1");
	String MemberSex = ParamUtils.getParameter(request,"MemberSex","-1");
	String Identity = ParamUtils.getParameter(request,"Identity","-1");
	String MemberPolitics = ParamUtils.getParameter(request,"MemberPolitics","-1");
	String MemberPhone = ParamUtils.getParameter(request,"MemberPhone","-1");
	String Memberqq = ParamUtils.getParameter(request,"Memberqq","-1");
	String Memberwx = ParamUtils.getParameter(request,"Memberwx","-1");
	String MProfile = ParamUtils.getParameter(request,"MProfile","-1");
	String Remark = ParamUtils.getParameter(request,"Remark","");
	String MemberMajor = ParamUtils.getParameter(request,"MemberMajor","-1");
	String MemberGrade = ParamUtils.getParameter(request,"MemberGrade","-1");
	String MemberBrith = ParamUtils.getParameter(request,"MemberBrith","");
	String MemberBirthplace = ParamUtils.getParameter(request,"MemberBirthplace","");
	String MExperience = ParamUtils.getParameter(request,"MExperience","");
	String MemberEmail= ParamUtils.getParameter(request,"MemberEmail","");
	if(v.getById(MemId)!=null){
		v = v.getById(MemId);
	}
	v.setMemberClubname(MemberClubname);
	v.setMemberName(MemberName);
	v.setMemberSno(MemberSno);
	v.setMemberAcademy(MemberAcademy);
	v.setMemberSex(MemberSex);
	v.setIdentity(Identity);
	v.setMemberPolitics(MemberPolitics);
	v.setMemberPhone(MemberPhone);
	v.setMemberqq(Memberqq);
	v.setMemberwx(Memberwx);
	v.setMProfile(MProfile);
	v.setRemark(Remark);
	v.setApplyTime(new Date());
	v.setCheckFlag(0);
	v.setMemberMajor(MemberMajor);
	v.setMemberGrade(MemberGrade);
	v.setMemberBrith(MemberBrith);
	v.setMemberBirthplace(MemberBirthplace);
	v.setMExperience(MExperience);
	v.setMemberEmail(MemberEmail);
	v.setIsManager("0");
	v.setAddTime(new Date());
	v.setApplyTime(new Date());
	int num = 0;
	if(v.getById(MemId)==null){
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
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("save".equals(cmd)){
	ClubMembers members = new ClubMembers();
	int num = save(members,request);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/student/club-all-list.jsp");
		return;
}

%>