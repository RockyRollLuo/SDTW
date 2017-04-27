<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--创新创业竞赛管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%
	Log log = LogFactory.getLog(InnovationCompetition.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	InnovationCompetition v = (InnovationCompetition)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	forms.addAll((List)paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	BaseUserCode user=userInfo.getUserCode();
List DeclarerRoleTypeoptions = (List)request.getAttribute("DeclarerRoleTypeoptions");
List ProductionTypeoptions = (List)request.getAttribute("ProductionTypeoptions");
List Auditoptions = (List)request.getAttribute("Auditoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
String[] labelclass = {"labeloff", "labeloff", "labeloff", "labeloff"};
List jianglioptions=new ArrayList();
List cdt= new ArrayList();
List list1= new ArrayList();
String activityId=ParamUtils.getParameter(request,"_Projectname_","");
Honor ica= new Honor();
cdt.add("honorType=7");
cdt.add("activityId ="+activityId);
list1=ica.query(cdt);
OptionBean ob= new OptionBean("","");
jianglioptions.add(ob);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		ica=( Honor)list1.get(i);
		ob=new OptionBean(ica.getHonorName(),ica.getId()+"");
		jianglioptions.add(ob);
	}
}

List projectOptions=new  ArrayList();
System.out.println( projectOptions);
InnovationCompetitionProject icp= new InnovationCompetitionProject();
List cdt1= new  ArrayList();
List list= new ArrayList();
list =icp.query(cdt1);
int xuhao=0;
int tiaoshu=list.size();
if(list.size()>0){
	OptionBean ob1= new OptionBean("","");
	projectOptions.add(ob1);
	for(int i=0;i<list.size();i++){
		icp=(InnovationCompetitionProject)list.get(i);
		ob1= new OptionBean(icp.getProjectName(),icp.getId()+"");
		projectOptions.add(ob1);
	}
	
}
String titlename = ParamUtils.getParameter(request,"_titleName_","");
String name = "";
if ("bm".equals(titlename)) {
	name = "报名作品";
}
if ("honor".equals(titlename)) {
	name = "荣誉分配";
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
	<style>

.labelon {
	background:#e5f1f4;
	font-size:13px;
	cursor:hand; 
}
.labeloff {
	background:#3992d0; 
	font-size:12px;
	color:#fff;
	cursor:hand; 
}
</style>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				
			}
			function tongguo(){
				
          $("#CheckFlagTw").val(1);

				
				document.postForm.submit();
				
			}
			function xytongguo(){
				
		          $("#CheckFlagXy").val(1);

						
						document.postForm.submit();
						
					}
			function butongguo(){
				
				   $("#CheckFlagTw").val(2);
				   CheckCommentTw
				   if($("#CheckCommentTw").val()==""){
					   alert("团委审核不通过，请给出团委审核意见")
					    $("#other").click();
					  $("#CheckCommentTw").focus();
					   return;
				   }
				
				document.postForm.submit();
				
			}
			function xybutongguo(){
				
		          $("#CheckFlagXy").val(2);
		          if($("#CheckCommentXy").val()==""){
					   alert("学院审核不通过，请给出学院审核意见")
					   $("#team").click();
					  $("#CheckCommentXy").focus();
					   return;
				   }
						
						document.postForm.submit();
						
					}
			
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001"><%=name %></div>
				<div class="browsetitle002"><%=XtUtil.getSpell(name) %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="InnovationCompetitionAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						       <%
													           if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.CXCY)){
													           %>
												<li><a href="javascript:void(0);" onclick="tongguo();">通过</a></li>
						
												<li><a href="javascript:void(0);" onclick="butongguo();">不通过</a></li>
												<%}else{ %>
												
												<li><a href="javascript:void(0);" onclick="xytongguo();">通过</a></li>
						
												<li><a href="javascript:void(0);" onclick="xybutongguo();">不通过</a></li>
												<%} %>
						
					</ul>
				</div>
			</div>
		</div>
		
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
	
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input name="_titleName_" value="<%=titlename%>" type="hidden"/>
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
				<table class="tabs-table">
