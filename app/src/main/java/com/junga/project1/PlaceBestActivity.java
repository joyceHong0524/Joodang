package com.junga.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceBestActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private TextView placeName;
    private int place;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_best);

        recyclerView = findViewById(R.id.recyclerView);
        Intent intent = getIntent();
        place = intent.getIntExtra("type", 0);
        placeName = findViewById(R.id.place_name);
        setRecyclerView();
        setToolbar();
    }

    private void setRecyclerView() {
        ArrayList<RestaurantVO> arrayList = new ArrayList<>();
        switch (place) {
            case CardPagerAdatper.HONGDAE:

                placeName.setText("H O N G D A E");

                arrayList.add(new RestaurantVO("Hongdae", R.drawable.hongdae_restaurant1, "GaehwaGi Yojeong", "Traditional, izakaya, bit pricy", "4.3 (201)", "Seogyo Dong", "2 AM", "401-5 Seogyo-dong, Mapo-gu, Seoul", "20$ - 30$ / dish", "Everyday 2:00 PM - 2:00AM", "Gaehwagi Yojeong is highly recommended Korean drinking place where exactly reproduces the street of Seoul in 19th century. Since the motive of this place is 19th, when a lot of foreign culture flood into Chosun, you can try a lot of foreign food like japanese food. ", 37.548907, 126.919298));
                arrayList.add(new RestaurantVO("Hongdae", R.drawable.hongdae_restaurant2, "Chosun Sidae", "Casual, traditional, makgeolli", "4.4 (59)", "Seogyo Dong", "24 hours", "Seoul, Mapo-gu, Seogyo-dong, Hongik-ro 3-gil, 44", "11$ - 20$ / dish", "Everyday 24 HOURS", "This place reproduced the Chosun dynasty era exactly. You definitely need to try Pageon and Makgeolli there. Also, you can experience Korean traditional costume and play some Korean traditional games like Tuho and Jegichagi.", 37.552807, 126.921510));
                arrayList.add(new RestaurantVO("Hongdae", R.drawable.hongdae_restaurant3, "Samgeori Pocha", "Casual, trendy, group", "3.3 (137)", "Seogyo Dong", "5 AM", "70 Wausan-ro, Seogyo-dong, Mapo-gu, Seoul", "10$ - 15$ / dish", "Everyday 6:30 PM - 5:00AM", "If you are a Korean, Hongik University naturally reminds you of Samgeori Pogacha. It is because this place is one of the most popular in hongdae aria. You can drink a lot of different Korean drins with reasonable price, while enjoying K-pop. There are  a lot of clubs nearby like NB2, Mad holic as well.", 37.550659, 126.923297));
                break;

            case CardPagerAdatper.GANGNAM:

                placeName.setText("G A N G N A M");

                arrayList.add(new RestaurantVO("Gangnam", R.drawable.gangnam_restaurant1, "Libugjib", "Late night food, Casual, Group", "4.0 (754)", "Nonhyeon Dong", "4 AM", "45 Hakdong-ro 2-gil, Nonhyeon 1(il)-dong, Gangnam-gu, Seoul", "32 $/ dish", "Everyday 11:00 AM - 4:00 AM", "It is a famous jokbal restaurant where pig's feet are seasoned. Jokbal is a meat that is eaten after marinating in soy sauce and other spices for a long time.It's full of jokbal. It's a favorite dish for men and women.Of course, makgeolli is the best drink to match jokbal. Since ancient times, Korean ancestors enjoyed eating jokbal and makgeolli.If you want to taste makgeolli to the fullest, eat it with jokbal.", 37.508670, 127.023578));
                arrayList.add(new RestaurantVO("Gangnam", R.drawable.gangnam_restaurant2, "Bulldog Pub", "Bar games, Casual, Group", "4.5 (95)", "Yeoksam Dong", "2AM", "810-2 Yeoksam-dong, Gangnam-gu, Seoul", "7$ - 11$ / dish", "Everyday 7:00 PM - 3:00 AM", "Locals and expats alike enjoy spending their nights at Bulldog Pub in Gangnam. The menu is varied and prices are reasonable for every budget. This location shows that you do not have to spend big bucks when in one of Seoul’s poshest areas.", 37.503624, 127.025932));
                arrayList.add(new RestaurantVO("Gangnam", R.drawable.gangnam_restaurant3, "Neurin Maeul", "Cosy, Casual, Beer", "4.0 (530)", "Seocho Dong", "1 AM", "7 Seocho-daero 73-gil, Seocho 4(sa)-dong, Seocho-gu, Seoul", "6$ / bottle", "Fri,Sat 3:00PM - 4:00AM\n Weekday 3:00 PM - 2:00 AM", "The Gangnam branch of this Baesangmyeon Brewery bar is a bit snazzier than others, but remains a good place to sample quality traditional Korean alcohol. Its signature Neurin Maeul makgeolli (milky rice wine) is the standout – it's divided into the four 'seasons', which refers to the differing production stages; you can sample each before ordering. Look for the rusty shipping container.", 37.498118, 127.025271));

                break;

            case CardPagerAdatper.ITAEWON:

                placeName.setText("I T A E W O N");

                arrayList.add(new RestaurantVO("Itaewon", R.drawable.itaewon_restaurant1, "Prost", "Bar games, Great cocktails, Casual", "4.0 (544)", "Itaewon Dong", "4 AM", "26 Itaewon-ro 27ga-gil, Itaewon 1(il)-dong, Yongsan-gu, Seoul", "10$ - 20$/ dish", "Everyday 6:00 PM - 4:00 AM", "Prost makes you feel the European sensibility in Korea. Usually this place is really busy on weekend which is gonna be great to check it out if you are a solo traveler. Prost Pub is a more casual part of the District and offers many western dishes. They offer pub food and several beers on tap.", 37.535046, 126.993806));
                arrayList.add(new RestaurantVO("Itaewon", R.drawable.itaewon_restaurant2, "Fountain", "Bar games,Great cocktails, Casual", "4.1 (566)", "Itaewon Dong", "3 AM", "116-6 Itaewon-dong, Yongsan-gu, Seoul", "9$ - 11$/cocktail", "THU-SAT 6:00PM - 6:00AM\n SUN-WED 3:00 PM - 3:00 AM", "Once you get into this place, you will get surprised how big this place is. Can’t dance? Feel awkward taking your date out to a club but want to try something different after dinner? Try The Fountain, a barcade that allows you to play a variety of games. A fairly large venue, you can run around trying out each of your childhood favorites like darts, soccer game. It offers you decent cocktails as well even though it is bit pricy.", 37.535038, 126.993013));
                arrayList.add(new RestaurantVO("Itaewon", R.drawable.itaewon_restaurant3, "Tongue & Groove Joint", "Pricy, Groups, Soju", "4.0 (155)", "Itaewon Dong", "11 PM", "7 Bogwang-ro 60-gil, Itaewon 1(il)-dong, Yongsan-gu, Seoul", "16$-42$ / dish", "Everyday 11:30 AM - 11:00 PM", "This place is not exactly drinking place but it will offer you amazing Korean dish and It is certified by Michelin guide 2019. The restaurant specializes in quality Korean beef aged for at least three weeks as well as tender lamb chops and beef ribeye.Hanwoo is the best match for traditional Korean liquor (soju).", 37.534045, 126.994514));

                break;

        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdpater adapter = new RecyclerViewAdpater(this, place, arrayList); //set place type so that adpater bind the image and data.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
        }

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

}
