/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 00:55:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.youthhonour;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import com.xietong.software.sdtw.youthhonour.YouthhonourUtil;
import java.io.*;
import java.util.*;
import jxl.*;
import jxl.write.*;
import java.math.BigDecimal;

public final class Youthhonour_005fnoticeAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static Log log = LogFactory.getLog(Youthhonour_notice.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SchoolYear", "AddAccount", "AddTime", "TwReport", "Notice", "Brief"};
private String[] DicKeys = {"Id", "SchoolYear", "AddAccount", "AddTime", "TwReport", "Notice", "Brief"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学年", "45", "text", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "团委发布状态", "0", "hidden", ""}, {"string", "通知标题", "45", "hidden", ""}, {"string", "通知简介", "2000", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SchoolYear", "AddAccount", "AddTime", "TwReport", "Notice", "Brief"};
private String[] ListFields = {"Notice","AddAccount","AddTime","TwReport"};
private String[] FormFields = {"SchoolYear", "AddAccount", "AddTime", "TwReport", "Notice", "Brief"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Youthhonour_notice getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Youthhonour_notice v = new Youthhonour_notice();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSchoolYear(request, "SchoolYear");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramTwReport(request, "TwReport");
        v.paramNotice(request, "Notice");
        v.paramBrief(request, "Brief");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
        
//         v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
//         v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
		
// 		v.setAddAccount(userInfo.getName());
		v.setAddAccount(""+userInfo.getId());
		Date currentDate=new Date();
		v.setAddTime(currentDate);

        v.setTwReport(ParamUtils.getIntParameter(request, "TwReport", -1));
        v.setNotice(ParamUtils.getParameter(request, "Notice", ""));
        v.setBrief(ParamUtils.getParameter(request, "Brief", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Youthhonour_notice pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    
		YouthhonourUtil yhUtil=new YouthhonourUtil();
		Map twReportMap=yhUtil.getTwReportMap();
		Map cnnameMap=CEditConst.getUserCnNameMap(userInfo);
	
		
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Youthhonour_notice v = (Youthhonour_notice)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSchoolYear()));
        
        row.add((String)cnnameMap.get(v.getAddAccount()));
        
        row.add(Tool.stringOfDate(v.getAddTime()));
        
//         row.add("" + v.getTwReport());
        row.add(twReportMap.get(v.getTwReport()));
        
        row.add(Tool.jsSpecialChars(v.getNotice()));
        row.add(Tool.jsSpecialChars(v.getBrief()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Youthhonour_notice pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Youthhonour_notice pv, boolean isAll)
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
    Youthhonour_notice pv = new Youthhonour_notice();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Youthhonour_notice");
    request.setAttribute("describe", "五四评比表彰通知");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Youthhonour_notice pv = new Youthhonour_notice();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Youthhonour_notice form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Youthhonour_notice");
    request.setAttribute("describe", "五四评比表彰通知");
}
private List mkRtn(String cmd, String forward, Youthhonour_notice form)
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
    Youthhonour_notice form = getByParameterDb(request);
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

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("Youthhonour_noticeAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;

//学院上报，团委发布结果
String tmp=ParamUtils.getParameter(request, "cmd","");
int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}else if("shangbaotw".equals(tmp)){//更新此noticeid下此学院的所有xyreport,YouthHonour表
	try{
		String academyid=userInfo.getDeptId()+"";
		List cdt = new ArrayList();
	    cdt.add("noticeid="+noticeid);
	    cdt.add("belongacademy='"+academyid+"'");
	    YouthHonour yh=new YouthHonour();
		yh.setXyReport(SdtwConst.XYREPORT_YSB);//youthhonour条目、学院上报
		yh.setModifyFlag(SdtwConst.MODIFY_YTJ);//youthhonour条目、已提交
		int sum=yh.updateByCondition(cdt);
		if(sum>0){
			out.println("<script>alert('上报成功！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('上报失败！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}
	}catch(Exception e){
   		e.printStackTrace();
   	}
	return;
}else if("gongbu".equals(tmp)){//Youthhonour_notice表
	try{
		List cdt=new ArrayList();
		cdt.add("id="+noticeid);
		Youthhonour_notice yhNotice=new Youthhonour_notice();
		yhNotice.setTwReport(SdtwConst.TWREPORT_YGB);//youthhonour_notice 已公布
		int sum=yhNotice.updateByCondition(cdt);
		if(sum>0){
			out.println("<script>alert('结果已公布');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('操作失败！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}
	}catch(Exception e){
   		e.printStackTrace();
   	}
	return;

}else if("bugongbu".equals(tmp)){//撤销notice的公布标志，并撤销所有YouthHonour学院的report标志
	try{
		List cdt=new ArrayList();
		cdt.add("id="+noticeid);
		Youthhonour_notice yhNotice=new Youthhonour_notice();
		yhNotice.setTwReport(SdtwConst.TWREPORT_WGB);//youthhonour_notice 未公布
		int sum1=yhNotice.updateByCondition(cdt);
		
		List cdt2=new ArrayList();
		cdt2.add("noticeid="+noticeid);
		YouthHonour yh=new YouthHonour();
		yh.setXyReport(SdtwConst.XYREPORT_WSB);//所有学院设置成未上报
		int sum2=yh.updateByCondition(cdt2);
		
		if(sum1+sum2>0){
			out.println("<script>alert('结果已公布');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('操作失败！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}
	}catch(Exception e){
   		e.printStackTrace();
   	}
	return;
}else if("resetstu".equals(tmp)){//YouthHonour重置本学院所有学生上报标志
	try{
		int academyid=userInfo.getDeptId();
		YouthHonour yh=new YouthHonour();
		List cdt=new ArrayList();
		cdt.add("noticeid="+noticeid);
		cdt.add("belongacademy='"+academyid+"'");
		yh.setModifyFlag(SdtwConst.MODIFY_WTJ);
		int sum=yh.updateByCondition(cdt);
		if(sum>0){
			out.println("<script>alert('操作成功！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('操作失败！');window.location.href='YouthhonourAllList.jsp?noticeid="+noticeid+"';</script>");
		}
	
	}catch(Exception e){
		e.printStackTrace();
	}
}else{
    rtn = main(request);
}

String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "Youthhonour_noticeAction.jsp");
forwardMap.put("failure", "Youthhonour_noticeForm.jsp");
forwardMap.put("success", "Youthhonour_noticeList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "Youthhonour_noticeForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='Youthhonour_noticeAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
