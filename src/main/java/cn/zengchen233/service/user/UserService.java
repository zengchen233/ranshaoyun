package cn.zengchen233.service.user;

import cn.zengchen233.pojo.User;

public interface UserService {
    //用户注册
    public boolean userRegister(User user);

    //用户登录
    public User userLogin(String usercode, String password);
}
