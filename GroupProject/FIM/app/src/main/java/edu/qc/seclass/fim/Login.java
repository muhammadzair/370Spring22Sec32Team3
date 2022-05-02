 package edu.qc.seclass.fim;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    String correct_username = "employee";
    String correct_password = "password";

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        // Variables
        Button loginBtn = (Button) findViewById(R.id.empLogin_btn_login);
        Button registerBtn = (Button) findViewById(R.id.empLogin_btn_register);

        // On login click
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Input variables
                EditText empId = (EditText) findViewById(R.id.empLogin_input_id);
                EditText empPass = (EditText) findViewById(R.id.empLogin_input_pass);
                // Input values
                String empIdText = empId.getText().toString();
                String empPassText = empPass.getText().toString();


                // Validation cases. If logged in, load EmployeeHomeActivity
                if(checkEmpID == false) {
                    Toast.makeText(getApplicationContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                } else if (checkEmp == true) {
                    Toast.makeText(getApplicationContext(), "Logged in!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EmployeeLoginActivity.this, EmployeeHomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect pass", Toast.LENGTH_SHORT).show();
                }
            }
        });

        
