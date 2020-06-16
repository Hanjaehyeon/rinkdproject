package com.example.rinkdproject.cafeacticity.Ediya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rinkdproject.R;
import com.example.rinkdproject.coffee.Drink;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class EdiyaPlaceFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
  //  private ArrayList<Drink> arrayList;
    private ArrayList<Place> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    public EdiyaPlaceFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_ediyaplacefragment, container, false);

        recyclerView = view.findViewById(R.id.ediyaplace_recyclerview);
        recyclerView.setHasFixedSize(true);//리사이클러뷰 성능 강화
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();//Drink 객체를 담을 리스트

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Ediyaplace");//DB 테이블 연결

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot Snapshot : dataSnapshot.getChildren()){

                    Place place = Snapshot.getValue(Place.class);
                    arrayList.add(place);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        adapter = new EdiyaPlaceAdapter(arrayList, getContext());
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결


        return view;

    }
}
