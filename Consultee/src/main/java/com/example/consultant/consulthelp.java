package com.example.consultant;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.consultant.R;

public class consulthelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulthelp);

        LinearLayout faqContainer = findViewById(R.id.faq_container);

        // Add FAQ items dynamically
        addFaqItem(faqContainer, "How do I create a consultant profile?", "To create a consultant profile, go to the 'Profile' section and click on the 'Create Profile' button. Follow the prompts to provide your information and expertise.");
        addFaqItem(faqContainer, "How can I edit my availability for consultations?", "You can edit your availability at any time. Navigate to the 'Availability' section in your profile and make the necessary changes.");
        addFaqItem(faqContainer, "What should I do if I forgot my password?", "If you've forgotten your password, you can click on the 'Forgot Password' link on the login screen. Follow the prompts to reset your password via email.");
        addFaqItem(faqContainer, "How do I set my consultation rates?", "You can set your consultation rates in the 'Consultation Settings' section of your profile. Simply enter the desired rate and save your changes.");
        addFaqItem(faqContainer, "Can I offer consultations in multiple categories?", "Yes, you can offer consultations in multiple categories. In the 'Profile' section, you can add additional expertise and specify the category for each.");
        addFaqItem(faqContainer, "How long does it take for payments to be processed?", "Payments are typically processed within 2-3 business days. You can view your transaction history in the 'Payments' section of your profile.");
    }

    private void addFaqItem(LinearLayout container, String question, String answer) {
        LinearLayout faqItemLayout = new LinearLayout(this);
        faqItemLayout.setOrientation(LinearLayout.VERTICAL);

        TextView questionTextView = new TextView(this);
        questionTextView.setText("Q: " + question);
        questionTextView.setTextSize(18);

        TextView answerTextView = new TextView(this);
        answerTextView.setText("A: " + answer);
        answerTextView.setTextSize(16);

        container.addView(questionTextView);
        container.addView(answerTextView);
    }
}
