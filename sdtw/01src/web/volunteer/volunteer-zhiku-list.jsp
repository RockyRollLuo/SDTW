<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../main/css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../main/js/tablelist.js"></script>
<script src="../main/js/jquery.min.js"></script>
</head>
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
BaseUserCode user= new BaseUserCode();

user=userinfo.getUserCode();
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));

System.out.println(pagenumstr);
int start=0;
user=user.getById(user.getId());
if(user.getVolunteerfFag().equals("1")){
	%>





<body>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>山大志库
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>




<%
String myaccount=(String)session.getAttribute("useraccount");

String strposition = "志愿服务>>山大志库>>";
String strfunction = "通知列表";
String strhelpwords = "显示已添加的山大志库通知列表。";
%>


<table class="command-table">
<tr height="35px">
	<td>

	</td>
</tr>    
</table>

<table class="content-table">
<tr>
	<th width="5%">序号</th> 
	<th >名称</th>  
	<th width="20%">日期</th>  
	<th width="15%">审核状态</th>
	<th  width="20%" colspan="2">操作</th>
</tr>
<%
ResultSet rs=null,rs2=null;
String[] checkstate={"未审核","通过","未通过","未申请"};
String zhikuname="",ck2="",declarehref="",detailhref="",modihref="",deletehref="",submit="",namehref="";
int id=0,order=0,rowscount=0,declareid=0,checkflag=3;

Map<String,VolunteerZhikuDeclare> map= new HashMap<String,VolunteerZhikuDeclare>();
List<String> yichanjia= new ArrayList<String> ();
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerZhikuDeclare vz= new VolunteerZhikuDeclare ();
cdt1.add("addAccount='"+user.getName()+"'");
list1=vz.query(cdt1);
for(int i=0;i<list1.size();i++){
	vz=(VolunteerZhikuDeclare )list1.get(i);

	map.put(vz.getZhikuId()+"", vz);
}
System.out.println("22222222222"+map);
//分割
List list= new ArrayList();
List cdt= new ArrayList();
java.util.Date now = new java.util.Date();
VolunteerZhiku va=new VolunteerZhiku();
Map checkmap=CEditConst.getCheckTypeMap(userinfo);

cdt.add("order by enddate desc limit 10");
list=va.query(cdt);
int tiaoshu=list.size();
int end=0;
if(list.size()>0){
start=(pagenumstr-1)*8;
	
	end=list.size()>pagenumstr*8?pagenumstr*8:list.size();
	System.out.println(list.size());
for(int i=start;i<end;i++)	{
	va=(VolunteerZhiku)list.get(i);
	zhikuname="<a href='volunteer-zhiku-details.jsp?id="+va.getId()+"'>"+va.getNoticeName()+"</a>";
	modihref ="<a href='volunteer-zhiku-declare.jsp?zhikuId="+va.getId()+"'>填写申请表</a>";
	if(map.containsKey(va.getId()+"")){
		checkflag=map.get(va.getId()+"").getCheckflag();
		modihref="<a href='volunteer-zhiku-declaredetail.jsp?Id="+map.get(va.getId()+"").getId()+"'>已填申请表</a>";
		deletehref="<a href='VolunteerZhikuDeclareAction.jsp?cmd=delete&Id="+map.get(va.getId()+"").getId()+"'>删除</a>";
	}
	
%>

<tr>
  <td><%=i+1%></td>
  <td><%=zhikuname%></td>
  <td><%=Tool.stringOfDate(va.getStartdate())%></td>
<%--   <td></td>
 --%>  <td><%=checkstate[checkflag]%></td>
  <td><%=modihref %></td>
  <td><%=deletehref %></td>
</tr>
<%
modihref="";
deletehref=
"";
}}else{ %>
<tr>
	<td colspan="8">系统中暂无信息！</td>
</tr>
<%} %>

<tr height=40>
	<th width="100%" colspan="15" align="center">
		共&nbsp<%=tiaoshu %>&nbsp条&nbsp;&nbsp;&nbsp;当前第<%=pagenumstr %>页&nbsp;&nbsp;&nbsp;
			<%
		
		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		%>
   		<a href="volunteer-zhiku-list.jsp?">首页</a>&nbsp;&nbsp;&nbsp;
		<a href="volunteer-zhiku-list.jsp?page=<%=shangyiye %>" >上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="volunteer-zhiku-list.jsp?page=<%=xiayiye%>" >下一页</a>&nbsp;&nbsp;&nbsp;
    
		
	</th>
</tr>
</table>

</body>
<%}else{ %>
<body>



<%
String strposition = "志愿服务信息  >> ";
String strfunction = "志愿者申请";
String strhelpwords= "申请成为志愿者。";
UserInfo userInfo = Tool.getUserInfo(request);

if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}else{
user = userInfo.getUserCode();
}
System.out.println(user.getName()+".............2222222222222...............");
%>
 <%@ include file="pagetop-positionandhelp.jsp" %>




<div id="table1" style="display:none;">
<table class="frame-table" align="center">
  <tr height="50px"><th>系统提示</th></tr>
  <tr>
    <td>欢迎您加入山东大学青年志愿者协会，您可以：<br><br>
    <a href="volunteer-activity-list.jsp" target="_self">浏览志愿活动</a><br>
	  <a href="volunteer-project-list.jsp" target="_self">参加志愿竞赛项目</a><br>
	  <a href="volunteer-search.jsp" target="_self">进行志愿信息查询</a>
    </td>
  </tr>
  <tr height="50px">
	<th>
	  
	</th>
  </tr>
</table>
</div>
<div id="table2" >
<table class="frame-table" align="center">
  <tr height="50px"><th>系统提示</th></tr>
  <tr>
    <td>您尚未加入山东大学青年志愿者协会，是否申请成为志愿者？</td>
  </tr>
  <tr height="50px">
	<th>
	
	  <a href="../main/volunter/BaseUserCodeAction.jsp?cmd=gaiziyuan&Id=<%=user.getId()%>" target="_self">是</a> | 
	  <a href="#">否</a>  
	</th>
  </tr>
</table>
</div>
</body>

<%} %>
</html>