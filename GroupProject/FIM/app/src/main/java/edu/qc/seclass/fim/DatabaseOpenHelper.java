package edu.qc.seclass.fim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    //constructor
    Context dbcontext;
    String dbname;
    String dbpath;

    public DatabaseOpenHelper(Context context, String name, int version){
        super(context, name, null, version);
        this.dbcontext = context;
        this.dbname = name;

        this.dbpath = "/data/data/edu.qc.seclass.fim/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CheckDB(){
        SQLiteDatabase checkDB = null;
        String filepath = dbpath + dbname;
        try{
            checkDB = SQLiteDatabase.openDatabase(filepath,null,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(checkDB != null){
            Toast.makeText(dbcontext,"DB exist", Toast.LENGTH_SHORT).show();
        }else{
            CopyDB();
        }
    }

    public void CopyDB(){
        this.getReadableDatabase();

        try {
            InputStream is = dbcontext.getAssets().open(dbname);
            OutputStream os = new FileOutputStream(dbpath + dbname);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = is.read()) > 0){
                os.write(buffer,0,length);
                os.flush();
                is.close();
                os.close();
            }
        }catch (Exception e){
                e.printStackTrace();
        }
        Log.d("CopyBD","copied");
    }

    public void OpenDatabsse(){
        String filepath = dbpath + dbname;
        SQLiteDatabase.openDatabase(filepath,null,0);
    }
}
