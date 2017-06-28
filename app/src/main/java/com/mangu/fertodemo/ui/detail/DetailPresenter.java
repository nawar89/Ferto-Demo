package com.mangu.fertodemo.ui.detail;

import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.ui.base.BasePresenter;

import javax.inject.Inject;

public class DetailPresenter extends BasePresenter<DetailMvpView> {
    private final DataManager mDataManager;

    @Inject
    public DetailPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(DetailMvpView mvpView) {
        super.attachView(mvpView);
    }


}
