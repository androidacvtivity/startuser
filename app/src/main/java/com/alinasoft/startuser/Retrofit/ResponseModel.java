package com.alinasoft.startuser.Retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Our json response will be mapped to this class.
 */
public class ResponseModel {
    /**
     * Our ResponseModel attributes
     */
    @SerializedName("result")
    List<Scientist> scientists;
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;


    /**
     * Generate Getter and Setters
     */
    public List<Scientist> getResult() {
        return scientists;
    }

    public void setResult(List<Scientist> scientists) {
        this.scientists = scientists;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
//end
