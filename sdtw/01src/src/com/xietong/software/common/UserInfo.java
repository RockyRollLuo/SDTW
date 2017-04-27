package com.xietong.software.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xietong.software.sdtw.db.BaseDeptCode;
import com.xietong.software.sdtw.db.BaseOrgCode;
import com.xietong.software.sdtw.db.BaseRoleCode;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.util.ExpiringCache;
import com.xietong.software.util.Tool;

public class UserInfo {
    
    private static Log log = LogFactory.getLog(UserInfo.class);
    private static ExpiringCache cache = new ExpiringCache(2*60*1000, 60*1000, 60*1000, 60*1000);
    private int documentStyle = 0; //公文类型, 0: send, 1: receive, 2: green
    private boolean share = false; //是否跨单位, 0: send, 1: receive, 2: green
    private boolean isht = false; //是否是合同
    private String sharedb = HeadConst.ShareUserDbName; //
    private String userdb = HeadConst.UserDbName; //
    private String rulelist = "";
    private String rootUrl = HeadConst.root_url_path;
    private String leaders = "";

    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private String productname = HeadConst.product_name;  //产品名称
    private String productcopyright = HeadConst.product_copyright;  //产品版权

    private String userleaders = ""; //用户部门领导
    
    private Date lastTime = null;
    private int logonNum = 0;
    private String ip = "";
    

    //用户界面默认值
    private String skinid = HeadConst.SkinId;
    private int dispnum = HeadConst.DispNum;
    private String openfolder = HeadConst.OpenFolder;
    private int wordstartstyle = HeadConst.WordStartStyle;
    private String orderby = HeadConst.OrderBy;
    private String orderstyle = HeadConst.OrderStyle;
    private int msgrefretime = HeadConst.MsgRefreTime;
    private int delefromtodo = HeadConst.DeleFromTodo;
    private BaseUserCode[] userCodes = null;
    private int userCodesIndex;

    public int getId() { return userCodes[userCodesIndex].getId(); }

    public String getCnName() { return userCodes[userCodesIndex].getCnName(); }

    public String getName() { return userCodes[userCodesIndex].getName(); }

    public String getDb() { return getDbByOrgId(userCodes[userCodesIndex].getOrgId()); }
    
    public Date getLastTime(){return userCodes[userCodesIndex].getLastTime();}
    public int getLogonNum(){return userCodes[userCodesIndex].getLogonNum();}
    public String getIp(){return userCodes[userCodesIndex].getIp();}

    public int getPower() { return -1; }
    private String MoudlePower = "";
    
	private String CSMoudlePower = "";
    private String CSFunPower = "";
    public String getCSMoudlePower() {
		return CSMoudlePower;
	}

	public void setCSMoudlePower(String cSMoudlePower) {
		CSMoudlePower = cSMoudlePower;
	}

	public void setCSFunPower(String cSFunPower) {
		CSFunPower = cSFunPower;
	}
    public void setMoudlePower(String val) {
    	MoudlePower = val;
    }
    
    public String getMoudlePower() { 
    	return MoudlePower; //返回每个人的模块权限code串，以“，”号分隔
    }
    private String FunPower = "";
    public void setFunPower(String val) {
    	FunPower = val;
    }
    public String getFunPower() { 
    	return FunPower; //返回每个人的功能点权限code串，以“，”号分隔
    }
    public boolean hasMoudlePower(String moudlecode){//判断是否对某模块具有权限
    	boolean has = false;
    	if((","+getMoudlePower()+",").indexOf(","+moudlecode+",")>-1)has=true;
    	return has;
    }
    
    public boolean hasFunPower(String funcode){//判断是否对某模块下功能点具有权限
    	boolean has = false;
    	System.out.println(getFunPower()+"   =============");
    	if((","+getFunPower()+",").indexOf(","+funcode+",")>-1||(","+getFunPower()+",").indexOf(",Admin,")>-1)has=true;
    	return has;
    }
    
