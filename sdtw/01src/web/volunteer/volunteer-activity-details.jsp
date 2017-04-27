<%@ page contentType="text/html;charset=utf-8" %>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.HeadConst"%>

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
ResultSet rs = null;
String id=request.getParameter("id");

String addfilelist="",foldercode="";
String activityname="",activitykind="",activitylevel="",addtime="",activityexplain="";
String starttime="",endtime="",deadline="",activityprincipal="",contact="",guideteacher="",applicationrange="",activitystatus="";
String addperson="",checkaccount="",launchacademy="",checktime="",checkstatus="";
String explainnew="",placetimestr="",activityplace="",applicationtype="";
String ids="";
Map citymaps= CEditConst.getOrgCityNameMap(userInfo);
Map xueyuanmaps=CEditConst.getAcademyNameMap(userInfo);
int personnumber=0,checkflag=0,placeflag=0;
List list= new ArrayList();
List cdt= new ArrayList();
cdt.add("id="+id);
VolunteerActivity va=new VolunteerActivity();
list=va.query( cdt);
String xueyuan="";
String xiaoqu="";
if(list.size()>0){
	va=(VolunteerActivity)list.get(0);
	activityname=va.getActivityname();
	activitykind=va.getActivityKind();
	activitylevel=va.getActivityLevel().equals(0)?"院级":"院级";
	 starttime=Tool.stringOfDate(va.getStarttime());
     endtime=Tool.stringOfDate(va.getEndtime());
     deadline=Tool.stringOfDate(va.getDeadline());
     activityplace=va.getActivityPlace();
     personnumber=va.getPersonNumber();
     activityprincipal=va.getActivityPrincipal();
     contact=va.getContact();
     guideteacher=va.getGuideTeacher();
     activityexplain=va.getActivityExplain();
     
     applicationrange=va.getApplicationRange();
     applicationtype=va.getApplicationRangeType();
     List xueyuanlist=Arrays.asList(applicationtype.split(","));
     if(xueyuanlist.size()>0){
    	 for(int i=0;i<xueyuanlist.size();i++){
    		 if(xueyuanmaps.get(xueyuanlist.get(i)+"")!=null){
    			 if(xueyuan.length()>0){
    		 xueyuan+=","+xueyuanmaps.get(xueyuanlist.get(i)+"");
    			 }else{
    				 xueyuan+=xueyuanmaps.get(xueyuanlist.get(i)+""); 
    			 }
    		 }
    	 }
     }
   
    List xiaoqulist=Arrays.asList( applicationrange.split(","));
    if(xiaoqulist.size()>0){
   	 for(int i=0;i<xiaoqulist.size();i++){
   		 if(xiaoqu.length()>0){
   		 xiaoqu+=","+citymaps.get(xiaoqulist.get(i)+"");
   		 }else{
   			 xiaoqu+=citymaps.get(xiaoqulist.get(i)+""); 
   		 }
   	 }
    }
     ids=va.getAddFilelist();
}

%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script></head>

<body>
<%
String strposition = "志愿服务 >>志愿活动浏览>> ";
String strfunction = "活动详细信息";
String strhelpwords= "志愿活动的详细信息。";
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>志愿活动>><%=activityname %>详情
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr>
	<td>
 	   <a href="volunteer-activity-list.jsp">返回</a>
	</td>
</tr>
</table>
<table class="content-table">
<tr>
	<th colspan="2" align="left">活动详细信息</th>
</tr>
<tr>
	 <td width="30%" align="right">活动名称：</td>
	 <td align="left" ><%=activityname%>&nbsp; </td>
</tr>

<tr>
	 <td align="right">&nbsp;活动类别：</td>
	 <td align="left"><%=activitykind%>&nbsp;
	 </td>
</tr>
<tr>
	 <td align="right">&nbsp;活动级别：</td>
	 <td align="left"><%=activitylevel%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;活动日期：</td>
	 <td align="left"><%=starttime%>~<%=endtime%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;活动地点：</td>
	 <td align="left"><%=activityplace%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;申请范围：</td>
	 <td align="left">学院：<%=xueyuan%>&nbsp&nbsp&nbsp&nbsp校区：<%=xiaoqu %>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;活动报名截止时间：</td>
	 <td align="left"><%=deadline%>&nbsp;
	 </td>
</tr>

<tr>
	 <td  align="right">&nbsp;所需人数：</td>
	 <td align="left"><%=personnumber%>人&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;负责人：</td>
	 <td align="left"><%=activityprincipal%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;联系方式：</td>
	 <td align="left"><%=contact%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;指导教师：</td>
	 <td align="left"><%=guideteacher%>&nbsp;
	 </td>
</tr>
<tr>
	 <td  align="right">&nbsp;详细介绍：</td>
	 <td  align="left"><%=activityexplain%>&nbsp;
	 </td>
</tr>

<tr>
	<td align="right">附件：</td>
	<td align="left">
 <%
 ClientAttach ca1=new ClientAttach();
 ClientAttach ca = new ClientAttach();

 if(ids!=null&&ids.trim().length()>0){
 	String[] idArray = Tool.split(",",ids);
 	System.out.println(idArray);
 	for(int i=0;i<idArray.length;i++){
 	ca1= ca.getById(Tool.StrToInt(idArray[i]));
 	 %>
 	 <a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/>下载文件<%=ca1.getUploadName() %>
 	</a> 
 	<%
 	}
 }


%>  
	</td>
</tr>




<tr>
	<th colspan="2"></th>
</tr>
</table>

</body>
</html>
