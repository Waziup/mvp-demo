package com.apps.waziup.domain.services.api;


import com.apps.waziup.domain.services.model.AuthBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface AuthApi {
    /**
     * Get the access token for subsequent calls
     *
     * @param domain      (required)
     * @param credentials auth credentials (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/token")
    Observable<Void> authTokenPost(
            @Path("domain") String domain, @Body AuthBody credentials
    );

}