    //------------车商权限------------------
    public String getCSFunPower() { 
    	return CSFunPower; //返回每个人的功能点权限code串，以“，”号分隔
    }
    public boolean hasCSMoudlePower(String moudlecode){//判断是否对某模块具有权限
    	boolean has = false;
    	if((","+getCSMoudlePower()+",").indexOf(","+moudlecode+",")>-1)has=true;
    	return has;
    }
    
    public boolean hasCSFunPower(String funcode){//判断是否对某模块下功能点具有权限
    	boolean has = false;
    	if((","+getCSFunPower()+",").indexOf(","+funcode+",")>-1||(","+getCSFunPower()+",").indexOf(",Admin,")>-1)has=true;
    	return has;
    }
    //--------------车商权限-------------------
    
    public int getOrgId() { return userCodes[userCodesIndex].getOrgId(); }

    public int getDocumentStyle() { return documentStyle; }
    public void setDocumentStyle(int val) {
        documentStyle = val;
    }
    public void setDocumentStyle(HttpServletRequest request, HttpServletResponse response, int val) {
        documentStyle = val;
        if (HeadConst.UserInfoInSession) {
            HttpSession session = request.getSession();
            UserInfo sui = (UserInfo)session.getAttribute("UserInfo");
            if (sui != null) {
                sui.setDocumentStyle(val);
            }
        }
        addCookie(response);
    }
    public void setShareAndDStyle(HttpServletRequest request, HttpServletResponse response, int val, boolean aShare){
    	documentStyle = val;
    	share = aShare;
        if (HeadConst.UserInfoInSession) {
            HttpSession session = request.getSession();
            UserInfo sui = (UserInfo)session.getAttribute("UserInfo");
            if (sui != null) {
                sui.setDocumentStyle(val);
                sui.setShare(aShare);
            }
        }
        addCookie(response);
    	
    }

    public int getDeptId() { return userCodes[userCodesIndex].getDeptId(); }
    //public void setDeptId(int aDeptId) { deptid = aDeptId; }

    public String getLeaders() { return leaders; }
    public void setLeaders(String aLeaders) { leaders = aLeaders; }

    public String getDbByOrgId(int id) {
        String rtn = HeadConst.UserDbName;
        com.xietong.software.sdtw.db.BaseOrgCode udc = getOrgCode(id);
        //if (udc != null) {
            //if (udc.getOracleUser().length() > 0) {
                //rtn = udc.getOracleUser();
            //}
        //}
        return rtn;
    }

    public String getUserLeaders() {//得到用户所在部门领导
        String rtn = "";
        BaseDeptCode udc = getDeptCode(userCodes[userCodesIndex].getDeptId());
        if (udc != null) {
            //if (udc.getLeaders().length() > 0) {
                //rtn = udc.getLeaders();
            //}
        }
        return rtn;
    }

    public String getDbname() {
        if (isht){
            return userdb;
        }else if (share) {
            return sharedb;
        } else {
            return getDb();
        }
    }

    

    public String getSkinId() { return skinid; }
    public void setSkinId(String aSkinId) { skinid = aSkinId; }

    public int getDispNum() { return dispnum; }
    public void setDispNum(int aDispNum) { dispnum = aDispNum; }

    public String getOpenFolder() { return openfolder; }
    public void setOpenFolder(String aOpenFolder) { openfolder = aOpenFolder; }

    public int getWordStartStyle() { return wordstartstyle; }
    public void setWordStartStyle(int aWordStartStyle) { wordstartstyle = aWordStartStyle; }

    public String getOrderBy() { return orderby; }
    public void setOrderBy(String aOrderBy) { orderby = aOrderBy; }

    public String getOrderStyle() { return orderstyle; }
    public void setOrderStyle(String aOrderStyle) { orderstyle = aOrderStyle; }

    public int getMsgRefreTime() { return msgrefretime; }
    public void setMsgRefreTime(int aMsgRefreTime) { msgrefretime = aMsgRefreTime; }

    public int getDeleFromTodo() { return delefromtodo; }
    public void setDeleFromTodo(int aDeleFromTodo) { delefromtodo = aDeleFromTodo; }

