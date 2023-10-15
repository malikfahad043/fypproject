package com.example.consultant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.second.LoginActivity;

public class myfirstpage extends AppCompatActivity {

    Button consultant, consultee;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfirstpage);

        consultee=findViewById(R.id.consultee);
        consultant=findViewById(R.id.consultant);

        consultant.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(myfirstpage.this, LoginActivity.class);
                startActivity(intent);

            }

        });
        consultee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(myfirstpage.this, MainActivity.class);
                startActivity(intent);

//                return false;
            }
        });
    }

}