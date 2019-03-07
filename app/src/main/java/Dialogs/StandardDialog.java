package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import CustomControls.CustomButton;
import CustomControls.CustomButtonBold;
import CustomControls.CustomTextView;
import CustomControls.CustomTextViewBold;
import activities.InOrUpActivity;
import adapters.SharedPrefrencesInfo;
import ir.punshop.book.App;
import ir.punshop.book.R;

public class StandardDialog extends Dialog {

    private CustomTextViewBold title;
    private CustomTextView text;
    private CustomButtonBold yes , no;
    private String titleStr , textStr;
    private int mode;
    private SharedPrefrencesInfo sharedPrefrencesInfo;

    public StandardDialog(String title , String text , Context context , int mode) {
        super(context);
        this.titleStr = title;
        this.textStr = text;
        this.mode = mode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.standard_dialog_layout);

        getItems();

        title.setText(titleStr);
        text.setText(textStr);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mode){
                    case 1:
                        clearPrefrences();
                        break;
                    case 2:
                        nothingHappend();
                        break;
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void getItems() {
        sharedPrefrencesInfo = new SharedPrefrencesInfo();
        title = findViewById(R.id.dialog_title);
        text = findViewById(R.id.dialog_text);
        yes = findViewById(R.id.dialog_right_btn);
        no = findViewById(R.id.dialog_left_btn);
    }

    private void clearPrefrences(){
        sharedPrefrencesInfo.deletePrefrences();
        App.startActivity(InOrUpActivity.class , true);
    }
    private void nothingHappend(){
        dismiss();
    }
}
