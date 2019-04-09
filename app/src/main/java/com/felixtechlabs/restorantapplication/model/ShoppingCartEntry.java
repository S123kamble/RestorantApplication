package com.felixtechlabs.restorantapplication.model;

public class ShoppingCartEntry {

    private Menu menu;
    private int mQuantity;

    public ShoppingCartEntry(Menu menu, int mQuantity) {
        this.menu = menu;
        this.mQuantity = mQuantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }
}
