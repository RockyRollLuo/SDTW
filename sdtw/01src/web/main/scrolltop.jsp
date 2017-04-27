<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
UserInfo ui = Tool.getUserInfo(request);
UserInfo userInfo =null;
if(ui.getUserCode().getDeptId()>0&&ui.getUserCode().getDeptId()!=3){
	userInfo = ui;
}
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
Map RoleNameMap = CEditConst.getRoleNameMap(userInfo);
Map DeptNameMap = CEditConst.getDeptNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
 %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body{
	margin:0;
	font-family:微软雅黑,Verdana;
	font-size:14px;
	background:#317eb4;   /*背景颜色*/
	color:#F8F8FF;       /*字体颜色 */
	
}
.wholeline{
	width:100%;
	height:35px;       /*单行 设置实际高度与行高相等，即可实现垂直居中*/
	line-height:35px;
}

.frontline{
	float:left;
	display:inline;   /*不占一行 */

}

.rearline{
	float:right;
	padding-right:2em;
}

.label{
	font-size:14px;
	color:#EEB422;
	padding-left:1.5em;
}
a,a:hover,a:visited,a:active{
	font-size:14px;
	color:#F8F8FF;
	text-decoration:none;
}
</style>

<script type="text/JavaScript">
var tt=1;
function ctrl_top()
{
   if (tt==1)
   { 
     window.parent.frames01.rows="0,35px,*";
     toparrow.src="../images/ctrltop01.gif";
     tt=0;
   }
   else
   {
     window.parent.frames01.rows="150px,35px,*";
     toparrow.src="../main/images/ctrltop02.gif";
     tt=1;
   }
}
</script>

</head>
<body>
<div class="wholeline">
	<div class="frontline">
	    <a href="pubpro/myaccount.jsp" target='mainFrame'><span class="label">用户账户：</span><%=userInfo.getName()%></a>
	    <span class="label">角色：</span><%=RoleNameMap.get(userInfo.getUserCode().getRoles()+"")%>(<%=DeptNameMap.get(userInfo.getUserCode().getDeptId()+"")%>)
		<span class="label">上次登录时间</span>：<%=userInfo.getUserCode().getLastTime()%>　
		<a href="javascript:;" onclick="{if(confirm('确定要退出系统吗?')){window.location.href='logoff.jsp'}}"  target="_top" ><span class="label">退出</span></a>
	</div>
	<div class="rearline">
    	<img id="toparrow" src="../images/ctrltop02.gif" style="cursor:hand" onclick="ctrl_top()"/>
    </div>
</div>
</html>
