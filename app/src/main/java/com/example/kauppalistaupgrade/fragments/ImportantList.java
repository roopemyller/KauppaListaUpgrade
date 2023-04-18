package com.example.kauppalistaupgrade.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kauppalistaupgrade.Product;
import com.example.kauppalistaupgrade.ProductListAdapter;
import com.example.kauppalistaupgrade.R;
import com.example.kauppalistaupgrade.Storage;

import java.util.ArrayList;


public class ImportantList extends Fragment{

    private RecyclerView recyclerView;
    private ArrayList<Product> data;

    public ImportantList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.important_fragment, container, false);

        Storage s = Storage.getInstance();
        s.loadProducts(getContext());
        data = s.getImportantProducts();

        recyclerView = view.findViewById(R.id.rvProductList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ProductListAdapter(getContext(), data));
        return view;
    }
}