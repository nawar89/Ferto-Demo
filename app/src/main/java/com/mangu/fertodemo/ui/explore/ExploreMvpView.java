package com.mangu.fertodemo.ui.explore;

import android.os.Bundle;

import com.mangu.fertodemo.data.local.Product;
import com.mangu.fertodemo.ui.base.MvpView;

import java.util.List;

public interface ExploreMvpView extends MvpView {

    void processProducts(List<Product> productList);

    void startDetailActivity(Bundle bundle);
}
