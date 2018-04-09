package com.apps.waziup.domain.services.networking;

/**
 * Created by askia on 3/16/2018.
 */


import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;


public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.example.com";
    public static final String API_OAUTH_REDIRECT = "nl.jpelgrm.retrofit2oauthrefresh://oauth";

    private static OkHttpClient.Builder httpClient;

    private static Retrofit.Builder builder;

    private static Context mContext;
    private static String mToken;

    /*
        public static <S> S createService(Class<S> serviceClass) {
            httpClient = new OkHttpClient.Builder();
            builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            OkHttpClient client = httpClient.build();
            Retrofit retrofit = builder.client(client).build();
            return retrofit.create(serviceClass);
        }

        public static <S> S createService(Class<S> serviceClass, String accessToken, Context c) {
            httpClient = new OkHttpClient.Builder();
            builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            if(accessToken != null) {
                mContext = c;
                mToken = accessToken;
                final String token = accessToken;
                httpClient.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Accept", "application/json")
                                .header("Content-type", "application/json")
                                .header("Authorization",
                                        //token.getTokenType() + " " + token.getAccessToken())
                                        "bearer" + " " + token)
                                .method(original.method(), original.body());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });

                httpClient.authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        if(responseCount(response) >= 2) {
                            // If both the original call and the call with refreshed token failed,
                            // it will probably keep failing, so don't try again.
                            return null;
                        }

                        // We need a new client, since we don't want to make another call using our client with access token
                        AuthApi tokenClient = createService(AuthApi.class);
                        //Call<AccessToken> call = tokenClient.authTokenPost(mToken.getRefreshToken(),
                         //       mToken.getClientID(), mToken.getClientSecret(), API_OAUTH_REDIRECT,
                         //       "refresh_token");
                        Call<AccessToken> call = tokenClient.authTokenPost();
                        try {
                            retrofit2.Response<AccessToken> tokenResponse = call.execute();
                            if(tokenResponse.code() == 200) {
                                AccessToken newToken = tokenResponse.body();
                                mToken = newToken;
                                SharedPreferences prefs = mContext.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
                                prefs.edit().putBoolean("oauth.loggedin", true).apply();
                                prefs.edit().putString("oauth.accesstoken", newToken.getAccessToken()).apply();
                                prefs.edit().putString("oauth.refreshtoken", newToken.getRefreshToken()).apply();
                                prefs.edit().putString("oauth.tokentype", newToken.getTokenType()).apply();

                                return response.request().newBuilder()
                                        .header("Authorization", newToken.getTokenType() + " " + newToken.getAccessToken())
                                        .build();
                            } else {
                                return null;
                            }
                        } catch(IOException e) {
                            return null;
                        }
                    }
                });
            }

            OkHttpClient client = httpClient.build();
            Retrofit retrofit = builder.client(client).build();
            return retrofit.create(serviceClass);
        }
    */
    private static int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }
}

