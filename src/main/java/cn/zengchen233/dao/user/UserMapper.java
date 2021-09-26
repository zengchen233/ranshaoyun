package cn.zengchen233.dao.user;

import cn.zengchen233.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    //用户注册
    public int userRegister(Map<String,Object> map);

    //用户登录
    public User userLogin(@Param("usercode") String usercode);

    public int userComment(Map<String,Object> map);
}
