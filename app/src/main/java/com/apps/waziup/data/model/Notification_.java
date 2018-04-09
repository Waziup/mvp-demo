package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification_ {

    @SerializedName("usernames")
    @Expose
    private List<String> usernames = null;
    @SerializedName("channels")
    @Expose
    private List<String> channels = null;
    @SerializedName("message")
    @Expose
    private String message;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
