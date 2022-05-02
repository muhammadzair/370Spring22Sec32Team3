package edu.qc.seclass.fim;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.qc.seclass.fim.Floor;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c =null;

    //private constructor so that object creation from outside the class is avoided
    public  DatabaseAccess(Context context){
        this.openHelper = new SQLiteOpenHelper(context, "FIMDatabase.db",null, 1) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            }
        };

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
    //we can query  by passing Store ID


    //get count for result
    public long getCount(String name)
    {
        db = openHelper.getWritableDatabase();
        c = db.rawQuery("select * from Floor where FloorBrand = '" + name + "'", null);
        c.moveToFirst();
        return c.getLong(0);
    }

    public Floor getByProductName(String name)
    {
        db = openHelper.getReadableDatabase();
        c = db.rawQuery("select * from Floor where FloorName = '" + name + "'", new String[]{});
        if(c.moveToFirst())
        {
            int FloorId = c.getInt(0);
            int StoreId = c.getInt(1);
            String FloorName = c.getString(2);
            String FloorCategory = c.getString(3);
            String FloorColor = c.getString(4);
            String FloorSize = c.getString(5);
            String FloorBrand = c.getString(6);
            String FloorPrice = c.getString(7);

            return new Floor(FloorId, StoreId, FloorName, FloorCategory, FloorColor,FloorSize, FloorBrand, FloorPrice);

        }
        return null;

    }

    public List<Floor> getByStore(String name)
    {
        List<Floor> Floors = new ArrayList<Floor>();
        db = openHelper.getReadableDatabase();
        c = db.rawQuery("select * from Floor where FloorBrand = '" + name + "'", new String[]{});
        while(c.moveToNext()) {
            int FloorId = c.getInt(0);
            int StoreId = c.getInt(1);
            String FloorName = c.getString(2);
            String FloorCategory = c.getString(3);
            String FloorColor = c.getString(4);
            String FloorSize = c.getString(5);
            String FloorBrand = c.getString(6);
            String FloorPrice = c.getString(7);


            Floors.add(new Floor(FloorId, StoreId, FloorName, FloorCategory, FloorColor,FloorSize, FloorBrand, FloorPrice));
        }
        return Floors;
    }
    //add Floor
    public void addProduct(Floor FL)
    {
        db = openHelper.getWritableDatabase();
        db.execSQL("Insert INTO Floor(FloorId, StoreId, FloorName, FloorCategory, FloorColor,FloorSize, FloorBrand, FloorPrice) values(?,?,?,?,?,?,?,?)",
                new Object[]{FL.getFloorId(),
                        FL.getStoreId(),
                        FL.getFloorName().trim(),
                        FL.getFloorCategory().trim(),
                        FL.getFloorColor().trim(),
                        FL.getFloorSize().trim(),
                        FL.getFloorPrice().trim()});
        //db.close();
    }

    //Delete Floor
    public void deleteProduct(Integer id){
        db = openHelper.getWritableDatabase();
        db.execSQL("delete from Floor Where FloorId = ?", new Object[]{id});
    }
    //public void insert

    public void test(int id) {

    }

    //update Floor
    public void updateProduct(Floor FL)
    {
        db = openHelper.getWritableDatabase();
        db.execSQL("update Floor set Floorname=?,FloorCategory=?, FloorSize=?, FloorBrand=?,FloorPrice=? where FloodId = ?",
                new Object[]{FL.getFloorName(),FL.getFloorCategory(), FL.getFloorColor(),FL.getFloorSize(),FL.getFloorBrand(),FL.getFloorPrice(),FL.getFloorId()});
    }

    //Login check
    public boolean loginCheck(String username, String password)
    {
        boolean check = false;
        db = openHelper.getReadableDatabase();
        c = db.rawQuery("select * from User Where UserName= '"+ username + "'", new String[]{});
        if(c.moveToFirst()){
            String UserPassword = c.getString(2);
            if(password.equals(UserPassword))
            {
                check = true;
            }
            else
            {
                check = false;
            }
        }
        return check;
    }
}
