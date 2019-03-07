package ir.punshop.book;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import CustomControls.CustomTextViewBold;

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context CONTEXT;
    public static Handler HANDLER = new Handler();
    @SuppressLint("StaticFieldLeak")
    public static AppCompatActivity ACTIVITY;
    public static Typeface FONT_BOLD;
    public static Typeface FONT_NORMAL;
    public static LayoutInflater INFLATER;

    public static void startActivity(Class targetActivity){
        startActivity(targetActivity , false);
    }

    public static void startActivity(Class targetActivity, boolean finish) {
        Intent intent = new Intent(ACTIVITY, targetActivity);
        ACTIVITY.startActivity(intent);
        if (finish) {
            ACTIVITY.finish();
        }
    }

    public static void toast(String message){
        toast(message , Toast.LENGTH_SHORT);
    }

    public static void toast(String message , int duration){
        View view = INFLATER.inflate(R.layout.toast , null);
        CustomTextViewBold txtMessage = view.findViewById(R.id.toastMessage);
        txtMessage.setText(message);
        Toast toast = new Toast(CONTEXT);
        toast.setDuration(duration);
        toast.setGravity(Gravity.BOTTOM , 0 , 250);
        toast.setView(view);
        toast.show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
        INFLATER = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        AssetManager assetManager = getAssets();
        FONT_BOLD = Typeface.createFromAsset(assetManager , "font/iran_sans.TTF");
        FONT_NORMAL = Typeface.createFromAsset(assetManager , "font/iran_sans_light.TTF");
    }
}
