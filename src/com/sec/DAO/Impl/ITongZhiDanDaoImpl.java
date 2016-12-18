package com.sec.DAO.Impl;

import com.sec.DAO.ITongZhiDanDao;
import com.sec.bean.myHibernateSessionFactory;
import com.sec.db.TongZhiDan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public class ITongZhiDanDaoImpl implements ITongZhiDanDao {

    @SuppressWarnings("JpaQlInspection")
    @Override
    public boolean insert(TongZhiDan tongZhiDan, long workID) throws Exception {

        Transaction tx = null;

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            session.save(tongZhiDan);
            session.flush();
            String hql = "update TongZhiDan set WorkID =:WorkID where tid=:tid";
            Query query = session.createQuery(hql);
            query.setLong("WorkID", workID);
            query.setLong("tid", tongZhiDan.getTid());
            query.executeUpdate();

            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

    @Override
    public boolean delTongZhiDan(int tid) throws Exception {

        Transaction tx = null;
        String hql = "";

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            TongZhiDan tongZhiDan = (TongZhiDan) session.get(TongZhiDan.class, tid);
            session.delete(tongZhiDan);
            tx.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }


    }

    @Override
    public void updateTongZhiDan(TongZhiDan tongZhiDan) throws Exception {

    }


    @Override
    public List<TongZhiDan> queryAll(long workID) throws Exception {
        Transaction tx = null;
        List<TongZhiDan> list = null;
        String hql = "";

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from TongZhiDan where WorkID = :WorkID";
            Query query = session.createQuery(hql);
            query.setLong("WorkID", workID);
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
    public String queryById(int TZDId) throws Exception {
        return null;
    }
}
