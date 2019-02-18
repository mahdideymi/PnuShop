package fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerStoreAdapter;
import ir.punshop.book.App;
import activities.KindWallActivity;
import ir.punshop.book.R;
import activities.SearchActivity;
import models.StoreRecyclerModel;


@SuppressLint("ValidFragment")
public class HomeBookStore extends Fragment {

    List<StoreRecyclerModel> items;
    RecyclerStoreAdapter adapter;
    GridLayoutManager gridLayoutManager;
    ImageView goToSearchActivity;
    ImageView kindWall;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_book_store_fragment , null);
        items = new ArrayList<>();
        goToSearchActivity = view.findViewById(R.id.searchInBooks);
        goToSearchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.startActivity(SearchActivity.class);
            }
        });
        kindWall = view.findViewById(R.id.kindWall);
        kindWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.startActivity(KindWallActivity.class);
            }
        });

        initRecyclerItems();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.bookStoreRecycler);
        gridLayoutManager = new GridLayoutManager(getActivity() , 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerStoreAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerItems() {
        StoreRecyclerModel modelRecyclerView = new StoreRecyclerModel();
        for(int i = 0 ; i<10 ; i++){
            modelRecyclerView.setBookName("آب و فاضلاب روستایی");
            modelRecyclerView.setBookPay("5500 تومان");
            modelRecyclerView.setBookImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources()
                    , R.drawable.book , null));
            items.add(modelRecyclerView);
        }
        Log.e("itemSize",""+items.size());
    }
}
