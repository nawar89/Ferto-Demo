package com.mangu.fertodemo.ui.explore;

import com.mangu.fertodemo.data.local.Product;
import com.mangu.fertodemo.ui.base.MvpView;

import java.util.List;

public interface ExploreMvpView extends MvpView {
    void processProducts(List<Product> productList);
}
