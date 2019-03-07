package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerStoreAdapter;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.StoreRecyclerModel;

public class SpecialSuggest extends Fragment {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    RecyclerStoreAdapter adapter;
    List<StoreRecyclerModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_suggest_by_field, null);
        list = new ArrayList<>();
        initRecyclerItems();
        recyclerView = view.findViewById(R.id.specialSuggestRecycler);
        gridLayoutManager = new GridLayoutManager(App.CONTEXT , 2);
        adapter = new RecyclerStoreAdapter(list);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initRecyclerItems() {
        StoreRecyclerModel modelRecyclerView = new StoreRecyclerModel();
        for (int i = 0; i < 10; i++) {
            modelRecyclerView.setBookName("آب و فاضلاب روستایی");
            modelRecyclerView.setBookPay("5500 تومان");
            modelRecyclerView.setBookImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources()
                    , R.drawable.book, null));
            list.add(modelRecyclerView);
        }
    }
}
