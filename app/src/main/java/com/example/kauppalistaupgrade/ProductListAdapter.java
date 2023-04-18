package com.example.kauppalistaupgrade;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListHolder> {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();


    public ProductListAdapter(Context applicationContext, ArrayList<Product> products) {
        this.context = applicationContext;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductListHolder(LayoutInflater.from(context).inflate(R.layout.product_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListHolder holder, int position) {
        holder.productName.setText(products.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
