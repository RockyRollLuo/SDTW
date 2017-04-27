
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.VolunteerParticipate"%>
<%@page import="com.xietong.software.sdtw.db.VolunteerActivity"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>
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
String academy = (String)session.getAttribute("academy");
String myaccount = (String)session.getAttribute("useraccount");
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));

System.out.println(pagenumstr);
int start=0;

%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../main/js/tablelist.js"></script>
<script src="../main/js/jquery.min.js"></script>
<script type="text/javascript">

 function submit1(){
	 $("#postForm").submit();
	 alert("111111111111")
	 
 }
 
</script>
</head>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode user= new BaseUserCode();

user=userInfo.getUserCode();
user=user.getById(user.getId());
Map OrgNameMap=CEditConst.getOrgNameMap(userInfo);
Map detpnameMap=CEditConst.getAcademyNameMap(userInfo);
List cdt= new ArrayList();
cdt.add("flag =1");
List academyOptions=COptionConst.getAcademyNameOptions(userInfo,"", cdt);
 String xiaoqu=user.getOrgId()+"";
 String xueyuan=user.getDeptId()+"";
 System.out.println(OrgNameMap);
 System.out.println(xueyuan+xiaoqu);
 System.out.println(xiaoqu+xueyuan);
if(user.getVolunteerfFag().equals("1")){
	%>
<body>

<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>志愿活动浏览
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>


<%
String strposition = "志愿服务>>志愿活动浏览>>";
String strfunction = "志愿活动列表";
String strhelpwords = "志愿活动的申请。";
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>

<form name="query" method="post" action="volunteer-activity-list.jsp">
<table class="command-table">
        <tr>
      <td>

   		<%=HtmlTool.renderSelect(academyOptions, "" + ParamUtils.getParameter(request, "_acdemy_", ""), "_acdemy_", "-1")%>
      </td>
     
      <td >

   
        
 
        活动名称<input name="_huodong_" value="<%=ParamUtils.getParameter(request, "_huodong_", "") %>" type="text" size="20"/>
        
        </td>
          <td ><a href="#" onclick="javascript:document.query.submit();">查询</a></td>
        </tr>
</table>
</form>

<table class="content-table" id="table2">
<tr>
    <th width="4%">序号</th>
	<th width="15%">名称</th>
	<th width="10%">发起单位</th>
	
	<th width="12%">活动类别</th>
	<th width="15%">活动日期</th>
	<th width="10%">报名截止日期</th>
	<th width="10%">是否参与</th>
	<th width="10%">审核状态</th>
	<th width="10%">报名活动</th>
	
</tr>

<%
int tiaoshu=0;
Map<String,VolunteerParticipate> map= new HashMap<String,VolunteerParticipate>();
List<String> yichanjia= new ArrayList<String> ();
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerParticipate vp= new VolunteerParticipate();
cdt1.add("sno='"+user.getName()+"'");
list1=vp.query(cdt1);

for(int i=0;i<list1.size();i++){
	vp=(VolunteerParticipate)list1.get(i);

	map.put(vp.getActivityId()+"", vp);
}
System.out.println("22222222222"+map);
System.out.println(yichanjia);
String strSQL2="",strSQL3="";
String activitycode="",activityname="",activitykind="",namehref="",honourlist="",evaluationlist="",placetimehref="";
String istr="",activitystatus="",checkstatus="",honourhref="",participatehref="",evaluationhref="",launchacademy="",applicationrange="",honourname="",evaluation="";
String starttime="",endtime="",deadline="",activityplace="",Activityname="",checktype="";
int id,order=0,checkflag=0,scheckflag=0,serivcelength=0,activityid;
String canjia="报名";
Map xynamenmap=CEditConst.getAcademyNameMap(userInfo);
List list= new ArrayList();
List cdt3= new ArrayList();
java.util.Date now = new java.util.Date();
VolunteerActivity va=new VolunteerActivity();
Map checkmap=CEditConst.getCheckTypeMap(userInfo);
String academy1=ParamUtils.getParameter(request, "_acdemy_", "-1");
if(academy1.length()>0&&academy1!="-1"){
	cdt3.add("launchacademy ="+academy1);
}
String huodong=ParamUtils.getParameter(request, "_huodong_", "-1");
if(huodong.length()>0&&huodong!="-1"){
    cdt3.add("activityname like '%" + huodong + "%'");

}
cdt3.add("checkflag=2");
cdt3.add("order by id desc ");

list=va.query(cdt3);
int end=0;

//过滤掉
List list2= new ArrayList();
for(int i=0;i<list.size();i++){
	 va=(VolunteerActivity)list.get(i);
	
  	 String sxueyuan=va.getApplicationRangeType();
  	 String sxiaoqu=va.getApplicationRange();
  	 System.out.println(sxiaoqu+"AAAAAAAAAAAA");
  	System.out.println(xiaoqu);
  	 if("".equals(sxueyuan)){
  		 list2.add(va); 
  	 }else{
  	  List xueyuanlist=Arrays.asList(sxueyuan.split(","));

  	   System.out.println(xueyuanlist);
     System.out.println(sxiaoqu.indexOf(xiaoqu));
	 
		  if(xueyuanlist.contains(xueyuan)&&sxiaoqu.indexOf(xiaoqu)>=0){
		  		 list2.add(va);
		  	   }
	  
	
}
}
if(list2.size()>0){
	tiaoshu=list2.size();
	start=(pagenumstr-1)*8;
    
	end=list2.size()>pagenumstr*8?pagenumstr*8:list2.size();
for(int i=start;i<end;i++)	{
	 va=(VolunteerActivity)list2.get(i);
       order=i;
       Activityname=va.getActivityname().length()>15?va.getActivityname().substring(0, 13)+"..":va.getActivityname();
       namehref="<a title='"+va.getActivityname()+"' href='volunteer-activity-details.jsp?id="+va.getId()+"'>"+va.getActivityname()+"</a>";
       launchacademy=(String)xynamenmap.get(va.getLaunchAcademy()+"")==null?"团委":(String)xynamenmap.get(va.getLaunchAcademy()+"");
       activitykind=va.getActivityKind();
       starttime=Tool.stringOfDate(va.getStarttime());
       endtime=Tool.stringOfDate(va.getEndtime());
       deadline=Tool.stringOfDate(va.getDeadline());
      

       if(map.containsKey(va.getId()+"")){
    	   canjia=""  ;
       checkstatus="已参加";
       checktype=map.get(va.getId()+"").getCheckFlag()+"";
       
       checktype=checktype.equals("-1")?"未审核":(checktype.equals("1")?"审核通过":"<font color='red'>审核未通过 <font>");
       }
       else{
    	   checkstatus=  "<font color='red'>未参加 <font>";
       }
    
%>
<tr>
  <td><%=order+1%></td>
  <td><%=namehref%></td>  
  <td><%=launchacademy%></td>
  
  <td><%=activitykind%></td>
  <td><%=starttime%>~<%=endtime%></td>
  <td><%=deadline%></td>
   <td><%=checkstatus %></td>
    <td><%=checktype %></td>
   <% 
   
   if((va.getDeadline().getTime()+86400000)<=now.getTime()){ %>
    <td><font color='red'>报名截止 <font></td>
   <%
   checktype="";
   } else{ 
	   
	   
	   
	   checktype="";%>
   
  <td><a href="volunteer-activity-apply.jsp?cmd=save&&page=<%=pagenumstr %>&&Sno=<%=user.getName() %>&&ActivityId=<%=va.getId() %>" "><%=canjia %></a>
  
 
 
  
  
  
  
  
  
  
  </td>
 
</tr>

<%
canjia="报名";
   
   }}} %>
<tr height=40>
	<th width="100%" colspan="15" align="center">
		共&nbsp<%=tiaoshu %>&nbsp条&nbsp;&nbsp;&nbsp;当前第<%=pagenumstr %>页&nbsp;&nbsp;&nbsp;
		<%
		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		%>
   		<a href="volunteer-activity-list.jsp?">首页</a>&nbsp;&nbsp;&nbsp;
		<a href="volunteer-activity-list.jsp?page=<%=shangyiye %>" >上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="volunteer-activity-list.jsp?page=<%=xiayiye %>" >下一页</a>&nbsp;&nbsp;&nbsp;
    
		
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


