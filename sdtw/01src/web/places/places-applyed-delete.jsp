<%@ page contentType="text/html;charset=GBK" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<jsp:useBean id="tsd" scope="page" class="pub.db_tuanwei" />
<jsp:useBean id="gb2312" scope="page" class="pub.ISOtoGb2312" />
<%	
//删除activity数据表中的记录 
String placeapplycode=request.getParameter("placeapplycode");
String myhref = "places-applyed-list.jsp";

String delete_places_applytable = "DELETE FROM places_applytable WHERE placeapplycode='"+placeapplycode+"'";
String delete_places_allocation = "DELETE FROM places_allocation WHERE placeapplycode='"+placeapplycode+"'";
	try{
		tsd.executeUpdate(delete_places_applytable);
		tsd.executeUpdate(delete_places_allocation);
	}catch(Exception e){
		e.getMessage();
	}finally{
		tsd.disconnectToDB();
		response.sendRedirect(myhref);
	}
%>
