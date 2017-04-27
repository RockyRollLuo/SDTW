<%@page import="com.xietong.software.util.OptionBean"%>
<%@page import="com.xietong.software.sdtw.db.InnovationCompetitionProject"%>
<%@page import="com.xietong.software.sdtw.db.ChuangKu"%>
<%@page import="com.xietong.software.sdtw.db.VolunteerZhiku"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
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
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}

String id=request.getParameter("id");
String ck1="",ck2="",ck3="",ck4="";
List list1= new ArrayList();
List cdt1= new ArrayList();
cdt1.add("id="+id);
ChuangKu va=new ChuangKu  ();
list1=va.query( cdt1);
if(list1.size()>0){
	va=(ChuangKu )list1.get(0);
	ck1=va.getCk1();
	ck2=Tool.stringOfDate(va.getCk2());
	ck3=va.getCk3();
	ck4=va.getAddTime();
}

%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>山大创库>><%=ck1%>详情表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table  class="command-table">
<tr >
  <td height="35px"><a href="innovation-chuangku-list.jsp" >返回</a></td>
</tr>
</table>

<table class="content-table">
<tr>
  <th colspan="2" align="left">山大创库通知详情</th>
</tr>
<tr>
  <td width="27%" align="right">通知名称：</td>
  <td align="left"><%=ck1%></td>
</tr>
<tr>	
  <td align="right">起止日期：</td>
  <td align="left"><%=ck2+"~"+ck4%></td>
</tr>
<tr>
  <td align="right">通知内容：</td>     
  <td align="left" ><%=ck3%></textarea>
  </td>
</tr>
<tr>
  <th  colspan="2">
  </th>
</tr>
</table>


</body>
</html>