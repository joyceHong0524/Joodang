package com.junga.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PlaceActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "PlaceActivity";
    Button hongdae;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        hongdae = (Button) findViewById(R.id.button2);
        hongdae.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button2){

            Intent intent = new Intent(this,PlaceBestActivity.class);
            startActivity(intent);
        }


    }
}
