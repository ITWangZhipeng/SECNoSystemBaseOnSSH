package com.sec.action.TZD;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.ITongZhiDanDao;
import com.sec.DAO.Impl.ITongZhiDanDaoImpl;
import com.sec.action.SuperAction;
import com.sec.db.TongZhiDan;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class QueryAllTZD extends SuperAction implements ModelDriven<TongZhiDan> {

    private TongZhiDan tongZhiDan;
    public static final long serialVersionUID = 1L;

    @Override
    public TongZhiDan getModel() {
        return this.tongZhiDan;
    }
    public String query() {
        ITongZhiDanDao iTongZhiDanDao = new ITongZhiDanDaoImpl();

        try {
            List<TongZhiDan> list = iTongZhiDanDao.queryAll();
            if (list != null && list.size() > 0) {
                session.setAttribute("TZD_list", list);
            }
            System.out.println("TZD_query_success");
            return "TZD_query_success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("TZD_query_null");
            return "TZD_query_null";
        }
    }

}
