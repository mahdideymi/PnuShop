package activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import CustomControls.CustomButton;
import CustomControls.CustomEditText;
import adapters.RecyclerStoreAdapter;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.StoreRecyclerModel;

public class SearchActivity extends ActivityEnhanced {

    private ImageView finishThisActivity;
    private CustomButton searchWithName;
    private CustomButton searchWithCode;
    private CustomButton searchWithAuther;
    private CustomEditText editSearch;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    RecyclerStoreAdapter adapter;
    List<StoreRecyclerModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editSearch.getText().toString().length() % 3 == 0){
                    initRecyclerItems();
                    gridLayoutManager = new GridLayoutManager(SearchActivity.this , 3);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    adapter = new RecyclerStoreAdapter(list);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        finishThisActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchWithName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonBackPressed(searchWithName , searchWithAuther  , searchWithCode);
            }
        });
        searchWithCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonBackPressed(searchWithCode , searchWithName , searchWithAuther);
            }
        });
        searchWithAuther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonBackPressed(searchWithAuther , searchWithName , searchWithCode);
            }
        });
    }

    private void initView() {
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.searchRecycler);
        editSearch = findViewById(R.id.edtSearch);
        finishThisActivity = findViewById(R.id.finishFromSearchActivity);
        searchWithName = findViewById(R.id.searchWithName);
        searchWithCode = findViewById(R.id.searchWithCode);
        searchWithAuther = findViewById(R.id.searchWithAuther);
    }

    private void setButtonBackPressed(CustomButton btnTrue , CustomButton btnFalse , CustomButton btnFalse1){
        final int sdk = Build.VERSION.SDK_INT;
        if(sdk < Build.VERSION_CODES.JELLY_BEAN){
            btnTrue.setBackgroundDrawable(ContextCompat.getDrawable(SearchActivity.this , R.drawable.button_search_back_pressed));
            btnTrue.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFalse.setBackgroundDrawable(ContextCompat.getDrawable(SearchActivity.this , R.drawable.button_search_back));
            btnFalse.setTextColor(getResources().getColor(R.color.colorWhite));
            btnFalse1.setBackgroundDrawable(ContextCompat.getDrawable(SearchActivity.this , R.drawable.button_search_back));
            btnFalse1.setTextColor(getResources().getColor(R.color.colorWhite));
        }else{
            btnTrue.setBackground(ContextCompat.getDrawable(SearchActivity.this,R.drawable.button_search_back_pressed));
            btnTrue.setTextColor(getResources().getColor(R.color.colorAccent));
            btnFalse.setBackground(ContextCompat.getDrawable(SearchActivity.this,R.drawable.button_search_back));
            btnFalse.setTextColor(getResources().getColor(R.color.colorWhite));
            btnFalse1.setBackground(ContextCompat.getDrawable(SearchActivity.this,R.drawable.button_search_back));
            btnFalse1.setTextColor(getResources().getColor(R.color.colorWhite));
            //
        }
    }

    private void initRecyclerItems() {
        StoreRecyclerModel modelRecyclerView = new StoreRecyclerModel();
        for(int i = 0 ; i<5 ; i++){
            modelRecyclerView.setBookName("آب و فاضلاب روستایی");
            modelRecyclerView.setBookPay("5500 تومان");
            modelRecyclerView.setBookImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources()
                    , R.drawable.book , null));
            list.add(modelRecyclerView);
        }
        Log.e("itemSize",""+list.size());
    }
}
