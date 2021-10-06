package cn.zengchen233.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class LoginListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {

    ServletContext application = null;

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("服务器关闭");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        List<String> list = new ArrayList<>();
        //用来保存所有已登录的用户
        application = event.getServletContext();
        //取得application对象
        application.setAttribute("allUser", list);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        List<String> list = (List<String>) application.getAttribute("allUser");
        //假设：用户登陆成功之后，只将户名设置到session中
        String userName = (String)event.getValue();
        //取得用户名
        if(!list.contains(userName)){ // list.indexOf(userName) == -1
            //表示此用户之前没有登陆
            list.add(userName);
            application.setAttribute("allUser", list);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        List<String> list = (List<String>)application.getAttribute("allUser");
        list.remove((String)event.getValue());
        application.setAttribute("allUser", list);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
