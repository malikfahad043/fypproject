package com.example.second;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import com.google.android.material.navigation.NavigationView;
public class drawer_consultant extends AppCompatActivity {
    private EditText editTextId;
    private DrawerLayout drawer_layout;
    private NavigationView navigation_view;

    private EditText editTextName;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_consultant);
        drawer_layout = findViewById(R.id.drawer_layout);
        navigation_view = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
}}
