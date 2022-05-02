package edu.qc.seclass.fim;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //this will create textview in linear layout
        LinearLayout result_table = findViewById(R.id.result_table);
        TextView t = new TextView(this);
        t.setText("something");
        result_table.addView(t);

    }
}