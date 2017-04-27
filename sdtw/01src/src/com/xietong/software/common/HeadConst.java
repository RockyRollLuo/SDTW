// Source File Name:   HeadConst.java

package com.xietong.software.common;


public class HeadConst
{
	//定义投诉几点降低一次信用等级
	public static int CreditRateSubNum_CM = 2;//企业
	public static int CreditRateSubNum_PM = 2;//个人
	
	//邮件发送设置
    public static String StmpHost = "";//服务器
	public static String StmpUserName = "";//用户名
	public static String StmpPassword = "";//密码

    public static final String[] SYSTEMCODES = {"_"};
    public static final String[] SYSTEMNAMES = {"后台管理"};
    public static final String[] SYSTEMURLS = {""};
    public static final String MainCookieName = "JNXHSD";
    public static final String CookieName = "JNXHSDU";

    public static String MainDbName = "xhsd";    //主数据库名或用户名
    public static String UserDbName = "xhsd";        //用户当前使用的WEBOA数据库名
    public static String ShareUserDbName = "xhsd";        //跨单位数据库名

    public static String product_name = "济南新华书店";
    public static String product_version = "";
    public static String product_copyright = "";
    public static String product_code = "";
    public static String ocx_word_version = "";
    public static String ocx_word_classid = "";
    public static String ocx_check_classid = "";
    public static String ocx_check_version = "";
    public static String ocx_version = "";
    public static String ocx_classid = "";
    public static boolean IsNoPlus = true; //是否采用无插件版本

    public static int Sms = 0;
    public static String SmsUrl = "";

    public static String root_file_path = "";
    public static String root_url_path = "";
    public static String gisPath = "";
    

    //索引
    public static String luceneIndex = "";
    public static String apache_url = "";
    public static String tg_url = "";
    public static String bbs_url = "";
    public static String smallSys_url = "";

    public static String SkinId = "blue";
    public static int DispNum = 10;
    public static String OpenFolder = "";
    public static int WordStartStyle = 1;
    public static String OrderBy = "";
    public static String OrderStyle = "";
    public static int MsgRefreTime = 60;
    public static int DeleFromTodo = 1;

    public static int ihub = 0;
    public static String ihub_server = "";
    public static String ihub_user = "";
    public static String ihub_password = "";
    public static String ihub_path = "";
    public static String ihub_server_path = "";

    public static String root_url_ip = "";

    public static String wfbak_url = "";

    public static int Ldap = 0;
    public static String Ldap_url = "";
    public static String Ldap_url_password = "";

    public static int ImServer = 0;
    public static String ImServerIp = "";
    public static String ImServerConfig = "";

    public static int Notice = 0;
    public static int ConfRoom = 0;
    public static int Goods = 0;
    public static int Site = 0;
    public static int Vehicles = 0;
    public static int Contract = 0;
    public static int Dangan = 0;
    public static int Task = 0;

    public static int Forum = 0;
    public static String ForumUrl = "";

    public static int Vod = 0;
    public static int WebCal = 0;
    public static int Meeting = 0;
    public static int SDUNICOMID = 1;
    

    //在恢复UserInfo的时候是否从session中恢复，可以提高性能。
    public static boolean UserInfoInSession = false;

    public static String years[] = { "2002", "2003", "2004", "2005", "2006" };
    public static int[] splitType = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    public HeadConst()
    {
    }

    public static String[] getUumPower(int power)
    {
        String ql[] = {
            "系统管理员", "单位管理员", "部门管理员", "普通人员"
        };
        if(power == 1)
            ql[0] = "";
        return ql;
    }

    public static String[] getQueryLevel()
    {
        String ql[] = {
            "普通人员", "处室档案员", "总档案员"
        };
        return ql;
    }

    public static String[] getFlowModule()
    {
        String fm[] = {
            "收文", "发文"
        };
        return fm;
    }

    public static String[] getUserType()
    {
        String fm[] = {
            "个人用户", "企业用户"
        };
        return fm;
    }

}
