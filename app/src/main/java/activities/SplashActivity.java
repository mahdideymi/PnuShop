package activities;

import android.os.Bundle;

import CustomControls.CustomTextView;
import adapters.SharedPrefrencesInfo;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.SharedPrefUserModel;

public class SplashActivity extends ActivityEnhanced {

    SharedPrefUserModel userModel;
    String nameFamily, email, telNumber, field, unit, token, collegiateNumber;
    SharedPrefrencesInfo sharedPrefrencesInfo;
    CustomTextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        userModel = new SharedPrefUserModel();
        sharedPrefrencesInfo = new SharedPrefrencesInfo();
        text = findViewById(R.id.showShare);

        userModel = sharedPrefrencesInfo.getUser();
        nameFamily = userModel.getNameAndFamily();
        email = userModel.getEmail();
        telNumber = userModel.getTelNumber();
        field = userModel.getField();
        unit = userModel.getUnit();
        token = userModel.getToken();
        collegiateNumber = userModel.getColligateNum();
        String nothing = "nothing";
        if (nameFamily.equals(nothing) || email.equals(nothing) || telNumber.equals(nothing)
                || field.equals(nothing) || unit.equals(nothing) || token.equals(nothing)
                || collegiateNumber.equals(nothing)) {
            App.HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    App.startActivity(InOrUpActivity.class, true);
                }
            }, 2000);
        }else{
            App.HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    App.startActivity(MainActivity.class, true);
                }
            }, 2000);
        }
    }
}
