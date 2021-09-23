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
import java.util.HashMap;
import java.util.Map;

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

        Map<String,Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("usercode", usercode);
        map.put("password", password);
        map.put("nickname", nickname);
        map.put("usertype", usertype);
        map.put("phone", phone);
        map.put("email", email);

        UserService userService = new UserServiceImpl();

        if (userService.userRegister(map)) {
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
