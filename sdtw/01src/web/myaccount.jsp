<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HtmlTool"%>

<%
String password,question1,answer1,truename,sexstr,nickname,birthday,email,mobiltel,homeaddress,hometel,workunit,officetel,fax,officeaddress,school,academy,major,classname;
String userrole,regtime,usergrouplist,accountstate;
ResultSet rs = null;

String[] questions=new String[7];
questions[0]="我最喜欢的运动";
questions[1]="我最难忘的日子";
questions[2]="我最喜欢的人";
questions[3]="我母亲的生日";
questions[4]="我父亲的生日";
questions[5]="我最喜欢的动物";
questions[6]="我最喜欢的水果";

String[] selectedstr=new String[7];
for (int i=0;i<7;i++)
    selectedstr[i]="";

UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
		return;
}else{
	user = userInfo.getUserCode();
	user=user.getById(user.getId());
}
String myaccount=user.getName();
String Password=Tool.decrypt(user.getPwd());
String cssLink="";
if(user.getId()==3){
	cssLink="<link href='css/common-student.css' rel='stylesheet' type='text/css'/>";
}else{
	cssLink="<link href='css/common.css' rel='stylesheet' type='text/css'/>";
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<%=cssLink%>
<script src="js/tablelist.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.2/jquery-1.9.1.js"></script>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="js/nice-validator/dist/jquery.validator.css" type="text/css"/>


<style type="text/css">
span{
	color:red;
}
</style>

<script type="text/javascript">
// 验证数据的合法性，提交表单数据
function mysubmit(){
	var password=document.form1.yuanpassword.value;
	var newpassword1=document.form1.newpassword1.value;
	var newpassword2=document.form1.newpassword2.value;
	var mypassword=document.form1.mypassword.value;
	var account=document.form1.myaccount.value;
	var ok=true;
	
	if(password!=mypassword){
		ok=false;
		alert("原密码错误");
		return;
	}
	if(!newpassword1){
		ok=false;
		alert("新密码不能为空")
		return;
	}
	if(newpassword1!=newpassword2){
		ok=false;
		alert("新密码不一致")
		return;
	}
	if(ok){
		 $.ajax({
				url:"emailCheck.jsp?cmd=modify&user="+account+"&xinmima="+newpassword1,
				type: "post",
				dataType:"json",
				async:false,
				success:function(data){
					if(data.msg=="error"){
						alert("账户不存在");
						
						return;
					}
					if(data.msg=="ok"){
						alert("修改成功，请使用新密码重新登录");
					     
					top.location.href='main/logoff.jsp'
							
					}
					if(data.msg=="no"){
						alert("修改失败")
					}
					
				},
				error: function (error) {
		            alert("信息出错！");
		        }
				
			});
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
<%@ include file="student/pagetop-positionandhelp.jsp" %>

<form  name="form1" action="myaccountsave.jsp" method="post" data-validator-option="{timely:2, theme:'yellow_right_effect'}">
<input type="hidden" name="myaccount" value="<%=myaccount%>">
<input type="hidden" name="mypassword" value="<%=Password%>">
<table class="content-table">
<tr>
	<th colspan="2" align="left">修改密码</th>
</tr>

<tr>
	<td width="45%" align="right"><span>*</span> 输入原密码：</td>
	<td align="left"><input class="text220" type="password" name="yuanpassword" value="" data-rule="password"/></td>
</tr>

<tr>
	<td width="45%" align="right"><span>*</span> 输入新密码：</td>
	<td align="left"><input class="text220" type="password" name="newpassword1" value="" data-rule="password" /></td>
</tr>
<tr>
    
	<td width="45%" align="right"><span>*</span> 重复新密码：</td>
	<td align="left"><input class="text220" type="password" name="newpassword2" value="" data-rule="password" /></td>
</tr>

<tr  height="5px">
	<td  colspan="2"></td>
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
