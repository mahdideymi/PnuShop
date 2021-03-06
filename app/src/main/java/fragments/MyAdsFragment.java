package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerMyAdsAdapter;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.RecyclerModelMyAds;

public class MyAdsFragment extends Fragment {

    List<RecyclerModelMyAds> list;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerMyAdsAdapter adsAdapter;

    public MyAdsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_my_ads , container , false);
        list = new ArrayList<>();
        initRecyclerItems();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.myAdsRecyclerView);
        linearLayoutManager = new LinearLayoutManager(App.CONTEXT , LinearLayoutManager.VERTICAL , false);
        adsAdapter = new RecyclerMyAdsAdapter(list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adsAdapter);
    }

    private void initRecyclerItems() {
        RecyclerModelMyAds modelMyAds = new RecyclerModelMyAds();
        for (int i = 0 ; i < 10 ; i++){
            modelMyAds.setTitle("برنامه نویسی پیشرفته");
            modelMyAds.setPrice("5500 تومان");
            modelMyAds.setImg(ResourcesCompat.getDrawable(App.ACTIVITY.getResources() , R.drawable.book , null));
            modelMyAds.setEditMyAds(ResourcesCompat.getDrawable(App.ACTIVITY.getResources() , R.drawable.ic_edit , null));
            modelMyAds.setIsSelledMyAds(ResourcesCompat.getDrawable(App.ACTIVITY.getResources() , R.drawable.ic_delete_forever , null));
            modelMyAds.setShareMyAds(ResourcesCompat.getDrawable(App.ACTIVITY.getResources() , R.drawable.ic_share_gray , null));
            list.add(modelMyAds);
        }
    }

    public static MyAdsFragment newInstance() {

        return new MyAdsFragment();
    }
}
