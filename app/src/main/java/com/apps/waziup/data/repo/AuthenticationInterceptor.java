package com.apps.waziup.data.repo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .header("Authorization","Bearer " + authToken)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
