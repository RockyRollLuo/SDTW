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
	out.print(HtmlTool.msgBox(request, "���ȵ�¼"));
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
String strposition = "־Ը����>>ɽ��־��>>";
String strfunction = "�������ϸ";
String strhelpwords = "����������";
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >����λ��>>־Ը����>>ɽ��־��>><%=vd.getName() %>�����
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr height="35px">
	<td>
		<a href="volunteer-zhiku-list.jsp" >����</a>
	</td>
</tr>    
</table>

<form name="form1" method="post" action="volunteer-zhiku-declaresave.jsp">
<table class="content-table">
<tr>
	<th colspan="3" align="left">��ɽ��־�⡱�����</th> 
</tr>
<tr>
	<td width="27%" align="right">��Ŀ����</td>
	<td align="left" colspan="2"><%=vd.getName()%></td>
</tr>
<tr>
	<td align="right">�Ŷ�����</td>
	<td align="left" colspan="2"><%=vd.getTeamname()%></td>
</tr>
<tr>
	<td align="right">������λ</td>
	<td align="left" colspan="2"><%=HtmlTool.renderSelect(zhuguanoptions, vd.getAcademy() + "", "Academy", "-1",true)%></td>
</tr>
<tr>
	<td align="right">��Ŀ����</td>
	<td align="left" colspan="2"><%=(String)CEditConst.getZkProjectTypeMap(userInfo).get(vd.getType()+"")%></td>
</tr>
<tr>
	<td align="right">�������Ŀ��</td>
	<td align="left" colspan="2"><%=vd.getIntention()%></td>
</tr>
<tr>
	<td align="right">�ʱ�䰲��</td>
	<td align="left" colspan="2"><%=vd.getProcess()%></td>
</tr>
<tr>
	<td align="right">�����</td>
	<td align="left" colspan="2"><%=vd.getArrange()%></td>
</tr>
<tr>
	<td align="right">Ԥ�ڳɹ�</td>
	<td align="left" colspan="2"><%=vd.getExpectresults()%></td>
</tr>
<tr>
	<td align="right">��ȡ�óɹ���ѡ�</td>
	<td align="left" colspan="2"><%=vd.getResults()%></td>
</tr>

<tr>
	<td align="right"><p>�Ŷ�������<p/></td>
	<td align="left" colspan="2">
		<table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>ѧ��</td><td>����</td><td>ѧԺ</td><td>��ϵ��ʽ</td><td>�Ŷӷֹ�</td>
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
	<td align="right">��Ŀ���</td>
	<td align="left" colspan="2">
		<p><span class="itemname">��ͨ��  </span><%=cd10%></p>
		<p><span class="itemname">ס�޷�  </span><%=cd11%></p>
		<p><span class="itemname">��������˵����  </span><%=cd12%></p>
		<p><span class="itemname">��������˵����  </span><%=cd13%></p>
		<p><span class="itemname">��������˵����  </span><%=cd14%></p>
		
		<p><span class="itemname">����  </span><%=cd16%></p>
	</td>
</tr>
<tr>
	<td align="right">����</td>
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
 	 <a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/>�����ļ�<%=ca1.getUploadName() %>
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