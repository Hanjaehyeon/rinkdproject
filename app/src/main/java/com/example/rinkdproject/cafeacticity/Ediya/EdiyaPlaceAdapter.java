package com.example.rinkdproject.cafeacticity.Ediya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rinkdproject.cafeacticity.Ediya.Place;
import com.bumptech.glide.Glide;
import com.example.rinkdproject.R;

import java.util.ArrayList;

//import noman.googleplaces.Place;

public class EdiyaPlaceAdapter extends RecyclerView.Adapter<EdiyaPlaceAdapter.CustomViewHolder> {

    private ArrayList<Place> arrayList;
    private Context context;

    public EdiyaPlaceAdapter(ArrayList<Place> arrayList, Context context){
        this.arrayList = arrayList;
        this.context =context;
    }
    @NonNull
    @Override
    public EdiyaPlaceAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ediyaplace_item,parent,false);
        EdiyaPlaceAdapter.CustomViewHolder holder = new EdiyaPlaceAdapter.CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EdiyaPlaceAdapter.CustomViewHolder holder, int position) {


        holder.tv_placename.setText(arrayList.get(position).getPlacename());
        holder.tv_doro.setText(arrayList.get(position).getDoro());
        holder.tv_number.setText(arrayList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() :0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_placename;
        TextView tv_doro;
        TextView tv_number;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_placename = itemView.findViewById(R.id.textView_placename);
            this.tv_doro = itemView.findViewById(R.id.textView_doro);
            this.tv_number = itemView.findViewById(R.id.textView_number);

        }
    }
}
