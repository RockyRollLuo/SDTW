<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.sql.*"%>
<%@ page import="pub.*" %>
<%@ include file="/session-confirm.jsp" %>
<jsp:useBean id="tuanwei" scope="page" class="pub.db_tuanwei" />
<jsp:useBean id="mytime" scope="page" class="pub.mytime"/>
<jsp:useBean id="gb2312" scope="page" class="pub.ISOtoGb2312" />
<%!
int retval;
%>
<%
String newsdate=mytime.getTime();

int id = Integer.parseInt(request.getParameter("id"));
String production_code= gb2312.convert(request.getParameter("production_code"));
String production_name= gb2312.convert(request.getParameter("production_name"));
String projectname= gb2312.convert(request.getParameter("projectname"));
String academy= gb2312.convert(request.getParameter("academy"));
String declarer = gb2312.convert(request.getParameter("declarer"));
String production_type=gb2312.convert(request.getParameter("production_type"));
String declarer_role = gb2312.convert(request.getParameter("declarer_role"));
String leader= gb2312.convert(request.getParameter("leader"));
String leaderid= gb2312.convert(request.getParameter("leaderid"));
String team = gb2312.convert(request.getParameter("team"));
String teamid = gb2312.convert(request.getParameter("teamid"));
String remark= gb2312.convert(request.getParameter("remark"));
String addfilelist=gb2312.convert(request.getParameter("addfilelist"));

String userrole= (String)session.getAttribute("userrole");
String rturl = "innovation-competition-list.jsp";
int checkflag =  0;
if("团委用户".equals(userrole)){
    rturl = "../role-tuanwei/innovation-competition-list.jsp";
    checkflag = 125;
}
if("学院用户".equals(userrole)){
    rturl = "../role-xy/innovation-competition-xylist.jsp";
    checkflag = 151;
}
 %>
<!DOCTYPE html>
<html>
  <head>
<%
String strSQL="update innovation_competition set "
        + "production_code=N'" + production_code    
        + "',production_name='" +production_name
        + "',projectname='" +projectname
        + "',academy='" + academy
        + "',declarer='" + declarer
        + "',production_type='" + production_type
        + "',declarer_role='" + declarer_role
        + "',leader='" + leader
        + "',leaderid=N'" + leaderid
        + "',team=N'" + team
        + "',teamid=N'" + teamid
        + "',remark=N'" + remark
        + "',addfilelist=N'" + addfilelist 
        + "',checkflag=N'" + checkflag 
        + "',modiperson=N'" + myuseraccount
        + "',moditime=N'" + newsdate
        + "'  where id="+id;

try{
     retval=tuanwei.executeUpdate(strSQL);	  
}catch (Exception ex){
     out.print(ex.getMessage());      
}finally {
     tuanwei.disconnectToDB(); 
}
%>
</head> 
<body>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<% request.setCharacterEncoding("GBK"); %>
<link href="pubcss/linestable.css" rel="stylesheet" type="text/css">
</head>
<center>
<body  leftmargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" >
<tr height="100%">
<td align="center" valign="middle">
  <table class="table_frame" width="60%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
  		<%if (retval==1) {%>
			<tr height="40"><td class="table_topic" align="center">数据修改成功</td></tr>
  			<tr height="77"> <td >竞赛作品：<%=production_name%>修改成功</td></tr>
		<%} else {%>
			<tr height="40"><td class="table_topic" align="center">数据修改失败</td></tr>
  			<tr height="77"> <td >竞赛作品：<%=production_name%>修改失败</td></tr>
		<%} %>
    <tr height="30"> 
      <td  align="right">[<a href="<%=rturl%>" class="wordblack12">返回竞赛作品列表</a>]&nbsp;&nbsp;&nbsp;</td>
    </tr>    
  </table>
</td>
</tr>
</table>
</body>
</center>
</html>
