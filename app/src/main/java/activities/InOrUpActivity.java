package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import ir.punshop.book.R;

public class InOrUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_or_up);
        Toast.makeText(this, "test toast 2", Toast.LENGTH_SHORT).show();
    }
}
