package com.mangu.fertodemo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.HttpException;
import timber.log.Timber;

public class NetworkUtils {

    public static boolean isHttpStatusCode(Throwable throwable, int statusCode) {
        return throwable instanceof HttpException
                && ((HttpException) throwable).code() == statusCode;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * For quick data hits.
     *
     * @return String content
     */
    public static String getURLContent(String url) {
        URL oURL;
        URLConnection oConnection;
        BufferedReader oReader;
        String sLine;
        StringBuilder sbResponse;
        String sResponse = null;

        try {
            oURL = new URL(url);
            oConnection = oURL.openConnection();
            oReader = new BufferedReader(
                    new InputStreamReader(oConnection.getInputStream(), "ISO_8859_1"));
            sbResponse = new StringBuilder();

            while ((sLine = oReader.readLine()) != null) {
                sbResponse.append(sLine);
            }

            sResponse = sbResponse.toString();
        } catch (Exception e) {
            Timber.e(e);
        }

        return sResponse;
    }
}
