package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Bookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        Button bookingButton1 = findViewById(R.id.bookingbutton1);
        Button bookingButton3 = findViewById(R.id.bookingbutton3);
        Button bookingButton5 = findViewById(R.id.bookingbutton5);
        Button bookingButton6 = findViewById(R.id.bookingbutton6);

        bookingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookings.this, CurrentBookings.class);
                startActivity(intent);
            }
        });

        bookingButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookings.this, BookingsExtended.class);
                startActivity(intent);
            }
        });

        bookingButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookings.this, previousclients.class);
                startActivity(intent);
            }
        });

        bookingButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookings.this, hours_available.class);
                startActivity(intent);
            }
        });
    }
}
