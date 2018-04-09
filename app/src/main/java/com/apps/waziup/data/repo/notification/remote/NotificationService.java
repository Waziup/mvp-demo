package com.apps.waziup.data.repo.notification.remote;

import com.apps.waziup.data.model.Notification;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by KidusMT on 4/4/2018.
 */

public interface NotificationService {

    /**
     * for getting list of notifications for a domain
     * @param domain
     * @return
     */
    @GET("/api/v1/domains/{domain}/notifications")
    Observable<List<Notification>> getNotifications(@Path("domain") String domain);

    /**
     * for getting a single notification detail for a specific domain
     * @param domain
     * @param id
     * @return
     */
    @GET("/api/v1/domains/{domain}/notifications/{notif_id}")
    Observable<Notification> getNotification(@Path("domain") String domain,@Path("notif_id") String id);

}
