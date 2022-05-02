package edu.qc.seclass.fim;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class Search extends AppCompatActivity {

    EditText checkProductName;
    EditText checkStoreName;
    private Button searchproduct;
    private Button searchstore;
    TextView searchResult;
    DatabaseAccess DBAccess;
    String result;
    Floor FL;
    List<Floor> FLS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        checkProductName = findViewById(R.id.enter_product_name);
        checkStoreName = findViewById(R.id.enter_store_name);
        searchproduct = findViewById(R.id.search_button1);
        searchstore = findViewById(R.id.search_button2);
        //searchResult = findViewById(R.id.textView6);

        DBAccess = new DatabaseAccess(this);


        searchproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkProductName.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter a product name!", Toast.LENGTH_LONG).show();
                }else{
                    Log.d("test","get text"+ checkProductName.getText().toString());
                    FL = DBAccess.getByProductName(checkProductName.getText().toString());
                    Log.d("test","get result"+ result);
                    //searchResult.setText(DBAccess.getProductByName(checkProductName.getText().toString()));
                    //searchResult.setText(DBAccess.getProductByName(checkProductName.getText().toString()));
                    //openSearchresult();
                }

            }

        });

        searchstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkStoreName.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter a Store name!", Toast.LENGTH_LONG).show();
                }else{
                    Log.d("test","get text"+ checkStoreName.getText().toString());
                    //result = DBAccess.getProductStoreName(checkStoreName.getText().toString());
                    FLS = DBAccess.getByStore(checkStoreName.getText().toString());
                    Log.d("test","get result"+ FL.toString());
                    //searchResult.setText(DBAccess.getProductByName(checkProductName.getText().toString()));
                    //searchResult.setText(DBAccess.getProductByName(checkProductName.getText().toString()));
                    //openSearchresult();
                }
            }
        });

    }


    public void openSearchresult(){
        Intent intent = new Intent(this, SearchResult.class);

        startActivity(intent);
    }
}