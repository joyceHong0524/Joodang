package com.junga.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import jp.wasabeef.blurry.Blurry;

public class PlaceActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "PlaceActivity";

    ViewPager viewPager;
    TextView top1;
    TextView top2;
    TextView goBack;
    Button random;

    int clicked_page;


    Button hongdae;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_place);
        viewPager = findViewById(R.id.viewPager);

        top1 = (TextView) findViewById(R.id.top1);
        top2 = (TextView) findViewById(R.id.top2);
        goBack = (TextView) findViewById(R.id.go_back);
        random = (Button) findViewById(R.id.random_pick);

        goBack.setOnClickListener(this);
        random.setOnClickListener(this);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.slide_in_half_left);
        top1.setAnimation(animation);
        top2.setAnimation(animation);


        CardPagerAdatper cardPagerAdatper = new CardPagerAdatper(CardPagerAdatper.PLACE_CARD);
        ShadowTransformer shadow = new ShadowTransformer(viewPager,cardPagerAdatper);
        shadow.enableScaling(true);
        viewPager.setPageMargin(30);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageTransformer(false,shadow);
        viewPager.setAdapter(cardPagerAdatper);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.go_back){
            finish();
        }else if (view.getId()==R.id.random_pick){
            Random random = new Random();
            clicked_page = random.nextInt(3);
            Log.d(TAG, "random num :" + clicked_page);
        }

    }
}
