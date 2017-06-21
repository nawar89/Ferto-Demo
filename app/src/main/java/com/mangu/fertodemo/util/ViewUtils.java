package com.mangu.fertodemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.inputmethod.InputMethodManager;

public class ViewUtils {
    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    @NonNull
    public static Snackbar createErrorSnackbar(Context context, int idLayout) {
        return Snackbar.make(((Activity) context).findViewById(idLayout),
                "Sorry, try again, there was an error with the connection", Snackbar.LENGTH_LONG);
    }

}
