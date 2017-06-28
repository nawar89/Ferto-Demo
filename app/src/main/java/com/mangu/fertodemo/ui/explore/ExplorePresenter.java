package com.mangu.fertodemo.ui.explore;

import android.view.View;

import com.mangu.fertodemo.R;
import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.data.local.Product;
import com.mangu.fertodemo.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ExplorePresenter extends BasePresenter<ExploreMvpView> {

    private final DataManager mDataManager;

    @Inject
    public ExplorePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ExploreMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void prepareProducts() {
        int[] images = new int[]{
                R.drawable.ic_fish,
                R.drawable.ic_chufles,
                R.drawable.ic_fresas
        };
        Product p1 = new Product("Kg de pescado fresco",
                3.5, "Velez-Malaga", "Pescaderia Rubeltor", images[0]);
        Product p2 = new Product("Caja pequeña de chufles",
                2.5, "Velez-Malaga", "Fruteria Francisco", images[1]);
        Product p3 = new Product("Kg de fresas", 3.12,
                "Velez-Malaga", "Fruteria Nueva Malaga", images[2]);
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        getMvpView().processProducts(productList);
    }

    public void processClick(View view, Product product) {

    }
}

