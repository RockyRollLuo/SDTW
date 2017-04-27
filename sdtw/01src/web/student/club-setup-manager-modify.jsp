<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"-1");
List MemberDutyOptions = CEditConst.getMemberDutyOptions(userInfo,"-1");
List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
List MajorNameOptions = CEditConst.getMajorNameOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
List sexOptions = CEditConst.getsexOptions(userInfo,"-1");
List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
//MemberName==mlist.get(j)&MemberClubname
String cmd = ParamUtils.getParameter(request,"cmd","");
int MemberClubname = ParamUtils.getIntParameter(request,"MemberClubname",-1);//社团id
int MemberName = ParamUtils.getIntParameter(request,"MemberName",-1);
ClubMembers members = new ClubMembers();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("MemberClubname="+MemberClubname);
cdt.add("MemberName="+MemberName);
list = members.query(cdt);
if(list.size()>0){
	members = (ClubMembers)list.get(0);
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../main/js/common.js"></script>
<script src="../main/js/datepicker/WdatePicker.js"></script>
<style type="text/css">
.blocktitle{
	font-size:large;
	font-weight:bold;
}
.labelon {
    background-image:url("../images/work/labelover.jpg");
    font-size:14px;
    cursor: hand; 
}
.labeloff {
    background-image:url('../images/work/labeloff.jpg'); 
    font-size:13px;
    cursor: hand; 
}
</style>
<script type="text/javascript">
function formsubmit(num){
	var formname=document.getElementById("formpost");
	if (formname.MemberSex.value==""){
  		alert("性别不能为空！");
  		formname.MemberSex.focus();
    	return false;
	}
	if (formname.MemberBrith.value==""){
  		alert("出生年月不能为空！");
  		formname.MemberBrith.focus();
    	return false;
	}
	if (formname.MemberPolitics.value==""){
 		alert("政治面貌不能为空！");
  		formname.MemberPolitics.focus();
    	return false;
	}
	if (formname.MemberBirthplace.value==""){
 		alert("籍贯不能为空！");
  		formname.MemberBirthplace.focus();
    	return false;
 	}
	if (formname.MemberPhone.value==""){
  		alert("手机不能为空！");
  		formname.MemberPhone.focus();
    	return false;
 	}
	var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test(formname.MemberPhone.value)){
		alert("手机号码格式不正确!")
		 formname.MemberPhone.focus();
		return;
	}
	/* formname.managerDuty_final.value = $("select[name='managerDuty']").val();
	 if(formname.managerDuty && formname.managerDuty.value=="其他"){
		 formname.managerDuty_final.value = "其他-" + $("input[name='managerDuty_other']").val();
	 } */
	if (formname.MemberAcademy.value==""){
  		alert("学院不能为空！");
  		formname.MemberAcademy.focus();
    	return false;
 	}
	if (formname.MemberMajor.value==""){
  		alert("专业不能为空！");
  		formname.MemberMajor.focus();
    	return false;
 	}
	if (formname.MemberGrade.value==""){
  		alert("年级不能为空！");
  		formname.MemberGrade.focus();
    	return false;
 	}
	if (formname.MemberEmail.value==""){
  		alert("E-mail不能为空！");
  		formname.MemberEmail.focus();
    	return false;
 	}
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!myreg.test(formname.MemberEmail.value)){
    	formname.MemberEmail.focus();
    	alert("邮箱格式不正确！");
    	return;
	 }
	if (formname.Memberqq.value==""){
  		alert("QQ不能为空！");
  		formname.Memberqq.focus();
    	return false;
 	}
	if (formname.Memberwx.value==""){
  		alert("微信不能为空！");
  		formname.Memberwx.focus();
    	return false;
 	}

	if (formname.MProfile.value==""){
  		alert("个人简介不能为空！");
  		formname.MProfile.focus();
    	return false;
 	}
 	if (formname.MExperience.value==""){
  		alert("社团工作经历不能为空！");
  		formname.MExperience.focus();
    	return false;
 	}
	
    //提交表单数据,包括disabled的输入域
    var len=formname.elements.length;
    var i;
    for (i=0;i<len;i++){
         formname.elements[i].disabled = false;
    } 
    formname.submit();
    return true;
}

