package com.example.user.onlineshopping.Activity.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.example.user.onlineshopping.R;

/**
 * Created by User on 3/9/2016.
 */
public class Listviewholder {
    ImageView image;


    public Listviewholder(View v)
    {
        super();
        image=(ImageView)v.findViewById(R.id.img);
    }
}
