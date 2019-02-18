package activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import CustomControls.CustomButton;
import Dialogs.DialogReport;
import adapters.RecyclerMohsoolatMoshabehAdapter;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.StoreRecyclerModel;

public class ShowInfoActivity extends ActivityEnhanced {

    String txtNumber = "tel:09301384709";
    CustomButton goToCallApp;
    android.support.v7.widget.Toolbar toolbar;
    Typeface typeface;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerMohsoolatMoshabehAdapter adapter;
    List<StoreRecyclerModel> items;
    CustomButton sendReportBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        items = new ArrayList<>();
        AppBarLayout appBarLayout = findViewById(R.id.show_info_appbar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0){
                    updateToolbarText("برنامه سازی پیشرفته");
                    isShow = true;
                }else if(isShow){
                    updateToolbarText("  ");
                    isShow = false;
                }
            }
        });

        typeface = Typeface.createFromAsset(getAssets() , "font/iran_sans.TTF");

        sendReportBtn = findViewById(R.id.report_problem_btn);
        sendReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogReport(App.ACTIVITY )
                        .setListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                //Toast.makeText(ShowInfoActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        goToCallApp = findViewById(R.id.buy_book_btn);
        goToCallApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(ShowInfoActivity.this ,
//                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(ShowInfoActivity.this ,
//                            new String[]{Manifest.permission.CALL_PHONE},
//                            1);
//                }else{
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse(txtNumber));
                    startActivity(callIntent);
                }
//            }
        });
        setupToolbar();
        setupRecyclerItems();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.moshabeh_recycler);
        linearLayoutManager = new LinearLayoutManager(ShowInfoActivity.this , LinearLayoutManager.HORIZONTAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerMohsoolatMoshabehAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerItems() {
        StoreRecyclerModel modelRecyclerView = new StoreRecyclerModel();
        for(int i = 0 ; i<10 ; i++){
            modelRecyclerView.setBookName("آب و فاضلاب روستایی");
            modelRecyclerView.setBookPay("5500 تومان");
            modelRecyclerView.setBookImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources()
                    , R.drawable.book , null));
            items.add(modelRecyclerView);
        }
    }

    private void updateToolbarText(String text){
        for(int i = 0 ; i <toolbar.getChildCount() ; i++){
            if(toolbar.getChildAt(i) instanceof TextView){
                ((TextView) toolbar.getChildAt(i)).setText(text);
                ((TextView) toolbar.getChildAt(i)).setTextColor(getResources().getColor(R.color.colorBlack));

            }
        }
    }


    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back_without_rtl);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int k = 0 ; k<toolbar.getChildCount() ; k++){
            if (toolbar.getChildAt(k) instanceof TextView){
                ((TextView) toolbar.getChildAt(k)).setTypeface(typeface);
                ((TextView) toolbar.getChildAt(k)).setTextSize(14.0f);
            }
        }
    }
}
