package com.apps.waziup.data.repo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.apps.waziup.data.repo.domain.remote.DomainService;
import com.apps.waziup.data.repo.user.remote.UserService;
import com.apps.waziup.util.Constants;
import com.apps.waziup.util.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;
import static com.apps.waziup.util.Constants.APP_NAME;
import static com.apps.waziup.util.Constants.USER_TOKEN;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class BaseRemote {

    public static UserService userService;
    public static DomainService domainService;
    private Cache cache;
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public BaseRemote(Context context, String identifier) {
        String authToken = "";
        int cacheSize = 10 * 1024 * 1024;//10MB for the cache size
        cache = new Cache(context.getApplicationContext().getCacheDir(), cacheSize);

        SharedPreferences pref = context.getSharedPreferences(APP_NAME, MODE_PRIVATE);
        authToken = pref.getString(USER_TOKEN, "");

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit;

        //whenever there is an authorization code from the user
        if (TextUtils.isEmpty(authToken)) {

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(createClient())
                    .build();
        } else {//when there seems to be no authorization code from the user

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(createClient(authToken))
                    .build();
        }

        switch (identifier) {
            case "sensor":
//                categoryService = retrofit.create(SensorService.class);
                break;
            case "notification":
//                notificationService = retrofit.create(NotificationService.class);
                break;
            case "user":
                userService = retrofit.create(UserService.class);
                break;
            case "domain":
                domainService = retrofit.create(DomainService.class);
                break;
        }
    }

    /**
     * with token from the user login
     *
     * @param auth (required for some api calls)
     * @return OkHttpClient.Builder for the retrofit to use it as a client
     */
    private OkHttpClient createClient(String auth) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(auth);
        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);
        }
        return httpClient.
                cache(cache)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    /**
     * for simple api calls that doesn't require any authorization code
     *
     * @return OkHttpClient.Builder for the retrofit to use it as a client
     */
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
