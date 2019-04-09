package com.felixtechlabs.restorantapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.felixtechlabs.restorantapplication.R;

public class CartHolder extends RecyclerView.ViewHolder{
TextView name,quanitty;
    public CartHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.itemcartname);
        quanitty=itemView.findViewById(R.id.itemcartquantity);

    }
}
