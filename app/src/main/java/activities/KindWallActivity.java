package activities;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerStoreAdapter;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.StoreRecyclerModel;

public class KindWallActivity extends ActivityEnhanced {

    RecyclerView recyclerView;
    RecyclerStoreAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<StoreRecyclerModel> items;
    ImageView finishKindWall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind_wall);

        initRecyclerItems();
        recyclerView = findViewById(R.id.kindWallRecycler);
        gridLayoutManager = new GridLayoutManager(KindWallActivity.this , 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerStoreAdapter(items);
        recyclerView.setAdapter(adapter);
        finishKindWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initRecyclerItems() {
        finishKindWall = findViewById(R.id.finishKindWall);
        items = new ArrayList<>();
        StoreRecyclerModel modelRecyclerView = new StoreRecyclerModel();
        for(int i = 0 ; i<10 ; i++){
            modelRecyclerView.setBookName("آب و فاضلاب روستایی");
            modelRecyclerView.setBookPay("5500 تومان");
            modelRecyclerView.setBookImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources()
                    , R.drawable.book , null));
            items.add(modelRecyclerView);
        }
    }
}
