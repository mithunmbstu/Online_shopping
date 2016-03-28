package com.example.user.onlineshopping.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.user.onlineshopping.Activity.Iteamrow.Listrowiteam;
import com.example.user.onlineshopping.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 3/9/2016.
 */
public class Listviewadapter extends BaseAdapter {


    Context context;
    List<Listrowiteam> eachArrayList;
    public Listviewadapter(Context context, List<Listrowiteam> eachArrayList)
    {
        this.context = context;
        this.eachArrayList = eachArrayList;
    }

    @Override
    public int getCount() {
        return eachArrayList.size();
    }


    @Override
    public Object getItem(int i) {
        return eachArrayList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View r=convertView;
        Listviewholder listviewholder=null;
        if (r==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            r=inflater.inflate(R.layout.list_single,parent,false);
            listviewholder=new Listviewholder(r);
            r.setTag(listviewholder);
        }
        else
        {
            listviewholder= (Listviewholder) r.getTag();
        }
        Listrowiteam t=eachArrayList.get(i);
        Picasso.with(context)
                .load(t.getImage())
                .into(listviewholder.image);


        return r;
    }
}
