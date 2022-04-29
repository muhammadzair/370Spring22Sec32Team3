package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Search extends AppCompatActivity {

    private Button searchproduct;
    private Button searchstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchproduct = findViewById(R.id.search_button1);
        searchstore = findViewById(R.id.search_button2);

    }

    public void openSearchresult(){
        Intent intent = new Intent(this, SearchResult.class);
        startActivity(intent);
    }
}