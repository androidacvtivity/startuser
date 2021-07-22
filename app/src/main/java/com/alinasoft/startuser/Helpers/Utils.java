package com.alinasoft.startuser.Helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alinasoft.startuser.Views.ScientistsActivity;
import com.yarolegovich.lovelydialog.LovelyChoiceDialog;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.alinasoft.startuser.R;
import com.alinasoft.startuser.Retrofit.Scientist;
import com.alinasoft.startuser.Views.DashboardActivity;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.alinasoft.startuser.Views.help;
import com.alinasoft.startuser.Views.helpen;
import com.alinasoft.startuser.Views.helpru;

/**
 * A Utility class. Contains reusable utility methods we will use throughout our project.This
 * class will save us from typing lots of repetitive code.
 */
public class Utils {
    /**
     * Let's define some Constants
     */
    //supply your ip address. Type ipconfig while connected to internet to get your
    //ip address in cmd. Watch video for more details.
     //
    //




     private  static  final String base_url = "http://bancusoft.com/PHP/bns/";
   // private  static  final String base_url = "http://192.168.0.102/PHP/bns/";

  //  private  static  final String base_url = "http://192.168.0.100/PHP/bns/";
    //private  static  final String base_url = "http://10.0.3.2/PHP/scientists/";

  //  private  static  final String base_url =   "http://172.20.14.3/PHP/bns/";
    private static Retrofit retrofit = null;
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * This method will return us our Retrofit instance which we can use to initiate HTTP calls.
     */
    public static Retrofit getClient(){
        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(base_url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();


//            retrofit = new retrofit2.Retrofit.Builder()
//                    .baseUrl(base_url)
//                    .addConverterFactory(new NullOnEmptyConverterFactory())
//                    .addConverterFactory(GsonConverterFactory.create()).build();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(okHttpClient)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build();


        }

        return  retrofit;
    }
    /**
     * THis method will allow us show Toast messages throughout all activities
     */
    public static void show(Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }
    /**
     * This method will allow us validate edittexts
     */
    public static boolean validate(EditText... editTexts){
        EditText nameTxt = editTexts[0];
        EditText descriptionTxt = editTexts[1];
        EditText galaxyTxt = editTexts[2];
        EditText phoneTxt = editTexts[6];
        EditText emailTxt = editTexts[8];

        if(nameTxt.getText() == null || nameTxt.getText().toString().isEmpty()){
            nameTxt.setError("Numele este obligatoriu Vă rog!");
            return false;
        }
        if(descriptionTxt.getText() == null || descriptionTxt.getText().toString().isEmpty()){
            descriptionTxt.setError("Locația este obligatorie Vă rog!");
            return false;
        }
        if(galaxyTxt.getText() == null || galaxyTxt.getText().toString().isEmpty()){
            galaxyTxt.setError("Funcția este obligatorie Vă rog!");
            return false;
        }

//        if(phoneTxt.getText() == null || phoneTxt.getText().toString().isEmpty()){
//            phoneTxt.setError("Telefonul este obligatorie Vă rog!");
//            return false;
//        }



        if(emailTxt.getText() == null || emailTxt.getText().toString().isEmpty()){
            emailTxt.setError("Email-ul  este obligatorie Vă rog!");
            return false;
        }
        return true;

    }
    /**
     * This utility method will allow us clear arbitrary number of edittexts
     */
    public static void clearEditTexts(EditText... editTexts){
        for (EditText editText:editTexts) {
            editText.setText("");
        }
    }
    /**
     * This utility method will allow us open any activity.
     */
    public static void openActivity(Context c,Class clazz){
        Intent intent = new Intent(c, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(intent);
    }


//    public static AlertDialog showDialog  (final AppCompatActivity activity, String title,
//                                           String message){
//
//
//
//    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog(final AppCompatActivity activity, String title,
                                      String message) {
        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Relax", v -> {})
                .setNeutralButton("Dashboard", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("The List", v -> openActivity(activity, ScientistsActivity.class))
                .show();
    }








    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ro(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)

                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("en", v -> openActivity(activity, helpen.class))
                .setNeutralButton("La inceput", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, helpru.class))

                .show();
    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_en(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help.class))
                .setNeutralButton("Dashboard", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, helpru.class))

                .show();
    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ru(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help.class))
                .setNeutralButton("В начало", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", v -> openActivity(activity, helpen.class))


                .show();
    }


    /**
     * This method will allow us show a single select dialog where we can select and return a
     * star to an edittext.
     */
     public static void selectStar(Context c,final EditText starTxt){
//        String[] stars ={"Rigel","Aldebaran","Arcturus","Betelgeuse","Antares","Deneb",
//        "Wezen","VY Canis Majoris","Sirius","Alpha Pegasi","Vega","Saiph","Polaris",
//        "Canopus","KY Cygni","VV Cephei","Uy Scuti","Bellatrix","Naos","Pollux",
//        "Achernar","Other"};

    String[] stars ={"Director General","Director general adjunct","tehnologii informationale","statistica intreprinderilor","statistica macroeconomica","colectarea datelor entitati economice",

            "statistica sociala si demografie","CRS NORD","CRS NORD Balti","CRS NORD Briceni","CRS NORD Donduseni","CRS NORD Drochia","CRS NORD Edinet",

            "CRS NORD Falesti","CRS NORD Floresti","CRS NORD Glodeni","CRS NORD Ocnita","CRS NORD Rezina","CRS NORD Rascani","CRS NORD Sangerei",

            "CRS NORD Soroca","CRS NORD Soldanesti", "CRS NORD Soldanesti","CRS NORD Telenesti","CRS CENTRU","CRS CENTRU Anenii-Noi",
            "CRS CENTRU Calarasi","CRS CENTRU Causeni","CRS CENTRU Cimislia","CRS CENTRU Criuleni",
            "CRS CENTRU Dubasari Cocieri","CRS CENTRU Hancesti","CRS CENTRU Ialoveni","CRS CENTRU Nisporeni",
            "CRS CENTRU Orhei","CRS CENTRU Straseni","CRS CENTRU Stefan-Voda","CRS CENTRU Ungheni","CRS SUD","CRS SUD Basarabeasca",
            "CRS SUD Cahul","CRS SUD Cantemir","CRS SUD UTA Gagauzia","CRS SUD Leova","CRS SUD Taraclia","CRS CENTRU Donduseni","CRS CENTRU Drochia",
            "CRS CENTRU Dubasari (Cocieri)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(c,
         android.R.layout.simple_list_item_1,
                stars);
        new LovelyChoiceDialog(c)
                .setTopColorRes(R.color.darkGreen)
                .setTitle("Direcția generală")
                .setTitleGravity(Gravity.CENTER_HORIZONTAL)
                .setIcon(R.drawable.m_star)
                .setMessage("Selectați Direcția generală sau cenrtul regional")
                .setMessageGravity(Gravity.CENTER_HORIZONTAL)
                .setItems(adapter, (position, item) -> starTxt.setText(item))
                .show();
    }

    /**
     * This method will allow us convert a string into a java.util.Date object and
     *  return it.
     */
    public static Date giveMeDate(String stringDate){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
            return sdf.parse(stringDate);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * This method will allow us show a progressbar
     */
    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }
    /**
     * This method will allow us hide a progressbar
     */
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }
    /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */
    public static void sendScientistToActivity(Context c, Scientist scientist,
     Class clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY",scientist);
        c.startActivity(i);
    }

    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientist receiveScientist(Intent intent,Context c){
        try {
            Scientist scientist= (Scientist) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientist;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }
}
//end
