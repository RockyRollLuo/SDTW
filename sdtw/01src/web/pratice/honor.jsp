<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
int ReportId = ParamUtils.getIntParameter(request,"ReportId",-1);//结题表id
int DeclareId = ParamUtils.getIntParameter(request,"DeclareId",-1);//立项表id
PracticeUtil util = new PracticeUtil();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../js/personlistorder.js"></script>
<script src="../main/js/common.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="js/upload.js"></script>
</head>
<body>
<%
String strposition = "社会实践  >>社会实践项目>> ";
String strfunction = "评定结果";
String strhelpwords= "1.各级各类实践立项申报团队均需填写此表，其中团队成员总数一般在10人以内;<br/>"
					+"2.两个以上学院合作组织的团队，需两个学院协商配套经费、共同签署意见;<br/>"
					+"3.若对申请书填写有不清楚的地方，请咨询0531-88369964。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
 	   <a href="pratice-activity-list.jsp"><!-- <img src="../images/commandico/back.png"> -->返回</a>
	</td>
</tr>
</table>

<form name="postForm" id="postForm" action="pratice-project-addsave.jsp">
<table class="content-table">
<tr>
<th align="left">荣誉列表</th>
</tr>
<tr>
	<td>
	<%
	List list = new ArrayList();
	list = util.getHonorList(DeclareId,ReportId);
	if(list.size()>0) {%>
		<%=Tool.join("<br/>",list) %>
	<%}
	%>
	</td>
</tr>

</table>
</body>
</html>
