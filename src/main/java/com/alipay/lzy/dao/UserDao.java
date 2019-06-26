package com.alipay.lzy.dao;

import com.alipay.lzy.entity.User;
import org.apache.ibatis.annotations.Param;

/*
 * dao层作为接口 映射数据库,不需要实现类
 */
public interface UserDao {
    void deleteByPrimaryKey(Integer id);

    //    1,添加用户(注册)
    void insert(User user);

    //    2,根据用户名和密码查询用户(登录)
/*    注解的两个参数会自动封装成map集合，括号内即为键
    @Param("")参数映射实体类定义的变量*/
    User selectByNameAndPwd(@Param("userName") String userName, @Param("password") String password);

//    void selectByNameAndPwd(String userName,String password);

    void insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(User user);

    void updateByPrimaryKey(User user);
}