<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<%@page import="com.xietong.software.sdtw.db.BaseDeptCode"%>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<%@ page language="java" %>
<%--部门--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.util.*"%>
<%@ include file="../js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseDeptCode.class);
	log.debug("DeptCodeTree");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
	    out.print(HtmlTool.msgBox(request, msg));
	    return;
	}
	//以下代码将产生树
	UserInfo userInfo = Tool.getUserInfo(request);
	if (userInfo==null) {
	    out.print(HtmlTool.msgBox(request, "用户未登录!"));
	    return;
	}
	BaseDeptCode v = new BaseDeptCode();
	List cdt = new ArrayList();
	cdt.add("limit 0, 300");
	cdt.add("order by orderby");
	Map imap = v.initParentMap(cdt);
	String treeRootKey = v.findRootKey(imap);
	log.debug("rootkey=" + treeRootKey);
	List tree = new ArrayList();
	if (imap.get(treeRootKey) == null) {
	    out.print(HtmlTool.msgBox(request, "没有树结点！"));
	    return;
	}
	StringBuffer strTree = new StringBuffer();
	for (Iterator it = ((List)imap.get(treeRootKey)).iterator(); it.hasNext();) {
		BaseDeptCode pv = (BaseDeptCode)it.next();
	    TreeItem ti = v.initTree(pv, imap);
	    strTree.append(HtmlTool.getTreeView(ti, "tree", "tree", "treeClick", 1, true));
	    //strTree.append(HtmlTool.getCheckBoxTree(ti, "tree", "tree", 1));
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	String orgName = "";
	if(userInfo.getOrgId()!=-1){
		orgName = CEditConst.getOrgNameMap(userInfo).get(userInfo.getOrgId()+"").toString();
	}
	else{
		//orgName = "登录用户没有单位！";
		orgName = "中国人民保险公司";
	}
%>
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script src="<%=HeadConst.apache_url%>/js/xtree.js"></script>
		<link type="text/css" rel="stylesheet" href="<%=HeadConst.apache_url%>/js/xtree.css">
		<script src="<%=HeadConst.apache_url%>/js/xmlextras.js"></script>
		<script src="<%=HeadConst.apache_url%>/js/common.js"></script>
		<script type="text/javascript">
			var url_para = "<%=url%>";
			var tree = new WebFXTree("<%=orgName%>", "javascript:treeClick(tree.getSelected());", "[{type:'DeptCode',id:'-1',pid:'无',code:'oadept',pcode:'',name:'协同办公系统',sort:'1',level:'0',url:'',checked:'0'}]", 0, 0);
			var currItem = {};
			var rows = {"-1": {"Id":"0", "OrgId":"", "Pid":"无", "Name":"", "Leaders":"", "Style":"", "Code":"", "Orderby":"", "ReptDept":"", "Address":"", "PostCode":"", "Tel":"", "Fax":"", "Email":"", "Remaik":"", "Enable":""}};
			function init() {
			    if (document.getElementById) {
			        tree.setBehavior("classic");
			        <%=strTree%>
			        document.getElementById("treelist").innerHTML = tree;
			    }
			}
			function treeClick(item) {
				currItem = item;
			    document.getElementById("prompt").innerHTML = "当前选中:[" + currItem.data.name + "]";
			    getDeptCode(currItem.data.id);
			}
			function editIt() {
			    if ((currItem.data == undefined)||(currItem.data.id == undefined || currItem.data.id == "-1")) {
			        alert("请选择可编辑部门!");
			        return;
			    }
			    window.location = "DeptCodeAction.jsp?cmd=modify&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
			}
			function cloneIt() {
			    if ((currItem.data == undefined)||(currItem.data.id == undefined || currItem.data.id == "-1")) {
			        alert("请选择可复制部门!");
			        return;
			    }
			    window.location = "DeptCodeAction.jsp?cmd=clone&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
			}
	
			function addNewSub(className, url_para)
			{
			    if ((currItem.data == undefined)||(currItem.data.id == undefined)) {
			        alert("请选择部门!");
			        return;
			    }
			    if (!url_para)
			        url_para = "";
			    var item = rows[currItem.data.id];
			    //alert((parseInt(currItem.data.level)));
			    location = "DeptCodeAction.jsp?cmd=create&Pid=" + currItem.data.id + "&MoudleGrade="+(parseInt(currItem.data.level)+1)+ ((url_para.length == 0) ? "" : "&" + url_para); 
			}
			function getDeptCode(id)
			{
			    var rtnval = rows[id];
			    var keys = ["Id", "OrgId", "Pid", "Name", "Code", "Orderby", "Enable"];
			    var decs = ["Id", "所属单位", "上级部门", "名称","部门编码","排序","是否可用"];
			    if (rtnval == undefined) {
			        var str = loadSync(GBasePath + "/common/Rpc.jsp?cmd=DeptCode&id=" + id + "&orgid=<%=ParamUtils.getIntParameter(request, "_OrgId_", -1)%>", false);
			       	
			       	document.getElementById("rpcForm").innerHTML = str;
			        rtnval = {};
			        for (var i in keys) {
			            rtnval[keys[i]] = document.rpc[keys[i]].value;
			        }
			        document.getElementById("rpcForm").innerHTML = "";
			        rows[id] = rtnval;
			    }
			    var str = "<ul>";
			    for (var i in keys) {
			        str += "<li>" + decs[i] + ":" + rtnval[keys[i]] + "</li>";
			    }
			    str += "</ul>";
			    document.getElementById("content").innerHTML = str;
			}
		</script>
	</head>
	<body onLoad="init();">
		<%-- <jsp:include page="../notice.jsp" flush="true"/> --%>
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
            							<td height="26" background="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="26"><div align="center"><img src="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanl.gif"></div></td>
                									<td width="80"><b class="bt">【部门管理】</b></td>
                									<td>&nbsp;<span id="prompt" class="bt">请选择一个部门</span></td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:editIt();">编辑</a></td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:cloneIt();">复制</a></td>
                									<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png"></div></td>
                									<td width="70" class="bt"><a href="javascript:addNewSub('Locus', url_para);">增加下一级</a></td>
              									</tr>
            								</table>
										</td>
          							</tr>
          							<tr>
            							<td valign="top"> 
              								<table width="100%" border="0" cellspacing="0" cellpadding="6">
                								<tr>
                  									<td style="padding: 20px;" id="treelist" width="50%" valign="top">
														
													</td>
													<td width="50%" id="content" valign="top"></td>
                								</tr>
                								<tr>
                  									<td style="padding: 20px;" colspan="2">
														<div id="content"></div>
														<div id="rpcForm" style="display:none"></div>
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
			<tr> 
				<td colspan="3" height="13"></td>
			</tr>
		</table>
	</body>
</html>
