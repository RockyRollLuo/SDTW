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
	String shoujian= ParamUtils.getParameter(request, "shoujian","");
	request.setAttribute("shoujian", shoujian);
	
	String url=Tool.join("&", urls);;
	
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
	}else{
		 
		 BaseUserCode user = new BaseUserCode();
		 user=userInfo.getUserCode();
	 	if(shoujian.equals("1")){
			url="_SmsStyle_=1&shoujian=1";
			
		System.out.println(url);
		}
		if(shoujian.equals("2")){
			url="_SmsStyle_=1&shoujian=2";
			
		System.out.println(url);
		}
		if(shoujian.equals("3")){
			url="_SmsStyle_=2&shoujian=3";
			
		System.out.println(url);
		}
	 	
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
			var  difference1="<%=(String)request.getAttribute("describe")%>";
			var hidefields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("hidefields"))%>"];
			function init() {
				
				showList("<%=request.getAttribute("classname")%>", <%=pagecontrol.getCurrPage()%>, url_para);
		}
			function showList(className, currpage, url_para,aHasCheckbox) {
			
				showList1(className, currpage, url_para, aHasCheckbox, "modify", "0","-1","1");
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
			        return "<td  align='" + data_align[dalign] + "' class=\"browsetable005\">" + str + "</td>\n";
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
			        return "<td align='" + data_align[dalign] + "' class=\"browsetable005\">" + str + "</td>\n";
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
			    str = str + "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\">\n";
			    
			    if (hasCheckbox) {
			        str = str + "<td bgcolor=\"#3992d0\"><div class=\"browsetable004\"><input type=\"checkbox\" onclick=\"selectAll(this);\" onchange=\"selectAll(this);\"></div></td>\n";
			    }
			    if(showEdit == "1"){
			    	str = str + "<td bgcolor=\"#3992d0\" nowrap><div class=\"browsetable004\">编辑</div></td>\n";
			    }
			    for (var i = 0; i < fields.length; i ++) {
			        var title = dic[fields[i]][1];
			        title = title.replace(/\(.*\)/, "");
			        if (title == "") title = "&nbsp;";
			        str = str + "<td bgcolor=\"#3992d0\" onclick=\"javascript:setOrderBy('" + fields[i] + "', '" + url_para + "')\" nowrap><div class=\"browsetable004\">" + title;
			        if (curr_orderby != undefined) {
			            if (curr_orderby[0] == fields[i]) {
			                str = str + "<img src=\"" + order_image[curr_orderby[1]] + "\">";
			            }
			        }
			        str = str + "</div></td>\n";
			        showfields[i] = getFieldIndex(fields[i]);
			    }
			    for (var i = 0; i < hidefields.length; i ++) {
			        showhidefields[i] = getFieldIndex(hidefields[i]);
			    }    
			  /*  if(showEdit == "1"){
			    	str = str + "<td bgcolor=\"#3992d0\" nowrap><div class=\"browsetable004\">编辑</div></td>\n";
			    }*/
			    str = str + "</tr>\n";
			    if (rows.length == 0) {
			        str = str + "<tr><td colspan=" + (showfields.length + 2) + " bgcolor=\"#FFFFFF\" ><div class=\"browsetable006\">没有记录！</div></td></tr>\n";
			    } 
			    else {
			        for (i = 0; i < rows.length; i ++) {
			            var color = (i % 2 != 0) ? "data_bgcolor_odd" : "data_bgcolor_even";
			            
			            if (rows[i][6] == "否"){
			            	if(difference1=="收的消息"){
			            	str = str +"<tr bgcolor='#ff66ff' >\n";
			            	}
			            	 else{
					            	str = str + "<tr onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\" class='"+color+"'>\n";
					            }
			            }
			            else{
			            	str = str + "<tr onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\" class='"+color+"'>\n";
			            }
			            
			            if (hasCheckbox) {
			            	if (haveSelect == "1" ){
			            		var selectRowsIdsStr = (selectRowsIds == undefined) ? "" : selectRowsIds;
			                	if (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){
			                		str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 checked value=" + rows[i][keyindex] + " /></td>";
			                	}else{
			                		str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                	}
			                }else{
			                	str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                }
			            }
			            if(showEdit == "1"){
			            	str = str + "<td class=\"xxybgx2\"  onclick=\"javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>";
			            }
			             var atitle = "";
			            for (var j = 0; j < fields.length; j ++) {
			                var k = showfields[j];
			                if(allfields[k]=="Id" ||allfields[k]=="OrderNo" ||allfields[k]=="Name" || allfields[k]=="Subject" || allfields[k] == "Email"|| allfields[k] == "Title"){
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
			            str = str + "</tr>\n";
			        }
			    }
			    str = str + '</table>';
			    document.getElementById("list").innerHTML = str;
			}
			
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<% ;
		System.out.println(shoujian+"....................");
		
		if(shoujian.equals("1")){
			request.setAttribute("shoujian", "1");
		%>
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
													          <div class="browsetitle001">收件箱</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("收件箱")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!--  <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>-->
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														        <!--      <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>-->
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
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
												<td>
														<div align="right">短消息标题</div>
													</td>
													<td>
														<input name="_Subject_" value="<%=ParamUtils.getParameter(request, "_Subject_", "")%>">
													</td>
												
														<input type="hidden" name="shoujian" value="<%=ParamUtils.getParameter(request, "shoujian", "")%>">
													
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
<input type="hidden"  name="shoujian" value="<%=shoujian%>"/>
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
											
											<!--  	<tr>
													<td>
														<div align="right">跳转地址</div>
													</td>
													<td>
														<input name="_RemUrl_" value="<%=ParamUtils.getParameter(request, "_RemUrl_", "")%>">
													</td>
													<td>
														<div align="right">RemindSys</div>
													</td>
													<td>
													</td>
													<td colspan="2">&nbsp;</td>
												</tr>
												-->
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
		<%} if(shoujian.equals("2")){
			request.setAttribute("shoujian", "2");
		%>
		
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
													          <div class="browsetitle001">发件箱</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("发件箱")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!--  <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>-->
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
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
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
														<div align="right">短消息标题</div>
													</td>
													<td>
														<input name="_Subject_" value="<%=ParamUtils.getParameter(request, "_Subject_", "")%>">
														<input type="hidden" name="shoujian" value="<%=ParamUtils.getParameter(request, "shoujian", "")%>">
													</td>
													<td>
														<div align="right">短消息级别</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(MsgGradeoptions, ParamUtils.getParameter(request,"_MsgGrade_",""), "_MsgGrade_", "")%>
													</td>
												</tr>
												
											<!--  	<tr>
													<td>
														<div align="right">跳转地址</div>
													</td>
													<td>
														<input name="_RemUrl_" value="<%=ParamUtils.getParameter(request, "_RemUrl_", "")%>">
													</td>
													<td>
														<div align="right">RemindSys</div>
													</td>
													<td>
													</td>
													<td colspan="2">&nbsp;</td>
												</tr>
												-->
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
		
		<%}
		if(shoujian.equals("3")){%>
		
		
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
													          <div class="browsetitle001">草稿箱</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("草稿箱")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!--  <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>-->
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														         
														            
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    							
												
											<!--  	<tr>
													<td>
														<div align="right">跳转地址</div>
													</td>
													<td>
														<input name="_RemUrl_" value="<%=ParamUtils.getParameter(request, "_RemUrl_", "")%>">
													</td>
													<td>
														<div align="right">RemindSys</div>
													</td>
													<td>
													</td>
													<td colspan="2">&nbsp;</td>
												</tr>
												-->
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
		
		<%} %>
	</body>
</html>
