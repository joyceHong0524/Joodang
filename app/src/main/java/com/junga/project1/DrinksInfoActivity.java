package com.junga.project1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class DrinksInfoActivity extends AppCompatActivity implements View.OnClickListener{

    Placeholder placeHolder;
    private ConstraintLayout layout;
    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_info);

        layout= (ConstraintLayout) findViewById(R.id.layout);

        button1 =(Button) findViewById(R.id.button5);
        button2 =(Button) findViewById(R.id.button6);
        button3 =(Button) findViewById(R.id.button7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }

    public void swapView(View v){
        TransitionManager.beginDelayedTransition(layout);
        placeHolder.setContentId(v.getId());

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button5){
            generateSnackBar(1);
        }else if(view.getId() ==R.id.button6){
            generateSnackBar(2);
        }else if (view.getId() == R.id.button7){
            generateSnackBar(3);
        }
    }

    public void generateSnackBar(int id){
        if(id ==1) {
            Snackbar snackbar = Snackbar.make(layout, "It is about 1 dollor/bottle :D", Snackbar.LENGTH_LONG);
            snackbar.show();
        }else if(id==2){
            Snackbar snackbar = Snackbar.make(layout,"Almost 18%, Slow donw when you drink :p",Snackbar.LENGTH_LONG);
            snackbar.show();
        }else if(id==3){
            Snackbar snackbar = Snackbar.make(layout,"There are a lot of fruit flavors !!",Snackbar.LENGTH_LONG);
            snackbar.show();
        }


    }
}
