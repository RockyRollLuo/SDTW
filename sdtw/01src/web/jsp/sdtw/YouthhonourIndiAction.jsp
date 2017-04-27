<%@ page language="java" %>
<%--五四评比表彰个人申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(YouthhonourIndi.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SchoolYear", "Type", "AddAccount", "AddTime", "XyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Sno", "Name", "Academy", "Grade", "Major", "Sex", "Nation", "SNative", "Photo", "Birthday", "Polistatu", "Phone", "Zhibu", "Duty", "WorkUnit", "VolstaTime", "VolservTime", "ClubName", "ClubType", "JoinClubInfo1", "JoinClubInfo2", "ClubInfo", "Education", "WorkExp", "Resume", "Award"};
private String[] DicKeys = {"Id", "SchoolYear", "Type", "AddAccount", "AddTime", "XyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Sno", "Name", "Academy", "Grade", "Major", "Sex", "Nation", "SNative", "Photo", "Birthday", "Polistatu", "Phone", "Zhibu", "Duty", "WorkUnit", "VolstaTime", "VolservTime", "ClubName", "ClubType", "JoinClubInfo1", "JoinClubInfo2", "ClubInfo", "Education", "WorkExp", "Resume", "Award"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学年", "45", "text", ""}, {"int", "申请表类型", "0", "text", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "学院审核标志", "0", "hidden", ""}, {"int", "团委审核标志", "0", "hidden", ""}, {"int", "是否可修改标志", "0", "hidden", ""}, {"int", "学院提交标志", "0", "hidden", ""}, {"int", "团委发布标志", "0", "hidden", ""}, {"date", "学院审核时间", "0", "hidden", ""}, {"date", "团委审核时间", "0", "hidden", ""}, {"string", "所属单位", "45", "hidden", ""}, {"string", "学号", "45", "text", ""}, {"string", "姓名", "45", "text", ""}, {"string", "学院", "45", "hidden", ""}, {"string", "年级", "45", "hidden", ""}, {"string", "专业", "45", "hidden", ""}, {"string", "性别", "2", "sex", ""}, {"string", "民族", "45", "hidden", ""}, {"string", "籍贯", "45", "text", ""}, {"string", "照片", "45", "text", ""}, {"string", "出生年月", "45", "text", ""}, {"string", "政治面貌", "45", "hidden", ""}, {"string", "联系电话", "45", "text", ""}, {"string", "支部", "45", "text", ""}, {"string", "职务", "45", "text", ""}, {"string", "所在组织（志愿）", "45", "hidden", ""}, {"string", "何时起参加支援服务（志愿", "45", "hidden", ""}, {"string", "总时长（志愿、社团", "45", "hidden", ""}, {"string", "社团名称（社团）", "45", "hidden", ""}, {"string", "所在社团属于（社团）", "45", "hidden", ""}, {"string", "参加校级社团活动情况（社团）", "45", "hidden", ""}, {"string", "参加院级社团活动情况（社团）", "45", "hidden", ""}, {"string", "社团简介（社团）", "500", "hidden", ""}, {"string", "教育程度", "45", "hidden", ""}, {"string", "工作经历", "500", "hidden", ""}, {"string", "个人简历", "500", "hidden", ""}, {"string", "获奖情况", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SchoolYear", "Type", "AddAccount", "AddTime", "XyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Sno", "Name", "Academy", "Grade", "Major", "Sex", "Nation", "SNative", "Photo", "Birthday", "Polistatu", "Phone", "Zhibu", "Duty", "WorkUnit", "VolstaTime", "VolservTime", "ClubName", "ClubType", "JoinClubInfo1", "JoinClubInfo2", "ClubInfo", "Education", "WorkExp", "Resume", "Award"};
private String[] ListFields = {"SchoolYear", "Type", "Sno", "Name", "Sex", "SNative", "Photo", "Birthday", "Phone", "Zhibu", "Duty"};
private String[] FormFields = {"SchoolYear", "Type", "AddAccount", "AddTime", "XyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Sno", "Name", "Academy", "Grade", "Major", "Sex", "Nation", "SNative", "Photo", "Birthday", "Polistatu", "Phone", "Zhibu", "Duty", "WorkUnit", "VolstaTime", "VolservTime", "ClubName", "ClubType", "JoinClubInfo1", "JoinClubInfo2", "ClubInfo", "Education", "WorkExp", "Resume", "Award"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private YouthhonourIndi getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthhonourIndi v = new YouthhonourIndi();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSchoolYear(request, "SchoolYear");
        v.paramType(request, "Type");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramXyCheckFlag(request, "XyCheckFlag");
        v.paramTwCheckFlag(request, "TwCheckFlag");
        v.paramModifyFlag(request, "ModifyFlag");
        v.paramXyReport(request, "XyReport");
        v.paramTwReport(request, "TwReport");
        v.paramXyCheckDate(request, "XyCheckDate");
        v.paramTwCheckDate(request, "TwCheckDate");
        v.paramBelongAcademy(request, "BelongAcademy");
        v.paramSno(request, "Sno");
        v.paramName(request, "Name");
        v.paramAcademy(request, "Academy");
        v.paramGrade(request, "Grade");
        v.paramMajor(request, "Major");
        v.paramSex(request, "Sex");
        v.paramNation(request, "Nation");
        v.paramSNative(request, "SNative");
        v.paramPhoto(request, "Photo");
        v.paramBirthday(request, "Birthday");
        v.paramPolistatu(request, "Polistatu");
        v.paramPhone(request, "Phone");
        v.paramZhibu(request, "Zhibu");
        v.paramDuty(request, "Duty");
        v.paramWorkUnit(request, "WorkUnit");
        v.paramVolstaTime(request, "VolstaTime");
        v.paramVolservTime(request, "VolservTime");
        v.paramClubName(request, "ClubName");
        v.paramClubType(request, "ClubType");
        v.paramJoinClubInfo1(request, "JoinClubInfo1");
        v.paramJoinClubInfo2(request, "JoinClubInfo2");
        v.paramClubInfo(request, "ClubInfo");
        v.paramEducation(request, "Education");
        v.paramWorkExp(request, "WorkExp");
        v.paramResume(request, "Resume");
        v.paramAward(request, "Award");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setXyCheckFlag(ParamUtils.getIntParameter(request, "XyCheckFlag", -1));
        v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
        v.setModifyFlag(ParamUtils.getIntParameter(request, "ModifyFlag", -1));
        v.setXyReport(ParamUtils.getIntParameter(request, "XyReport", -1));
        v.setTwReport(ParamUtils.getIntParameter(request, "TwReport", -1));
        v.setXyCheckDate(ParamUtils.getDateTimeParameter(request, "XyCheckDate", java.sql.Date.valueOf("0001-01-01")));
        v.setTwCheckDate(ParamUtils.getDateTimeParameter(request, "TwCheckDate", java.sql.Date.valueOf("0001-01-01")));
        v.setBelongAcademy(ParamUtils.getParameter(request, "BelongAcademy", ""));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setGrade(ParamUtils.getParameter(request, "Grade", ""));
        v.setMajor(ParamUtils.getParameter(request, "Major", ""));
        v.setSex(ParamUtils.getParameter(request, "Sex", ""));
        v.setNation(ParamUtils.getParameter(request, "Nation", ""));
        v.setSNative(ParamUtils.getParameter(request, "SNative", ""));
        v.setPhoto(ParamUtils.getParameter(request, "Photo", ""));
        v.setBirthday(ParamUtils.getParameter(request, "Birthday", ""));
        v.setPolistatu(ParamUtils.getParameter(request, "Polistatu", ""));
        v.setPhone(ParamUtils.getParameter(request, "Phone", ""));
        v.setZhibu(ParamUtils.getParameter(request, "Zhibu", ""));
        v.setDuty(ParamUtils.getParameter(request, "Duty", ""));
        v.setWorkUnit(ParamUtils.getParameter(request, "WorkUnit", ""));
        v.setVolstaTime(ParamUtils.getParameter(request, "VolstaTime", ""));
        v.setVolservTime(ParamUtils.getParameter(request, "VolservTime", ""));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubType(ParamUtils.getParameter(request, "ClubType", ""));
        v.setJoinClubInfo1(ParamUtils.getParameter(request, "JoinClubInfo1", ""));
        v.setJoinClubInfo2(ParamUtils.getParameter(request, "JoinClubInfo2", ""));
        v.setClubInfo(ParamUtils.getParameter(request, "ClubInfo", ""));
        v.setEducation(ParamUtils.getParameter(request, "Education", ""));
        v.setWorkExp(ParamUtils.getParameter(request, "WorkExp", ""));
        v.setResume(ParamUtils.getParameter(request, "Resume", ""));
        v.setAward(ParamUtils.getParameter(request, "Award", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, YouthhonourIndi pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map sexmap = CEditConst.getsexMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        YouthhonourIndi v = (YouthhonourIndi)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSchoolYear()));
        row.add("" + v.getType());
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add("" + v.getXyCheckFlag());
        row.add("" + v.getTwCheckFlag());
        row.add("" + v.getModifyFlag());
        row.add("" + v.getXyReport());
        row.add("" + v.getTwReport());
        row.add(Tool.stringOfDate(v.getXyCheckDate()));
        row.add(Tool.stringOfDate(v.getTwCheckDate()));
        row.add(Tool.jsSpecialChars(v.getBelongAcademy()));
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add(Tool.jsSpecialChars(v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getGrade()));
        row.add(Tool.jsSpecialChars(v.getMajor()));
        row.add((String)sexmap.get("" + v.getSex()));
        row.add(Tool.jsSpecialChars(v.getNation()));
        row.add(Tool.jsSpecialChars(v.getSNative()));
        row.add(Tool.jsSpecialChars(v.getPhoto()));
        row.add(Tool.jsSpecialChars(v.getBirthday()));
        row.add(Tool.jsSpecialChars(v.getPolistatu()));
        row.add(Tool.jsSpecialChars(v.getPhone()));
        row.add(Tool.jsSpecialChars(v.getZhibu()));
        row.add(Tool.jsSpecialChars(v.getDuty()));
        row.add(Tool.jsSpecialChars(v.getWorkUnit()));
        row.add(Tool.jsSpecialChars(v.getVolstaTime()));
        row.add(Tool.jsSpecialChars(v.getVolservTime()));
        row.add(Tool.jsSpecialChars(v.getClubName()));
        row.add(Tool.jsSpecialChars(v.getClubType()));
        row.add(Tool.jsSpecialChars(v.getJoinClubInfo1()));
        row.add(Tool.jsSpecialChars(v.getJoinClubInfo2()));
        row.add(Tool.jsSpecialChars(v.getClubInfo()));
        row.add(Tool.jsSpecialChars(v.getEducation()));
        row.add(Tool.jsSpecialChars(v.getWorkExp()));
        row.add(Tool.jsSpecialChars(v.getResume()));
        row.add(Tool.jsSpecialChars(v.getAward()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, YouthhonourIndi pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, YouthhonourIndi pv, boolean isAll)
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
    YouthhonourIndi pv = new YouthhonourIndi();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "YouthhonourIndi");
    request.setAttribute("describe", "五四评比表彰个人申请表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthhonourIndi pv = new YouthhonourIndi();
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
private void setForm(javax.servlet.http.HttpServletRequest request, YouthhonourIndi form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("PoliticsNameoptions", CEditConst.getPoliticsNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, ""));
    request.setAttribute("Identityoptions", CEditConst.getIdentityOptions(userInfo, ""));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, ""));
    request.setAttribute("NationNameoptions", CEditConst.getNationNameOptions(userInfo, ""));
    request.setAttribute("MajorNameoptions", CEditConst.getMajorNameOptions(userInfo, ""));
    request.setAttribute("ClubTypeNameoptions", CEditConst.getClubTypeNameOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "YouthhonourIndi");
    request.setAttribute("describe", "五四评比表彰个人申请表");
}
private List mkRtn(String cmd, String forward, YouthhonourIndi form)
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
    YouthhonourIndi form = getByParameterDb(request);
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
log.debug("YouthhonourIndiAction");
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
forwardMap.put("list", "YouthhonourIndiAction.jsp");
forwardMap.put("failure", "YouthhonourIndiForm.jsp");
forwardMap.put("success", "YouthhonourIndiList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "YouthhonourIndiForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='YouthhonourIndiAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
