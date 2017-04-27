<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*"%> 


<%!
String teacheraccount,teachername;
int personnums=0;
%>

<%
teacheraccount=(String)session.getAttribute("useraccount");
teachername=(String)session.getAttribute("truename");
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<% request.setCharacterEncoding("utf-8"); %>
<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

<script language="JavaScript" >
//////////////////////////////////////////////////////////////////////////////////////////////
// 显示留言窗口              HaoXW：2011-02-15
// togroup--小组留言表示，1：为小组留言，0：为个人留言
// msgid--图层id，显示保存留言后的返回信息
// frommodulename--发送消息的模块名,例如：blog,bbs
function pubmsgwnd(perosonfrom,personto,togroup,msgid,frommodulename){
   document.msgform.personfrom.value = perosonfrom;
   document.msgform.personto.value = personto;
   document.msgform.msgtitle.value = "来自：" + perosonfrom;
   document.msgform.frommodulename.value = frommodulename;
   //Ajax返回数据要显示的图层标识
   document.msgform.msgid.value = msgid;
   //显示隐藏的留言图层,定义在包含文件message-edit.jsp中
   openmsgwnd(msgdiv);
}
</script>
</head>

<body>
<%
String strposition = "个人消息管理  >> 发送消息 >> ";
String strfunction = "通信簿列表";
String strhelpwords= "该列表列出了全校所有学生的基本信息，点击名称即可查看其详细信息。";
%>
<%@ include file="../pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr height="40px">
    <td>
        <a href='#' title="给系统管理员留言..." onclick="pubmsgwnd('<%=teachername%>(<%=teacheraccount%>)','','0','mymsgdiv','blog')">
    		<img src="../images/commandico/add.png">
    	</a>
    	<a href="../myaccount.jsp" >
    		<img src="../images/commandico/back.png">
 	    </a>
    </td>
</tr>
</table>


<table class="content-table">
<tr height="35">
    <th width="20%">分 类</th>
    <th width="45%">用户组名或用户名</th>
    <th width="10%">成员数目</th>
    <th colspan="2">操作</th>
</tr>


<tr>
	<td >用户</td>
	<td colspan="4"><a href=""></a></td>
</tr>

<tr height="40">
    <th colspan="6">
    	<a href="../myaccount.jsp">返回</a>
    </th>
</tr>
</table>

<%@ include file="message-editforteacher.jsp" %>
<div id="mymsgdiv" style="position:absolute;width:400px; height:250px;background:#F7FBFF;pading:10px;display:none;">
</div>

</body>
</html>