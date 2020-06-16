package com.example.rinkdproject.ui.star;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rinkdproject.cafeacticity.Ediya.EdiyaActivity;
import com.example.rinkdproject.cafeacticity.Gongcha.GongchaActivity;
import com.example.rinkdproject.cafeacticity.Mega.MegaActivity;
import com.example.rinkdproject.cafemenu.Cafe;
import com.example.rinkdproject.cafemenu.CafeAdapter;
import com.example.rinkdproject.Layout1;
import com.example.rinkdproject.MapActivity;
import com.example.rinkdproject.cafemenu.OnCafeItemClickListener;
import com.example.rinkdproject.R;


public class StarFragment extends Fragment {


    Layout1 layout1;
    Intent intent;
    Intent intent2;
    Intent intent3;

    public static StarFragment newInstance(){
        return new StarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_star,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.layout1);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        // Layout1 layout1 = view.findViewById(R.id.layout1);
        //layout1.setImage(R.drawable.gongcha);
        //layout1.setName("공차");
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        // recyclerView.setLayoutManager(layoutManager);
        final CafeAdapter adapter = new CafeAdapter();


        adapter.addItem(new Cafe(R.drawable.gongcha,"공차"));
        adapter.addItem(new Cafe(R.drawable.ediya,"이디야"));
        adapter.addItem(new Cafe(R.drawable.megacoffee,"메가커피"));
        adapter.addItem(new Cafe(R.drawable.hoicha,"호이차"));
        adapter.addItem(new Cafe(R.drawable.hollys,"할리스"));
        adapter.addItem(new Cafe(R.drawable.compose,"컴포즈커피"));
        adapter.addItem(new Cafe(R.drawable.jamba,"잠바쥬스"));
        adapter.addItem(new Cafe(R.drawable.tomntoms,"탐앤탐스"));
        adapter.addItem(new Cafe(R.drawable.jenjudan,"쩐주단"));
        adapter.addItem(new Cafe(R.drawable.amasbin,"아마스빈"));
        adapter.addItem(new Cafe(R.drawable.twosomeplace,"투썸플레이스"));
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnCafeItemClickListener() {
            @Override
            public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position) {
                Cafe item = adapter.getItem(position);
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), GongchaActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), EdiyaActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getActivity(), MegaActivity.class);
                        startActivity(intent3);
                        break;
                    default:
                        break;
                }

                //((RandomActivity)getActivity()).replaceFragment(GongchaFragment.newInstance());

            }
        });

        return view;
    }
}