package com.mangu.fertodemo.ui.main;


import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.inyection.ConfigPersistent;
import com.mangu.fertodemo.ui.base.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {
    private final DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }
}
