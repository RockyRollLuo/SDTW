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

String cmd = ParamUtils.getParameter(request, "cmd", "create");
int id = ParamUtils.getIntParameter(request, "id", -1);
int tabActive=ParamUtils.getIntParameter(request, "tabActive", -1);
StudentRzdUtil srUtil=new StudentRzdUtil();

StudentRzd v=new StudentRzd();
if("update".equals(cmd)||"view".equals(cmd)){//修改
	v=v.getById(id);
}

//rzd类型
List StudentRzdTypeNameoptions=CEditConst.getStudentRzdTypeNameOptions(userInfo);
Map checkMap=srUtil.getCheckMap();

%>
<head>
	<title><%=request.getAttribute("describe")%></title>
	<link rel="stylesheet" type="text/css" href="../css/common-student.css"/>
	<script src="../../js/tablelist.js"></script> 
	<script src="../js/jquery.min.js"></script> 
	<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
	<script>
	function ShowMessage(){ 
		var cmdStr='<%=cmd%>'; 
		if(cmdStr=='view'){
			var controls = document.getElementsByTagName("input");
  			for(var i=0; i<controls.length; i++){
   				controls[i].setAttribute('disabled','disabled');
   			}
		}
	} 
	window.load=ShowMessage(); 
	
	function doValidate(){
		var alltime="";
		var starttime= $("#Starttime").val();
		var endtime=$("#Endtime").val();
		if(starttime!=null&&endtime!=null)
			alltime=starttime+"-"+endtime;
		if(starttime!=null&&(endtime==null||endtime==""))	
			alltime=starttime;
		document.postForm.Value3.value=alltime;
		
		var value1=$("#Value1").val();
		var value2=$("#Value2").val();
		var value3=$("#Value3").val();
		var value4=$("#Value4").val();
		if(value1==""){
			$("#Value1").focus();
			alert("请输入活动名称!");
			return;
		}
		if(value1!=""){
			if(value1.length>22){
				$("#Value1").focus();
				alert("不能超过22个字！");
				return;
			}
		}
		
		if(value3!=""){
			var reg=/^(^\d{4}\.\d{2}$)|(^\d{4}\.\d{2}\-\d{4}\.\d{2}$)$/;
			if(!reg.test(value3)){
				$("#Value3").focus();
				alert("日期格式:yyyy.mm或yyyy.mm-yyyy.mm");
				return;
			}	
		}
		$("#postForm").submit(); 
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
	<td><a href="StudentRzdStudentList.jsp?tabActive=<%=tabActive%>">返回</a></td>
</tr>    
</table>
<form action="StudentRzdStudentAction.jsp" method="post" name="postForm" id="postForm">
	<input type="hidden" name="cmd" value="<%=cmd%>"/>
	<input type="hidden" name="Id" value="<%=v.getId()%>"/>
	<input type="hidden" name="Deptid" value="<%=v.getDeptid()%>"/>
	<input type="hidden" name="ActivityId" value="<%=v.getActivityId()%>"/>
	<%if("create".equals(cmd)){%>
	 	<input type="hidden" name="Modifyflag" id="Modifyflag" value="<%=SdtwConst.RZDMODIFY_WTJ%>"/>
	<%}else{%>
	 	<input type="hidden" name="Modifyflag" id="Modifyflag" value="<%=v.getModifyflag()%>"/>
	<%}%>
 	
	<table class="content-table" >
	<tr>
		<th colspan="2"></th>
	</tr>
	<tr>
		<td align="right">类别</td>
		<td align="left">
			<%=HtmlTool.renderSelect(StudentRzdTypeNameoptions, "" + v.getType(), "Type", "-1")%>
		</td>
	</tr>
	<%if(!"create".equals(cmd)){//只要不是添加，都有%>
 	<tr>
 		<td align="right">审核标志</td>
		<td align="left">
 			<input type="hidden" name="Checkflag" id="Checkflag" value="<%=v.getCheckflag()%>" />
 			<%=checkMap.get(v.getCheckflag())%>
 		</td>
	</tr>
 	<tr>
 		<td align="right">审核原因</td>
		<td align="left">
 			<textarea name="Checkreason" id="Checkreason" cols="60" rows="2"><%=v.getCheckreason()%></textarea>
 		</td>
	</tr>
	<%}%>
 	<tr>
 		<td align="right">组织/活动名称</td>
		<td align="left">
 			<input name="Value1" id="Value1" size="45" maxsize="45" value="<%=v.getValue1()%>"/>
 		</td>
	</tr>
 	<tr>
		<td align="right">主办/主管/接收单位</td>
		<td align="left">
 		<input name="Value2" id="Value2" size="45" maxsize="45" value="<%=v.getValue2()%>" list="type_list"/>
 			</td>
	</tr>
 	<tr>
 		<td align="right">起止时间</td>
		<td align="left">
			<input type="hidden" name="Value3" id="Value3" value="<%=v.getValue3()%>"/>
			<%
			String alltime=v.getValue3();
			String starttime="",endtime="";
			if(alltime.length()>0) starttime=alltime.substring(0,7);
			if(alltime.length()>7) endtime=alltime.substring(8);
 			%>
 			<input class="date" name="Starttime" id="Starttime" size="0" value="<%=starttime%>" readonly onclick="WdatePicker({el:'Starttime',dateFmt:'yyyy.MM',startDate: '%y.%M',onpicked:function(){}})" >-
 			<input class="date" name="Endtime"  id="Endtime" size="0" value="<%=endtime%>" readonly onclick="WdatePicker({dateFmt:'yyyy.MM',minDate:'#F{$dp.$D(\'Starttime\')',onpicked:function(){}})" />
 			格式：yyyy.mm或yyyy.mm-yyyy.mm
 		</td>
	</tr>
 	<tr>
 		<td align="right">成果/经历</td>
		<td align="left">
 			<input name="Value4" id="Value4" size="45" maxsize="45" value="<%=v.getValue4()%>" list="type_list2"/>
 		</td>
	</tr>
	<tr>
		<th colspan="2">
		<%if("create".equals(cmd)||"update".equals(cmd)){%>
	        <input type="button" class="button" value="保存" name="btn1" onclick="javascript:doValidate();"/>&nbsp;&nbsp;&nbsp;
	    <%}else{%>
	    	<a href="#" onclick="history.go(-1)" >返回</a>
	    <%}%>
		</th>
	</tr>
	
 	</table>
</form>

<datalist id="type_list2">
<option label="特等奖" value="特等奖"/>
<option label="一等奖" value="一等奖"/>
<option label="二等奖" value="二等奖"/>
<option label="三等奖" value="三等奖"/>
<option label="金奖" value="金奖"/>
<option label="银奖" value="银奖"/>
<option label="铜奖" value="铜奖"/>
<option label="优秀奖" value="优秀奖"/>
<option label="参与" value="参与"/>
<option label="发明专利" value="发明专利"/>
<option label="实用新型专利" value="实用新型专利"/>
<option label="外观设计专利" value="外观设计专利"/>
<option label="志愿者" value="志愿者"/>
<option label="负责人" value="负责人"/>
<option label="校级优秀团队(队长)" value="校级优秀团队(队长)"/>
<option label="校级优秀团队(队员)" value="校级优秀团队(队员)"/>
</datalist>
<datalist id="type_list">
<option label="校团委" value="校团委"/>
<option label="学工部" value="学工部"/>
<option label="研工部" value="研工部"/>
<option label="本科生院" value="本科生院"/>
<option label="研究生院" value="研究生院"/>
<option label="就业指导中心" value="就业指导中心"/>
<option label="宣传部" value="宣传部"/>
<option label="学院" value="学院名称"/>
</datalist>
	</body>
</html>
