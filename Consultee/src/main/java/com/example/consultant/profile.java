package com.example.consultant;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.integrity.e;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class profile extends AppCompatActivity
{
    private EditText phoneno, emailaddress;
    private EditText user_cnic;
    private EditText dob;
    private EditText editName;
    private EditText age;
    private ImageView profileImage;
    private Button chooseImageBtn;
    private Button buttonSave;
    private Button buttonUpdate;
    private Button buttonDelete;
    private RadioGroup radioGroup;
    private FirebaseFirestore firestore;
    private StorageReference storageReference;
    private static final int PICK_IMAGE_REQUEST = 1;

//TO SELECT THE IMAGE FROM THE PHONE
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            profileImage.setImageURI(imageUri);
            profileImage.setVisibility(View.VISIBLE); // Make the header visible

            // Save the image URI to SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("ImageUri", imageUri.toString());
            editor.apply();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        phoneno = findViewById(R.id.phoneno);
        emailaddress = findViewById(R.id.emailaddress);
        editName = findViewById(R.id.editName);
        age = findViewById(R.id.age);
        user_cnic=findViewById(R.id.user_cnic);
        dob=findViewById(R.id.dob);
        profileImage = findViewById(R.id.profileImage);
        chooseImageBtn = findViewById(R.id.chooseImageBtn);
        buttonSave = findViewById(R.id.buttonSave);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        radioGroup = findViewById(R.id.radio_group_gender);
        //        CHOOSE IMAGE
        chooseImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
//        RADIO BUTTONS
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_button_male) {
                    Toast.makeText(profile.this, "Male selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio_button_female) {
                    Toast.makeText(profile.this, "Female selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //SAVE BUTTON TO FIRESTORE
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save data to Firestore
                saveToFirestore();
                // Save data to SharedPreferences
                saveUserDetails();
            }
        });
        // Set a click listener on the update button
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInFirestore();
//                return false;
            }
        });

        // Set a click listener on the delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFromFirestore();
//                return false;
            }
        });
    }
//NEW CODE
private void saveUserDetails() {
    String firstName = editName.getText().toString().trim();
    String phoneNumber = phoneno.getText().toString().trim();
    String email = emailaddress.getText().toString().trim();
    String userAge = age.getText().toString().trim();
    String usercnic = user_cnic.getText().toString().trim();
    String userdob = dob.getText().toString().trim();
    // Save user details using SharedPreferences
    SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("Name", firstName);
    editor.putString("PhoneNumber", phoneNumber);
    editor.putString("Email", email);
    editor.putString("Age", userAge);
    editor.putString("Cnic", usercnic);
    editor.putString("Dob", userdob);
    editor.apply();
}
    private void saveToFirestore() {
        // Get the entered data
        String productName = editName.getText().toString().trim();

        String productEmail = emailaddress.getText().toString().trim();
        String productNo = phoneno.getText().toString().trim();
        String productAge = age.getText().toString().trim();
        String productcnic = user_cnic.getText().toString().trim();
        String productdob = dob.getText().toString().trim();
        double productPrice = Double.parseDouble(age.getText().toString().trim());
        // Create a new product object
        Map<String, Object> product = new HashMap<>();
        product.put("Name", productName);
        product.put("Email", productEmail);
        product.put("Phone Number", productNo);
        product.put("age", productAge);
        product.put("cnic", productcnic);
        product.put("dob", productdob);
//        product.put("image",profileImage);
        // Add the product to Firestore
        firestore.collection("products")
                .document(productNo)
                .set(product)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data added successfully
                        Intent intent = new Intent(profile.this, userinfo.class);
                        intent.putExtra("Name", productName);
                        intent.putExtra("Email", productEmail);
                        intent.putExtra("Phone Number", productNo);
                        intent.putExtra("age", productAge);
                        intent.putExtra("cnic", productcnic);
                        intent.putExtra("dob", productdob);
                        startActivity(intent);
                        Toast.makeText(profile.this, "Product saved to Firestore", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(profile.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    // Save profile data to the database
    private void saveProfileDataToDatabase(String editName, String emailaddress, int phoneno, int age, int cnic, int dob) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference consultantsRef = database.getReference("consultants");

        // Generate a unique ID for each consultant entry
        DatabaseReference newConsultantRef = consultantsRef.push();

        // Save the profile data under the generated ID
        newConsultantRef.child("name").setValue(editName);
        newConsultantRef.child("emailaddress").setValue(emailaddress);
        newConsultantRef.child("phoneno").setValue(phoneno);
        newConsultantRef.child("age").setValue(age);
        newConsultantRef.child("cnic").setValue(cnic);
        newConsultantRef.child("dob").setValue(dob);
    }

    // Retrieve consultant data from the database and update UI
    private void loadConsultantDataFromDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference consultantsRef = database.getReference("consultants");

        // Add a listener to fetch the consultant data
        consultantsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Clear previous data from the UI

                // Iterate through the consultant entries
                for (DataSnapshot consultantSnapshot : dataSnapshot.getChildren()) {
                    // Retrieve the consultant data
                    String name = consultantSnapshot.child("name").getValue(String.class);
                    String domain = consultantSnapshot.child("domain").getValue(String.class);
                    int age = consultantSnapshot.child("age").getValue(Integer.class);
                    int experience = consultantSnapshot.child("experience").getValue(Integer.class);

                    // Update the UI with the consultant data
                    // Display the retrieved data in the "Consultant" item of the drawer
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle database error
            }
        });
    }
    //      THIS IS THE SEPERATE CODE DONT TOUCH THIS!!!!!!!!!!
    private void updateInFirestore() {
        // Get the entered data
        String productId = phoneno.getText().toString().trim();
        String productName = editName.getText().toString().trim();
        double productPrice = Double.parseDouble(age.getText().toString().trim());

        // Create a new product object
        Map<String, Object> product = new HashMap<>();
        product.put("name", productName);
        product.put("price", productPrice);

        // Update the product in Firestore
        firestore.collection("products")
                .document(productId)
                .update(product)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data updated successfully
                        Toast.makeText(profile.this, "Product updated in Firestore", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        // Error occurred while updating data
                        Toast.makeText(profile.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void deleteFromFirestore() {
        // Get the entered data
        String productId = phoneno.getText().toString().trim();

        // Delete the product from Firestore
        firestore.collection("products")
                .document(productId)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data deleted successfully
                        Toast.makeText(profile.this, "Product deleted from Firestore", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        // Error occurred while deleting data
                        Toast.makeText(profile.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
