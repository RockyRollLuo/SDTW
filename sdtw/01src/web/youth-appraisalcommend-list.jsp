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
String strposition = "��֯������Ϣ  >>�������ȱ���>> ";
String strfunction = "���ȱ����б�";
String strhelpwords= "��������������ƿɽ�������д����ϸ���档";
%>
<%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr height="20px">
	<td style="text-align:left">
<%if("".equals("")){%>
		<span>ѧԺδ��������ʱ��</span>
<%
}else{
%>
		<span>����ʱ��Ϊ&nbsp;</span>

<%
}
%>		
	</td>
    <td>
 		&nbsp;ѧ��
    </td>	
</tr>
</table>

<table class="content-table">

<tr>
	<th width="5%">���</th>
	<th>�������ȱ�������</th>
	<th width="15%">����</th>
	<th width="15%">״̬</th>
	<th width="20%" colspan="2" >����</th>
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
	<th align="left" colspan="11">˵��:������������ݡ������ɽ�������д����ϸҳ�棬�����������롱�����ɽ����������档ÿ��ֻ���ύһ�ݡ�</th> 
</tr>
</table>

</body>
</html>
