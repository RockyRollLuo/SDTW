<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivityProject"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%
   UserInfo userInfo = Tool.getUserInfo(request);
   if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
	}
   if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	   out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
   }
   int id = ParamUtils.getIntParameter(request,"id",-1);
   ClubActivityProject v = new ClubActivityProject();
   if(id!=-1&&v.getById(id)!=null){
	   v = v.getById(id);
   }
   Map RoleNameMap = CEditConst.getRoleNameMap(userInfo);
   Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css"> 
<style>
.ui-widget-content{
background-color: #ffffff;
}
</style>
<script type="text/javascript">
$(function(){
	$('.ui-button-text').text("关闭");
	$('.ui-dialog .ui-dialog-titlebar-close span').hide();
})
</script>
</head>
<body>
<form>
	<table width="100%"  border="0" align="center" cellpadding="4" cellspacing="1" >
		<tr>
			<td align="right">项目名称</td>
			<td bgcolor="#ffffff" colspan="5" align="left"><%=v.getProjectName()%></td>
		</tr>
		<tr>
			<td align="right">
			发布单位</td><td align="left"><%=RoleNameMap.get(v.getProjectUnit()) %>
			</td>
		</tr>
		<tr>
			<td align="right">
			负责人:</td><td align="left"><%=v.getProjectLeader()%>&nbsp;&nbsp;联系方式:<%=v.getProjectId()%></td>
		</tr>
		<tr>
			<td align="right">
			时间：</td><td align="left"><%=v.getTimeStart()%>~<%=v.getTimeEnd()%>
			</td>
		</tr>
		
		<tr>
			<td align="right" >
			项目详情:
			</td>
			<td align="left"><%=v.getProjectDetail()%></td>
		</tr>
		
		<tr>
			<td align="right">
			其他说明<%=v.getRemark()%>
			</td>
			<td align="left"><%=v.getProjectDetail()%></td>
		</tr>
</table>
</form>
</body>
</html>