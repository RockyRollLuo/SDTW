<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
Students student=new Students();
BaseUserCode user = new BaseUserCode();
Map xueyuanmap=CEditConst.getAcademyNameMap(userInfo);
Map nianjimap=CEditConst.getGradeNameMap(userInfo);
Map majormap=CEditConst.getMajorNameMap(userInfo);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
		return;
}else{
	user = user.getById(userInfo.getId());
}
List cdt = new ArrayList();
List list = new ArrayList();
String sname="",sex="",sacademy="",timetoschool="",timetotuan="",birthday="",email="",zhibu="",nation="",major="",lenofschool="",grade="",polista="",nativeplace="",IDNum="",phone="";
String addfilelist="";
String useraccount=user.getCode();
System.out.println(useraccount);
cdt.add("sno='"+useraccount+"'");
list=student.query(cdt);
if(list.size()==1){
	 student=(Students)list.get(0);	
	 sname=student.getSName();
	 sex=student.getSSex()=="1"?"女":"男";
	 sacademy=student.getSacademy();
	 timetoschool=Tool.stringOfCnDate(student.getTimeToSchool());
	 timetotuan=Tool.stringOfCnDate(student.getTimeToTuan());
	 birthday=Tool.stringOfCnDate(student.getBirthday());
	 email=student.getEmail();
	 zhibu=student.getZhiBu();
	 major=student.getMajor();
	 grade=student.getGrade();
	 polista=student.getPolista();
	 phone=student.getPhone();
	 
}else{
	
}


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common-student.css">
<script src="js/tablelist.js"></script> 
<script src="js/jquery.min.js"></script> 


<script type="text/javascript">
function submit(){
	if(check()){
	document.form1.submit();
	}
}
function check(){
	if (document.form1.Email.value==""){
		alert("邮箱不能为空！");
		document.form1.Email.focus();
		return false;
	}
	if (document.form1.MobilePhone.value==""){
		alert("手机号码不能为空！");
		document.form1.MobilePhone.focus();
		return false;
	}
	var myreg3=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	var myreg1 = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var myreg2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
if (!myreg1.test(document.form1.MobilePhone.value)){
		
		alert("手机号码不合法");
		document.form1.MobilePhone.focus();
		return false;
	}
if (!myreg2.test(document.form1.Email.value)){
	
	alert("邮箱不合法！");
	document.form1.Email.focus();
	return false;
}
return true;
}
</script>
</head>

<body>
<%
String strposition = "个人基本信息>>";
String strfunction = "学生信息";
String strhelpwords = "学生信息。";

%>
<%@ include file="student/pagetop-positionandhelp.jsp" %>

<form  name ="form1" action="BaseUserCodeAction.jsp"  method="post">
<input type="hidden" name="Id" value="<%=user.getId()%>"/>
<input type="hidden" name="cmd" value="modify"/>
<table class="content-table">
<tr>
	<th colspan="10" align="left">学生基本信息</th>
</tr>
<tr>
   <td width="15%" align="right" >学号:</td>
    <td width="15%" align="left"  ><%=user.getName() %></td>
	<td width="15%" align="right" >姓名:</td>
    <td  width="15%" align="left"  ><%=user.getCnName() %></td>
    <td width="15%" align="right">性别:</td>
    <td  width="15%"align="left"><%=user.getGender()==0?'男':'女'%></td>

</tr>    
<tr>
<td align="right">学院:</td>
    <td align="left"><%=(String)xueyuanmap.get(user.getDeptId()+"")==null?"":(String)xueyuanmap.get(user.getDeptId()+"")%></td>
    
    <td align="right" >年级:</td>
    <td align="left" ><%=(String)nianjimap.get(user.getGrade())==null?"":(String)nianjimap.get(user.getGrade())%></td>
  <td align="right" >专业:</td>
    <td align="left"  ><%=majormap.get(user.getMajor())%></td>
    
    
  
</tr>

<tr>
    <td align="right" >邮箱:</td>
    <td align="left"  ><input type="text" name="Email"  size="15" value="<%=user.getEmail() %>"/></td>
    
    <td align="right" >手机:</td>
    <td align="left"  ><input type="text" name="MobilePhone" size="15" value="<%=user.getMobilePhone() %>"/></td>

</tr>


<tr>
	<th colspan="13" align="center"><a href="#" onclick="submit();">修改</a></th>
</tr> 
</table>
</form>
</body>
</html>
