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

    public boolean userComment(Map<String, Object> map);

    public List<Comment> queryComment(Map<String,Object> map);

}
