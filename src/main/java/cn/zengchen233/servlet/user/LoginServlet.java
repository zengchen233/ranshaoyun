package cn.zengchen233.servlet.user;

import cn.zengchen233.pojo.User;
import cn.zengchen233.service.user.UserService;
import cn.zengchen233.service.user.UserServiceImpl;
import cn.zengchen233.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usercode = req.getParameter("usercode");
        String password = req.getParameter("password");
        User user = null;

        //和数据库中的做对比,调用业务层
        UserService userService = new UserServiceImpl();
        try {
            user = userService.userLogin(usercode);//这里已经把登陆的人查出来
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user != null && password.equals(user.getPassword())) {//有这个人 ，可以登录 且密码正确
            //将用户的信息放在Session
            req.getSession().setAttribute(Constant.USER_SESSION,user);
            System.out.println("登陆成功");
            resp.sendRedirect(req.getContextPath() + "/user/success.html");
        } else {
            System.out.println("登陆失败");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
