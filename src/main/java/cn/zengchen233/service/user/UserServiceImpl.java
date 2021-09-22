package cn.zengchen233.service.user;

import cn.zengchen233.dao.BaseDao;
import cn.zengchen233.dao.user.UserDao;
import cn.zengchen233.dao.user.UserDaoImpl;
import cn.zengchen233.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    //业务层都会调用Dao层,所以我们要引用Dao层
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean userRegister(User user) {
        boolean flag = false;
        Connection connection = null;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userDao.userRegister(connection,user);
            connection.commit();//提交事务

            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback(); //回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public User userLogin(String usercode, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库
            user = userDao.userLogin(connection, usercode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResources(connection,null,null);
        }
        return user;
    }
}
