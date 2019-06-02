package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinksActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DrinksActivity";

    ViewPager viewPager;
    Button learnMore;
    TextView goBack;

    private CardPagerAdatper mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        learnMore = (Button) findViewById(R.id.button4);
        goBack = (TextView) findViewById(R.id.go_back);

        learnMore.setOnClickListener(this);
        goBack.setOnClickListener(this);

         mCardAdapter = new CardPagerAdatper(CardPagerAdatper.DRINK_CARD,this);

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

        if (view.getId()==R.id.button4){
            Intent intent = new Intent(DrinksActivity.this,DrinksInfoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up_in,R.anim.slide_up_out);
        } else if (view.getId() == R.id.go_back){
            finish();
        }


    }




}
