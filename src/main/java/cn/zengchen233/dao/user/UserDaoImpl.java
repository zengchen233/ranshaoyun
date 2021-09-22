package cn.zengchen233.dao.user;

import cn.zengchen233.dao.BaseDao;
import cn.zengchen233.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public int userRegister(Connection connection, User user) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;

        if (connection != null) {
            String sql = "insert into user (userid,usercode,password,nickname,usertype,phone,email)" +
                         "values(?,?,?,?,?,?,?)";

            Object[] params = {user.getUserid(), user.getUsercode(), user.getPassword(), user.getNickname(),
                    user.getUsertype(), user.getPhone(), user.getEmail()};

            updateRows = BaseDao.execute(connection, pstm, sql, params);

            //connection不用关,连接可能存在业务
            BaseDao.closeResources(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public User userLogin(Connection connection, String usercode) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from user where usercode=?";
            Object[] params = {usercode};
            rs = BaseDao.execute(connection, pstm, sql, params, rs);

            if (rs.next()) {
                user = new User();
                user.setUserid(rs.getString("userid"));
                user.setUsercode(rs.getString("usercode"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setUsertype(rs.getInt("usertype"));
                user.setPhone(rs.getString("phone"));
                user.setPhone(rs.getString("email"));
            }
            BaseDao.closeResources(null, pstm, rs);
            //connection不用关,连接可能存在业务
        }
        return user;
    }
}
