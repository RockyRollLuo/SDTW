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
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%! 
%>
<% 
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));

System.out.println(pagenumstr);
int start=0;
%>

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
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
user=user.getById(user.getId());
System.out.println(user.getVolunteerfFag()+"zhiyuanze");
if(user.getVolunteerfFag().equals("1")){
	

	%>

<body>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>志愿竞赛项目列表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>





<%
String strposition = "志愿服务>>志愿竞赛项目>>";
String strfunction = "竞赛项目列表";
String strhelpwords = "负责志愿竞赛项目的添加、修改、删除以及审核工作，点击竞赛项目名称的超链接可以进入相应的竞赛项目审核管理的界面。";
%>


<table class="command-table" id="table1">
<tr height="30px">
	<td></td>
</tr>
</table>

<table class="content-table" id="table2">
<tr>
<th width="5%">序号</th>
<th width="10%">项目名称</th>
<th width="15%">比赛日期</th>

<th width="10%">申报截止日期</th>

<th width="10%">学院审核</th>
<th width="10%">团委审核</th>
<th colspan="3">项目申报</th>

</tr>

<%


String istr, projectcode,projectname,projectnamehref="",addaccount,addtime,deadline,participatehref="",honourhref,submithref="",cancelhref="",checkstatus="";
String teammemberslist = "",teammajorvolunteer = "",teamcode="",starttime="",endtime="",xychecktype="",twchecktype="",submithref2="",submithref3="",subtype="";
int id=0,pubflag=0,projectid=0,rowscount=0;

Map<String,VolunteerProjectParticipate> map= new HashMap<String,VolunteerProjectParticipate>();
List<String> yichanjia= new ArrayList<String> ();
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerProjectParticipate vp= new VolunteerProjectParticipate();
cdt1.add("sno='"+user.getName()+"'");
list1=vp.query(cdt1);
for(int i=0;i<list1.size();i++){
	vp=(VolunteerProjectParticipate)list1.get(i);

	map.put(vp.getProjectId()+"", vp);
}
System.out.println("22222222222"+map);
//华丽分割线
List list= new ArrayList();
List cdt= new ArrayList();
java.util.Date now = new java.util.Date();
VolunteerProject va=new VolunteerProject();
Map checkmap=CEditConst.getCheckTypeMap(userinfo);

cdt.add("order by deadline desc ");
list=va.query(cdt);
int tiaoshu=list.size();
start=(pagenumstr-1)*8;

int end=list.size()>pagenumstr*8?pagenumstr*8:list.size();
if(list.size()>0){

	System.out.println(list.size());
for(int i=start;i<end;i++)	{
	 checkstatus="";
	 xychecktype="";
	 twchecktype="";
	 va=(VolunteerProject)list.get(i);
      
       projectnamehref="<a href='volunteer-project-details.jsp?id="+va.getId()+"'>"+va.getProjectName()+"</a>";
      
       starttime=Tool.stringOfDate(va.getStartTime());
       endtime=Tool.stringOfDate(va.getStartTime())+"~"+Tool.stringOfDate(va.getEndTime());
       deadline=Tool.stringOfDate(va.getDeadline());
       
       submithref="<a href='volunteer-project-participate.jsp?ProjectId="+va.getId()+"&page=1'>填写申报信息</a>";
       
       if(map.containsKey(va.getId()+"")){
    	   if(map.get(va.getId()+"").getSubmitFlag()==0){
    		   submithref="<a href='volunteer-project-participate.jsp?ProjectId="+va.getId()+"&page=1'>已填申报信息</a>";
    	   submithref2="<a href='VolunteerProjectParticipateAction.jsp?cmd=modify&Id="+map.get(va.getId()+"").getId()+"'>确认提交 </a>";}
    	  if(map.get(va.getId()+"").getSubmitFlag()!=0){
    		  submithref="<a href='volunteer-project-participate.jsp?ProjectId="+va.getId()+"&page=1'>已填申报信息</a>";
    		   submithref3="<a href='VolunteerProjectParticipateAction.jsp?cmd=modify1&Id="+map.get(va.getId()+"").getId()+"'>取消提交 </a>";;  
    	   }
    	   System.out.println(submithref2);
           
    	   checkstatus=  "已参加";
    	   subtype=map.get(va.getId()+"").getSubmitFlag()+"";
    	   xychecktype=map.get(va.getId()+"").getXycheckFalg()+"";
    	   twchecktype=map.get(va.getId()+"").getCheckFlag()+"";
    	   if( subtype.equals("0")){
    		   xychecktype="未提交"  ; 
    		   twchecktype="未提交" ;
    	   } 
    	   if( xychecktype.equals("0")){
    		   xychecktype="未审核"  ; 
    	   } 
    	   if( xychecktype.equals("1")){
    		   xychecktype="审核通过"  ; 
    	   } 
    	   if( xychecktype.equals("2")){
    		   xychecktype="<font color='red'>审核未通过 <font>"  ; 
    	   }
    	   if( twchecktype.equals("-1")){
    		   ; 
    	   } 
    	   if( twchecktype.equals("0")){
    		   twchecktype="未审核"  ; 
    	   } 
    	   if( twchecktype.equals("1")){
    		   twchecktype="审核通过"  ; 
    	   } 
    	   if( twchecktype.equals("2")){
    		   twchecktype="<font color='red'>审核未通过 <font>"  ; 
    	   }
       }else{
    	   checkstatus=  "<font color='red'>未参加 <font>";
       } 
	  %>      
<tr>
  <td><%=i+1%></td>
  <td><%=projectnamehref%></td>  
  <td><%=endtime%></td>
  <td><%= deadline %></td>
 
  
  <td><%=xychecktype %></td>
  <td><%=twchecktype %></td>
  <td><%=submithref %></td>
  <td><%=submithref2 %></td>
  <td><%=submithref3%></td>

  
</tr>
<%
submithref2="";
submithref3="";
}} %>
<tr height=40>
	<th width="100%" colspan="15" align="center">
		共&nbsp<%=tiaoshu %>&nbsp条&nbsp;&nbsp;&nbsp;当前第<%=pagenumstr %>页&nbsp;&nbsp;&nbsp;
		<%
		
		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		%>
   		<a href="volunteer-project-list.jsp?">首页</a>&nbsp;&nbsp;&nbsp;
		<a href="volunteer-project-list.jsp?page=<%=shangyiye %>" >上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="volunteer-project-list.jsp?page=<%=xiayiye %>" >下一页</a>&nbsp;&nbsp;&nbsp;
    
		
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