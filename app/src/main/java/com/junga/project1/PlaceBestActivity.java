package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.junga.project1.lib.RoundedCorner;

import java.security.MessageDigest;
import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BitmapTransformation;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlaceBestActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    int place;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_best);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
//        Bitmap d = BitmapFactory.decodeResource(this.getResources(),R.drawable.card_gangnam);
//        d = RoundedCorner.getRoundCornerBitmap(d,180);
//        Glide.with(this).load(d).into(imageView);
//        imageView.setClipToOutline(true);

        Intent intent = getIntent();
        place = intent.getIntExtra("type",0);


        setRecyclerView();



    }

    private void setRecyclerView(){
        ArrayList<RestaurantVO> arrayList = new ArrayList<>();


        switch (place){
            case CardPagerAdatper.HONGDAE:

                arrayList.add(new RestaurantVO("Hongdae",R.drawable.hongdae,"GaeWhaGi Yojeong","Traditional, izakaya, bit pricy","4.3 (201)","Seogyo Dong","2 AM"));
                arrayList.add(new RestaurantVO("Hongdae",R.drawable.hongdae,"GaeWhaGi Yojeong","Traditional, izakaya, bit pricy","4.3 (201)","Seogyo Dong","2 AM"));
                arrayList.add(new RestaurantVO("Hongdae",R.drawable.hongdae,"GaeWhaGi Yojeong","Traditional, izakaya, bit pricy","4.3 (201)","Seogyo Dong","2 AM"));
                break;
            case CardPagerAdatper.GANGNAM:

                break;

            case CardPagerAdatper.ITAEWON:


                break;

        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdpater adapter = new RecyclerViewAdpater(this,place,arrayList); //set place type so that adpater bind the image and data.



        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
}
