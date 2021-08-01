package com.alinasoft.startuser.Views;
import android.content.Intent;
import android.os.Bundle;
//import androidx.appcompat.widget.Toolbar;
import com.alinasoft.startuser.R;
public class AboutUsActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
      //  Toolbar toolbar = findViewById(R.id.aboutUsToolBar);

        findViewById(R.id.mBackArrow).setOnClickListener(v ->finish());
    }

    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }
}
