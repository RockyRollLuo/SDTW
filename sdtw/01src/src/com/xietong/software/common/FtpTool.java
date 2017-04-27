package com.xietong.software.common;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.io.*;
import com.xietong.software.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FtpTool{
    private static Log log = LogFactory.getLog(FtpTool.class);
    private FtpTool() {
    }
    //创建目录    
    public static boolean makeDir(String hostname,String username,String password, String directory){
        boolean reply=false;
        FTPClient ftp=new FTPClient();
        try {
            int flag;
            ftp.connect(hostname);
            System.out.println("Connected to " + hostname + ".");
            System.out.print("connected to reply="+ftp.getReplyString());      
            flag = ftp.getReplyCode();
            if(!FTPReply.isPositiveCompletion(flag)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            } else if (!ftp.login(username, password)) { // 尝试登陆
                System.out.print("Login failed");
                reply = false;
            } else {
                System.out.print("Remote system is " + ftp.getSystemName());
                reply = ftp.makeDirectory(directory);//创建目录
            }
            ftp.logout();
        } catch (Exception e) {
            e.printStackTrace();
            reply = true;
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {                   
                }
            }
        }       
        return reply;
    }
    //删除文件         
    public static boolean delAllFile(String hostname,String username,String password, String directory){
        boolean reply=false;
        FTPClient ftp=new FTPClient();
        try {
            int flag;
            ftp.connect(hostname);
            System.out.println("Connected to " + hostname + ".");
            System.out.print("connected to reply="+ftp.getReplyString());      
            flag = ftp.getReplyCode();
            if(!FTPReply.isPositiveCompletion(flag)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            } else if (!ftp.login(username, password)) { // 尝试登陆
                System.out.print("Login failed");
                reply = false;
            } else {
                System.out.print("Remote system is " + ftp.getSystemName());
                reply = ftp.deleteFile(directory);//删除文件                     
            }
            ftp.logout();
        } catch (Exception e) {
            e.printStackTrace();
            reply = true;
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {                   
                }
            }
        }       
        return reply;
    }
    //删除目录         
    public static boolean delDirectory(String hostname,String username,String password, String directory){
        boolean reply=false;
        FTPClient ftp=new FTPClient();
        try {
            int flag;
            ftp.connect(hostname);
            System.out.println("Connected to " + hostname + ".");
            System.out.print("connected to reply="+ftp.getReplyString());      
            flag = ftp.getReplyCode();
            if(!FTPReply.isPositiveCompletion(flag)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            } else if (!ftp.login(username, password)) { // 尝试登陆
                System.out.print("Login failed");
                reply = false;
            } else {
                System.out.print("Remote system is " + ftp.getSystemName());
                reply = ftp.removeDirectory(directory);//删除目录                     
            }
            ftp.logout();
        } catch (Exception e) {
            e.printStackTrace();
            reply = true;
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {                   
                }
            }
        }       
        return reply;
    }
    //上传和下载文件         
    public static boolean uploadAnddownloadFile(String server, String username, String password, String remote, String local, boolean storeFile, boolean binaryTransfer) {
        // 宣告 FTPClient
        FTPClient ftp;
        boolean rtn = true;

        // new FTPClient() 这个 instance
        ftp = new FTPClient();

        try {
            int reply;
            // 连结到 server
            ftp.setControlEncoding("gbk");
            ftp.connect(server);
            log.debug("Connected to " + server + ".");

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftp.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                log.debug("FTP server refused connection.");
                rtn = false;
            } else if (!ftp.login(username, password)) { // 尝试登陆
                log.debug("Login failed");
                rtn = false;
            } else {
                log.debug("Remote system is " + ftp.getSystemName());

                // 设置传输 ASCII 或 BINARY
                if (binaryTransfer)
                    ftp.setFileType(FTP.BINARY_FILE_TYPE);

                // Use passive mode as default because most of us are
                // behind firewalls these days.
                ftp.enterLocalPassiveMode();

                // 设置下载或上传
                if (storeFile) {//上传
                    InputStream input;

                    input = new FileInputStream(local);
                    rtn = ftp.storeFile(remote, input);
                    input.close();
                } else {
                    OutputStream output;

                    output = new FileOutputStream(local);
                    rtn = ftp.retrieveFile(remote, output);//下载
                    output.close();
                }
            }
            ftp.logout();
        } catch (CopyStreamException e) {
            log.debug("Copy Stream failed.");
            e.printStackTrace();
            rtn = false;
        } catch (FTPConnectionClosedException e) {
            log.debug("Server closed connection.");
            e.printStackTrace();
            rtn = false;
        } catch (IOException e) {
            e.printStackTrace();
            rtn = false;
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {
                    // do nothing
                }
            }
        }
        return rtn;
    }

}

