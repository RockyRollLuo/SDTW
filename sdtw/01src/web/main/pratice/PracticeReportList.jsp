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
	int DeclareId = ParamUtils.getIntParameter(request,"_DeclareId_",-1);//立项id
	Practice v = new Practice();//立项表
	if (DeclareId!=-1&&v.getById(DeclareId)!=null) {
		v = v.getById(DeclareId);
	}
	int tabs = ParamUtils.getIntParameter(request,"tabs",0);
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<jsp:include page="../../main/jqueryui.jsp" flush="true"/>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
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
			    if(showEdit == "1"){
			    	str = str + "<td bgcolor=\"#3992d0\" nowrap><div class=\"browsetable004\">查看</div></td>\n";
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
			    	str = str + "<td bgcolor=\"#3992d0\" nowrap><div class=\"browsetable004\">查看</div></td>\n";
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
			                	else {
			                		if(k==11) {
			                			var s = "分配荣誉";
			                			//alert(rows[i][0])
			                			var id = rows[i][0];
			                			var type=rows[i][2];
			                			if (rows[i][9]=="未审核") {//团委审核
			                				if (rows[i][k]!="") {
			                					s = "修改荣誉";
			                				}
			                			} else {
			                				s = "查看分配情况";
			                			}
			                			/**
			                			Honor
			                			,c,HonorType,,社会实践-个人申报,5
										,c,HonorType,,社会实践-集体申报,6
			                			**/
			                			/* var type1=1;//集体
			                			if(type=="集体"){
			                				type1=6;//集体
			                			}
			                			if(type=="个人"){
			                				type1=5;//个人
			                			} */
			                			//荣誉
			                			str = str + getRow("<a class=visit style='cursor:hand;color:red;' href='javascript:setHonor("+id+")' style='color:red;'>"+s+"</a>", fields[j]);
			                		} else {
			                			str = str + getRow(rows[i][k], fields[j]);
			                		}
			                	}
			                }                
			            }        
			            str = str + "</tr>\n";
			        }
			    }
			    str = str + '</table>';
			    document.getElementById("list").innerHTML = str;
			}

			
			function returnList(currpage, url_para) {
				var new_url = url_para;
				window.location = "PracticeAction.jsp?page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
			}
			function checkPassOrNo(className,flag,currpage, url_para,check) {
				var page = 1;
				var check = "";
				if (flag=="1") {
					check="审核通过";
				}
				if (flag=="2") {
					check="审核不通过";
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
			        if (confirm("确实要"+check+"这些记录吗?")) {
			            location = className + "Action.jsp?cmd=checklist&"+check+"&_DeclareId_=<%=DeclareId%>&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			
			function setHonor(id) {
				var url = "<%=HeadConst.apache_url%>/main/pratice/PracticeDeclareTeammemberAction.jsp?_ReportId_="+id;
              	openWindow(url,"900,600");
              
				/* var height = window.screen.availHeight;
				var width = window.screen.availWidth;
				var arg = {}; // 可通过该参数给模态窗口传递参数
				var window_parameter = 'dialogHeight=' + height + ';dialogWidth=' + width + ';resizable=no;location=no;menubar=no;status:no;';
				window.showModalDialog(url, arg, window_parameter); */

			}
			function shenhe(url_para) {
				var page = 1;
				location.href="<%=HeadConst.apache_url%>/main/pratice/PracticeReportAction.jsp?tabs=0&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			}
			function fenpeihonor(url_para) {
				var page = 1;
				location.href="<%=HeadConst.apache_url%>/main/pratice/PracticeReportAction.jsp?tabs=1&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			}
			function modifyRecord1(className, id, currpage, url_para, cmd) {
			    //已经由Action处理了，现在不用处理了。
			    //var new_url = getQuery(url_para);
				//alert("modifyRecord1"+className);
			    var new_url = url_para;
			   	//window.location= className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
			   	var url = "<%=HeadConst.apache_url%>/main/pratice/"+className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
			   	//alert(url)
			   	parent.showDialog (url,1000,600,'查看结题书'
                        ,{ 
              });

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
												            <div class="browsetitleleft">
													          <div class="browsetitle001"><%=v.getPracticeName() %>结题书</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell(v.getPracticeName()+"结题书")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <%-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>
														            <li><a href="javascript:document.query.submit();">查询</a></li> --%>
														            <li ><a href="javascript:returnList(1,url_para);">返回</a></li>
														            <%
													            	if(tabs==0) {
															            if (userInfo.hasFunPower(Power.UserAdminPower)) {//指导单位
															            %>
															            	<li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',2,url_para,'XyCheckFlag=2');">审核不通过</a></li>
															            	<li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',1,url_para,'XyCheckFlag=1');">审核通过</a></li>
															            <%}
															            if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {//团委
																            %>
																            	<li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',2,url_para,'TwCheckFlag=2');">审核不通过</a></li>
																            	<li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',1,url_para,'TwCheckFlag=1');">审核通过</a></li>
																           <%}
															           // if(tabs==1) {%>
															            	<%-- <li class="browsetitle_lang"><a href="javascript:setHonor('<%=request.getAttribute("classname")%>',url_para);">分配荣誉</a></li> --%>
															            <%//}
														            }
														            %>
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
                               </div>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
        										<tr>
          											<td>
          											<div id="tabs" style='display: block' >
															<ul>
																<li><a href="#tabs-1" onmousedown="shenhe(url_para);">审核</a></li>
																<li><a href="#tabs-2" onmousedown="fenpeihonor(url_para);">分配荣誉</a></li>
															</ul>
														<div id="list" class="browsetable">
														</div>
														<div id="tabs-1" style="display: none">
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
														</div>
														<div id="tabs-2" style="display: none">
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
														</div>
														</div>
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
		<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', '<%=tabs%>'); 
	});
	</script>
	</body>
</html>
