package de ;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper {
    private Context context=null;
    private DataBaseHelperInternal mDbHelper=null;
    private SQLiteDatabase mDb=null;
    private static final String DATABASE_NAME="DBClientes";
    private static final String DATABASE_TABLE_CLIENTES="Clientes";
    private static final int DATABASE_VERSION=3;
    public static final String CODIGO ="codigo";
    public static final String NOMBRE="nombre";
    public static final String TELEFONO="telefono";
    private static final String DATABASE_CREATE_CLIENTES="create table "+DATABASE_TABLE_CLIENTES+"("+CODIGO+" integer primary key,"+NOMBRE+" text not null,"+TELEFONO+" text not null)";

    private static class DataBaseHelperInternal extends SQLiteOpenHelper{
        public DataBaseHelperInternal(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db){
            db.execSQL(DATABASE_CREATE_CLIENTES);
        }
        private void deleteTables(SQLiteDatabase db){
            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE_CLIENTES);
        }
    }

    public DataBaseHelper(Context context){
        this.context=context;
    }
    public DataBaseHelper open(){
        mDbHelper=new DataBaseHelperInternal(context);
        mDb=mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        mDbHelper.close();
    }
    public long insertItem(int cod,String nom,String tel){
        ContentValues initialValues=new ContentValues();
        initialValues.put(CODIGO,cod);
        initialValues.put(NOMBRE,nom);
        initialValues.put(TELEFONO,tel);
        return mDb.insert(DATABASE_TABLE_CLIENTES,null,initialValues);
    }
}
