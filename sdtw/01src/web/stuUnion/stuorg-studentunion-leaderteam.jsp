<%@page import="com.xietong.software.sdtw.db.StudentUnionMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>

<%@ page import="java.sql.*"%>
<%@ page import="java.*"%>
<%@page import="com.xietong.software.util.*"%>
<%@page import="com.xietong.software.common.*"%>
<%@page import="java.util.*"%>
<%String space6="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; %>
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src='../js/jquery.min.js'></script>
<script src="../js/autosearch.js"></script>
<style type="text/css">
.sp1{
	display:inline-block;
/* 	width:150px; */
}
.sp2{
	display:inline-block;
/* 	width:200px; */
}

</style>
<% 	


	
	String academy = (String)session.getAttribute("academy"); 
	
	String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};
	
	String strfunction = "主席团信息";
	String strhelpwords = "主席团信息列表";
%>
<body>
<table class="command-table">
<tr height="30px"></tr>
</table>

<table class="content-table" style="width:100%">
<%  
%>
<tr>
	<th width="4%" >序号</th>
	<th width="10%" >姓名</th>
	<th width="10%" >职务</th>
	<th width="10%" >分管部门</th>
	<th width="10%" >校区</th>
	<th width="14%" >学院</th>
	<th width="10%" >联系方式</th>
	<th width="10%" >备注</th>
</tr>

<%
String sno = "",sname = "",sacademy="",chargedept="",campus="",duty = "",phone="",remark = "",modifyhref = "",delhref = "",snamehref="";
int order=0,memberid;
UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
 	return;
 }

	
	List list= new ArrayList();
	List cdt= new ArrayList();
	StudentUnionMember stum= new StudentUnionMember ();
	String qval=ParamUtils.getParameter(request, "_type_", "-1");

	    if(qval.equals("zhuxi")){
	    	cdt.add("duty in (0,1,2,3,4)");
	    }
	   
	    qval=ParamUtils.getParameter(request, "_UnionId_", "-1");
	    if(qval.length()>0&&!qval.equals("-1")){
	    	cdt.add("unionid="+qval);
	    }
	    cdt.add("order by duty");
	    
 Map dutymaps=CEditConst.getStuDutyMap(userinfo);
Map deptmaps=CEditConst.getStuDeptNameMap(userinfo);
System.out.println(deptmaps);
Map xynamemaps=CEditConst.getAcademyNameMap(userinfo);
Map xiaoqunamemaspa=CEditConst.getOrgNameMap(userinfo);
 list = stum.query(cdt);
if(list.size()>0){
 for(int i=0;i<list.size();i++){
      stum=(StudentUnionMember)list.get(i);
      sname=stum.getSNo();
      if(stum.getChargeDept()!=""){
      duty=(String)dutymaps.get(stum.getDuty())==null?"":(String)dutymaps.get(stum.getDuty());}
      if(stum.getDeptid()>0){
      chargedept=(String)deptmaps.get(stum.getDeptid()+"")==null?"":(String)deptmaps.get(stum.getDeptid()+"");}
      if(stum.getCampus()!=""){
      campus=(String)xiaoqunamemaspa.get(stum.getCampus()+"")==null?"":(String)xiaoqunamemaspa.get(stum.getCampus()+"");}
      if(stum.getChargeDept()!=""){
      sacademy=(String) xynamemaps.get(stum.getChargeDept())==null?"":(String) xynamemaps.get(stum.getChargeDept());}
      phone=stum.getPhone();
      remark=stum.getRemark();
      
%>
<tr>
	<td><%=i+1%></td>
	<td><%=sname%></td>
	<td><%=duty%></td>
	<td><%=chargedept%></td>
	<td><%=campus%></td>
	<td><%=sacademy%></td>
	<td><%=phone%></td>
	<td><%=remark%></td>
</tr>
<%} }else{%>
<tr>
	<td colspan="9">无负责人信息！</td>
</tr>
<%} %>
<tr>
	<th colspan="9" align="left">说明：主席团成团信息</th>
</tr>

</table>


</body>
</html>