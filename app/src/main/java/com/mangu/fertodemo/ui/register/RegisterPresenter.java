package com.mangu.fertodemo.ui.register;

import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.inyection.ConfigPersistent;
import com.mangu.fertodemo.ui.base.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class RegisterPresenter extends BasePresenter<RegisterMvpView> {
    private final DataManager mDataManager;

    @Inject
    public RegisterPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(RegisterMvpView mvpView) {
        super.attachView(mvpView);
    }
}
