<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Member"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 社团申请加入 -->
<%
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}else{
	user = userInfo.getUserCode();
}
Club club = new Club();
int id = ParamUtils.getIntParameter(request,"id",-1);
if(id!=-1&&club.getById(id)!=null){
	club = club.getById(id);
}
List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
List sexOptions = CEditConst.getsexOptions(userInfo,"-1");
List IdentityOptions = CEditConst.getIdentityOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
List cdt = new ArrayList();
cdt.add("academy="+userInfo.getDeptId());
List MajorNameOptions = COptionConst.getMajorNameOptions(userInfo,"-1",cdt);
List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"-1");
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
String cmd = ParamUtils.getParameter(request,"cmd","save");
int MemId = ParamUtils.getIntParameter(request,"MemId",-1);
ClubMembers member = new ClubMembers();
if(MemId!=-1&& member.getById(MemId)!=null){
	member = member.getById(MemId);
	if(!(""+userInfo.getId()).equals(member.getMemberName())){
		member = new ClubMembers();
	}
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script> 
<script src="../js/jquery.min.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
function form1submit(){   
	var MemberPolitics = $('#MemberPolitics').val();
	if (MemberPolitics==""||MemberPolitics=="-1") {
		alert("请选择政治面貌!")
		 $('#MemberPolitics').focus();
		return;
	} 
	var MemberMajor = $('#MemberMajor').val();
	if (MemberMajor==""||MemberMajor=="-1") {
		alert("请选择专业!")
		 $('#MemberMajor').focus();
		return;
	}
	var MemberGrade = $('#MemberGrade').val();
	if (MemberGrade==""||MemberGrade=="-1") {
		alert("请选择年级!")
		 $('#MemberGrade').focus();
		return;
	}
	var MemberBrith = $('#MemberBrith').val();
	if (MemberBrith==""||MemberBrith=="-1") {
		alert("请设置生日!")
		 $('#MemberBrith').focus();
		return;
	}
	var MemberGrade = $('#MemberGrade').val();
	if (MemberGrade==""||MemberGrade=="-1") {
		alert("请设置年级!")
		 $('#MemberGrade').focus();
		return;
	}
	var MemberBirthplace = $('#MemberBirthplace').val();
	if (MemberBirthplace==""||MemberBirthplace=="-1") {
		alert("请录入籍贯!")
		 $('#MemberBirthplace').focus();
		return;
	}
	var MemberPhone = $('#MemberPhone').val();
	var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test(MemberPhone)){
		alert("手机号码格式不正确!")
		 $('#MemberPhone').focus();
		return;
	}
	var MemberEmail = $('#MemberEmail').val();
	var myreg2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg2.test(MemberEmail)){
		alert("邮箱格式不正确!")
		 $('#MemberEmail').focus();
		return;
	}
	var Memberqq = $('#Memberqq').val();
	if (Memberqq == "") {
		alert("请录入QQ！")
		 $('#Memberqq').focus();
		return;
	}
	var Memberwx = $('#Memberwx').val();
	if (Memberwx == "") {
		alert("请录入微信！")
		 $('#Memberwx').focus();
		return;
	}
	var MProfile = $('#MProfile').val();
	if (MProfile == "") {
		alert("请录入个人简介！")
		 $('#MProfile').focus();
		return;
	}
    document.form1.submit();
}
</script>
</head>

<body>
<%
String strposition = "学生社团工作>>社团管理>>";
String strfunction = "申请加入社团";
String strhelpwords = "申请加入社团。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<form name="form1" method="post" action="club-recruitment-addsave.jsp">
<input name="cmd" id="cmd" value="<%=cmd %>" type="hidden"/>
<input name="MemId" id="MemId" value="<%=member.getId()%>" type="hidden"/>
<table class="command-table">
<tr>
    <td>
    <a href="club-all-list.jsp" >
    <!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table>
