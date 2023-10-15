package com.example.consultant;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.GridView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//
//import com.google.android.material.navigation.NavigationView;
//
//import org.checkerframework.checker.units.qual.C;
//
//
//public class dashboard extends AppCompatActivity implements View.OnClickListener{
//
//
//    private CardView dat1, dat2, dat3, dat4, dat5, dat6, dat7, dat8, dat9;
//    private CardView card1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);
//
//        dat1 = findViewById(R.id.d1);
//        dat2 = findViewById(R.id.d2);
//        dat3 = findViewById(R.id.d3);
//        dat4 = findViewById(R.id.d4);
//        dat5 = findViewById(R.id.d5);
//        dat6 = findViewById(R.id.d6);
//        dat7 = findViewById(R.id.d7);
//        dat8 = findViewById(R.id.d8);
//        dat9 = findViewById(R.id.d9);
//
//        dat1.setOnClickListener((View.OnClickListener) this);
//        dat2.setOnClickListener((View.OnClickListener) this);
//        dat3.setOnClickListener((View.OnClickListener) this);
//        dat4.setOnClickListener((View.OnClickListener) this);
//        dat5.setOnClickListener((View.OnClickListener) this);
//        dat6.setOnClickListener((View.OnClickListener) this);
//        dat7.setOnClickListener((View.OnClickListener) this);
//        dat8.setOnClickListener((View.OnClickListener) this);
//        dat9.setOnClickListener((View.OnClickListener) this);
//
//        @SuppressLint("WrongViewCast") CardView card1 = findViewById(R.id.card1);
//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(dashboard.this, card1.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        Intent i;
//        switch (v.getId()) {
//            case R.id.d1:
//                i = new Intent(this, d1.class);
//                startActivity(i);
//                break;
//            case R.id.d2:
//                i = new Intent(this, d2.class);
//                startActivity(i);
//                break;
//            case R.id.d3:
//                i = new Intent(this, d3.class);
//                startActivity(i);
//                break;
//            case R.id.d4:
//                i = new Intent(this, d4.class);
//                startActivity(i);
//                break;
//            case R.id.d5:
//                i = new Intent(this, d5.class);
//                startActivity(i);
//                break;
//            case R.id.d6:
//                i = new Intent(this, d6.class);
//                startActivity(i);
//                break;
//            case R.id.d7:
//                i = new Intent(this, d7.class);
//                startActivity(i);
//                break;
//            case R.id.d8:
//                i = new Intent(this, d8.class);
//                startActivity(i);
//                break;
//            case R.id.d9:
//                i = new Intent(this, d9.class);
//                startActivity(i);
//                break;
//        }
//
//    }
//}
//NEW CODE FOR THE BUTTON
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class dashboard extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);
//
//        Button cardButton1 = findViewById(R.id.cardbutton1);
//
//        cardButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(dashboard.this, card1.class);
//                startActivity(intent);
//            }
//        });
//    }
//}

//<androidx.appcompat.widget.AppCompatButton
//        android:id="@+id/cardbutton1"
//        android:layout_width="50dp"
//        android:layout_height="50dp"
//        android:layout_marginLeft="105dp"
//        android:layout_marginTop="90dp"
//        android:background="@drawable/button2"
//        android:text=">" />