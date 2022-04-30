package edu.qc.seclass.fim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHelper {

    //dbname to import
    private final String DB_NAME = "FIMDatabase.db";
    private SQLiteDatabase myDatabase;
    private Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    // copydb file
    public String CopyDBfile() throws IOException {

        // import db in to /data/data/package/databases/
        // context.getPackageName() to take package name
        File dir = new File("data/data/" + context.getPackageName() + "/databases");
        //if dir is not exist, create dir
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
        // file
        File file = new File(dir, DB_NAME);
        // input
        InputStream inputStream = null;
        // output
        OutputStream outputStream = null;
        //if emulator don't have the file, will import file into emulator

        if (!file.exists()) {
            try {
                //create file
                file.createNewFile();
                //read file
                inputStream = context.getClass().getClassLoader().getResourceAsStream("assets/" + DB_NAME);
                //output to file
                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }


            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                //close
                if (outputStream != null) {

                    outputStream.flush();
                    outputStream.close();

                }
                if (inputStream != null) {
                    inputStream.close();
                }

            }

        }
        return file.getPath();
    }
}
