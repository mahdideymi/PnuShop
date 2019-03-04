package CustomControls;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import ir.punshop.book.App;

public class CustomCheckBox extends android.support.v7.widget.AppCompatCheckBox {
    public CustomCheckBox(Context context) {
        super(context);
        init();
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(App.FONT_NORMAL);
    }
}
