package com.alinasoft.startuser.Views;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import com.alinasoft.startuser.Helpers.Utils;


public class BaseActivity extends AppCompatActivity {

    protected void show(String message){
        Utils.show(this,message);
    }
    protected void openPage(Class clazz){
        Utils.openActivity(this,clazz);
    }

}