//图层置为空，类似隐藏了图层
function selectlabel(num){
   $("span[name='label']").each(function(){
      $(this).removeClass();
      $(this).addClass("labeloff");
      });
   $("tbody[name='content']").each(function(){
      $(this).hide();
      });
   $("span[name='label']").eq(num).removeClass();
   $("span[name='label']").eq(num).addClass("labelon");
   $("tbody[name='content']").eq(num).show();
}

function addSponsor(){
	openWindow("BaseUserCodeAction.jsp?cmd=stuSponsor&values="+$('#MemberName').val(),"703,400");
}
function setRole(reId,MemberSno,MemberName,MemberSex,MemberBrith,MemberPolitics,MemberBirthplace,MemberAcademy,MemberGrade,MemberMajor,MemberPhone,Memberqq,MemberEmail,Memberwx){
	//window.opener.setRole(MemberSno,MemberName,MemberSex,MemberBrith,MemberPolitics,MemberBirthplace,MemberAcademy);
	$('#MemberName').val(reId);
	$('#MemberSno').val(MemberSno);
	$('#MemberNameShow').val(MemberName);
	$('#MemberSex').val(MemberSex);
	$('#MemberBrith').val(MemberBrith);
	$('#MemberPolitics').val(MemberPolitics);
	$('#MemberBirthplace').val(MemberBirthplace)
	$('#MemberAcademy').val(MemberAcademy);
	$('#MemberGrade').val(MemberGrade);
	$('#MemberMajor').val(MemberMajor);
	$('#MemberPhone').val(MemberPhone);
	$('#Memberqq').val(Memberqq);
	$('#MemberEmail').val(MemberEmail);
	$('#Memberwx').val(Memberwx);
}
</script>
</head>



<body>
<%
String strposition = "学生社团工作 >> 社团成立申请 >> ";
String strfunction = "添加学生社团负责人";
String strhelpwords = "添加学生社团负责人。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td><a href="#" onclick="history.go(-1)" ><!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table>

<table class="content-table">
<tr height="35"><td colspan="8" class="blocktitle">学生社团负责人情况登记表</td></tr>
<tbody name="content">
<form name="formpost" id="formpost" method="post" action="club-setup-manager-addsave.jsp">
<input id="Id" name="Id" value="<%=members.getId()%>" type="hidden"/>
<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>"/>
<tr>
	<td align="right" width="10%">&nbsp;<font color="red">*&nbsp;</font>学号：</td>
    <td align="left" colspan="5">
    <input type="text" name="MemberSno" id="MemberSno" value="<%=members.getMemberSno() %>" />
    <a href="#" class='add_btn' onclick="addSponsor();">添加</a></td>
</tr>
<tr>
	<td align="right" width="10%">&nbsp;<font color="red">*&nbsp;</font>姓名：</td>
    <td align="left" width="25%">
    <span><input readonly="readonly" id="MemberNameShow" name="MemberNameShow" value="<%=UserCnNameMap.get(""+members.getMemberName())==null?"":UserCnNameMap.get(""+members.getMemberName())%>"/></span>
   <%-- <%=HtmlTool.renderSelect(UserCnNameOptions,""+members.getMemberName(),"MemberName","") %> --%>
   <input id="MemberName" name="MemberName" value="<%=members.getMemberName()%>" type="hidden"/>
    <input type="hidden" name="MemberName" id="MemberName"  maxlength="45" size="30"></td>
    <td  align="right" width="10%">&nbsp;<font color="red">*&nbsp;</font>性别：</td>
     <td align="left" width="25%">
     <%=HtmlTool.renderSelect(sexOptions,""+members.getMemberSex(),"MemberSex","") %>
     </td>
    <td  align="right" width="10%">&nbsp;<font color="red">*&nbsp;</font>出生年月：</td>
     <td align="left">
     <input readonly class= "date" name ="MemberBrith" id= "MemberBrith" onfocus="WdatePicker({el:'MemberBrith',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size= "0" value="<%=members.getMemberBrith()%>"/>
     </td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>政治面貌：</td>
    <td align="left">
    <%=HtmlTool.renderSelect(PoliticsNameOptions,""+members.getMemberPolitics(),"MemberPolitics","") %>
    </td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>籍贯：</td>
     <td align="left" colspan="3"><input type="text" name="MemberBirthplace" id="MemberBirthplace"  maxlength="50" size="30" value="<%=members.getMemberBirthplace()%>"></td>
