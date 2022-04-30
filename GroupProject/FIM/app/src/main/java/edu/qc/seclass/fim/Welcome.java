package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class Welcome extends AppCompatActivity {

    private Button tosearch;
    private Button tologin;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        dbhelper = new DatabaseHelper(Welcome.this);
        try {
            dbhelper.CopyDBfile();
        } catch (IOException e) {
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