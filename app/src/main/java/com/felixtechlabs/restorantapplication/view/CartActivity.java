package com.felixtechlabs.restorantapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.adapter.MenuItemAdapter;
import com.felixtechlabs.restorantapplication.model.CartHelper;
import com.felixtechlabs.restorantapplication.model.Menu;
import com.felixtechlabs.restorantapplication.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<Menu> menuList;
    private MenuItemAdapter mMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        /*
        menuList = CartHelper.getCartList();

        // Make sure to clear the selections
        for(int i=0; i<menuList.size(); i++) {
            menuList.get(i).selected = false;
        }

        // Create the list
        final RecyclerView recyclerViewCatalog = (RecyclerView) findViewById(R.id.rvCatalog);
        mMenuAdapter = new MenuItemAdapter(this,menuList);
        recyclerViewCatalog.setAdapter(mMenuAdapter);

//        recyclerViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent productDetailsIntent = new Intent(getBaseContext(),DetailsActivity.class);
//                productDetailsIntent.putExtra(CartHelper.MENU_INDEX, position);
//                startActivity(productDetailsIntent);            }
       });
*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if(mMenuAdapter != null) {
            mMenuAdapter.notifyDataSetChanged();
        }




    }
}
