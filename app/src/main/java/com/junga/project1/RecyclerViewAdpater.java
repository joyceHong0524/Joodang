package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerViewAdpater.MyViewHolder> {

    private final Context context;
    private final int place; //distinguish if it is from hongdae,gangnam or itaewon;
    private final ArrayList<RestaurantVO> restaurants;

    public RecyclerViewAdpater(Context context, int place, ArrayList<RestaurantVO> restaurants) {
        this.context = context;
        this.place = place;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_restaurant, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final RestaurantVO data = restaurants.get(i);

        Glide.with(context).load(data.getDrawable()).into(myViewHolder.title_image);

        myViewHolder.resName.setText(data.getName());
        myViewHolder.resAttr.setText(data.getAttr());
        myViewHolder.star.setText(data.getStar());
        myViewHolder.dongName.setText(data.getDongName());
        myViewHolder.closeTime.setText(data.getCloseTime());

        myViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Going to pass this restuarant VO!!!
                Intent intent = new Intent(context, PlaceBestInfoActivity.class);
                intent.putExtra("restaurant", data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        final ImageView title_image;
        final TextView resName;
        final TextView resAttr;
        final TextView star;
        final TextView dongName;
        final TextView closeTime;
        final CardView view;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.layout);
            title_image = itemView.findViewById(R.id.title_image);
            resName = itemView.findViewById(R.id.res_name);
            resAttr = itemView.findViewById(R.id.res_attr);
            star = itemView.findViewById(R.id.star);
            dongName = itemView.findViewById(R.id.dong_name);
            closeTime = itemView.findViewById(R.id.close_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, PlaceBestInfoActivity.class));

                }
            });

        }
    }

}
