package com.alinasoft.startuser.Views;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.alinasoft.startuser.Helpers.Utils;
import com.alinasoft.startuser.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DashboardActivity extends AppCompatActivity {

    //We have 4 cards in the dashboard
    LinearLayout viewScientistsCard;
    LinearLayout addScientistCard;
    LinearLayout third;
    LinearLayout closeCard;
    LinearLayout help;
    /**
     * Let's initialize our cards  and listen to their click events
     */
    private void initializeWidgets(){
        viewScientistsCard = findViewById(R.id.viewScientistsCard);
        addScientistCard = findViewById(R.id.addScientistCard);
        third = findViewById(R.id.third);
        closeCard = findViewById(R.id.closeCard);
        help = findViewById(R.id.help);

		viewScientistsCard.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivity.class));
        addScientistCard.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,CRUDActivity.class));

        help.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,help.class));



        third.setOnClickListener(v -> {

            Utils.openActivity(DashboardActivity.this,AboutUsActivity.class);
//                Utils.showInfoDialog(DashboardActivity.this, "YEEES",
//                "Hey You can Display another page when this is clicked");

        });
        closeCard.setOnClickListener(v -> finish());
    }
    /**
     * Let's override the attachBaseContext() method
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * When the back button is pressed finish this activity
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

//    public void onBackPressed() {
//        Intent intent;
//        intent = new Intent(this, ScientistsActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        finish();
//      //  startActivity(intent);
 //  }

    /**
     * Let's override the onCreate() and call our initializeWidgets()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.initializeWidgets();
    }
}
//end


