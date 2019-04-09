package com.felixtechlabs.restorantapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felixtechlabs.restorantapplication.R;

import java.util.List;

public class CaetAdapter extends RecyclerView.Adapter<CartHolder> {
    List<String> cartList;

    public CaetAdapter(List<String> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item,viewGroup,false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder cartHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
