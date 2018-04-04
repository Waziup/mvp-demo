package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Social {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("message")
    @Expose
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
