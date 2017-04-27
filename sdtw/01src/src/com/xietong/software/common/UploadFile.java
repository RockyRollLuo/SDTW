//自动生成的程序，请不要修改，下次生成的时候会覆盖
package com.xietong.software.common;

import java.io.*;
import java.util.*;
import com.xietong.software.system.*;
import com.xietong.software.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 这是自动生成的对UPLOADFILE表的封装类
 *
 *@author 苏卫新
 *@author DBbean.py
 *
*/
public class UploadFile {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(UploadFile.class);
    // 设定在调用clone方法的时候，包含在这个列表中的属性将不被复制
    private String[] noChangeList = {"id"};
    private String[] getNoChangeList() { return noChangeList; }
    public void setNoChangeList(String[] aNoChangeList) { noChangeList = aNoChangeList; }
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    protected int userId = -1;
    public int getUserId() { return userId; }
    public void setUserId(int aUserId) { userId = aUserId; }
    protected java.util.Date postDate = new java.util.Date();
    public java.util.Date getPostDate() { return postDate; }
    public void setPostDate(java.util.Date aPostDate) { postDate = aPostDate; }
    protected String realName = "";
    public String getRealName() { if((realName==null)||(realName.trim().length() == 0)) return ""; else return (realName.trim()); }
    public String getRealName(int size) { if((realName==null)||(realName.trim().length() == 0)) return ""; else if (realName.trim().length() <= size) { return (realName).trim();} else { return (realName).trim().substring(0, size) + "...";} }
    public void setRealName(String aRealName) { realName = aRealName; }
    protected String type = "";
    public String getType() { if((type==null)||(type.trim().length() == 0)) return ""; else return (type.trim()); }
    public String getType(int size) { if((type==null)||(type.trim().length() == 0)) return ""; else if (type.trim().length() <= size) { return (type).trim();} else { return (type).trim().substring(0, size) + "...";} }
    public void setType(String aType) { type = aType; }
    protected int size = -1;
    public int getSize() { return size; }
    public void setSize(int aSize) { size = aSize; }
    protected String fileName = " ";
    public String getFileName() { if((fileName==null)||(fileName.trim().length() == 0)) return ""; else return (fileName.trim()); }
    public String getFileName(int size) { if((fileName==null)||(fileName.trim().length() == 0)) return ""; else if (fileName.trim().length() <= size) { return (fileName).trim();} else { return (fileName).trim().substring(0, size) + "...";} }
    public void setFileName(String aFileName) { fileName = aFileName; }
    protected int flag = -1;
    public int getFlag() { return flag; }
    public void setFlag(int aFlag) { flag = aFlag; }
    public UploadFile ()
    {
    }
    /**
     * 提交的form中的输入域名符合数据库字段名，将被赋值给对应的映射属性。
     * @param request包含从http请求提交过来的form信息
     * @return UploadFile类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public UploadFile getByParameterDb(javax.servlet.http.HttpServletRequest request)
    {
        UploadFile v = new UploadFile();
        v.setId(ParamUtils.getIntParameter(request,"id",-1));
        v.setUserId(ParamUtils.getIntParameter(request,"user_id",-1));
        v.setPostDate(ParamUtils.getDateTimeParameter(request,"post_date",(new java.util.Date())));
        v.setRealName(ParamUtils.getParameter(request,"realname",""));
        v.setType(ParamUtils.getParameter(request,"filetype",""));
        v.setSize(ParamUtils.getIntParameter(request,"filesize",-1));
        v.setFileName(ParamUtils.getParameter(request,"filename"," "));
        v.setFlag(ParamUtils.getIntParameter(request,"flag",-1));
        return v;
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return UploadFile类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public UploadFile getByParameterBean(javax.servlet.http.HttpServletRequest request)
    {
        UploadFile v = new UploadFile();
        v.setId(ParamUtils.getIntParameter(request,"id",-1));
        v.setUserId(ParamUtils.getIntParameter(request,"userId",-1));
        v.setPostDate(ParamUtils.getDateTimeParameter(request,"POST_DATE",(new java.util.Date())));
        v.setRealName(ParamUtils.getParameter(request,"realName",""));
        v.setType(ParamUtils.getParameter(request,"type",""));
        v.setSize(ParamUtils.getIntParameter(request,"size",-1));
        v.setFileName(ParamUtils.getParameter(request,"fileName"," "));
        v.setFlag(ParamUtils.getIntParameter(request,"flag",-1));
        return v;
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(UploadFile bean)
    {
        if (!Tool.inArray("id", noChangeList)) {
            setId(bean.getId());
        }
        if (!Tool.inArray("userId", noChangeList)) {
            setUserId(bean.getUserId());
        }
        if (!Tool.inArray("postDate", noChangeList)) {
            setPostDate(bean.getPostDate());
        }
        if (!Tool.inArray("realName", noChangeList)) {
            setRealName(bean.getRealName());
        }
        if (!Tool.inArray("type", noChangeList)) {
            setType(bean.getType());
        }
        if (!Tool.inArray("size", noChangeList)) {
            setSize(bean.getSize());
        }
        if (!Tool.inArray("fileName", noChangeList)) {
            setFileName(bean.getFileName());
        }
        if (!Tool.inArray("flag", noChangeList)) {
            setFlag(bean.getFlag());
        }
    }
}
