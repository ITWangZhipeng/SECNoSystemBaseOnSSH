package com.sec.DAO.Impl;

import com.sec.DAO.IUserDao;
import com.sec.bean.myHibernateSessionFactory;
import com.sec.db.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by 10433208 on 2016/12/9.
 */
public class IUserDaoImpl implements IUserDao {
    public IUserDaoImpl() {

    }

    @Override
    public boolean insert(User user) throws Exception {

        return false;
    }

    @Override
    public boolean delUser(long workID) throws Exception {

        return false;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return false;
    }

    @Override
    public List<User> queryAll() throws Exception {
        Transaction tx = null;
        List<User> list = null;
        String hql = "";

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from User";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return list;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

    @Override
    public User queryById(long UserId) throws Exception {
        Transaction tx = null;
        List<User> list = null;
        String hql = "";

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from User where WorkID=:WorkID";
            Query query = session.createQuery(hql);
            query.setLong("WorkID", UserId);
            list = query.list();

            tx.commit();

            if(list.size()>0){
                return list.get(0);
            }
            else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("通过WorkID查找用户发生错误");
            return null;

        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }


    @Override
    public boolean loginValidate(User user) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        System.out.println("开始验证登录信息");
        Transaction tx = null;
        String hql = "";
        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from User where WorkID =:WorkID and password=:password";
            Query query = session.createQuery(hql);
            query.setLong("WorkID", user.getWorkID());
            query.setString("password", user.getPassword());
            List list = query.list();

            tx.commit();//提交事务

            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

}
