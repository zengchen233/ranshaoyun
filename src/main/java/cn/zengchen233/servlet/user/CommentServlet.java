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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "comment", urlPatterns = "/user/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("leave")) {
            this.leavemessage(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void leavemessage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String title = req.getParameter("title");

        String message = req.getParameter("message");

        User attribute = (User) req.getSession().getAttribute(Constant.USER_SESSION);

        Date date = new Date(System.currentTimeMillis());

        Map<String,Object> map = new HashMap<>();

        map.put("usercode",attribute.getUsercode());

        map.put("nickname",attribute.getNickname());

        map.put("datetime",date);

        map.put("title",title);

        map.put("message",message);

        UserService userService = new UserServiceImpl();

        if (userService.userComment(map)) {
            resp.sendRedirect(req.getContextPath() + "/user/success.jsp");
        } else {
            req.getRequestDispatcher("/user/leavemessage.jsp").forward(req, resp);
        }
    }
}
