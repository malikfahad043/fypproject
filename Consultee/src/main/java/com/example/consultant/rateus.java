package com.example.consultant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class rateus extends AppCompatActivity {

    private TextView feedbackMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);

        RatingBar ratingBar = findViewById(R.id.rating_bar);
        Button submitRatingButton = findViewById(R.id.submit_rating_button);
        feedbackMessage = findViewById(R.id.feedback_message);

        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rating = (int) ratingBar.getRating();
                displayMessage(rating);
            }
        });
    }

    private void displayMessage(int rating) {
        String message;
        switch (rating) {
            case 1:
                message = "Thank you for your feedback. We're sorry to hear that you're dissatisfied.";
                break;
            case 2:
                message = "Thank you for your feedback. We'll work on improving your experience.";
                break;
            case 3:
                message = "Thank you for your feedback. We're glad you're satisfied, but there's room for improvement.";
                break;
            case 4:
                message = "Thank you for your feedback. We're glad you're satisfied!";
                break;
            case 5:
                message = "Thank you for your feedback. We're thrilled you had such a positive experience!";
                break;
            default:
                message = "Invalid rating.";
                break;
        }
        feedbackMessage.setVisibility(View.VISIBLE);
        feedbackMessage.setText(message);
    }
}
