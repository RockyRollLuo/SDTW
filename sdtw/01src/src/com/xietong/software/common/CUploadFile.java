package com.xietong.software.common;

import com.xietong.software.util.*;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


//import com.xietong.software.website.Img2;


public class CUploadFile
{
	private static final long SIZEMAX = 0x3200000L;
	private long maxSize;
	private String savePath;
	private String repositoryPath;
	private String saveName;
	private String paramName;
	private String saveTotalName;
	private String realName ;
	private long limitSize=-1;
	static Log log = LogFactory.getLog(Log.class);

	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @param paramName
	 *            the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @return the maxSize
	 */
	public long getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize
	 *            the maxSize to set
	 */
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the fileRealName
	 */
	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @param savePath
	 *            the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return the repositoryPath
	 */
	public String getRepositoryPath() {
		return repositoryPath;
	}

	/**
	 * @param repositoryPath
	 *            the repositoryPath to set
	 */
	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	/**
	 * @return the saveName
	 */
	public String getSaveName() {
		return saveName;
	}

	/**
	 * @param saveName
	 *            the saveName to set
	 */
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
	/**
	 * @return the saveTotalName
	 */
	public String getSaveTotalName() {
		return saveTotalName;
	}
	
	
	/**上传文件名
	 * @return
	 */
	public String getRealName(){
		return realName;
	}
    private static final int MAXMEMORYSIZE = 102400;
    private CUploadFile()
    {
    }
    public CUploadFile(String paramName, String saveName, String savePath) {
		this(paramName, saveName, savePath, savePath, SIZEMAX);
	}

	public CUploadFile(String paramName, String savePath) {
		this(paramName, "", savePath);
	}

	public CUploadFile(String savePath) {
		this("", "", savePath);
	}
	/**
	 * 
	 * @param paramName
	 *            上传文件在form中的name
	 * @param saveName
	 *            上传文件保存时的文件名
	 * @param savePath
	 *            上传文件保存路径
	 * @param repositoryPath
	 *            临时路径
	 * @param maxSize
	 *            上传文件最大尺寸
	 */
	public CUploadFile(String paramName, String saveName, String savePath,
			String repositoryPath, long maxSize) {
		this(paramName, saveName,savePath,repositoryPath,maxSize,-1);
	}
	public CUploadFile(String paramName, String saveName, String savePath,
			String repositoryPath, long maxSize,long limitSize) {
		this.setParamName(paramName);
		this.setSaveName(saveName);
		this.setSavePath(savePath);
		this.setRepositoryPath(repositoryPath);
		this.setMaxSize(maxSize);
		this.setlimitSize(limitSize);
	}

