package com.example.cpu11112_local.cleansample.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.utils.AuthorizationInterceptor;
import com.example.cpu11112_local.cleansample.utils.Constant;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class MovieRetrofitInstance {

    public static Retrofit getInstance(@NonNull Context context) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient(context))
                .build();
    }

    private static OkHttpClient getClient(Context context) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // add loggingInterceptor to client
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constant.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constant.TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new AuthorizationInterceptor());

        // add cache to client
        final File baseDir = context.getCacheDir();
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, Constant.CACHE_DIR);
            builder.cache(new Cache(cacheDir, Constant.CACHE_SIZE));
        }

        // build all client
        return builder.build();
    }
}
