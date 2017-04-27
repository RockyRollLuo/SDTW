<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.train.TrainUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	StringBuffer str = new StringBuffer();
	List rows = (List)request.getAttribute("List");
	if (rows == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	if (pagecontrol == null) {
    		pagecontrol = new PageControl(0, 1, 1);
	}
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	int audit = ParamUtils.getIntParameter(request,"_Audit_",-2);
	int ProjectId = ParamUtils.getIntParameter(request,"_ProjectId_",-1);
	String all = ParamUtils.getParameter(request,"_All_","");
	TrainUtil util = new TrainUtil();
	List AuditList = util.getAuditList();
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script>
			var curr_orderby = ["<%=HttpTool.getString(extMaps, "orderfield", "")%>", "<%=HttpTool.getString(extMaps, "ordertype", "")%>"];
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var queryfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("queryfields"))%>"];
			var queryvalues = ["<%=Tool.join("\", \"", (List)request.getAttribute("queryvalues"))%>"];
			var rows = [<%=Tool.join(", ", rows)%>];
			var hidefields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("hidefields"))%>"];
			function init() {
    				showList("<%=request.getAttribute("classname")%>", <%=pagecontrol.getCurrPage()%>, url_para);
			}
			function checkBaoming(className, url_para,flag) {
				  var page = <%=currpage%>;
				  var str = "";
				  if (flag==0) {
					  str = "通过";
				  }
				  if (flag==1) {
					  str = "不通过";
				  }
				  var chks = document.getElementsByName("chk1");
				    if (!url_para)
				        url_para = "";
				    var chkeds = new Array();
				    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
				        if (chks[i].checked == true) {
				            chkeds.push(chks[i].value);
				        }
				    }
				    if (chkeds.length > 0) {
				        if (confirm("确实"+str+"这些记录吗?")) {
				            location = className + "Action.jsp?cmd=baominglist&idlist=" + chkeds.join(',') + "&Audit="+flag+"&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
				        }
				    } else {
				        alert("未选择记录！");
				    }
			} 
			function chekzuoye(className, url_para) {
				var page = <%=currpage%>;
				var chks = document.getElementsByName("chk1");
			    if (!url_para)
			        url_para = "";
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    if (chkeds.length > 0) {
			        if (confirm("确实审核这些记录吗?")) {
			        	///sdtw/01src/web/main/train/zuoye.jsp
			        	var url = "<%=HeadConst.apache_url%>/main/train/zuoye.jsp?idlist="+chkeds.join(',');
			        	parent.parent.showDialog (url,500,350,'审核作业'
                                ,{ '确定': function(){
                                	parent.parent.submitthis();
                                	//alert("TrainingParticipateAction.jsp?_Audit_=0&_ProjectId_=<%=ProjectId%>");
                                	parent.$('#commentFrame0').attr("src","TrainingParticipateAction.jsp?_Audit_=0&_ProjectId_=<%=ProjectId%>") 
                                }
                      });
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			
			function jieti(className, url_para) {
				var page = <%=currpage%>;
				var chks = document.getElementsByName("chk1");
			    if (!url_para)
			        url_para = "";
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    if (chkeds.length > 0) {
			        if (confirm("确实审核这些记录吗?")) {
			        	///sdtw/01src/web/main/train/zuoye.jsp
			        	var url = "<%=HeadConst.apache_url%>/main/train/jieti.jsp?idlist="+chkeds.join(',');
			        	parent.parent.showDialog (url,500,300,'审核结题'
                                ,{ '确定': function(){
                                	parent.parent.submitthis();
                                	//alert("TrainingParticipateAction.jsp?_Audit_=0&_ProjectId_=<%=ProjectId%>");
                                	parent.$('#commentFrame2').attr("src","TrainingParticipateAction.jsp?_Audit_=2&_ProjectId_=<%=ProjectId%>") 
                                }
                      });
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
		</script>
	</head>
	<body onload="init();">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
  									<tr>
    									<td height="26">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                   <td>
											            <div class="browsetitle title_css">
												           <%--  <div class="browsetitleleft">
													          <div class="browsetitle001">团校培训管理资料</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("团校培训管理资料")%></div>
												          </div> --%>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
													           <%
													           if (audit==-1&&"".equals(all)) {//报名审核%>
													        	   <li class="browsetitle_lang"><a href="javascript:checkBaoming('<%=request.getAttribute("classname")%>', url_para,1);">报名不通过</a></li>
														           <li class="browsetitle_lang"><a href="javascript:checkBaoming('<%=request.getAttribute("classname")%>', url_para,0);">报名通过</a></li>
													           <%}
													           %>
													           <%
													           if (audit==0&&"".equals(all)) {//作业审核%>
														           <li class="browsetitle_lang"><a href="javascript:chekzuoye('<%=request.getAttribute("classname")%>', url_para);">作业审核</a></li>
													           <%}
													           %>
													           <%
													           if (audit==2&&"".equals(all)) {//结题审核%>
														           <li class="browsetitle_lang"><a href="javascript:jieti('<%=request.getAttribute("classname")%>', url_para);">结题审核</a></li>
													           <%}
													           %>
													           <%
													           if ("all".equals(all)) {%>
													        	 <li><a href="javascript:document.query.submit();">查询</a></li>  
													           <%}
													           %>														            
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr> 
                                </table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td>
                               <div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
											<input type="hidden" id="_All_" name="_All_" value="<%=all%>"/>
											<input type="hidden" id="_ProjectId_" name="_ProjectId_" value="<%=ProjectId%>"/>
											<%-- <%=Tool.join("\n", forms)%> --%>
											<%
											//查看所有人员
											if ("all".equals(all)) {%>
												<table>
													<tr>
														<td>状态</td>
														<td><%=HtmlTool.renderSelect(AuditList,""+audit,"_Audit_","") %></td>
													</tr>
												</table>
											<%}
											%>
                               </div>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
        										<tr>
          											<td>
														<div id="list" class="browsetable">
														</div>
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
													</td>
        										</tr>
      										</table>
			                			</td>
  									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
