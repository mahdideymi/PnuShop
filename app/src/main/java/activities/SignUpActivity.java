package activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import CustomControls.CustomAutoComplete;
import CustomControls.CustomButtonBold;
import CustomControls.CustomCheckBox;
import CustomControls.CustomEditText;
import CustomControls.CustomTextView;
import CustomControls.CustomTextViewBold;
import adapters.SharedPrefrencesInfo;
import ir.punshop.book.ActivityEnhanced;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.SharedPrefUserModel;

public class SignUpActivity extends ActivityEnhanced {

    CustomEditText nameFamily, telNumber, stuNumber, email, pass, confirmPass;
    ScrollView scrollView;
    CustomTextViewBold nameError, telError, stuNumError, unitError, fieldError, emailError, passError, confirmPassError;
    CustomButtonBold signUpBtn;
    CustomCheckBox roleCheck;
    SharedPrefrencesInfo sharedPrefrencesInfo;
    SharedPrefUserModel user = new SharedPrefUserModel();
    CustomAutoComplete fieldAuto , unitsAuto;
    String[] fields = {"کامپیوتر گرایش فناوری اطلاعات" , "هوافضا ورودی ها 95 به بعد" ,
            "الهیات" , "حقوق مدنی" , "معماری و نقشه کشی" , "عمران ورودی های 93 به بعد"
            , "مهندسی خودرو" , "حسابداری" , "علوم تربیتی" , "مدیریت بازرگانی"};
    ArrayAdapter<String> adapterFields;
    String[] units = {"دانشگاه پیام نور مرکز مشهد" , "دانشگاه پیام نور مرکز همدان" ,
            "دانشگاه پیام نور مرکز تهران" , "دانشگاه پیام نور مرکز زاهدان" , "دانشگاه پیام نور مرکز سیستان و بلوچستان" , "دانشگاه پیام نور مرکز زنجان"
            , "دانشگاه پیام نور مرکز مراغه" , "دانشگاه پیام نور مرکز بیرجند" , "دانشگاه پیام نور مرکز نجف آباد" , "دانشگاه پیام نور مرکز گرگان"};
    ArrayAdapter<String>adapterUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        sharedPrefrencesInfo = new SharedPrefrencesInfo();
        init();

        fieldAuto.setAdapter(adapterFields);
        unitsAuto.setAdapter(adapterUnits);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {
                    setUserValue();
                    sharedPrefrencesInfo.saveUser(user);
                    //TODO: send signUp information to Server

                    App.startActivity(MainActivity.class, true);
                    finish();
                }
            }
        });

        roleCheck.setChecked(true);


    }

    private void setUserValue(){
        user.setNameAndFamily(nameFamily.getText().toString());
        user.setEmail(email.getText().toString());
        user.setTelNumber(telNumber.getText().toString());
        user.setField(fieldAuto.getText().toString());
        user.setUnit(unitsAuto.getText().toString());
        user.setToken("111111");
        //TODO : send request for token and set on sharedprefrences
        user.setColligateNum(stuNumber.getText().toString());
    }

    private void init() {
        adapterFields = new ArrayAdapter<>(App.CONTEXT,R.layout.item_auto_complete , fields);
        adapterUnits = new ArrayAdapter<>(App.CONTEXT,R.layout.item_auto_complete , units);
        fieldAuto = findViewById(R.id.field_edt);
        unitsAuto = findViewById(R.id.uni_edt);
        scrollView = findViewById(R.id.sign_up_scroll);
        roleCheck = findViewById(R.id.role_check_box);
        signUpBtn = findViewById(R.id.sign_up_btn);
        nameFamily = findViewById(R.id.name_family_edt);
        nameError = findViewById(R.id.name_error);
        telNumber = findViewById(R.id.mobile_edt);
        telError = findViewById(R.id.mobile_error);
        stuNumber = findViewById(R.id.stu_number_edt);
        stuNumError = findViewById(R.id.stu_number_error);
        unitError = findViewById(R.id.uni_error);
        fieldError = findViewById(R.id.field_error);
        email = findViewById(R.id.email_edt);
        emailError = findViewById(R.id.email_error);
        pass = findViewById(R.id.pass_edt);
        passError = findViewById(R.id.pass_error);
        confirmPass = findViewById(R.id.pass_confirm_edt);
        confirmPassError = findViewById(R.id.pass_confirm_error);
    }

    private void backgroundSetKindAuto(CustomAutoComplete edt, boolean kindBackground, char downOrUp) {
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
        backgroundSetKindAuto(unitsAuto, true, 'N');
        backgroundSetKindAuto(fieldAuto, true, 'N');
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
        String unitStr = unitsAuto.getText().toString();
        String feildStr = fieldAuto.getText().toString();
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
            backgroundSetKindAuto(unitsAuto, false, 'U');
            unitsAuto.requestFocus();
        } else if (feildStr.isEmpty()) {
            fieldError.setVisibility(View.VISIBLE);
            fieldError.setText("رشته خود را به درستی وارد نمایید.");
            sendToWebService = false;
            backgroundSetKindAuto(fieldAuto, false, 'U');
            fieldAuto.requestFocus();
        } else if (!isEmailValid(emailStr) || emailStr.isEmpty()) {
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

        return sendToWebService;

    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
