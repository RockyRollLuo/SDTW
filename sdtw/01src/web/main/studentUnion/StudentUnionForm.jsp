<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生会--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="ueditor" uri="http://sdxietong.com"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%@page import="com.xietong.software.base.Power"%>
<%
	Log log = LogFactory.getLog(StudentUnion.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentUnion v = (StudentUnion)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	System.out.println(dickeys .length+"aaaaaaaaaaaaaaaaaaaaaaa");
	
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
List UnionTypeoptions = (List)request.getAttribute("UnionTypeoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
String id=ParamUtils.getParameter(request, "id", "1");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<style>
          .tabs-table tr{
	height:25px;
}
.tabs-table tr td{
	width:80px;
	text-align:center;	
}
.labelon {
	background:#e5f1f4;
	font-size:13px;
		color:#fff;
	cursor:hand; 
}
.labeloff {
	background:#3992d0; 
	font-size:12px;
	color:#fff;
	cursor:hand; 
}
</style>
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
		</script>  
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
				<table class="tabs-table">
<tr>
      <td  id = "base" class="labelon" width="60" align="center"  ><a style="color: black"href="StudentUnionAction.jsp?cmd=modify&id=<%=id%>">学生会介绍</a></td>
      <td  id = "team" class="labeloff" width="60" align="center"  ><a style="color: #ffffff" href="StudentUnionMemberAction.jsp?cmd=list&_type_=zhuxi&_UnionId_=<%=id%>">主席团信息</a></td>
      <td  id = "other" class="labeloff" width="60" align="center"  ><a  style="color: #ffffff"href="StudentUnionDeptAction.jsp?cmd=list&_UnionId_=<%=id%>">部门列表</a></td>
     
</tr>
</table>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">学生会简介</div>
				
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
	
														             
						 <%
													               if(id.equals("1")||id.equals("2")){
													            	   if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHGZ)){
													            		%> 								             
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						
						<%}}else{
			            	   if(userInfo.hasFunPower(Power.UserAdminPower)){
			            		   %> 
			            		   		<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
			            		   
			            		   <%}} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Uniontype" value="<%=v.getUniontype()%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    											
                    												<tr>
                    													<td align="right" class="form_label">学生会简介</td>
														    		
                    													<td colspan="3" style="padding: 0px;"><ueditor:editor
																				       
																						autoFloat="false" instanceName="Unionprofile"
																						basePath="/main/js/ueditor" width="99.9%"
																						height="280px" toolbars="toolbar_society"
																						value="<%=v.getUnionprofile() %>"></ueditor:editor></td>
													  				</tr>
                    												
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
                    										
                    												<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="0" value="<%=Tool.stringOfDateTime(v.getAddtime())%>">
                    													</td>
                    													<td align="right" class="form_label">添加人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addaccount" id="Addaccount" size="45" maxsize="45" value="<%=v.getAddaccount()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
