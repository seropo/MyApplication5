package com.nwebtekno.sewaapps.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nwebtekno.sewaapps.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by HP on 21/01/2019.
 */

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen);
        Picasso.get().load(R.drawable.plasa_icon).into(((ImageView)this.findViewById(R.id.imgs)));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this,MainActivity.class));
            }
        },2000);
    }

}
