package com.felixtechlabs.restorantapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.felixtechlabs.restorantapplication.ItemClickListener;
import com.felixtechlabs.restorantapplication.R;
import com.felixtechlabs.restorantapplication.model.CartHelper;
import com.felixtechlabs.restorantapplication.model.Menu;
import com.felixtechlabs.restorantapplication.view.CartActivity;
import com.felixtechlabs.restorantapplication.view.DetailActivity;
import com.felixtechlabs.restorantapplication.view.DetailsActivity;
import com.felixtechlabs.restorantapplication.view.OrderActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MyViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    int counter = 0;
    private Context mContext;
    private List<Menu> mMenuList;
    int textTotal = 0;
    int total = 0;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener =  listener;

    }

    public MenuItemAdapter(Context context, List<Menu> menuList) {
        mContext = context;
        mMenuList = menuList;
    }

    @NonNull
    @Override
    public MenuItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Menu menu = mMenuList.get(position);


        final ImageView imageView = (holder).imgMenu;
        holder.textName.setText(menu.getTitle());
        holder.textBody.setText(menu.getDescription());
        Picasso.with(mContext).load((menu.getImgUrl())).into(imageView);
        holder.textPrice.setText(String.valueOf(mMenuList.get(position).getPrice()));
        holder.textQuantity.setText(String.valueOf(mMenuList.get(position).getQuantity()));
        holder.text_total.setText(String.valueOf(mMenuList.get(position).getTotal()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
//               ((OrderActivity).mContext).setOnItemClickListener
                mListener.onItemClick(position);


            }

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), OrderActivity.class);
                view.getContext().startActivity(intent);
                Toast.makeText(view.getContext(), "os version is: " + menu.getTitle(), Toast.LENGTH_SHORT).show();


            }
        });



//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Intent intent;
////                intent = new Intent(mContext, OrderActivity.class);
////                holder.itemView.getContext().startActivity(new Intent(mContext, ParcActivity.class));
////
////                intent.putExtra("menu", menu);
////                mContext.startActivity(intent);
////                //intent.putParcelableArrayListExtra("mMenuList",(ArrayList<? extends Parcelable>) mMenuList);
////        To pass:
////                intent.putExtra("OderActivity", String.valueOf(ParcActivity.class));
////                    v.getContext().startActivity(intent);
////// To retrieve object in second Activity
////                intent.getIntent().getSerializableExtra("ParcActivity");
//
//            }
//        });
//
//        holder.plusitem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                counter++;
//                holder.itennumber.setText(String.valueOf(counter));
//                menu.setQuantity(counter);
//            }
//        });
//        holder.minusitem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (counter > 0) {
//                    counter--;
//                    holder.itennumber.setText(String.valueOf(counter));
//                    menu.setQuantity(counter);
//                }
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return mMenuList.size();
    }


    //Recycling
    public class MyViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {

        public ImageView imgMenu, plusitem, minusitem;

        public TextView textName;
        public TextView textBody;
        public TextView textPrice;
        public TextView textQuantity;
        public TextView itennumber;
        public TextView text_plist_price;
        public TextView text_total;
        public ProgressBar progressBar;
        public ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            imgMenu =  itemView.findViewById(R.id.img_Menu);
            textName =  itemView.findViewById(
                    R.id.txtName);
            textBody =  itemView.findViewById(R.id.txtBody);
            textPrice =  itemView.findViewById(R.id.txtPrice);
            plusitem =  itemView.findViewById(R.id.cart_plus_img);
            minusitem = itemView.findViewById(R.id.cart_minus_img);
            itennumber = itemView.findViewById(R.id.cart_product_quantity_tv);
            textQuantity =  itemView.findViewById(R.id.txtQuantity);
            text_plist_price =  itemView.findViewById(R.id.plist_price_text);
            text_total =  itemView.findViewById(R.id.total);
            //progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {

        }
    }
}

