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

// û�е�"ת��"��ť,���ϴ��ı�������,gopagestrΪnull��������㡰ת����ҳ���ֵ
if (gopagestr==null)
   gopagestr="0";
gopage=java.lang.Integer.parseInt(gopagestr);

// ��href������page������ֵ�����δָ��page��������page==null
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
String strposition = "־Ը����>>־Ը������Ŀ>>";
String strfunction = "������Ŀ�б�";
String strhelpwords = "����־Ը������Ŀ����ӡ��޸ġ�ɾ���Լ���˹��������������Ŀ���Ƶĳ����ӿ��Խ�����Ӧ�ľ�����Ŀ��˹���Ľ��档";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table" id="table1">
<tr height="30px">
	<td></td>
</tr>
</table>

<table class="content-table" id="table2">
<tr>
<th width="5%">���</th>
<th width="20%">��Ŀ����</th>
<th width="15%">��������</th>
<th width="10%">��������</th>
<th width="10%">�걨��ֹ����</th>
<th width="10%">���״̬</th>
<th colspan="3">��Ŀ�걨</th>

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
