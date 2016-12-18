package com.sec.DAO.Impl;

import com.sec.DAO.IJiGuiDao;
import com.sec.db.JiGui;

import java.util.List;


public class IJiGuiDaoImpl implements IJiGuiDao{
    @Override
    public boolean insert(JiGui jigui, long workID) throws Exception {

        return false;
    }

    @Override
    public boolean delJiGui(Integer jigui) throws Exception {

        return false;
    }

    @Override
    public void updateJiGui(JiGui jigui) throws Exception {

    }


    @Override
    public List<JiGui> queryAll(long workID) throws Exception {
        return null;
    }

    @Override
    public String queryById(int JGId) throws Exception {
        return null;
    }
}
