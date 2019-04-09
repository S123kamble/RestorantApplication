package com.felixtechlabs.restorantapplication.view;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.adapter.MenuItemAdapter;
import com.felixtechlabs.restorantapplication.model.Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class OrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Menu> menuList;
    List<String> menuTitles;
    TabLayout tabLayout;

    ArrayList<Menu> selectedArray = new ArrayList<Menu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        menuTitles = new ArrayList<>();


        ButterKnife.bind(this);

        tabLayout = findViewById(R.id.tab_table);


        //fetchMenu();

        recyclerView = findViewById(R.id.rvOrder);

        menuList = new ArrayList<>();


        final Menu menu = new Menu("sandwich","club sandwich 160","http://i.imgur.com/DvpvklR.png","1","Starter",160,0,0,true,true);
        menuList.add(new Menu("sandwich","club sandwich 160","http://i.imgur.com/DvpvklR.png","2","Dessert",160,0,0,true,false));
        menuList.add(new Menu("sandwich","choklate sandwich 260","http://i.imgur.com/DvpvklR.png","3","Main",180,0,0,true,true));
        menuList.add(new Menu("Brade","bradPuding 160","https://api.androidhive.info/images/glide/medium/deadpool.jpg","4","Starter",100,0,0,true,false));
        menuList.add(new Menu("sandwich","panir sandwich 260","http://i.imgur.com/DvpvklR.png","5","Dessert",200,0,0,true,true));
        menuList.add(new Menu("sandwich","vege sandwich 200","http://i.imgur.com/DvpvklR.png","6","Main",150,0,0,true,false));
        menuList.add(new Menu("Brade","bradjam 160","http://i.imgur.com/DvpvklR.png","7","Dessert",160,0,0,true,true));
        menuList.add(new Menu("Brade","bradbutter 120","http://i.imgur.com/DvpvklR.png","8","Main",260,0,0,true,false));
        menuList.add(new Menu("poha","poha 110","http://i.imgur.com/DvpvklR.png","9","Starter",110,0,0,true,true));
        menuList.add(new Menu("dosa","dosa 160","https://api.androidhive.info/images/glide/medium/deadpool.jpg","10","Dessert",100,0, 0,true,false));
        menuList.add(new Menu("idli","idli 120","https://api.androidhive.info/images/glide/medium/deadpool.jpg","11","Main",100,0,0,true,true));


        MenuItemAdapter menuAdapter = new MenuItemAdapter(getApplicationContext(),menuList);
        layoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setNestedScrollingEnabled(false);

//        recyclerView.computeHorizontalScrollOffset();
//        recyclerView.computeVerticalScrollOffset();
//
//
//        //int overallXScroll = 0;
//
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(!menuTitles.isEmpty()) {
                    int position = linearLayoutManager.findFirstVisibleItemPosition();

                    String type = menuList.get(position).getType();

                    int index = menuTitles.indexOf(type);

                    TabLayout.Tab tab = tabLayout.getTabAt(index);

                    tab.select();

                }
            }
        });
    }
}



