package com.example.myfooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class StartActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        // Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        // Hooks
        image = findViewById(R.id.logoImage_start);
        logo = findViewById(R.id.logo_name_start);
        slogan = findViewById(R.id.slogan_name_start);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(StartActivity.this,LoginActivity.class);

            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View,String>(image, "logo_image");
            pairs[1] = new Pair<View,String>(logo, "logo_txt");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = new ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, pairs);
                startActivity(intent, options.toBundle());

            } else {

            }
        },SPLASH_SCREEN);
    }
}