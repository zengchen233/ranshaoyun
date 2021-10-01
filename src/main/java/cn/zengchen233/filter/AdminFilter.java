package cn.zengchen233.filter;

import cn.zengchen233.pojo.User;
import cn.zengchen233.utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/user/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION_ADMIN);

        if (user == null) {
            resp.sendRedirect( req.getContextPath() + "/user/without permission.html");
            return;
        }
        chain.doFilter(request,response);
    }
}
