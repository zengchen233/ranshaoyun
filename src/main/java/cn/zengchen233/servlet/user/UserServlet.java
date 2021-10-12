package cn.zengchen233.servlet.user;

import cn.zengchen233.pojo.User;
import cn.zengchen233.service.user.UserService;
import cn.zengchen233.service.user.UserServiceImpl;
import cn.zengchen233.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user/user.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("modify") && method != null) {
            this.modify(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;

        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        String usercode = user.getUsercode();

        if (oldpassword.equals(user.getPassword())) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(usercode, newpassword);
            if (flag) {
                req.setAttribute("message", "密码修改成功,请退出并使用新密码登录!");
                //密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constant.USER_SESSION);
                req.getSession().removeAttribute(Constant.USER_SESSION_ADMIN);
                req.getSession().removeAttribute("username");
            } else {
                req.setAttribute("message", "密码修改失败!");
            }
        } else {
            req.setAttribute("error","旧密码不匹配");
        }
        req.getRequestDispatcher("modifypw.jsp").forward(req,resp);
    }

    public void view(HttpServletRequest req, HttpServletResponse resp) {

    }

}
