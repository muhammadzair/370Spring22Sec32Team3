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
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validate inputs
                if(TextUtils.isEmpty(username.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(Login.this, "Empty Entry Provided", Toast.LENGTH_LONG).show();
                } else if(username.getText().toString().equals(correct_username)){
                    //validate password
                    if(password.getText().toString().equals(correct_password)){
                        Toast.makeText(Login.this, "Login Success", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Login.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Login.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
