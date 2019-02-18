package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerReportAdapter;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.ReportRecyclerModel;

public class DialogReport extends Dialog {

    private List<ReportRecyclerModel> list;

    private OnDismissListener listener;
    private LinearLayoutManager linearLayoutManager;

    public DialogReport( Context context) {
        super(context);
        init();
    }

    public DialogReport( Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_report);

        getItems();
    }

    private void getItems() {
        list = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.report_recycler);
        initialRecyclerItem();
        linearLayoutManager = new LinearLayoutManager(App.CONTEXT , LinearLayoutManager.VERTICAL , false);
        RecyclerReportAdapter adapter = new RecyclerReportAdapter(list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
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

    public DialogReport setListener(OnDismissListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(listener != null){
            listener.onDismiss(this);
        }
    }
}
