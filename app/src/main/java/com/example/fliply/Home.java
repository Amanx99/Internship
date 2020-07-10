package com.example.fliply;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import adapter.Home_Adapter;
import model.Home_Model;

public class Home extends Fragment {
    private Home_Adapter home_adapter;
    private RecyclerView recyclerview;
    private ArrayList<Home_Model> home_modelArrayList;

    Integer bitmap5[]={R.drawable.bitmap9,R.drawable.bitmap11,R.drawable.bitmap12,R.drawable.bitmap10};
    Integer imgrs[]={R.drawable.ic_rupee,R.drawable.ic_rupee,R.drawable.ic_rupee,R.drawable.ic_rupee};
    String txtdji[]={"Chanel Perfume","Miss Dior Perfume","Shalimar Perfume","Versace Perfume"};
    String txtprice[]={"1999","1200","4999","4500"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.activity_home, container, false);

        //  bitmap5 = root.findViewById(R.id.bitmap1);

        recyclerview = root.findViewById(R.id.recycler3);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        home_modelArrayList = new ArrayList<>();

        for (int i = 0; i < bitmap5.length; i++) {
            Home_Model view = new Home_Model(bitmap5[i], imgrs[i], txtdji[i], txtprice[i]);
            home_modelArrayList.add(view);
        }
        home_adapter = new Home_Adapter(getContext(),home_modelArrayList);
        recyclerview.setAdapter(home_adapter);


        return root;
    }
}
