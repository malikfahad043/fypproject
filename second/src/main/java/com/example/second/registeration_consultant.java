package com.example.second;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class registeration_consultant extends AppCompatActivity {
    EditText u_email, u_pass, u_cpass;
    Button reg;
    private FirebaseAuth auth;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_consultant);
        u_email = findViewById(R.id.u_email);
        u_pass = findViewById(R.id.u_pass);
        u_cpass = findViewById(R.id.u_cpass);
        reg = findViewById(R.id.reg);
        auth = FirebaseAuth.getInstance();


        reg.setOnClickListener(view ->
        {
            if (u_pass.getText().toString().equals(u_cpass.getText().toString()))
            {
                if (u_email.getText().toString().isEmpty() || u_pass.getText().toString().isEmpty())
                {
                    Toast.makeText(registeration_consultant.this, "Fill the required Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String email = u_email.getText().toString();
                    String password = u_pass.getText().toString();
                    //Registeration Code
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(registeration_consultant.this, task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(registeration_consultant.this, "register successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(registeration_consultant.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                Toast.makeText(getApplicationContext(), "Passwords match", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

    }

}












