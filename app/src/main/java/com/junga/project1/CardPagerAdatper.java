package com.junga.project1;

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


public class CardPagerAdatper extends PagerAdapter implements  CardAdapter {

    private List<CardView> mViews;
    private float mBaseElevation;

    public CardPagerAdatper() {
        mViews = new ArrayList<>();

        for(int i=0; i<3; i++) {
            mViews.add(null);
        }

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
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_adpater,container,false);

        container.addView(view);
        bind(position,view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        if(mBaseElevation == 0){
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation*MAX_ELEVATION_FACTOR);
        mViews.set(position,cardView);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position,null);
    }

    private void bind(int position, View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        switch(position){
            case 0: imageView.setImageResource(R.drawable.fragment_soju);
                    break;
            case 1: imageView.setImageResource(R.drawable.fragment_cheongju);
                    break;
            case 2: imageView.setImageResource(R.drawable.fragment_makgeoli);
                    break;
            default : break;
        }
    }

}
