package com.mangu.fertodemo.ui.detail;

import android.icu.util.Currency;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mangu.fertodemo.R;
import com.mangu.fertodemo.data.local.Product;
import com.mangu.fertodemo.ui.base.BaseActivity;

import org.parceler.Parcels;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;
import timber.log.Timber;

import static com.mangu.fertodemo.util.ViewUtils.createErrorSnackbar;


public class DetailActivity extends BaseActivity implements DetailMvpView {

    @Inject
    DetailPresenter mDetailPresenter;

    Product mProductToShow;
    @BindView(R.id.iv_detail_product)
    ImageView mDetailProduct;
    @BindView(R.id.tv_detail_name)
    TextView mDetailName;
    @BindView(R.id.tv_detail_shop)
    TextView mDetailShop;
    @BindView(R.id.tv_detail_price)
    TextView mDetailPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mDetailPresenter.attachView(this);
        Bundle extraBundle = getIntent().getBundleExtra(DetailActivity.class.getSimpleName());
        if (extraBundle == null) {
            createErrorSnackbar(this, getLayout());
            finish();
        } else {
            mProductToShow = Parcels.unwrap(extraBundle.
                    getParcelable(Product.class.getSimpleName()));
            prepareLayout();
        }

    }

    private void prepareLayout() {
        Glide.with(this)
                .load(mProductToShow.getPicture())
                .into(mDetailProduct);
        mDetailName.setText(mProductToShow.getName());
        mDetailPrice.append(Double.toString(mProductToShow.getPrice()));
        mDetailPrice.append(" €");
        mDetailShop.append(" " + mProductToShow.getVendor() + " " +mProductToShow.getCity() );
    }
    @OnClick(R.id.btn_buy)
    public void buyProduct() {
        finish();
    }
    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public void showError(Throwable error) {
        Timber.e(error);
    }
}
