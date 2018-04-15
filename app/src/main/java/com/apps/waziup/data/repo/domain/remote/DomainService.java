package com.apps.waziup.data.repo.domain.remote;

import com.apps.waziup.data.model.Domain;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by KidusMT on 4/4/2018.
 */

public interface DomainService {

    /**
     * for getting all the domains from the API
     * @return domains
     */
    @GET("/api/v1/domains")
    Observable<List<Domain>> getDomains();

    /**
     * for creating a domain
     * @param domain containing the string id
     * @return response a domain object with id and type
     */
    @Headers("Content-Type: application/json")
    @POST("/api/v1/domains")
    Observable<Void> createDomain(@Body Domain domain);

    /**
     * for deleting a specific domain from the domain list on remote
     * @param domain (required)
     * @return string saying deleted
     */
    @Headers("Content-Type: application/json")
    @DELETE("/api/v1/domains/{domain}")
    Observable<Void> deleteDomain(@Path("domain") String domain);

}
