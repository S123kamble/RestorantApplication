package com.felixtechlabs.restorantapplication.References;

import com.felixtechlabs.restorantapplication.BuildConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RADatabase {

    private static final RADatabase ourInstance = new RADatabase();



    public static RADatabase getInstance() {
        return ourInstance;
    }

    public RADatabase() {
    }

    private DatabaseReference getDatabaseReference() {
        if (BuildConfig.DEBUG) {
            return FirebaseDatabase.getInstance().getReference().child(Reference.DEVELOPMENT);
        } else {
            return FirebaseDatabase.getInstance().getReference().child(Reference.PRODUCTION);
        }
    }

    public DatabaseReference getUsers() {
        return getDatabaseReference().child(Reference.USERS);
    }

    public DatabaseReference getTableNumbers() {
        return getDatabaseReference().child(Reference.TABLES);
    }
    public DatabaseReference getMenuItems() {
        return getDatabaseReference().child(Reference.MENU_ITEMS);
    }

    public DatabaseReference getOrders() {
        return getDatabaseReference().child(Reference.ORDERS);
    }

//    public DatabaseReference getItemPrise() {
//        return getDatabaseReference().child(reference.TABLES);
//    }

    public DatabaseReference getFCM_TOKENS() {
        return getDatabaseReference().child(Reference.FCM_TOKENS);
    }

}