<tr>
      <td id = "base" class="<%=labelclass[0]%>" width="60" align="center" onclick="infoshow(1)" >基本信息</td>
      
      <td id = "team" class="<%=labelclass[1]%>" width="60" align="center" onclick="infoshow(2)" >学院审核</td>

         <%
													           if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.CXCY)){
													           %>
      <td id = "other" class="<%=labelclass[2]%>" width="60" align="center"  onclick="infoshow(3)">团委审核</td>
            <%} %>
          <%    
          
    
          if((userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.CXCY))&&v.getCheckFlagTw()==1){%>
      <td id = "file" class="<%=labelclass[3]%>" width="60" align="center" onclick="infoshow(4)" >奖励信息</td>
      <%} %>
</tr> 
</table>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >

                    											
													  				<tbody id="baseinfo"  >
													  				<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
<input type="hidden" name="AddPerson" value="<%=v.getAddPerson()%>">
<input type="hidden" name="ModiTime" value="<%=v.getModiTime()%>">
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">
<input type="hidden" name="AddFilelist" value="<%=v.getAddFilelist()%>">
                    											
                    											
                    												
                    												<tr>
                    												
													  				</tr>
<input type="hidden" name="Team" value="<%=v.getTeam()%>">
                    											
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">考核人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckPersonXy" id="CheckPersonXy" size="70" maxsize="70" value="<%=v.getCheckPersonXy()%>" readonly="readonly">
                    													</td>
													  				</tr>
                    											
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">申报类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(DeclarerRoleTypeoptions, v.getDeclarerRole(), "DeclarerRole", "",true)%>
                    													</td>
                    													<td align="right" class="form_label">考核人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckPersonTw" id="CheckPersonTw" size="70" maxsize="70" value="<%=v.getCheckPersonTw()%>" 	>
                    													</td>
													  				</tr>
													  				<tr style="display: none;">
                    													<td align="right" class="form_label">作品编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProductionCode" id="ProductionCode" size="20" maxsize="20" value="<%=v.getProductionCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">作品名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProductionName" id="ProductionName" size="20" maxsize="20" value="<%=v.getProductionName()%>"readonly="readonly">
                    													</td>
                    													<td align="right" class="form_label">申报团队</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declarer" id="Declarer" size="45" maxsize="45" value="<%=v.getDeclarer()%>"readonly="readonly">
                    													</td>
													  				</tr>
                    												<tr>
                    												<td align="right" class="form_label">所属项目</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(projectOptions, v.getProjectName(), "ProjectName", "",true)%>
														    			
                    													</td>
                    													<td align="right" class="form_label">学院全称</td>
														    			<td  align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "",true)%>
                    													</td>
													  				</tr>
                    												<tr>
                    												<%
                    												String sid=v.getLeaderId();
                    												System.out.println(sid);
                    												BaseUserCode stu= new BaseUserCode();
                    												stu=stu.getById(Integer.parseInt(sid));
                    												
                    												%>
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="Leader" id="Leader" size="45" maxsize="45" value="<%=stu.getCnName()%>"readonly="readonly"/>
                    													</td>
                    										
                    													<input type="hidden" name="LeaderId" id="LeaderId" value="<%=v.getLeaderId()%>"></input>
                    												
													  				</tr>
													  				<tr>
													  							<td align="right" class="form_label">团队成员</td>
														    			<td  colspan="3" align="left"  bgcolor="#ffffff">
                                                                     <table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td>
			</tr>
		<%
		String snoids="";
		if(v.getId()!=-1){
			InnovationCompetitionMembers  vpt= new 	InnovationCompetitionMembers();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			String vppid= v.getId()+"";
			cdt2.add("productionid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			List phonelist= new ArrayList();
			String xueyuan="";
			BaseUserCode stu1= new BaseUserCode();
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(	InnovationCompetitionMembers)list2.get(i);
				
			stu1=stu1.getById(Integer.parseInt(vpt.getName()));
			if(stu1!=null){
		
	
				 xueyuan=(String)CEditConst.getAcademyNameMap(userInfo).get(stu1.getDeptId()+"");
				
				%>
				<tr id='deleteSponsor_<%=stu1.getId()%>'><td><%=stu1.getName() %></td><td><%=stu1.getCnName() %></td><td><%=xueyuan %></td><td><%=vpt.getTel() %></td></tr>
				<% 
			}
				}
			}
		}
		
		%>	
			
		</table>
                    													</td>		
													  				
													  				
													  				</tr>
													  				
                    												<tr>
                    													<td align="right" class="form_label">作品类别</td>
														    			<td  colspan="3" align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ProductionTypeoptions, v.getProductionType(), "ProductionType", "",true)%>
                    													</td>
                    												
													  				</tr>
													  					
                    												
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="Remark" id="Remark" cols="160" rows="4"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    											
													  				
													  				<tr>
	<td align="right" class="form_label" >附件</td>
	<td align="left" bgcolor="#ffffff"  colspan="3">
 <%
 String ids="";
 ids=v.getAddFilelist();
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
 }else{
      %>
      没有上传的资料
      
      <% 
 }


