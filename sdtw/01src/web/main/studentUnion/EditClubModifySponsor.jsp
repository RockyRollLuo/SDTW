<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.common.HeadConst"%>
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
if(userInfo==null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"-1");
List MemberDutyOptions = CEditConst.getMemberDutyOptions(userInfo,"-1");
List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
List MajorNameOptions = CEditConst.getMajorNameOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
List sexOptions = CEditConst.getsexOptions(userInfo,"-1");
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
//MemberName==mlist.get(j)&MemberClubname
String cmd = ParamUtils.getParameter(request,"cmd","");
int MemberClubname = ParamUtils.getIntParameter(request,"cid",-1);//社团id
int MemberName = ParamUtils.getIntParameter(request,"uid",-1);
ClubMembers members = new ClubMembers();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("MemberClubname="+MemberClubname);
cdt.add("MemberName="+MemberName);
list = members.query(cdt);
if(list.size()>0){
	members = (ClubMembers)list.get(0);
}
String checkflag = ParamUtils.getParameter(request,"checkflag","");

cdt.clear();
cdt.add("id in("+MemberName+")");
List UserCnNameOptions = COptionConst.getUserCnNameOptions(userInfo,cdt);
	//CEditConst.getUserCnNameOptions(userInfo,"-1");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%-- <script src="<%=HeadConst.apache_url %>/js/jquery.min.js"></script> --%>
