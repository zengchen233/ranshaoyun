package cn.zengchen233.service.role;

import cn.zengchen233.dao.BaseDao;
import cn.zengchen233.dao.role.RoleDao;
import cn.zengchen233.dao.role.RoleDaoImpl;
import cn.zengchen233.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResources(connection, null, null);
        }
        return roleList;
    }

    //测试连接情况，随即打印信息
    @Test
    public void test() {
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRolename());
        }
    }
}
