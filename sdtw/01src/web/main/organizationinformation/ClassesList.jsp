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
		<jsp:include page="../../main/comjs.jsp" flush="true"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
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
			function excel(){
				  $.messager.confirm('操作提示','是否下载excel模板？',function(r){
	            		if(r){
	            			window.open("<%=HeadConst.apache_url %>/servlet/attach?type=downclasses");
	            		}
	            	});
	            }
			function upload(){  //导入
          	$("#upwindow").window('open');
          }
			function closeUp(wName){   //关闭窗口
          	//$("#upwindow").window('close');
          	$('#'+wName).window('close');
          	$("#upFile").val("");
          	if(wName=='reswindow'){
          		window.location.reload();
          	}
          	//location.reload() ;
          }
			function checkType(){    //检查上传文件类型
          	var file=$("#upFile").val();
          	if(file){
          		var allowType = {"xls":""};
          		var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
          		var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; //jquery获得后缀名
          		if((fileExt+"").toLowerCase() in allowType){
          			ajaxFileUpload();
          		}
          		else{
          			$.messager.alert('操作提示','上传文件格式不符合要求，请重新选择！','error');
          		}
          	}
          	
          	return;
          }
			function ajaxFileUpload(){//上传文件
          	var fileElement;
          	fileElement='upFile';
          	$.ajaxFileUpload
              (
                  {
                      url:'ClassesAction.jsp?cmd=upLoadFile',
                      secureuri:false,
                      fileElementId:fileElement,
                      dataType: 'json',
                      success: function (data, status)
                      {
                     
                          if(typeof(data.error) != 'undefined')
                          {
                              if(data.error != '')
                              {
                              	$.messager.alert('操作提示',data.error,'error');
                              }else
                              {
                                 // closeUp();
                                  $("#reswindow").window('open');
                                  $("#resArea").html(data.msg+"<br/>"+data.outstr);
                                  closeUp('upwindow');
                                  
                              }
                          }
                          
                      },
                      error: function (data, status, e)
                      {
                      	$.messager.alert('操作提示','上传文件失败，请重新上传！','error');
                      }
                  }
              )
          }
		</script>
	</head>
	<body onload="init();">
	<%-- 	<jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
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
													          <div class="browsetitle001">班级</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("班级")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li> -->
														            <li class="browsetitle_lang"><a href="javascript: upload();">批量导入</a></li>
														            <li class="browsetitle_lang"><a href="javascript:excel();">下载模板</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>
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
														<div align="right">班级名称</div>
													</td>
													<td>
														<input name="_Name_" value="<%=ParamUtils.getParameter(request, "_Name_", "")%>">
													</td>
													<td colspan="4">&nbsp;</td>
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
		<div id="upwindow" class="easyui-window" title="导入班级信息" collapsible="false" minimizable="false" closed="true"
        maximizable="false" icon="icon-save"  style="width: 350px; height: 150px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                <tr>
                        <td>上传文件：</td>
                        <td><input id="upFile" name="upFile" type="file" class="txt01" /></td>
                </tr>
                <tr><td></td><td><font color="red">仅限xls格式的文件</font></td></tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:checkType();">确定</a>
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:closeUp('upwindow');">取消</a>
            </div>
        </div>
    </div>
    <div id="reswindow" class="easyui-window" title="导入结果" collapsible="false" minimizable="false" closed="true"
        maximizable="false" icon="icon-save"  style="width: 300px;height:300px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                <tr>
                        <td id="resArea" align="center" width="250px" align="center"></td>
                </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp1" class="easyui-linkbutton" icon="icon-ok" href="javascript:closeUp('reswindow');">确定</a>
            </div>
        </div>
    </div>
	</body>
</html>
