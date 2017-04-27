<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--五四评比表彰申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="com.xietong.software.sdtw.db.Academy"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(YouthHonour.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Noticeid", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Attachids", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val21", "Val18", "Val19", "Val20", "Val22", "Text1", "Text2", "Text3", "Text4", "Text5", "Text6"};
private String[] DicKeys = {"Id", "Noticeid", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Attachids", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val21", "Val18", "Val19", "Val20", "Val22", "Text1", "Text2", "Text3", "Text4", "Text5", "Text6"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "通知id", "0", "hidden", ""}, {"string", "学年", "45", "text", ""}, {"int", "Id", "0", "hidden", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "学院审核状态", "0", "text", ""}, {"int", "团委审核状态", "0", "text", ""}, {"int", "提交状态", "0", "text", ""}, {"int", "学院提交标志", "0", "text", ""}, {"int", "团委发布标志", "0", "text", ""}, {"date", "学院审核时间", "0", "hidden", ""}, {"date", "团委审核时间", "0", "hidden", ""}, {"string", "所属单位", "45", "text", ""}, {"string", "附件", "45", "text", ""}, {"string", "姓名/负责人/名称", "45", "hidden", ""}, {"string", "va2", "45", "hidden", ""}, {"string", "va3", "45", "hidden", ""}, {"string", "va4", "45", "hidden", ""}, {"string", "va5", "45", "hidden", ""}, {"string", "va6", "45", "hidden", ""}, {"string", "va7", "45", "hidden", ""}, {"string", "va8", "45", "hidden", ""}, {"string", "va9", "45", "hidden", ""}, {"string", "va10", "45", "hidden", ""}, {"string", "va11", "45", "hidden", ""}, {"string", "va12", "45", "hidden", ""}, {"string", "va13", "45", "hidden", ""}, {"string", "va14", "45", "hidden", ""}, {"string", "va15", "45", "hidden", ""}, {"string", "va16", "45", "hidden", ""}, {"string", "va17", "45", "hidden", ""}, {"string", "va21", "45", "hidden", ""}, {"string", "va18", "45", "hidden", ""}, {"string", "va19", "45", "hidden", ""}, {"string", "va20", "45", "hidden", ""}, {"string", "va22", "45", "hidden", ""}, {"string", "text1", "500", "hidden", ""}, {"string", "text2", "500", "hidden", ""}, {"string", "text3", "500", "hidden", ""}, {"string", "text4", "500", "hidden", ""}, {"string", "text5", "500", "hidden", ""}, {"string", "text6", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Noticeid", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Attachids", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val21", "Val18", "Val19", "Val20", "Val22", "Text1", "Text2", "Text3", "Text4", "Text5", "Text6"};

// private String[] ListFields = {"SchoolYear", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "BelongAcademy", "Attachids"};
private String[] ListFields = {"BelongAcademy", "Val1", "Addaccount", "Addtime","ModifyFlag","AyCheckFlag", "TwCheckFlag"};

private String[] FormFields = {"SchoolYear", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "BelongAcademy", "Attachids", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val21", "Val18", "Val19", "Val20", "Val22", "Text1", "Text2", "Text3", "Text4", "Text5", "Text6"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private YouthHonour getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthHonour v = new YouthHonour();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    
    //noticeid,type
	int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);
    int type=ParamUtils.getIntParameter(request,"type", -1);
	//date
	Date currentDate=new Date();
	//schoolyear
	String currentSchoolyear=CurrentSemester.getSchoolYear(currentDate);
    
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramNoticeid(request, "Noticeid");
        v.paramSchoolYear(request, "SchoolYear");
        v.paramType(request, "Type");
        v.paramAddaccount(request, "Addaccount");
        v.paramAddtime(request, "Addtime");
        v.paramAyCheckFlag(request, "AyCheckFlag");
        v.paramTwCheckFlag(request, "TwCheckFlag");
        v.paramModifyFlag(request, "ModifyFlag");
        v.paramXyReport(request, "XyReport");
        v.paramTwReport(request, "TwReport");
        v.paramXyCheckDate(request, "XyCheckDate");
        v.paramTwCheckDate(request, "TwCheckDate");
        v.paramBelongAcademy(request, "BelongAcademy");
        v.paramAttachids(request, "Attachids");
        v.paramVal1(request, "Val1");
        v.paramVal2(request, "Val2");
        v.paramVal3(request, "Val3");
        v.paramVal4(request, "Val4");
        v.paramVal5(request, "Val5");
        v.paramVal6(request, "Val6");
        v.paramVal7(request, "Val7");
        v.paramVal8(request, "Val8");
        v.paramVal9(request, "Val9");
        v.paramVal10(request, "Val10");
        v.paramVal11(request, "Val11");
        v.paramVal12(request, "Val12");
        v.paramVal13(request, "Val13");
        v.paramVal14(request, "Val14");
        v.paramVal15(request, "Val15");
        v.paramVal16(request, "Val16");
        v.paramVal17(request, "Val17");
        v.paramVal21(request, "Val21");
        v.paramVal18(request, "Val18");
        v.paramVal19(request, "Val19");
        v.paramVal20(request, "Val20");
        v.paramVal22(request, "Val22");
        v.paramText1(request, "Text1");
        v.paramText2(request, "Text2");
        v.paramText3(request, "Text3");
        v.paramText4(request, "Text4");
        v.paramText5(request, "Text5");
        v.paramText6(request, "Text6");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        
//         v.setNoticeid(ParamUtils.getIntParameter(request, "Noticeid", -1));
//         v.setType(ParamUtils.getIntParameter(request, "Type", -1));
//         v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
//         v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
//         v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
        v.setNoticeid(noticeid);
        v.setType(type);
        v.setAddaccount(userInfo.getId()+"");
        v.setAddtime(currentDate);
        v.setSchoolYear(currentSchoolyear);
        
        v.setAyCheckFlag(ParamUtils.getIntParameter(request, "AyCheckFlag", -1));
       	v.setXyCheckDate(ParamUtils.getDateTimeParameter(request, "XyCheckDate", java.sql.Date.valueOf("0001-01-01")));
       	v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
       	v.setTwCheckDate(ParamUtils.getDateTimeParameter(request, "TwCheckDate", java.sql.Date.valueOf("0001-01-01")));
       	v.setModifyFlag(ParamUtils.getIntParameter(request, "ModifyFlag", -1));
        	
        //学院添加默认通过
        if(userInfo.hasFunPower(Power.UserAdminPower)){
       		v.setAyCheckFlag(SdtwConst.XYCHECK_TG);
        	v.setXyCheckDate(currentDate);
        	v.setModifyFlag(SdtwConst.MODIFY_YTJ);
        }
        
        //团委添加的,学院、团委全默认通过,由于学院没有上报，团委是无法看见的
		if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
			v.setAyCheckFlag(SdtwConst.XYCHECK_TG);
			v.setXyCheckDate(currentDate);
	        v.setTwCheckFlag(SdtwConst.TWCHECK_TG);
        	v.setTwCheckDate(currentDate);
        	v.setModifyFlag(SdtwConst.MODIFY_YTJ);
        	v.setXyReport(SdtwConst.XYREPORT_YSB);//添加已上报
		}
        
//         v.setBelongAcademy(ParamUtils.getParameter(request, "BelongAcademy", ""));
        if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
	        v.setBelongAcademy(ParamUtils.getParameter(request, "BelongAcademy", ""));
        }else{
	        v.setBelongAcademy(userInfo.getDeptId()+"");
        }
        
        v.setAttachids(ParamUtils.getParameter(request, "Attachids", ""));
        v.setVal1(ParamUtils.getParameter(request, "Val1", ""));
        v.setVal2(ParamUtils.getParameter(request, "Val2", ""));
        v.setVal3(ParamUtils.getParameter(request, "Val3", ""));
        v.setVal4(ParamUtils.getParameter(request, "Val4", ""));
        v.setVal5(ParamUtils.getParameter(request, "Val5", ""));
        v.setVal6(ParamUtils.getParameter(request, "Val6", ""));
        v.setVal7(ParamUtils.getParameter(request, "Val7", ""));
        v.setVal8(ParamUtils.getParameter(request, "Val8", ""));
        v.setVal9(ParamUtils.getParameter(request, "Val9", ""));
        v.setVal10(ParamUtils.getParameter(request, "Val10", ""));
        v.setVal11(ParamUtils.getParameter(request, "Val11", ""));
        v.setVal12(ParamUtils.getParameter(request, "Val12", ""));
        v.setVal13(ParamUtils.getParameter(request, "Val13", ""));
        v.setVal14(ParamUtils.getParameter(request, "Val14", ""));
        v.setVal15(ParamUtils.getParameter(request, "Val15", ""));
        v.setVal16(ParamUtils.getParameter(request, "Val16", ""));
        v.setVal17(ParamUtils.getParameter(request, "Val17", ""));
        v.setVal21(ParamUtils.getParameter(request, "Val21", ""));
        v.setVal18(ParamUtils.getParameter(request, "Val18", ""));
        v.setVal19(ParamUtils.getParameter(request, "Val19", ""));
        v.setVal20(ParamUtils.getParameter(request, "Val20", ""));
        v.setVal22(ParamUtils.getParameter(request, "Val22", ""));
        v.setText1(ParamUtils.getParameter(request, "Text1", ""));
        v.setText2(ParamUtils.getParameter(request, "Text2", ""));
        v.setText3(ParamUtils.getParameter(request, "Text3", ""));
        v.setText4(ParamUtils.getParameter(request, "Text4", ""));
        v.setText5(ParamUtils.getParameter(request, "Text5", ""));
        v.setText6(ParamUtils.getParameter(request, "Text6", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, YouthHonour pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    YouthhonourUtil yhUtil=new YouthhonourUtil();
    Map xyCheckFlag=yhUtil.getXyCheckMap();
    Map twCheckFlag=yhUtil.getTwCheckMap();
    Map modifyFlag=yhUtil.getStuModifyMap();
    
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        YouthHonour v = (YouthHonour)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getNoticeid());
        row.add(Tool.jsSpecialChars(v.getSchoolYear()));
        row.add("" + v.getType());
        
//         row.add(Tool.jsSpecialChars(v.getAddaccount()));
        row.add(CEditConst.getUserNameMap(userInfo).get(v.getAddaccount()));
        
        row.add(Tool.stringOfDate(v.getAddtime()));
        
//         row.add("" + v.getAyCheckFlag());
//         row.add("" + v.getTwCheckFlag());
        row.add(xyCheckFlag.get(v.getAyCheckFlag()));
        row.add(twCheckFlag.get(v.getTwCheckFlag()));
        
//         row.add("" + v.getModifyFlag());
        row.add("" + modifyFlag.get(v.getModifyFlag()));
        
        row.add("" + v.getXyReport());
        row.add("" + v.getTwReport());
        row.add(Tool.stringOfDate(v.getXyCheckDate()));
        row.add(Tool.stringOfDate(v.getTwCheckDate()));
        
//      row.add(Tool.jsSpecialChars(v.getBelongAcademy()));
		Map academynamemap=CEditConst.getAcademyNameMap(userInfo);
		String myacademyname=(String)academynamemap.get(v.getBelongAcademy());
        row.add(Tool.jsSpecialChars(myacademyname));
        
        row.add(Tool.jsSpecialChars(v.getAttachids()));
        row.add(Tool.jsSpecialChars(v.getVal1()));
        row.add(Tool.jsSpecialChars(v.getVal2()));
        row.add(Tool.jsSpecialChars(v.getVal3()));
        row.add(Tool.jsSpecialChars(v.getVal4()));
        row.add(Tool.jsSpecialChars(v.getVal5()));
        row.add(Tool.jsSpecialChars(v.getVal6()));
        row.add(Tool.jsSpecialChars(v.getVal7()));
        row.add(Tool.jsSpecialChars(v.getVal8()));
        row.add(Tool.jsSpecialChars(v.getVal9()));
        row.add(Tool.jsSpecialChars(v.getVal10()));
        row.add(Tool.jsSpecialChars(v.getVal11()));
        row.add(Tool.jsSpecialChars(v.getVal12()));
        row.add(Tool.jsSpecialChars(v.getVal13()));
        row.add(Tool.jsSpecialChars(v.getVal14()));
        row.add(Tool.jsSpecialChars(v.getVal15()));
        row.add(Tool.jsSpecialChars(v.getVal16()));
        row.add(Tool.jsSpecialChars(v.getVal17()));
        row.add(Tool.jsSpecialChars(v.getVal21()));
        row.add(Tool.jsSpecialChars(v.getVal18()));
        row.add(Tool.jsSpecialChars(v.getVal19()));
        row.add(Tool.jsSpecialChars(v.getVal20()));
        row.add(Tool.jsSpecialChars(v.getVal22()));
        row.add(Tool.jsSpecialChars(v.getText1()));
        row.add(Tool.jsSpecialChars(v.getText2()));
        row.add(Tool.jsSpecialChars(v.getText3()));
        row.add(Tool.jsSpecialChars(v.getText4()));
        row.add(Tool.jsSpecialChars(v.getText5()));
        row.add(Tool.jsSpecialChars(v.getText6()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, YouthHonour pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
//查询条件
private List getListCondition(javax.servlet.http.HttpServletRequest request, YouthHonour pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    
    //限定noticeid
    int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);
    cdt.add("noticeid="+noticeid);
    
    
    //限定academy
    if(userInfo.hasFunPower(Power.UserAdminPower)){//学院
    	int myacademyid=userInfo.getUserCode().getDeptId();
    	if(myacademyid>0){
	    	cdt.add("belongacademy ='"+myacademyid+"'");
    	}
    }else if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){//团委筛选
    	String _belongacademy_=ParamUtils.getParameter(request, "_belongacademy_","");
    	if(_belongacademy_.trim().length()>0){
    		cdt.add("belongacademy='"+_belongacademy_+"'");
    	}
    }

    //type
    int type=ParamUtils.getIntParameter(request, "type", -1);
    if(type>0){
    	cdt.add("type="+type);
    }
    
    //val1
    String _val1_=ParamUtils.getParameter(request, "_val1_","");
    if(!"".equals(_val1_)){
    	cdt.add("val1 like '%"+_val1_+"%'");
    }
    
    
    //提交了才能看见,
    cdt.add("modifyflag in("+SdtwConst.MODIFY_YTJ+","+SdtwConst.MODIFY_SQXG+")");
    
    //学院上报了团委才能看见
    if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
    	cdt.add("xyreport="+SdtwConst.XYREPORT_YSB);
    }
    

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

    YouthHonour pv = new YouthHonour();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "YouthHonour");
    request.setAttribute("describe", "五四评比表彰申请表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthHonour pv = new YouthHonour();
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
private void setForm(javax.servlet.http.HttpServletRequest request, YouthHonour form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "YouthHonour");
    request.setAttribute("describe", "五四评比表彰申请表");
}
private List mkRtn(String cmd, String forward, YouthHonour form)
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
    YouthHonour form = getByParameterDb(request);
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
    //审核
    if(cmd.equals("checkpass"))
    {
    	String idlist = ParamUtils.getParameter(request, "idlist", "");
    	int checkflag=ParamUtils.getIntParameter(request, "checkflag",-1);
    	
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        YouthHonour vp=new YouthHonour();
        
		if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
			vp.setTwCheckFlag(checkflag);
		}else if(userInfo.hasFunPower(Power.UserAdminPower)){
			vp.setAyCheckFlag(checkflag);
		}	
        vp.updateByCondition(cdt);
		return mkRtn("list", "list", form);   
    }

    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
