package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("description")
    @Expose
    private String description;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
