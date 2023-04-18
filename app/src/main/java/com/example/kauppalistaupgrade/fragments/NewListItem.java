package com.example.kauppalistaupgrade.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.kauppalistaupgrade.Product;
import com.example.kauppalistaupgrade.R;
import com.example.kauppalistaupgrade.Storage;
import com.example.kauppalistaupgrade.TabActivity;

public class NewListItem extends Fragment {

    private TabActivity tabActivity;
    private Button addButton;
    private EditText editText;
    private CheckBox checkBox;
    private Button deleteAllButton;

    public NewListItem(TabActivity tabActivity) {
        this.tabActivity = tabActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_list_item_view, container, false);

        addButton = view.findViewById(R.id.addButton);
        editText = view.findViewById(R.id.editText);
        checkBox = view.findViewById(R.id.extraImportantCheck);
        deleteAllButton = view.findViewById(R.id.deleteAllBtn);

        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Storage.getInstance().deleteAllProducts();
                Storage.getInstance().saveProducts(view.getContext());
                tabActivity.setupTabLayout();

                tabActivity.runImportantFragment();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {
                    editText.setTextColor(Color.RED);
                    editText.setText("Lisää nimi!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editText.setText("");
                            editText.setTextColor(Color.BLACK);
                        }
                    }, 1500);
                } else {
                    int isImportant = 0;
                    if (checkBox.isChecked()) isImportant = 1;
                    Storage.getInstance().addProduct(new Product(editText.getText().toString(), isImportant));
                    editText.setText("");
                    Storage.getInstance().saveProducts(view.getContext());

                    tabActivity.setupTabLayout();
                    tabActivity.runImportantFragment();
                }
            }
        });
        return view;
    }
}