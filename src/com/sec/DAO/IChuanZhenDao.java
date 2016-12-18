package com.sec.DAO;

import com.sec.db.ChuanZhen;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public interface IChuanZhenDao {
    //增
    boolean insert(ChuanZhen cz, long workID) throws Exception;
    //删
    boolean delChuanZhen(Integer cz) throws Exception;
    //改
    void updateChuanZhen(ChuanZhen cz) throws Exception;
    //查全
    List<ChuanZhen> queryAll(Long WorkID) throws Exception;
    //单查
    String queryById(ChuanZhen cz) throws Exception;
}
