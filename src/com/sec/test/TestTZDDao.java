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
            long WorkID = 10433208L;
            List<TongZhiDan> list = iTongZhiDanDao.queryAll(WorkID);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
