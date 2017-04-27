<%@ page language="java" %>
<%--社团活动报名--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubActivityParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Clubid", "Clubname", "Activityid", "Activityname", "Sno", "Sname", "Applytime", "Checktime", "Checkaccount", "Checkflag", "Issafe", "Traffictool", "Activityprocedure", "Activitysecurity", "Istell", "Isbuy", "Tellway", "Iswilling", "Isvoluntary", "Isresponsible", "Safetime"};
private String[] DicKeys = {"Id", "Clubid", "Clubname", "Activityid", "Activityname", "Sno", "Sname", "Applytime", "Checktime", "Checkaccount", "Checkflag", "Issafe", "Traffictool", "Activityprocedure", "Activitysecurity", "Istell", "Isbuy", "Tellway", "Iswilling", "Isvoluntary", "Isresponsible", "Safetime"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "社团编号", "45", "text", ""}, {"string", "社团名称", "45", "ClubName", ""}, {"string", "活动id", "45", "text", ""}, {"string", "活动名称", "100", "text", ""}, {"string", "学号", "45", "text", ""}, {"string", "姓名", "45", "text", ""}, {"date", "申请时间", "0", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "审核账号", "45", "hidden", ""}, {"int", "审核状态", "0", "hidden", ""}, {"int", "issafe", "0", "hidden", ""}, {"string", "交通工具", "100", "hidden", ""}, {"string", "活动程序", "1000", "hidden", ""}, {"string", "安全保障措施", "1000", "hidden", ""}, {"string", "是否将本次活动的详细情况告知了父母", "10", "hidden", ""}, {"string", "和父母商议是否购买保险", "10", "hidden", ""}, {"string", "告知父母的方式(面谈/电话/信件)", "10", "hidden", ""}, {"string", "父母是否知道这次活动是自愿参加", "10", "hidden", ""}, {"string", "父母是否知道这次活动是由学生社团自发组织", "10", "hidden", ""}, {"string", "如万一在活动中发生任何意外情况，父母是否同意责任自负", "10", "hidden", ""}, {"date", "safetime", "0", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Clubid", "Clubname", "Activityid", "Activityname", "Sno", "Sname", "Applytime", "Checktime", "Checkaccount", "Checkflag", "Issafe", "Traffictool", "Activityprocedure", "Activitysecurity", "Istell", "Isbuy", "Tellway", "Iswilling", "Isvoluntary", "Isresponsible", "Safetime"};
private String[] ListFields = {"Clubid", "Clubname", "Activityid", "Activityname", "Sno", "Sname"};
private String[] FormFields = {"Clubname", "Activityid", "Activityname", "Sno", "Sname", "Applytime", "Checktime", "Checkaccount", "Checkflag", "Issafe", "Traffictool", "Activityprocedure", "Activitysecurity", "Istell", "Isbuy", "Tellway", "Iswilling", "Isvoluntary", "Isresponsible", "Safetime"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubActivityParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubActivityParticipate v = new ClubActivityParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubid(request, "Clubid");
        v.paramClubname(request, "Clubname");
        v.paramActivityid(request, "Activityid");
        v.paramActivityname(request, "Activityname");
        v.paramSno(request, "Sno");
        v.paramSname(request, "Sname");
        v.paramApplytime(request, "Applytime");
        v.paramChecktime(request, "Checktime");
        v.paramCheckaccount(request, "Checkaccount");
        v.paramCheckflag(request, "Checkflag");
        v.paramIssafe(request, "Issafe");
        v.paramTraffictool(request, "Traffictool");
        v.paramActivityprocedure(request, "Activityprocedure");
        v.paramActivitysecurity(request, "Activitysecurity");
        v.paramIstell(request, "Istell");
        v.paramIsbuy(request, "Isbuy");
        v.paramTellway(request, "Tellway");
        v.paramIswilling(request, "Iswilling");
        v.paramIsvoluntary(request, "Isvoluntary");
        v.paramIsresponsible(request, "Isresponsible");
        v.paramSafetime(request, "Safetime");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubid(ParamUtils.getParameter(request, "Clubid", ""));
        v.setClubname(ParamUtils.getParameter(request, "Clubname", ""));
        v.setActivityid(ParamUtils.getParameter(request, "Activityid", ""));
        v.setActivityname(ParamUtils.getParameter(request, "Activityname", ""));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setSname(ParamUtils.getParameter(request, "Sname", ""));
        v.setApplytime(ParamUtils.getDateTimeParameter(request, "Applytime", java.sql.Date.valueOf("0001-01-01")));
        v.setChecktime(ParamUtils.getDateTimeParameter(request, "Checktime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckaccount(ParamUtils.getParameter(request, "Checkaccount", ""));
        v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", -1));
        v.setIssafe(ParamUtils.getIntParameter(request, "Issafe", -1));
        v.setTraffictool(ParamUtils.getParameter(request, "Traffictool", ""));
        v.setActivityprocedure(ParamUtils.getParameter(request, "Activityprocedure", ""));
        v.setActivitysecurity(ParamUtils.getParameter(request, "Activitysecurity", ""));
        v.setIstell(ParamUtils.getParameter(request, "Istell", ""));
        v.setIsbuy(ParamUtils.getParameter(request, "Isbuy", ""));
        v.setTellway(ParamUtils.getParameter(request, "Tellway", ""));
        v.setIswilling(ParamUtils.getParameter(request, "Iswilling", ""));
        v.setIsvoluntary(ParamUtils.getParameter(request, "Isvoluntary", ""));
        v.setIsresponsible(ParamUtils.getParameter(request, "Isresponsible", ""));
        v.setSafetime(ParamUtils.getDateTimeParameter(request, "Safetime", java.sql.Date.valueOf("0001-01-01")));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubActivityParticipate pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map ClubNamemap = CEditConst.getClubNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubActivityParticipate v = (ClubActivityParticipate)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubid()));
        row.add((String)ClubNamemap.get("" + v.getClubname()));
        row.add(Tool.jsSpecialChars(v.getActivityid()));
        row.add(Tool.jsSpecialChars(v.getActivityname()));
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getSname()));
        row.add(Tool.stringOfDate(v.getApplytime()));
        row.add(Tool.stringOfDate(v.getChecktime()));
        row.add(Tool.jsSpecialChars(v.getCheckaccount()));
        row.add("" + v.getCheckflag());
        row.add("" + v.getIssafe());
        row.add(Tool.jsSpecialChars(v.getTraffictool()));
        row.add(Tool.jsSpecialChars(v.getActivityprocedure()));
        row.add(Tool.jsSpecialChars(v.getActivitysecurity()));
        row.add(Tool.jsSpecialChars(v.getIstell()));
        row.add(Tool.jsSpecialChars(v.getIsbuy()));
        row.add(Tool.jsSpecialChars(v.getTellway()));
        row.add(Tool.jsSpecialChars(v.getIswilling()));
        row.add(Tool.jsSpecialChars(v.getIsvoluntary()));
        row.add(Tool.jsSpecialChars(v.getIsresponsible()));
        row.add(Tool.stringOfDate(v.getSafetime()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubActivityParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubActivityParticipate pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
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
    ClubActivityParticipate pv = new ClubActivityParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubActivityParticipate");
    request.setAttribute("describe", "社团活动报名");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubActivityParticipate pv = new ClubActivityParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubActivityParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubActivityParticipate");
    request.setAttribute("describe", "社团活动报名");
}
private List mkRtn(String cmd, String forward, ClubActivityParticipate form)
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
    ClubActivityParticipate form = getByParameterDb(request);
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
log.debug("ClubActivityParticipateAction");
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
forwardMap.put("list", "ClubActivityParticipateAction.jsp");
forwardMap.put("failure", "ClubActivityParticipateForm.jsp");
forwardMap.put("success", "ClubActivityParticipateList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubActivityParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubActivityParticipateAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
