<%@ page language="java" %>
<%--人员管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/js/jsheader.jsp"%>
<%
Log log = LogFactory.getLog(BaseUserCode.class);
log.debug("BaseUserCodeTree");
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
BaseUserCode v = new BaseUserCode();
List cdt = new ArrayList();
cdt.add("limit 0, 300");
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
for (Iterator it = ((List)imap.get(treeRootKey)).iterator(); it.hasNext();) {
    BaseUserCode pv = (BaseUserCode)it.next();
    TreeItem ti = v.initTree(pv, imap);
    strTree.append(HtmlTool.getTreeView(ti, "tree", "tree", "treeClick", 1, true));
    //strTree.append(HtmlTool.getCheckBoxTree(ti, "tree", "tree", 1));
}
%>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="<%=HeadConst.apache_url%>/images/<%=Tool.getUserInfo(request).getSkinId()%>/web_oa.css">
<script src="<%=HeadConst.apache_url%>/js/xtree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=HeadConst.apache_url%>/js/xtree.css">
</head>
<body>
<script>
function treeClick(item) {
    alert(item.data);
}
if (document.getElementById) {
    var tree = new WebFXTree("人员管理");
    //var tree = new WebFXTree("人员管理", "javascript:void(0);", "[]", 1, 0);
    tree.setBehavior("classic");
    <%=strTree%>
    document.write(tree);
}
</script>
</body>
</html>
