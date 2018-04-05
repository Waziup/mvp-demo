package com.apps.waziup.data.repo;

import android.content.Context;

import com.apps.waziup.data.repo.user.remote.UserService;
import com.apps.waziup.util.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class BaseRemote {

    public static UserService userService;

    private Cache cache;

    public BaseRemote(Context context, String identifier) {

        int cacheSize = 10 * 1024 * 1024;//10MB for the cache size

        cache = new Cache(context.getApplicationContext().getCacheDir(), cacheSize);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(createClient())
                .build();

        switch (identifier) {
            case "sensor":
//                categoryService = retrofit.create(SensorService.class);
                break;
            case "request":
//                requestService = retrofit.create(RequestService.class);
                break;
            case "user":
                userService = retrofit.create(UserService.class);
                break;
        }
    }

    private OkHttpClient createClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
