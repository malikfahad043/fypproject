//package com.example.second;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.MenuItem;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import com.google.android.material.navigation.NavigationView;
//
//public class DashboardActivity extends AppCompatActivity {
//
//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle toggle;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard_consultant);
//
//        drawerLayout = findViewById(R.id.drawer_layout);
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
////        NavigationView navigationView = findViewById(R.id.nav_view);
////        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                // Handle item clicks here
//                if (id == R.id.nav_consultee1) {
//                    // Handle "View Clients" click
//                } else if (id == R.id.nav_consultee2) {
//                    // Handle "Add New Clients" click
//                } // Add more conditions for other items
//
//                drawerLayout.closeDrawer(Gravity.LEFT);
//                return true;
//            }
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
//
//
////        Button button1 = findViewById(R.id.button1);
////        button1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openEditProfileUI();
////            }
////        });
////
////        Button button2 = findViewById(R.id.button2);
////        button2.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openConsulteesActivity();
////            }
////        });
////
////        Button button3 = findViewById(R.id.button3);
////        button3.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openBookingsActivity();
////            }
////        });
////
////        Button button4 = findViewById(R.id.button4);
////        button4.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openMessagesActivity();
////            }
////        });
////
////        Button button5 = findViewById(R.id.button5);
////        button5.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openSettingsActivity();
////            }
////        });
////    }
////
////    public void openEditProfileUI() {
////        Intent intent = new Intent(this, profile.class);
////        startActivity(intent);
////    }
////
////    public void openConsulteesActivity() {
////        Intent intent = new Intent(this, ConsulteesUI.class);
////        startActivity(intent);
////    }
////
////    public void openBookingsActivity() {
////        Intent intent = new Intent(this, Bookings.class);
////        startActivity(intent);
////    }
////
////    public void openMessagesActivity() {
////        Intent intent = new Intent(this, messages.class);
////        startActivity(intent);
////    }
////
////    public void openSettingsActivity() {
////        Intent intent = new Intent(this, SettingsUI.class);
////        startActivity(intent);
////    }
////}