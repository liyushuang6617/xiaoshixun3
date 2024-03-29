package com.example.dao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.dao.bean.ListBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LIST_BEAN".
*/
public class ListBeanDao extends AbstractDao<ListBean, Long> {

    public static final String TABLENAME = "LIST_BEAN";

    /**
     * Properties of entity ListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Collect_num = new Property(2, String.class, "collect_num", false, "COLLECT_NUM");
        public final static Property Pic = new Property(3, String.class, "pic", false, "PIC");
    }


    public ListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public ListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LIST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"COLLECT_NUM\" TEXT," + // 2: collect_num
                "\"PIC\" TEXT);"); // 3: pic
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LIST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ListBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String collect_num = entity.getCollect_num();
        if (collect_num != null) {
            stmt.bindString(3, collect_num);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(4, pic);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ListBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String collect_num = entity.getCollect_num();
        if (collect_num != null) {
            stmt.bindString(3, collect_num);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(4, pic);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ListBean readEntity(Cursor cursor, int offset) {
        ListBean entity = new ListBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // collect_num
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // pic
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ListBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCollect_num(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPic(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ListBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ListBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ListBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
