package com.mangu.fertodemo.ui.register;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mangu.fertodemo.R;
import com.mangu.fertodemo.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;


public class RegisterActivity extends BaseActivity implements RegisterMvpView,
        AdapterView.OnItemSelectedListener {

    @Inject
    RegisterPresenter mRegisterPresenter;
    @BindView(R.id.et_nombre)
    EditText mEtName;
    @BindView(R.id.et_apellidos)
    EditText mEtApellidos;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.btn_finish)
    Button mBtnFinish;
    private ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mRegisterPresenter.attachView(this);
        mAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_register, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);
        mSpinner.setOnItemSelectedListener(this);
        mRegisterPresenter.inicialiteSpinner(getIntent());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void showError(Throwable error) {
        Timber.e(error);
    }

    @OnClick(R.id.btn_finish)
    public void onClick(View view) {
        Snackbar.make(findViewById(android.R.id.content)
                , "Registado", Snackbar.LENGTH_LONG).show();
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("ItemSelected", mAdapter.getItem(i) + "");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void showSpinnerData(String extra) {
        if (extra != null && !extra.equalsIgnoreCase("default")) {
            int spinnerPosition = mAdapter.getPosition(extra);
            mSpinner.setSelection(spinnerPosition, true);
        } else if (extra != null && extra.equalsIgnoreCase("default")) {
            mSpinner.setSelection(0);
        }
    }
}
