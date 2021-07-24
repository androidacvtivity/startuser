package com.alinasoft.startuser.Views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.alinasoft.startuser.Helpers.Utils;
import com.alinasoft.startuser.R;
import com.alinasoft.startuser.Retrofit.Scientist;


public class help extends BaseActivity {

    private  Scientist receivedScientist;



    @Override
    protected void onCreate (Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrowh).setOnClickListener(v-> Utils.showInfoDialog_help_ro(this,"Atenție",
                "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar in limba engleza si rusa."));
    }

    @Override
    public void onBackPressed() {
        Utils.showInfoDialog_help_ro(this,
                "Atenție", "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar in limba engleza si rusa.");
    }


    /**
     * Let's inflate our menu for the detail page
     */

    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.help, menu);

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



//        switch (item.getItemId()) {
//            case R.id.rolang:
//                Utils.sendScientistToActivity(this, receivedScientist, help.class);
//                finish();
//                return true;
//
//            case R.id.enlang:
//                Utils.sendScientistToActivity(this, receivedScientist, helpen.class);
//                finish();
//                return true;
//
//            case R.id.rulang:
//                Utils.sendScientistToActivity(this,receivedScientist,helpru.class);
//                finish();
//                return true;
//
//
//        }



        return super.onOptionsItemSelected(item);

    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }
}
