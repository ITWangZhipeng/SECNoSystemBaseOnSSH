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
public class ITongZhiDanDaoImpl implements ITongZhiDanDao{
    @Override
    public void insert(TongZhiDan tongZhiDan) throws Exception {

    }

    @Override
    public void delTongZhiDan(TongZhiDan tongZhiDan) throws Exception {

    }

    @Override
    public void updateTongZhiDan(TongZhiDan tongZhiDan) throws Exception {

    }


    @Override
    public List<TongZhiDan> queryAll() throws Exception {
        Transaction tx = null;
        List<TongZhiDan> list = null;
        String hql = "";

        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from TongZhiDan ";
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
    public String queryById(int TZDId) throws Exception {
        return null;
    }
}
