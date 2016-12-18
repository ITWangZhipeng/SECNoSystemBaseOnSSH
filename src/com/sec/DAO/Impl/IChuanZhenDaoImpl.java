package com.sec.DAO.Impl;

import com.sec.DAO.IChuanZhenDao;
import com.sec.db.ChuanZhen;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public class IChuanZhenDaoImpl implements IChuanZhenDao{
    @Override
    public boolean insert(ChuanZhen cz, long workID) throws Exception {

        return false;
    }

    @Override
    public boolean delChuanZhen(Integer cz) throws Exception {

        return false;
    }

    @Override
    public void updateChuanZhen(ChuanZhen cz) throws Exception {

    }

    @Override
    public List<ChuanZhen> queryAll(Long WorkID) throws Exception {
        List<ChuanZhen> list =null;
        return list;
    }

    @Override
    public String queryById(ChuanZhen cz) throws Exception {
        return null;
    }
}
