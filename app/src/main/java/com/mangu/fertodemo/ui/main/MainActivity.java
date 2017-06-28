package com.mangu.fertodemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mangu.fertodemo.R;
import com.mangu.fertodemo.ui.base.BaseActivity;
import com.mangu.fertodemo.ui.explore.ExploreActivity;
import com.mangu.fertodemo.ui.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainMvpView {

    public static final String INTENT_USER_EXTRA_KEY = "userType";
    @Inject
    MainPresenter mMainPresenter;
    @BindView(R.id.iv_particular)
    ImageView mIvParticular;
    @BindView(R.id.iv_fisica)
    ImageView mIvFisica;
    @BindView(R.id.iv_intermediario)
    ImageView mIvWeather;
    @BindView(R.id.btn_explora)
    Button mBtnExplora;
    @BindView(R.id.constraintLayout)
    ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);
        mConstraintLayout.getBackground().setAlpha(90);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(Throwable error) {
        Timber.e(error, "There was an error");
    }

    @OnClick({R.id.iv_fisica, R.id.iv_particular, R.id.iv_intermediario})
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        switch (view.getId()) {
            case R.id.iv_fisica:
                intent.putExtra(INTENT_USER_EXTRA_KEY, "shop");
                break;
            case R.id.iv_intermediario:
                intent.putExtra(INTENT_USER_EXTRA_KEY, "middleman");
                break;
            case R.id.iv_particular:
                intent.putExtra(INTENT_USER_EXTRA_KEY, "client");
                break;
            default:
                Timber.e("Unknow view", view);
        }
        startActivity(intent);
    }

    @OnClick(R.id.btn_explora)
    public void register(View view) {
        startActivity(new Intent(this.getApplicationContext(), ExploreActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }
}
