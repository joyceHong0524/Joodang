package com.junga.project1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerViewAdpater.MyViewHolder>{

    Context context;
    int place; //distinguish if it is from hongdae,gangnam or itaewon;
    ArrayList<RestaurantVO> restaurants;

    public RecyclerViewAdpater(Context context,int place,ArrayList<RestaurantVO> restaurants) {
        this.context = context;
        this.place = place;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_restaurant,viewGroup,false);

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
                Intent intent = new Intent(context,PlaceBestInfoActivity.class);
                intent.putExtra("restaurant",data);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView title_image;
        TextView resName,resAttr,star,dongName,closeTime;
        CardView view;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            view = (CardView) itemView.findViewById(R.id.layout);
            title_image = (ImageView) itemView.findViewById(R.id.title_image);
            resName = (TextView) itemView.findViewById(R.id.res_name);
            resAttr = (TextView) itemView.findViewById(R.id.res_attr);
            star = (TextView) itemView.findViewById(R.id.star);
            dongName = (TextView) itemView.findViewById(R.id.dong_name);
            closeTime = (TextView) itemView.findViewById(R.id.close_time);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context,PlaceBestInfoActivity.class));

                }
            });

        }
    }

}
