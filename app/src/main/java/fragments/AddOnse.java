package fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;

import CustomControls.CustomAutoComplete;
import CustomControls.CustomButton;
import CustomControls.CustomEditText;
import CustomControls.CustomTextView;
import Dialogs.StandardDialog;
import ir.punshop.book.App;
import ir.punshop.book.R;

public class AddOnse extends Fragment {

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    CustomTextView errorImage;
    NestedScrollView scrollView;
    CustomAutoComplete autoCompleteField;
    CustomButton takePhoto;
    CustomButton saveAd;
    ImageView bookPhoto;
    CustomTextView clearAd, toolbarAdText;
    CustomEditText tozihatEditText, bookName, bookAuther, bookPayment, phoneNumber;
    //TODO: must read all of field read from server
    String[] fields = {"کامپیوتر گرایش فناوری اطلاعات" , "هوافضا ورودی ها 95 به بعد" ,
            "الهیات" , "حقوق مدنی" , "معماری و نقشه کشی" , "عمران ورودی های 93 به بعد"
            , "مهندسی خودرو" , "حسابداری" , "علوم تربیتی" , "مدیریت بازرگانی"};
    ArrayAdapter <String> adapter ;

    public AddOnse() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_onse, container, false);
        initViews(view);
        autoCompleteField.setAdapter(adapter);
        saveAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationData();
                if (bookPhoto.getVisibility() == View.GONE){
                    StandardDialog dialog = new StandardDialog("اخطار" , "لطفا عکس کتاب را هم بارگذاری نمایید." , App.ACTIVITY , 2);
                    dialog.show();
                }
            }
        });

        tozihatEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 249) {
                    App.toast("توضیحات شما بیشتر از حد مجاز است!");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(App.ACTIVITY,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(App.ACTIVITY,
                            new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        clearAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllViews();
            }
        });


        return view;
    }

    private void clearAllViews() {
        tozihatEditText.setText("");
        bookName.setText("");
        bookAuther.setText("");
        bookPayment.setText("");
        phoneNumber.setText("");
        toolbarAdText.requestFocus();
    }

    private void initViews(View view) {
        errorImage = view.findViewById(R.id.add_onse_error_image);
        adapter = new ArrayAdapter<>(App.CONTEXT, R.layout.item_auto_complete, fields);
        autoCompleteField = view.findViewById(R.id.autoCompleteUnit);
        scrollView = view.findViewById(R.id.scrollViewAddAd);
        saveAd = view.findViewById(R.id.save_ad);
        bookPhoto = view.findViewById(R.id.img_ad_pics);
        takePhoto = view.findViewById(R.id.take_photo_btn);
        clearAd = view.findViewById(R.id.clear_prefrence_text);
        toolbarAdText = view.findViewById(R.id.toolbar_ad_text);
        tozihatEditText = view.findViewById(R.id.tozihat_edit_text);
        bookName = view.findViewById(R.id.book_name_create_ad);
        bookAuther = view.findViewById(R.id.book_auther_create_ad);
        bookPayment = view.findViewById(R.id.book_payment_create_ad);
        phoneNumber = view.findViewById(R.id.phone_number_create_Ad);
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

    private void validationData() {
        backgroundSetKind(phoneNumber, true, 'N');
        backgroundSetKind(tozihatEditText, true, 'N');
        backgroundSetKind(bookName, true, 'N');
        backgroundSetKind(bookAuther, true, 'N');
        backgroundSetKind(bookPayment, true, 'N');

        boolean sendToWebService = true;
        String phoneNumberStr = phoneNumber.getText().toString();
        String tozihatStr = tozihatEditText.getText().toString();
        String nameStr = bookName.getText().toString();
        String auther = bookAuther.getText().toString();
        String price = bookPayment.getText().toString();
        if (nameStr.isEmpty() || nameStr.length() > 50) {
            sendToWebService = false;
            backgroundSetKind(bookName, false, 'U');
            bookName.requestFocus();
        } else if (auther.isEmpty() || auther.length() > 50) {
            sendToWebService = false;
            backgroundSetKind(bookAuther, false, 'U');
            bookAuther.requestFocus();
        } else if (price.isEmpty() || price.length() > 6 || price.length() <= 3) {
            sendToWebService = false;
            backgroundSetKind(bookPayment, false, 'U');
            bookPayment.requestFocus();
        } else if (tozihatStr.isEmpty() || tozihatStr.length() > 250) {
            sendToWebService = false;
            backgroundSetKind(tozihatEditText, false, 'U');
            tozihatEditText.requestFocus();
        } else if (phoneNumberStr.isEmpty() || phoneNumberStr.length() != 11 || phoneNumberStr.charAt(0) != '0' || phoneNumberStr.charAt(1) != '9') {
            sendToWebService = false;
            backgroundSetKind(phoneNumber, false, 'D');
            phoneNumber.requestFocus();
        }
        if (sendToWebService) {
            //TODO : send all data of new onse of ad to web service
        }
    }

    public AddOnse newInstance() {
        return new AddOnse();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                App.toast("camera permission granted.");
                Intent cameraIntent = new
                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                App.toast("camera permission denied.");
            }

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            bookPhoto.setVisibility(View.VISIBLE);
            bookPhoto.setImageBitmap(imageBitmap);
        }
    }
}
