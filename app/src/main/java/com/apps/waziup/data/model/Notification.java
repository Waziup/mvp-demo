package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("subject")
    @Expose
    private Subject subject;
    @SerializedName("notification")
    @Expose
    private Notification_ notification;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("throttling")
    @Expose
    private Integer throttling;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Notification_ getNotification() {
        return notification;
    }

    public void setNotification(Notification_ notification) {
        this.notification = notification;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Integer getThrottling() {
        return throttling;
    }

    public void setThrottling(Integer throttling) {
        this.throttling = throttling;
    }

}
