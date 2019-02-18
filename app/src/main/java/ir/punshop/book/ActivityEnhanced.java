package ir.punshop.book;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

@SuppressLint("Registered")
public class ActivityEnhanced extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        App.ACTIVITY = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        App.ACTIVITY = this;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        App.ACTIVITY = this;
    }
}
