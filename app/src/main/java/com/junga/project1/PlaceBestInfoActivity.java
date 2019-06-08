package com.junga.project1;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceBestInfoActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    private static final String TAG = "PlaceBestInfoActivity";
    
    RestaurantVO resData;
    ImageView titleImage;
    TextView resName,star,resAddress,resOpenClose,resPrice,resDescription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        resData = (RestaurantVO) getIntent().getSerializableExtra("restaurant");

        titleImage = (ImageView) findViewById(R.id.title_image);
        resName = (TextView) findViewById(R.id.res_name);
        star = (TextView) findViewById(R.id.star);
        resAddress = (TextView) findViewById(R.id.res_address);
        resPrice =(TextView) findViewById(R.id.price);
        resOpenClose = (TextView) findViewById(R.id.res_openclose);
        resDescription =(TextView) findViewById(R.id.res_description);

        setView();





        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng PLACE = new LatLng(resData.getLatitude(),resData.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(PLACE);
        markerOptions.title(resData.getName());
        markerOptions.snippet("Let's get drunk here!");
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(PLACE));

    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.button){
            Double myLatitude = resData.getLatitude();
            Double myLongitude = resData.getLongitude();
            String labelLocation = resData.getName(); //I don't know why but this label doesn't work.
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + myLatitude  + ">,<" + myLongitude + ">?q=<" + myLatitude  + ">,<" + myLongitude + ">(" + labelLocation + ")"));
            startActivity(intent);
        }
    }

    private void setView(){

        Glide.with(this).load(resData.getDrawable()).into(titleImage);
        resName.setText(resData.getName());
        star.setText(resData.getStar());
        resAddress.setText(resData.getResAddress());
        resOpenClose.setText(resData.getResOpenClose());
        resPrice.setText(resData.getResPrice());
        resDescription.setText(resData.getResDescription());

    }
}
