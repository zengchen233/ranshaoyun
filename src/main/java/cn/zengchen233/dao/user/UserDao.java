package cn.zengchen233.dao.user;

import cn.zengchen233.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //用户注册
    public int userRegister(Connection connection, User user) throws Exception;

    //用户登录
    public User userLogin(Connection connection, String usercode) throws Exception;
}
