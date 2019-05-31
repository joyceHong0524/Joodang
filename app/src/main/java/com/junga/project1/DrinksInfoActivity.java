package com.junga.project1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

public class DrinksInfoActivity extends AppCompatActivity {

    Placeholder placeHolder;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_info);

        layout= (ConstraintLayout) findViewById(R.id.layout);

    }

    public void swapView(View v){
        TransitionManager.beginDelayedTransition(layout);
        placeHolder.setContentId(v.getId());

    }
}
