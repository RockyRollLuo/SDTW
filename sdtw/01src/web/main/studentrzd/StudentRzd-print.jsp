<!DOCTYPE html>
<%@ page import="com.xietong.software.base.SdtwConst"%>
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
//
String cmd = ParamUtils.getParameter(request, "cmd", "choose");
int stateid=ParamUtils.getIntParameter(request, "stateid",-1);
StudentRzdState srs=new StudentRzdState();
srs =srs.getById(stateid);
String idlist=srs.getIdlist();
System.out.println("---------idlist:"+idlist+"---------");
String printtime=srs.getPrintTime().substring(0, 10);
String printcode=srs.getPrintcode();
int stuid=srs.getStuid();

Map academyMap=CEditConst.getAcademyNameMap(userInfo);
Map polistaMap=CEditConst.getPoliticsNameMap(userInfo);
Map majorMap=CEditConst.getMajorNameMap(userInfo);
Map gradeMap=CEditConst.getGradeNameMap(userInfo);
//学生基本信息
BaseUserCode student=new BaseUserCode();
student=student.getById(stuid);
String myName=student.getCnName();
String myStuno=student.getName();
String myPolista=(String)polistaMap.get(student.getMemberPolitics())==null?"":(String)polistaMap.get(student.getMemberPolitics());
String myAcademy=(String)academyMap.get(""+student.getDeptId());
String myMajor=(String)majorMap.get(student.getMajor())==null?"":(String)majorMap.get(student.getMajor());
String myGrade=(String)gradeMap.get(student.getGrade())==null?"":(String)gradeMap.get(student.getGrade());

//认证单类型map，选定的打印map
StudentRzdUtil srUtil=new StudentRzdUtil();
Map rzdTypeMap=srUtil.rzdTypeMap;
Map rzdPrintMap=srUtil.getPrintRzdByType(idlist,stuid);
%>
<html>
<head>
	<title>学生素质拓展培养认证单</title>
	<script src="../js/jquery.min.js"></script> 
<script>
//点击打印按钮后，更新state表
function printFunc(){
	printFunc2();	
}

function printFunc2(){
	var headstr = "<html><head><title></title></head><body>";
	var footstr = "</body>";
	var newstr = document.all.item("printdiv").innerHTML;
	var oldstr = document.body.innerHTML;
	document.body.innerHTML = headstr+newstr+footstr;
	window.print(); 
	document.body.innerHTML = oldstr;
	return false;
}
</script>
<style type="text/css">
#title1{
	font-size:18pt;
	font-family:楷体;
	font-weight:bold;

}
#title2{
	font-size:9.0pt;
	font-family:宋体;
	font-weight:bold;
}
.table1{
	width:100%;
	margin:0 auto;
	font-size:10pt;
	text-align:center;
}
.table2{
	font-size:9pt;
	font-family:宋体;
  	border-collapse:collapse;
	border-left:2px solid #000;
	border-right:2px solid #000;
	width:100%;
	margin:0 auto;
	text-align:center;
}
.table2 td{
	border:1px solid #000;
}
.table21{
	border-top:2px solid #000;
	border-bottom:0;
}
.table22{
	border-top:1px solid #000;
	border-bottom:2px solid #000;
}
</style>
</head>
<body>
<div align="center"><button onclick="printFunc()">打印</button></div>
<div id="printdiv">
<table>
<tr height="60px">
<!-- 	<td align="center"><img width="212" height="85" src="images/sddx.jpg"/></td> -->
<!-- 	<td align="center"> -->
<!-- 		<p id="title1">学生拓展培养计划认证单</p> -->
<!-- 		<p id="title2">The Certification List of Student Quality Development Program</p> -->
<!-- 	</td> -->
</tr>
</table>
<table class="table2 table21">
<tr>
	<td width="11%">姓名</td><td width="22%"><%=myName%></td>
	<td width="11%">学号</td><td><%=myStuno%></td>
	<td width="11%">政治面貌</td><td width="22%"><%=myPolista%></td>
</tr>
<tr>
	<td>学院</td><td><%=myAcademy%></td>
	<td>专业</td><td><%=myMajor%></td>
	<td>年级</td><td><%=myGrade%></td>
</tr>
</table>

<table class="table2 table22" >
<tr>
	<td width="11%">类型</td>
	<td>组织/活动名称</td>
	<td width="20%">主办/主管/接收单位</td>
	<td width="15%">起止时间</td>
	<td width="13%">成果/经历</td>
</tr>
<% 
for(Iterator it=rzdPrintMap.keySet().iterator();it.hasNext();){
	int type=(Integer)it.next();
	List list=(List<StudentRzd>)rzdPrintMap.get(type);
	
	if(list.size()>0){
	//---------------------只有一行的情况-----------------------------
		StudentRzd v1=(StudentRzd)list.get(0);
%>
	<tr>
		<td rowspan="<%=list.size()%>"><%=rzdTypeMap.get(type)%></td>
		<td><%=v1.getValue1()%></td>
		<td><%=v1.getValue2()%></td>
		<td><%=v1.getValue3()%></td>
		<td><%=v1.getValue4()%></td>
	</tr>
	<%
	//---------------------两行及以上--------------------------------
	}if(list.size()>1){
		for(int i=1;i<list.size();i++){
			StudentRzd v2=(StudentRzd)list.get(i);
	%>
			<tr>
				<td><%=v2.getValue1()%></td>
				<td><%=v2.getValue2()%></td>
				<td><%=v2.getValue3()%></td>
				<td><%=v2.getValue4()%></td>
			</tr>
	<%	}//end for(i)
	}
}//end for(it)
rzdTypeMap.clear();
rzdPrintMap.clear();
%>
</table>
<table class="table1">
<tr>
	<td width="50%" align="center">打印日期：<%=printtime%></td>
	<td width="50%" align="center">打印编号：<%=printcode%></td>
</tr>
</table>
</div>

</body>
</html>