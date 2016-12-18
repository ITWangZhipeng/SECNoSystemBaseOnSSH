package com.sec.action.TZD;

import com.opensymphony.xwork2.ModelDriven;
import com.sec.DAO.ITongZhiDanDao;
import com.sec.DAO.Impl.ITongZhiDanDaoImpl;
import com.sec.action.SuperAction;
import com.sec.db.TongZhiDan;

/**
 * Created by Administrator on 2016/12/18.
 */
public class addTZDAction extends SuperAction implements ModelDriven<TongZhiDan> {

    private TongZhiDan tongzhidan;
    public static final long serialVersionUID = 1L;

    @Override
    public TongZhiDan getModel() {
        return this.tongzhidan;
    }

    public String add() throws Exception {

        ITongZhiDanDao iTongZhiDanDao = new ITongZhiDanDaoImpl();

        String department = request.getParameter("department");
        String content = request.getParameter("content");
        TongZhiDan tongZhiDan = new TongZhiDan();
        tongZhiDan.setContent(content);
        tongZhiDan.setDepartment(department);

        long WorkID = (long) session.getAttribute("loginWorkID");

        try {
            boolean b = iTongZhiDanDao.insert(tongZhiDan, WorkID);
            if (b) {
                return "add_TZD_success";
            } else {
                return "add_TZD_failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "add_TZD_failed";
        }
    }
}

