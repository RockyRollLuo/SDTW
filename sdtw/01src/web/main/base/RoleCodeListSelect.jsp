<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	String values = ParamUtils.getParameter(request,"values","");
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction.js"></script>
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
			function showList1(className, currpage, url_para, aHasCheckbox, cmd, haveSelect,curId,showEdit) {
			    var getRow = function (str, field) {
			        if (str == "" || str == "null") {
			            str = "&nbsp;";
			        }
			        var desc = ["string", "", "0", "text", ""];
			        if (field != undefined) {
			            desc = dic[field];
			        }
			        var dalign = desc[0] || "control";
			        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx1\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
			    };
			    var getRow1 = function (str, field) {
			        if (str == "" || str == "null") {
			            str = "&nbsp;";
			        }
			        var desc = ["string", "", "0", "text", ""];
			        if (field != undefined) {
			            desc = dic[field];
			        }
			        var dalign = desc[0] || "control";
			        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
			    };
			    var hasCheckbox = (aHasCheckbox == undefined) ? true: aHasCheckbox;
			    var showfields = new Array();
			    var showhidefields = new Array();
			    var keyindex = getFieldIndex(keyfield);
			    //var str = showQuery(className, currpage, url_para);
			    var str = "";
			    if (typeof(curId) == "undefined") {var curId = "";}
			    if (typeof(isSelect) == "undefined") var isSelect=0;
			    
			    var titlecolor = (isSelect == "1") ? "data_bgcolor_odd" : "title_bgcolor";
			    str = str + "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D2D2D2\" ><tr>\n";
			    if (hasCheckbox) {
			        str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\"><input type=\"checkbox\" onclick=\"selectAll(this);\" onchange=\"selectAll(this);\"></td>\n";
			    }
			    for (var i = 0; i < fields.length; i ++) {
			        var title = dic[fields[i]][1];
			        title = title.replace(/\(.*\)/, "");
			        if (title == "") title = "&nbsp;";
			        str = str + "<td align=\"center\" background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" onclick=\"javascript:setOrderBy('" + fields[i] + "', '" + url_para + "')\" class=\"button\" nowrap>" + title;
			        if (curr_orderby != undefined) {
			            if (curr_orderby[0] == fields[i]) {
			                str = str + "<img src=\"" + order_image[curr_orderby[1]] + "\">";
			            }
			        }
			        str = str + "</td>\n";
			        showfields[i] = getFieldIndex(fields[i]);
			    }
			    for (var i = 0; i < hidefields.length; i ++) {
			        showhidefields[i] = getFieldIndex(hidefields[i]);
			    }    
			    if(showEdit == "1"){
			    	str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" class=\"button\" nowrap>编辑</td>\n";
			    }
			    str = str + "</tr>\n";
			    if (rows.length == 0) {
			        str = str + "<tr><td colspan=" + (showfields.length + 2) + " align=\"center\" bgcolor=\"#FFFFFF\" class=\"xxybgx1\">没有记录！</td></tr>\n";
			    } 
			    else {
			        for (i = 0; i < rows.length; i ++) {
			            var color = (i % 2 != 0) ? "data_bgcolor_odd" : "data_bgcolor_even";
			            if (rows[i][keyindex] == curId){
			            	str = str + "<tr onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\" bgcolor='#7DCDE6'>\n";
			            }else{
			            	str = str + "<tr onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\">\n";
			            }
			            if (hasCheckbox) {
			            	if (haveSelect == "1" ){
			            		var selectRowsIdsStr = (selectRowsIds == undefined) ? "" : selectRowsIds;
			                	if (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){
			                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 checked value=" + rows[i][keyindex] + " /></td>";
			                	}else{
			                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                	}
			                }else{
			                	var selectValue = "<%=values%>";
			                	if(selectValue!=""){
			                		selectValue = ","+selectValue+",";
			                	}
			                	if(selectValue.length>2&&selectValue.indexOf(","+rows[i][getCodeIndex("Id")]+",")>=0){
			                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 checked=true value=" + rows[i][keyindex] + " /></td>";
			                	}else{
			                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                	}
			                }
			            }
			             var atitle = "";
			            for (var j = 0; j < fields.length; j ++) {
			                var k = showfields[j];
			                if(allfields[k]=="Id" ||allfields[k]=="OrderNo" ||allfields[k]=="Name" || allfields[k]=="Subject" || allfields[k] == "Email"){
			                	for (m = 0; m < showhidefields.length; m++){
			                		var n = showhidefields[m];
			                	    atitle = atitle + dic[hidefields[m]][1] + ":" + rows[i][n] + " || ";
			                	}
			                	if (rows[i][k] == "" || rows[i][k] == "null") {
			                		rows[i][k] = "&nbsp;";
			                    }
			                    if(j==0)
			                		str = str + getRow1("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
			                	else
			                		str = str + getRow("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
			                }else{
			                	if(j==0)
			                		str = str + getRow1(rows[i][k], fields[j]);
			                	else
			                		str = str + getRow(rows[i][k], fields[j]);
			                }                
			            }
			            if(showEdit == "1"){
			            	str = str + "<td bgcolor=\"#FFFFFF\" class=\"xxybgx2\" onclick=\"javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>";
			            }
			            str = str + "</tr>\n";
			        }
			    }
			    str = str + '</table>';
			    document.getElementById("list").innerHTML = str;
			}
			function selectRole(){
				var chks = document.getElementsByName("chk1");
			    if (!url_para)
			        url_para = "";
			    var chkeds = new Array();
			    var rowIndex = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			            rowIndex.push(i);
			        }
			    }
			    if (chkeds.length > 0) {
			    	var reName = "";
			    	var reId = "";
					for(var i =0;i<rowIndex.length;i++){
						if(reName==""){
							reName = rows[rowIndex[i]][getCodeIndex('Name')];
							reId = rows[rowIndex[i]][getCodeIndex('Id')];
						}
						else{ 
							reName += ","+rows[rowIndex[i]][getCodeIndex('Name')];
							reId += ","+rows[rowIndex[i]][getCodeIndex('Id')];
						}
					}
			    	window.opener.setRole(reName,reId);
			    	window.close();
			    } else {
			    	reName='';
			    	reId='';
			    	window.opener.setRole(reName,reId);
			    	window.close();
			    }
				
			}
			//获得代码的位置
			function getCodeIndex(colu){
				for(var k=0;k<allfields.length;k++){
					if(allfields[k]==colu){
						return k;
					}
				}
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="../jqueryui.jsp" flush="true"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr><td colspan="3" height="13"></td></tr>
			<tr> 
				<td width="25">&nbsp;</td>
				<td valign="top">
					<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#33577B">
						<tr>
							<td bgcolor="#FFFFFF" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
  									<tr>
    									<td height="26" background="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
      											<tr>
        											<td width="26"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanl.gif"></div></td>
         											<td width="100"><b class="bt">[角色表]</b></td>
        											<td>&nbsp;</td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr1.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.submit();">查询</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr2.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:selectRole();">选中</a></td>

      											</tr>
    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td  class="cxbj">
											<input type="hidden" name="cmd" value="select">
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">角色名</div>
													</td>
													<td>
														<input name="_Name_" value="<%=ParamUtils.getParameter(request, "_Name_", "")%>">
													</td>
													<td>
														<div align="right">角色代码</div>
													</td>
													<td>
														<input name="_Code_" value="<%=ParamUtils.getParameter(request, "_Code_", "")%>">
													</td>
													<td colspan="2">&nbsp;</td>
												</tr>
											</table>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
        										<tr>
          											<td>
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
											 				<tr>
											    				<td height="3" class="topline"></td>
															</tr>
														</table>
            											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td height="2"></td></tr>
            											</table>
														<div id="list">
														</div>
														<%//=(("listall".equals(cmd)))? "": pagecontrol.getControl1((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/images/skin/"+userInfo.getSkinId())%>
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
				<td width="25">&nbsp;</td>
			</tr>
			<tr><td colspan="3" height="13"></td></tr>
		</table>
	</body>
</html>
