<%@ page pageEncoding="GBK" %>
<%@ page import="java.sql.*" %>


 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../pubcss/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../pubjs/tablelist.js"></script>
<script src="../pubjs/jquery.min.js"></script>
</head>

<body>
<%
String strposition = "组织建设信息  >>五四评比表彰>> ";
String strfunction = "评比表彰列表";
String strhelpwords= "点击表彰内容名称可进入已填写的详细界面。";
%>
<%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr height="20px">
	<td style="text-align:left">
<%if("".equals("")){%>
		<span>学院未设置申请时段</span>
<%
}else{
%>
		<span>申请时段为&nbsp;</span>

<%
}
%>		
	</td>
    <td>
 		&nbsp;学年
    </td>	
</tr>
</table>

<table class="content-table">

<tr>
	<th width="5%">序号</th>
	<th>五四评比表彰内容</th>
	<th width="15%">申请</th>
	<th width="15%">状态</th>
	<th width="20%" colspan="2" >操作</th>
</tr>
			
<tr>
  <td></td>
  <td align="left"></td> 
  <td></td>
  <td></td>
  <td></td>
  <td></td>
</tr>





<tr>
	<th align="left" colspan="11">说明:点击“表彰内容”名即可进入已填写的详细页面，点击“点击申请”，即可进入申请表界面。每项只能提交一份。</th> 
</tr>
</table>

</body>
</html>
