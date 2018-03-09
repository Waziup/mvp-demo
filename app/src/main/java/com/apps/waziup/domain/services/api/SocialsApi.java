package com.apps.waziup.domain.services.api;


import com.apps.waziup.domain.services.model.SocialMessage;
import com.apps.waziup.domain.services.model.SocialMessageBatch;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface SocialsApi {
    /**
     * post several message to social networks
     *
     * @param domain (required)
     * @param data   social message (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/socials/batch")
    Observable<Void> domainsDomainSocialsBatchPost(
            @Path("domain") String domain, @Body SocialMessageBatch data
    );

    /**
     * Get all messages sent
     *
     * @param domain (required)
     * @return Call&lt;SocialMessage&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/socials")
    Observable<SocialMessage> domainsDomainSocialsGet(
            @Path("domain") String domain
    );

    /**
     * delete a message to social networks
     *
     * @param domain (required)
     * @param msgId  (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/socials/{msg_id}")
    Observable<Void> domainsDomainSocialsMsgIdDelete(
            @Path("domain") String domain, @Path("msg_id") String msgId
    );

    /**
     * Get one message
     *
     * @param domain (required)
     * @param msgId  (required)
     * @return Call&lt;SocialMessage&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/socials/{msg_id}")
    Observable<SocialMessage> domainsDomainSocialsMsgIdGet(
            @Path("domain") String domain, @Path("msg_id") String msgId
    );

    /**
     * post a message to social networks
     *
     * @param domain (required)
     * @param data   social message (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/socials")
    Observable<Void> domainsDomainSocialsPost(
            @Path("domain") String domain, @Body SocialMessage data
    );

}
