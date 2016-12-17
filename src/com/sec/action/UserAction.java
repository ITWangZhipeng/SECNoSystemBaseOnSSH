package com.sec.action;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.IUserDao;
import com.sec.DAO.Impl.IUserDaoImpl;
import com.sec.db.User;

/**
 * Created by Administrator on 2016/12/15.
 */
public class UserAction extends SuperAction implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;
    private User user = new User();

    public String login() throws Exception {
        IUserDao userDao = new IUserDaoImpl();
        boolean result = userDao.loginValidate(user);
        if (result) {
            System.out.println(result);
            session.setAttribute("loginUserName",user.getUserName());
            return "login_success";
        } else {
            return "login_failed";
        }
    }


    @Override
    public User getModel() {
        return this.user;
    }

    @Override
    public void validate() {
        if ("".equals(user.getUserName())) {
            this.addFieldError("usernameError", "用户名不能为空");
        }
        if(user.getPassword().length()<3){
            this.addFieldError("passwordError","密码长度不少于3位");
        }
    }
}

