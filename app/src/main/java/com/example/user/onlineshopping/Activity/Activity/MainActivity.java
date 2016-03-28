package com.example.user.onlineshopping.Activity.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.onlineshopping.Activity.Adapter.Listviewadapter;
import com.example.user.onlineshopping.Activity.Iteamrow.Listrowiteam;
import com.example.user.onlineshopping.Activity.Volley.AppConfig;
import com.example.user.onlineshopping.Activity.Volley.AppController;
import com.example.user.onlineshopping.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Context context;
    public Listviewadapter listviewadapter;
    GridView gridView;
    public List<String> image = new ArrayList<String>();
    public List<String> name = new ArrayList<String>();
    public List <String> description = new ArrayList<String>();

    public List<String>price=new ArrayList<String>();

    private static final String TAG=MainActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= (GridView) findViewById(R.id.gridView);
        context = getApplicationContext();
        showall();
    }

    private void showall()
    {
        String tag_array_req = "req_show";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.show, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {

            String nam, img, des, pricetag;

            try
            {
                JSONArray array = new JSONArray(response);

                for(int i=0; i<array.length(); i++)
                {
                    JSONObject jobj1 = array.getJSONObject(i);

                    img = jobj1.getString("image");
                    nam = jobj1.getString("name");
                    des = jobj1.getString("description");
                    pricetag=jobj1.getString("price");


                    name.add(nam);
                    image.add(img);
                    description.add(des);
                    price.add(pricetag);
                }

                List<Listrowiteam> eachItem = new ArrayList<Listrowiteam>();

                for (int i = 0; i < name.size(); i++)
                {
                    eachItem.add(new Listrowiteam(image.get(i), name.get(i), description.get(i),price.get(i)));
                }

                listviewadapter = new Listviewadapter(context, eachItem);
                gridView.setAdapter(listviewadapter);


                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                    {
                        Intent intent = new Intent(context, Showalliteam.class);
                        intent.putExtra("name", name.get(position));
                        intent.putExtra("image", image.get(position));
                        intent.putExtra("description", description.get(position));
                        intent.putExtra("price",price.get(position));
                        startActivity(intent);
                    }
                });
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener()
        {
        @Override
        public void onErrorResponse(VolleyError error)
        {
            Log.e(TAG, "Showing Error: " + error.getMessage());
            Toast.makeText(getApplicationContext(),
                    error.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
        AppController.getInstance().addToRequestQueue(stringRequest, tag_array_req);
    }
}