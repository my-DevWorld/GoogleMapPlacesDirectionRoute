package com.example.leasemasteronboarding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogIn extends AppCompatActivity {

    private Button login;
    private TextView forgotPassword_label;
    private TextView signUp;
    private RelativeLayout fb_btn;
    private RelativeLayout google_btn;
    private RelativeLayout fullNameWraper;
    private TextInputEditText fullNameEditText;
    private RelativeLayout creatPasswordWraper;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setUp();

    }

    private void setUp(){
        fullNameEditText = findViewById(R.id.fullNameEditText);
        fullNameWraper = findViewById(R.id.fullNameWraper);
        fullNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus ){
                if (Build.VERSION_CODES.LOLLIPOP_MR1 < 22){
                    fullNameWraper.setBackground(getDrawable(R.drawable.orange_border));
                }
                else {
                    fullNameWraper.setBackgroundResource(R.drawable.orange_border);
                }

            }else {
                if (Build.VERSION_CODES.LOLLIPOP_MR1 < 22) {
                    fullNameWraper.setBackground(getDrawable(R.drawable.edit_text_background));
                }
                else {
                    fullNameWraper.setBackgroundResource(R.drawable.edit_text_background);
                }

            }
        });

        passwordEditText = findViewById(R.id.passwordEditText);
        creatPasswordWraper = findViewById(R.id.creatPasswordWraper);
        passwordEditText.setOnFocusChangeListener((v,hasFocus) -> {
            if(hasFocus ){
                if (Build.VERSION_CODES.LOLLIPOP_MR1 < 22){
                    creatPasswordWraper.setBackground(getDrawable(R.drawable.orange_border));
                }
                else {
                    creatPasswordWraper.setBackgroundResource(R.drawable.orange_border);
                }

            }else {
                if (Build.VERSION_CODES.LOLLIPOP_MR1 < 22) {
                    creatPasswordWraper.setBackground(getDrawable(R.drawable.edit_text_background));
                }
                else {
                    creatPasswordWraper.setBackgroundResource(R.drawable.edit_text_background);
                }

            }
        });

        fb_btn = findViewById(R.id.fb_btn);
        fb_btn.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        google_btn = findViewById(R.id.google_btn);
        google_btn.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        login = findViewById(R.id.login);
        login.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        forgotPassword_label = findViewById(R.id.forgotPassword_label);
        forgotPassword_label.setOnClickListener(view -> {
            startActivity(new Intent(this, PasswordReset.class));
        });

        signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(this, Signup.class));
        });
    }

}
