package com.junga.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class DrinksActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView image1;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setViewPager();

        image1 = (ImageView) findViewById(R.id.imageView);
        image1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(DrinksActivity.this,DrinksInfoActivity.class);
        startActivity(intent);

    }

    private void setViewPager(){
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);
    }
}
