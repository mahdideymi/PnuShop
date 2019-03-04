package activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import CustomControls.CustomButtonBold;
import CustomControls.CustomCheckBox;
import CustomControls.CustomEditText;
import CustomControls.CustomTextView;
import CustomControls.CustomTextViewBold;
import ir.punshop.book.App;
import ir.punshop.book.R;

public class SignUpActivity extends AppCompatActivity {

    CustomEditText nameFamily, telNumber, stuNumber, email, pass, confirmPass;
    CustomEditText colligateUnit, feild;
    ScrollView scrollView;
    CustomTextViewBold nameError, telError, stuNumError, unitError, fieldError, emailError, passError, confirmPassError;
    CustomButtonBold signUpBtn;
    CustomCheckBox roleCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        init();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {
                    App.startActivity(MainActivity.class, true);
                    finish();
                }
            }
        });

        roleCheck.setChecked(true);


    }

    private void init() {
        scrollView = findViewById(R.id.sign_up_scroll);
        roleCheck = findViewById(R.id.role_check_box);
        signUpBtn = findViewById(R.id.sign_up_btn);
        nameFamily = findViewById(R.id.name_family_edt);
        nameError = findViewById(R.id.name_error);
        telNumber = findViewById(R.id.mobile_edt);
        telError = findViewById(R.id.mobile_error);
        stuNumber = findViewById(R.id.stu_number_edt);
        stuNumError = findViewById(R.id.stu_number_error);
        colligateUnit = findViewById(R.id.uni_edt);
        unitError = findViewById(R.id.uni_error);
        feild = findViewById(R.id.field_edt);
        fieldError = findViewById(R.id.field_error);
        email = findViewById(R.id.email_edt);
        emailError = findViewById(R.id.email_error);
        pass = findViewById(R.id.pass_edt);
        passError = findViewById(R.id.pass_error);
        confirmPass = findViewById(R.id.pass_confirm_edt);
        confirmPassError = findViewById(R.id.pass_confirm_error);
    }

    private void backgroundSetKind(CustomEditText edt, boolean kindBackground, char downOrUp) {
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
        if (downOrUp == 'U') {
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        } else if (downOrUp == 'D') {
            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        }
    }

    private boolean validation() {
        backgroundSetKind(nameFamily, true, 'N');
        backgroundSetKind(telNumber, true, 'N');
        backgroundSetKind(stuNumber, true, 'N');
        backgroundSetKind(colligateUnit, true, 'N');
        backgroundSetKind(feild, true, 'N');
        backgroundSetKind(email, true, 'N');
        backgroundSetKind(pass, true, 'N');
        backgroundSetKind(confirmPass, true, 'N');


        nameError.setVisibility(View.INVISIBLE);
        telError.setVisibility(View.INVISIBLE);
        stuNumError.setVisibility(View.INVISIBLE);
        unitError.setVisibility(View.INVISIBLE);
        fieldError.setVisibility(View.INVISIBLE);
        emailError.setVisibility(View.INVISIBLE);
        passError.setVisibility(View.INVISIBLE);
        confirmPassError.setVisibility(View.INVISIBLE);

        boolean sendToWebService = true;

        String nameFamilyStr = nameFamily.getText().toString();
        String telNumberStr = telNumber.getText().toString();
        String stuNmberStr = stuNumber.getText().toString();
        String unitStr = colligateUnit.getText().toString();
        String feildStr = feild.getText().toString();
        String emailStr = email.getText().toString();
        String passStr = pass.getText().toString();
        String confirmPassStr = confirmPass.getText().toString();

        if (nameFamilyStr.length() <= 4) {
            nameError.setVisibility(View.VISIBLE);
            nameError.setText("نام و نام خانوادگی نمی تواند کمتر از 4 حرف باشد.");
            sendToWebService = false;
            backgroundSetKind(nameFamily, false, 'U');
            nameFamily.requestFocus();
        } else if (telNumberStr.isEmpty() || telNumberStr.length() != 11 || telNumberStr.charAt(0) != '0' || telNumberStr.charAt(1) != '9') {
            telError.setVisibility(View.VISIBLE);
            telError.setText("تلفن همراه خود را به درستی وارد نمایید.");
            sendToWebService = false;
            backgroundSetKind(telNumber, false, 'U');
            telNumber.requestFocus();
        } else if (stuNmberStr.length() != 9) {
            stuNumError.setVisibility(View.VISIBLE);
            stuNumError.setText("شماره دانشجویی خود را به درستی وارد نمایید.");
            sendToWebService = false;
            backgroundSetKind(stuNumber, false, 'U');
            stuNumber.requestFocus();
        } else if (unitStr.isEmpty()) {
            unitError.setVisibility(View.VISIBLE);
            unitError.setText("دانشگاه نمی تواند خالی باشد.");
            sendToWebService = false;
            backgroundSetKind(colligateUnit, false, 'U');
            colligateUnit.requestFocus();
        } else if (feildStr.isEmpty()) {
            fieldError.setVisibility(View.VISIBLE);
            fieldError.setText("رشته خود را به درستی وارد نمایید.");
            sendToWebService = false;
            backgroundSetKind(feild, false, 'U');
            feild.requestFocus();
        } else if (isEmailValid(emailStr) || emailStr.isEmpty()) {
            emailError.setVisibility(View.VISIBLE);
            emailError.setText("ایمیل خود را به درستی وارد نمایید.");
            sendToWebService = false;
            backgroundSetKind(email, false, 'D');
            email.requestFocus();
        } else if (passStr.isEmpty()) {
            passError.setVisibility(View.VISIBLE);
            passError.setText("رمز عبور نمی تواند خالی باشد.");
            sendToWebService = false;
            backgroundSetKind(pass, false, 'D');
            pass.requestFocus();
        } else if (passStr.length() < 8) {
            passError.setVisibility(View.VISIBLE);
            passError.setText("رمز عبور باید بیشتر از 8 کاراکتر باشد");
            sendToWebService = false;
            backgroundSetKind(pass, false, 'D');
            pass.requestFocus();
        } else if (!confirmPassStr.equals(passStr)) {
            confirmPassError.setVisibility(View.VISIBLE);
            confirmPassError.setText("عدم تطابق رمز عبور ها");
            sendToWebService = false;
            backgroundSetKind(confirmPass, false, 'D');
            confirmPass.requestFocus();
        }

        //TODO: send signUp information to Server
        return sendToWebService;

    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
