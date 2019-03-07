package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerReportAdapter;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.ReportRecyclerModel;

public class DialogReport extends Dialog {

    private List<ReportRecyclerModel> list;

    public DialogReport( Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_report);
        getItems();
    }


    private void getItems() {
        list = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.report_recycler);
        initialRecyclerItem();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.CONTEXT, LinearLayoutManager.VERTICAL, false);
        RecyclerReportAdapter adapter = new RecyclerReportAdapter(list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                //TODO: send report for server and check this
                App.toast("تخلف با موفقیت به ثبت رسید.");
                dismiss();
                return true;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                //TODO: send report for server and check this
                App.toast("تخلف با موفقیت به ثبت رسید.");
                dismiss();

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {
            }
        });
    }

    private void initialRecyclerItem() {

        setToListRecycler("محتوای آگهی نامناسب است.");
        setToListRecycler("آگهی چندین بار پست شده است.");
        setToListRecycler("توضیحات آگهی نامناسب است.");
        setToListRecycler("اطلاعات آگهی گمراه کننده یا دروغ است.");
        setToListRecycler("آگهی در دسته بندی نامناسب قرار گرفته است.");
        setToListRecycler("قیمت آگهی نامناسب است.");
        setToListRecycler("عکس های آگهی نامناسب است.");
        setToListRecycler("دلایل دیگر");
    }

    private void setToListRecycler(String string){
        ReportRecyclerModel model = new ReportRecyclerModel();
        model.setText(string);
        list.add(model);
    }
}
