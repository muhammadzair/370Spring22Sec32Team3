package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Welcome extends AppCompatActivity {

    private Button tosearch;
    private Button tologin;
    DatabaseOpenHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        dbhelper = new DatabaseOpenHelper(this,"FIMDatabase.db",1);
        try {
            dbhelper.CheckDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            dbhelper.OpenDatabsse();
        }catch (Exception e){
            e.printStackTrace();
        }

        tosearch = findViewById(R.id.to_search);
        tosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearch();
            }
        });

        tologin = findViewById(R.id.to_login);
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

    }

    public void openSearch(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}