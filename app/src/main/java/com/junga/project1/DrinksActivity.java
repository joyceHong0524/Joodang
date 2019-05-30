package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DrinksActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DrinksActivity";

    ViewPager viewPager;

    private CardPagerAdatper mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

         mCardAdapter = new CardPagerAdatper();

         mCardShadowTransformer = new ShadowTransformer(viewPager,mCardAdapter);
         mCardShadowTransformer.enableScaling(true);
         viewPager.setPageTransformer(false,mCardShadowTransformer);
         viewPager.setOffscreenPageLimit(3);
         viewPager.setPageMargin(30);
         viewPager.setAdapter(mCardAdapter);
        Log.d(TAG, "currentItem " + viewPager.getCurrentItem());




    }

    @Override
    public void onClick(View view) {

    }




}
