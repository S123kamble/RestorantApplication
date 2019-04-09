package com.felixtechlabs.restorantapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.References.RADatabase;
import com.felixtechlabs.restorantapplication.adapter.TableAdapter;
import com.felixtechlabs.restorantapplication.model.Table;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class TableActivity extends AppCompatActivity {

      RecyclerView recyclerView;

    private FirebaseAuth auth;
    private FirebaseDatabase mFirebaseInstance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        auth = FirebaseAuth.getInstance();


       RADatabase.getInstance().getTableNumbers().addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               ArrayList<Table> tables = new ArrayList<>();

               for (DataSnapshot childSnapshot: dataSnapshot.getChildren()){
                   Table table = childSnapshot.getValue(Table.class);

                   tables.add(table);

               }
               TableAdapter adapter = new TableAdapter(tables);
               recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
               recyclerView.setAdapter(adapter);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

       recyclerView = findViewById(R.id.rv_Table);

        List<Table> list = new ArrayList<>();



    }



//    RADatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//        @Override
//        public void onComplete (@NonNull Task < Void > task) {
//            progressBar.setVisibility(View.GONE);
//            if (task.isSuccessful()) {
//
//            }
        }



