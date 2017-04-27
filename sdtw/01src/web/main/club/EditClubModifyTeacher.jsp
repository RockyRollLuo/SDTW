<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
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
List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
List NationNameOptions = CEditConst.getNationNameOptions(userInfo,"");
//MemberName==mlist.get(j)&MemberClubname
String cmd = ParamUtils.getParameter(request,"cmd","");
int MemberClubname = ParamUtils.getIntParameter(request,"cid",-1);//社团id
int MemberName = ParamUtils.getIntParameter(request,"uid",-1);
ClubTeacher teacher = new ClubTeacher();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("ClubName="+MemberClubname);
cdt.add("TeaName="+MemberName);
list = teacher.query(cdt);
if(list.size()>0){
	teacher = (ClubTeacher)list.get(0);
}
String checkflag = ParamUtils.getParameter(request,"checkflag","");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%-- <script src="<%=HeadConst.apache_url %>/js/jquery.min.js"></script> --%>
<%-- <link href="<%=HeadConst.apache_url %>/css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="<%=HeadConst.apache_url %>/js/tablelist.js"></script>
<script src="<%=HeadConst.apache_url %>/main/js/common.js"></script> --%>
<script type="text/javascript">
<%
if(!"".equals(checkflag)){%>
$('.ui-dialog-buttonset').find("button:eq(0)").hide();
$('.ui-dialog-buttonset').find("button:eq(1)").find("span:eq(0)").html("关闭");
<%}
%>
function formsubmit(){
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
	 	}
		if (formname.TeaPhone.value==""){
	  		alert("手机不能为空！");
	  		formname.TeaPhone.focus();
	    	return false;
	 	}
		if (formname.TeaEmail.value==""){
	  		alert("E-mail不能为空！");
	  		formname.TeaEmail.focus();
	    	return false;
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
    tijiao();
    return true;
}
function tijiao(){
	var url = "<%=HeadConst.apache_url%>/main/club/ClubTeacherAction.jsp?cmd=updateUser&"+$('form').serialize();
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
				alert('操作失败');
			}
		}
	});
}

</script>
</head>



<body>

<form name="formpost" id="formpost" method="post" action="club-setup-teacher-addsave.jsp">
<table background="#e3e5e8" width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
<input type="hidden" id="Id" name=Id value="<%=teacher.getId()%>">
<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>"/>
<tr>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>社团名称：</td>
    <td align="left">
    <%=HtmlTool.renderSelect(ClubNameOptions,""+teacher.getClubName(),"ClubName",""+MemberClubname) %>
    </td>

	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>指导教师姓名：</td>
    <td align="left" width="35%" >
    <%=HtmlTool.renderSelect(UserCnNameOptions,""+teacher.getTeaName(),"TeaName","") %>
    <!-- <a href="#" class='add_btn' onclick="addSponsor();">添加</a> --></td>
    </td>
	<td class="form_label" >&nbsp;<font color="red">*&nbsp;</font>性别：</td>
     <td align="left">
      <%=HtmlTool.renderSelect(sexOptions,""+teacher.getTeaSex(),"TeaSex","") %>
     </td>
</tr>  
<tr>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>年龄：</td>
    <td align="left"><input type="text" name="TeaAge" id="TeaAge"  maxlength="45" size="30" value="<%=teacher.getTeaAge()%>"></td>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>民族：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(NationNameOptions,""+teacher.getTeaNation(),"TeaNation","") %>
     </td>

	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>政治面貌：</td>
    <td align="left">
     <%=HtmlTool.renderSelect(PoliticsNameOptions,""+teacher.getTeaPolitics(),"TeaPolitics","") %>
    </td>
    </tr>
    <tr>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>籍贯：</td>
     <td align="left">
     <input type="text" name="TeaBirthplace" id="TeaBirthplace"  maxlength="45" size="30" value="<%=teacher.getTeaBirthplace()%>">
     </td>

	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>职务：</td>
    <td align="left"><input type="text" name="TeaDuty" id="TeaDuty"  maxlength="45" size="30" value="<%=teacher.getTeaDuty()%>"></td>
	<td class="form_label">&nbsp;<font color="red">*&nbsp;</font>所在学院（部门）：</td>
     <td align="left">
     <%=HtmlTool.renderSelect(AcademyNameOptions,""+teacher.getTeaAcademy(),"TeaAcademy","") %>
     </td>
</tr>   
<tr>
	<td class="form_label" rowspan="3">&nbsp;<font color="red">*&nbsp;</font>联系方式：</td>
	<td align="left" colspan="5">&nbsp;电&nbsp;&nbsp;&nbsp;话：
	<input type="text" name="TeaTel" id="TeaTel"  maxlength="45" size="30" value="<%=teacher.getTeaTel()%>">
	</td>
</tr>
<tr>
	<td align="left" colspan="5">&nbsp;手&nbsp;&nbsp;&nbsp;机：
	<input type="text" name="TeaPhone" id="TeaPhone"  maxlength="45" size="30" value="<%=teacher.getTeaPhone()%>">
	</td>
</tr>
<tr>
	<td align=left colspan="5">&nbsp;E-mail：
	<input type="text" name="TeaEmail" id="TeaEmail"  maxlength="45" size="30" value="<%=teacher.getTeaEmail()%>">
	</td>
</tr>
<tr>
	<td class="form_label" >&nbsp;<font color="red">*&nbsp;</font>个人情况简介：<br/>（社团相关）</td>
	<td align="left" colspan="5"><textarea name="TeaAcademic" id="TeaAcademic" style="width: 80%;"  maxlength="500" cols="130" rows="4"><%=teacher.getTeaAcademic() %></textarea>	</td>
</tr>
<%-- <%
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
%> --%>
</table>
</form>
</body>
<%-- <%@include file="searchboxpub.jsp" %> --%>
</html>
