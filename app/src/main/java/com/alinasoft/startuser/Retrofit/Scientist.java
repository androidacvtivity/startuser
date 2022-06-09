package com.alinasoft.startuser.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

 /**
 * Let's Create our Scientist class to represent a single employee.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our
 * class to support serialization and deserialization.
 */
public class Scientist implements Serializable {
    /**
     * Let' now come define instance fields for this class. We decorate them with
     * @SerializedName
     * attribute. Through this we are specifying the keys in our json data.
     */
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("galaxy")
    private String galaxy;
    @SerializedName("star")
    private String star;
    @SerializedName("serviciu")
     private String serviciu;
    @SerializedName("sectia")
     private String sectia;
     @SerializedName("depart")
     private String depart;
     @SerializedName("phone")
     private String phone;


     @SerializedName("phonemobil")
     private String phonemobil;


     @SerializedName("phoneinternal")
     private String phoneinternal;
     @SerializedName("email")
     private String email;
     @SerializedName("formname")
     private String formname;

     @SerializedName("personalinfo")
     private String personalinfo;

     @SerializedName("floor")
     private String floor;

     @SerializedName("office")
     private String office;


     @SerializedName("created_date")
     private String created_date;

     @SerializedName("statut")
     private String statut;


     @SerializedName("remove_date")
     private String remove_date;

     @SerializedName("date_updated")
     private String date_updated;

     @SerializedName("recoverydata")
     private String recoverydata;


     /**
     * Let's now come define our getter and setter methods.
     */
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }



     public String getRemove_date() {
         return remove_date;
     }


     public String getDate_updated() {
         return date_updated;
     }


     public String getRecoverydata() {
         return recoverydata;
     }


     public String getStatut() {
         return statut;
     }


     public String getCreated_date() {
         return created_date;
     }


     public String getFloor() {
         return floor;
     }


     public String getOffice() {
         return office;
     }


     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }


     public String getDepart() {
         return depart;
     }

     public String getPhone() {
         return phone;
     }


     public String getPhonemobil() {
         return phonemobil;
     }


     public String getPersonalinfo() {
         return personalinfo;
     }


     public String getFormname() {
         return formname;
     }


     public String getEmail() {
         return email;
     }


     public String getPhoneinternal() {
         return phoneinternal;
     }


     public String getServiciu() {
         return serviciu;
     }

     public String getSectia() {
         return sectia;
     }


     public String getStar() {
         return star;
     }

     public String getGalaxy() {
        return galaxy;
    }

     @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
//end

