package com.felixtechlabs.restorantapplication.model;

import android.content.res.Resources;

import com.felixtechlabs.restorantapplication.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CartHelper {

    public static final  String MENU_INDEX = "MENU_INDEX";

    public  static List<Menu> catalog;

    private static Map<Menu,ShoppingCartEntry > cartMap = new HashMap<>();

    public static List<Menu> getCatalog(Resources res){
       if (catalog == null){
           catalog = new Vector<Menu>();
           catalog.add(new Menu("Biryani","It use Green vegetables","http://i.imgur.com/DvpvklR.png","2","Starter",150,3,450,true,true));
           catalog.add(new Menu("Biryani","It use Green vegetables","http://i.imgur.com/DvpvklR.png","1","main",100,3,300,false,false));
           catalog.add(new Menu("Biryani","It use Green vegetables","http://i.imgur.com/DvpvklR.png","4","dessert",120,3,240,true,true));
       }
       return catalog;
    }


    public static void setQuantity(Menu menu, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(menu);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(menu);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(menu, quantity);
            cartMap.put(menu, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setmQuantity(quantity);
    }

    public static int getProductQuantity(Menu menu) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(menu);

        if(curEntry != null)
            return curEntry.getmQuantity();

        return 0;
    }

    public static void removeProduct(Menu menu) {
        cartMap.remove(menu);
    }

    public static List<Menu> getCartList() {
        List<Menu> cartList = new Vector<Menu>(cartMap.keySet().size());
        for(Menu p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }
}
