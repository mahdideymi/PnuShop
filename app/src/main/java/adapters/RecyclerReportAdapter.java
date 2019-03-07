package adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.punshop.book.App;
import ir.punshop.book.R;
import models.ReportRecyclerModel;

public class RecyclerReportAdapter extends RecyclerView.Adapter<RecyclerReportAdapter.ViewHolder> {

    private List<ReportRecyclerModel> list;

    public RecyclerReportAdapter(List<ReportRecyclerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(App.ACTIVITY).inflate(R.layout.item_recycler_report , viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.text.setText(list.get(i).getText());
        viewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.CONTEXT, "گزارش شما پس از بررسی پیگیری خواهد شد.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.report_problem_recycler_text);
        }
    }
}
