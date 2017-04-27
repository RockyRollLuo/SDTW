package com.xietong.software.util;

import com.xietong.software.common.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeUtils {
    private static Log log = LogFactory.getLog(CodeUtils.class);
    private int[] splitType = HeadConst.splitType;
    
    public CodeUtils() {}

    public CodeUtils(int[] splitType) {
        this.splitType = splitType;
    }
    public void setSplitType(int[] splitType) {
        this.splitType = splitType;
    }
    public int getFirstLevelLen() {
        return splitType[0];
    }

    private int getMaxLength() {
        int rtn = 0;
        for (int i = 0; i < splitType.length; i ++)
            rtn += splitType[i];
        return rtn;
    }
    public int getLevel(String code) {
        int currlen = 0;
        int len = code.length();
        for (int i = 0; i < splitType.length; i ++) {
            currlen += splitType[i];
            if (currlen == len)
               return (i + 1); 
        }
        return -1;
    }
    public String getPcode(String code) {
        int len = code.length();
        int level = getLevel(code);
        if (level == -1)
            return null;
        StringBuffer rtn = new StringBuffer();
        int index = 0;
        for (int i = 0; i < (level - 1); i ++) {
            for (int j = 0; j < splitType[i]; j ++) {
                rtn.append(code.charAt(index ++));
            }
        }
        return rtn.toString();
    }
    public String[] getCodes(String code) {
        int len = code.length();
        int level = getLevel(code);
        if (level == -1)
            return new String[0];
        String[] rtn = new String[level];
        int index = 0;
        for (int i = 0; i < level; i ++) {
            StringBuffer str = new StringBuffer();
            for (int j = 0; j < splitType[i]; j ++) {
                str.append(code.charAt(index ++));
            }
            rtn[i] = str.toString();
        }
        return rtn;
    }
    public String getNextCode(String code, int level) {
        String[] codes = getCodes(code);
        String[] arr = new String[level];
        for (int i = 0; i < codes.length; i ++) {
            arr[i] = codes[i];
        }
        int sn = 0;
        if (codes.length == level) {
            sn = StrTool.toInt(codes[level - 1]);
        }
        String strSn = "" + (sn + 1);
        //jdk1.4语法
        StringBuffer tmp = new StringBuffer(strSn);
        for (int i = 0; i < splitType[level - 1] - strSn.length(); i ++) {
            tmp.insert(0, "0");
        }
        arr[level - 1] = tmp.toString();
        //jdk1.5语法
        //arr[level - 1] = String.format("%" + splitType[level - 1] + "s", (sn + 1)).replaceAll(" ", "0");
        return Tool.join("", arr);
    }
}
