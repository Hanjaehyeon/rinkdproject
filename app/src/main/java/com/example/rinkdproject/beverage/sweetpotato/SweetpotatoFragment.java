package com.example.rinkdproject.beverage.sweetpotato;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.rinkdproject.R;
import com.example.rinkdproject.coffee.Drink;
import com.example.rinkdproject.coffee.DrinkAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SweetpotatoFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Drink> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    TextView textView;
    Query query;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caffe_latte_all, container, false);

        recyclerView = view.findViewById(R.id.drink_recyclerview);
        recyclerView.setHasFixedSize(true);//리사이클러뷰 성능 강화
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); //Drink 객체를 담을 리스트

        database = FirebaseDatabase.getInstance();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        query =FirebaseDatabase.getInstance().getReference().child("Latte").child("SweetpotatoLatte").orderByChild("price");
        // databaseReference = database.getReference("Latte");//DB 테이블 연결
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아옴
                arrayList.clear(); //기존 배열 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Drink drink = snapshot.getValue(Drink.class);//드링크 객체의 데이터를 담는다.
                    arrayList.add(drink);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // db가져오던 중 에러 발생 시
                Log.e("CaffeLatteAllFragment", String.valueOf(databaseError.toException()));

            }
        });

        adapter = new DrinkAdapter(arrayList, getContext());
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결


        final Button btn = (Button)view.findViewById(R.id.listbutton);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                PopupMenu popup = new PopupMenu(getContext(),v);

                popup.getMenuInflater().inflate(R.menu.pricelist_option,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                btn.setText("가격순");
                                query =FirebaseDatabase.getInstance().getReference().child("Latte").child("SweetpotatoLatte").orderByChild("price");
                                // adapter.notifyDataSetChanged();
                                query.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        // 파이어베이스 데이터베이스의 데이터를 받아옴
                                        arrayList.clear(); //기존 배열 초기화
                                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                            Drink drink = snapshot.getValue(Drink.class);//드링크 객체의 데이터를 담는다.
                                            arrayList.add(drink);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        // db가져오던 중 에러 발생 시
                                        Log.e("CafeLatteActivity", String.valueOf(databaseError.toException()));
                                    }
                                });
                                adapter = new DrinkAdapter(arrayList, getContext());
                                recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결
                                break;

                            case R.id.menu2:
                                btn.setText("리뷰순");
                            default:
                                break;
                        }

                        return false;
                    }
                });
                popup.show();
            }
        });

        return view;
    }
}
