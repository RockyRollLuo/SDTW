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
// ��ʾ���Դ���              HaoXW��2011-02-15
// togroup--С�����Ա�ʾ��1��ΪС�����ԣ�0��Ϊ��������
// msgid--ͼ��id����ʾ�������Ժ�ķ�����Ϣ
// frommodulename--������Ϣ��ģ����,���磺blog,bbs
function pubmsgwnd(perosonfrom,personto,togroup,msgid,frommodulename){
   document.msgform.personfrom.value = perosonfrom;
   document.msgform.personto.value = personto;
   document.msgform.msgtitle.value = "���ԣ�" + perosonfrom;
   document.msgform.frommodulename.value = frommodulename;
   //Ajax��������Ҫ��ʾ��ͼ���ʶ
   document.msgform.msgid.value = msgid;
   //��ʾ���ص�����ͼ��,�����ڰ����ļ�message-edit.jsp��
   openmsgwnd(msgdiv);
}
</script>
</head>

<body>
<%
String strposition = "������Ϣ����  >> ������Ϣ >> ";
String strfunction = "ͨ�Ų��б�";
String strhelpwords= "���б��г���ȫУ����ѧ���Ļ�����Ϣ��������Ƽ��ɲ鿴����ϸ��Ϣ��";
%>
<%@ include file="../pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr height="40px">
    <td>
        <a href='#' title="��ϵͳ����Ա����..." onclick="pubmsgwnd('<%=teachername%>(<%=teacheraccount%>)','','0','mymsgdiv','blog')">
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
    <th width="20%">�� ��</th>
    <th width="45%">�û��������û���</th>
    <th width="10%">��Ա��Ŀ</th>
    <th colspan="2">����</th>
</tr>


<tr>
	<td >�û�</td>
	<td colspan="4"><a href=""></a></td>
</tr>

<tr height="40">
    <th colspan="6">
    	<a href="../myaccount.jsp">����</a>
    </th>
</tr>
</table>

<%@ include file="message-editforteacher.jsp" %>
<div id="mymsgdiv" style="position:absolute;width:400px; height:250px;background:#F7FBFF;pading:10px;display:none;">
</div>

</body>
</html>