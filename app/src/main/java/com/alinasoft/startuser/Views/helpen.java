package com.alinasoft.startuser.Views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.alinasoft.startuser.Helpers.Utils;
import com.alinasoft.startuser.R;
import com.alinasoft.startuser.Retrofit.Scientist;

public class helpen extends BaseActivity{

    private  Scientist receivedScientist;




    @Override
    protected  void onCreate (Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.help_en);

            Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_en);
            setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrowh_en).setOnClickListener(v -> finish());

            findViewById(R.id.mBackArrowh_en).setOnClickListener( v -> Utils.showInfoDialog_help_en(this,
                    "Attention!", "Are you sure you want to exit? We have translate help in romanian and russian.") );
        }


    @Override
    public void onBackPressed() {

        Utils.showInfoDialog_help_en(this,
                "Attention!", "Are you sure you want to exit? We have translate help in romanian and russian.");
    }



    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.help, menu);
        return true;

    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.rolang){
            Utils.sendScientistToActivity(this, receivedScientist, help.class);
                finish();
                return true;
        }

        else
        if (id==R.id.enlang)
        {

            Utils.sendScientistToActivity(this, receivedScientist, helpen.class);
            finish();
            return true;
        }

        else


        if (id==R.id.rulang)
        {

            Utils.sendScientistToActivity(this, receivedScientist, helpru.class);
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);

    }
    @SuppressWarnings("unused")
    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }
}