package cn.zengchen233.service.user;

import cn.zengchen233.pojo.Comment;
import cn.zengchen233.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //用户注册
    public boolean userRegister(Map<String, Object> map);

    //用户登录
    public User userLogin(String usercode);

    //用户留言
    public boolean userComment(Map<String, Object> map);

    //用户留言查询
    public List<Comment> queryComment();

    //获取用户列表
    public List<User> queryUserList(Map<String, Object> map);

    //修改密码
    public boolean updatePwd(String usercode, String password);

}
