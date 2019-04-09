package com.felixtechlabs.restorantapplication;

import android.view.View;

public interface ItemClickListener {

    void onClick(View view,int position,boolean isLongClick);

    void onClick(View view);


}
