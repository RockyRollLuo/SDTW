<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
List MsgGradeoptions = (List)request.getAttribute("MsgGradeoptions");
List MsgPropoptions = (List)request.getAttribute("MsgPropoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
			<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		
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
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
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
												            <div class="browsetitleleft">
												            <%
												            String biaoti="";
												            int shoujian=ParamUtils.getIntParameter(request, "_shoujian_",2);
												            if(shoujian==2){
												            	biaoti ="发件箱";
												            }
												            if(shoujian==1){
												            	biaoti ="收件箱";
												            }
												            
												            
												            
												            %>
													          <div class="browsetitle001"><%=biaoti %></div>
													        
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														           
														            <li><a href="javascript:document.query.submit();">查询</a></li>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td>
                               <div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
											<input type="hidden" name="_shoujian_" value="<%=ParamUtils.getParameter(request, "_shoujian_","")%>">
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
													<tr>
												<td>
														<div align="right">短消息标题</div>
													</td>
													<td>
														<input name="_Subject_" value="<%=ParamUtils.getParameter(request, "_Subject_", "")%>">
													</td>
												
														<input  type="hidden" name="shoujian" value="<%=ParamUtils.getParameter(request, "_shoujian_", "")%>">
													
													<td>
														<div align="right">短消息发送时间</div>
													</td>
													<td>
														
														
                    														<input name="_SendDate_"
																					onclick="WdatePicker({el:'SendDate'})"
																					id="_SendDate_" size="0"
																					>
																						<img onclick="WdatePicker({el:'_SendDate_'})"
																						src="<%=HeadConst.apache_url%>/main/images/datePicker.gif"
																						width="16" height="22" align="absmiddle">
													</td>
													
													<td>
														<div align="right">短消息级别</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(MsgGradeoptions, ParamUtils.getParameter(request,"_MsgGrade_",""), "_MsgGrade_", "")%>
													</td>
												</tr>
												<tr style="display: none">
													<td>
														<div align="right">发送人</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(UserNameoptions, ParamUtils.getParameter(request,"_SendId_",""), "_SendId_", "")%>
													</td>
													<td>
														<div align="right">是否查看</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(YesNooptions, ParamUtils.getParameter(request,"_IfSee_",""), "_IfSee_", "")%>
													</td>
													<td>
														<div align="right">是否回执</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(YesNooptions, ParamUtils.getParameter(request,"_Receipt_",""), "_Receipt_", "")%>
													</td>
												</tr>
												
											</table>
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