    public String getProductName() { return productname; }
    public void setProductName(String aProductName) { productname = aProductName; }

    public String getProductCopyright() { return productcopyright; }
    public void setProductCopyright(String aProductCopyright) { productcopyright = aProductCopyright; }

    public String getRootUrl() { return rootUrl; }
    public void setRootUrl(String aRootUrl) { rootUrl = aRootUrl; }

    //public int getIsFirstLogon() { return userCodes[userCodesIndex].getIsFirstLogon(); }

    public boolean isShare() { return share; }
    public void setShare(boolean aShare) { share = aShare; }/*在CUserCode.java SendAction.jsp中调用，如果调用setShare（）此方法，请在此处写上说明*/
    public void setShare(HttpServletRequest request, HttpServletResponse response, boolean aShare){
    	share = aShare;
    	if (HeadConst.UserInfoInSession) {
            HttpSession session = request.getSession();
            UserInfo sui = (UserInfo)session.getAttribute("UserInfo");
            if (sui != null) {
                sui.setShare(aShare);
            }
        }
    	addCookie(response);
    }
    
    public void setAgreement(boolean aAgreement) { isht = aAgreement; }

    public BaseUserCode getUserCode() { return userCodes[userCodesIndex]; }
    public String getRuleList() { return rulelist; }

