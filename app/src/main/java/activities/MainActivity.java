package activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import fragments.AddOnse;
import fragments.SpecialSuggest;
import fragments.HomeBookStore;
import fragments.Profile;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;

public class MainActivity extends ActivityEnhanced {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeBookStore());

        BottomNavigationView navigation =  findViewById(R.id.navigation);
//        disableShiftMode(navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        fragment = new HomeBookStore();
                        break;
                    case R.id.navigation_dashboard:
                        fragment = new SpecialSuggest();
                        break;
                    case R.id.navigation_notifications:
                        fragment = new AddOnse();
                        break;
                    case R.id.navigation_notifications3:
                        fragment = new Profile();
                }
                return loadFragment(fragment);
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container , fragment)
                    .commit();
            return true;
        }
        return false;
    }

    boolean doubleBackToExitPressedOne = false;
    @Override
    public void onBackPressed() {
        if(doubleBackToExitPressedOne){
            super.onBackPressed();
            finish();
        }
        this.doubleBackToExitPressedOne = true;
        Toast.makeText(MainActivity.this, "برای خروج لطفا دوباره بزنید.", Toast.LENGTH_SHORT).show();
        App.HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOne = false;
            }
        },2000);
    }


   /* @SuppressLint("RestrictedApi")
    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
//                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }*/

}