<table class="content-table">
<tr height="35"><th colspan="8" align="center">申请加入社团</th></tr>
<tr>
	<td  align="right" width="15%">&nbsp;<font color="red">*&nbsp;</font>社团名称：</td>
	<td align="left" width="35%"><%=club.getClubName() %>
	<%=HtmlTool.renderSelect(ClubNameOptions,""+club.getId(),"MemberClubname","-1",true) %>
	</td>
	<td  align="right" width="15%">&nbsp;<font color="red">*&nbsp;</font>社团编号：</td>
     <td align="left"><%=club.getClubId() %><input type="hidden" name="ClubId" id="ClubId" value="<%=club.getClubId()%>"></td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>学生姓名：</td>
    <td align="left"><%=HtmlTool.renderSelect(UserCnNameOptions,""+user.getId(),"MemberName","-1",true) %></td>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>学号：</td>
     <td align="left"><%=user.getName() %><input type="hidden" name="MemberSno" value="<%=user.getName()%>"></td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>所在学院：</td>
    <td align="left"><%=HtmlTool.renderSelect(AcademyNameOptions,""+user.getDeptId(),"MemberAcademy","-1",true) %></td>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>性别：</td>
     <td align="left">
	<%=HtmlTool.renderSelect(sexOptions,""+user.getGender(),"MemberSex","-1",true) %>
	</td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>学生身份：</td>
     <td align="left">
     		<%=HtmlTool.renderSelect(IdentityOptions,member.getIdentity(),"Identity","0",true) %>
     </td>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>政治面貌：</td>
     <td align="left">
     		<%=HtmlTool.renderSelect(PoliticsNameOptions,member.getMemberPolitics(),"MemberPolitics","-1") %>
     </td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>专业：</td>
     <td align="left">
     		<%=HtmlTool.renderSelect(MajorNameOptions,member.getMemberMajor(),"MemberMajor","-1") %>
     </td>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>生日：</td>
     <td align="left">
     		<input value="<%=member.getMemberBrith()%>" readonly class="date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  name="MemberBrith" id="MemberBrith" size="0">
     </td>
</tr>
<tr>
	
     <td  align="right">&nbsp;<font color="red">*&nbsp;</font>年级：</td>
     <td align="left">
     		<%=HtmlTool.renderSelect(GradeNameOptions,member.getMemberGrade(),"MemberGrade","-1") %>
     </td>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>籍贯：</td>
     <td align="left">
     		<input name="MemberBirthplace" id="MemberBirthplace" maxsize="50" value="<%=member.getMemberBirthplace()%>">
     </td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>联系方式：</td>
	<td colspan="3" valign="top" style="padding: 0px;">
     <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="font-size: 12px;">
     <tr>
	     <td align="left"style="padding: 0px;">
	 	    手机&nbsp;&nbsp;
	     <input id="MemberPhone" name="MemberPhone" value="<%=member.getMemberPhone()%>"/>
	     </td>
     
	     <td align="left"style="padding: 0px;">
	     QQ&nbsp;&nbsp;
	     <input id="Memberqq" name="Memberqq" value="<%=member.getMemberqq()%>"/>
	     </td>
  	 </tr>
  	  <tr>
     <td align="left"style="padding: 0px;">
    	 微信&nbsp;&nbsp;
     <input id="Memberwx" name="Memberwx" value="<%=member.getMemberwx()%>"/>
     </td>
     <td align="left"style="padding: 0px;">
    	邮箱&nbsp;&nbsp;
     <input id="MemberEmail" name="MemberEmail" value="<%=member.getMemberEmail()%>"/>
     </td>
</tr>
     </table>
     </td>
   </tr>
  
  
<tr height="170">
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>个人简介：</td>
	<td align="left"colspan="3"><textarea name="MProfile" id="MProfile" maxlength="500" cols="100" rows="10"><%=member.getMProfile() %></textarea></td>
</tr>
<tr height="170">
	<td  align="right">社团工作经历：</td>
	<td align="left"colspan="3"><textarea name="MExperience" id="MExperience" maxlength="500" cols="100" rows="10"><%=member.getMExperience() %></textarea></td>
</tr>
<tr height="60">
     <td  align="right">&nbsp;备注：</td>
     <td align="left" colspan="3"><textarea name="Remark" id="Remark" maxlength="500" cols="100"  rows="3"><%=member.getRemark() %></textarea></td>
</tr>
<tr height="45">
    <th  colspan="4" align="center">
    <%
    if("viewlist".equals(cmd)){%>
    	<a href="club-all-list.jsp" >返回</a>
    <%}else{%>
        <input type="button" value="提交申请" name="btn1" onclick="form1submit()"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="取消" name="btn2" onclick="history.go(-1)"/>&nbsp;&nbsp;&nbsp;
    <%}
    %>
    </th>
</tr>          
</form>
</table>
</body>
</html>
