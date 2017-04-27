<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="javax.swing.text.html.HTMLDocument.HTMLReader"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%//指导教师页面 %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"");
//List cdt1  = new ArrayList();
//cdt1.add("roles!="+SdtwConst.USER_TYPE_STU+"");
//List UserCnNameOptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt1);
List sexOptions = CEditConst.getsexOptions(userInfo,"");
List NationNameOptions = CEditConst.getNationNameOptions(userInfo,"");
List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"");
List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"");
int ClubName = ParamUtils.getIntParameter(request,"ClubName",-1);//社团id
//int TeaName = ParamUtils.getIntParameter(request,"TeaName",-1);//教师id
ClubTeacher teacher = new ClubTeacher();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("ClubName="+ClubName);
cdt.add("CheckFlag=1");
//cdt.add("TeaName="+TeaName);
list = teacher.query(cdt);
if(list.size()>0){
	teacher = (ClubTeacher)list.get(0);
}
String cmd = ParamUtils.getParameter(request,"cmd","");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../js/autosearch.js"></script>
<script src="../main/js/common.js"></script>
<style type="text/css">
.blocktitle{
	font-size:large;
	font-weight:bold;
}
</style>
<script type="text/javascript">
function addSponsor(){
	openWindow("BaseUserCodeAction.jsp?cmd=teacher&values=","703,400");
}
function setRole(reId,TeaName,TeaSex,TeaAge,TeaNation,TeaPolitics,TeaBirthplace,TeaDuty,TeaAcademy,TeaTel,TeaPhone,TeaEmail){
	$('#TeaName').val(reId);
	//$('#ClubName').val(ClubName);
	$('#TeaSex').val(TeaSex);
	$('#TeaAge').val(TeaAge);
	$('#TeaNation').val(TeaNation);
	$('#TeaPolitics').val(TeaPolitics);
	$('#TeaBirthplace').val(TeaBirthplace);
	$('#TeaDuty').val(TeaDuty);
	$('#TeaAcademy').val(TeaAcademy);
	$('#TeaTel').val(TeaTel);
	$('#TeaPhone').val(TeaPhone);
	$('#TeaEmail').val(TeaEmail);
}
function formsubmit(num){ 
	var formname=document.getElementById("formpost");
	if (formname.TeaName.value==""){
  		alert("指导教师姓名不能为空！");
  		formname.TeaName.focus();
    	return false;
	}
	if (formname.TeaSex.value==""){
  		alert("性别不能为空！");
  		formname.TeaSex.focus();
    	return false;
	}
	if (formname.TeaAge.value==""){
 		alert("年龄不能为空！");
  		formname.TeaAge.focus();
    	return false;
	}
	if (formname.TeaNation.value==""){
 		alert("民族不能为空！");
  		formname.TeaNation.focus();
    	return false;
 	}
	if (formname.TeaPolitics.value==""){
  		alert("政治面貌不能为空！");
  		formname.TeaPolitics.focus();
    	return false;
 	}
	if (formname.TeaBirthplace.value==""){
  		alert("籍贯不能为空！");
  		formname.TeaBirthplace.focus();
    	return false;
 	}
	if (formname.TeaDuty.value==""){
  		alert("职务不能为空！");
  		formname.TeaDuty.focus();
    	return false;
 	}
	if (formname.TeaAcademy.value==""){
  		alert("所在学院（部门）不能为空！");
  		formname.TeaAcademy.focus();
    	return false;
 	}
	if (formname.TeaTel.value==""){
  		alert("电话不能为空！");
  		formname.TeaTel.focus();
    	return false;
 	} else {
 		var myreg=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
 		if(!myreg.test(formname.TeaTel.value)){
 			formname.TeaTel.focus();
	    	alert("电话不正确！");
	    	return;
		 }
 	}
	if (formname.TeaPhone.value==""){
  		alert("手机不能为空！");
  		formname.TeaPhone.focus();
    	return false;
 	} else {
 		var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		 if(!myreg.test(formname.TeaPhone.value)){
			 formname.TeaPhone.focus();
 	    	alert("手机不正确！");
 	    	return;
 		 }
 	}
	if (formname.TeaEmail.value==""){
  		alert("E-mail不能为空！");
  		formname.TeaEmail.focus();
    	return false;
 	} else {
 		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
 	    if(!myreg.test(formname.TeaEmail.value)){
 	    	formname.TeaEmail.focus();
 	    	alert("邮箱格式不正确！");
 	    	return;
 		 }
 	}
	if (formname.TeaAcademic.value==""){
  		alert("个人情况简介不能为空！");
  		formname.TeaAcademic.focus();
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
</script>
</head>

<body>
<%
String strposition = "学生社团工作 >> 社团成立申请 >> ";
String strfunction = "添加社团指导教师";
String strhelpwords = "提交社团指导教师。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td><a a href="#" onclick="history.go(-1)" ><!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table>

<table class="content-table">
<tr height="35"><td colspan="8" class="blocktitle">学生社团指导教师情况登记表</td></tr>
<%-- <tr height="20">
<td align="right" colspan="6">
	<%for(teai=0;!"".equals(teanames)&&teai<teanameslst.length;teai++){%>
   <span name="label" class="labeloff" onclick="selectlabel('<%=teai%>')" style="padding-left: 15px;padding-right: 15px"><%=teanameslst[teai]%></span>
   <%} %>
   <span name="label" class="labeloff" onclick="selectlabel('<%=teai%>')" style="padding-left: 15px;padding-right: 15px">添加指导教师</span>
</td>
</tr> --%>

<tbody name="content" >
<form name="formpost" id="formpost" method="post" action="club-setup-teacher-addsave.jsp">
<input type="hidden" id="Id" name=Id value="<%=teacher.getId()%>">
<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>"/>
<tr>
	<td align="right" width="15%">&nbsp;<font color="red">*&nbsp;</font>社团名称：</td>
    <td align="left" colspan="3">
    <%=HtmlTool.renderSelect(ClubNameOptions,""+teacher.getClubName(),"ClubName",""+ClubName,true) %>
    </td>
</tr>   
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>指导教师姓名：</td>
    <td align="left" width="35%" >
    <%//=HtmlTool.renderSelect(UserCnNameOptions,""+teacher.getTeaName(),"TeaName","") %>
   <!--  <a href="#" class='add_btn' onclick="addSponsor();">添加</a> -->
   <input id="TeaName" name="TeaName" value="<%=teacher.getTeaName()%>"/>
   </td>
    </td>
	<td align="right" width="15%" >&nbsp;<font color="red">*&nbsp;</font>性别：</td>
     <td align="left">
      <%=HtmlTool.renderSelect(sexOptions,""+teacher.getTeaSex(),"TeaSex","") %>
     </td>
</tr>  
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>年龄：</td>
    <td align="left"><input type="text" name="TeaAge" id="TeaAge"  maxlength="45" size="30" value="<%=teacher.getTeaAge()%>"></td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>民族：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(NationNameOptions,""+teacher.getTeaNation(),"TeaNation","") %>
     </td>
</tr> 
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>政治面貌：</td>
    <td align="left">
     <%=HtmlTool.renderSelect(PoliticsNameOptions,""+teacher.getTeaPolitics(),"TeaPolitics","") %>
    </td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>籍贯：</td>
     <td align="left">
     <input type="text" name="TeaBirthplace" id="TeaBirthplace"  maxlength="45" size="30" value="<%=teacher.getTeaBirthplace()%>">
     </td>
</tr>   
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>职务：</td>
    <td align="left"><input type="text" name="TeaDuty" id="TeaDuty"  maxlength="45" size="30" value="<%=teacher.getTeaDuty()%>"></td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>所在学院（部门）：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(AcademyNameOptions,""+teacher.getTeaAcademy(),"TeaAcademy","") %>
     </td>
</tr>   
<tr>
	<td align="right" rowspan="3">&nbsp;<font color="red">*&nbsp;</font>联系方式：</td>
	<td align="left" colspan="3">&nbsp;电&nbsp;&nbsp;&nbsp;话：
	<input type="text" name="TeaTel" id="TeaTel"  maxlength="45" size="30" value="<%=teacher.getTeaTel()%>"><span style="color: red;">*</span>区号-号码 或 号码
	</td>
</tr>
<tr>
	<td align="left" colspan="3">&nbsp;手&nbsp;&nbsp;&nbsp;机：
	<input type="text" name="TeaPhone" id="TeaPhone"  maxlength="45" size="30" value="<%=teacher.getTeaPhone()%>">
	</td>
</tr>
<tr>
	<td align=left colspan="3">&nbsp;E-mail：
	<input type="text" name="TeaEmail" id="TeaEmail"  maxlength="45" size="30" value="<%=teacher.getTeaEmail()%>">
	</td>
</tr>
<tr>
	<td align="right" >&nbsp;<font color="red">*&nbsp;</font>个人情况简介：<br/>（社团相关）</td>
	<td align="left" colspan="3"><textarea name="TeaAcademic" id="TeaAcademic"  maxlength="500" cols="130" rows="4"><%=teacher.getTeaAcademic() %></textarea>	</td>
</tr>
<%
String state = ParamUtils.getParameter(request,"state","");
if(state.equals(SdtwConst.CHECKFLAG_WSB)||state.equals(SdtwConst.CHECKFLAG_XYWTG)||state.equals(SdtwConst.CHECKFLAG_XXWTG))
if((userInfo.getId()+"").equals(teacher.getAddPerson())||teacher.getAddPerson().equals("")){
if(teacher.getId()==-1){%>
<tr>
    <th  colspan="6" align="center">
        <input type="button" class="button" value="确定添加" name="btn1" onclick="formsubmit()">&nbsp;&nbsp;&nbsp;
        <input type="button" class="button" value="取消添加" name="btn2" onclick="history.go(-1)">&nbsp;&nbsp;&nbsp;
    </th>
</tr>
<%}else{%>
	<tr>
    <th  colspan="6" align="center">
        <input type="button" class="button" value="确定修改" name="btn1" onclick="formsubmit()">&nbsp;&nbsp;&nbsp;
        <input type="button" class="button" value="取消修改" name="btn2" onclick="history.go(-1)">&nbsp;&nbsp;&nbsp;
    </th>
</tr>
<%}
}
%>
</form>
</tbody>
</body>
</html>