</tr>
<tr>
	<td align="right">&nbsp;所在社团：</td>
    <td align="left">
    <%=HtmlTool.renderSelect(ClubNameOptions,members.getMemberClubname(),"MemberClubname",""+MemberClubname,true) %>
    </td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>职务：</td>
     <td align="left"  colspan="3">
     <%=HtmlTool.renderSelect(MemberDutyOptions,""+members.getMemberDuty(),"MemberDuty","") %>
     </td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>学院：</td>
    <td align="left">
    <%=HtmlTool.renderSelect(AcademyNameOptions,""+members.getMemberAcademy(),"MemberAcademy","") %>
    </td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>专业：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(MajorNameOptions,""+members.getMemberMajor(),"MemberMajor","") %>
     </td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>年级：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(GradeNameOptions,""+members.getMemberGrade(),"MemberGrade","") %>
     </td>
</tr>
<tr>
	<td align="right" rowspan="2">&nbsp;<font color="red">*&nbsp;</font>联系方式：</td>
	<td align="left">&nbsp;<font color="red">*&nbsp;</font>手机：
	<input type="text" name="MemberPhone" id="MemberPhone"  maxlength="30" size="30" value="<%=members.getMemberPhone()%>"> </td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>E-mail：</td>
	<td align="left" colspan="3">
	<input type="text" name="MemberEmail" id="MemberEmail"  maxlength="45" size="30" value="<%=members.getMemberEmail()%>"></td>
</tr>
<tr>
	<td align="left">&nbsp;<font color="red">*&nbsp;</font>QQ：
	<input type="text" name="Memberqq" id="Memberqq" maxlength="20" size="30" value="<%=members.getMemberqq()%>"></td>
    <td align="right">&nbsp;<font color="red">*&nbsp;</font>微信：</td>
    <td align="left" colspan="3">
    <input type="text" name="Memberwx" id="Memberwx" maxlength="20" size="30" value="<%=members.getMemberwx()%>"></td>
</tr>
<tr>
	<td align="right" >&nbsp;<font color="red">*&nbsp;</font>个人简介：</td>
	<td align="left" colspan="5"><textarea name="MProfile" id="MProfile"  maxlength="500" cols="130" rows="4"><%=members.getMProfile() %></textarea>	</td>
</tr>
<tr>
	<td align="right" >&nbsp;<font color="red">*&nbsp;</font>社团工作经历：</td>
	<td align="left" colspan="5"><textarea name="MExperience" id="MExperience"  maxlength="500" cols="130" rows="4"><%=members.getMExperience() %></textarea></td>
</tr>
<%
String bt1 = "确定添加";
String bt2 = "取消添加";
if(members.getId()!=-1){
	bt1 = "确定修改";
	bt2 = "取消修改";
}
String state = ParamUtils.getParameter(request,"state","");
if(state.equals(SdtwConst.CHECKFLAG_WSB)||state.equals(SdtwConst.CHECKFLAG_XYWTG)||state.equals(SdtwConst.CHECKFLAG_XXWTG))
if((userInfo.getId()+"").equals(members.getAddPerson())||members.getAddPerson().equals("")){
%>
	<tr>
	    <th  colspan="6" align="center">
	        <input type="button" class="button" value="<%=bt1 %>" name="btn1" onclick="formsubmit()">&nbsp;&nbsp;&nbsp;
	        <input type="button" class="button" value="<%=bt2 %>" name="btn2" onclick="history.go(-1)">&nbsp;&nbsp;&nbsp;
	    </th>
	</tr>
<%} %>
</form>
</tbody>
</table>
</body>
<%-- <%@include file="searchboxpub.jsp" %> --%>

<script type="text/javascript">

</script>


</html>
