package com.felixtechlabs.restorantapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.model.Menu;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    TextView textName,textBody,textQuantity,textPrice,textTotal,costTextView;
    ImageView imageView;
    List<Menu> menuList;
    public DetailsActivity(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        Menu menu = intent.getParcelableExtra("menu");

        String imgUrl = menu.getImgUrl();
        String name = menu.getTitle();
        String body = menu.getDescription();
        int quantity = menu.getQuantity();
        int price = menu.getPrice();
        int total = menu.getTotal();

        imageView = findViewById(R.id.imgFoodP);
        //imageView.setImageResource(Integer.parseInt(imageRes));
//
////        TextView textView = findViewById(R.id.txtName);
////        textView.setText();
////        TextView textView = findViewById(R.id.txtBody);
////        TextView textView = findViewById(R.id. quantity);
////        TextView textView = findViewById(R.id.price_id);
////        TextView textView = findViewById(R.id.total);

//        costTextView=(TextView) findViewById(R.id.cost_text_view);
//        costTextView.setText("$0.00");

        TextView textName = findViewById(R.id.txtName);
        TextView textBody = findViewById(R.id.txtBody);
        TextView textPrice = findViewById(R.id.txtPrice);
        TextView textQuantity = findViewById(R.id.parcQuantity);

        TextView textTotal = findViewById(R.id.parcTotal);


        textName.setText(name);
        textBody.setText(body);
        textPrice.setText(String.valueOf(price));
        textQuantity.setText(String.valueOf(quantity));
        textTotal.setText(String.valueOf(total));

        Picasso.with(getApplicationContext()).load(menu. getImgUrl()).into(imageView);



    }
//    public void increment(View view){
//
//        mFinalQuantity = mFinalQuantity + 1;
//        displayQuantity(mFinalQuantity);
//        mFinalTotalPrice = calculatePrice();
//        displayCost(mFinalQuantity);
//    }
//
//    public void decrement(View view){
//        if (mFinalQuantity > 0){
//
//            mFinalQuantity = mFinalQuantity - 1;
//            displayQuantity(mFinalQuantity);
//            mFinalTotalPrice = calculatePrice();
//            displayCost(mFinalTotalPrice);
//
//        }
//    }
//
//    private int calculatePrice(){
//
//                mFinalTotalPrice = mFinalQuantity * mFinalTotalPrice;
//
//        return mFinalTotalPrice;
//
//    }
//
//    private void displayQuantity(int numberOfTeas) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        quantityTextView.setText(String.valueOf(numberOfTeas));
//    }
//
//    private void displayCost(int totalPrice) {
//        TextView costTextView = (TextView) findViewById(
//                R.id.cost_text_view);
//
//        String convertPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
//        costTextView.setText(convertPrice);
//    }
//
//    public void brewTea(View view) {
//
//        Intent intent = new Intent(ParActivity.this, MainActivity.class);
//        intent.putExtra("Item", mFinalTotalPrice);
//
//
//
//        startActivity(intent);
//    }
}