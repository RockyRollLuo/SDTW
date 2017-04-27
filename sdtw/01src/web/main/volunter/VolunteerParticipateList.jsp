<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>

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
	//url="ActivityId="+ParamUtils.getIntParameter(request, "ActivityId", 1);
	System.out.println("当前网址"+url );
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
	BaseUserCode user= userInfo.getUserCode();
	int  projectid = ParamUtils.getIntParameter(request, "_ActivityId_", -1);
	System.out.println(projectid );
	VolunteerActivity va= new VolunteerActivity();
	va= va.getById(projectid);
	String check=ParamUtils.getParameter(request, "CheckFlag", "");
	System.out.println( check);

%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script>
			var curr_orderby = ["<%=HttpTool.getString(extMaps, "orderfield", "")%>", "<%=HttpTool.getString(extMaps, "ordertype", "")%>"];
			var url_para = "<%=url%>";
		//	alert( url_para);
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
			function modifyList(className, url_para){
				modifyList1(className, url_para, 1);
			}
			function modifyList1(className, url_para, page)
			{
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
			        if (confirm("确实要通过这些学生的审核吗?")) {
			        	
			            location = className + "Action.jsp?cmd=modifylist&_ActivityId_=<%=projectid%>&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			          
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			function modify1List(className, url_para){
				modify1List1(className, url_para, 1);
				
			}
			function modify1List1(className, url_para, page)
			{
				//alert( url_para);
			    var chks = document.getElementsByName("chk1");
			    var chks3= document.getElementsByName("chk3");
			    
			    if (!url_para)
			        url_para = "";
			    var chkeds2= new Array();
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			           
			        }
			    }
			   
			    if (chkeds.length > 0) {
			        if (confirm("确实要拒绝通过这些学生的审核吗?")) {
			        	//alert(className + "Action.jsp?cmd=modifylist1&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para));
			            location = className + "Action.jsp?cmd=modifylist1&_ActivityId_=<%=projectid%>&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			function download(className, url_para, page)
			{
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
			        if (confirm("只能导出审核通过的记录,确实要导出这些记录吗?")) {
			            location = className + "Action.jsp?cmd=excelselect&_ActivityId_=<%=projectid%>&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			    	if (confirm("只能导出审核通过的记录,确实要导出这些记录吗?")) {
			    	//document.query.cmd.value = 'excel'; document.query.submit();
			    		location = className + "Action.jsp?cmd=excel&_ActivityId_=<%=projectid%>&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			    	}
			    }
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
												            String biaoti="志愿活动报名表";
												            int checkfalg=ParamUtils.getIntParameter(request, "_CheckFlag_", -1);
												            if(checkfalg==1){
												            	biaoti="志愿活动分配荣誉";
												            }
												            %>
													          <div class="browsetitle001"><%=biaoti %></div>
													       
												          </div>
												          <div class="browsetitleright">
												           	              <div class="anniulist2">
													           <ul>
													             
												           
														      
														           
														              <li> <a href="VolunteerActivityAction.jsp" >返回</a></li> 
														              <%if(va.getAddAccount().equals(user.getId()+"")&&checkfalg!=1){ 
														              	if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZYFW)) {
														              %>   
														              <li><a href="javascript:download('<%=request.getAttribute("classname")%>', url_para);">导出信息</a></li>
														              <%} %>
														            <li><a href="javascript:modifyList('<%=request.getAttribute("classname")%>', url_para);">通过</a></li>
														          
														             <li><a href="javascript:modify1List('<%=request.getAttribute("classname")%>', url_para);">不通过</a></li>
														             <%} %>
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
											
											<input type="hidden"   name="_ActivityId_" value="<%=projectid%>">
											<%=Tool.join("\n", forms)%>
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