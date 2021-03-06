package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FILE_INFO".
*/
public class FileInfoDao extends AbstractDao<FileInfo, Void> {

    public static final String TABLENAME = "FILE_INFO";

    /**
     * Properties of entity FileInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property FileName = new Property(2, String.class, "fileName", false, "FILE_NAME");
        public final static Property Lenght = new Property(3, int.class, "lenght", false, "LENGHT");
        public final static Property Finished = new Property(4, int.class, "finished", false, "FINISHED");
        public final static Property StateInte = new Property(5, int.class, "stateInte", false, "STATE_INTE");
    }


    public FileInfoDao(DaoConfig config) {
        super(config);
    }
    
    public FileInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FILE_INFO\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"FILE_NAME\" TEXT," + // 2: fileName
                "\"LENGHT\" INTEGER NOT NULL ," + // 3: lenght
                "\"FINISHED\" INTEGER NOT NULL ," + // 4: finished
                "\"STATE_INTE\" INTEGER NOT NULL );"); // 5: stateInte
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FILE_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FileInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(3, fileName);
        }
        stmt.bindLong(4, entity.getLenght());
        stmt.bindLong(5, entity.getFinished());
        stmt.bindLong(6, entity.getStateInte());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FileInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(3, fileName);
        }
        stmt.bindLong(4, entity.getLenght());
        stmt.bindLong(5, entity.getFinished());
        stmt.bindLong(6, entity.getStateInte());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public FileInfo readEntity(Cursor cursor, int offset) {
        FileInfo entity = new FileInfo( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fileName
            cursor.getInt(offset + 3), // lenght
            cursor.getInt(offset + 4), // finished
            cursor.getInt(offset + 5) // stateInte
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FileInfo entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFileName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLenght(cursor.getInt(offset + 3));
        entity.setFinished(cursor.getInt(offset + 4));
        entity.setStateInte(cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(FileInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(FileInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(FileInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