    private Map tnameMap = null;
    private String[] getLowerCaseArray(String[] arr) {
        String[] rtn = new String[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            rtn[i] = arr[i].toLowerCase();
        }
        return rtn;
    }
    public String getTname(String oldName, int docStyle) {
        if (tnameMap == null) {
            tnameMap = new HashMap();
            //发文、收文、学生事务、教学事务、人事事务、财务事务、后勤事务、请示报告、其他事务、科学研究、国际交流、安全保卫、研究生工作、实验室与设备管理
            String[][] tnames = new String[][]{
                    {"Send", "Receive", "Student", "Teach", "Person", "Finace", "Logistics", "Apply", "Rest", "Science", "Communion", "Safe", "Graduate", "Laboratory"},
                    {"SendDealSug", "ReceiveDealSug", "StudentDealSug", "TeachDealSug", "PersonDealSug", "FinaceDealSug", "LogisticsDealSug", "ApplyDealSug", "RestDealSug", "ScienceDealSug", "CommunionDealSug", "SafeDealSug", "GraduateDealSug", "LaboratoryDealSug"},
                    {"SendDistribute", "ReceiveDistribute", "StudentDistribute", "TeachDistribute", "PersonDistribute", "FinaceDistribute", "LogisticsDistribute", "ApplyDistribute", "RestDistribute", "ScienceDistribute", "CommunionDistribute", "SafeDistribute", "GraduateDistribute", "LaboratoryDistribute"},
                    {"SendDocLimit", "ReceiveDocLimit", "StudentDocLimit", "TeachDocLimit", "PersonDocLimit", "FinaceDocLimit", "LogisticsDocLimit", "ApplyDocLimit", "RestDocLimit", "ScienceDocLimit", "CommunionDocLimit", "SafeDocLimit", "GraduateDistribute", "LaboratoryDistribute"},
                    {"SendEx", "ReceiveEx", "StudentEx", "TeachEx", "PersonEx", "FinaceEx", "LogisticsEx", "ApplyEx", "RestEx", "ScienceEx", "CommunionEx", "SafeEx", "GraduateEx", "LaboratoryEx"},
                    {"SendFlowItem", "ReceiveFlowItem", "StudentFlowItem", "TeachFlowItem", "PersonFlowItem", "FinaceFlowItem", "LogisticsFlowItem", "ApplyFlowItem", "RestFlowItem", "ScienceFlowItem", "CommunionFlowItem", "SafeFlowItem", "GraduateFlowItem", "LaboratoryFlowItem"},
                    {"SendLogs", "ReceiveLogs", "StudentLogs", "TeachLogs", "PersonLogs", "FinaceLogs", "LogisticsLogs", "ApplyLogs", "RestLogs", "ScienceLogs", "CommunionLogs", "SafeLogs", "GraduateLogs", "LaboratoryLogs"},
                    {"SendSugAttach", "ReceiveSugAttach", "StudentSugAttach", "TeachSugAttach", "PersonSugAttach", "FinaceSugAttach", "LogisticsSugAttach", "ApplySugAttach", "RestSugAttach", "ScienceSugAttach", "CommunionSugAttach", "SafeSugAttach", "GraduateSugAttach", "LaboratorySugAttach"}
            };

            for (int i = 0; i < tnames.length; i ++) {
                //oracle采用大小写区分的
                tnameMap.put(tnames[i][0], tnames[i]);
                //mysql采用全部小写
                tnameMap.put(tnames[i][0].toLowerCase(), getLowerCaseArray(tnames[i]));
            }
        }
        String[] name = (String[])tnameMap.get(oldName);
        if (name == null) {
            return oldName;
        } else if (docStyle > (name.length - 1)) {
            return oldName;
        } else {
            return name[docStyle];
        }
    }
    public String getTname(String oldName) {
        return getTname(oldName, documentStyle);
    }
    
    
    public void changeUser(HttpServletRequest request, HttpServletResponse response, int id) {
        init(getUserCode(id));
        addCookie(response);
        if (HeadConst.UserInfoInSession) {
            request.getSession().setAttribute("UserInfo", this);
        }
        request.setAttribute("Global_UserInfo", this);
        //setUserCodesIndex(id);
    }
    public void initDefault(BaseUserCode uc) {
        //判断用户选项是否为空，如果为空，则取系统默认值
        if(uc.getSkinId().trim().length()!=0) {
            //setSkinId("set" + uc.getSkinId()); //用户界面"皮肤"ID   edit by dyh 2011-11-16
        	setSkinId(uc.getSkinId());
        }
        if(uc.getDispNum()!=-1) {
            setDispNum(uc.getDispNum()); //显示条数
        }
        //if(uc.getOpenFolder().trim().length()!=0) {
            //setOpenFolder(uc.getOpenFolder()); //默认打开文件夹
        //}
        //if(uc.getWordStartStyle()!=-1) {
            //setWordStartStyle(uc.getWordStartStyle());    //删除时是否提示
        //}
        //if(uc.getOrderbyField().trim().length()!=0) {
            //setOrderBy(uc.getOrderbyField());    //默认排序列
        //}
        //if(uc.getOrderStyle().trim().length()!=0) {
            //setOrderStyle(uc.getOrderStyle());    //默认默认排序方式
        //}
        //if(uc.getMsgRefreTime()!=-1) {
            //setMsgRefreTime(uc.getMsgRefreTime());    //默认刷新时间（消息提示）
        //}
        //if(uc.getDeleFromTodo()!=-1) {
            //setDeleFromTodo(uc.getDeleFromTodo());    //立即删除
        //}
    }
    
