package com.felixtechlabs.restorantapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.model.Table;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.MyTableHolder> {

   private List<Table> tables;
   private Context context;

    public TableAdapter(List<Table> tables, Context context) {
        this.tables = tables;
        this.context = context;
    }

    @NonNull
    @Override
    public MyTableHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_list,parent,false);

        return new MyTableHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTableHolder holder, int position) {

         Table table = tables.get(position);

        ImageView imageView = (holder).imgTable;
        String num=String.valueOf(table.getTableNumbers());
        holder.textViewTableNumber.setText(num);
        holder.textViewTableStatus.setText(table.getTableStatus());
        holder.textViewTableId.setText(table.getTableId());
        //Picasso.with(context).load((table.getImgUrl())).into(imageView);

    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public static class MyTableHolder extends RecyclerView.ViewHolder {

        public ImageView imgTable;
        public TextView textViewTableNumber;
        public TextView textViewTableStatus;

        public TextView textViewTableId;


        public MyTableHolder(@NonNull View itemView) {
            super(itemView);
            textViewTableNumber = itemView.findViewById(R.id.table);
            textViewTableStatus = itemView.findViewById(R.id.txtStatus);
            textViewTableId = itemView.findViewById(R.id.txtTableId);
        }
    }

   public TableAdapter(ArrayList<Table>tables){
        this.tables =tables;
   }
}
