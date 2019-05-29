package com.junga.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    Button buttonInfo;
    Button buttonBest;
    ImageView mainTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInfo = (Button) findViewById(R.id.button_info);
        buttonBest = (Button) findViewById(R.id.button_best);
        mainTop = (ImageView) findViewById(R.id.main_top);

        buttonInfo.setOnClickListener(this);
        buttonBest.setOnClickListener(this);

        //Set animation
        Animation slideInRight = AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_half_right);
        Animation slideInLeft = AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_half_left);

        mainTop.startAnimation(slideInRight);
        buttonInfo.startAnimation(slideInLeft);
        buttonBest.startAnimation(slideInLeft);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_info){
            Intent intent = new Intent(MainActivity.this,DrinksActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            finish();

        } else if (view.getId() == R.id.button_best){
            Intent intent = new Intent(MainActivity.this,PlaceActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            finish();
        }

    }
}
