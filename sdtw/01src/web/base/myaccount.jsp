<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 学生用户 -->
<!-- <link href='css/common-student.css' rel='stylesheet' type='text/css'/> -->
<!-- 管理用户 -->
<link href='../css/common.css' rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="../js/nice-validator/dist/jquery.validator.css" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/nice-validator/dist/jquery.validator.js?local=zh-CN" type="text/javascript" charset="utf-8"></script>

<style type="text/css">
span{
	color:red;
}
</style>

<script type="text/javascript">
// 验证数据的合法性，提交表单数据
function mysubmit(){
	var newpassword1=document.form1.newpassword1.value;
	var newpassword2=document.form1.newpassword2.value;
	if(newpassword1==newpassword2){
		document.form1.submit();
	}else{
		alert("两次密码输入不一致！");
	}
	
}

</script>
</head>
<body>
<script type="text/javascript">
$("form").validator({
    timely:2,
});
</script>
<%
String strposition = "基本信息  >> 修改密码";
String strfunction = "";
String strhelpwords= "我的账户信息。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr height="35px">
   <td>
   		<a></a>
   </td>
</tr>
</table>
<form  name="form1" action="myaccountsave.jsp" method="post" data-validator-option="{timely:2, theme:'yellow_right_effect'}">
<input type="hidden" name="myaccount" value="<%//=myaccount%>">

<table class="content-table">
<tr>
	<th colspan="2" align="left">修改密码</th>
</tr>

<tr>
	<td width="30%" align="right"><span>*</span> 输入原密码：</td>
	<td align="left"><input class="text220" type="password" name="yuanpassword" value="" data-rule="password"/></td>
</tr>

<tr>
	<td width="20%" align="right"><span>*</span> 输入新密码：</td>
	<td align="left"><input class="text220" type="password" name="newpassword1" value="" data-rule="password" /></td>
</tr>
<tr>
	<td width="20%" align="right"><span>*</span> 重复新密码：</td>
	<td align="left"><input class="text220" type="password" name="newpassword2" value="" data-rule="password" /></td>
</tr>

<tr  height="5px">
	<td  colspan="2"></td>
</tr>

<tr>
	<td align="right"><span>*</span> 密码查询问题：</td>
	<td align="left">
		  <%--  <select name="question1" data-rule="required;nonhtml;">
			  <option value="<%=questions[0]%>" selected><%=questions[0]%></option>
			  <option value="<%=questions[1]%>"><%=questions[1]%></option>
			  <option value="<%=questions[2]%>"><%=questions[2]%></option>
			  <option value="<%=questions[3]%>"><%=questions[3]%></option>
			  <option value="<%=questions[4]%>"><%=questions[4]%></option>
			  <option value="<%=questions[5]%>"><%=questions[5]%></option>
			  <option value="<%=questions[6]%>"><%=questions[6]%></option>
		   </select> --%>
	</td>
</tr>
<tr>
	<td align="right"><span>*</span> 答案：</td>
	<td align="left"><input class="text220" type="text" name="answer1" value="" data-rule="required;nonhtml;"/></td>
</tr>

<tr>
   <th colspan="2">
	<input class="button" type="button" value="保存" onclick="mysubmit()">&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="button" type="reset" value="放弃 "  onclick="mycancel()">
   </th>
</tr>

</table>
</form>

</body>
</html>
