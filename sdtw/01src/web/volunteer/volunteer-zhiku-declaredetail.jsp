<%@ page pageEncoding="GBK" %>
<%@ page import="java.sql.*" %>
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
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<style type="text/css">
.itemname{
	display:inline-block;
	width:100px;
	text-align:center;
}
</style>
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
String declareid=request.getParameter("Id");

String cd1="",cd2="",cd3="",cd4="",cd5="",cd6="",cd7="",cd8="",cd9="",cd10="",cd11="",cd12="",cd13="",cd14="",cd15="",cd16="";
String cdteam="",addfilelist="";
System.out.println("ID"+declareid);
String ids="";
UserInfo userInfo = Tool.getUserInfo(request);
List list= new ArrayList();
  List cdt=new ArrayList();
  VolunteerZhikuDeclare vd= new  VolunteerZhikuDeclare();
  cdt.add("id="+declareid);
  list=vd.query(cdt);
  if(list.size()>0){
	  vd=(VolunteerZhikuDeclare)list.get(0);
	  ids=vd.getAddfilelist();
	  cd10=vd.getCost1();
	  cd11=vd.getCost2();
	  cd12=vd.getCost3();
	  cd13=vd.getCost4();
	  cd14=vd.getCost5();
	 cd16=vd.getTotalcost();
	
	  
  }
  List zhuguanoptions=CEditConst.getAcademyNameOptions(userInfo);
%>
<body>
<%
String strposition = "志愿服务>>山大志库>>";
String strfunction = "申请表详细";
String strhelpwords = "已填的申请表。";
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>山大志库>><%=vd.getName() %>申请表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr height="35px">
	<td>
		<a href="volunteer-zhiku-list.jsp" >返回</a>
	</td>
</tr>    
</table>

<form name="form1" method="post" action="volunteer-zhiku-declaresave.jsp">
<table class="content-table">
<tr>
	<th colspan="3" align="left">“山大志库”申请表</th> 
</tr>
<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left" colspan="2"><%=vd.getName()%></td>
</tr>
<tr>
	<td align="right">团队名称</td>
	<td align="left" colspan="2"><%=vd.getTeamname()%></td>
</tr>
<tr>
	<td align="right">所属单位</td>
	<td align="left" colspan="2"><%=HtmlTool.renderSelect(zhuguanoptions, vd.getAcademy() + "", "Academy", "-1",true)%></td>
</tr>
<tr>
	<td align="right">项目分组</td>
	<td align="left" colspan="2"><%=(String)CEditConst.getZkProjectTypeMap(userInfo).get(vd.getType()+"")%></td>
</tr>
<tr>
	<td align="right">活动背景及目的</td>
	<td align="left" colspan="2"><%=vd.getIntention()%></td>
</tr>
<tr>
	<td align="right">活动时间安排</td>
	<td align="left" colspan="2"><%=vd.getProcess()%></td>
</tr>
<tr>
	<td align="right">活动流程</td>
	<td align="left" colspan="2"><%=vd.getArrange()%></td>
</tr>
<tr>
	<td align="right">预期成果</td>
	<td align="left" colspan="2"><%=vd.getExpectresults()%></td>
</tr>
<tr>
	<td align="right">已取得成果（选填）</td>
	<td align="left" colspan="2"><%=vd.getResults()%></td>
</tr>

<tr>
	<td align="right"><p>团队组成情况<p/></td>
	<td align="left" colspan="2">
		<table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td><td>团队分工</td>
			</tr>
		<%
		String snoids="";
		if(vd.getId()!=-1){
			VolunteerZhikuTeammember vpt= new VolunteerZhikuTeammember();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			List dianhualist=new ArrayList();
			String vppid= vd.getId()+"";
			cdt2.add("zhikudeclareid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(VolunteerZhikuTeammember)list2.get(i);
					snoidlist.add(vpt.getSno());
					 dutylist.add(vpt.getDuty());
					 dianhualist.add(vpt.getPhone());
				}
			}
		snoids=Tool.join(",", snoidlist);
		System.out.println(snoids+"sssssssssssssssssss");
			BaseUserCode stu= new BaseUserCode();
			List list3= new ArrayList();
			List cdt3= new ArrayList();
			cdt3.add("id in ("+snoids+")");
			String xueyuan="";
			String duty="";
			list3=stu.query(cdt3);
			if(list3.size()>0){
				for(int i=0;i<list3.size();i++){
				stu = (BaseUserCode)list3.get(i)	;
				 xueyuan=(String)CEditConst.getAcademyNameMap(userInfo).get(stu.getDeptId()+"");
				 duty=((String)dutylist.get(i)).equals("-1")?"":(String)dutylist.get(i);
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td><%=stu.getName() %></td><td><%=stu.getCnName() %></td><td><%=xueyuan %></td><td><%= dianhualist.get(i) %></td><td><input size='10' name='zhiwu<%=i %>' value="<%=duty %>" /></td></tr>
				<% 
				}
			}
		}
		
		%>	
			
		</table>
	</td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left" colspan="2">
		<p><span class="itemname">交通费  </span><%=cd10%></p>
		<p><span class="itemname">住宿费  </span><%=cd11%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd12%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd13%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd14%></p>
		
		<p><span class="itemname">共计  </span><%=cd16%></p>
	</td>
</tr>
<tr>
	<td align="right">附件</td>
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
	<th colspan="2">
	</th>
</tr>
</table>
</form>

</body>
</html>