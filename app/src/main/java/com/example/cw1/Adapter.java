package com.example.cw1;

import android.content.Context;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.HikeViewHolder>{

    private Context context;
    private ArrayList<ModelHike> hikeList;

    // add constructor


    public Adapter(Context context, ArrayList<ModelHike> hikeList) {
        this.context = context;
        this.hikeList = hikeList;
    }

    @NonNull
    @Override
    public HikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hike_item,parent,false);
        HikeViewHolder vh = new HikeViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HikeViewHolder holder, int position) {

        ModelHike modelHike = hikeList.get(position);

        //get data
        String id = modelHike.getId();
        String name = modelHike.getName();
        Log.d(name, "name");

        //set data
        holder.name.setText(name);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return hikeList.size();
    }

    class HikeViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView hikeDetail;

        public HikeViewHolder(@NonNull View itemView) {
            super(itemView);

            //Init view
                    name = itemView.findViewById(R.id.hike_name);
        }
    }
}
