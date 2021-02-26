package com.example.myfooddelivery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private Animation logoAnim;
    private ImageView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Init();
    }
    private void Init(){
        logoImage = findViewById(R.id.gifImageView);
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        logoImage.startAnimation(logoAnim);
    }
}
