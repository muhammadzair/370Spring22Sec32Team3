package edu.qc.seclass.fim;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c =null;

    //private constructor so that object creation from outside the class is avoided
    private  DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);

    }

    //to return the single instance of database

    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }


    // closing the database connection

    public void close(){
        if(db != null){
            this.db.close();
        }
    }

    // now lets create a method to query and return the result from database
    //we wukk qyert fir address by passing Store ID

    public String getInformation(int id){
        c = db.rawQuery("select * from Floor where FloorId = '" + id + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String information = c.getString(0);
            buffer.append(""+ information);
        }
        return buffer.toString();
    }

}
