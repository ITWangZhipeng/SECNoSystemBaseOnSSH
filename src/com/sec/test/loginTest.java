package com.sec.test;

import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.db.User;

/**
 * Created by Administrator on 2016/12/15.
 */
public class loginTest {
    public static void main(String[] args) {
        User user = new User();
        user.setWorkID(10433208);
        user.setPassword("111111");
        IUserDao userDao = new IUserDaoImpl();
        boolean result = false;
        try {
            User u = userDao.loginValidate(user);

            if (u != null) {
                System.out.println(result);
                System.out.println("login_success");
            } else {
                System.out.println("login_failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

