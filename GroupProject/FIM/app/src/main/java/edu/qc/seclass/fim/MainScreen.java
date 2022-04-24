package edu.qc.seclass.fim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.qc.seclass.fim.databinding.ActivityMainScreenBinding;

public class MainScreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainScreenBinding binding;


    public EditText name;
    public Button query_button;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_screen);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //now setting onclicklistener to query button
        query_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the instance of database access class and open database connect
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                //getting string value from edittext

                String n = name.getText().toString();
                String information = databaseAccess.getInformation(1);

                //setting text to result filed
                result.setText((information));

                databaseAccess.close();
                //database connection close
            }
        });

        }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_screen);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}