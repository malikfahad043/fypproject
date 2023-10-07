package com.example.consultant;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class userinfo extends AppCompatActivity {

    private TextView textViewName, textViewPhone, textViewEmail, textViewAge, textViewcnic, textViewdob;

    //new code
    private ImageView userProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhoneNumber);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewAge = findViewById(R.id.textViewAge);
        textViewcnic = findViewById(R.id.textViewcnic);
        textViewdob = findViewById(R.id.textViewdob);
        //new code
        userProfileImage = findViewById(R.id.userProfileImage);

        // Retrieve user details from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", "");
        String email = sharedPreferences.getString("Email", "");
        String phoneNumber = sharedPreferences.getString("PhoneNumber", "");
        String age = sharedPreferences.getString("Age", "");
        String cnic = sharedPreferences.getString("cnic", "");
        String dob = sharedPreferences.getString("dob", "");
        //new code
        String imageUriString = sharedPreferences.getString("ImageUri", "");
//        CircleImageView userProfileImage = findViewById(R.id.userProfileImage);
//        if (!imageUriString.isEmpty()) {
//            Uri imageUri = Uri.parse(imageUriString);
//            userProfileImage.setImageURI(imageUri);
//            userProfileImage.setVisibility(View.VISIBLE);
//            }

        // Update TextViews with user details
        textViewName.setText("Name: " + name);
        textViewEmail.setText("Email: " + email);
        textViewPhone.setText("Phone Number: " + phoneNumber);
        textViewAge.setText("Age: " + age);
        textViewcnic.setText("CNIC: " + cnic);
        textViewdob.setText("Date Of Birth: " + dob);
//
//        //newcode
//        // Load and display the user profile image
//        if (!imageUriString.isEmpty()) {
//            Uri imageUri = Uri.parse(imageUriString);
//            userProfileImage.setImageURI(imageUri);
//            userProfileImage.setVisibility(View.VISIBLE);
//        }
    }
}