    public static List save(HttpServletRequest request, String paramName)
    {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        List ufs = new ArrayList();
        if(isMultipart)
        {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MAXMEMORYSIZE);
            factory.setRepository(new File(HeadConst.root_file_path + "/main/upload/temp"));
            System.out.println(HeadConst.root_file_path + "/main/upload/temp");
            ServletFileUpload upload = new ServletFileUpload(factory);
            UserInfo ui = Tool.getUserInfo(request);
            upload.setSizeMax(0x3200000L); //80M
            UploadProgressListener progressListener = new UploadProgressListener();
            request.getSession().setAttribute("Progress", progressListener);
            upload.setProgressListener(progressListener);
            try
            {
                List items = upload.parseRequest(request);
                for(Iterator iter = items.iterator(); iter.hasNext();)
                {
                    FileItem item = (FileItem)iter.next();
                    if(item.getFieldName().equals(paramName) && !item.isFormField())
                        ufs.add(process(ui, item));
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return ufs;
    }

    public static UploadFile process(UserInfo ui, FileItem item)
        throws Exception
    {
        UploadFile uf = new UploadFile();
        uf.setUserId(ui.getId());
        uf.setRealName(FilenameUtils.getName(item.getName()));
        uf.setType(item.getContentType());
        uf.setSize((int)item.getSize());
        uf.setFlag(0);
        uf.setFileName(HeadConst.root_file_path + "/main/upload/temp/" + stringOfDateTime() + "_" + ui.getId());
        File uploadedFile = new File(uf.getFileName());
        item.write(uploadedFile);
        return uf;
    }
	public static String getFileName(String fn) {
		String[] fns = Tool.split("\\", fn);
		return fns[fns.length - 1];
	}

	public static String getFileExt(String fn) {
		String[] fns = Tool.split(".", fn);
		if (fns.length < 2) {
			return "";
		} else {
			return "." + fns[fns.length - 1];
		}
	}
	public UploadFile processinfo(UserInfo ui, FileItem item)
	throws java.lang.Exception {
	UploadFile uf = new UploadFile();
	if(ui!=null){
		uf.setUserId(ui.getId());
	}
	uf.setRealName(getFileName(item.getName()));
	uf.setType(item.getContentType());
	uf.setSize((int) item.getSize());
	uf.setFlag(0);
	if (this.getSaveName().equals("")) {// 没有指定保存文件的名字，用上传文件的名称保存文件
		if(FileTool.exists(HeadConst.root_file_path + "/" + this.getSavePath())){
			FileTool.delete(HeadConst.root_file_path + "/" + this.getSavePath());
		}
		FileTool.createDir(HeadConst.root_file_path + "/" + this.getSavePath());
		uf.setFileName(HeadConst.root_file_path + "/" + this.getSavePath()
				+ "/" + getFileName(item.getName()));
		this.setSaveTotalName(getFileName(item.getName()));
		this.realName = getFileName(item.getName());
	} else {//注意：指定的文件名没有后缀名，item.getName有后缀名
		if(FileTool.exists(HeadConst.root_file_path + "/" + this.getSavePath())){
			FileTool.delete(HeadConst.root_file_path + "/" + this.getSavePath());
		}
		FileTool.createDir(HeadConst.root_file_path + "/" + this.getSavePath());
		uf.setFileName(HeadConst.root_file_path + "/" + this.getSavePath()
				+ "/" + this.getSaveName() + getFileExt(item.getName()));
		this.setSaveTotalName(this.getSaveName() + getFileExt(item.getName()));
		this.realName = getFileName(item.getName());
	}
	File uploadedFile = new File(uf.getFileName());
	item.write(uploadedFile);
	/*
	 * 二次server存储图片
	 */
	//String name2="E:/webbak/jnjsxy/01src/web";
	String name2="E:/jnjsxy/01src/web";
	UploadFile uf2=uf;
	if(FileTool.exists(name2 + "/" + this.getSavePath())){
		FileTool.delete(name2 + "/" + this.getSavePath());
	}
//	FileTool.createDir(name2 + "/" + this.getSavePath());
	String desName=name2 + "/" + this.getSavePath()	+ "/" + this.getSaveName() + getFileExt(item.getName());
	//Img2.copyFile(uf.getFileName(), desName);
	//uf2.setFileName(name2 + "/" + this.getSavePath()
	//		+ "/" + this.getSaveName() + getFileExt(item.getName()));
	//File uploadedFile2 = new File(uf2.getFileName());
	//item.write(uploadedFile2);
	/*
	 * end 
	 */
	return uf;
	}
	public int save(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		int ufs = -1;
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MAXMEMORYSIZE);
			factory.setRepository(new File(HeadConst.root_file_path
					+ this.getRepositoryPath()));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			UserInfo ui = Tool.getUserInfo(request);
			upload.setSizeMax(this.getMaxSize());
			UploadProgressListener progressListener = new UploadProgressListener();
			request.getSession().setAttribute("Progress", progressListener);
			upload.setProgressListener(progressListener);
			try {
				List items = upload.parseRequest(request);
				System.out.println(items.size());
				for (int i = 0; i < items.size(); i++) {
					FileItem fi = (FileItem) items.get(i);
					String ext = getFileExt(fi.getName()).toLowerCase();
					if (this.getParamName().equals("")) {
						if(ext.equals(".jsp") || ext.equals(".jspx")){//jsp文件
							ufs = 2;
						}else if (!fi.isFormField()) {
							processinfo(ui, fi);
							ufs = 1;
						}
					} else {
						if (fi.getFieldName().equals(paramName)&& !fi.isFormField()) {
							if(this.limitSize>0&&fi.getSize()>this.limitSize){
								ufs=0;
							}else if(ext.equals(".jsp")||ext.equals(".jspx")){//jsp文件
								ufs = 2;
							}else{
							log.debug(paramName);
							processinfo(ui, fi);
								ufs = 1;
							}
						}
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ufs;
	}
	
	public UploadFile saveForUp(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		UploadFile uf = new UploadFile();
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MAXMEMORYSIZE);
			factory.setRepository(new File(HeadConst.root_file_path
					+ this.getRepositoryPath()));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			UserInfo ui = Tool.getUserInfo(request);
			upload.setSizeMax(this.getMaxSize());
			UploadProgressListener progressListener = new UploadProgressListener();
			request.getSession().setAttribute("Progress", progressListener);
			upload.setProgressListener(progressListener);
			
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fi = (FileItem) items.get(i);
					String ext = getFileExt(fi.getName()).toLowerCase();
					if (this.getParamName().equals("")) {
						if (!fi.isFormField()) {
							if(!ext.equals(".jsp") && !ext.equals(".jspx")){//jsp文件
								uf = processinfo(ui, fi);
								uf.setFlag(1);
							}else{
								uf.setFlag(2);
							}
						}
					} else {
						if (fi.getFieldName().equals(paramName)&& !fi.isFormField()) {
							if(this.limitSize>0&&fi.getSize()>this.limitSize){
								uf.setFlag(0);
							}else{
							log.debug(paramName);
								if(!ext.equals(".jsp") && !ext.equals(".jspx")){//jsp文件
									uf = processinfo(ui, fi);
									uf.setFlag(1);
								}else{
									uf.setFlag(2);
								}
							}
						}
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return uf;
	}
	
    public InputStream saveFileStream(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		InputStream inputStream  = null;
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MAXMEMORYSIZE);
			factory.setRepository(new File(HeadConst.root_file_path
					+ this.getRepositoryPath()));
			ServletFileUpload upload = new ServletFileUpload(factory);
			UserInfo ui = Tool.getUserInfo(request);
			upload.setSizeMax(this.getMaxSize());
			UploadProgressListener progressListener = new UploadProgressListener();
			request.getSession().setAttribute("Progress", progressListener);
			upload.setProgressListener(progressListener);
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fi = (FileItem) items.get(i);
					if (this.getParamName().equals("")) {// 不指定特殊上传的文件，只要是文件都上传
						if (!fi.isFormField()) {
							if(this.limitSize>0&&fi.getSize()>this.limitSize)
							{
								this.setSaveTotalName("0");//文件大小标记超出限制大小
								return null;
							}
							else{
								this.setSaveName(getFileName(fi.getName()));//文件名字
								this.setSavePath(fi.getContentType());//文件扩展名
								this.setSaveTotalName(fi.getSize()+"");//文件大小
								return fi.getInputStream();
							}
						}
					} else {
						if (fi.getFieldName().equals(paramName)
								&& !fi.isFormField()) {// 只上传指定的文件
							if(this.limitSize>0&&fi.getSize()>this.limitSize){
								this.setSaveTotalName("0");//文件大小标记超出限制大小
								return null;
							}
							else{
								this.setSaveName(getFileName(fi.getName()));//文件名字
								this.setSavePath(fi.getContentType());//文件扩展名
								this.setSaveTotalName(fi.getSize()+"");//文件大小
								return fi.getInputStream();
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * @param saveTotalName the saveTotalName to set
	 */
	public void setSaveTotalName(String saveTotalName) {
		this.saveTotalName = saveTotalName;
	}
	
	public void setlimitSize(long alimitSize) {
		this.limitSize = alimitSize;
	}
	public long getlimitSize(long alimitSize) {
		return limitSize;
	}
	 public static int save(HttpServletRequest request, String paramName,String fileName)
	    {
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	        int ufs = -1;
	        if(isMultipart)
	        {
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            factory.setSizeThreshold(MAXMEMORYSIZE);
	            factory.setRepository(new File(HeadConst.root_file_path + "/main/images/sign/"));
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            UserInfo ui = Tool.getUserInfo(request);
	            upload.setSizeMax(0x3200000L);
	            UploadProgressListener progressListener = new UploadProgressListener();
	            request.getSession().setAttribute("Progress", progressListener);
	            upload.setProgressListener(progressListener);
	            try
	            {
	                List items = upload.parseRequest(request);
	                if(items.size()==2){
	                    FileItem item0 = (FileItem)items.get(0);
	                    FileItem item1 = (FileItem)items.get(1);
	                    //System.out.println("fileName="+item1.getFieldName());
	                    if(item0.getFieldName().equals(paramName) && !item0.isFormField()){
	                    	String ext = getFileExt(item1.getName()).toLowerCase();
	                    	if(!ext.equals(".jsp") && !ext.equals(".jspx")){//jsp文件{
		                        process(ui, item0,item1.getFieldName());
		                        ufs=1;
	                    	}
	                    }
	                }
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
	        return ufs;
	    }
    
    public static UploadFile process(UserInfo ui, FileItem item,String fileName)throws Exception{
    	UploadFile uf = new UploadFile();
    	uf.setUserId(ui.getId());
    	uf.setRealName(FilenameUtils.getName(item.getName()));
    	uf.setType(item.getContentType());
    	uf.setSize((int)item.getSize());
    	uf.setFlag(0);
    	uf.setFileName(HeadConst.root_file_path + "/main/images/sign/" + fileName);
    	File uploadedFile = new File(uf.getFileName());
    	item.write(uploadedFile);
    	return uf;
    }
    

    
    public static List save(HttpServletRequest request, String paramName ,int flag) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        List ufs = new ArrayList();
        if (isMultipart) {
            // Create a new file upload handler
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Set upload parameters
            factory.setSizeThreshold(MAXMEMORYSIZE);
            if(flag==1)
                factory.setRepository(new File(HeadConst.root_file_path + "/weboa/upload/broad"));
            else
                factory.setRepository(new File(HeadConst.root_file_path + "/site/upload"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            UserInfo ui = Tool.getUserInfo(request);

            upload.setSizeMax(10485760);
            UploadProgressListener progressListener = new UploadProgressListener();
            request.getSession().setAttribute("Progress", progressListener);
            upload.setProgressListener(progressListener);
            // Parse the request
            try {
                List items = upload.parseRequest(request);

                // Process the uploaded items
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.getFieldName().equals(paramName)&&!item.isFormField()) {
                        ufs.add(process(ui, item,flag));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ufs;
    }
    //jinxz 2005/3/4 鍏憡鏉縗缃戠珯鍥剧墖銆侀檮浠朵笂浼�
    public static UploadFile process(UserInfo ui, FileItem item,int flag) 
        throws java.lang.Exception 
    {
        UploadFile uf = new UploadFile();
        uf.setUserId(ui.getId());
        uf.setRealName(FilenameUtils.getName(item.getName()));
        uf.setType(item.getContentType());
        uf.setSize((int)item.getSize());
        uf.setFlag(0);
        String[] path_parts = Tool.explode(".", uf.getRealName());
        if(flag==1)
          uf.setFileName(HeadConst.root_file_path + "/weboa/upload/broad/" + stringOfDateTime() + "_" + ui.getId()+"."+path_parts[path_parts.length-1]);
        else
          uf.setFileName(HeadConst.root_file_path + "/site/upload/" + stringOfDateTime() + "_" + ui.getId()+"."+path_parts[path_parts.length-1]);
        File uploadedFile = new File(uf.getFileName());
        item.write(uploadedFile);
        return uf;
    }
    public static String stringOfDateTime()
    {
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date());
    }

    public static List saveSiteUpload(HttpServletRequest request, String paramName)
    {
        UserInfo ui = Tool.getUserInfo(request);
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        List ufs = new ArrayList();
        String savePath = HeadConst.root_file_path + "/site/upload/" + ui.getDbname();
        if(isMultipart)
        {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MAXMEMORYSIZE);
            factory.setRepository(new File(savePath));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(0xa00000L);
            UploadProgressListener progressListener = new UploadProgressListener();
            request.getSession().setAttribute("Progress", progressListener);
            upload.setProgressListener(progressListener);
            try
            {
                List items = upload.parseRequest(request);
                for(Iterator iter = items.iterator(); iter.hasNext();)
                {
                    FileItem item = (FileItem)iter.next();
                    if(item.getFieldName().equals(paramName) && !item.isFormField())
                    {
                        UploadFile uf = new UploadFile();
                        uf.setUserId(ui.getId());
                        uf.setRealName(FilenameUtils.getName(item.getName()));
                        uf.setType(item.getContentType());
                        uf.setSize((int)item.getSize());
                        uf.setFlag(0);
                        uf.setFileName(savePath + "/" + stringOfDateTime() + "_" + ui.getId() + getFileExt(item.getName()));
                        File uploadedFile = new File(uf.getFileName());
                        item.write(uploadedFile);
                        ufs.add(uf);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ufs;
    }
    public static String saveOaModuleCellFile(HttpServletRequest request, String paramName, String prefixName, String path, String fileName)
    {
        UserInfo ui = Tool.getUserInfo(request);
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String rtn = fileName;
        String savePath = HeadConst.root_file_path + path + "/";
        System.out.println(savePath);
        if(isMultipart)
        {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MAXMEMORYSIZE);
            factory.setRepository(new File(savePath));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(0x2000000L);
            UploadProgressListener progressListener = new UploadProgressListener();
            request.getSession().setAttribute("Progress", progressListener);
            upload.setProgressListener(progressListener);
            try
            {
                List items = upload.parseRequest(request);
                for(Iterator iter = items.iterator(); iter.hasNext();)
                {
                    FileItem item = (FileItem)iter.next();
                    if(item.getFieldName().equals(prefixName) && item.isFormField())
                    {
                        savePath = savePath + item.getString() + "_";
                        rtn = item.getString() + "_" + fileName;
                    }
                }
                savePath = savePath + fileName;
                for(Iterator iter = items.iterator(); iter.hasNext();)
                {
                    FileItem item = (FileItem)iter.next();
                    if(item.getFieldName().equals(paramName) && !item.isFormField())
                    {
                        File uploadedFile = new File(savePath);
                        item.write(uploadedFile);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rtn;
    }
 
}
