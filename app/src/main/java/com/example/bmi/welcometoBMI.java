package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class welcometoBMI extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcometo_bmi);

        TextView title = findViewById(R.id.tx1);
        TextView slogan = findViewById(R.id.txt2);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1500);
        title.startAnimation(fadeIn);
        slogan.startAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(welcometoBMI.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}