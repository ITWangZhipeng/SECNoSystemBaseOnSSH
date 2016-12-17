package com.sec.action.User;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.action.SuperAction;
import com.sec.db.User;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class QueryAllUser extends SuperAction implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;
    private User user = new User();

    @Override
    public User getModel() {
        return this.user;
    }


    public String query() {
        IUserDao userDao = new IUserDaoImpl();
        try {
            List<User> list = userDao.queryAll();
            if (list != null && list.size() > 0) {
                session.setAttribute("User_list", list);
            }
            System.out.println("User_query_success");
            return "User_query_success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User_query_null");
            return "User_query_null";
        }
    }
}
