<!DOCTYPE html>
<%@page import="com.xietong.software.base.SdtwConst"%>
<html>
<%@ page language="java" %>
<%--学生素质拓展培养认证单类型--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.rzd.StudentRzdUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
//默认值定义
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
  	out.print(HtmlTool.msgBox(request, "请先登录"));
  	return;
}
int stuid=userInfo.getId();
String cmd = ParamUtils.getParameter(request, "cmd", "choose");

StudentRzdUtil srUtil=new StudentRzdUtil();
Map rzdTypeMap=srUtil.rzdTypeMap;
Map rzdByTypeMap=srUtil.getPrintRzdByType(stuid);
%>
<head>
	<title><%=request.getAttribute("describe")%></title>
	<link rel="stylesheet" type="text/css" href="../css/common-student.css"/>
	<script src="../../js/tablelist.js"></script> 
	<script src="../js/jquery.min.js"></script> 
<script>
function clickCheckbox(){
	var count=0;
	var a = document.getElementsByName("checkitem");
	for(var i=0;i<a.length;i++) { 
 		if(a[i].checked){ 
			count++;
		}
	}
	document.getElementById("info").innerHTML=count;
}

function printFunc(){
	var a = document.getElementsByName("checkitem");
 	var checkdata=new Array(); //存放申请数据
 	var count=0; //数组行数
	for(var i=0;i<a.length;i++) { 
 		if(a[i].checked){ 
			checkdata[count]=a[i].value;
			count++;
		}
	}
	if(count==0){
		alert("请至少选择一条！");
	}else if(count>50){
		alert("最多选50条！");
	}else{
		window.open("StudentRzdStudent-print.jsp?idlist="+checkdata,"_blank",
					"width=794px,height=1090px,left="+(screen.width-794)*0.5+",top=-20,directories=no,location=0,menubar=no,resizable=no,status=no,titlebar=no,toolbar=no");  
	}
}

function selectAll(){
	var checklist = document.getElementsByName("checkitem");
	if(document.getElementById("checkall").checked){
		for(var i=0;i<checklist.length;i++){
			checklist[i].checked = 1;
		}
		document.getElementById("info").innerHTML=checklist.length; 
	}else{
		for(var j=0;j<checklist.length;j++){
			checklist[j].checked = 0;
		}
		document.getElementById("info").innerHTML=0;
	}
}
</script>
</head>
<body>
<%
String strposition = "组织建设>>五四评比表彰>>";
String strfunction ="学生拓展培养计划认证单";
String strhelpwords = "申请表。";
%>
<%@ include file="/student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
		<a href="StudentRzdStudentList.jsp">返回</a>
		已选<span id="info">0</span>项
		<a href="#" onclick="printFunc()">打印预览</a>
	</td>
</tr>    
</table>

<table class="content-table" >
<tr>
	<th width="10%">全选/取消<input type="checkbox" id="checkall" onclick="selectAll()"/></th>
	<th>组织/活动名称</th>
	<th width="20%">主办/主管/接收单位</th>
	<th width="14%">起止时间</th>
	<th width="14%">成果/经历</th>
</tr>
<% 
for(Iterator it=rzdTypeMap.keySet().iterator();it.hasNext();){
	int type=(Integer)it.next();
	List list=(List<StudentRzd>)rzdByTypeMap.get(type)==null?new ArrayList():(List<StudentRzd>)rzdByTypeMap.get(type);
	
	if(list.size()>0){
%>
	<tr>
		<th><%=rzdTypeMap.get(type)%></th>
		<th colspan="4"></th>
	</tr>
	<%
	for(int i=0;i<list.size();i++){
		StudentRzd v=(StudentRzd)list.get(i);
	%>
		<tr>
			<td><input type="checkbox" name="checkitem" value="<%=v.getId()%>" onclick="clickCheckbox()"></td>
			<td><%=v.getValue1()%></td>
			<td><%=v.getValue2()%></td>
			<td><%=v.getValue3()%></td>
			<td><%=v.getValue4()%></td>
		</tr>
	<%}
	}
}
rzdTypeMap.clear();
rzdByTypeMap.clear();
%>
<tr>
	<th colspan="6" align="left"></th>
</tr>
</table>

</body>
</html>
