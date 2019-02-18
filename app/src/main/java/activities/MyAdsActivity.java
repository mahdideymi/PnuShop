package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import CustomControls.CustomTextView;
import adapters.ViewPagerAdapter;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.R;

public class MyAdsActivity extends ActivityEnhanced {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    ImageView finishActivity;
    CustomTextView toolbarTxt;
    Intent intent;
    String toolbarStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ads);

        intent = getIntent();
        Bundle bundle = intent.getExtras();

        init();
        if(bundle != null) {
            toolbarStr = bundle.get("toolbarTxt").toString();
            toolbarTxt.setText(toolbarStr);
        }
        finishActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        if (toolbarStr.equals("آگهی های من")){
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            if (tab != null)
                tab.select();
        }else{
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            if (tab != null)
                tab.select();
        }

    }
    private void init(){
        toolbarTxt = findViewById(R.id.txtToolbarMyAds);
        tabLayout = findViewById(R.id.tabLayoutMyAds);
        viewPager = findViewById(R.id.viewPagerMyAds);
        finishActivity = findViewById(R.id.back_myAds);
    }
}
