package com.sec.test;

import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.db.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class TestUserDao {
    @Test
    public void testQueryAllUser(){
        IUserDao iUserDao = new IUserDaoImpl();
        try {
            List<User> list = iUserDao.queryAll();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryByID(){
        IUserDao iUserDao = new IUserDaoImpl();
        try{
            User user = iUserDao.queryById(10433208);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser(){
        IUserDao iUserDao = new IUserDaoImpl();
        try{
            User user = new User(10433208,"王志鹏","222222");
            iUserDao.updateUser(user);
            user = iUserDao.queryById(user.getWorkID());
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
