package com.apps.waziup.data.repo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.apps.waziup.data.repo.domain.remote.DomainService;
import com.apps.waziup.data.repo.sensor.remote.SensorService;
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
    public static SensorService sensorService;
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

        //whenever there is token
        if (TextUtils.isEmpty(authToken)) {

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(createClient())
                    .build();
        } else {//when there is no token we still allow the user to do some basic request

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(createClient(authToken))
                    .build();
        }

        switch (identifier) {
            case "sensor":
                sensorService = retrofit.create(SensorService.class);
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
        //for authenticating the request with previous token from the server
        httpClient.addInterceptor(new AuthenticationInterceptor(auth));
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
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
