package fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import CustomControls.CustomTextView;
import Dialogs.StandardDialog;
import ir.punshop.book.App;
import activities.MyAdsActivity;
import ir.punshop.book.R;

public class Profile extends Fragment implements View.OnClickListener {

    CustomTextView suggestToFriends;
    CustomTextView favorite;
    CustomTextView myAds;
    CustomTextView helper;
    CustomTextView limitUse;
    CustomTextView aboutUs;
    LinearLayout suggest , favoriteLine , myAdsLine , helperLine , limitUseLine , aboutUsLine;
    CustomTextView clearPrefrencesText;
    ImageView clearPrefrencesImg;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.profile_fragment, null);
        init(view);
        suggest.setOnClickListener(this);
        favoriteLine.setOnClickListener(this);
        myAdsLine.setOnClickListener(this);
        helperLine.setOnClickListener(this);
        limitUseLine.setOnClickListener(this);
        aboutUsLine.setOnClickListener(this);
        suggestToFriends.setOnClickListener(this);
        favorite.setOnClickListener(this);
        myAds.setOnClickListener(this);
        helper.setOnClickListener(this);
        limitUse.setOnClickListener(this);
        aboutUs.setOnClickListener(this);

        clearPrefrencesText.setOnClickListener(this);
        clearPrefrencesImg.setOnClickListener(this);

        return view;
    }

    private void init(View view) {
        clearPrefrencesImg = view.findViewById(R.id.clear_prefrence_icon);
        clearPrefrencesText = view.findViewById(R.id.clear_prefrence_text);
        suggest = view.findViewById(R.id.lineSuggestToFriend);
        favoriteLine = view.findViewById(R.id.lineFavorite);
        myAdsLine = view.findViewById(R.id.lineMyAds);
        helperLine = view.findViewById(R.id.lineHelper);
        limitUseLine = view.findViewById(R.id.lineLimitUse);
        aboutUsLine = view.findViewById(R.id.lineAboutUs);
        suggestToFriends = view.findViewById(R.id.suggestToFriend);
        favorite = view.findViewById(R.id.favorite);
        myAds = view.findViewById(R.id.myAds);
        helper = view.findViewById(R.id.helper);
        limitUse = view.findViewById(R.id.limitUse);
        aboutUs = view.findViewById(R.id.aboutUs);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.suggestToFriend:
                shareToFriend();
                break;
            case R.id.lineSuggestToFriend:
                shareToFriend();
                break;
            case R.id.favorite:
                intentWithExtras("نشان شده ها");
                break;
            case  R.id.lineFavorite:
                intentWithExtras("نشان شده ها");
                break;
            case R.id.myAds:
                intentWithExtras("آگهی های من");
                break;
            case R.id.lineMyAds:
                intentWithExtras("آگهی های من");
                break;
            case R.id.helper:
                Toast.makeText(App.ACTIVITY, "پشتیبانی", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lineHelper:
                Toast.makeText(App.ACTIVITY, "پشتیبانی", Toast.LENGTH_SHORT).show();
                //TODO : open helper box for send message for us
                break;
            case R.id.limitUse:
                Toast.makeText(App.ACTIVITY, "شرایط استفاده", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lineLimitUse:
                Toast.makeText(App.ACTIVITY, "شرایط استفاده", Toast.LENGTH_SHORT).show();
                //TODO: how to use this application
                break;
            case R.id.aboutUs:
                Toast.makeText(App.ACTIVITY, "درباره ما", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lineAboutUs:
                Toast.makeText(App.ACTIVITY, "درباره ما", Toast.LENGTH_SHORT).show();
                //TODO: about us
                break;
            case R.id.clear_prefrence_icon:
                showDialogForClearPrefrences();
                break;
            case R.id.clear_prefrence_text:
                showDialogForClearPrefrences();
                break;
        }
    }

    private void shareToFriend() {
        String shareBody = "ما را در لینک فلان در کافه بازار دنبال کنید.";
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT , "\n\n");
        sharingIntent.putExtra(Intent.EXTRA_TEXT , shareBody);
        startActivity(Intent.createChooser(sharingIntent , "دعوت از دوستان"));

    }

    private void intentWithExtras(String extrasString){
        Intent intent = new Intent(App.ACTIVITY , MyAdsActivity.class);
        intent.putExtra("toolbarTxt" , extrasString);
        startActivity(intent);
    }

    private void showDialogForClearPrefrences(){
        final StandardDialog dialog = new StandardDialog("خروج از حساب کاربری" , "آیا قصد خروج از حساب کاربری را دارید؟" , App.ACTIVITY , 1);
        dialog.show();
    }

}

