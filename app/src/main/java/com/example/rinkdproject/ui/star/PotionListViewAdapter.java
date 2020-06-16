package com.example.rinkdproject.ui.star;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rinkdproject.R;
import com.example.rinkdproject.cafemenu.Cafe;

import java.util.ArrayList;
import java.util.List;

public class PotionListViewAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;
    private List<Cafe> potionList = null;
    private ArrayList<Cafe> arrayList;
    public PotionListViewAdapter(Context context, List<Cafe> potionList){
        this.context = context;
        this.potionList = potionList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Cafe>();
        this.arrayList.addAll(potionList);

    }

    public class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    public int getCount(){
        return potionList.size();
    }

    public Cafe getItem(int position){
        return potionList.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        final Cafe cafe = potionList.get(position);

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.layout1, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(cafe.getName());
        holder.imageView.setImageResource(cafe.getImage());

        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            }
        });
        return view;
    }


}
