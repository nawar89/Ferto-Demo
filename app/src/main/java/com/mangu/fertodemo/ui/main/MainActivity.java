package com.mangu.fertodemo.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mangu.fertodemo.R;
import com.mangu.fertodemo.ui.base.BaseActivity;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(Throwable error) {
        Timber.e(error, "There was an error");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }
}
