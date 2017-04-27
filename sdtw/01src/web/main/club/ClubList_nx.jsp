<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
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
	List ClubTypeNameOptions = CEditConst.getClubTypeNameOptions(userInfo,"-1");
	List OrgCityNameOptions = CEditConst.getOrgCityNameOptions(userInfo,"-1");
	List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
	Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
	Map OrgCityNameMap = CEditConst.getOrgCityNameMap(userInfo);
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
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
			    /* if(showEdit == "1"){
			    	str = str + "<td bgcolor=\"#3992d0\" nowrap><div class=\"browsetable004\">编辑</div></td>\n";
			    } */
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
			            if (rows[i][keyindex] == curId){
			            	str = str + "<tr onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\" class='"+color+"'>\n";
			            }else{
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
			            /* if(showEdit == "1"){
			            	str = str + "<td class=\"xxybgx2\"  onclick=\"javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>";
			            } */
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
			                   // if(j==0)
			                	//	str = str + getRow1("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
			                //	else
			                //		str = str + getRow("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
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
			
			function setNxTime(){
				var chks = document.getElementsByName("chk1");
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    if (chkeds.length > 0) {
			    	var idlist = chkeds.join(',');
			    	var url = "<%=HeadConst.apache_url%>/main/club/ChangeTimeEnter.jsp?idlist="+idlist;
			    	parent.showDialog(url,400,267,'设置纳新时间'
							,{'确定':function(){
								parent.checkDate();
							}
					});
			    } else {
			        alert("未选择记录！");
			    }	
				
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
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
													          <div class="browsetitle001">
													          <%String desc = ParamUtils.getAttribute(request,"describe",""); %>
																<%=desc %>
													          </div>
													          <div class="browsetitle002"><%=XtUtil.getSpell(desc)%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li> -->
														            <%-- <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li> --%>
														            <%-- <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li> --%>
														            <li><a href="javascript:setNxTime();">纳新时间</a></li>
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
											<input type="hidden" id="_flag_" name="_flag_" value="<%=ParamUtils.getParameter(request,"_flag_","")%>"/>
											<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>"/>
											<%-- <%=Tool.join("\n", forms)%> --%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">社团名称</div>
													</td>
													<td>
														<input name="_ClubName_" value="<%=ParamUtils.getParameter(request, "_ClubName_", "")%>"/>
													</td>
													<td>
														<div align="right">社团类别</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(ClubTypeNameOptions, ParamUtils.getParameter(request,"_ClubType_",""), "_ClubType_", "")%>
													</td>
													<td>
														<div align="right">所在校区</div>
													</td>
													<td>
													<%
													if(userInfo.hasFunPower(Power.UserAdminPower)){%>
													<%=OrgCityNameMap.get(userInfo.getOrgId()+"") %>
													<%}else{%>
<%=HtmlTool.renderSelect(OrgCityNameOptions, ParamUtils.getParameter(request,"_City_",""), "_City_", "")%>
													<%} %>
													</td>
													<td>
														<div align="right">负责人姓名</div>
													</td>
													<td>
													<input name="_Chairman_" value="<%=ParamUtils.getParameter(request, "_Chairman_", "")%>"/>
													</td>
													<td>
														<div align="right">指导单位</div>
													</td>
													<td>
													<%
													if(userInfo.hasFunPower(Power.UserAdminPower)){%>
													<%=AcademyNameMap.get(userInfo.getDeptId()+"") %>
													<%}else{%>
<%=HtmlTool.renderSelect(AcademyNameOptions, ParamUtils.getParameter(request,"_Academy_",""), "_Academy_", "")%>
													<%}
													%>
													</td>
													<td colspan="2">&nbsp;</td>
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
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd="+cmd+"" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
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
