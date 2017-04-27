<%@ page language="java" %>
<%--社会实践项目报名表-学生素质拓展培养认证单-实践服务--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(PracticeDeclare.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Type", "DeclareId", "Academy", "XyHonour", "Submitflag", "XyCheckFlag", "TwCheckFlag", "Addaccount", "Addtime", "Declare1", "Declare2", "Declare5", "Declare8", "Declare6", "Declare7", "Declare9", "Declare10", "Declare11", "Declare12", "Declare13", "Declare14", "Declare15", "Declare16", "Declare17", "Declare18", "Declare19", "Declare20", "Declare21", "Declare22", "Declare23", "Declare24", "Declare25", "Declare26", "Declare27", "Declare28", "Declare29", "Declare30", "Declare31", "Declare32", "Declare33", "Declare34", "Declare35", "Declare36", "Declare37", "Declare38", "Declare39", "Declare40", "Declare41", "Declare42", "Declare43", "Declare44", "Declare45", "Declare46", "Declare47", "Declare48", "Declare49", "Declare50", "Declare51", "Declare52", "Declare53", "Declare54", "Declare55", "Declare56", "Declare57", "Declare58", "Declare59", "Declare60", "Declare61", "Declare62", "Declare63", "Declare64", "AddFileList", "Remark1", "Remark2", "Remark3"};
private String[] DicKeys = {"Id", "Type", "DeclareId", "Academy", "XyHonour", "Submitflag", "XyCheckFlag", "TwCheckFlag", "Addaccount", "Addtime", "Declare1", "Declare2", "Declare5", "Declare8", "Declare6", "Declare7", "Declare9", "Declare10", "Declare11", "Declare12", "Declare13", "Declare14", "Declare15", "Declare16", "Declare17", "Declare18", "Declare19", "Declare20", "Declare21", "Declare22", "Declare23", "Declare24", "Declare25", "Declare26", "Declare27", "Declare28", "Declare29", "Declare30", "Declare31", "Declare32", "Declare33", "Declare34", "Declare35", "Declare36", "Declare37", "Declare38", "Declare39", "Declare40", "Declare41", "Declare42", "Declare43", "Declare44", "Declare45", "Declare46", "Declare47", "Declare48", "Declare49", "Declare50", "Declare51", "Declare52", "Declare53", "Declare54", "Declare55", "Declare56", "Declare57", "Declare58", "Declare59", "Declare60", "Declare61", "Declare62", "Declare63", "Declare64", "AddFileList", "Remark1", "Remark2", "Remark3"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "类别", "0", "text", ""}, {"int", "立项表id", "0", "text", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "学院设置荣誉", "45", "text", ""}, {"int", "提交状态", "0", "text", ""}, {"int", "学院状态", "0", "hidden", ""}, {"int", "团委审核状态", "0", "hidden", ""}, {"string", "添加用户", "45", "text", ""}, {"string", "添加时间", "45", "hidden", ""}, {"string", "课题名称", "45", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "实践主题", "45", "text", ""}, {"string", "其他主题", "45", "text", ""}, {"string", "接受单位（个人）", "45", "text", ""}, {"string", "接收单位负责人或接收个人姓名", "45", "text", ""}, {"string", "手机", "45", "text", ""}, {"string", "接受单位个人简介", "255", "hidden", ""}, {"string", "活动计划主题", "255", "hidden", ""}, {"string", "活动计划背景及意义", "255", "hidden", ""}, {"string", "时间", "255", "text", ""}, {"string", "活动地点及路线", "255", "hidden", ""}, {"string", "项目预期成果", "255", "hidden", ""}, {"string", "宣讲会", "45", "hidden", ""}, {"string", "讲座", "45", "hidden", ""}, {"string", "专业培训", "45", "hidden", ""}, {"string", "调研报告", "45", "hidden", ""}, {"string", "支教受益人数", "45", "text", ""}, {"string", "文体演出", "45", "text", ""}, {"string", "捐赠（价值）", "45", "text", ""}, {"string", "咨询场次", "45", "text", ""}, {"string", "是否建立实践基地", "45", "text", ""}, {"string", "其它实践成果", "45", "hidden", ""}, {"string", "实践中团队是否拍摄DV", "45", "text", ""}, {"string", "前期准备工作", "255", "text", ""}, {"string", "新闻媒体联系报道", "255", "text", ""}, {"string", "实践期间完成的任务、详细活动计划及日程安排", "255", "text", ""}, {"string", "团队安全应急预案", "255", "text", ""}, {"string", "指导老师姓名", "45", "text", ""}, {"string", "是否随从队伍", "45", "text", ""}, {"string", "工作单位", "45", "text", ""}, {"string", "职务职称", "45", "text", ""}, {"string", "指导老师电话", "45", "text", ""}, {"string", "指导老师手机", "45", "text", ""}, {"string", "指导老师邮箱", "45", "text", ""}, {"string", "领队姓名", "45", "text", ""}, {"string", "领队工作单位", "45", "text", ""}, {"string", "领队职务名称", "45", "text", ""}, {"string", "领队电话", "45", "text", ""}, {"string", "领队手机", "45", "text", ""}, {"string", "领队邮箱", "45", "text", ""}, {"string", "领队2姓名", "45", "text", ""}, {"string", "领队2学院", "45", "text", ""}, {"string", "领队2专业", "45", "text", ""}, {"string", "领队2年级", "45", "text", ""}, {"string", "领队2学历", "45", "text", ""}, {"string", "领队2电话", "45", "text", ""}, {"string", "领队2手机", "45", "text", ""}, {"string", "领队2邮箱", "45", "text", ""}, {"string", "总人数", "45", "text", ""}, {"string", "专业老师", "45", "text", ""}, {"string", "政工干部", "45", "text", ""}, {"string", "本专科学生", "45", "text", ""}, {"string", "研究生", "45", "text", ""}, {"string", "交通费", "45", "text", ""}, {"string", "住宿费", "45", "text", ""}, {"string", "其他费用", "255", "text", ""}, {"string", "费用总计", "45", "text", ""}, {"string", "团队自筹费用", "45", "text", ""}, {"string", "申请学校立项经费", "45", "text", ""}, {"string", "学校配套经费", "45", "text", ""}, {"string", "接收单位（个人）支持经费", "45", "text", ""}, {"string", "附件", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Type", "DeclareId", "Academy", "XyHonour", "Submitflag", "XyCheckFlag", "TwCheckFlag", "Addaccount", "Addtime", "Declare1", "Declare2", "Declare5", "Declare8", "Declare6", "Declare7", "Declare9", "Declare10", "Declare11", "Declare12", "Declare13", "Declare14", "Declare15", "Declare16", "Declare17", "Declare18", "Declare19", "Declare20", "Declare21", "Declare22", "Declare23", "Declare24", "Declare25", "Declare26", "Declare27", "Declare28", "Declare29", "Declare30", "Declare31", "Declare32", "Declare33", "Declare34", "Declare35", "Declare36", "Declare37", "Declare38", "Declare39", "Declare40", "Declare41", "Declare42", "Declare43", "Declare44", "Declare45", "Declare46", "Declare47", "Declare48", "Declare49", "Declare50", "Declare51", "Declare52", "Declare53", "Declare54", "Declare55", "Declare56", "Declare57", "Declare58", "Declare59", "Declare60", "Declare61", "Declare62", "Declare63", "Declare64", "AddFileList", "Remark1", "Remark2", "Remark3"};
private String[] ListFields = {"Type", "DeclareId", "Academy", "XyHonour", "Submitflag", "Addaccount", "Declare1", "Declare2", "Declare5", "Declare8", "Declare6", "Declare7", "Declare9", "Declare13", "Declare20", "Declare21", "Declare22", "Declare23", "Declare24", "Declare26", "Declare27", "Declare28", "Declare29", "Declare30", "Declare31", "Declare32", "Declare33", "Declare34", "Declare35", "Declare36", "Declare37", "Declare38", "Declare39", "Declare40", "Declare41", "Declare42", "Declare43", "Declare44", "Declare45", "Declare46", "Declare47", "Declare48", "Declare49", "Declare50", "Declare51", "Declare52", "Declare53", "Declare54", "Declare55", "Declare56", "Declare57", "Declare58", "Declare59", "Declare60", "Declare61", "Declare62", "Declare63", "Declare64", "AddFileList", "Remark1", "Remark2", "Remark3"};
private String[] FormFields = {"Type", "DeclareId", "Academy", "XyHonour", "Submitflag", "XyCheckFlag", "TwCheckFlag", "Addaccount", "Addtime", "Declare1", "Declare2", "Declare5", "Declare8", "Declare6", "Declare7", "Declare9", "Declare10", "Declare11", "Declare12", "Declare13", "Declare14", "Declare15", "Declare16", "Declare17", "Declare18", "Declare19", "Declare20", "Declare21", "Declare22", "Declare23", "Declare24", "Declare25", "Declare26", "Declare27", "Declare28", "Declare29", "Declare30", "Declare31", "Declare32", "Declare33", "Declare34", "Declare35", "Declare36", "Declare37", "Declare38", "Declare39", "Declare40", "Declare41", "Declare42", "Declare43", "Declare44", "Declare45", "Declare46", "Declare47", "Declare48", "Declare49", "Declare50", "Declare51", "Declare52", "Declare53", "Declare54", "Declare55", "Declare56", "Declare57", "Declare58", "Declare59", "Declare60", "Declare61", "Declare62", "Declare63", "Declare64", "AddFileList", "Remark1", "Remark2", "Remark3"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private PracticeDeclare getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclare v = new PracticeDeclare();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramType(request, "Type");
        v.paramDeclareId(request, "DeclareId");
        v.paramAcademy(request, "Academy");
        v.paramXyHonour(request, "XyHonour");
        v.paramSubmitflag(request, "Submitflag");
        v.paramXyCheckFlag(request, "XyCheckFlag");
        v.paramTwCheckFlag(request, "TwCheckFlag");
        v.paramAddaccount(request, "Addaccount");
        v.paramAddtime(request, "Addtime");
        v.paramDeclare1(request, "Declare1");
        v.paramDeclare2(request, "Declare2");
        v.paramDeclare5(request, "Declare5");
        v.paramDeclare8(request, "Declare8");
        v.paramDeclare6(request, "Declare6");
        v.paramDeclare7(request, "Declare7");
        v.paramDeclare9(request, "Declare9");
        v.paramDeclare10(request, "Declare10");
        v.paramDeclare11(request, "Declare11");
        v.paramDeclare12(request, "Declare12");
        v.paramDeclare13(request, "Declare13");
        v.paramDeclare14(request, "Declare14");
        v.paramDeclare15(request, "Declare15");
        v.paramDeclare16(request, "Declare16");
        v.paramDeclare17(request, "Declare17");
        v.paramDeclare18(request, "Declare18");
        v.paramDeclare19(request, "Declare19");
        v.paramDeclare20(request, "Declare20");
        v.paramDeclare21(request, "Declare21");
        v.paramDeclare22(request, "Declare22");
        v.paramDeclare23(request, "Declare23");
        v.paramDeclare24(request, "Declare24");
        v.paramDeclare25(request, "Declare25");
        v.paramDeclare26(request, "Declare26");
        v.paramDeclare27(request, "Declare27");
        v.paramDeclare28(request, "Declare28");
        v.paramDeclare29(request, "Declare29");
        v.paramDeclare30(request, "Declare30");
        v.paramDeclare31(request, "Declare31");
        v.paramDeclare32(request, "Declare32");
        v.paramDeclare33(request, "Declare33");
        v.paramDeclare34(request, "Declare34");
        v.paramDeclare35(request, "Declare35");
        v.paramDeclare36(request, "Declare36");
        v.paramDeclare37(request, "Declare37");
        v.paramDeclare38(request, "Declare38");
        v.paramDeclare39(request, "Declare39");
        v.paramDeclare40(request, "Declare40");
        v.paramDeclare41(request, "Declare41");
        v.paramDeclare42(request, "Declare42");
        v.paramDeclare43(request, "Declare43");
        v.paramDeclare44(request, "Declare44");
        v.paramDeclare45(request, "Declare45");
        v.paramDeclare46(request, "Declare46");
        v.paramDeclare47(request, "Declare47");
        v.paramDeclare48(request, "Declare48");
        v.paramDeclare49(request, "Declare49");
        v.paramDeclare50(request, "Declare50");
        v.paramDeclare51(request, "Declare51");
        v.paramDeclare52(request, "Declare52");
        v.paramDeclare53(request, "Declare53");
        v.paramDeclare54(request, "Declare54");
        v.paramDeclare55(request, "Declare55");
        v.paramDeclare56(request, "Declare56");
        v.paramDeclare57(request, "Declare57");
        v.paramDeclare58(request, "Declare58");
        v.paramDeclare59(request, "Declare59");
        v.paramDeclare60(request, "Declare60");
        v.paramDeclare61(request, "Declare61");
        v.paramDeclare62(request, "Declare62");
        v.paramDeclare63(request, "Declare63");
        v.paramDeclare64(request, "Declare64");
        v.paramAddFileList(request, "AddFileList");
        v.paramRemark1(request, "Remark1");
        v.paramRemark2(request, "Remark2");
        v.paramRemark3(request, "Remark3");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setDeclareId(ParamUtils.getIntParameter(request, "DeclareId", -1));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setXyHonour(ParamUtils.getParameter(request, "XyHonour", ""));
        v.setSubmitflag(ParamUtils.getIntParameter(request, "Submitflag", -1));
        v.setXyCheckFlag(ParamUtils.getIntParameter(request, "XyCheckFlag", -1));
        v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
        v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
        v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
        v.setDeclare1(ParamUtils.getParameter(request, "Declare1", ""));
        v.setDeclare2(ParamUtils.getParameter(request, "Declare2", ""));
        v.setDeclare5(ParamUtils.getParameter(request, "Declare5", ""));
        v.setDeclare8(ParamUtils.getParameter(request, "Declare8", ""));
        v.setDeclare6(ParamUtils.getParameter(request, "Declare6", ""));
        v.setDeclare7(ParamUtils.getParameter(request, "Declare7", ""));
        v.setDeclare9(ParamUtils.getParameter(request, "Declare9", ""));
        v.setDeclare10(ParamUtils.getParameter(request, "Declare10", ""));
        v.setDeclare11(ParamUtils.getParameter(request, "Declare11", ""));
        v.setDeclare12(ParamUtils.getParameter(request, "Declare12", ""));
        v.setDeclare13(ParamUtils.getParameter(request, "Declare13", ""));
        v.setDeclare14(ParamUtils.getParameter(request, "Declare14", ""));
        v.setDeclare15(ParamUtils.getParameter(request, "Declare15", ""));
        v.setDeclare16(ParamUtils.getParameter(request, "Declare16", ""));
        v.setDeclare17(ParamUtils.getParameter(request, "Declare17", ""));
        v.setDeclare18(ParamUtils.getParameter(request, "Declare18", ""));
        v.setDeclare19(ParamUtils.getParameter(request, "Declare19", ""));
        v.setDeclare20(ParamUtils.getParameter(request, "Declare20", ""));
        v.setDeclare21(ParamUtils.getParameter(request, "Declare21", ""));
        v.setDeclare22(ParamUtils.getParameter(request, "Declare22", ""));
        v.setDeclare23(ParamUtils.getParameter(request, "Declare23", ""));
        v.setDeclare24(ParamUtils.getParameter(request, "Declare24", ""));
        v.setDeclare25(ParamUtils.getParameter(request, "Declare25", ""));
        v.setDeclare26(ParamUtils.getParameter(request, "Declare26", ""));
        v.setDeclare27(ParamUtils.getParameter(request, "Declare27", ""));
        v.setDeclare28(ParamUtils.getParameter(request, "Declare28", ""));
        v.setDeclare29(ParamUtils.getParameter(request, "Declare29", ""));
        v.setDeclare30(ParamUtils.getParameter(request, "Declare30", ""));
        v.setDeclare31(ParamUtils.getParameter(request, "Declare31", ""));
        v.setDeclare32(ParamUtils.getParameter(request, "Declare32", ""));
        v.setDeclare33(ParamUtils.getParameter(request, "Declare33", ""));
        v.setDeclare34(ParamUtils.getParameter(request, "Declare34", ""));
        v.setDeclare35(ParamUtils.getParameter(request, "Declare35", ""));
        v.setDeclare36(ParamUtils.getParameter(request, "Declare36", ""));
        v.setDeclare37(ParamUtils.getParameter(request, "Declare37", ""));
        v.setDeclare38(ParamUtils.getParameter(request, "Declare38", ""));
        v.setDeclare39(ParamUtils.getParameter(request, "Declare39", ""));
        v.setDeclare40(ParamUtils.getParameter(request, "Declare40", ""));
        v.setDeclare41(ParamUtils.getParameter(request, "Declare41", ""));
        v.setDeclare42(ParamUtils.getParameter(request, "Declare42", ""));
        v.setDeclare43(ParamUtils.getParameter(request, "Declare43", ""));
        v.setDeclare44(ParamUtils.getParameter(request, "Declare44", ""));
        v.setDeclare45(ParamUtils.getParameter(request, "Declare45", ""));
        v.setDeclare46(ParamUtils.getParameter(request, "Declare46", ""));
        v.setDeclare47(ParamUtils.getParameter(request, "Declare47", ""));
        v.setDeclare48(ParamUtils.getParameter(request, "Declare48", ""));
        v.setDeclare49(ParamUtils.getParameter(request, "Declare49", ""));
        v.setDeclare50(ParamUtils.getParameter(request, "Declare50", ""));
        v.setDeclare51(ParamUtils.getParameter(request, "Declare51", ""));
        v.setDeclare52(ParamUtils.getParameter(request, "Declare52", ""));
        v.setDeclare53(ParamUtils.getParameter(request, "Declare53", ""));
        v.setDeclare54(ParamUtils.getParameter(request, "Declare54", ""));
        v.setDeclare55(ParamUtils.getParameter(request, "Declare55", ""));
        v.setDeclare56(ParamUtils.getParameter(request, "Declare56", ""));
        v.setDeclare57(ParamUtils.getParameter(request, "Declare57", ""));
        v.setDeclare58(ParamUtils.getParameter(request, "Declare58", ""));
        v.setDeclare59(ParamUtils.getParameter(request, "Declare59", ""));
        v.setDeclare60(ParamUtils.getParameter(request, "Declare60", ""));
        v.setDeclare61(ParamUtils.getParameter(request, "Declare61", ""));
        v.setDeclare62(ParamUtils.getParameter(request, "Declare62", ""));
        v.setDeclare63(ParamUtils.getParameter(request, "Declare63", ""));
        v.setDeclare64(ParamUtils.getParameter(request, "Declare64", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setRemark1(ParamUtils.getParameter(request, "Remark1", ""));
        v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
        v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, PracticeDeclare pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        PracticeDeclare v = (PracticeDeclare)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getType());
        row.add("" + v.getDeclareId());
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getXyHonour()));
        row.add("" + v.getSubmitflag());
        row.add("" + v.getXyCheckFlag());
        row.add("" + v.getTwCheckFlag());
        row.add(Tool.jsSpecialChars(v.getAddaccount()));
        row.add(Tool.jsSpecialChars(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getDeclare1()));
        row.add(Tool.jsSpecialChars(v.getDeclare2()));
        row.add(Tool.jsSpecialChars(v.getDeclare5()));
        row.add(Tool.jsSpecialChars(v.getDeclare8()));
        row.add(Tool.jsSpecialChars(v.getDeclare6()));
        row.add(Tool.jsSpecialChars(v.getDeclare7()));
        row.add(Tool.jsSpecialChars(v.getDeclare9()));
        row.add(Tool.jsSpecialChars(v.getDeclare10()));
        row.add(Tool.jsSpecialChars(v.getDeclare11()));
        row.add(Tool.jsSpecialChars(v.getDeclare12()));
        row.add(Tool.jsSpecialChars(v.getDeclare13()));
        row.add(Tool.jsSpecialChars(v.getDeclare14()));
        row.add(Tool.jsSpecialChars(v.getDeclare15()));
        row.add(Tool.jsSpecialChars(v.getDeclare16()));
        row.add(Tool.jsSpecialChars(v.getDeclare17()));
        row.add(Tool.jsSpecialChars(v.getDeclare18()));
        row.add(Tool.jsSpecialChars(v.getDeclare19()));
        row.add(Tool.jsSpecialChars(v.getDeclare20()));
        row.add(Tool.jsSpecialChars(v.getDeclare21()));
        row.add(Tool.jsSpecialChars(v.getDeclare22()));
        row.add(Tool.jsSpecialChars(v.getDeclare23()));
        row.add(Tool.jsSpecialChars(v.getDeclare24()));
        row.add(Tool.jsSpecialChars(v.getDeclare25()));
        row.add(Tool.jsSpecialChars(v.getDeclare26()));
        row.add(Tool.jsSpecialChars(v.getDeclare27()));
        row.add(Tool.jsSpecialChars(v.getDeclare28()));
        row.add(Tool.jsSpecialChars(v.getDeclare29()));
        row.add(Tool.jsSpecialChars(v.getDeclare30()));
        row.add(Tool.jsSpecialChars(v.getDeclare31()));
        row.add(Tool.jsSpecialChars(v.getDeclare32()));
        row.add(Tool.jsSpecialChars(v.getDeclare33()));
        row.add(Tool.jsSpecialChars(v.getDeclare34()));
        row.add(Tool.jsSpecialChars(v.getDeclare35()));
        row.add(Tool.jsSpecialChars(v.getDeclare36()));
        row.add(Tool.jsSpecialChars(v.getDeclare37()));
        row.add(Tool.jsSpecialChars(v.getDeclare38()));
        row.add(Tool.jsSpecialChars(v.getDeclare39()));
        row.add(Tool.jsSpecialChars(v.getDeclare40()));
        row.add(Tool.jsSpecialChars(v.getDeclare41()));
        row.add(Tool.jsSpecialChars(v.getDeclare42()));
        row.add(Tool.jsSpecialChars(v.getDeclare43()));
        row.add(Tool.jsSpecialChars(v.getDeclare44()));
        row.add(Tool.jsSpecialChars(v.getDeclare45()));
        row.add(Tool.jsSpecialChars(v.getDeclare46()));
        row.add(Tool.jsSpecialChars(v.getDeclare47()));
        row.add(Tool.jsSpecialChars(v.getDeclare48()));
        row.add(Tool.jsSpecialChars(v.getDeclare49()));
        row.add(Tool.jsSpecialChars(v.getDeclare50()));
        row.add(Tool.jsSpecialChars(v.getDeclare51()));
        row.add(Tool.jsSpecialChars(v.getDeclare52()));
        row.add(Tool.jsSpecialChars(v.getDeclare53()));
        row.add(Tool.jsSpecialChars(v.getDeclare54()));
        row.add(Tool.jsSpecialChars(v.getDeclare55()));
        row.add(Tool.jsSpecialChars(v.getDeclare56()));
        row.add(Tool.jsSpecialChars(v.getDeclare57()));
        row.add(Tool.jsSpecialChars(v.getDeclare58()));
        row.add(Tool.jsSpecialChars(v.getDeclare59()));
        row.add(Tool.jsSpecialChars(v.getDeclare60()));
        row.add(Tool.jsSpecialChars(v.getDeclare61()));
        row.add(Tool.jsSpecialChars(v.getDeclare62()));
        row.add(Tool.jsSpecialChars(v.getDeclare63()));
        row.add(Tool.jsSpecialChars(v.getDeclare64()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.jsSpecialChars(v.getRemark1()));
        row.add(Tool.jsSpecialChars(v.getRemark2()));
        row.add(Tool.jsSpecialChars(v.getRemark3()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, PracticeDeclare pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, PracticeDeclare pv, boolean isAll)
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
    PracticeDeclare pv = new PracticeDeclare();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "PracticeDeclare");
    request.setAttribute("describe", "社会实践项目报名表-学生素质拓展培养认证单-实践服务");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclare pv = new PracticeDeclare();
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
private void setForm(javax.servlet.http.HttpServletRequest request, PracticeDeclare form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "PracticeDeclare");
    request.setAttribute("describe", "社会实践项目报名表-学生素质拓展培养认证单-实践服务");
}
private List mkRtn(String cmd, String forward, PracticeDeclare form)
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
    PracticeDeclare form = getByParameterDb(request);
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
log.debug("PracticeDeclareAction");
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
forwardMap.put("list", "PracticeDeclareAction.jsp");
forwardMap.put("failure", "PracticeDeclareForm.jsp");
forwardMap.put("success", "PracticeDeclareList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PracticeDeclareForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PracticeDeclareAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
