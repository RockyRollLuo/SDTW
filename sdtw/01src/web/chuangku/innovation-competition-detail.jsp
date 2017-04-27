<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %> 
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.base.Power"%>

<%!
ResultSet rs = null;
//保存数据使用的分隔符
String f1="\10";
String f2="\20";
%>

<%
//接收客户端提交的数据

String production_code="",production_name="", projectname="", academy="",declarer="", production_type="",declarer_role="",leader="",leaderid="",team="",remark="", addfilelist="",twcheck="",xycheck="",twcheckcomment="",xycheckcomment="",award="";
int checkflag = 0, xystate=0, twstate=0;

  %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../js/tablelist.js"></script> 
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script> 
<script type="text/javascript">
function formsubmit(){
	var tmpCheckflag = $('input:radio[name="checkflag"]:checked').val();
	var tmpCheckcomment =  document.checkform.checkcomment.value;
 	if ((tmpCheckcomment=="" || tmpCheckcomment=="null")&& (tmpCheckflag==130 || tmpCheckflag==123 || tmpCheckflag==242)){
    	alert("请填写审核意见！");
    	document.checkform.checkcomment.focus();
    	return false;
  	}
 	document.checkform.submit();
}
</script>
</head>

<body>
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
Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);
Map usercnmamemaps=CEditConst.getUserCnNameMap(userInfo);
Map production_typemaps=CEditConst.getProductionTypeMap(userInfo);
Map checkmaps=CEditConst.getCancleCheckFlagMap(userInfo);
List projectOptions=new  ArrayList();
Honor honor= new Honor();
List list1=new ArrayList();
List cdt1= new ArrayList();
Map honormap=new HashMap();
cdt1.add("honorType =7");
list1=honor.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		honor=( Honor)list1.get(i);
		honormap.put(""+honor.getId(), honor.getHonorName());
	}
}
System.out.println( projectOptions);
InnovationCompetitionProject icp= new InnovationCompetitionProject();
List cdt= new  ArrayList();
List list= new ArrayList();
list =icp.query(cdt);
int xuhao=0;
int tiaoshu=list.size();
if(list.size()>0){
	OptionBean ob= new OptionBean("","");
	projectOptions.add(ob);
	for(int i=0;i<list.size();i++){
		icp=(InnovationCompetitionProject)list.get(i);
		ob= new OptionBean(icp.getProjectName(),icp.getId()+"");
		projectOptions.add(ob);
	}
	
}
String strposition = "创新创业管理>>竞赛管理";
String strfunction = "竞赛作品详细信息";
String strhelpwords = "竞赛作品详细信息。";
int  id=ParamUtils.getIntParameter(request, "Id", -1);

InnovationCompetition ic= new InnovationCompetition();
ic=ic.getById(id);
production_code=ic.getProductionCode();
production_name=ic.getProductionName();

if(ic.getAcademy()!=""){
	academy=(String)xynamemaps.get(ic.getAcademy());

}
projectname=ic.getProjectName();
declarer=ic.getDeclarer();
production_type=(String)production_typemaps.get(ic.getProductionType());
declarer_role=ic.getDeclarerRole();
leader=ic.getLeader();
String leaderphone=ic.getLeaderId();
String ids=ic.getAddFilelist();
xycheck=(String)checkmaps.get(ic.getCheckFlagXy()+"");
twcheck=(String)checkmaps.get(ic.getCheckFlagTw()+"");
xycheckcomment=ic.getCheckCommentXy();
twcheckcomment=ic.getCheckCommentTw();
if(ic.getAward()!=""){
award=(String)honormap.get(ic.getAward());
}
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>创业竞赛>><%=ic.getProductionName() %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="content-table" width="97%" cellpadding="0" cellspacing="0" style="margin-top:10px">
<tr height="40">
  <td width="30%" class="table_topic" align="center" style="border-right:0">【竞赛作品详细信息】</td>
  <td class="table_topic" align="right" style="padding-right:20px;color:#000">&nbsp;

  </td>
