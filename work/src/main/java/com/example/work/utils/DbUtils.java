package com.example.work.utils;

import com.example.work.base1.BaseApplication;
import com.example.work.bean.ListBean;
import com.example.work.dao.DaoMaster;
import com.example.work.dao.ListBeanDao;

import java.util.List;

public class DbUtils {

    private static DbUtils dbUtils;
    private final ListBeanDao dao;

    private DbUtils() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getApplication(), "lmn.db");
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

    public void insert(ListBean bean) {
        if (has(bean)) {
            return;
        }
        dao.insertOrReplaceInTx(bean);
    }

    public void delete(ListBean bean) {
        if (has(bean)) {
            dao.delete(bean);
        }
    }

    public List<ListBean> query() {
        return dao.queryBuilder().list();
    }

    public boolean has(ListBean bean) {
        List<ListBean> list = dao.queryBuilder().where(ListBeanDao.Properties.Title.eq(bean.getTitle()),
                ListBeanDao.Properties.Desc.eq(bean.getDesc()),
                ListBeanDao.Properties.EnvelopePic.eq(bean.getEnvelopePic())).list();
        if (list.size() > 0 && list != null) {
            return true;
        }
        return false;
    }
}
