<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
  <%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
    <%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>

<%! 
ResultSet rs=null;
int i=0;
%>
<%
String myuserrole = (String)session.getAttribute("userrole");
String myuseraccount = (String)session.getAttribute("useraccount"); 
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../main/css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../main/js/tablelist.js"></script>
<script src="../main/js/jquery.min.js"></script>
</head>

<body>



<%
String strposition = "志愿服务信息  >> ";
String strfunction = "志愿者申请";
String strhelpwords= "申请成为志愿者。";
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}else{
user = userInfo.getUserCode();
}
System.out.println(user.getName()+".............2222222222222...............");
%>
 <%@ include file="pagetop-positionandhelp.jsp" %>




<div id="table1" style="display:none;">
<table class="frame-table" align="center">
  <tr height="50px"><th>系统提示</th></tr>
  <tr>
    <td>欢迎您加入山东大学青年志愿者协会，您可以：<br><br>
    <a href="volunteer-activity-list.jsp" target="_self">浏览志愿活动</a><br>
	  <a href="volunteer-project-list.jsp" target="_self">参加志愿竞赛项目</a><br>
	  <a href="volunteer-search.jsp" target="_self">进行志愿信息查询</a>
    </td>
  </tr>
  <tr height="50px">
	<th>
	  
	</th>
  </tr>
</table>
</div>
<div id="table2" >
<table class="frame-table" align="center">
  <tr height="50px"><th>系统提示</th></tr>
  <tr>
    <td>您尚未加入山东大学青年志愿者协会，是否申请成为志愿者？</td>
  </tr>
  <tr height="50px">
	<th>
	
	  <a href="../main/volunter/BaseUserCodeAction.jsp?cmd=gaiziyuan&Id=<%=user.getId()%>" target="_self">是</a> | 
	  <a href="#">否</a>  
	</th>
  </tr>
</table>
</div>
</body>
</html>
