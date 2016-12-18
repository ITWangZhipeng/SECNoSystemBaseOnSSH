package com.sec.action.TZD;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.ITongZhiDanDao;
import com.sec.DAO.Impl.ITongZhiDanDaoImpl;
import com.sec.action.SuperAction;
import com.sec.db.TongZhiDan;

/**
 * Created by Administrator on 2016/12/18.
 */
public class delTZDAction extends SuperAction implements ModelDriven<TongZhiDan> {
    private TongZhiDan tongZhiDan;
    public static final long serialVersionUID = 1L;

    @Override
    public TongZhiDan getModel() {
        return this.tongZhiDan;
    }

    public String dele() {

        try {
            ITongZhiDanDao iTongZhiDanDao = new ITongZhiDanDaoImpl();
            Integer tid = Integer.parseInt(request.getParameter("tid"));
            boolean b = iTongZhiDanDao.delTongZhiDan(tid);
            if (b) {
                System.out.println("TZD_dele_success");
                return "TZD_dele_success";
            } else {
                return "TZD_dele_failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("TZD_dele_null");
            return "TZD_dele_failed";
        }
    }
}
