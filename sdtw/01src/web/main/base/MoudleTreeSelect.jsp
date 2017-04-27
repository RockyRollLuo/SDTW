<%@page import="com.xietong.software.sdtw.db.BaseMoudle"%>
<%@ page language="java" %>
<%--模块--%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
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
String ids = (String)request.getAttribute("ids");
String flag = (String)request.getAttribute("flag");
BaseMoudle v = new BaseMoudle();
List cdt = new ArrayList();
cdt.add("order by OrderNum");
cdt.add("limit 0, 300");
if(flag.equals("1")){
	cdt.add("MoudleType=" + flag);//flag ==1 功能点
}else{
	cdt.add("MoudleType<=" + flag);
}
cdt.add("order by id");
Map imap = v.initParentMap(cdt);
String treeRootKey = v.findRootKey(imap);
log.debug("rootkey=" + treeRootKey);
List tree = new ArrayList();
if (imap.get(treeRootKey) == null) {
    out.print(HtmlTool.msgBox(request, "没有树结点！"));
    return;
}
StringBuffer strTree = new StringBuffer();
BaseMoudle cm = new BaseMoudle();
for (Iterator it = ((List)imap.get(treeRootKey)).iterator(); it.hasNext();) {
	BaseMoudle pv = (BaseMoudle)it.next();
    TreeItem ti = cm.initTree(pv, imap);
    ti.setCode(pv.getCode());
    //strTree.append(HtmlTool.getTreeView(ti, "tree", "tree", "treeClick", 1, true));
    strTree.append(HtmlTool.getCheckBoxTree(ti, "tree", "tree", 1,ids));
}
Map extMaps = (Map)request.getAttribute("Ext");
List paras = HttpTool.getSavedUrlForm(request, "Ext");
List urls = (List)paras.get(0);
List forms = (List)paras.get(1);
urls.addAll((List)paras.get(2));
String url = Tool.join("&", urls);

%>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<link rel="STYLESHEET" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=Tool.getUserInfo(request).getSkinId()%>/css_blue.css">
<script src="<%=HeadConst.apache_url%>/main/js/xtree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=HeadConst.apache_url%>/main/js/xtree.css">
</head>
<body>
<script>
var url_para = "<%=url%>";
var currItem = {};
var rows = {"-1": {"Id": "-1", "Pid": "-1", "Name": "", "TheType": "", "DocumentType": "", "DocumentScope": "", "Grade": "0", "OrderBy": "0",  "ToUrl": "", "Show": "1", "ExcludeUsers": ""}};
if (document.getElementById) {
    var tree = new WebFXTree("模块");
    //var tree = new WebFXTree("模块", "javascript:void(0);", "[]", 1, 0);
    tree.setBehavior("classic");
    <%=strTree%>
    document.write(tree);
}


function treeClick(item) {
	currItem = item;
    //document.getElementById("prompt").innerHTML = "当前选中:[" + currItem.data.name + "]";
}
function editIt() {
    if (currItem.data.id == undefined || currItem.data.id == "-1") {
        alert("请选择可编辑模块!");
        return;
    }
    window.location = "<%=request.getAttribute("classname")%>Action.jsp?cmd=modify&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
}
function cloneIt() {
    if (currItem.data.id == undefined || currItem.data.id == "-1") {
        alert("请选择可复制模块!");
        return;
    }
    window.location = "<%=request.getAttribute("classname")%>Action.jsp?cmd=clone&Id=" + currItem.data.id + ((url_para.length == 0) ? "" : "&" + url_para);
}

function addNewSub(className, url_para)
{
    if (currItem.data.id == undefined) {
        alert("请选择模块!");
        return;
    }
    if (!url_para)
        url_para = "";
    var item = rows[currItem.data.id];
    for(var u in currItem.data){
    	//alert(u);
    }
    location = className + "Action.jsp?cmd=create&Pid=" + currItem.data.id +  ((url_para.length == 0) ? "" : "&" + url_para); 
}
function selectAll(flag)
{
    tree.expandAll();
    for (var i = 0; i < webFXTreeHandler.idCounter; i++) {
        var item = webFXTreeHandler.getItem(i);
        if (item != undefined)
            if (item.data != undefined && item.type == webFXTreeConfig.checkboxType && item.checked == (1 - flag)) {
                item.check();
            }
    }
}

function ok()
{
    var rtn = {"ids": "", "names" : "", "codes" : "","funids":"", "funnames" : "", "funcodes" : ""};
    var items = tree.getCheckeds();
    for(m in items){
    	if(items[m].checked=="1"){//模块串
    		if(rtn.ids==""){
            		rtn.ids=items[m].id;
            	}else{
            		rtn.ids=rtn.ids+","+items[m].id;
            	}
                if(rtn.names==""){
            		rtn.names=items[m].name;
            	}else{
            		rtn.names=rtn.names+","+items[m].name;
            	}
            	if(rtn.codes==""){
            		rtn.codes=items[m].code;
            	}else{
            		rtn.codes=rtn.codes+","+items[m].code;
            	}
           }
    	
    }
    window.opener.document.postForm.MoudleIds.value = rtn.ids;
    window.opener.document.postForm.MoudleCode.value = rtn.codes;
    window.opener.document.postForm.MoudleNames.value = rtn.names;
    top.close();
}

function ok1()
{
    var rtn = {"ids": "", "names" : "", "codes" : "","funids":"", "funnames" : "", "funcodes" : ""};
    var items = tree.getCheckeds();
    for(m in items){
    	if(items[m].checked=="1"){
    		if(rtn.funids==""){
            		rtn.funids=items[m].id;
            	}else{
            		rtn.funids=rtn.funids+","+items[m].id;
            	}
                if(rtn.funnames==""){
            		rtn.funnames=items[m].name;
            	}else{
            		rtn.funnames=rtn.funnames+","+items[m].name;
            	}
            	if(rtn.funcodes==""){
            		rtn.funcodes=items[m].code;
            	}else{
            		rtn.funcodes=rtn.funcodes+","+items[m].code;
            	}
            }
    	
    	
    }
    
    window.opener.document.postForm.FunIds.value = rtn.funids;
    window.opener.document.postForm.FunCodes.value = rtn.funcodes;
    window.opener.document.postForm.FunNames.value = rtn.funnames;
    top.close();
}
function cancel()
{
    top.close();
}
</script>
<br>
<div id="buttons" align="center">
<input type="button" value="展开" onclick="javascript:tree.expandAll();">
<input type="button" value="全选" onclick="javascript:selectAll(1);">
<input type="button" value="全否" onclick="javascript:selectAll(0);">
<%if(flag.equals("0")) {%>
<input type="button" value="选定" onclick="javascript:ok();">
<%}else{ %>
<input type="button" value="选定" onclick="javascript:ok1();">
<%}%>
<input type="button" value="取消" onclick="javascript:cancel();">
</div>
</body>
</html>
