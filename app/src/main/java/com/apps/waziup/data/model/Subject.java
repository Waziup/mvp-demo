package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

    @SerializedName("entityNames")
    @Expose
    private List<String> entityNames = null;
    @SerializedName("condition")
    @Expose
    private Condition condition;

    public List<String> getEntityNames() {
        return entityNames;
    }

    public void setEntityNames(List<String> entityNames) {
        this.entityNames = entityNames;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
