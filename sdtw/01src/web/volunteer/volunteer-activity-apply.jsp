<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>

<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
String myaccount = (String)session.getAttribute("useraccount");//sno
String activityid = ParamUtils.getParameter(request, "ActivityId", "-1");
VolunteerActivity va= new VolunteerActivity();
va= va.getById(Integer.parseInt(activityid));
String sno = ParamUtils.getParameter(request, "Sno", "-1");
String pagenum = request.getParameter("pagenum");
String cmd=ParamUtils.getParameter(request, "cmd", "save");
String page1=ParamUtils.getParameter(request, "page", "1");

 %>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script type="text/javascript">
function form99submit(){

	document.form1.submit();
}


</script>
</head>

<body>
<%
String strposition = "志愿服务 >>报名活动>> ";
String strfunction = "志愿者申请";
String strhelpwords= "申请成为志愿者。";
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>志愿活动>>报名<%=va.getActivityname() %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr>
    <td>
		<a href="volunteer-activity-list.jsp" >返回</a>
    </td>
</tr>
</table>

<table class="content-table">
<tr><th colspan="3"  align="left" >报名活动</th></tr>
<form name="form1" mentod="post" action="VolunteerParticipateAction.jsp">
<tr>
	<td width="27%" align="right" >个人陈述</td>
	<td align="left" colspan="2">
		<textarea name="Addfilelist" cols="100" rows="6" placeholder="请从本人专业、技能、语言优势等其他方面阐述自己的优势，并且留下自己的联系方式"></textarea>
	</td>
	<input type="hidden" name="ActivityId" value="<%=activityid%>"/>
	<input type="hidden" name="Sno" value="<%=sno%>"/>
	<input type="hidden" name="cmd" value="<%=cmd%>"/>
	<input type="hidden" name="page" value="<%=page1%>"/>
</tr>
</form> 
 <%

%>

<tr>
	<th colspan="3" >
		<input class="button" type="button" value="提交" name="btn1" onclick="form99submit()">&nbsp;&nbsp;&nbsp;
		<input class="button" type="button" value="取消" name="btn2" onclick="history.go(-1);">&nbsp;&nbsp;&nbsp;
	</th>
</tr>
</table>



</body>
</html>
 
