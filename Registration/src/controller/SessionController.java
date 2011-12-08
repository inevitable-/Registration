package controller;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionController implements HttpSessionListener {
    private int sessionCount = 0;
 
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount++;
        }
 
        System.out.println("Session Created: " + event.getSession().getId());
        System.out.println("Total Sessions: " + sessionCount);
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount--;
        }
        System.out.println("Session Destroyed: " + event.getSession().getId());
        System.out.println("Total Sessions: " + sessionCount);
    }
}