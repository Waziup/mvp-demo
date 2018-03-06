package com.apps.waziup.domain.services.api;

import com.apps.waziup.domain.services.model.Domain;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface DomainsApi {
    /**
     * Delete domain
     *
     * @param domain (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}")
    Observable<Void> domainsDomainDelete(
            @Path("domain") String domain
    );

    /**
     * get domain
     *
     * @param domain (required)
     * @return Call&lt;Domain&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}")
    Observable<Domain> domainsDomainGet(
            @Path("domain") String domain
    );

    /**
     * list domains
     *
     * @return Call&lt;List&lt;Domain&gt;&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains")
    Observable<List<Domain>> domainsGet();


    /**
     * Create a domain
     *
     * @param body (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains")
    Observable<Void> domainsPost(
            @Body Domain body
    );

}
