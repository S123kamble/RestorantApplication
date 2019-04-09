package com.felixtechlabs.restorantapplication.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.References.RADatabase;
import com.felixtechlabs.restorantapplication.adapter.TableAdapter;
import com.felixtechlabs.restorantapplication.model.Table;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

   private RecyclerView recyclerView;
    List<Table> mTableList;
    Context mContext;

//    private MainActivity(Context context,List<Table>mTableList){
//
//        this.mContext=context;
//        this.mTableList = mTableList;
//    }

    //FUI

    public FirebaseRecyclerAdapter<Table, TableAdapter.MyTableHolder> tablesAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        //recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

       //fetchTableByFUI();

        fetchTables();
    }

    void fetchTableByFUI() {
        final Query tablesQuery = RADatabase.getInstance().getTableNumbers();


        FirebaseRecyclerOptions<Table> options = new FirebaseRecyclerOptions.Builder<Table>()
                .setQuery(tablesQuery, Table.class)
                .build();


        tablesAdap = new FirebaseRecyclerAdapter<Table, TableAdapter.MyTableHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull TableAdapter.MyTableHolder holder, int position, @NonNull Table model) {
                holder.textViewTableNumber.setText(model.getTableNumbers());
                holder.textViewTableStatus.setText(model.getTableStatus());
                //holder.textViewTableId.setText(model.getTableId());

            }

            @NonNull
            @Override
            public TableAdapter.MyTableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.table_list, parent, false);
                return new TableAdapter.MyTableHolder(view);
            }
        };
        tablesAdap.startListening();
        tablesAdap.notifyDataSetChanged();
        recyclerView.setAdapter(tablesAdap);




    }

    void fetchTables() {
        Query tablesQuery = RADatabase.getInstance().getTableNumbers();

        tablesQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mTableList = new ArrayList<>();
                for (DataSnapshot childSnap : dataSnapshot.getChildren()) {
                    Table table = childSnap.getValue(Table.class);
                    mTableList.add(table);
                }
                TableAdapter tablesAdap = new TableAdapter(mTableList,getApplicationContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(tablesAdap);
                recyclerView.setHasFixedSize(true);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

