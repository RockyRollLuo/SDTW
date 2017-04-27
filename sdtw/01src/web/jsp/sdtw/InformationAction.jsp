<%@ page language="java" %>
<%--资讯信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Information.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] DicKeys = {"Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "标题", "500", "text", ""}, {"string", "图片信息", "300", "hidden", ""}, {"string", "描述", "2000", "hidden", ""}, {"date", "创建时间", "0", "text", ""}, {"int", "发表人", "0", "UserName", ""}, {"string", "发表人类型", "1", "hidden", ""}, {"string", "相关附件ids", "200", "text", ""}, {"string", "视频", "200", "hidden", ""}, {"int", "是否推荐", "0", "YesNo", ""}, {"int", "是否焦点", "0", "YesNo", ""}, {"string", "部门", "50", "text", ""}, {"int", "是否删除", "0", "YesNo", ""}, {"int", "排序", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] ListFields = {"Subject", "NewDate", "UserId", "AttachIds", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] FormFields = {"Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "AttachIds", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] QueryFields = {"Subject", "ImageInfo", "NewDate", "UserId", "IsRecommond", "IsFocus"};
private String[] HideFields = {"Id"};
private Information getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Information v = new Information();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSubject(request, "Subject");
        v.paramImageInfo(request, "ImageInfo");
        v.paramInfoDesc(request, "InfoDesc");
        v.paramNewDate(request, "NewDate");
        v.paramUserId(request, "UserId");
        v.paramUserType(request, "UserType");
        v.paramAttachIds(request, "AttachIds");
        v.paramVideoPath(request, "VideoPath");
        v.paramIsRecommond(request, "IsRecommond");
        v.paramIsFocus(request, "IsFocus");
        v.paramDept(request, "Dept");
        v.paramIsDel(request, "IsDel");
        v.paramOrderNum(request, "OrderNum");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSubject(ParamUtils.getParameter(request, "Subject", ""));
        v.setImageInfo(ParamUtils.getParameter(request, "ImageInfo", ""));
        v.setInfoDesc(ParamUtils.getParameter(request, "InfoDesc", ""));
        v.setNewDate(ParamUtils.getDateTimeParameter(request, "NewDate", java.sql.Date.valueOf("0001-01-01")));
        v.setUserId(ParamUtils.getIntParameter(request, "UserId", -1));
        v.setUserType(ParamUtils.getParameter(request, "UserType", ""));
        v.setAttachIds(ParamUtils.getParameter(request, "AttachIds", ""));
        v.setVideoPath(ParamUtils.getParameter(request, "VideoPath", ""));
        v.setIsRecommond(ParamUtils.getIntParameter(request, "IsRecommond", -1));
        v.setIsFocus(ParamUtils.getIntParameter(request, "IsFocus", -1));
        v.setDept(ParamUtils.getParameter(request, "Dept", ""));
        v.setIsDel(ParamUtils.getIntParameter(request, "IsDel", -1));
        v.setOrderNum(ParamUtils.getIntParameter(request, "OrderNum", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Information pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Information v = (Information)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSubject()));
        row.add(Tool.jsSpecialChars(v.getImageInfo()));
        row.add(Tool.jsSpecialChars(v.getInfoDesc()));
        row.add(Tool.stringOfDate(v.getNewDate()));
        row.add((String)UserNamemap.get("" + v.getUserId()));
        row.add(Tool.jsSpecialChars(v.getUserType()));
        row.add(Tool.jsSpecialChars(v.getAttachIds()));
        row.add(Tool.jsSpecialChars(v.getVideoPath()));
        row.add((String)YesNomap.get("" + v.getIsRecommond()));
        row.add((String)YesNomap.get("" + v.getIsFocus()));
        row.add(Tool.jsSpecialChars(v.getDept()));
        row.add((String)YesNomap.get("" + v.getIsDel()));
        row.add("" + v.getOrderNum());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Information pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Information pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_Subject_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("subject like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_ImageInfo_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("imageinfo like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_NewDate_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("newdate='" + qval + "'");
    }
    qval = ParamUtils.getParameter(request, "_UserId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("userid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_IsRecommond_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("isrecommond=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_IsFocus_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("isfocus=" + qval);
    }
    if (!isAll) {
        int currpage = ParamUtils.getIntParameter(request, "page", 1);
        com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(pv.getCount(cdt), currpage, shownum);
        cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
        request.setAttribute("PageControl", pc);
    }
    String cname = pv.getFieldByProperty(orderfield);
    if (cname.length() != 0) {
        cdt.add("order by " + cname + " " + ordertype);
        log.debug("order by " + cname + " " + ordertype);
    }
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("queryfields", QueryFields);
    request.setAttribute("queryvalues", QueryValues);
    return cdt;
}
private void setList(javax.servlet.http.HttpServletRequest request)
{
    setList(request, false);
request.setAttribute("hidefields", HideFields);}
private void setList(javax.servlet.http.HttpServletRequest request, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Information pv = new Information();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Information");
    request.setAttribute("describe", "资讯信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Information pv = new Information();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for (int k = 0; k < DicValues.length; k ++) {
            Label lr = new Label(k, 0, DicValues[k][1]);
            s1.addCell(lr);
        }
        int i = 1;
        List condition = getListCondition(request, pv, true);
        int num = pv.getCount(condition);
        for (int pos = 0; pos < num; pos += 100) {
            List cdt = new ArrayList(condition);
            for (Iterator it = condition.iterator(); it.hasNext();) {
                cdt.add(new String((String)it.next()));
            }
            cdt.add("limit " + pos + ",100");
            for (Iterator rit = getListRows(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (Iterator cit = row.iterator(); cit.hasNext(); j ++) {
                    Label lr = new Label(j, i, (String)cit.next());
                    s1.addCell(lr);
                }
            }
        }
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }
}
private void setForm(javax.servlet.http.HttpServletRequest request, Information form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Information");
    request.setAttribute("describe", "资讯信息");
}
private List mkRtn(String cmd, String forward, Information form)
{
    List rtn = new ArrayList();
    rtn.add(cmd);
    rtn.add(forward);
    rtn.add(form);
    return rtn;
}
public List main(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    log.debug("cmd=" + cmd);
    Information form = getByParameterDb(request);
    if (cmd.equals("list"))
    {
        setList(request);
        return mkRtn("list", "success", form);
    }
    if (cmd.equals("listall"))
    {
        setList(request, true);
        return mkRtn(cmd, "success", form);
    }
    if (cmd.equals("excel"))
    {
        String filename = HeadConst.root_file_path + "/upload/temp/" + userInfo.getName() + ".xls";
        writeExcel(request, filename);
        return mkRtn(cmd, "excel", form);
    }
    if (cmd.equals("create"))
    {
        setForm(request, form);
        return mkRtn("save", "input", form);
    }
    if (cmd.equals("modify"))
    {
        form = form.getById(form.getId());
        setForm(request, form);
        return mkRtn("update", "input", form);
    }
    if (cmd.equals("delete"))
    {
        form.delete(form.getId());
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("deletelist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        form.deleteByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("InformationAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
else {
    rtn = main(request);
}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "InformationAction.jsp");
forwardMap.put("failure", "InformationForm.jsp");
forwardMap.put("success", "InformationList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "InformationForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='InformationAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
