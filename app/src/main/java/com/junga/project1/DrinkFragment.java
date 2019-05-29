package com.junga.project1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DrinkFragment extends Fragment {


    int fragmentType;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();

        fragmentType = bundle.getInt("type",0);

        View view =  inflater.inflate(R.layout.fragment_drink,container,false);
        ImageView image = (ImageView) view.findViewById(R.id.image);

        switch(fragmentType){
            case 0 :
                image.setImageResource(R.drawable.button_gangnam);
                return view;
            case 1:
                image.setImageResource(R.drawable.button_best);
                return view;
            case 2:
                image.setImageResource(R.drawable.button_first);
                return view;
            default:
                return view;

        }
    }
}
