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

    public String getCode() {
        return code;
    }



    public String getMessage() {
        return message;
    }

}
//end
