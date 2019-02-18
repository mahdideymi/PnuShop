package adapters;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import ir.punshop.book.App;
import models.SharedPrefUserModel;

public class SharedPrefrencesInfo {
    private static final String PREF_NAME = "SPMNUser";

    private static final String KEY_FIRST_NAME_FAMILY = "name_family";
    private static final String EMAIL = "email";
    private static final String TELEPHONE_NUMBER= "telephone_number";
    private static final String FIELD = "field";
    private static final String UNIT = "unit";
    private static final String TOKEN = "token";
    private static final String COLLIGATE_NUMBER = "collegiate_number";

    private SharedPreferences sharedPreferences;


    public SharedPrefrencesInfo() {
        sharedPreferences = App.CONTEXT.getSharedPreferences(PREF_NAME , App.CONTEXT.MODE_PRIVATE);
    }

    public void saveUser(SharedPrefUserModel user){
        if (user != null){
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_FIRST_NAME_FAMILY , user.getNameAndFamily());
            editor.putString(EMAIL , user.getEmail());
            editor.putString(TELEPHONE_NUMBER , user.getTelNumber());
            editor.putString(FIELD , user.getField());
            editor.putString(UNIT , user.getUnit());
            editor.putString(TOKEN , user.getToken());
            editor.putString(COLLIGATE_NUMBER , user.getColligateNum());
            editor.apply();
        }
    }

    public SharedPrefUserModel getUser(){
        SharedPrefUserModel model = new SharedPrefUserModel();
        model.setNameAndFamily(sharedPreferences.getString(KEY_FIRST_NAME_FAMILY , "nothing"));
        model.setEmail(sharedPreferences.getString(EMAIL , "nothing"));
        model.setTelNumber(sharedPreferences.getString(TELEPHONE_NUMBER , "nothing"));
        model.setField(sharedPreferences.getString(FIELD , "nothing"));
        model.setUnit(sharedPreferences.getString(UNIT , "nothing"));
        model.setToken(sharedPreferences.getString(TOKEN , "nothing"));
        model.setColligateNum(sharedPreferences.getString(COLLIGATE_NUMBER , "nothing"));
        return model;
    }
}
