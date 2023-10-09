package com.example.consultant;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
{
    EditText uname, pass;
    Button login,regbtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
        TextInputEditText passEditText = findViewById(R.id.pass);

        passEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                passwordTextInputLayout.setHint("");
            } else {
                passwordTextInputLayout.setHint("Password");
            }
        });
        passwordTextInputLayout.setEndIconOnClickListener(v -> {
            // Toggle password visibility
            int inputType = passEditText.getInputType();
            if (inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                passEditText.setInputType(
                        InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                passEditText.setInputType(
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
            passEditText.setSelection(passEditText.getText().length());
        });



    uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        regbtn=findViewById(R.id.regbtn);
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(view ->
        {
//            FirebaseUser user = auth.getCurrentUser();

            if (uname.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Fill the required Fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String email = uname.getText().toString();
                String password = pass.getText().toString();
                //Login Authentication Code
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,task -> {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, drawer_DB.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "email or password is invalid", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });


        regbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, registration_page.class);
                startActivity(intent);

//                return false;
            }
        });

    }
}












