package com.example.dao.utils;

import com.example.dao.app.MyApp;
import com.example.dao.bean.ListBean;
import com.example.dao.dao.DaoMaster;
import com.example.dao.dao.ListBeanDao;

import java.util.List;

public class DbUtils {

    private static DbUtils dbUtils;
    private final ListBeanDao dao;

    private DbUtils() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "ldd.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        dao = daoMaster.newSession().getListBeanDao();
    }

    public static DbUtils getDbUtils() {
        if (dbUtils == null) {
            synchronized (DbUtils.class) {
                if (dbUtils == null) {
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }

    public void insert(ListBean listBean) {
        if (has(listBean)) {
            return;
        }
        dao.insertOrReplaceInTx(listBean);
    }

    public void delete(ListBean listBean) {
        if (has(listBean)) {
            dao.delete(listBean);
        }
    }

    public List<ListBean> query() {
        return dao.queryBuilder().list();
    }

    public boolean has(ListBean listBean) {
        List<ListBean> list = dao.queryBuilder().where(
                ListBeanDao.Properties.Collect_num.eq(listBean.getCollect_num()),
                ListBeanDao.Properties.Title.eq(listBean.getTitle()),
                ListBeanDao.Properties.Pic.eq(listBean.getPic())).list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
