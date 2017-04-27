<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.rzd.StudentRzdUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
String cmd = ParamUtils.getParameter(request, "cmd", "list");
int currpage = ParamUtils.getIntParameter(request, "page", 1);

//默认值定义
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
   		out.print(HtmlTool.msgBox(request, "请先登录"));
   		return;
}

StudentRzdUtil srUtil=new StudentRzdUtil();
int stuid=userInfo.getId();

//打印记录
List list=srUtil.getStudentRzdStateList(stuid);
%>
<head>
	<title>学生拓展培养计划认证单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<jsp:include page="/main/jqueryui.jsp" flush="true" />
	<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="../css/common-student.css"/>
	<script src="../js/tablelist.js"></script>
	<script>
	function actionFunc(id,obj){
		if(confirm("确定删除此条信息吗？")){
			$.ajax({
				type:"post",			
				url:"StudentRzdStudentAction.jsp?cmd=deletestate&id="+id,
				dataType:"json",
				success:function(data){
					alert(data.msg);
				},
				error:function(data){
					alert("操作失败");	
				}
			});
			//将此行删除
			obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
		}
	}
	
	function viewFunc(stateid){
		window.open("StudentRzdStudent-print.jsp?cmd=view&stateid="+stateid,"_blank",
					"width=794px,height=1090px,left="+(screen.width-794)*0.5+",top=-20,directories=no,location=0,menubar=no,resizable=no,status=no,titlebar=no,toolbar=no");
	}
	</script>
</head>
<body>
<%
String strposition = "组织建设>>五四评比表彰>>";
String strfunction ="学生拓展培养计划认证单打印记录";
String strhelpwords = "申请表。";
%>
<%@ include file="/student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
		<a href="StudentRzdStudentList.jsp">返回</a>
	</td>
</tr>    
</table>

<table class="content-table">
<tr>
	<th width="8%">序号</th>
	<th width="35%">打印时间</th>
	<th width="35%">打印编号</th>
	<th>操作</th>
</tr>
<%
	if(list.size()>0){
	for(int i=0;i<list.size();i++){
		StudentRzdState srs=(StudentRzdState)list.get(i);
		int id=srs.getId();
%>
		<tr>
			<td><%=i+1%></td>
			<td><%=srs.getPrintTime()%></td>
			<td><%=srs.getPrintcode()%></td>
			<td>
			<%-- <a href="#" onclick="actionFunc('<%=id%>',this)">删除</a> --%>
				<a href="#" onclick="viewFunc('<%=id%>')">查看</a>
			</td>
		</tr>
	<%}%>
		<tr>
			<th colspan="4"></th>
		</tr>
<%}else{%>
	<tr>
		<td colspan="4">无信息！</td>
	</tr>
<%}%>
</table>
</body>
</html>
