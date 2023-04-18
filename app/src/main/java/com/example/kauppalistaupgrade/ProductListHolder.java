package com.example.kauppalistaupgrade;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductListHolder extends RecyclerView.ViewHolder {

    TextView productName;
    public ProductListHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.txtProductName);
    }
}
