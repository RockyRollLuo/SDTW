<%@page import="com.xietong.software.sdtw.db.ChuangkuDeclare"%>
<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

</head>
<%
UserInfo userInfo=Tool.getUserInfo(request);
if(userInfo==null){
	return;
}
int declareid=ParamUtils.getIntParameter(request, "Id", -1);
Map zhongleiOptions=CEditConst.getCkProjectTypeMap(userInfo);
Map chuangyefenzuOptions=CEditConst.getCkProjectGroupMap(userInfo);
System.out.println(chuangyefenzuOptions);
Map xiangmujieduan=CEditConst.getCkProjectStageMap(userInfo);

String cd1="",cd2="",cd3="",cd4="",cd5="",cd6="",cd7="",cd8="",cd9="",cd10="",cd11="",cd12="",cd13="",cd14="";
String cdp1="",cdp2="",cdp3="",cdp4="",cdp5="",cdteam="",addfilelist="";
ChuangkuDeclare cd= new  ChuangkuDeclare ();
cd=cd.getById(declareid);

cd1=cd.getCd1();
if(cd.getCd2()!=""){
cd2=(String)zhongleiOptions.get(cd.getCd2());
}
if(cd.getCd3()!=""){
cd3=(String)chuangyefenzuOptions.get(cd.getCd3()+"");
}
cd4=cd.getCd4();
cd5=cd.getCd5();
cd6=cd.getCd6();

if(cd.getCd7()!=""){
cd7=(String)xiangmujieduan.get(cd.getCd7()+"  ");
}
cd8=cd.getCd8();
cd9=cd.getCd9();
cd10=cd.getCd10();
cd11=cd.getCd11();
cd12=cd.getCd12();
cd13=cd.getCd13();
cd14=cd.getCd14();
%>
<body>
<%
String strposition = "创新创业>>山大创库>>";
String strfunction = "申请表详细";
String strhelpwords = "已填的申请表。";
%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>山大创库>><%=cd.getCd1() %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr height="35px">
	<td>
		<a href="innovation-chuangku-list.jsp" >返回</a>
	</td>
</tr>    
</table>

<form name="form1" method="post" action="innovation-chuangku-declaresave.jsp">
<input type="hidden" name="cdteam" value=""/>
<table class="content-table">
<tr>
	<th colspan="8" align="left">“山大创库”项目入库申请表</th> 
</tr>

<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left"><%=cd1%></td>
</tr>
<tr>
	<td align="right">项目分类</td>
	<td align="left"><%=cd2%></td>
</tr>
<tr>
	<td align="right">项目分组</td>
	<td align="left"><%=cd3%></td>
</tr>
<tr>
	<td align="right">创业团队</td>
	<td align="left">
		<table class="content-table" id="teamtable">
			<tr>
				<td>姓名</td><td>学院</td><td>学号</td><td>联系方式</td><td>职责</td>
				<%
				BaseUserCode stu= new BaseUserCode();
				Map xynamemap=CEditConst.getAcademyNameMap(userInfo);
				ChuangkuDeclareMembers vpm= new ChuangkuDeclareMembers();
				List cdt1= new ArrayList();
				List list1= new ArrayList();
				cdt1.add("chuangkudeclareid ="+cd.getId());
				list1=vpm.query(cdt1);
				if(list1.size()>0){
					for(int i=0;i<list1.size();i++){
					vpm=(ChuangkuDeclareMembers)list1.get(i);
					stu=stu.getById(Integer.parseInt(vpm.getName()));
					cdp1=stu.getCnName();
					cdp2="";
					if(stu.getDeptId()!=-1){
					cdp2=(String)xynamemap.get(stu.getDeptId()+"");
					}
					cdp3= stu.getName();
					cdp4=vpm.getTel();
					cdp5=vpm.getDuty();
				 
				%>
			</tr>
			<tr>
				
				<td><%=cdp1%></td>
				<td><%=cdp2%></td>
				<td><%=cdp3%></td>
				<td><%=cdp4%></td>
				<td><%=cdp5%></td>
			</tr>
			<% 
					}
				}
			
			%>
	
		</table>
	</td>
</tr>
<tr>
	<td align="right">技术可行性分析</td>
	<td align="left"><%=cd4%></td>
</tr>
<tr>
	<td align="right">市场可行性分析</td>
	<td align="left"><%=cd5%></td>
</tr>
<tr>
	<td align="right">项目推进时间分析</td>
	<td align="left"><%=cd6%></td>
</tr>
<tr>
	<td align="right">项目阶段</td>
	<td align="left"><%=cd7%></td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left">
		<p>是否有社会资金注入：<%=cd8%>（请注明注资额度为<%=cd9%> 万）</p>
		<p>计划注册资本金为：<%=cd10%>万，其中创业团队自有资金<%=cd11%> 万</p>
		<p>团队已经经营该项目时间：<%=cd12%>个月，盈利情况：<%=cd13%> 万</p>
	</td>
</tr>
<tr>
	<td align="right">备注</td>
	<td align="left"><%=cd14%></td>
</tr>
<tr>
	<td align="right">附件</td>
	<td align="left">
 <%
 String ids="";
 ids=cd.getAddFilelist();
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