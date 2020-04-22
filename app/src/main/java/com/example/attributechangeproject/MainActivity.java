package com.example.attributechangeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayoutBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChangeBackground = findViewById(R.id.btnChangeBackground);
        constraintLayoutBackground = findViewById(R.id.constraintLayoutBackground);
        btnChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(225,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
                constraintLayoutBackground.setBackgroundColor(color);
            }
        });
    }
}
