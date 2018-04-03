package com.apps.waziup.data.repo.user.remote;

import com.apps.waziup.data.model.AuthBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by KidusMT on 4/1/2018.
 */

public interface UserService {

    @Headers("Content-Type: application/json")
    @POST("/api/v1/auth/token")
    Observable<String> login(@Body AuthBody authBody);

}
