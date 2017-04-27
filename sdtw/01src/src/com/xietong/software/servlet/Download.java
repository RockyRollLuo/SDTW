package com.xietong.software.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xietong.software.common.HeadConst;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.ClientAttach;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.util.Tool;

public class Download extends HttpServlet
{

    public Download()
    {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        UserInfo ui = Tool.getUserInfo(req);
        int id = ParamUtils.getIntParameter(req, "id", 0);
        String type = ParamUtils.getParameter(req, "type", "attach");
        
        if(type.equals("clientattach")) {
        	//System.out.println("==============   ");
        	 ClientAttach item = new ClientAttach();
             //item.setDataBase("tuanwei");
             //item.setTableName("club");
             item=item.getById(id);
            
            if(item != null) {
            	String fileName=HeadConst.root_file_path+item.getGenerateName();
            	//String hdName=item.getUploadName();
            	//hdName=hdName.substring(hdName.lastIndexOf("/")+1);
            	FileInputStream fis = new FileInputStream(fileName);
                setHeaderName(res, item.getUploadName(), item.getUploadType());
                javax.servlet.ServletOutputStream out = res.getOutputStream();
                writeData(fis, out);
            }
            return;
        }
        if(type.equals("otherattach")) {
            ClientAttach item = new ClientAttach();
            //item.setDataBase("tuanwei");
            //item.setTableName("club");
            item=item.getById(id);
            if(item != null) {
            	String fileName=HeadConst.root_file_path+item.getGenerateName();
            	//String hdName=item.getUploadName();
            	//hdName=hdName.substring(hdName.lastIndexOf("/")+1);
            	FileInputStream fis = new FileInputStream(fileName);
            	//System.out.println("==============   "+item.getUploadType());
                setHeaderName(res, item.getUploadName(), item.getUploadType());
                javax.servlet.ServletOutputStream out = res.getOutputStream();
                writeData(fis, out);
            }
            return;
        }
       
        if(type.equals("downUsers")){
			String filename = HeadConst.root_file_path+ "/main/upload/template/user.xls";
			setHeaderName(res,"学生信息导入模板.xls", "xls");
			javax.servlet.ServletOutputStream out = res.getOutputStream();
			FileInputStream fis = new FileInputStream(filename);
			writeData(fis, out);
			return;
		}
        if(type.equals("downclasses")){
			String filename = HeadConst.root_file_path+ "/main/upload/template/class.xls";
			setHeaderName(res,"班级信息导入模板.xls", "xls");
			javax.servlet.ServletOutputStream out = res.getOutputStream();
			FileInputStream fis = new FileInputStream(filename);
			writeData(fis, out);
			return;
		}
    }
    
   
	    public void setHeaderName(HttpServletResponse res, String name, String style)
	    throws ServletException, IOException
	{
	    String fn = name;
	    String[] fileNames = Tool.split(".", name);
	    String postfix = "";
	       // System.out.println("AttachNameLen=" + fileNames[0].length());
	        //if (fileNames.length > 1 && fileNames[0].length() <= 16) {
	        //    postfix = fileNames[fileNames.length - 1].toLowerCase();
	            fn = new String(name.getBytes("GBK"), "iso8859-1");
	        /*} else {
	            if (fileNames.length > 1 && fileNames[0].length() % 2 ==0) {
	                fn = URLEncoder.encode(fileNames[0].substring(fileNames[0].length()-16,fileNames[0].length()) + "." + fileNames[1],"UTF-8");
	            } else if(fileNames.length > 1 && fileNames[0].length() % 2 ==1) {
	                fn = URLEncoder.encode(fileNames[0].substring(fileNames[0].length()-15,fileNames[0].length()) + "." + fileNames[1],"UTF-8");
	            } else {
	                fn = "attach.bin";
	            }
	        }*/
	        if (style.equals("") || style.equals("application/octet-stream")) {
	            res.setContentType("application/x-download");
	            res.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\"");  
	        } else {
	            res.setContentType(style);
	            res.setHeader("Content-Disposition", "filename=\"" + fn + "\"");
	        }
	}
    public void writeData(InputStream bis, OutputStream os)
    {
        try {
            byte buffer[] = new byte[1024];
            for(int length = -1; (length = bis.read(buffer, 0, 1024)) != -1;)
                os.write(buffer, 0, length);
            bis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
