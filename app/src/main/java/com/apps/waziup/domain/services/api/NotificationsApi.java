package com.apps.waziup.domain.services.api;


import com.apps.waziup.domain.services.model.Notification;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface NotificationsApi {
    /**
     * Get all notifications
     *
     * @param domain (required)
     * @return Call&lt;Notification&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/notifications")
    Observable<Notification> domainsDomainNotificationsGet(
            @Path("domain") String domain
    );

    /**
     * delete a notification
     *
     * @param domain  (required)
     * @param notifId (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("domains/{domain}/notifications/{notif_id}")
    Observable<Void> domainsDomainNotificationsNotifIdDelete(
            @Path("domain") String domain, @Path("notif_id") String notifId
    );

    /**
     * Get one notification
     *
     * @param domain  (required)
     * @param notifId (required)
     * @return Call&lt;Notification&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("domains/{domain}/notifications/{notif_id}")
    Observable<Notification> domainsDomainNotificationsNotifIdGet(
            @Path("domain") String domain, @Path("notif_id") String notifId
    );

    /**
     * create a notification
     *
     * @param domain (required)
     * @param data   notification (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("domains/{domain}/notifications")
    Single<Response<Void>> domainsDomainNotificationsPost(
            @Path("domain") String domain, @Body Notification data
    );

}
