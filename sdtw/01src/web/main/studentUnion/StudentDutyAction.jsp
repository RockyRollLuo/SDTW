<%@page import="com.xietong.software.sdtw.studentUnion.StudentUnionUtil"%>
<%@ page language="java" %>
<%--添加班委--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.base.Power"%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
}
String cmd = ParamUtils.getParameter(request,"cmd","");
if ("insert".equals(cmd)) {
	String schoolyear = ParamUtils.getParameter(request,"schoolyear","");
	String academy = ParamUtils.getParameter(request,"academy","");
	String classname = ParamUtils.getParameter(request,"classname","");
	String SId = ParamUtils.getParameter(request,"SId","");//学号
	String current = ParamUtils.getParameter(request,"page","1");
	if (SId.length()>0) {
		String sid[] = SId.split(",");
		for (int i=0;i<sid.length;i++) {
			String Sno = ParamUtils.getParameter(request,"Sno"+sid[i],"");
			String Duty = ParamUtils.getParameter(request,"Duty"+sid[i],"");
			StudentClassDuty v = new StudentClassDuty();
			v.setSchoolYear(schoolyear);
			v.setAcademy(academy);
			v.setClassname(classname);
			v.setSno(Sno);
			v.setDuty(Duty);
			v.insert();
		}
	}
	out.println("<script>window.location='StudentDutyList.jsp?_academy_="+academy+"&_schoolyear_="+schoolyear+"&page="+current+"';</script>");
	
	return;
}
if ("modify".equals(cmd)) {
	String schoolyear = ParamUtils.getParameter(request,"schoolyear","");
	String academy = ParamUtils.getParameter(request,"academy","");
	String classname = ParamUtils.getParameter(request,"classname","");
	String SId = ParamUtils.getParameter(request,"SId","");//学号
	String current = ParamUtils.getParameter(request,"page","1");
	StudentUnionUtil util = new StudentUnionUtil();
	List list = new ArrayList();
	Map<String,StudentClassDuty>map = new HashMap<String,StudentClassDuty>();
	list = util.getStudentDutyList(academy,schoolyear,classname);
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			StudentClassDuty v = new StudentClassDuty();
			v = (StudentClassDuty)list.get(i);
			map.put(v.getSno(),v);
		}
	}
	if (SId.length()>0) {
		String sid[] = SId.split(",");
		for (int i=0;i<sid.length;i++) {
			String Sno = ParamUtils.getParameter(request,"Sno"+sid[i],"");
			String Duty = ParamUtils.getParameter(request,"Duty"+sid[i],"");
			StudentClassDuty v = new StudentClassDuty();
			if (map.get(sid[i])!=null) {
				v = map.get(sid[i]);
			}
			v.setSchoolYear(schoolyear);
			v.setAcademy(academy);
			v.setClassname(classname);
			v.setSno(Sno);
			v.setDuty(Duty);
			if (map.get(sid[i])!=null) {
				v.update();
			} else {
				v.insert(); 
			}
		}
	}
	map.clear();
	out.println("<script>window.location='StudentDutyList.jsp?_academy_="+academy+"&_schoolyear_="+schoolyear+"&page="+current+"';</script>");
	
	return;
}
%>

