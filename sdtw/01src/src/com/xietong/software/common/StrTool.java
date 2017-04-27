package com.xietong.software.common;

import java.io.*;
import java.util.*;
import com.xietong.software.util.*;

public class StrTool {

    private StrTool() {
    }

    public static String fromInputStream(InputStream in)
    {
        StringBuffer rtn = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                rtn.append(line + "\r\n");
            }
        } catch (IOException e) {
        }
        return rtn.toString();
    }

    public static InputStream toInputStream(String str)
    {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static String base64Encode(String str)
    {
        String rtn = "";
        try {
            rtn = Base64.encodeString(str);
        } catch (Exception e) {
        }
        return rtn;
    }

    public static String base64Decode(String str)
    {
        String rtn = "";
        try {
            rtn = Base64.decodeToString(str);
        } catch (Exception e) {
        }
        return rtn;
    }

    public static String base64Encode(InputStream in)
    {
        StringBuffer rtn = new StringBuffer();
        try {
            InputStream cin = new Base64.InputStream(in, Base64.ENCODE);
            byte[] buffer = new byte[1024];
            int readLen = -1;
            while ((readLen = cin.read(buffer, 0, 1024)) != -1) {
                rtn.append(new String(buffer, 0, readLen));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return rtn.toString();
    }

    public static InputStream base64DecodeStream(String str)
    {
        InputStream in = new ByteArrayInputStream(str.getBytes());
        InputStream rtn = new Base64.InputStream(in, Base64.DECODE);
        return rtn;
    }

    /*
       本函式将字串 str 代入 haystack 字串中，将所有的 needle 置换成 str。
       */
    public static String strReplace(String needle, String str, String haystack)
    {
        String[] temp = Tool.split(needle, haystack);
        if (temp.length == 1)
            return haystack;
        else
            return Tool.join(str, temp);
    }

    public static int toInt(String str)
    {
        int irtn = -1;
        try {
            irtn=Integer.parseInt(str);
        } catch( NumberFormatException  nume ) {
            nume.printStackTrace();
            return irtn;
        }
        return irtn;
    }

    /**
     *  得到填充表格的数据,用\&nbsp;防止出现空白的单元
     *  @param str 输入要在表格显示的数据。
     *  @return 如果输入的数据长度为零，返回\&nbsp;，
     *  否则返回字符串本身。
     */
   public static String fillTd(String str)
    {
        if (str == null || str.length() == 0) {
            return "&nbsp;";
        } else {
            return str;
        }
    }

    public static boolean inList(String list, String item, String mark)
    {
        return Tool.inArray(item, Tool.split(mark, list));
    }

    public static String chunkSplit(String str)
    {
        return chunkSplit(str, 76);
    }

    public static String chunkSplit(String str, int lsize)
    {
        StringBuffer rtn = new StringBuffer();
        int lines = (int)Math.ceil((double)str.length() / (double)lsize);
        for (int i = 0; i < lines; i ++) {
            int endIndex = (i + 1) * lsize;
            if (endIndex > str.length()) {
                endIndex = str.length();
            }
            rtn.append(str.substring(i * lsize, endIndex));
            rtn.append("\n");
        }
        return rtn.toString();
    }
    public static String getIpAddr(javax.servlet.http.HttpServletRequest request){ 
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        return ip; 
    } 
}

