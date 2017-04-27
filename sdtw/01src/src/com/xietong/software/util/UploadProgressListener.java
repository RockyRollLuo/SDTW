package com.xietong.software.util;

import java.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.fileupload.*;


public class UploadProgressListener implements ProgressListener {

    public class UploadInfo {
        private long bytesRead = 0;
        public void setBytesRead(long aval) {bytesRead = aval;}
        public long getBytesRead() {return bytesRead;}

        private long contentLength = 0;
        public void setContentLength(long aval) {contentLength = aval;}
        public long getContentLength() {return contentLength;}


        private long lastRead = 0;
        public void setLastRead(long aval) {lastRead = aval;}
        public long getLastRead() {return lastRead;}

        private Date currDate = null;
        public void setCurrDate(Date aval) {currDate = aval;}
        public Date getCurrDate() {return currDate;}

        private Date lastDate = null;
        public void setLastDate(Date aval) {lastDate = aval;}
        public Date getLastDate() {return lastDate;}

        private Date beginDate = null;
        public void setBeginDate(Date aval) {beginDate = aval;}
        public Date getBeginDate() {return beginDate;}

        private Date endDate = null;
        public void setEndDate(Date aval) {endDate = aval;}
        public Date getEndDate() {return endDate;}

        private String bps = null;

        public UploadInfo() {
            currDate = new Date();
            lastDate = new Date();
        }

        public Object clone() {
            UploadInfo rtn = new UploadInfo();
            rtn.setBytesRead(bytesRead);
            rtn.setContentLength(contentLength);
            rtn.setLastRead(lastRead);
            rtn.setLastDate(lastDate);
            rtn.setBeginDate(beginDate);
            lastRead = bytesRead;
            lastDate = new Date();
            return rtn;
        }

        public String getPercent() {
            if (contentLength > 0) {
                float rtn = (float)(bytesRead * 100) / (float)contentLength;
                return Math.round(rtn) + "";
            } else {
                return "";
            }
        }

        public String getPartBps() {
            long ms = Math.abs(currDate.getTime() - lastDate.getTime());
            if (ms > 0) {
                float rtn = (float)(bytesRead - lastRead) / (float)(ms / 1000);
                return Math.round(rtn) + "";
            } else {
                return "";
            }
        }

        public String getBps() {
            long ms = Math.abs(currDate.getTime() - beginDate.getTime());
            if (ms > 0) {
                if (endDate == null) {
                    float rtn = (float)(bytesRead) / (float)(ms / 1000);
                    bps = Math.round(rtn) + "";
                }
                return bps;
            } else {
                return "";
            }
        }

    }

    private static Log log = LogFactory.getLog(UploadProgressListener.class);
    private UploadInfo uploadInfo = null;

    public UploadProgressListener() {
        uploadInfo = new UploadInfo();
        uploadInfo.setBeginDate(new Date());
    }

    public Map getUploadInfoMap() {
        UploadInfo ui = (UploadInfo)uploadInfo.clone();
        Map rtn = new HashMap();
        rtn.put("contentLength", "" + ui.getContentLength());
        rtn.put("bytesRead", "" + ui.getBytesRead());
        rtn.put("percent", "" + ui.getPercent());
        rtn.put("bps", "" + ui.getBps());
        rtn.put("lastBps", "" + ui.getPartBps());
        return rtn;
    }
    public String getPercent() {
        UploadInfo ui = (UploadInfo)uploadInfo.clone();
        String percent = "&nbsp;总长度:" + ui.getContentLength() + "&nbsp;已经上传:" + ui.getBytesRead() + "&nbsp;" + ui.getPercent() + "&nbsp;" + ui.getBps();
        return percent;
    }

    public void update(long pBytesRead, long pContentLength, int pItems) {
        uploadInfo.setBytesRead(pBytesRead);
        uploadInfo.setContentLength(pContentLength);
        if (pBytesRead == pContentLength) {
            uploadInfo.setEndDate(new Date());
        }
    }

}
