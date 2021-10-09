package cn.zengchen233.servlet.admin;

import cn.zengchen233.pojo.User;
import cn.zengchen233.service.user.UserService;
import cn.zengchen233.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "admin", urlPatterns = "/user/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("online")) {
            this.online(req, resp);
        } else if (method.equals("query")) {
            this.query(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void online(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("admin/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String temp = req.getParameter("queryUserRole");
        int queryUserRole = 0;

        if (name == null){
            name = "";
        }
        if (temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);//给查询赋值
            // System.out.println(queryUserRole);
        }

        UserService userService = new UserServiceImpl();

        List<User> userList;
        Map<String, Object> map = new HashMap<>();

        map.put("nickname", name);
        map.put("userRole", queryUserRole);

        //获取用户列表展示
        userList = userService.queryUserList(map);

        req.setAttribute("userList", userList);


        try {
            req.getRequestDispatcher("admin/userlist.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
