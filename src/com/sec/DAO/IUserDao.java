package com.sec.DAO;

import com.sec.db.User;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public interface IUserDao {
    //增
    boolean insert(User user) throws Exception;
    //删
    boolean delUser(long workID) throws Exception;
    //改
    boolean updateUser(User user) throws Exception;
    //查全
    List<User> queryAll() throws Exception;
    //单查
    User queryById(long UserId) throws Exception;
    //验证登录
    boolean loginValidate(User user) throws  Exception;
}
