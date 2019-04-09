package com.felixtechlabs.restorantapplication.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.adapter.MenuItemAdapter;
import com.felixtechlabs.restorantapplication.model.CartHelper;
import com.felixtechlabs.restorantapplication.model.Menu;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemClickListener;



import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private List<Menu> mMenuList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Obtain a reference to the product catalog
        mMenuList = CartHelper.getCatalog(getResources());

        // Create the list

        RecyclerView recyclerViewCatalog = (RecyclerView) findViewById(R.id.rvCatalog);
        recyclerViewCatalog.setAdapter(new MenuItemAdapter(this, mMenuList));





        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), CartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

    }
}
