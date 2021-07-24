package com.alinasoft.startuser.Views;

import androidx.appcompat.app.AppCompatActivity;

import com.alinasoft.startuser.Helpers.Utils;


public class BaseActivity extends AppCompatActivity {

    protected void show(String message){
        Utils.show(this,message);
    }
    protected void openPage(Class clazz){
        Utils.openActivity(this,clazz);
    }

}
