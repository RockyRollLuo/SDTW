<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/session-confirm.jsp" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="pub.db_exportpub"%>
<jsp:useBean id="mytime" scope="page" class="pub.mytime"/>

<html>
<head>
<%!
String sql1="";
String a1="";
String [] title1;
String filepath="",filename="";
%>

<%
String downloadtime =mytime.getTime();
downloadtime = downloadtime.substring(0,4)+ downloadtime.substring(5,7)+ downloadtime.substring(8,10);

a1="��Ŀ����,��Ŀ����,������,��ϵ��ʽ,���λ,��ʼʱ��,��ֹʱ��,��Ŀ����,��ע";
title1=a1.split(",");
sql1="SELECT projectname,projectid,projectleader,leaderphone,projectunit,timestart,timeend,projectdetail,remark  FROM innovation_competition_project";

String basepath = request.getContextPath();
basepath += "/datawork/exportfile/";
// ϵͳ��Ŀ¼
filepath = request.getRealPath("");
filepath += "/datawork/exportfile/";
filename = "innovation-competition-project" + "(" + downloadtime  +")" +".xls";

pub.db_exportpub Myexcel1=new db_exportpub();
Myexcel1.createEXCEL(title1,sql1,filepath+filename);
%>
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
            <font color="#FF3401">��������ҵ��Ŀ��Ϣ��</font>
        </td>
    </tr>
    <tr height="70">
        <td  width="30%" align="center">���ݵ����ɹ�!<br><br>
            �����ļ�Ϊ��<a href="<%=basepath+filename%>"><%=filename%></a><br>
        </td>
    </tr>
    <tr height="35">
       <td  align="right">
           <a href="#" onclick="history.go(-1)" >����</a> 
       </td>
    </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
