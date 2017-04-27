<%@ page contentType="text/html;charset=utf-8" %>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HtmlTool"%>

<%
String sno=(String)session.getAttribute("useraccount");


%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../main/css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../main/js/tablelist.js"></script>
<script src="../main/js/jquery.min.js"></script>

</head>
<%
UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
	return;
}
BaseUserCode user= new BaseUserCode();

user=userinfo.getUserCode();
user=user.getById(user.getId());
if(user.getVolunteerfFag().equals("1")){
%>
<body>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置：志愿服务：志愿履历浏览
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<%
String strposition = "志愿服务工作  >> 志愿服务履历 >> ";
String strfunction = "参与志愿活动列表";
String strhelpwords= "该列表列出了详细信息。";
%>


<table class="command-table">
<tr>
    <td>
       <a href="#" onclick="history.go(-1)">返回</a> 
    </td>
</tr>
</table>

<table class="content-table">

<tr >
	<th width="5%">序号</th>
	<th width="20%">&nbsp;活动名称</th>
	<th width="20%">&nbsp;活动级别</th>
	<th width="20%">&nbsp;活动类别</th>
	<th width="20%">&nbsp;服务时长</th>
	<th align="center">&nbsp;所获荣誉</th>
</tr>
<%

Map activityNamemap= CEditConst.getVolunActivityNameMap(userinfo);

ResultSet rs=null,rs2 = null;
String  activityname="",activitykind="",activitylevel="",honourname="",servicelength ="";
List list= new ArrayList();
List cdt= new ArrayList();
VolunteerActivity va=new VolunteerActivity();
cdt.add("checkflag=1");
Map<String,VolunteerActivity> map= new HashMap<String,VolunteerActivity>();
list=va.query(cdt);
if(list.size()>0){
	for(int i=0;i<list.size();i++){
		va=(VolunteerActivity )list.get(i);
		map.put(va.getId()+"", va);
	}
}
System.out.println(map);
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerParticipate vp= new VolunteerParticipate();
cdt1.add("sno='"+user.getName()+"'");
cdt1.add("checkflag=1");
list1=vp.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		vp=(VolunteerParticipate)list1.get(i);	
		activityname="<a href='volunteer-activity-details.jsp?id="+va.getId()+"'>"+(String)activityNamemap.get(vp.getActivityId()+"")+"</a>";
		servicelength =vp.getServicelenth()+"";
		honourname=vp.getHonourName();
		if(map.containsKey(vp.getActivityId()+"")){
			va=map.get(vp.getActivityId()+"");
			activitylevel=va.getActivityLevel();
			activitykind=va.getActivityKind();
		}
 %>
<tr>
	<td><%=i+1%>&nbsp;</td>
	<td><%=activityname%>&nbsp;</td>
	<td><%=activitylevel%>&nbsp;</td>
	<td><%=activitykind%>&nbsp;</td>
	<td><%=servicelength %>&nbsp;</td>
	<td><%=honourname%>&nbsp;</td>
 </tr>
<%}} else{%>

<tr>
	<td colspan="6" >未参与过志愿活动!</td>
</tr>	
<%} %>

<tr>    
	<th  colspan="6" align="left">参加所有活动服务总时长	
	</th>
</tr>
</table>
</body>
<%}else{
	%>
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