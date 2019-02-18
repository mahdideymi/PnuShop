package CustomControls;

import android.content.Context;
import android.util.AttributeSet;

import ir.punshop.book.App;

public class CustomAutoComplete extends android.support.v7.widget.AppCompatAutoCompleteTextView {

    public CustomAutoComplete(Context context) {
        super(context);
        init();
    }

    public CustomAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomAutoComplete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(App.FONT_NORMAL);
    }
}
