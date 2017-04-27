<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.sdtw.db.Places_Applytable"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

</head>
<body >
<% 
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode stu= userinfo.getUserCode();
	//接受各种参数 从session或者其他对象中 
	String useraccount = (String)session.getAttribute("useraccount"); 
	//wherestr用来传递翻页时的查询语言，因为当翻页时，wherestr就不是原来的strsql了
	String strposition = "场地管理 >> 申请状态查询>> ";
	String strfunction = "已申请场地列表";
	String strhelpwords = "已申请场地列表。";
%>

 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>场地信息>>我的场地申请
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="content-table" id="table2">
<tr>
  <th width="5%">序号</th>
  <th width="25%">活动内容</th>
  <th width="10%">活动时间</th>
  <th width="20%">场地名称</th>
  <th width="10%">申请日期</th>
  <th width="10%">申请时段</th>
<!--   <th width="8%">活动负责人</th>  -->
<!--   <th width="8%">联系方式</th>     -->
  <th width="8%">审核状态</th>
  <th colspan="2">操作</th>
</tr>
<%  
	

	//定义数据库中读取字段的变量 
	String placecode="",placename="",placeapplycode="",activityprincipal="",activitycontents="",activitytime="",timerange="",statustr="",applicant="",principalphone="";
	String namehref="",modifyhref="",delhref="",apphref="";
	String shenqingshijian="";
	Map audimap=CEditConst.getAuditMap(userinfo);
	int id,order=0,status;
List list = new ArrayList();
List cdt = new ArrayList();
Places_Applytable pat = new Places_Applytable();
cdt.add("useraccount ="+stu.getId());
      list= pat.query(cdt)   ;
      if(list.size()>0){
    	  for(int i=0;i<list.size();i++){
    		  pat= (Places_Applytable)list.get(i)	;	  
    		  namehref="<a href='places-applyed-details.jsp?Id="+pat.getId()+"'>"+pat.getActivityContents()+"</a>";
    		  activitytime=Tool.stringOfDate(pat.getActivityTime());
    		  placename=pat.getPlaceApplycode();
    		  shenqingshijian=pat.getApplyDate();
    		  timerange=pat.getApplyTimeRange();
    		  if(pat.getStatus()!=""){
    		  statustr=(String)audimap.get(pat.getStatus());
    		  }
    		  if(!pat.getStatus().equals("1")){
    		  modifyhref="<a href='places-applyed-modify.jsp?Id="+pat.getId()+"'>修改</a>";
    		  delhref="<a href='Places_ApplytableAction.jsp?cmd=delete&&Id="+pat.getId()+"'>删除</a>";
    		  }
%>
<tr>
	<td><%=order+1%></td>
	<td><%=namehref%></td>
	<td><%=activitytime%></td>
    <td><%=placename%></td>
	<td><%=shenqingshijian %></td>
	<td><%=timerange%></td>

	<td><%=statustr%></td>
	<td><%=modifyhref%></td>
	<td><%=delhref%></td>
</tr>
<%	 
order++;
modifyhref="";delhref=""; 	
statustr="";
    	  }
      }else{ %>
<tr>
    <td colspan="11" >该账号未申请任何场地</td>
</tr>
<%} %>
  <tr>
    <th colspan="11" align="left">已经通过审核的场地申请不允许修改和删除</th>
  </tr>
</table>



</body>

</html>