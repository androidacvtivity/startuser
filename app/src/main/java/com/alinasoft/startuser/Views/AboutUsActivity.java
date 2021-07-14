package com.alinasoft.startuser.Views;
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
}
