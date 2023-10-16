package com.example.consultant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

public class drawer_DB extends AppCompatActivity {
    private EditText editTextId;
    private DrawerLayout drawerlayout;
    private NavigationView nav_view;
    private Toolbar toolbar;
    private EditText editTextName;
    private EditText editTextPrice;
    private Button buttonSave;
    private Button buttonUpdate;
    private Button buttonDelete;
    private FirebaseFirestore firestore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        firestore = FirebaseFirestore.getInstance();
        drawerlayout = findViewById(R.id.drawerlayout);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.navigationopen, R.string.navigationclose);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();

                if (id == R.id.nav_profile)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, profile.class);
                    startActivity(intent);
                }

                else if (id == R.id.nav_help)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, help.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_logout)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, MainActivity.class);
                    startActivity(intent);
                }

                else if (id == R.id.nav_faq)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, consulthelp.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_userinfo)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, userinfo.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_rateus)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, rateus.class);
                    startActivity(intent);
                }
                drawerlayout.closeDrawers(); // Close the drawer after handling the item click
                return true;

            }

        });

}
}

