package com.example.kauppalistaupgrade.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kauppalistaupgrade.Product;
import com.example.kauppalistaupgrade.ProductListAdapter;
import com.example.kauppalistaupgrade.R;
import com.example.kauppalistaupgrade.Storage;

import java.util.ArrayList;


public class List extends Fragment{

    private RecyclerView recyclerView;
    private ArrayList<Product> data;

    public List() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view, container, false);

        Storage s = Storage.getInstance();
        s.loadProducts(view.getContext());
        data = s.getProducts();

        recyclerView = view.findViewById(R.id.rvProductList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ProductListAdapter(getContext(), data));
        recyclerView.getAdapter().notifyDataSetChanged();

        return view;
    }
    public void onResume(){
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();

    }

}