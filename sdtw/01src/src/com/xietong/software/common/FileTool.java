package com.xietong.software.common;

import java.io.*;
import java.util.*;
import java.util.zip.*;

import org.apache.commons.net.ftp.*;
import org.apache.commons.net.io.*;

import com.xietong.software.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  目录文件操纵控制类。
 */
public class FileTool {
    private static Log log = LogFactory.getLog(FileTool.class);
    private FileTool() {
    }

    /**
     *  复制原文件sourcefile到目的文件targetfile。
     *  @param sourcefile 源文件名。
     *  @param targetfile 目标文件名。
     */
    public static void copy(String sourcefile, String targetfile) throws IOException {
        File inputFile = new File(sourcefile);
        File outputFile = new File(targetfile);

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);
        int c;

        while ((c = in.read()) != -1)
            out.write(c);

        in.close();
        out.close();
    }

    /**
     *  复制原文件sourcefile到目的文件targetfile(二进制方式)。hjl添加
     *  @param sourcefile 源文件名。
     *  @param targetfile 目标文件名。
     */    
    public static void  copyFile(String  sourcefile,  String  targetfile)  {  
        try  {  
            int  bytesum  =  0;  
            int  byteread  =  0;  
            File  oldfile  =  new  File(sourcefile);  
            if  (oldfile.exists())  {  //文件存在时  
                InputStream  inStream  =  new  FileInputStream(sourcefile);  //读入原文件  
                FileOutputStream  fs  =  new  FileOutputStream(targetfile);  
                byte[]  buffer  =  new  byte[1444];  
                int  length;  
                while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
                    bytesum  +=  byteread;  //字节数  文件大小  
                    System.out.println(bytesum);  
                    fs.write(buffer,  0,  byteread);  
                } 
                fs.flush();
                fs.close();
                inStream.close();  
            }  
        }  
        catch  (Exception  e)  {  
            System.out.println("复制文件操作出错");  
            e.printStackTrace();  
  
        }  
  
    }  

    
    /**
     *  移动原文件sourcefile到目的文件targetfile。
     *  @param sourcefile 源文件名。
     *  @param targetfile 目标文件名。
     */
    public static void move(String sourcefile, String targetfile) throws IOException {
        copy(sourcefile, targetfile);
        delete(sourcefile);
    }

    /**
     *  测试指定文件名的文件是否存在。
     *  @param filename 测试的文件名。
     *  @return 如果文件存在返回真，否则返回假。
     */
    public static boolean exists(String filename) {
        return (new File(filename)).exists();
    }
    //创建文件夹
    public static void createDir(String dirname) {
        File d=new File(dirname);//建立代表Sub目录的File对象，并得到它的一个引用 
        d.mkdir();//建立Sub目录 
    }
  //创建多层文件夹
    public static void createDirs(String dirname) {
        File d=new File(dirname);//建立代表Sub目录的File对象，并得到它的一个引用 
        d.mkdirs();//建立Sub目录 
    }
    /**
     *  读入指定文件名的文本文件内容。
     *  @param filename 要读入的文本文件名。
     *  @return 如果文件存在，将文件内容返回，否则返回长度为零的字符串。
     */
    public static String read(String filename) {
        String str = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String tmp;
            while ((tmp = in.readLine()) != null) {
                str = str + tmp + "\n";
            }
            in.close();
        } catch (IOException e) {
        }
        return str;
    }
    
    public static void existsAndCreateDir(String dirname) {
		if ((new File(dirname)).exists()) {
		} else {
			createDir(dirname);
		}
	}

    /**
     *  读入指定文件名的文本文件内容（指定长度内）。
     *  @param filename 要读入的文本文件名。
     *  @param size 要读入的字符串最大长度。
     *  @return 如果文件存在，将不大于指定长度的文件内容返回，
     *  否则返回长度为零的字符串。
     */
    public static String read(String filename, int size) {
        String str = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String tmp;
            while ((tmp = in.readLine()) != null) {
                str = str + tmp + "\n";
                if (str.length() >= size) {
                    break;
                }
            }
            in.close();
        } catch (IOException e) {
        }
        return str;
    }

    /**
     *  读入指定目录中所有非目录的文件名列表。
     *  @param directoryName 要读入的文件名列表的目录名。
     *  @return 包含文件名列表的字符串数组。
     */
    public static String[] readdir(String directoryName)
    {
        File dir = new File(directoryName);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                File file = new File(dir.getPath() + "/" + name);
                return !file.isDirectory();
            }
        };
        return dir.list(filter);
    }

    /**
     *  读入指定目录中所有目录名列表。
     *  @param directoryName 要读入的目录名列表的目录名。
     *  @return 包含目录名列表的字符串数组。
     */
    public static String[] readDirectory(String directoryName)
    {
        File dir = new File(directoryName);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                File file = new File(dir.getPath() + "/" + name);
                return file.isDirectory();
            }
        };
        return dir.list(filter);
    }

    /**
     *  读入指定目录中所有目录名和文件名列表。
     *  @param directoryName 要读入的目录名列表的目录名。
     *  @return 包含目录名列表的字符串数组和标记。
     */
    public static File[] readAllDirectory(String directoryName)
    {
        File dir = new File(directoryName);
        return dir.listFiles();
    }

    /**
     *  删除指定文件。
     *  @param filename 删除指定文件的名字。
     *  @return 如果文件被删除，返回真
     *  否则返回长度为零的字符串。
     */
    public static boolean delete(String filename)
    {
        return (new File(filename)).delete();
    }

    public static String base64EncodeFile(String filename)
    {
        return Base64.encodeFromFile(filename);
    }
    public static int write(String filename, String data, String strEncode) {
		try {
			/*
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(data);
			out.close();
			*/
			BufferedWriter writer = null;
			File file = new File(filename);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), strEncode));
            writer.write(data);
            writer.flush();
            writer.close();
		} catch (IOException e) {
		}
		return data.length();
	}
	
	public static int write(String filename, String data) {
		return write(filename,data,"gbk");
	}
    
    public static int append(String filename, String data)
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
            out.write(data);
            out.close();
        } catch (IOException e) {
        }
        return data.length();
    }
    public static int writeLogs(String filename, String data)
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
            out.write(data + "\n");
            out.close();
        } catch (IOException e) {
        }
        return data.length();
    }
    public static int write(String filename, InputStream data)
    {
        int rtn = 0;
        try {
            FileOutputStream out = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            int readLength = -1;
            while ((readLength = data.read(buffer)) != -1) {
                out.write(buffer, 0, readLength);
                rtn += readLength;
            }
            out.close();
        } catch (IOException e) {
        }
        return rtn;
    }
    public static boolean testFtp(String server, String username, String password) {
        FTPClient ftp;

        // new FTPClient() 这个 instance
        ftp = new FTPClient();
        boolean rtn = true;

        try {
            ftp.connect(server);
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                log.debug("FTP server refused connection.");
                rtn = false;
            } else if (!ftp.login(username, password)) { // 尝试登陆
                log.debug("Login failed");
                rtn = false;
            } else {
                log.debug("Remote system is " + ftp.getSystemName());
            }
            ftp.logout();
        } catch (Exception e) {
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
    public static boolean createFtpPath(String server, String username, String password, String path) {
        FTPClient ftp;

        // new FTPClient() 这个 instance
        ftp = new FTPClient();
        boolean rtn = true;

        try {
            ftp.connect(server);
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                log.debug("FTP server refused connection.");
                rtn = false;
            } else if (!ftp.login(username, password)) { // 尝试登陆
                log.debug("Login failed");
                rtn = false;
            } else {
                log.debug("Remote system is " + ftp.getSystemName());
                rtn = ftp.makeDirectory(path);
            }
            ftp.logout();
        } catch (Exception e) {
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
    public static boolean ftp(String server, String username, String password, String remote, String local, boolean storeFile, boolean binaryTransfer) {
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
                if (storeFile) {
                    InputStream input;

                    input = new FileInputStream(local);
                    rtn = ftp.storeFile(remote, input);
                    input.close();
                } else {
                    OutputStream output;

                    output = new FileOutputStream(local);
                    rtn = ftp.retrieveFile(remote, output);
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
    /**
     * 压缩文件列表filelist中包含的文件到filename指定的文件中去。
     * 返回0表示成功，-1表示失败。
     */
    public static int zipFiles(String filename, List filelist)
    {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];

        try {
            // Create the ZIP file
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(filename));

            // Compress the files
            for (Iterator it = filelist.iterator(); it.hasNext(); ) {
                String fn = (String)it.next();
                FileInputStream in = new FileInputStream(fn);

                // Add ZIP entry to output stream.
                File f = new File(fn);
                out.putNextEntry(new ZipEntry(f.getName()));

                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                // Complete the entry
                out.closeEntry();
                in.close();
            }

            // Complete the ZIP file
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
