package com.example.second;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity
{
    EditText uname, pass;
    Button login,regbtn;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        regbtn=findViewById(R.id.regbtn);
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(view ->
        {
//            FirebaseUser user = auth.getCurrentUser();

            if (uname.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Fill the required Fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String email = uname.getText().toString();
                String password = pass.getText().toString();
                //Login Authentication Code
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,task -> {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, dashboard_consultant.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "email or password is invalid", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });


        regbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, registeration_consultant.class);
                startActivity(intent);

//                return false;
            }
        });

    }
}












