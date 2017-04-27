<%@ page language="java" %>
<%--学生表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Students.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Sno", "SName", "SSex", "Sacademy", "TimeToSchool", "TimeToTuan", "Birthday", "ZhiBu", "Nation", "Major", "LenOfSchool", "Grade", "Polista", "NativePlace", "IDNum", "Phone", "Email", "Addfilelist", "YearToSchool", "GraduateTime", "VolunteerfFag"};
private String[] DicKeys = {"Id", "Sno", "SName", "SSex", "Sacademy", "TimeToSchool", "TimeToTuan", "Birthday", "ZhiBu", "Nation", "Major", "LenOfSchool", "Grade", "Polista", "NativePlace", "IDNum", "Phone", "Email", "Addfilelist", "YearToSchool", "GraduateTime", "VolunteerfFag"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学号", "45", "text", ""}, {"string", "姓名", "50", "text", ""}, {"string", "性别", "2", "text", ""}, {"string", "学院", "50", "hidden", ""}, {"date", "入校时间", "0", "hidden", ""}, {"date", "入团时间", "0", "hidden", ""}, {"date", "生日", "0", "text", ""}, {"string", "支部", "50", "ClassesName", ""}, {"string", "民族", "50", "NationName", ""}, {"string", "专业", "50", "MajorName", ""}, {"string", "学制", "50", "LenOfSchool", ""}, {"string", "年级", "50", "GradeName", ""}, {"string", "政治面貌", "3", "PoliticsName", ""}, {"string", "籍贯", "50", "text", ""}, {"string", "身份证号码", "50", "text", ""}, {"string", "手机", "50", "text", ""}, {"string", "邮箱", "50", "text", ""}, {"string", "附件", "50", "text", ""}, {"string", "学年", "2000", "text", ""}, {"date", "毕业时间", "0", "text", ""}, {"string", "是否青年志愿者", "2", "YesNo", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Sno", "SName", "SSex", "Sacademy", "TimeToSchool", "TimeToTuan", "Birthday", "ZhiBu", "Nation", "Major", "LenOfSchool", "Grade", "Polista", "NativePlace", "IDNum", "Phone", "Email", "Addfilelist", "YearToSchool", "GraduateTime", "VolunteerfFag"};
private String[] ListFields = {"Sno", "SName", "SSex", "Birthday", "ZhiBu", "Nation", "Major", "LenOfSchool", "Grade", "Polista", "NativePlace", "IDNum", "Phone", "Email", "Addfilelist", "YearToSchool", "GraduateTime", "VolunteerfFag"};
private String[] FormFields = {"Sno", "SName", "SSex", "Sacademy", "TimeToSchool", "TimeToTuan", "Birthday", "ZhiBu", "Nation", "Major", "LenOfSchool", "Grade", "Polista", "NativePlace", "IDNum", "Phone", "Email", "Addfilelist", "YearToSchool", "GraduateTime", "VolunteerfFag"};
private String[] QueryFields = {"Grade"};
private String[] HideFields = {"Id"};
private Students getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Students v = new Students();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSno(request, "Sno");
        v.paramSName(request, "SName");
        v.paramSSex(request, "SSex");
        v.paramSacademy(request, "Sacademy");
        v.paramTimeToSchool(request, "TimeToSchool");
        v.paramTimeToTuan(request, "TimeToTuan");
        v.paramBirthday(request, "Birthday");
        v.paramZhiBu(request, "ZhiBu");
        v.paramNation(request, "Nation");
        v.paramMajor(request, "Major");
        v.paramLenOfSchool(request, "LenOfSchool");
        v.paramGrade(request, "Grade");
        v.paramPolista(request, "Polista");
        v.paramNativePlace(request, "NativePlace");
        v.paramIDNum(request, "IDNum");
        v.paramPhone(request, "Phone");
        v.paramEmail(request, "Email");
        v.paramAddfilelist(request, "Addfilelist");
        v.paramYearToSchool(request, "YearToSchool");
        v.paramGraduateTime(request, "GraduateTime");
        v.paramVolunteerfFag(request, "VolunteerfFag");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setSName(ParamUtils.getParameter(request, "SName", ""));
        v.setSSex(ParamUtils.getParameter(request, "SSex", ""));
        v.setSacademy(ParamUtils.getParameter(request, "Sacademy", ""));
        v.setTimeToSchool(ParamUtils.getDateTimeParameter(request, "TimeToSchool", java.sql.Date.valueOf("0001-01-01")));
        v.setTimeToTuan(ParamUtils.getDateTimeParameter(request, "TimeToTuan", java.sql.Date.valueOf("0001-01-01")));
        v.setBirthday(ParamUtils.getDateTimeParameter(request, "Birthday", java.sql.Date.valueOf("0001-01-01")));
        v.setZhiBu(ParamUtils.getParameter(request, "ZhiBu", ""));
        v.setNation(ParamUtils.getParameter(request, "Nation", ""));
        v.setMajor(ParamUtils.getParameter(request, "Major", ""));
        v.setLenOfSchool(ParamUtils.getParameter(request, "LenOfSchool", ""));
        v.setGrade(ParamUtils.getParameter(request, "Grade", ""));
        v.setPolista(ParamUtils.getParameter(request, "Polista", ""));
        v.setNativePlace(ParamUtils.getParameter(request, "NativePlace", ""));
        v.setIDNum(ParamUtils.getParameter(request, "IDNum", ""));
        v.setPhone(ParamUtils.getParameter(request, "Phone", ""));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setAddfilelist(ParamUtils.getParameter(request, "Addfilelist", ""));
        v.setYearToSchool(ParamUtils.getParameter(request, "YearToSchool", ""));
        v.setGraduateTime(ParamUtils.getDateTimeParameter(request, "GraduateTime", java.sql.Date.valueOf("0001-01-01")));
        v.setVolunteerfFag(ParamUtils.getParameter(request, "VolunteerfFag", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Students pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    Map PoliticsNamemap = CEditConst.getPoliticsNameMap(userInfo);
    Map GradeNamemap = CEditConst.getGradeNameMap(userInfo);
    Map LenOfSchoolmap = CEditConst.getLenOfSchoolMap(userInfo);
    Map NationNamemap = CEditConst.getNationNameMap(userInfo);
    Map MajorNamemap = CEditConst.getMajorNameMap(userInfo);
    Map ClassesNamemap = CEditConst.getClassesNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Students v = (Students)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getSName()));
        row.add(Tool.jsSpecialChars(v.getSSex()));
        row.add(Tool.jsSpecialChars(v.getSacademy()));
        row.add(Tool.stringOfDate(v.getTimeToSchool()));
        row.add(Tool.stringOfDate(v.getTimeToTuan()));
        row.add(Tool.stringOfDate(v.getBirthday()));
        row.add((String)ClassesNamemap.get("" + v.getZhiBu()));
        row.add((String)NationNamemap.get("" + v.getNation()));
        row.add((String)MajorNamemap.get("" + v.getMajor()));
        row.add((String)LenOfSchoolmap.get("" + v.getLenOfSchool()));
        row.add((String)GradeNamemap.get("" + v.getGrade()));
        row.add((String)PoliticsNamemap.get("" + v.getPolista()));
        row.add(Tool.jsSpecialChars(v.getNativePlace()));
        row.add(Tool.jsSpecialChars(v.getIDNum()));
        row.add(Tool.jsSpecialChars(v.getPhone()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getAddfilelist()));
        row.add(Tool.jsSpecialChars(v.getYearToSchool()));
        row.add(Tool.stringOfDate(v.getGraduateTime()));
        row.add((String)YesNomap.get("" + v.getVolunteerfFag()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Students pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Students pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_Grade_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("grade like '%" + qval + "%'");
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
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, ""));
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
    Students pv = new Students();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Students");
    request.setAttribute("describe", "学生表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Students pv = new Students();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Students form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("PoliticsNameoptions", CEditConst.getPoliticsNameOptions(userInfo, ""));
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, ""));
    request.setAttribute("LenOfSchooloptions", CEditConst.getLenOfSchoolOptions(userInfo, ""));
    request.setAttribute("NationNameoptions", CEditConst.getNationNameOptions(userInfo, ""));
    request.setAttribute("MajorNameoptions", CEditConst.getMajorNameOptions(userInfo, ""));
    request.setAttribute("ClassesNameoptions", CEditConst.getClassesNameOptions(userInfo, ""));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Students");
    request.setAttribute("describe", "学生表");
}
private List mkRtn(String cmd, String forward, Students form)
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
    Students form = getByParameterDb(request);
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
log.debug("StudentsAction");
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
forwardMap.put("list", "StudentsAction.jsp");
forwardMap.put("failure", "StudentsForm.jsp");
forwardMap.put("success", "StudentsList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StudentsForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StudentsAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
