package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;

import CustomControls.CustomButton;
import CustomControls.CustomButtonBold;
import CustomControls.CustomTextView;
import CustomControls.CustomTextViewBold;
import ir.punshop.book.R;

public class StandardDialog extends Dialog {

    private CustomTextViewBold title;
    private CustomTextView text;
//    private CustomButtonBold yes , no;
    private String titleStr , textStr;

    public StandardDialog(String title , String text , Context context) {
        super(context);
        this.titleStr = title;
        this.textStr = text;
        init();
    }

    public StandardDialog(String title , String text , Context context, int themeResId) {
        super(context, themeResId);
        this.titleStr = title;
        this.textStr = text;
        init();
    }

    protected StandardDialog(String title , String text , Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.titleStr = title;
        this.textStr = text;
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.standard_dialog_layout);

        getItems();

        title.setText(titleStr);
        text.setText(textStr);

    }

    private void getItems() {
        title = findViewById(R.id.dialog_title);
        text = findViewById(R.id.dialog_text);
//        yes = findViewById(R.id.dialog_right_btn);
//        no = findViewById(R.id.dialog_left_btn);
    }
}
