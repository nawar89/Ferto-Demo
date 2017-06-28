package com.mangu.fertodemo.ui.register;

import android.content.Intent;

import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.inyection.ConfigPersistent;
import com.mangu.fertodemo.ui.base.BasePresenter;

import javax.inject.Inject;

import static com.mangu.fertodemo.ui.main.MainActivity.INTENT_USER_EXTRA_KEY;

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

    public void inicialiteSpinner(Intent intent) {
        String extra = intent.getStringExtra(INTENT_USER_EXTRA_KEY);
        if (extra != null && extra.equalsIgnoreCase("")) {
            getMvpView().showSpinnerData(extra);
        } else {
            getMvpView().showSpinnerData("default");
        }
    }
}
