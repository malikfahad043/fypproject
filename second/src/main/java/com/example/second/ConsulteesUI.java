package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class ConsulteesUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultees_ui);

        Button button99 = findViewById(R.id.button99);
        Button button16 = findViewById(R.id.button16);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);

        button99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewClientsIntent = new Intent(ConsulteesUI.this, view_clients.class);
                startActivity(viewClientsIntent);
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNewClientsIntent = new Intent(ConsulteesUI.this, addnewclients.class);
                startActivity(addNewClientsIntent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousClientsIntent = new Intent(ConsulteesUI.this, previousclients.class);
                startActivity(previousClientsIntent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent managePaymentsIntent = new Intent(ConsulteesUI.this, manage_payments.class);
                startActivity(managePaymentsIntent);
            }
        });
    }
}
