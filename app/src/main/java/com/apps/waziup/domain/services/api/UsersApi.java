package com.apps.waziup.domain.services.api;

import com.apps.waziup.domain.services.model.User;
import com.apps.waziup.domain.services.model.UserUpdateBody;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface UsersApi {
    /**
     * Get all users in a realm
     *
     * @param domain (required)
     * @return Call&lt;List&lt;User&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/users/")
    Observable<List<User>> domainsDomainUsersGet(
            @Path("domain") String domain
    );

    /**
     * Create a new user in a realm
     *
     * @param domain (required)
     * @param user   user object (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/users/")
    Single<Response<Void>> domainsDomainUsersPost(
            @Path("domain") String domain, @Body User user
    );

    /**
     * Search users with specific criteria
     *
     * @param domain (required)
     * @return Call&lt;List&lt;User&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/users/search/")
    Observable<List<User>> domainsDomainUsersSearchGet(
            @Path("domain") String domain
    );

    /**
     * @param domain (required)
     * @param userid (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/users/{userid}")
    Single<Response<Void>> domainsDomainUsersUseridDelete(
            @Path("domain") String domain, @Path("userid") String userid
    );

    /**
     * @param domain (required)
     * @param userid (required)
     * @return Call&lt;User&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/users/{userid}")
    Observable<User> domainsDomainUsersUseridGet(
            @Path("domain") String domain, @Path("userid") String userid
    );

    /**
     * @param domain (required)
     * @param userid (required)
     * @param data   user data to update (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("domains/{domain}/users/{userid}")
    Single<Response<Void>> domainsDomainUsersUseridPut(
            @Path("domain") String domain, @Path("userid") String userid, @Body UserUpdateBody data
    );

}
