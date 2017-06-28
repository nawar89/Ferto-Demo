package com.mangu.fertodemo.data.remote;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mangu.fertodemo.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static com.mangu.fertodemo.BuildConfig.OpenWeatherApiToken;

public class StarterServiceFactory {

    public static StarterService makeStarterService() {
        return makeStarterService(makeGson());

    }

    private static StarterService makeStarterService(Gson gson) {
        //TODO The "" will crash when called
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.google.es")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(makeOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(StarterService.class);

    }

    private static OkHttpClient makeOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message
                    -> Timber.d(message));
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
            httpClientBuilder.addInterceptor(chain -> {
                Request request = chain.request();
                HttpUrl originalHttpUrl = request.url();
                HttpUrl httpUrl = originalHttpUrl.newBuilder()
                        .addQueryParameter("appid", OpenWeatherApiToken).build();
                Request.Builder requestBuilder = request.newBuilder().url(httpUrl);
                return chain.proceed(requestBuilder.build());
            });
        }

        return httpClientBuilder.build();
    }

    private static Gson makeGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
}
