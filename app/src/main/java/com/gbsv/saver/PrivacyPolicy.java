package com.gbsv.saver;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        Toolbar toolbar = findViewById(R.id.toolbarPolicy);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.policy_view);

        textView.setText("Our app, GB Saver, is committed to respecting your privacy and collecting personal information only when necessary to provide you with our services. We do this in a fair and lawful manner, with your knowledge and consent, and we ensure that you know why we are collecting your information and how it will be used.\n" +
                "\n" +
                "We will retain your information only for as long as necessary to provide the service you have requested, and we will take commercially acceptable measures to protect the data we store from loss, theft, unauthorized access, disclosure, copying, use, or modification.\n" +
                "\n" +
                "We do not share personally identifying information publicly or with third parties, except when required by law. Please note that our app may link to external sites whose content and practices we cannot control, and we are not responsible for their privacy policies.\n" +
                "\n" +
                "You have the right to refuse to provide your personal information, but please understand that this may limit your access to some of our services. By continuing to use our app, you are indicating your acceptance of our privacy practices and policies. If you have any questions about how we handle user data and personal information, please do not hesitate to contact us.\n" +
                "\n" +
                "This privacy policy has been in effect since April 20, 2023.");

    }
}