%> 
	</td>
</tr>
													  				</tbody>
													  			
													  					<tbody id="teaminfo" style="display:none">
													  							<tr>
                    													<td align="right" class="form_label">考核状态</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%if(userInfo.hasFunPower(Power.UserAdminPower)){%>
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlagXy(), "CheckFlagXy", "0",true)%>
<%}else{ %>
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlagXy(), "CheckFlagXy", "0",true)%>
<%} %>
                    													</td>
                    													
													  				</tr>
													  					<tr>
                    													<td align="right" class="form_label">学院意见</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%if(userInfo.hasFunPower(Power.UserAdminPower)){%>
                    														<textarea name="CheckCommentXy" id="CheckCommentXy" cols="160" rows="2"><%=v.getCheckCommentXy()%></textarea>
                    														<%}else{ %>
                    														
                    										<textarea name="CheckCommentXy" id="CheckCommentXy" cols="160" rows="2" readonly="readonly"><%=v.getCheckCommentXy()%></textarea>
                    														
                    														<%} %>
                    													</td>
													  				</tr>
													  				</tbody>
													  					<tbody id="otherinfo" style="display:none">
													  						<tr>
                    													<td align="right" class="form_label">考核状态</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlagTw(), "CheckFlagTw", "0",true)%>
                    													</td>
                    														<tr>
                    													<td align="right" class="form_label">团委意见</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="CheckCommentTw" id="CheckCommentTw" cols="160" rows="2"><%=v.getCheckCommentTw()%></textarea>
                    													</td>
													  				</tr>
													  				</tr>
													  				</tbody>
													  					<tbody id="fileinfo" style="display:none">
													  						<tr>
                    													<td align="right" class="form_label">奖励荣誉</td>
														    			<td align="left"  bgcolor="#ffffff" width="900px">
                    													
                    														<%=HtmlTool.renderSelect(jianglioptions, v.getAward(), "Award", "")%>
                    													</td>
													  				</tr>
													  				</tbody>
                    												
                    											</table>
			</form>
		</div>
	<script type="text/javascript">
	function infoshow(val)
	{
		switch(val)
		{
			case 1:
				$("#baseinfo").attr("style","display:block");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labelon");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labeloff");
				break;
			case 2:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:block");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labelon");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labeloff");
				break;
			case 3:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:block");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labelon");
				$("#file").attr("class","labeloff");
				break;
			case 4:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:block");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labelon");
				
		}
	}
</script>
	</body>

</html>