    public void init(BaseUserCode uc) {
        if (uc == null) {
            log.debug("init uc is null!");
            return;
        }
        setUserCodes(uc);
        initDefault(uc);
        
        String MoudleCodes = "";
        String FunCodes = "";String RoleIds = userCodes[userCodesIndex].getRoles();
    	List cdt = new ArrayList();
    	if(RoleIds!=null&&!RoleIds.equals(""))
        {
    		cdt.add("id in ("+RoleIds+")");
    	}else{
    		cdt.add("1>2");
    	}
    	BaseRoleCode r = new BaseRoleCode();
    	BaseRoleCode[] rs = r.queryByCondition(cdt);
        Set moudleSet = new HashSet();
        Set funSet = new HashSet();
    	for(int i=0;i<rs.length;i++){
    		String[] moudleTmp = rs[i].getMoudleCode().split(",");
    		String[] funTmp = rs[i].getFunCodes().split(",");
    		for(int j=0;j<moudleTmp.length;j++)
    			moudleSet.add(moudleTmp[j]);
    		for(int j=0;j<funTmp.length;j++)
    			funSet.add(funTmp[j]);
    	}
    	MoudleCodes = Tool.join(",", moudleSet);
    	FunCodes = Tool.join(",", funSet);
    	setMoudlePower(MoudleCodes);
    	setFunPower(FunCodes);
        //OrgCode oc = getOrgCode(uc.getOrgId());
        //if (oc != null) {
            //rootUrl = ((oc.getRootPath().length() == 0) ? HeadConst.root_url_path: oc.getRootPath());
            //if(oc.getProductName().trim().length()>0) {
                //String[] ls_array2  = Tool.split(":",oc.getProductName().trim());	
                //for(int i=0; i<ls_array2.length; i++) {
                    //if(i==0) {
                        //if(ls_array2[0].trim().length()>0)
                            //setProductName(ls_array2[0].trim());  //2005年3月14日 jinxz 各单位可以设置本单位的产品名称
                    //} else if(i==1) {
                        //if(ls_array2[1].trim().length()>0)
                            //setProductCopyright(ls_array2[1].trim());
                    //}
                //}        	
            //}
        //}
        //DeptCode dc = getDeptCode(uc.getDeptId());
        //if (dc != null) {
            //setLeaders(dc.getLeaders());
        //}
    }
    
    

