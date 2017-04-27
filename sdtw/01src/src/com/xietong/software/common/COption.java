package com.xietong.software.common;

import com.xietong.software.util.StringUtils;
import java.io.*;
import java.util.*;
import java.net.MalformedURLException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;

// Referenced classes of package com.xietong.software.common:
//            HeadConst, StrTool

public class COption extends HttpServlet
{

	private static final long serialVersionUID = -3198821442074386996L;

	public COption()
    {
    }

    public void init()
        throws ServletException
    {
        // Read properties file.
        Properties properties = new Properties();
        try {
            String path = getServletConfig().getServletContext().getRealPath("");
            properties.load(new FileInputStream(path + "/WEB-INF/classes/init.properties"));

            HeadConst.MainDbName = StringUtils.stringFromCh(properties.getProperty("MainDbName"));
            HeadConst.UserDbName = StringUtils.stringFromCh(properties.getProperty("UserDbName"));
            HeadConst.ShareUserDbName = StringUtils.stringFromCh(properties.getProperty("ShareUserDbName"));

            HeadConst.product_name = properties.getProperty("product_name");
            HeadConst.product_version = StringUtils.stringFromCh(properties.getProperty("product_version"));
            HeadConst.product_copyright = properties.getProperty("product_copyright");
            HeadConst.product_code = StringUtils.stringFromCh(properties.getProperty("product_code"));

            HeadConst.ocx_word_version = StringUtils.stringFromCh(properties.getProperty("ocx_word_version"));
            HeadConst.ocx_word_classid = StringUtils.stringFromCh(properties.getProperty("ocx_word_classid"));
            HeadConst.ocx_check_version = StringUtils.stringFromCh(properties.getProperty("ocx_check_version"));
            HeadConst.ocx_check_classid = StringUtils.stringFromCh(properties.getProperty("ocx_check_classid"));
            HeadConst.ocx_version = StringUtils.stringFromCh(properties.getProperty("ocx_version"));
            HeadConst.ocx_classid = StringUtils.stringFromCh(properties.getProperty("ocx_classid"));

            HeadConst.DispNum = StrTool.toInt(properties.getProperty("DispNum"));
            HeadConst.OpenFolder = StringUtils.stringFromCh(properties.getProperty("OpenFolder"));
            HeadConst.WordStartStyle = StrTool.toInt(properties.getProperty("WordStartStyle"));
            HeadConst.OrderBy = StringUtils.stringFromCh(properties.getProperty("OrderBy")); 
            HeadConst.OrderStyle = StringUtils.stringFromCh(properties.getProperty("OrderStyle"));
            HeadConst.MsgRefreTime = StrTool.toInt(properties.getProperty("MsgRefreTime"));
            HeadConst.DeleFromTodo = StrTool.toInt(properties.getProperty("DeleFromTodo"));
            HeadConst.SDUNICOMID = StrTool.toInt(properties.getProperty("SDUNICOMID"));
            HeadConst.apache_url = StringUtils.stringFromCh(properties.getProperty("apache_url"));
            HeadConst.tg_url = StringUtils.stringFromCh(properties.getProperty("tg_url"));
            HeadConst.bbs_url = StringUtils.stringFromCh(properties.getProperty("bbs_url"));

            HeadConst.ihub = StrTool.toInt(properties.getProperty("ihub"));
            HeadConst.ihub_server = StringUtils.stringFromCh(properties.getProperty("ihub_server"));
            HeadConst.ihub_user = StringUtils.stringFromCh(properties.getProperty("ihub_user"));
            HeadConst.ihub_password = StringUtils.stringFromCh(properties.getProperty("ihub_password"));
            HeadConst.ihub_path = StringUtils.stringFromCh(properties.getProperty("ihub_path"));
            HeadConst.ihub_server_path = StringUtils.stringFromCh(properties.getProperty("ihub_server_path"));

            HeadConst.root_url_ip = StringUtils.stringFromCh(properties.getProperty("root_url_ip"));

            HeadConst.wfbak_url = StringUtils.stringFromCh(properties.getProperty("wfbak_url"));

            HeadConst.Ldap = StrTool.toInt(properties.getProperty("Ldap"));
            HeadConst.Ldap_url = StringUtils.stringFromCh(properties.getProperty("Ldap_url"));
            HeadConst.Ldap_url_password = StringUtils.stringFromCh(properties.getProperty("Ldap_url_password"));

            HeadConst.Sms = StrTool.toInt(properties.getProperty("Sms"));
            HeadConst.SmsUrl = StringUtils.stringFromCh(properties.getProperty("SmsUrl"));

            HeadConst.ImServer = StrTool.toInt(properties.getProperty("ImServer"));
            HeadConst.ImServerIp = StringUtils.stringFromCh(properties.getProperty("ImServerIp"));
            HeadConst.ImServerConfig = StringUtils.stringFromCh(properties.getProperty("ImServerConfig"));

            HeadConst.Notice = StrTool.toInt(properties.getProperty("Notice"));
            HeadConst.ConfRoom = StrTool.toInt(properties.getProperty("ConfRoom"));
            HeadConst.Goods = StrTool.toInt(properties.getProperty("Goods"));
            HeadConst.Site = StrTool.toInt(properties.getProperty("Site"));
            HeadConst.Vehicles = StrTool.toInt(properties.getProperty("Vehicles"));
            HeadConst.Contract = StrTool.toInt(properties.getProperty("Contract"));
            HeadConst.Dangan = StrTool.toInt(properties.getProperty("Dangan"));
            HeadConst.Task = StrTool.toInt(properties.getProperty("Task"));

            HeadConst.Vod = StrTool.toInt(properties.getProperty("Vod"));
            HeadConst.WebCal = StrTool.toInt(properties.getProperty("WebCal"));
            HeadConst.Meeting = StrTool.toInt(properties.getProperty("Meeting"));
            
            
           
          

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String[] resource = com.xietong.software.util.Tool.split("/", getServletConfig().getServletContext().getResource("/").toString());
//            HeadConst.root_url_path = "/" + resource[resource.length - 2];
            HeadConst.root_url_path = StringUtils.stringFromCh(properties.getProperty("root_url_path")); 
            HeadConst.root_file_path = getServletConfig().getServletContext().getRealPath("/").replaceAll("\\\\", "/");

            HeadConst.root_file_path = HeadConst.root_file_path.substring(0, HeadConst.root_file_path.length());
            System.out.println("root_url_path=" + HeadConst.root_url_path);
            System.out.println("root_file_path=" + HeadConst.root_file_path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CEditConst.init(getServletContext());
    }
}
