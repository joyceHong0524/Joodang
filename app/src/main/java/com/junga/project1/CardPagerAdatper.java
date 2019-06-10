package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class CardPagerAdatper extends PagerAdapter implements CardAdapter {

    public final static int DRINK_CARD = 0;
    public final static int PLACE_CARD = 1;

    public final static int SOJU = 0;
    public final static int CHEONGJU = 1;
    public final static int MAKGEOLLI = 2;

    public final static int HONGDAE = 0;
    public final static int GANGNAM = 1;
    public final static int ITAEWON = 2;


    private List<CardView> mViews;
    private float mBaseElevation;
    private int type; //In this case, it tells if it is from Drinks Activity or Place Activity.
    private Context context;

    public CardPagerAdatper(int type, Context context) {
        mViews = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            mViews.add(null);
        }
        this.type = type;
        this.context = context;

    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return 3; //hard coded for now
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_adpater, container, false);

        container.addView(view);
        bind(position, view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(int position, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);


        if (type == DRINK_CARD) {
            switch (position) {
                case 0:
                    imageView.setImageResource(R.drawable.fragment_soju);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, DrinksInfoActivity.class);
                            intent.putExtra("type", SOJU);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.fragment_cheongju);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, DrinksInfoActivity.class);
                            intent.putExtra("type", CHEONGJU);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.fragment_makgeoli);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, DrinksInfoActivity.class);
                            intent.putExtra("type", MAKGEOLLI);
                            context.startActivity(intent);
                        }
                    });
                    break;
                default:
                    break;
            }
        } else if (type == PLACE_CARD) {
            switch (position) {
                case 0:
                    imageView.setImageResource(R.drawable.card_hongdae);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, PlaceBestActivity.class);
                            intent.putExtra("type", HONGDAE);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.card_gangnam);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, PlaceBestActivity.class);
                            intent.putExtra("type", GANGNAM);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.card_itaewon);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, PlaceBestActivity.class);
                            intent.putExtra("type", ITAEWON);
                            context.startActivity(intent);
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    }

}
