package com.mangu.fertodemo.ui.explore;

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
                R.drawable.ic_example1,
                R.drawable.ic_example2,
                R.drawable.ic_example3
        };
        Product p1 = new Product("Kg de pescado fresco",
                3.5, "Velez-Malaga", "Pescaderia Ejemplo", images[0]);
        Product p2 = new Product("Caja pequeña de chufles",
                2.5, "Velez-Malaga", "Fruteria Ejemplo", images[1]);
        Product p3 = new Product("Kg de fresas", 3.12,
                "Velez-Malaga", "Fruteria Ejemplo", images[2]);
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        getMvpView().processProducts(productList);
    }
}

