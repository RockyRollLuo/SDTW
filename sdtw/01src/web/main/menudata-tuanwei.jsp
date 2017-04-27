<%@page import="com.xietong.software.base.CNavTree"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
CNavTree tree = new CNavTree();
if(userInfo==null){
	out.print("<meta http-equiv='refresh' content='0;url="+ HeadConst.root_url_path + "/main/logon.jsp'>");
    return;
} 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="../css/menuleft.css" rel="stylesheet" type="text/css"/>
<script src="../js/menuleft.js"></script>
<link href="../images/css.css"></link>
</head>
<body>
<!--- 树形菜单定义开始 --->
<!-- <div class="leftsidebar">
		<div class="line"></div>

<dl class="syetem_management">
<dt class="one-three">个人信息中心</dt>
<dl>
<dt class="two">个人信息维护<img src="../images/menuico/arrowright.png"></dt>
<dd><a href='../base/myaccount.jsp'  target='mainFrame'>个人信息浏览</a></dd>
</dl>
<dl>
<dt class="two">个人消息管理<img src="../images/menuico/arrowright.png"></dt>
<dd><a href='../base/sitemsg-list.jsp'  target='mainFrame'>消息列表</a></dd>
<dd><a href='../base/sitemsg-admin.jsp'  target='mainFrame'>收发消息</a></dd>
</dl>
<dl>
<dt class="two">通信录管理<img src="images/menuico/arrowright.png"></dt>
<dd><a href='pubpro/addbook-admin.jsp'  target='mainFrame'>通信录列表</a></dd>
<dd><a href='pubpro/addbook-admin.jsp'  target='mainFrame'>通信录维护</a></dd>
</dl>
<dl>
<dt class="two">邮件管理<img src="images/menuico/arrowright.png"></dt>
<dd><a href='mail/mail-list.jsp'  target='mainFrame'>联系人列表</a></dd>
<dd><a href='mail/mail-new.jsp'  target='mainFrame'>写邮件</a></dd>
</dl>		
</dl>	
</div> -->
<div class="area">
<div class="left">
<%= tree.getMainMenu(userInfo) %>	
</div>

<!--- 树形菜单定义完成 --->
		<div class="copyright">
			<span><b>系统信息</b></span><br/>
			<span>版权所有：山东大学团委</span><br/>
			<span>技术支持：计算机科学与技术学院</span>
		</div>
</div>
</body>
</html>
