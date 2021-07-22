package com.alinasoft.startuser.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.alinasoft.startuser.Helpers.Utils;
import com.alinasoft.startuser.R;
import com.alinasoft.startuser.Retrofit.Scientist;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    //Let's define our instance fields
    private TextView nameTV,descriptionTV,galaxyTV,starTV,serviciuTV, sectiaTV, departTV, phoneTV, phoneinternalTV, emailTV, personalinfoTV,
            formnameTV,phonemobilTV, floorTV, officeTV,created_dateTV, statutTV, remove_dateTV, date_updatedTV ;

    private Scientist receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        nameTV= findViewById(R.id.nameTV);
        descriptionTV= findViewById(R.id.descriptionTV);
        galaxyTV= findViewById(R.id.galaxyTV);
        starTV= findViewById(R.id.starTV);
        serviciuTV = findViewById(R.id.serviciuTV);
        sectiaTV = findViewById(R.id.sectiaTV);
        departTV = findViewById(R.id.departTV);
        phoneTV = findViewById(R.id.phoneTV);
        phoneinternalTV = findViewById(R.id.phoneinternalTV);
        emailTV = findViewById(R.id.emailTV);
        personalinfoTV = findViewById(R.id.personalinfoTV);
        formnameTV = findViewById(R.id.formnameTV);
        phonemobilTV = findViewById(R.id.phonemobilTV);
        floorTV = findViewById(R.id.floorTV);
        officeTV = findViewById(R.id.officeTV);
        created_dateTV  = findViewById(R.id.created_dateTV);
        statutTV = findViewById(R.id.statutTV);
        remove_dateTV = findViewById(R.id.recoverydataTV);
        date_updatedTV = findViewById(R.id.date_updatedTV);
        remove_dateTV = findViewById(R.id.remove_dateTV);
        remove_dateTV = findViewById(R.id.recoverydataTV);

//        dobTV= findViewById(R.id.dobTV);
//        diedTV= findViewById(R.id.diedTV);
        FloatingActionButton editFAB = findViewById(R.id.editFAB);
		editFAB.setOnClickListener(this);
        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayout);
    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){
         receivedScientist = Utils.receiveScientist(getIntent(),DetailActivity.this);

         if(receivedScientist != null){
             nameTV.setText(receivedScientist.getName());
             descriptionTV.setText(receivedScientist.getDescription());
             galaxyTV.setText(receivedScientist.getGalaxy());
             starTV.setText(receivedScientist.getStar());
             serviciuTV.setText(receivedScientist.getServiciu());
             sectiaTV.setText(receivedScientist.getSectia());
             departTV.setText(receivedScientist.getDepart());
             phoneTV.setText(receivedScientist.getPhone());
             phoneinternalTV.setText(receivedScientist.getPhoneinternal());
             emailTV.setText(receivedScientist.getEmail());
             personalinfoTV.setText(receivedScientist.getPersonalinfo());
             formnameTV.setText(receivedScientist.getFormname());
             phonemobilTV.setText(receivedScientist.getPhonemobil());
             floorTV.setText(receivedScientist.getFloor());
             officeTV.setText(receivedScientist.getOffice());
             created_dateTV.setText(receivedScientist.getCreated_date());

             statutTV.setText(receivedScientist.getStatut());
             remove_dateTV.setText(receivedScientist.getRemove_date());
             date_updatedTV.setText(receivedScientist.getDate_updated());
             remove_dateTV.setText(receivedScientist.getRemove_date());



//             dobTV.setText(receivedScientist.getDob());
//             diedTV.setText(receivedScientist.getDied());

             mCollapsingToolbarLayout.setTitle(receivedScientist.getName());
             mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                                                                                  getColor(R.color.white));
//

             //mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor();
         }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionedit:
                Utils.sendScientistToActivity(this,receivedScientist,CRUDActivity.class);
                finish();
                return true;
            case android.R.id.home:
             //   NavUtils.navigateUpFromSameTask(this);
                Utils.sendScientistToActivity(this,receivedScientist,ScientistsActivity.class);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * When FAB button is clicked we want to go to the editing page
     */
    @Override
    public void onClick(View v) {
        int id =v.getId();
        if(id == R.id.editFAB){
            Utils.sendScientistToActivity(this,receivedScientist,CRUDActivity.class);
            finish();
        }
    }
    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * Let's finish the current activity when back button is pressed
     */
   // @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }

    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, ScientistsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    /**
     * Our onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidgets();
        receiveAndShowData();
    }

}
//end
