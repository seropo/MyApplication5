package com.nwebtekno.sewaapps.myapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class HomeActvity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<String>listitems,listcateg;
    private GridView listing,catelistitems;
    private int[]imgs={R.drawable.burgericon,R.drawable.breadicon,R.drawable.snackicon};
    private String[]keterangan,harga,categs={"Snack","Furniture","Sport","Food","Car","Entertainment"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        listing=((GridView)this.findViewById(R.id.listmakanan));
        catelistitems=((GridView)this.findViewById(R.id.listcateg));
        listing.setNumColumns(2);
        catelistitems.setNumColumns(4);
        ((LinearLayout)this.findViewById(R.id.lwrapp)).setOnClickListener(this);
        listitems=new ArrayList<>();
        listcateg=new ArrayList<>();
        keterangan= new String[]{"Chiki enak","Sarung sajuk enak dipakai dipinggang nyaman ukuran ada yang xl,xxl,dan super xl"};
        harga=new String[]{"10.000","12.000"};
        listitems.add("Chiki");


        listitems.add("Spre");
        ((FloatingActionButton)this.findViewById(R.id.floatingActionButton2)).setOnClickListener(this);
        listing.setAdapter(new adapter(HomeActvity.this,R.layout.item_homelist));
        catelistitems.setAdapter(new adapter(HomeActvity.this,R.layout.item_homelist));
        catelistitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((LinearLayout)HomeActvity.this.findViewById(R.id.lwrapp)).setVisibility(View.GONE);
                ((LinearLayout)HomeActvity.this.findViewById(R.id.wraping)).setVisibility(View.GONE);
                Toast.makeText(getBaseContext(),"Open With Category Product", Toast.LENGTH_LONG).show();

            }
        });
        listing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    Intent product=new Intent(HomeActvity.this,Product.class);
                    product.putExtra("title", String.valueOf("Title Product Akan Tampil "));
                    product.putExtra("keterangan",String.valueOf("Keterangan ini menjelaskan deskripsi product,jenis product,ukuran product,tipe product."));
                    product.putExtra("harga",String.valueOf("Harga Product berdasarkan satuan IDR "));
                    startActivity(product);
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(),String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
                }
            }
        });
        ((ImageView)this.findViewById(R.id.imgprofile)).setOnClickListener(this);
        ((ImageView)this.findViewById(R.id.imgcart)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case (int)R.id.floatingActionButton2:
                ((LinearLayout)HomeActvity.this.findViewById(R.id.lwrapp)).setVisibility(View.VISIBLE);
                ((LinearLayout)HomeActvity.this.findViewById(R.id.wraping)).setVisibility(View.VISIBLE);
                break;
            case (int)R.id.lwrapp:
                ((LinearLayout)HomeActvity.this.findViewById(view.getId())).setVisibility(View.GONE);
                ((LinearLayout)HomeActvity.this.findViewById(R.id.wraping)).setVisibility(View.GONE);
                break;
            case (int)R.id.imgcart:
                Toast.makeText(getBaseContext(),"Comming Soon",Toast.LENGTH_SHORT).show();
                break;
            case (int)R.id.imgprofile:
                Toast.makeText(getBaseContext(),"Comming Soon",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class adapter extends ArrayAdapter{
        private int layouts;
        public adapter(@NonNull Context context, int resource) {
            super(context, resource);
            this.layouts=resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view= LayoutInflater.from(HomeActvity.this).inflate(layouts,null,false);
            switch(layouts){
                case (int)R.layout.item_menus:
                    break;
                case (int)R.layout.item_homelist:
                    ((TextView)view.findViewById(R.id.tproduct)).setText(categs[position].toString());
                    Picasso.get().load(imgs[(new Random().nextInt(3))]).into(((ImageView)view.findViewById(R.id.imageView)));
                    break;
            }
            return ((View)view);
        }

        @Override
        public int getCount() {
            return categs.length;
        }
    }
}
