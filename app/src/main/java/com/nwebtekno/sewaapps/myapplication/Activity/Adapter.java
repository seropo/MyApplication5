package com.nwebtekno.sewaapps.myapplication.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nwebtekno.sewaapps.myapplication.R;

/**
 * Created by HP on 20/01/2019.
 */

public class Adapter extends RecyclerView.Adapter{
    private Context context;
    public interface ProductListener{
        void clicking(int positions);
    }
    public ProductListener listener;
    public Adapter(Context context){
        this.context=context;
        listener=(ProductListener)context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_homelist,null,false);
        return new Adapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    private class Holder extends RecyclerView.ViewHolder{
        private LinearLayout.LayoutParams layoutParams;
        public Holder(View itemView) {
            super(itemView);
            ((TextView)itemView.findViewById(R.id.tproduct)).setVisibility(View.GONE);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.clicking(getAdapterPosition());
                }
            });
        }
    }
}
