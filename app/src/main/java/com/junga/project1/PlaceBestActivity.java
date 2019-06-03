package com.junga.project1;

import android.content.Context;
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

import jp.wasabeef.glide.transformations.BitmapTransformation;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlaceBestActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_best);

//        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
//        Bitmap d = BitmapFactory.decodeResource(this.getResources(),R.drawable.card_gangnam);
//        d = RoundedCorner.getRoundCornerBitmap(d,180);
//        Glide.with(this).load(d).into(imageView);
//        imageView.setClipToOutline(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

      LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdpater adpater = new RecyclerViewAdpater(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpater);


    }
}