<%-- <link href="<%=HeadConst.apache_url %>/css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="<%=HeadConst.apache_url %>/js/tablelist.js"></script>
<script src="<%=HeadConst.apache_url %>/main/js/common.js"></script> --%>
<script src="<%=HeadConst.apache_url %>/main/js/datepicker/WdatePicker.js"></script>
<style type="text/css">
    table{
   border-collapse:collapse;
}
tr{border:1px solid #e5f1f4} 
</style>
<script type="text/javascript">
<%
if(!"".equals(checkflag)){%>
$('.ui-dialog-buttonset').find("button:eq(0)").hide();
$('.ui-dialog-buttonset').find("button:eq(1)").find("span:eq(0)").html("关闭");
<%}
%>
function formsubmit(){
	var formname=document.getElementById("formP");
	if ($('#MemberSex').val()==""){
  		alert("性别不能为空！");
  		$('#MemberSex').focus();
    	return false;
	}
	if ($('#MemberBrith').val()==""){
  		alert("出生年月不能为空！");
  		$('#MemberBrith').focus();
    	return false;
	}
	if ($('#MemberPolitics').val()==""){
 		alert("政治面貌不能为空！");
  		$('#MemberPolitics').focus();
    	return false;
	}
	if ($('#MemberBirthplace').val()==""){
 		alert("籍贯不能为空！");
  		$('#MemberBirthplace').focus();
    	return false;
 	}
	if ($('#MemberPhone').val()==""){
  		alert("手机不能为空！");
  		$('#MemberPhone').focus();
    	return false;
 	} else {
 		var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
 		var MemberPhone = $('#MemberPhone').val();
 		if(!myreg.test(MemberPhone)){
        	alert("手机格式不正确！");
        	$('#MemberPhone').focus();
        	return false;
        } 
 	}
	/* formname.managerDuty_final.value = $("select[name='managerDuty']").val();
	 if(formname.managerDuty && formname.managerDuty.value=="其他"){
		 formname.managerDuty_final.value = "其他-" + $("input[name='managerDuty_other']").val();
	 } */
	if ($('#MemberAcademy').val()==""){
  		alert("学院不能为空！");
  		$('#MemberAcademy').focus();
    	return false;
 	}
	if ($('#MemberMajor').val()==""){
  		alert("专业不能为空！");
  		$('#MemberMajor').focus();
    	return false;
 	}
	if ($('#MemberGrade').val()==""){
  		alert("年级不能为空！");
  		$('#MemberGrade').focus();
    	return false;
 	}
	if ($('#MemberEmail').val()==""){
  		alert("E-mail不能为空！");
  		$('#MemberEmail').focus();
    	return false;
 	} else {
 		var MemberEmail = $('#MemberEmail').val();
 		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
 	    if(!myreg.test(MemberEmail)){
 	    	$('#MemberEmail').focus();
 	    	alert("邮箱格式不正确！");
 	    	return false;
 		 } 

 	}
	if ($('#Memberqq').val()==""){
  		alert("QQ不能为空！");
  		$('#Memberqq').focus();
    	return false;
 	}
	if ($('#Memberwx').val()==""){
  		alert("微信不能为空！");
  		$('#Memberwx').focus();
    	return false;
 	}

	if ($('#MProfile').val()==""){
  		alert("个人简介不能为空！");
  		$('#MProfile').focus();
    	return false;
 	}
 	if ($('#MExperience').val()==""){
  		alert("社团工作经历不能为空！");
  		$('#MExperience').focus();
    	return false;
 	}
	
    //提交表单数据,包括disabled的输入域
    var len=formname.elements.length;
    var i;
    for (i=0;i<len;i++){
         formname.elements[i].disabled = false;
    } 
    tijiao();
    return true;
}
function tijiao(){
	var url = "<%=HeadConst.apache_url%>/main/club/ClubMembersAction.jsp?cmd=updateUser&"+$('form').serialize();
	$.ajax({
		cache:false,
		type:"json",
		url:url,
		dataType:'json',
		async:false,
		error:function(request){
			alert('操作提示:发送请求失败！');
		},
		success:function(data){
			if(data.msg=="ok"){
				alert('操作成功');
				$('#top_dialog').dialog('close');
			}else{
				//alert('操作失败');
				$('#top_dialog').dialog('close');
			}
		}
	});
}

</script>
</head>



<body>

<form action="<%=HeadConst.apache_url %>/main/club/ClubMembersAction.jsp" id="formP" method="post">
<table background="#e3e5e8" width="100%" border="0" align="center" cellpadding="4" cellspacing="1"  border-collapse:collapse;>
<input id="Id" name="Id" value="<%=members.getId()%>" type="hidden"/>
<tr>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>学号：</td>
    <td align="left" bgcolor="#FFFFFF">
    <input type="text" name="MemberSno" id="MemberSno" value="<%=members.getMemberSno() %>" readonly="readonly" />

	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>姓名：</td>
    <td align="left" bgcolor="#FFFFFF">
   <%=HtmlTool.renderSelect(UserCnNameOptions,""+members.getMemberName(),"MemberName","",true) %>
    </td>
    <td class="form_label">&nbsp;<font color="red">*&nbsp;</font>性别：</td>
     <td align="left" bgcolor="#FFFFFF">
     <%=HtmlTool.renderSelect(sexOptions,""+members.getMemberSex(),"MemberSex","",true) %>
     </td>
     </tr>
     <tr>
    <td  class="form_label">&nbsp;<font color="red">*&nbsp;</font>出生年月：</td>
     <td align="left" bgcolor="#FFFFFF">
     <input readonly="readonly" class= "date" name ="MemberBrith" id= "MemberBrith"  size= "0" value="<%=members.getMemberBrith()%>"/>
     </td>

	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>政治面貌：</td>
    <td align="left" bgcolor="#FFFFFF">
    <%=HtmlTool.renderSelect(PoliticsNameOptions,""+members.getMemberPolitics(),"MemberPolitics","",true) %>
    </td>
    <td  class="form_label">&nbsp;<font color="red">*&nbsp;</font>籍贯：</td>
     <td align="left" colspan="3" bgcolor="#FFFFFF"><input readonly="readonly" type="text" name="MemberBirthplace" id="MemberBirthplace" value="<%=members.getMemberBirthplace()%>"></td>
</tr>
<tr>
	<td class="form_label">&nbsp;所在社团：</td>
    <td align="left" bgcolor="#FFFFFF">
    <%=HtmlTool.renderSelect(ClubNameOptions,members.getMemberClubname(),"MemberClubname",""+MemberClubname,true) %>
    </td>
    <td  class="form_label">&nbsp;<font color="red">*&nbsp;</font>职务：</td>
     <td align="left"  colspan="3" bgcolor="#FFFFFF">
     <%=HtmlTool.renderSelect(MemberDutyOptions,""+members.getMemberDuty(),"MemberDuty","",true) %>
     </td>
</tr>
<tr>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>学院：</td>
    <td align="left" bgcolor="#FFFFFF">
    <%=HtmlTool.renderSelect(AcademyNameOptions,""+members.getMemberAcademy(),"MemberAcademy","",true) %>
    </td>
    <td  class="form_label">&nbsp;<font color="red">*&nbsp;</font>专业：</td>
     <td align="left" bgcolor="#FFFFFF">
     <%=HtmlTool.renderSelect(MajorNameOptions,""+members.getMemberMajor(),"MemberMajor","",true) %>
     </td>
    <td  class="form_label">&nbsp;<font color="red">*&nbsp;</font>年级：</td>
     <td align="left" bgcolor="#FFFFFF">
     <%=HtmlTool.renderSelect(GradeNameOptions,""+members.getMemberGrade(),"MemberGrade","",true) %>
     </td>
</tr>
<tr>
	<td class="form_label" rowspan="2">&nbsp;<font color="red">*&nbsp;</font>联系方式：</td>
	<td bgcolor="#FFFFFF">&nbsp;<font color="red">*&nbsp;</font>手机：
	<input type="text" name="MemberPhone" id="MemberPhone"   value="<%=members.getMemberPhone()%>" readonly="readonly" > </td>
	<td bgcolor="#FFFFFF">&nbsp;<font color="red">*&nbsp;</font>E-mail：</td>
	<td align="left" colspan="3" bgcolor="#FFFFFF">
	<input type="text" name="MemberEmail" id="MemberEmail"   value="<%=members.getMemberEmail()%>" readonly="readonly"></td>
</tr>
<tr>
	<td bgcolor="#FFFFFF">&nbsp;<font color="red">*&nbsp;</font>QQ：
	<input type="text" name="Memberqq" id="Memberqq"  value="<%=members.getMemberqq()%>" readonly="readonly"></td>
    <td bgcolor="#FFFFFF">&nbsp;<font color="red">*&nbsp;</font>微信：</td>
    <td align="left" colspan="3" bgcolor="#FFFFFF">
    <input type="text" name="Memberwx" id="Memberwx"  value="<%=members.getMemberwx()%>" readonly="readonly"></td>
</tr>
<tr>
	<td class="form_label" >&nbsp;<font color="red">*&nbsp;</font>个人简介：</td>
	<td align="left" colspan="5" bgcolor="#FFFFFF"><textarea readonly="readonly" name="MProfile" id="MProfile"  style="width: 80%;" cols="130" rows="4"><%=members.getMProfile() %></textarea>	</td>
</tr>
<tr>
	<td class="form_label" >&nbsp;<font color="red">*&nbsp;</font>社团工作经历：</td>
	<td align="left" colspan="5" bgcolor="#FFFFFF"><textarea readonly="readonly" name="MExperience" id="MExperience" style="width: 80%;" cols="130" rows="4"><%=members.getMExperience() %></textarea></td>
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
	<%-- <tr>
	    <th  colspan="6" align="center">
	        <input type="button" class="button" value="<%=bt1 %>" name="btn1" onclick="formsubmit()">&nbsp;&nbsp;&nbsp;
	        <input type="button" class="button" value="<%=bt2 %>" name="btn2" onclick="history.go(-1)">&nbsp;&nbsp;&nbsp;
	    </th>
	</tr> --%>
<%} %>
</table>
</form>
</body>
<%-- <%@include file="searchboxpub.jsp" %> --%>
</html>
