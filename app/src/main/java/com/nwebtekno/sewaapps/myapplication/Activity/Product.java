package com.nwebtekno.sewaapps.myapplication.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nwebtekno.sewaapps.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HP on 20/01/2019.
 */

public class Product extends AppCompatActivity implements View.OnClickListener,Adapter.ProductListener{
    private ImageView img;
    private TextView ttoko,ttime,treview,ttile;
    private LinearLayout lback;
    private GridView items,itemss;
    private RecyclerView itemproduct;
    private ArrayList<String>listing;
    private String nilaiss;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.productt);
            ttile = ((TextView) this.findViewById(R.id.ttitle));
            itemproduct = ((RecyclerView) this.findViewById(R.id.listitems));
            itemss = ((GridView) this.findViewById(R.id.itemss));
            listing = new ArrayList<>();
            ttile.setText(getViews("title"));
            ((TextView)this.findViewById(R.id.tketerangan)).setText(getViews("keterangan"));
            ((TextView)this.findViewById(R.id.tproductbayar)).setText(getViews("harga"));
            itemproduct.setAdapter(new Adapter(Product.this));
            itemproduct.setLayoutManager(new GridLayoutManager(Product.this,5));
            itemss.setAdapter(new adapter(Product.this, R.layout.item_homelist));
            ((LinearLayout)this.findViewById(R.id.lback)).setOnClickListener(this);
            ((TextView)this.findViewById(R.id.tphone)).setOnClickListener(this);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getBaseContext(),String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
        }
    }
    private String getViews(String nilais){
        nilaiss=getIntent().getStringExtra(nilais);
        return nilaiss;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case (int)R.id.lback:
                finish();
                break;
            case (int)R.id.tphone:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("telp:"+((TextView)view).getText().toString())));
                break;
        }
    }

    @Override
    public void clicking(int positions) {
        alerting();
    }

    private class adapter extends ArrayAdapter{

        public adapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view= LayoutInflater.from(Product.this).inflate(R.layout.item_homelist,null,false);
            ((TextView)view.findViewById(R.id.tproduct)).setText("Product References "+(new Random().nextInt(10)));
            return ((View)view);
        }

        @Override
        public int getCount() {
            return 10;
        }
    }
    private void alerting(){
        View view=LayoutInflater.from(Product.this).inflate(R.layout.full_screen,null,false);
        AlertDialog.Builder alert=new AlertDialog.Builder(Product.this);
        alert.setMessage("Images").setView(view).show();
    }
}
