package CustomControls;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ir.punshop.book.App;

public class CustomButtonBold extends AppCompatButton {
    public CustomButtonBold(Context context) {
        super(context);
    }

    public CustomButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButtonBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        setTypeface(App.FONT_NORMAL , Typeface.BOLD);
    }
}
