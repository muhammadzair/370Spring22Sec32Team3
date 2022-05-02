package edu.qc.seclass.fim;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //correct username/password
                        if(username.getText().toString().equals("employee")
                                && password.getText().toString().equals("password")){
                            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            //redirects to another page when login succesfully
                            Intent intent = new Intent(Login.this, UserPage.class);
                            startActivity(intent);
                            finish();
                            //if one of the field is empty
                        } else if (TextUtils.isEmpty(username.getText().toString()) ||
                                TextUtils.isEmpty(password.getText().toString())){
                            Toast.makeText(Login.this, "Empty Entry Provided", Toast.LENGTH_LONG).show();
                        }

                        else
                            //incorrect username/password
                            Toast.makeText(Login.this,"Wrong username or password",Toast.LENGTH_SHORT).show();
                    }
                });

        }
    }
