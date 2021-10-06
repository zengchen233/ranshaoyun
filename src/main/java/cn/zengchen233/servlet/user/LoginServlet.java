package cn.zengchen233.servlet.user;

import cn.zengchen233.pojo.User;
import cn.zengchen233.service.user.UserService;
import cn.zengchen233.service.user.UserServiceImpl;
import cn.zengchen233.utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = "/log.do")
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

            ServletContext application = this.getServletContext();//取得application对象
            List<String> list = (List<String>) application.getAttribute("allUser");

            if(!list.contains(user.getNickname())){
                HttpSession session = req.getSession(true);//取得session对象
                session.setAttribute("username", user.getNickname());
            }


            // 判断用户是否为管理员
            if (String.valueOf(user.getUsertype()).equals("1")) {
                req.getSession().setAttribute(Constant.USER_SESSION_ADMIN,user);
                // System.out.println("添加成功");
            }
            // System.out.println("登陆成功");
            resp.sendRedirect(req.getContextPath() + "/user/index.jsp");
        } else {
            // System.out.println("登陆失败");
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
