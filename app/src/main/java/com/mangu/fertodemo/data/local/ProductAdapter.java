package com.mangu.fertodemo.data.local;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mangu.fertodemo.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.mPrice.setText(Double.toString(product.getPrice()));
        holder.mName.setText(product.getName());
        Glide.with(mContext)
                .load(product.getPicture())
                .into(holder.mPicture);
    }

    @Override
    public int getItemCount() {
        return mProductList != null ? mProductList.size() : 0;
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        public TextView mName, mPrice;
        public ImageView mPicture;
        public ProductHolder(View itemView) {
            super(itemView);
            this.mName = (TextView) itemView.findViewById(R.id.tv_name);
            this.mPrice = (TextView) itemView.findViewById(R.id.tv_price);
            this.mPicture = (ImageView) itemView.findViewById(R.id.iv_producto);
        }
    }
}
