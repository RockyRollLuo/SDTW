<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.train.TrainUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--团校培训管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(TrainingArrangement.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	TrainingArrangement v = (TrainingArrangement)request.getAttribute("fromBean");
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
	List cdt = new ArrayList();
	cdt.add("roles!=3 && roles!=4");
	List UserCnNameOptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt);
	TrainUtil util = new TrainUtil();
		//CEditConst.getUserCnNameOptions(userInfo,"-1");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="../../main/js/ajaxfileupload.js"></script>
		<script language="JavaScript" src="js/upload.js"></script>
		<%-- <link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script> --%>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				//$("#HostId").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
    				/* var clienth = document.documentElement.clientHeight-200;
    				$('#tabs-2').height(clienth);
    				$('#tabs-3').height(clienth);
    				$('#tabs-4').height(clienth); */
			}
			function changeHost() {
				//0 校内
				//1 校外
				if ($("#OtherUniversity").is(':checked')) {
					$('#OtherUniversity').val(1);
				//if ($('#OtherUniversity').attr("checked" )) {
			          $('#xn').hide();
			          $('#xw').show();
			     } else {
			    	 $('#OtherUniversity').val(0);
			    	 $('#xw').hide();
			         $('#xn').show();
			     }
			}
			function Jump(f){
				$('#commentFrame'+f).attr("src","TrainingParticipateAction.jsp?_Audit_="+f+"&_ProjectId_=<%=v.getId()%>") 
			}
			function Jump2(){
				$('#commentFrame5').attr("src","TrainingParticipateAction.jsp?_ProjectId_=<%=v.getId()%>&_All_=all") 
			}
			
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">团校培训管理</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("团校培训管理") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="TrainingArrangementAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">基本信息</a></li>
				<li><a href="#tabs-2" onclick="Jump(-1)"><%=v.getProjectName() %>报名审核</a></li>
				<li><a href="#tabs-3" onclick="Jump(0)"><%=v.getProjectName() %>作业审核</a></li>
				<li><a href="#tabs-4" onclick="Jump(2)"><%=v.getProjectName() %>结题审核</a></li>
				<li><a href="#tabs-5" onclick="Jump2()"><%=v.getProjectName() %>所有报名人员</a></li> 
				</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px; padding: 0px;height: 100%" >
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input type="hidden" name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
<input type="hidden" id="AddPerson" name="AddPerson" value="<%="save".equals(cmd)?userInfo.getId():v.getAddPerson()%>"/>
<input type="hidden" name="ModifyTime" id="ModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getModifyTime())%>">
<input type="hidden" id="ModifyUseraccount" name="ModifyUseraccount" value="<%=v.getModifyUseraccount()%>"/>
<input type="hidden" id="ModifyPerson" name="ModifyPerson" value="<%=v.getModifyPerson()%>"/>
<input type="hidden" id="AddFileList" name="AddFileList" value="<%=v.getAddFileList()%>"/>
                    												<tr>
                    													<td align="right" class="form_label">学习项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input id="ProjectName" name="ProjectName" value="<%=v.getProjectName()%>" style="width: 90%"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			String check = "";
														    			String desc = "";
														    			String desc1 = "style=\"display: none;\"";
														    			if (v.getOtherUniversity()==1) {//校外
														    				check = "checked=\"checked\"";
														    				desc = "style=\"display: none;\"";
														    				desc1 = "";
														    			}
														    			%>
														    			<span id="xn" <%=desc %>></span>
														    			姓名：<input id="HostName" name="HostName" value="<%=v.getHostName()%>"/>
														    			<span id="xw" <%=desc1 %>>
														    			 <br/>学校：<input  id="AddUseraccount" name="AddUseraccount" value="<%=v.getAddUseraccount()%>" style="width: 60%"/>
														    			</span>
														    			<input type="checkbox" id="OtherUniversity" name="OtherUniversity" value="<%=v.getOtherUniversity()%>" onclick="changeHost()" <%=check %>/>校外
                    													</td>
													  				</tr>
                    												<%-- <tr>
                    													<td align="right" class="form_label">负责人id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HostId" id="HostId" cols="40" rows="2"><%=v.getHostId()%></textarea>
                    													</td>
													  				</tr> --%>
													  				<tr>
                    													<td align="right" class="form_label">开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input class="date" name="StartTime" id="StartTime" onfocus="WdatePicker({el:'StartTime',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size="0" value="<%="save".equals(cmd)?"":Tool.stringOfDate(v.getStartTime())%>"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input class="date" name="EndTime"  id="EndTime" size="0" value="<%="save".equals(cmd)?"":Tool.stringOfDate(v.getEndTime())%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'StartTime\')}',onpicked:function(){}})" >
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">项目说明</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="ProjectExplain" id="ProjectExplain" cols="120" rows="5"><%=v.getProjectExplain()%></textarea>
                    													</td>
													  				</tr>
                    												<tr id="ClientAttach">
													  				<td align="right" class="form_label">附件</td>
													  				<td bgcolor="#ffffff" align="left" colspan="3">
																	<table width="100%" border="0" cellspacing="0" id="ShowFiles">
																				<%
																				int caid = -1;
																				if (!"".equals(v.getAddFileList().trim())) {
																					String caids[] = v.getAddFileList().split(",");
																					for(int i=0;i<caids.length;i++){
																						caid = Tool.StrToInt(caids[i]);
																						ClientAttach ca = new ClientAttach();
																						//社团校外活动会长（带队队长）承诺书
																						if (caid!=-1&&ca.getById(caid)!=null) {
																							ca = ca.getById(caid);
																				%>
																			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
																				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
																				<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
																				</tr>
																					<%}
																					}
																				}
																				%>
																	</table>
																	<%
																	//if(v.getCheckFlag()!=1){%>
																	<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
																	<input type="button" value="上传" id="btn_up"  onclick="checkFileType(8,'Training_Arrangement');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
																	<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
																	<%//}
																	%>
																    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
																</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-2" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			<!--报名审核 -->
												         			<iframe  class="commentFrame-1" name="commentFrame-1" id="commentFrame-1" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div>
												         		<div id="tabs-3" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			<!--作业审核 -->
												         			<iframe  class="commentFrame0" name="commentFrame0" id="commentFrame0" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div>
												         		<div id="tabs-4" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			<!--结题审核 -->
												         			<iframe  class="commentFrame2" name="commentFrame2" id="commentFrame2" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div>
												         		<div id="tabs-5" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			<!-- 查看所有报名人员 -->
												         			<iframe  class="commentFrame5" name="commentFrame5" id="commentFrame5" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div>
			</form>
			</div>
		</div>
		<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script>
	</body>
</html>
