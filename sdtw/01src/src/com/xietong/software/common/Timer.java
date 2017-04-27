package com.xietong.software.common;
/**
 * 侦听器程序测试
 */
public class Timer implements javax.servlet.ServletContextListener {
    private java.util.Timer timer;

    public Timer() {
        System.out.println( "startup init" );
        timer = new java.util.Timer( true );
    }

    public void contextDestroyed( javax.servlet.ServletContextEvent event ) {
        System.out.println( "destory" );
        timer.cancel();
    }

    public void contextInitialized( javax.servlet.ServletContextEvent event ) {
        System.out.println( "start" );
        System.out.println( event.getServletContext().getRealPath( "/" ) );
        timer.schedule( new java.util.TimerTask() {
            public void run() {
                //com.xietong.software.main.COnlineUser.refresh();
            }
        } , 0 , 30000 );
    }

}
