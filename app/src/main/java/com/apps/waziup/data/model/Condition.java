package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/4/2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("attrs")
    @Expose
    private List<String> attrs = null;
    @SerializedName("expression")
    @Expose
    private String expression;

    public List<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<String> attrs) {
        this.attrs = attrs;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
