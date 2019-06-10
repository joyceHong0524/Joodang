package com.junga.project1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class DrinksActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DrinksActivity";

    private ViewPager viewPager;
    private Button learnMore;
    private TextView goBack;

    private ConstraintLayout layout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        viewPager = findViewById(R.id.viewPager);
        learnMore = findViewById(R.id.button4);
        goBack = findViewById(R.id.go_back);
        layout = findViewById(R.id.layout);

        learnMore.setOnClickListener(this);
        goBack.setOnClickListener(this);

        CardPagerAdatper mCardAdapter = new CardPagerAdatper(CardPagerAdatper.DRINK_CARD, this);

        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(viewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        viewPager.setPageTransformer(false, mCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(30);
        viewPager.setAdapter(mCardAdapter);
        Log.d(TAG, "currentItem " + viewPager.getCurrentItem());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //따로 클릭이벤트는 설정해야됨 android.R.id.home으로다
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.go_back) {
            finish();
        } else if (view.getId() == R.id.button4) {

            Random random = new Random();
            int i = random.nextInt(5);

            ArrayList<String> funfacts = new ArrayList<>();
            funfacts.add("Soju is a distilled colorless beverage that can be as strong as 53% down to 16.8%");
            funfacts.add("Koreans drink twice as much alcohol as russians.");
            funfacts.add("South Koreans drink 13.7 shots of liquor per week on average, which is the most in the world.");
            funfacts.add("In fact, the South Korean liquor accounts for 97% of the country’s spirits market.");
            funfacts.add("Pouring your own glass in a group is considered impolite");
            funfacts.add("Korean would drink to celebrate holidays and show respect for ancestors.");

            Snackbar snackbar = Snackbar.make(layout, funfacts.get(i), Snackbar.LENGTH_LONG);
            snackbar.show();


        }


    }


}
