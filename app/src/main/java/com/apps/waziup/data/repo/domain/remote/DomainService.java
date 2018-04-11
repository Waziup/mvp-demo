package com.apps.waziup.data.repo.domain.remote;

import com.apps.waziup.data.model.Domain;
import com.apps.waziup.data.model.DomainResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
    Observable<DomainResponse> createDomain(@Body Domain domain);

}
