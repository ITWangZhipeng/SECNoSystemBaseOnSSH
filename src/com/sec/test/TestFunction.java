package com.sec.test;

import com.sec.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


/**
 * Created by Administrator on 2016/12/17.
 */
public class TestFunction {

    @Test
    public void testTZDExport() {
        //创建配置对象
        Configuration configuration = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //创建SessionFactory
        SessionFactory sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
        //创阿金Session对象
        Session session = sessionFactory.openSession();
        //创建SchemaExport表
        SchemaExport TZD = new SchemaExport(configuration);

        TZD.create(true, true);

    }

    //添加测试数据
    @Test
    public void testSaveUser() {
        //创建配置对象
        Configuration configuration = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //创建SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //创阿金Session对象
        Session session = sessionFactory.openSession();
        //创建事务对象
        Transaction tx = session.beginTransaction();

        User user0 = new User(10000000, "管理员账号0", "000000");
        User user1 = new User(10000001, "管理员账号1", "000000");
        User user2 = new User(10000002, "管理员账号2", "000000");
        User user3 = new User(10000003, "管理员账号3", "000000");

        session.save(user0);
        session.save(user1);
        session.save(user2);
        session.save(user3);


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
