package activities;

import android.graphics.Paint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import CustomControls.CustomButtonBold;
import CustomControls.CustomEditText;
import CustomControls.CustomTextViewBold;
import adapters.SharedPrefrencesInfo;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.SharedPrefUserModel;

public class LoginActivity extends AppCompatActivity {

    CustomEditText email , pass;
    CustomTextViewBold emailError , passError;
    CustomTextViewBold goToSignUp , forgetPass;
    CustomButtonBold loginBtn;
    SharedPrefrencesInfo sharedPrefrencesInfo;
    SharedPrefUserModel user = new SharedPrefUserModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        goToSignUp.setPaintFlags(goToSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        forgetPass.setPaintFlags(forgetPass.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()){
                    //TODO: send request to server for login and if exist any account go to MainActivity and save prefrences info
                    user.setToken("1111");
                    user.setColligateNum("949696906");
                    user.setUnit("پیام نور مرکز مشهد");
                    user.setField("کارشناسی کامیپوتر گرایش فناوری اطلاعات");
                    user.setTelNumber("09301384709");
                    user.setEmail("mahdideymi4709@gmail.com");
                    user.setNameAndFamily("مهدی دیمی");
                    sharedPrefrencesInfo.saveUser(user);
                    App.startActivity(MainActivity.class , true);
                    finish();
                }
            }
        });

        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.startActivity(SignUpActivity.class , true);
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: implement forget password
            }
        });
    }

    private void init() {
        sharedPrefrencesInfo = new SharedPrefrencesInfo();
        email = findViewById(R.id.login_email_edt);
        emailError = findViewById(R.id.login_email_error);
        pass = findViewById(R.id.login_pass_edt);
        passError = findViewById(R.id.login_pass_error);
        goToSignUp = findViewById(R.id.login_goTo_signup);
        loginBtn = findViewById(R.id.login_btn);
        forgetPass = findViewById(R.id.forget_pass);
    }

    private void backgroundSetKind(CustomEditText edt, boolean kindBackground) {
        int sdk = Build.VERSION.SDK_INT;
        if (kindBackground) {
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                edt.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_text_ad));
            } else {
                edt.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_text_ad));
            }
        } else {
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                edt.setBackgroundDrawable(getResources().getDrawable(R.drawable.validation_false_add_ad));
            } else {
                edt.setBackgroundDrawable(getResources().getDrawable(R.drawable.validation_false_add_ad));
            }
        }

    }

    private boolean validation(){
        String emailStr = email.getText().toString();
        String passStr = pass.getText().toString();

        backgroundSetKind(email , true);
        backgroundSetKind(pass , true);

        emailError.setVisibility(View.INVISIBLE);
        passError.setVisibility(View.INVISIBLE);

        boolean sendToWebService = true;

        if (emailStr.isEmpty()){
            emailError.setVisibility(View.VISIBLE);
            emailError.setText("ایمیل نمی تواند خالی باشد.");
            sendToWebService = false;
            backgroundSetKind(email , false);
            email.requestFocus();
        }else if(passStr.isEmpty()){
            passError.setVisibility(View.VISIBLE);
            passError.setText("رمز عبور نمی تواند خالی باشد.");
            sendToWebService = false;
            backgroundSetKind(pass , false);
            pass.requestFocus();
        }

        return sendToWebService;
    }
}
