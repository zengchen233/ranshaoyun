package cn.zengchen233.dao.user;

import cn.zengchen233.pojo.Comment;
import cn.zengchen233.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //用户注册
    public int userRegister(Map<String, Object> map);

    //用户登录
    public User userLogin(@Param("usercode") String usercode);

    //添加留言
    public int userComment(Map<String, Object> map);

    //通过条件查询留言
    public List<Comment> queryComment();

    //获取用户列表
    public List<User> queryUserList(Map<String, Object> map);
}
