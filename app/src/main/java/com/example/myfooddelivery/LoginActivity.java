package com.example.myfooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        // Hooks
        callSignUp = findViewById(R.id.registration_btn);
        image = findViewById(R.id.logoImage);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.enter_btn);

        callSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,SignUp.class);
            startActivity(intent);

            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View,String>(image, "logo_image");
            pairs[1] = new Pair<View,String>(logoText, "logo_txt");
            pairs[2] = new Pair<View,String>(sloganText, "logo_desk");
            pairs[3] = new Pair<View,String>(username, "username_tran");
            pairs[4] = new Pair<View,String>(password, "password_tran");
            pairs[5] = new Pair<View,String>(login_btn, "enter_btn_tran");
            pairs[6] = new Pair<View,String>(callSignUp, "registration_btn_tran");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = new ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}