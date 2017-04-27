package com.xietong.software.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.BaseOnlineUser;
import com.xietong.software.sdtw.db.BaseUserCode;


public class UserSessionListener implements HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener {
	HttpServletRequest request;
    public static class Users {
        private static Map userMap = new HashMap();
        private static Map sessionMap = new HashMap();

        public static void add(UserItem ui) {
            userMap.put(ui.getId(), ui);
            sessionMap.put(ui.getSessionId(), ui.getId());
            ui.login();
        }

        public static UserItem remove(HttpSession session) {
            String id = (String)sessionMap.get(session.getId());
            if (id != null) {
                UserItem ui = (UserItem)userMap.get(id);
                ui.logout(session);
                userMap.remove(id);
                sessionMap.remove(session.getId());
                return ui;
            }
            return null;
        }

        public static UserItem getUserItem(HttpServletRequest request) {
            String id = (String)sessionMap.get(request.getSession().getId());
            if (id != null) {
                return (UserItem)userMap.get(id);
            }
            return null;
        }
    }

    public class UserItem {
        private UserInfo userInfo = null;
        private BaseOnlineUser onlineUser = new BaseOnlineUser();

        public void setUserInfo(UserInfo aval) {userInfo = aval;}
        public UserInfo getUserInfo() {return userInfo;}

        private String sessionId = null;
        public void setSessionId(String aval) {sessionId = aval;}
        public String getSessionId() {return sessionId;}

        private Date beginDate = null;
        public void setBeginDate(Date aval) {beginDate = aval;}
        public Date getBeginDate() {return beginDate;}
        
        public UserItem(UserInfo ui, String sid) {
            this.userInfo = ui;
            this.sessionId = sid;
            beginDate = new Date();
        }

        public String getId() {
            return "" + userInfo.getId();
        }

        public BaseOnlineUser getOnlineUser() {
            return onlineUser;
        }

        public void login() {
        	BaseUserCode uc = userInfo.getUserCode();
            onlineUser = onlineUser.getById(uc.getId());
            if (onlineUser == null) {
                onlineUser = new BaseOnlineUser();
                onlineUser.setId(uc.getId());
                onlineUser.setDeptId(uc.getDeptId());
                onlineUser.setOrgId(uc.getOrgId());
                onlineUser.setOccupation(uc.getOccupation());
                onlineUser.setLogonTime(beginDate);
                onlineUser.setLastTime(beginDate);
                onlineUser.insertByKey();
            } else {
                onlineUser.setLastTime(beginDate);
                onlineUser.update();
            }
            log.debug("用户上线：" + Tool.stringOfDateTime(beginDate));
        }

        public void logout(HttpSession session) {
            (new BaseOnlineUser()).delete(userInfo.getId());
            Date eDate = new Date();
            log.debug("用户下线：" + Tool.stringOfDateTime(eDate));
            log.debug("用户在线：" + (int)((eDate.getTime() - beginDate.getTime()) / 1000) + "秒");
        }
    }
    private static Log log = LogFactory.getLog(UserSessionListener.class);

    public void sessionCreated(HttpSessionEvent se) {
        Date bDate = new Date();
        se.getSession().setAttribute("__BEGINTIME__", bDate);
        log.debug("上线：" + Tool.stringOfDateTime(bDate));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Date bDate = (Date)se.getSession().getAttribute("__BEGINTIME__");
        if (bDate != null) {
            Date eDate = new Date();
            log.debug("下线：" + Tool.stringOfDateTime(eDate));
            log.debug("在线：" + (eDate.getTime() - bDate.getTime()) / 1000 + "秒");
        }
        Users.remove(se.getSession());
    }

    public void attributeAdded(HttpSessionBindingEvent se) {
        if (se.getName().equals("UserInfo")) {
            if (se.getValue() == null) {
                Users.remove(se.getSession());
            } else {
                UserItem ui = new UserItem((UserInfo)se.getValue(), se.getSession().getId());
                Users.add(ui);
            }
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        if (se.getName().equals("UserInfo")) {
            Users.remove(se.getSession());
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
    }

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		request = (HttpServletRequest)arg0.getServletRequest();
	}

}
