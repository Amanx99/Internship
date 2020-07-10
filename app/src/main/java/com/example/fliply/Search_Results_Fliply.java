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

import adapter.Search_Results_Adapter;
import model.Search_Results_Fliply_Model;

public class Search_Results_Fliply extends Fragment {
    private Search_Results_Adapter search_results_adapter;
    private RecyclerView recyclerview;
    private ArrayList<Search_Results_Fliply_Model> search_results_fliply_modelArrayList;

    Integer bitmap5[]={R.drawable.bitmap9,R.drawable.bitmap11};
    Integer imgrs[]={R.drawable.ic_rupee,R.drawable.ic_rupee};
    String txtdji[]={"Chanel Perfume","Miss Dior Perfume"};
    String txtprice[]={"1999","1200"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_search_results_fliply, container, false);

        recyclerview = root.findViewById(R.id.recycler2);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        search_results_fliply_modelArrayList = new ArrayList<>();

        for (int i = 0; i < bitmap5.length; i++) {
            Search_Results_Fliply_Model view = new Search_Results_Fliply_Model(bitmap5[i],imgrs[i],txtdji[i],txtprice[i]);
            search_results_fliply_modelArrayList.add(view);
        }
        search_results_adapter = new Search_Results_Adapter(getContext(),search_results_fliply_modelArrayList);
        recyclerview.setAdapter(search_results_adapter);

        return root;
    }
}
