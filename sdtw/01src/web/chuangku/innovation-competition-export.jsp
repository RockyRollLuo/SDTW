<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/session-confirm.jsp" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="pub.db_exportpub"%>
<jsp:useBean id="mytime" scope="page" class="pub.mytime"/>
<html>
<head>
<%!
String strSQL="";
String exceltitle="";
String [] titlelist;

String filepath="",filename="";
%>

<%
String downloadtime =mytime.getTime();
downloadtime = downloadtime.substring(0,4)+ downloadtime.substring(5,7)+ downloadtime.substring(8,10);

exceltitle="��Ʒ����,��Ʒ����,������Ŀ,ѧԺ,�걨���������������ƣ�,��Ʒ���,�걨���,������,�Ŷӳ�Ա,�����,��ע";
titlelist=exceltitle.split(",");

strSQL="SELECT production_code,production_name,projectname,academy,declarer,production_type,declarer_role,leader,team,award,remark FROM innovation_competition WHERE leaderid = '" + myuseraccount +"' or teamid like '%" + myuseraccount + "%' ";

String basepath = request.getContextPath();
basepath += "/datawork/exportfile/";
// ϵͳ��Ŀ¼
filepath = request.getRealPath("");
filepath += "/datawork/exportfile/";
filename = myuseraccount+"-innovation_competition" + "(" + downloadtime  +")" +".xls";

pub.db_exportpub Myexcel1=new db_exportpub();
int ret = Myexcel1.createEXCEL(titlelist,strSQL,filepath+filename);
if(ret==-1){
    out.println("����ʧ�ܣ�<a href='#' onclick='history.go(-1)'>����</>");
}else{%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../pubcss/common-student.css">
<link rel="stylesheet" type="text/css" href="../pubcss/linestable.css">
</head>

<body>
<table border="0" cellspacing="0" width="100%" height="100%">
<tr>
<td align="center">

<table class="table_frame"  width="50%"  cellspacing="0">
<tr height="35">
    <td class="table_topic" colspan="2" align="left">
        <font color="#FF3401">������������Ʒ��Ϣ��</font>
    </td>
</tr>
    
<tr height="70">
    <td  width="30%" align="center">���ݵ����ɹ���������<%=ret%>����¼!<br><br>
       �����ļ�Ϊ��<a href="<%=basepath+filename%>"><%=filename%></a><br>
    </td>
</tr>

<tr height="35">
    <td  align="right">
       <a href="#" onclick="history.go(-1)">����</a> 
    </td>
</tr>
</table>

</td>
</tr>
</table>
</body>
</html>
<%}%>