int type=ParamUtils.getIntParameter(request, "type", -1);
int noticeid=ParamUtils.getIntParameter(request, "noticeid", -1);

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("YouthHonourAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);

//附件,单个审核
String tmp = ParamUtils.getParameter(request,"cmd","");
int id=ParamUtils.getIntParameter(request, "id", -1);
String checkflag=ParamUtils.getParameter(request, "checkflag","N");

List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}else if(tmp.equals("otherattach")){
	 String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
	 Calendar c = Calendar.getInstance();
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*5L);
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	 int fl = cuf.save(request);

	 if(fl==-1){//上传失败
	    	try{
	    		out.clear();
				out.print("{error:'上传失败',msg:''}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
		}else if(fl==0){
			out.clear();
			out.print("{error:'附件大小超过10M不能上传',msg:''}");
		}
	else{//上传成功
		try{
			ClientAttach attach = new ClientAttach();
			attach.setDataBase("tuanwei");
			attach.setAttachType(2);
			//attach.setUploadType("application/msword");
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			attach.setFromClass("volunter/VolunteerProjectAction.jsp");
			attach.setFromTable("VolunteerProject");
			if(attach.insert()>0){
				out.clear();
				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
   			
   		}else{
   			out.clear();
   			out.print("{error:'上传失败',msg:''}");
   		}
   	}catch(Exception e){
   		e.printStackTrace();
   	}
	}
	return;
}else if(tmp.equals("delAttach")){
	int tmpid = ParamUtils.getIntParameter(request,"did",-1);
	if(tmpid != -1){
		ClientAttach ca = new ClientAttach();
		ca.delete(tmpid);
		out.print("{\"error\":\"\",\"msg\":\"删除成功\"}");
	}
	else{
		out.print("{error:'删除失败',msg:''}");
	}
	return;
//end 附件
//pic
}else if(tmp.equals("upPic")){
	String Attachids = ParamUtils.getParameter(request,"Attachids","");
	String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
	Calendar c = Calendar.getInstance();
	if(!Attachids.equals("")){
		FileTool.delete(HeadConst.root_file_path+Attachids);
	}
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*3L);
   	int flag = cuf.save(request);
   	if(flag==-1){//上传失败
    	try{
    		out.clear();
    		out.print("{error:'上传失败',msg:''}");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
   	}else if(flag ==0){
   		out.clear();
    	out.print("{error:'图片大小超过3M不 能上传！',msg:''}");
   	}
   	else{//上传成功
   		try{
   			out.clear();
   			//System.out.println(cuf.getSaveTotalName());
    		out.print("{error:'',msg:'上传成功',url:'/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"'}");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
   	}
   	return;

//end pic
//审核单个youthhonour
}else if(tmp.equals("checkYh")){	
	YouthHonour yh=new YouthHonour();
	List cdt=new ArrayList();
	cdt.add("id="+id);
	
	if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
		if(checkflag.equals("Y")){
			yh.setTwCheckFlag(SdtwConst.TWCHECK_TG);
		}else{
			yh.setTwCheckFlag(SdtwConst.TWCHECK_WTG);
		}
	}else if(userInfo.hasFunPower(Power.UserAdminPower)){
		if(checkflag.equals("Y")){
			yh.setAyCheckFlag(SdtwConst.XYCHECK_TG);
		}else{
			yh.setAyCheckFlag(SdtwConst.XYCHECK_WTG);
		}
	}	
	int sum=yh.updateByCondition(cdt);
	
	if(sum>0){
		out.print("{\"output\":\"\",\"msg\":\"审核成功\"}");
	}else{
		out.print("{\"output\":\"\",\"msg\":\"审核失败\"}");
	}
	return;
	
//同意申请修改
}else if("checkApplymodify".equals(tmp)){
	YouthHonour yh=new YouthHonour();
	List cdt=new ArrayList();
	cdt.add("id="+id);
	yh.setModifyFlag(SdtwConst.MODIFY_WTJ);//设置成未提交的状态
	yh.setAyCheckFlag(SdtwConst.XYCHECK_WSH);//设置成学院
	int sum=yh.updateByCondition(cdt);
	
	if(sum>0){
		out.print("{\"output\":\"\",\"msg\":\"操作成功\"}");
	}else{
		out.print("{\"output\":\"\",\"msg\":\"操作失败\"}");
	}
	return;

}else{
	rtn = main(request);
}

String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "YouthHonourAction.jsp?");
forwardMap.put("failure", "YouthHonourForm"+type+".jsp");
forwardMap.put("success", "YouthHonourList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "YouthHonourForm"+type+".jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='YouthHonourAction.jsp?cmd=list&type="+type+"&noticeid="+noticeid+"&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage+ "&type=" + type+ "&noticeid=" + noticeid);
}
%>
