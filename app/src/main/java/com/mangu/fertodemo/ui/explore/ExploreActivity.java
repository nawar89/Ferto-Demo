package com.mangu.fertodemo.ui.explore;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mangu.fertodemo.R;
import com.mangu.fertodemo.data.local.Product;
import com.mangu.fertodemo.data.local.ProductAdapter;
import com.mangu.fertodemo.ui.base.BaseActivity;
import com.mangu.fertodemo.ui.common.ItemSpacingDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

import static com.mangu.fertodemo.util.ViewUtils.dpToPx;

public class ExploreActivity extends BaseActivity implements ExploreMvpView {
    @Inject
    ExplorePresenter mExplorePresenter;

    @BindView(R.id.rv_destacados)
    RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mExplorePresenter.attachView(this);
        mProductList = new ArrayList<>();
        mProductAdapter = new ProductAdapter(getApplicationContext(), mProductList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(
                getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mProductAdapter);
        mRecyclerView.addItemDecoration(new ItemSpacingDecoration(2, dpToPx(10), true));
        mExplorePresenter.prepareProducts();
    }


    @Override
    public int getLayout() {
        return R.layout.activity_explore;
    }

    @Override
    public void showError(Throwable error) {
        Timber.e(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExplorePresenter.detachView();
    }

    @Override
    public void processProducts(List<Product> productList) {
        mProductList.addAll(productList);
        mProductAdapter.notifyDataSetChanged();
    }
}
