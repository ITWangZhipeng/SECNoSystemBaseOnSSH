package com.sec.action.User;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.action.SuperAction;
import com.sec.db.User;

/**
 * Created by Administrator on 2016/12/15.
 */
public class UserAction extends SuperAction implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;
    private User user = new User();

    @Override
    public User getModel() {
        return this.user;
    }

    @Override
    public void validate() {
        if ("".equals(user.getWorkID())) {
            this.addFieldError("usernameError", "工号不能为空");
        }
        if (user.getPassword().length() < 3 && user.getPassword().length() >0) {
            this.addFieldError("passwordError", "密码长度不少于3位");
        }
    }


    public String login() throws Exception {
        IUserDao userDao = new IUserDaoImpl();
        User u = userDao.loginValidate(user);
        if (u!=null) {
            System.out.println(u);
            session.setAttribute("loginWorkID", u.getWorkID());
            session.setAttribute("loginUserName", u.getUserName());
            session.setAttribute("user", u);
            return "login_success";
        } else {
            return "login_failed";
        }
    }
//
//    public String query() {
//        IUserDao userDao = new IUserDaoImpl();
//        try {
//            List<User> list = userDao.queryAll();
//            if (list != null && list.size() > 0) {
//                session.setAttribute("User_list", list);
//            }
//            System.out.println("User_query_success");
//            return "User_query_success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("User_query_null");
//            return "User_query_null";
//        }
//    }
}

