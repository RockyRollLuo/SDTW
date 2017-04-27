<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.*"%>
<jsp:useBean id="tuanwei" scope="page" class="pub.db_tuanwei" />

<%
String id=request.getParameter("id");

String sqlString;
sqlString="delete from message "
         + " where ID='" + id + "'";
try
{
    tuanwei.executeUpdate(sqlString);
}

catch(Exception ex)
{
     out.print(ex.getMessage());      
}
finally
{
     tuanwei.disconnectToDB();
     response.sendRedirect("sitemsg-list.jsp");
}
%>
