<%@ page language="java" %>
<%--志愿竞赛报名表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(VolunteerProjectParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ProjectId", "Sno", "Honour", "SubmitFlag", "CheckFlag", "XycheckFalg", "CheckComments", "AddAccount", "Addtime", "CheckAccount", "CheckTime", "Academy", "ProjectName", "TeamName", "TeamUnit", "RegisterId", "SetupTime", "ZipCode", "ContactAddress", "InspectionConclution", "AssLevel", "DutyFree", "StartTime", "ProjectArea", "ImpleArea", "ParticipateNum", "FulltimeNum", "Award", "Content", "Meanings", "DisiredResults", "ImplePlace", "Promotion", "Specialist", "BeneFicaiaries", "Benenum", "MajorName", "MajorSex", "MajorBirth", "MajorDuty", "MajorPolista", "MajorPhone", "MajorPhone2", "MajorEmail", "GuideTeacherName", "GuideTeacherSex", "GuideTeacherBirth", "GuideTeacherDuty", "GuideTeacherPolista", "GuideTeacherPhone", "GuideTeacherPhone2", "GuiderTeacherEmail", "AddFileList"};
private String[] DicKeys = {"Id", "ProjectId", "Sno", "Honour", "SubmitFlag", "CheckFlag", "XycheckFalg", "CheckComments", "AddAccount", "Addtime", "CheckAccount", "CheckTime", "Academy", "ProjectName", "TeamName", "TeamUnit", "RegisterId", "SetupTime", "ZipCode", "ContactAddress", "InspectionConclution", "AssLevel", "DutyFree", "StartTime", "ProjectArea", "ImpleArea", "ParticipateNum", "FulltimeNum", "Award", "Content", "Meanings", "DisiredResults", "ImplePlace", "Promotion", "Specialist", "BeneFicaiaries", "Benenum", "MajorName", "MajorSex", "MajorBirth", "MajorDuty", "MajorPolista", "MajorPhone", "MajorPhone2", "MajorEmail", "GuideTeacherName", "GuideTeacherSex", "GuideTeacherBirth", "GuideTeacherDuty", "GuideTeacherPolista", "GuideTeacherPhone", "GuideTeacherPhone2", "GuiderTeacherEmail", "AddFileList"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"int", "志愿竞赛项目id", "0", "VolunProjectName", ""}, {"string", "学生学号", "20", "text", ""}, {"string", "荣誉名称", "45", "text", ""}, {"int", "提交标志", "0", "hidden", ""}, {"int", "团委审核标志", "0", "hidden", ""}, {"int", "学院审核标志", "0", "hidden", ""}, {"string", "审批意见", "255", "hidden", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "审核账号", "45", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "所属学院", "45", "AcademyName", ""}, {"string", "项目名称", "45", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "团队主管单位", "45", "text", ""}, {"string", "登记时间", "45", "hidden", ""}, {"date", "成立时间", "0", "hidden", ""}, {"string", "邮政编码", "45", "text", ""}, {"string", "通讯地址", "100", "text", ""}, {"string", "年度年检结论", "255", "hidden", ""}, {"string", "评估等级", "45", "AssLevel", ""}, {"string", "有无免税资格", "2", "hidden", ""}, {"date", "项目实施时间", "0", "hidden", ""}, {"string", "项目领域", "45", "hidden", ""}, {"string", "实施领域", "45", "hidden", ""}, {"int", "参与项目运作人数", "0", "hidden", ""}, {"int", "专职人员人数", "0", "hidden", ""}, {"string", "曾获何等奖励", "255", "hidden", ""}, {"string", "项目内容", "255", "hidden", ""}, {"string", "项目背景意义", "255", "hidden", ""}, {"string", "项目预计效果", "255", "hidden", ""}, {"string", "项目实施地点", "255", "hidden", ""}, {"string", "项目实施地点", "255", "hidden", ""}, {"string", "项目特色", "255", "hidden", ""}, {"string", "受益对象", "255", "hidden", ""}, {"int", "预计直接受益人数", "0", "hidden", ""}, {"string", "项目负责人姓名", "45", "hidden", ""}, {"string", "项目负责人性别", "45", "hidden", ""}, {"string", "项目负责人出生年月", "45", "hidden", ""}, {"string", "项目负责人工作单位及职务", "45", "hidden", ""}, {"string", "项目负责人政治面貌", "45", "hidden", ""}, {"string", "项目负责人办公电话", "45", "hidden", ""}, {"string", "项目负责人手机", "45", "hidden", ""}, {"string", "项目负责人邮箱", "45", "hidden", ""}, {"string", "项目指导教师姓名", "45", "UserName", ""}, {"string", "项目指导教师性别", "45", "hidden", ""}, {"string", "项目指导教师出生年月", "45", "hidden", ""}, {"string", "项目指导教师工作单位及职务", "45", "hidden", ""}, {"string", "项目指导教师政治面貌", "45", "hidden", ""}, {"string", "项目指导教师办公电话", "45", "hidden", ""}, {"string", "项目指导教师手机", "45", "hidden", ""}, {"string", "项目指导教师邮箱", "45", "hidden", ""}, {"string", "上传文件列表", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ProjectId", "Sno", "Honour", "SubmitFlag", "CheckFlag", "XycheckFalg", "CheckComments", "AddAccount", "Addtime", "CheckAccount", "CheckTime", "Academy", "ProjectName", "TeamName", "TeamUnit", "RegisterId", "SetupTime", "ZipCode", "ContactAddress", "InspectionConclution", "AssLevel", "DutyFree", "StartTime", "ProjectArea", "ImpleArea", "ParticipateNum", "FulltimeNum", "Award", "Content", "Meanings", "DisiredResults", "ImplePlace", "Promotion", "Specialist", "BeneFicaiaries", "Benenum", "MajorName", "MajorSex", "MajorBirth", "MajorDuty", "MajorPolista", "MajorPhone", "MajorPhone2", "MajorEmail", "GuideTeacherName", "GuideTeacherSex", "GuideTeacherBirth", "GuideTeacherDuty", "GuideTeacherPolista", "GuideTeacherPhone", "GuideTeacherPhone2", "GuiderTeacherEmail", "AddFileList"};
private String[] ListFields = {"ProjectId", "Sno", "Honour", "Academy", "ProjectName", "TeamName", "TeamUnit", "ZipCode", "ContactAddress", "AssLevel", "GuideTeacherName"};
private String[] FormFields = {"ProjectId", "Sno", "Honour", "SubmitFlag", "CheckComments", "Academy", "ProjectName", "TeamName", "TeamUnit", "RegisterId", "SetupTime", "ZipCode", "ContactAddress", "InspectionConclution", "AssLevel", "DutyFree", "StartTime", "ProjectArea", "ImpleArea", "ParticipateNum", "FulltimeNum", "Award", "Content", "Meanings", "DisiredResults", "ImplePlace", "Promotion", "Specialist", "BeneFicaiaries", "Benenum", "MajorName", "MajorSex", "MajorBirth", "MajorDuty", "MajorPolista", "MajorPhone", "MajorPhone2", "MajorEmail", "GuideTeacherName", "GuideTeacherSex", "GuideTeacherBirth", "GuideTeacherDuty", "GuideTeacherPolista", "GuideTeacherPhone", "GuideTeacherPhone2", "GuiderTeacherEmail"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private VolunteerProjectParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerProjectParticipate v = new VolunteerProjectParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramProjectId(request, "ProjectId");
        v.paramSno(request, "Sno");
        v.paramHonour(request, "Honour");
        v.paramSubmitFlag(request, "SubmitFlag");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramXycheckFalg(request, "XycheckFalg");
        v.paramCheckComments(request, "CheckComments");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddtime(request, "Addtime");
        v.paramCheckAccount(request, "CheckAccount");
        v.paramCheckTime(request, "CheckTime");
        v.paramAcademy(request, "Academy");
        v.paramProjectName(request, "ProjectName");
        v.paramTeamName(request, "TeamName");
        v.paramTeamUnit(request, "TeamUnit");
        v.paramRegisterId(request, "RegisterId");
        v.paramSetupTime(request, "SetupTime");
        v.paramZipCode(request, "ZipCode");
        v.paramContactAddress(request, "ContactAddress");
        v.paramInspectionConclution(request, "InspectionConclution");
        v.paramAssLevel(request, "AssLevel");
        v.paramDutyFree(request, "DutyFree");
        v.paramStartTime(request, "StartTime");
        v.paramProjectArea(request, "ProjectArea");
        v.paramImpleArea(request, "ImpleArea");
        v.paramParticipateNum(request, "ParticipateNum");
        v.paramFulltimeNum(request, "FulltimeNum");
        v.paramAward(request, "Award");
        v.paramContent(request, "Content");
        v.paramMeanings(request, "Meanings");
        v.paramDisiredResults(request, "DisiredResults");
        v.paramImplePlace(request, "ImplePlace");
        v.paramPromotion(request, "Promotion");
        v.paramSpecialist(request, "Specialist");
        v.paramBeneFicaiaries(request, "BeneFicaiaries");
        v.paramBenenum(request, "Benenum");
        v.paramMajorName(request, "MajorName");
        v.paramMajorSex(request, "MajorSex");
        v.paramMajorBirth(request, "MajorBirth");
        v.paramMajorDuty(request, "MajorDuty");
        v.paramMajorPolista(request, "MajorPolista");
        v.paramMajorPhone(request, "MajorPhone");
        v.paramMajorPhone2(request, "MajorPhone2");
        v.paramMajorEmail(request, "MajorEmail");
        v.paramGuideTeacherName(request, "GuideTeacherName");
        v.paramGuideTeacherSex(request, "GuideTeacherSex");
        v.paramGuideTeacherBirth(request, "GuideTeacherBirth");
        v.paramGuideTeacherDuty(request, "GuideTeacherDuty");
        v.paramGuideTeacherPolista(request, "GuideTeacherPolista");
        v.paramGuideTeacherPhone(request, "GuideTeacherPhone");
        v.paramGuideTeacherPhone2(request, "GuideTeacherPhone2");
        v.paramGuiderTeacherEmail(request, "GuiderTeacherEmail");
        v.paramAddFileList(request, "AddFileList");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setProjectId(ParamUtils.getIntParameter(request, "ProjectId", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setHonour(ParamUtils.getParameter(request, "Honour", ""));
        v.setSubmitFlag(ParamUtils.getIntParameter(request, "SubmitFlag", -1));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setXycheckFalg(ParamUtils.getIntParameter(request, "XycheckFalg", -1));
        v.setCheckComments(ParamUtils.getParameter(request, "CheckComments", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckAccount(ParamUtils.getParameter(request, "CheckAccount", ""));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
        v.setTeamName(ParamUtils.getParameter(request, "TeamName", ""));
        v.setTeamUnit(ParamUtils.getParameter(request, "TeamUnit", ""));
        v.setRegisterId(ParamUtils.getParameter(request, "RegisterId", ""));
        v.setSetupTime(ParamUtils.getDateTimeParameter(request, "SetupTime", java.sql.Date.valueOf("0001-01-01")));
        v.setZipCode(ParamUtils.getParameter(request, "ZipCode", ""));
        v.setContactAddress(ParamUtils.getParameter(request, "ContactAddress", ""));
        v.setInspectionConclution(ParamUtils.getParameter(request, "InspectionConclution", ""));
        v.setAssLevel(ParamUtils.getParameter(request, "AssLevel", ""));
        v.setDutyFree(ParamUtils.getParameter(request, "DutyFree", ""));
        v.setStartTime(ParamUtils.getDateTimeParameter(request, "StartTime", java.sql.Date.valueOf("0001-01-01")));
        v.setProjectArea(ParamUtils.getParameter(request, "ProjectArea", ""));
        v.setImpleArea(ParamUtils.getParameter(request, "ImpleArea", ""));
        v.setParticipateNum(ParamUtils.getIntParameter(request, "ParticipateNum", -1));
        v.setFulltimeNum(ParamUtils.getIntParameter(request, "FulltimeNum", -1));
        v.setAward(ParamUtils.getParameter(request, "Award", ""));
        v.setContent(ParamUtils.getParameter(request, "Content", ""));
        v.setMeanings(ParamUtils.getParameter(request, "Meanings", ""));
        v.setDisiredResults(ParamUtils.getParameter(request, "DisiredResults", ""));
        v.setImplePlace(ParamUtils.getParameter(request, "ImplePlace", ""));
        v.setPromotion(ParamUtils.getParameter(request, "Promotion", ""));
        v.setSpecialist(ParamUtils.getParameter(request, "Specialist", ""));
        v.setBeneFicaiaries(ParamUtils.getParameter(request, "BeneFicaiaries", ""));
        v.setBenenum(ParamUtils.getIntParameter(request, "Benenum", -1));
        v.setMajorName(ParamUtils.getParameter(request, "MajorName", ""));
        v.setMajorSex(ParamUtils.getParameter(request, "MajorSex", ""));
        v.setMajorBirth(ParamUtils.getParameter(request, "MajorBirth", ""));
        v.setMajorDuty(ParamUtils.getParameter(request, "MajorDuty", ""));
        v.setMajorPolista(ParamUtils.getParameter(request, "MajorPolista", ""));
        v.setMajorPhone(ParamUtils.getParameter(request, "MajorPhone", ""));
        v.setMajorPhone2(ParamUtils.getParameter(request, "MajorPhone2", ""));
        v.setMajorEmail(ParamUtils.getParameter(request, "MajorEmail", ""));
        v.setGuideTeacherName(ParamUtils.getParameter(request, "GuideTeacherName", ""));
        v.setGuideTeacherSex(ParamUtils.getParameter(request, "GuideTeacherSex", ""));
        v.setGuideTeacherBirth(ParamUtils.getParameter(request, "GuideTeacherBirth", ""));
        v.setGuideTeacherDuty(ParamUtils.getParameter(request, "GuideTeacherDuty", ""));
        v.setGuideTeacherPolista(ParamUtils.getParameter(request, "GuideTeacherPolista", ""));
        v.setGuideTeacherPhone(ParamUtils.getParameter(request, "GuideTeacherPhone", ""));
        v.setGuideTeacherPhone2(ParamUtils.getParameter(request, "GuideTeacherPhone2", ""));
        v.setGuiderTeacherEmail(ParamUtils.getParameter(request, "GuiderTeacherEmail", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, VolunteerProjectParticipate pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map VolunProjectNamemap = CEditConst.getVolunProjectNameMap(userInfo);
    Map AssLevelmap = CEditConst.getAssLevelMap(userInfo);
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        VolunteerProjectParticipate v = (VolunteerProjectParticipate)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)VolunProjectNamemap.get("" + v.getProjectId()));
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getHonour()));
        row.add("" + v.getSubmitFlag());
        row.add("" + v.getCheckFlag());
        row.add("" + v.getXycheckFalg());
        row.add(Tool.jsSpecialChars(v.getCheckComments()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getCheckAccount()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getProjectName()));
        row.add(Tool.jsSpecialChars(v.getTeamName()));
        row.add(Tool.jsSpecialChars(v.getTeamUnit()));
        row.add(Tool.jsSpecialChars(v.getRegisterId()));
        row.add(Tool.stringOfDate(v.getSetupTime()));
        row.add(Tool.jsSpecialChars(v.getZipCode()));
        row.add(Tool.jsSpecialChars(v.getContactAddress()));
        row.add(Tool.jsSpecialChars(v.getInspectionConclution()));
        row.add((String)AssLevelmap.get("" + v.getAssLevel()));
        row.add(Tool.jsSpecialChars(v.getDutyFree()));
        row.add(Tool.stringOfDate(v.getStartTime()));
        row.add(Tool.jsSpecialChars(v.getProjectArea()));
        row.add(Tool.jsSpecialChars(v.getImpleArea()));
        row.add("" + v.getParticipateNum());
        row.add("" + v.getFulltimeNum());
        row.add(Tool.jsSpecialChars(v.getAward()));
        row.add(Tool.jsSpecialChars(v.getContent()));
        row.add(Tool.jsSpecialChars(v.getMeanings()));
        row.add(Tool.jsSpecialChars(v.getDisiredResults()));
        row.add(Tool.jsSpecialChars(v.getImplePlace()));
        row.add(Tool.jsSpecialChars(v.getPromotion()));
        row.add(Tool.jsSpecialChars(v.getSpecialist()));
        row.add(Tool.jsSpecialChars(v.getBeneFicaiaries()));
        row.add("" + v.getBenenum());
        row.add(Tool.jsSpecialChars(v.getMajorName()));
        row.add(Tool.jsSpecialChars(v.getMajorSex()));
        row.add(Tool.jsSpecialChars(v.getMajorBirth()));
        row.add(Tool.jsSpecialChars(v.getMajorDuty()));
        row.add(Tool.jsSpecialChars(v.getMajorPolista()));
        row.add(Tool.jsSpecialChars(v.getMajorPhone()));
        row.add(Tool.jsSpecialChars(v.getMajorPhone2()));
        row.add(Tool.jsSpecialChars(v.getMajorEmail()));
        row.add((String)UserNamemap.get("" + v.getGuideTeacherName()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherSex()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherBirth()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherDuty()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherPolista()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherPhone()));
        row.add(Tool.jsSpecialChars(v.getGuideTeacherPhone2()));
        row.add(Tool.jsSpecialChars(v.getGuiderTeacherEmail()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, VolunteerProjectParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, VolunteerProjectParticipate pv, boolean isAll)
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
    VolunteerProjectParticipate pv = new VolunteerProjectParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "VolunteerProjectParticipate");
    request.setAttribute("describe", "志愿竞赛报名表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerProjectParticipate pv = new VolunteerProjectParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, VolunteerProjectParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("VolunProjectNameoptions", CEditConst.getVolunProjectNameOptions(userInfo, "-1"));
    request.setAttribute("AssLeveloptions", CEditConst.getAssLevelOptions(userInfo, ""));
    request.setAttribute("PoliticsNameoptions", CEditConst.getPoliticsNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "VolunteerProjectParticipate");
    request.setAttribute("describe", "志愿竞赛报名表");
}
private List mkRtn(String cmd, String forward, VolunteerProjectParticipate form)
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
    VolunteerProjectParticipate form = getByParameterDb(request);
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
log.debug("VolunteerProjectParticipateAction");
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
forwardMap.put("list", "VolunteerProjectParticipateAction.jsp");
forwardMap.put("failure", "VolunteerProjectParticipateForm.jsp");
forwardMap.put("success", "VolunteerProjectParticipateList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "VolunteerProjectParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='VolunteerProjectParticipateAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