</tr>

<tr height="40">
  <td  width="20%"align="right">&nbsp;作品名称：</td>
  <td align="left"><%=production_name %>&nbsp;</td>
</tr>
<tr height="40">
  <td  width="20%"align="right">&nbsp;所属项目：</td>
  <td align="left">
  
  <%=HtmlTool.renderSelect(projectOptions,  ic.getProjectName(), "ProjectName", "-1",true)%>
  </td>
</tr>
<tr height="40">
  <td  align="right">&nbsp;学院全称：</td>
  <td align="left"><%=academy%>&nbsp;</td>
</tr>
<tr height="40">
  <td  width="20%"align="right">&nbsp;申报者姓名（集体名称）：</td>
  <td align="left"><%=declarer%>&nbsp;</td>
</tr>
<tr height="40">
  <td  width="20%"align="right">&nbsp;作品类别：</td>
  <td align="left"><%=production_type%>&nbsp;</td>
</tr>
<tr height="40">
  <td  width="20%"align="right">&nbsp;申报类别：</td>
  <td align="left" >个人申报&nbsp;</td>
</tr>
<tr height="40">
  <td  width="20%"align="right">&nbsp;获奖情况：</td>
  <td align="left"><%=award%>&nbsp;</td>
</tr>
<tr height="40">
  <td  align="right">&nbsp;负责人：</td>
  <td align="left" ><%=leader%>&nbsp;</td>
</tr>
<tr height="40">
  <td  align="right">&nbsp;负责人联系电话：</td>
  <td align="left" ><%=leaderphone%>&nbsp;</td>
</tr>
<tr height="40">
  <td  align="right">团队成员：</td>
  <td >
  	<table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td>
			</tr>
		<%
		String snoids="";
		if(ic.getId()!=-1){
			InnovationCompetitionMembers  vpt= new 	InnovationCompetitionMembers();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			String vppid= ic.getId()+"";
			cdt2.add("productionid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			List phonelist= new ArrayList();
			String xueyuan="";
			BaseUserCode stu= new BaseUserCode();
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(	InnovationCompetitionMembers)list2.get(i);
				
			stu=stu.getById(Integer.parseInt(vpt.getName()));
		
	
				 xueyuan=(String)CEditConst.getAcademyNameMap(userInfo).get(stu.getDeptId()+"");
				
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td><%=stu.getName() %></td><td><%=stu.getCnName() %></td><td><%=xueyuan %></td><td><%=vpt.getTel() %></td></tr>
				<% 
				}
			}
		}
		
		%>	
			
		</table>
  
  
  
  
  
  
  
  
  
  </td>
</tr>
<tr height="40">
  <td  align="right">备注：</td>
  <td align="left"><%=remark%>&nbsp;</td>
</tr>
<tr>
	<td align="right">附件</td>
	<td align="left" align="left">
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


<form name="checkform" method="POST" action="innovation-competition-check.jsp?id=<%=id%>">
<input name="leader" type="hidden" value="<%=leader%>">
<input name="leaderid" type="hidden" value="<%=leaderid%>">
<input name="production_name" type="hidden" value="<%=production_name%>">
<tr height="40">
  <td  align="right">&nbsp;团委审核：</td>
    <td  align="left">
     <%=twcheck %>
  </td>
</tr>

<tr height="40">
  <td  align="right">&nbsp;审核意见：</td>
    <td align="left" >
<%=twcheckcomment %>
  </td>
</tr>


<tr height="40">
  <td   align="right">&nbsp;学院审核：</td>
    <td align="left">
     <%=xycheck %>
  </td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>&nbsp;审核意见：</td>
    <td align="left" >
  <%=xycheckcomment %>
  </td>
</tr>


<tr height="35">
  <td  width="100%" colspan="2" align="center">
    <a href="#" onclick="history.go(-1)">返  回</a>
  </td>
</tr>

</form>
</table>
</body>
</html>