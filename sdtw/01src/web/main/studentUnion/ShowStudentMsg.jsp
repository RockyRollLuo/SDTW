<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return;
}
int id = ParamUtils.getIntParameter(request,"id",-1);
BaseUserCode user = new BaseUserCode();
if (id!=-1&&user.getById(id)!=null) {
	user = user.getById(id);
}
Map sexMap = CEditConst.getsexMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<style>
.ui-dialog .ui-dialog-titlebar-close span {
    display: none;
    margin: 1px;
    text-indent: 9999px;
}
</style>
<script type="text/javascript">
$(function(){
	$('.ui-button-text').html("关闭");
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div  style="margin:0 auto 0 auto; padding-top:0px; width:100%;height:auto;border-radius: 3px;background-color: #E3E5E8">
     <form id="" name="" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="enter">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8" style="width: 100%;">
     <tr bgcolor="#E3E5E8">
     <td class="form_label">学号</td>
     <td bgcolor="#ffffff">
		 <div align="left">
			<%=user.getName() %>
	     </div>
	 </td>
     
     <td class="form_label">姓名</td>
     <td bgcolor="#ffffff">
		 <div align="left">
		 <%=user.getCnName() %>
	     </div>
	 </td>
     </tr>
     <tr bgcolor="#E3E5E8">
     <td class="form_label">学院</td>
     <td bgcolor="#ffffff">
		 <div align="left">
		 <%=AcademyNameMap.get(user.getDeptId()+"")==null?"":AcademyNameMap.get(user.getDeptId()+"")%>
	     </div>
	 </td>
     <td class="form_label">性别</td>
     <td bgcolor="#ffffff">
		 <div align="left">
		 <%=sexMap.get(user.getGender()+"")==null?"":sexMap.get(user.getGender()+"") %>
	     </div>
	 </td>
     </tr>
    <tr bgcolor="#E3E5E8">
     <td class="form_label">年级</td>
     <td bgcolor="#ffffff" colspan="3">
		 <div align="left">
		 <%=GradeNameMap.get(user.getGrade()+"")==null?"":GradeNameMap.get(user.getGrade()+"")%>
	     </div>
	 </td>
     </tr>
     </table>
     </form>
     </div>
</body>
</html>