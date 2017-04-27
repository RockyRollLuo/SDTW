<%@page import="com.xietong.software.sdtw.db.TrainingArrangement"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%//社团申请页面 %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
int id = ParamUtils.getIntParameter(request,"id",-1);
TrainingArrangement v = new TrainingArrangement();
if (id!=-1&&v.getById(id)!=null)
v = v.getById(id);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
String currpage = ParamUtils.getParameter(request,"page","1");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="../css/autosearch.css"> -->
<script src="../js/autosearch.js"></script>
<script src="../main/js/common.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
	<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
<style type="text/css">
.blocktitle{
	font-size:large;
	font-weight:bold;
}
</style>
<script type="text/javascript">
function fanhui(currpage) {
	location = "training_arrangement-list.jsp?page="+currpage;
}
</script>
</head>

<body>
<%
String strposition = "团校培训管理 >> 培训项目报名 >> ";
String strfunction = "学习项目";
String strhelpwords = "";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td>
    <%-- <%
    if("viewlist".equals(cmd)){%>
    	<a href="club-all-list.jsp" >
    <%}else{%>
    	<a href="club-setup-list.jsp" >
    <%}
    %> --%>
    <a href="#" onclick="fanhui(<%=currpage %>)" >
    <!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table>
<table class="content-table">
<form name="postForm" id="postForm" method="post" action="club-setup-addsave.jsp">
<tr height="35"><td colspan="8" class="blocktitle">培训项目</td></tr>
<tr>
	<td align="right">项目名称：</td>
    <td align="left">
		<%=v.getProjectName() %>
	</td>
</tr>
<tr>
<td align="right">负责人：</td>
    <td align="left">
		<%
		if (v.getOtherUniversity()==0) {//校内%>
			<%//=UserCnNameMap.get(v.getHostId()) %>
			<%=v.getHostName() %>&nbsp;&nbsp;
		<%}
		if (v.getOtherUniversity()==1) {//校外%>
			<%=v.getHostName() %>&nbsp;&nbsp;
			学校：<%=v.getAddUseraccount() %>
		<%}
		%>
	</td>
</tr>
<tr>
	<td align="right">时间安排</td>
	<td align="left" colspan="3"><%=Tool.stringOfDate(v.getStartTime()) %>~<%=Tool.stringOfDate(v.getEndTime()) %></td>
</tr>
<tr>
	<td align="right">项目说明</td>
	<td align="left" colspan="3"><%=v.getProjectExplain() %></td>
</tr>
<tr>
	<td align="right">附件</td>
	<td align="left" colspan="3">
	<%
	int caid = v.getId();
	if (!"".equals(v.getAddFileList().trim())) {
		String caids[] = v.getAddFileList().split(",");
		for(int i=0;i<caids.length;i++){
			caid = Tool.StrToInt(caids[i]);
			ClientAttach ca = new ClientAttach();
			if (caid!=-1&&ca.getById(caid)!=null) {
				ca = ca.getById(caid);
	%>
     <a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
     <%=ca.getUploadName() %>
     </a>
		<%}
		}
	}
	%>
	</td>
</tr>
<tr>
	<th onclick="fanhui(<%=currpage %>)"  colspan="4" style="cursor: pointer;">返回</th>
</tr>
</form>
</table>
<!-- <script src="../js/jquery.editable-1.0.1.js"></script> -->
</body>
</html>
