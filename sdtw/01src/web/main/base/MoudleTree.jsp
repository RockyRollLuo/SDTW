<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<%@page import="com.xietong.software.sdtw.db.BaseMoudle"%>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<%@ page language="java" %>
<%--模块--%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="../js/jsheader.jsp"%>
<%!
public TreeItem initTree(BaseMoudle item, Map parent) {
    TreeItem ti = cloneTi(item);
    List list = (List)parent.get("" + item.getId());
    if (list != null) {
        for (Iterator it = list.iterator(); it.hasNext();) {
        	BaseMoudle v = (BaseMoudle)it.next();
            TreeItem nti = cloneTi(v);
            TreeItem sti = initTree(v, parent);
            if (sti.equals(nti)) {
                ti.put(sti.getId(), sti);
            }
            else {
                sti.put(nti.getId(), nti);
            }
        }
    }
    return ti;
}

public TreeItem cloneTi(BaseMoudle item) {
    TreeItem ti = new TreeItem();
    ti.setId(item.getId());
    ti.setPid(item.getPid());
    ti.setName(item.getName());
    ti.setCode(item.getCode());
    ti.setOrders("" + item.getOrderNum());
    ti.setClassName("Moudle");
    return ti;
}
%>
<%
	Log log = LogFactory.getLog(BaseMoudle.class);
	log.debug("MoudleTree");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
	    out.print(HtmlTool.msgBox(request, msg));
	    return;
	}
	response.setDateHeader ("Expires", 0);
	//以下代码将产生树
	UserInfo userInfo = Tool.getUserInfo(request);
	if (userInfo==null) {
	    out.print(HtmlTool.msgBox(request, "用户未登录!"));
	    return;
	}
	BaseMoudle v = new BaseMoudle();
	List cdt = new ArrayList();
	cdt.add("Order by ordernum");
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
		BaseMoudle pv = (BaseMoudle)it.next();
	    TreeItem ti = initTree(pv, imap);
	    strTree.append(HtmlTool.getTreeView(ti, "tree", "tree", "treeClick", 1, true));
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
%>
<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
		<script src="<%=HeadConst.apache_url%>/main/js/xtree.js"></script>
		<link type="text/css" rel="stylesheet" href="<%=HeadConst.apache_url%>/main/js/xtree.css">
		<script src="<%=HeadConst.apache_url%>/main/js/xmlextras.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		<script>
			var url_para = "<%=url%>";
			var tree = new WebFXTree("模块", "javascript:treeClick(tree.getSelected());", "[{type:'Moudle',id:'-1',pid:'-1',code:'',pcode:'',name:'模块',url:'',checked:'0'}]", 0, 0);
			var rows = {"-1": {"Id": "-1", "Pid": "-1", "Name": "", "TheType": "", "DocumentType": "", "DocumentScope": "", "MoudleGrade": "0", "OrderBy": "0",  "ToUrl": "", "Show": "1", "ExcludeUsers": ""}};
			var currItem = {};
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
			    getMoudle(currItem.data.id);
			}
			function editIt() {
			    if (currItem.data == undefined || (currItem.data.id == undefined || currItem.data.id == "-1")) {
			        alert("请选择可编辑模块!");
			        return;
			    }
			    window.location = "MoudleAction.jsp?cmd=modify&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
			}
			function cloneIt() {
			    if (currItem.data == undefined || (currItem.data.id == undefined || currItem.data.id == "-1")) {
			        alert("请选择可复制模块!");
			        return;
			    }
			    window.location = "MoudleAction.jsp?cmd=clone&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
			}
			function addNewSub(className, url_para)
			{
				 if ((currItem.data == undefined)||(currItem.data.id == undefined))  {
			        alert("请选择模块!");
			        return;
			    }
			    if (!url_para)
			        url_para = "";
			    var item = rows[currItem.data.id];
			    location = "MoudleAction.jsp?cmd=create&Pid=" + item.Id + "&MoudleGrade=" + (parseInt(item.MoudleGrade) + 1) + ((url_para.length == 0) ? "" : "&" + url_para); 
			}
			function getMoudle(id)
			{
			    var rtnval = rows[id];
			    //"cmd", "page", "idlist", "Id", "Pid", "Name", "Code", "MoudleGrade", "MoudleType","IsDept", "ToUrl", "OrderNum", "IsEnable", "OpLog"};
			    //var keys = ["Id", "Pid", "Name", "Code", "MoudleGrade", "MoudleOrFun", "IsDept", "OrderNum",  "ToUrl"];
			    //var decs = ["Id", "上级模块", "模块名称", "编码", "级别", "类型", "部门模块", "排序", "连接Url"];
			    var keys = ["Id", "Pid", "Name", "MoudleGrade",  "IsDept","OrderNum",  "ToUrl"];
			    var decs = ["Id", "上级模块", "模块名称",  "级别", "部门模块","排序", "连接Url"];
			    if (rtnval == undefined) {
			        var str = loadSync(GBasePath + "/main/common/Rpc.jsp?cmd=MoudleToMap&id=" + id + "&orgid=<%=ParamUtils.getIntParameter(request, "_OrgId_", -1)%>", false);
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
	<body onload="init();">
		<%-- <jsp:include page="../jqueryui.jsp" flush="true"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
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
                									<td width="55" class="bt"><b>模块管理</b></td>
                									<td>&nbsp;&nbsp;&nbsp;&nbsp;<span id="prompt" class="bt">请选择一个模块</span></td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:editIt();">编辑</a></td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:cloneIt();">复制</a></td>
                									<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png"></div></td>
                									<td width="70" class="bt"><a href="javascript:addNewSub('Moudle', url_para);">增加下一级</a></td>
              									</tr>
            								</table>
										</td>
          							</tr>
          							<tr>
            							<td valign="top"> 
              								<table width="100%" border="0" cellspacing="0" cellpadding="6">
                								<tr>
                  									<td style="padding: 20px;" id="treelist" width="40%" valign="top">
														
													</td>
													<td width="60%" id="content" valign="top"></td>
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
			</tr>
		</table>
	</body>
</html>