    public UserInfo(BaseUserCode uc) {
        init(uc);
    }
    public UserInfo(int userid) {
    	BaseUserCode uc = getUserCode(userid);
        if (uc != null) {
            init(uc);
        }
    }
    public static UserInfo getInstance(HttpServletRequest request) {
        UserInfo rtn = null;
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i ++) {
                if (cookies[i].getName().equals(HeadConst.MainCookieName)) {
                    String svalue = cookies[i].getValue();
                    if (svalue.length() > 0) {
                        String[] id_ds_sh = Tool.split("_", svalue);
                        BaseUserCode uc = getUserCode(StrTool.toInt(id_ds_sh[0]));
                        if (uc != null) {
                            rtn = new UserInfo(uc);
                            if (id_ds_sh.length > 1) {
                                rtn.setDocumentStyle(StrTool.toInt(id_ds_sh[1]));
                            }
                            if (id_ds_sh.length > 2) {
                                rtn.setShare(id_ds_sh[2].equals("1"));
                            }
                            //com.xietong.software.main.COnlineUser.add(uc);
                            request.getSession().setAttribute("UserInfo", rtn);
                        }
                        break;
                    }
                }
            }
        }
        return rtn;
    }

    public int getUserCodesIndex() {
        return userCodesIndex;
    }

    //通过用户ID设置当前的索引
    public void setUserCodesIndex(int id) {
        log.debug("setUserCodesIndex(" + id + ")");
        for (int i = 0; i < userCodes.length; i ++) {
            if (userCodes[i].getId() == id) {
                userCodesIndex = i;
                break;
            }
        }
        log.debug("userCodesIndex = " + userCodesIndex);
    }

    public BaseUserCode[] getUserCodes() {
        return userCodes;
    }

    public void setUserCodes(BaseUserCode[] ucs, int index) {
        userCodes = ucs;
        userCodesIndex = index;
    }

    public void setUserCodes(BaseUserCode uc) {
        userCodes = (BaseUserCode[])cache.recover("ucs_" + uc.getId());
        if (userCodes == null) {
            List cdt = new ArrayList();
            cdt.add("id=" + uc.getId());
            cdt.add("enable=1");
            cdt.add("order by id");
            userCodes = uc.queryByCondition(cdt);
            cache.admit("ucs_" + uc.getId(), userCodes);
        }
        setUserCodesIndex(uc.getId());
    }
    
    /**
     * 用户退出时  清空cache
     * 主要是在更换显示风格的时候
     * @param uc
     */
    public void removeUserCode(BaseUserCode uc){
    	userCodes = (BaseUserCode[])cache.recover("ucs_" + uc.getId());
        if (userCodes != null) {
            cache.discard("ucs_"+uc.getId());
            cache.discard("uc_"+uc.getId());
        }
    }

    public static BaseUserCode getUserCode(int id) {
    	BaseUserCode rtn = (BaseUserCode)cache.recover("uc_" + id);
        if (rtn == null) {
            rtn = (new BaseUserCode()).getById(id);
            log.debug(rtn.toMap());
            cache.admit("uc_" + id, rtn);
        }
        return rtn;
    }

    public static BaseOrgCode getOrgCode(int id) {
    	BaseOrgCode rtn = (BaseOrgCode)cache.recover("oc_" + id);
        if (rtn == null) {
            rtn = (new BaseOrgCode()).getById(id);
            log.debug(rtn.toMap());
            cache.admit("oc_" + id, rtn);
        }
        return rtn;
    }

    public static BaseDeptCode getDeptCode(int id) {
    	BaseDeptCode rtn = (BaseDeptCode)cache.recover("dc_" + id);
        if (rtn == null) {
            rtn = (new BaseDeptCode()).getById(id);
            log.debug(rtn.toMap());
            cache.admit("dc_" + id, rtn);
        }
        return rtn;
    }
    
    public String getDeptCode(){
    	BaseDeptCode deptCode = getDeptCode(getDeptId());
    	return deptCode.getCode();
    }

    public void addCookie(HttpServletResponse response) {
        String value = "" + userCodes[userCodesIndex].getId() + "_" + documentStyle + "_" + ((share)? "1": "0");
        Cookie cookie = new Cookie(HeadConst.MainCookieName, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void removeCookie(HttpServletResponse response) {
        String value = "";
        Cookie cookie = new Cookie(HeadConst.MainCookieName, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public UserInfo() {
    }
    public UserInfo cloneMe() {
        UserInfo ui = new UserInfo();
        ui.setUserCodes(this.userCodes, this.userCodesIndex);
        ui.setSkinId(this.getSkinId());
        ui.setMoudlePower(this.getMoudlePower());
        ui.setFunPower(this.getFunPower());
        ui.setCSMoudlePower(this.getCSMoudlePower());
        ui.setCSFunPower(this.getCSFunPower());
        ui.setDispNum(this.getDispNum());
        ui.setOpenFolder(this.getOpenFolder());
        ui.setWordStartStyle(this.getWordStartStyle());
        ui.setOrderBy(this.getOrderBy());
        ui.setOrderStyle(this.getOrderStyle());
        ui.setMsgRefreTime(this.getMsgRefreTime());
        ui.setDeleFromTodo(this.getDeleFromTodo());
        ui.setProductName(this.getProductName());
        ui.setProductCopyright(this.getProductCopyright());
        ui.setLeaders(this.getLeaders());
        ui.setDocumentStyle(this.getDocumentStyle());
        ui.setRootUrl(this.getRootUrl());
        ui.setShare(this.isShare());
        return ui;
    }
    public static List getOrgDeptList() {
        List rtn = (List)cache.recover("orgdeptlist");
        if (rtn == null) {
            rtn = new ArrayList();
            rtn.add("_");
            List cdt = new ArrayList();
            cdt.add("order by ordernum asc");
            Map orgdept = new HashMap();
            for (Iterator it = (new BaseDeptCode()).query(cdt).iterator(); it.hasNext();) {
            	BaseDeptCode item = (BaseDeptCode)it.next();
                List dept = (List)orgdept.get("" + item.getOrgId());
                if (dept == null) {
                    dept = new ArrayList();
                }
                dept.add(item.getOrgId() + "_" + item.getId());
                orgdept.put("" + item.getOrgId(), dept);
            }
            for (Iterator it = (new BaseOrgCode()).query(cdt).iterator(); it.hasNext();) {
            	BaseOrgCode item = (BaseOrgCode)it.next();
                rtn.add( item.getId()+ "_");
                List dept = (List)orgdept.get("" + item.getId());
                if (dept != null) {
                    rtn.addAll(dept);
                }
            }
            cache.admit("orgdeptlist", rtn);
        }
        return rtn;
    }
}

