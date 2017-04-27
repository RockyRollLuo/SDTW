<%@ page pageEncoding="GBK" %>
<%@ page import="java.sql.*" %>

<%! 
ResultSet rs=null,rs2=null;

int numsperpage=10,pagecount,pagenum,gopage;
%>
<%
String academy = (String)session.getAttribute("academy");
String myaccount = (String)session.getAttribute("useraccount");
String pagenumstr=request.getParameter("page");
String gopagestr=request.getParameter("gopage");

// 没有点"转到"按钮,不上传文本框输入,gopagestr为null，否则计算“转到”页码的值
if (gopagestr==null)
   gopagestr="0";
gopage=java.lang.Integer.parseInt(gopagestr);

// 求href参数中page参数的值，如果未指定page参数，则page==null
if(pagenumstr==null)
   pagenumstr="1";
pagenum=java.lang.Integer.parseInt(pagenumstr);
if (gopage>0)
   pagenum=gopage;
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../pubcss/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../pubjs/tablelist.js"></script>
<script src="../pubjs/jquery.min.js"></script>
</head>

<body>
<%
String strposition = "志愿服务>>志愿竞赛项目>>";
String strfunction = "竞赛项目列表";
String strhelpwords = "负责志愿竞赛项目的添加、修改、删除以及审核工作，点击竞赛项目名称的超链接可以进入相应的竞赛项目审核管理的界面。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table" id="table1">
<tr height="30px">
	<td></td>
</tr>
</table>

<table class="content-table" id="table2">
<tr>
<th width="5%">序号</th>
<th width="20%">项目名称</th>
<th width="15%">比赛日期</th>
<th width="10%">立项日期</th>
<th width="10%">申报截止日期</th>
<th width="10%">审核状态</th>
<th colspan="3">项目申报</th>

</tr>

<%


String istr, projectcode,projectname,projectnamehref="",addaccount,addtime,deadline,participatehref="",honourhref,submithref="",cancelhref="",checkstatus="";
String teammemberslist = "",teammajorvolunteer = "",teamcode="",starttime="",endtime="";
int id=0,pubflag=0,projectid=0,rowscount=0,i=0;

	  %>      
<tr>
  <td><%=i++%></td>
  <td><%=projectnamehref%></td>  
  <td><%=starttime%>~<%=endtime%></td>
  <td></td>
  <td></td>
  <td><%=checkstatus %></td>
  <td><%=participatehref %></td>
  <td><%=submithref %></td>
  <td><%=cancelhref %></td>
  
</tr>

</table>

<form name="mygo" method="post" action="volunteer-project-list.jsp" target="_self"  >
	<%@ include file="pagebottom-changepage.jsp" %>
</form>




</body>
<script type="text/javascript">

</script>
</html>


%>
<script type="text/javascript">
	document.getElementById("table2").style.display="none";
	document.getElementById("table3").style.display="none";
	document.getElementById("table4").style.display="block";
</script>
