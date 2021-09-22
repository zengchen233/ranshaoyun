package cn.zengchen233.servlet.user;

import cn.zengchen233.pojo.User;
import cn.zengchen233.service.user.UserService;
import cn.zengchen233.service.user.UserServiceImpl;
import cn.zengchen233.utils.IDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = 2;
        String userid = IDUtils.getId();
        String usercode = req.getParameter("usercode"); //账号
        String password = req.getParameter("password"); //密码
        String nickname = req.getParameter("nickname"); //用户名
        String phone = req.getParameter("phone"); //电话号码
        String email = req.getParameter("email"); //电子邮件

        User user = new User();
        user.setUserid(userid);
        user.setUsercode(usercode);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setUsertype(usertype);
        user.setPhone(phone);
        user.setEmail(email);

        UserService userService = new UserServiceImpl();

        if (userService.userRegister(user)) {
            resp.sendRedirect(req.getContextPath() + "/user/success.html");
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
