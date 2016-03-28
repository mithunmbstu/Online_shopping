package com.example.user.onlineshopping.Activity.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.onlineshopping.Activity.Adapter.Listviewadapter;
import com.example.user.onlineshopping.R;
import com.squareup.picasso.Picasso;

public class Showalliteam extends AppCompatActivity {

ImageView imageshow;
    TextView nameshow,descriptionshow,priceshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showalliteam);
        nameshow= (TextView) findViewById(R.id.nameshow);
        descriptionshow= (TextView) findViewById(R.id.descriptionshow);
        priceshow= (TextView) findViewById(R.id.priceshow);
        imageshow= (ImageView) findViewById(R.id.imageshow);
        Bundle bundle=getIntent().getExtras();

        String name=bundle.getString("name");
        String description=bundle.getString("description");
        String price=bundle.getString("price");
        String image=bundle.getString("image");
        nameshow.setText(name);
        descriptionshow.setText(description);
        priceshow.setText(price);
        Picasso.with(this).load(image).into(imageshow);



    }
}
