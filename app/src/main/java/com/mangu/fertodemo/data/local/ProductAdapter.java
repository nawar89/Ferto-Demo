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
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> implements
        View.OnClickListener {

    private Context mContext;
    private List<Product> mProductList;
    private View.OnClickListener mClickListener;

    public ProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);
        itemView.setOnClickListener(this);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.mPrice.setText(String.format(Locale.getDefault().getCountry(),
                product.getPrice()));
        holder.mName.setText(product.getName());
        Glide.with(mContext)
                .load(product.getPicture())
                .into(holder.mPicture);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.mClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) {
            mClickListener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return mProductList != null ? mProductList.size() : 0;
    }


    class ProductHolder extends RecyclerView.ViewHolder {

        TextView mName, mPrice;
        ImageView mPicture;

        ProductHolder(View itemView) {
            super(itemView);
            this.mName = (TextView) itemView.findViewById(R.id.tv_name);
            this.mPrice = (TextView) itemView.findViewById(R.id.tv_price);
            this.mPicture = (ImageView) itemView.findViewById(R.id.iv_producto);
        }
    }
}
