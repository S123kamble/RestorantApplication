package com.felixtechlabs.restorantapplication.fragmnt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.adapter.MenuItemAdapter;
import com.felixtechlabs.restorantapplication.model.Menu;
import com.felixtechlabs.restorantapplication.view.DetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class StarterFragment extends Fragment {


    View v;
    private RecyclerView recyclerView;
    private List<Menu> menus;

    public StarterFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_starter, container, false);


        recyclerView = (RecyclerView) v.findViewById(R.id.rvMenu);

        menus = new ArrayList<>();


        menus.add(new Menu("sandwich","club sandwich 160","http://i.imgur.com/DvpvklR.png","1","Starter",160,0,0,true,true));
        menus.add(new Menu("sandwich","club sandwich 160","http://i.imgur.com/DvpvklR.png","2","Starter",160,0,0,true,false));
        menus.add(new Menu("sandwich","choklate sandwich 260","http://i.imgur.com/DvpvklR.png","3","Starter",180,0,0,true,true));
        menus.add(new Menu("Brade","bradPuding 160","http://i.imgur.com/DvpvklR.png","4","Starter",100,0,0,true,false));
        menus.add(new Menu("sandwich","panir sandwich 260","http://i.imgur.com/DvpvklR.png","5","starter",200,0,0,true,true));
        menus.add(new Menu("sandwich","vege sandwich 200","http://i.imgur.com/DvpvklR.png","6","starter",150,0,0,true,false));
        menus.add(new Menu("Brade","bradjam 160","http://i.imgur.com/DvpvklR.png","7","starter",160,0,0,true,true));
        menus.add(new Menu("Brade","bradbutter 120","http://i.imgur.com/DvpvklR.png","8","starter",260,0,0,true,false));
        menus.add(new Menu("poha","poha 110","http://i.imgur.com/DvpvklR.png","9","Starter",110,0,0,true,true));
        menus.add(new Menu("dosa","dosa 160","http://i.imgur.com/DvpvklR.png","10","starter",100,0, 0,true,false));



        MenuItemAdapter menuAdapter = new MenuItemAdapter(getContext(),menus);
        DetailsActivity detailsActivity=new DetailsActivity(menus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(menuAdapter);

        return v;



    }


    }

