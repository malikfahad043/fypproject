package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myapplication.R; // Make sure to import your R class properly.
import com.example.myapplication.account_settings;
import com.example.myapplication.app_settings;

public class SettingsUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_ui);

        Button settingsButton1 = findViewById(R.id.settingsbutton1);
        Button settingsButton2 = findViewById(R.id.settingsbutton2);

        settingsButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsUI.this, account_settings.class);
                startActivity(intent);
            }
        });

        settingsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsUI.this, app_settings.class);
                startActivity(intent);
            }
        });
    }
}
