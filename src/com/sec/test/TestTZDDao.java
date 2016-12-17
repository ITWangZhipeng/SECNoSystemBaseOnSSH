package com.sec.test;

import com.sec.DAO.ITongZhiDanDao;
import com.sec.DAO.Impl.ITongZhiDanDaoImpl;
import com.sec.db.TongZhiDan;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class TestTZDDao {
    @Test
    public void testQueryAllTZD(){
        ITongZhiDanDao iTongZhiDanDao = new ITongZhiDanDaoImpl();
        try {
            List<TongZhiDan> list = iTongZhiDanDao.queryAll();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
