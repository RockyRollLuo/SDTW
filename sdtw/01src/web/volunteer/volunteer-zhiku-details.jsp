<%@ page pageEncoding="utf-8" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script> 
<script src="../js/jquery.min.js"></script> 

</head>
<body>
<%
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
String id=request.getParameter("id");
String ck1="",ck2="",ck3="";
List list= new ArrayList();
List cdt= new ArrayList();
cdt.add("id="+id);
VolunteerZhiku va=new VolunteerZhiku ();
list=va.query( cdt);
if(list.size()>0){
	va=(VolunteerZhiku)list.get(0);
	ck1=va.getNoticeName();
	ck2=Tool.stringOfDate(va.getStartdate());
	ck3=va.getNoticeInfo();
}


String strposition = "志愿服务>>山大志库>>";
String strfunction = "通知详情";
String strhelpwords = "山大志库通知的信息。";
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>山大志库>><%=ck1 %>详情
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr>
  <td><a href="#" onclick="history.go(-1)">返回</a> </td>
</tr>
</table>

<table class="content-table">
<tr>
  <th colspan="2" align="left">山大志库通知详情</th>
</tr>
<tr>
  <td width="27%" align="right">通知名称：</td>
  <td align="left"><%=ck1%></td>
</tr>
<tr>
  <td align="right">起止日期：</td>
  <td align="left"><%=ck2%></td>
</tr>
<tr>
  <td align="right">通知内容：</td>     
  <td align="left" ><%=ck3%></td>
</tr>
<tr>
  <th  colspan="2">
  </th>
</tr>
</table>


</body>
</html>