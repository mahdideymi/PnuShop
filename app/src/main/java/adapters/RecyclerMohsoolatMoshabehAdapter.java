package adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import CustomControls.CustomTextView;
import activities.ShowInfoActivity;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.StoreRecyclerModel;

public class RecyclerMohsoolatMoshabehAdapter extends RecyclerView.Adapter<RecyclerMohsoolatMoshabehAdapter.ViewHolder> {

    private List<StoreRecyclerModel> items;

    public RecyclerMohsoolatMoshabehAdapter(List<StoreRecyclerModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(App.CONTEXT).inflate(R.layout.item_recycler_store_in_info_activity,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.bookImg.setImageDrawable(items.get(position).getBookImg());
        viewHolder.bookName.setText(items.get(position).getBookName());
        viewHolder.bookPay.setText(items.get(position).getBookPay());
        viewHolder.bookImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.startActivity(ShowInfoActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView bookImg;
        public CustomTextView bookName;
        public CustomTextView bookPay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImg = itemView.findViewById(R.id.recyclerBookImage);
            bookName = itemView.findViewById(R.id.recyclerBookName);
            bookPay = itemView.findViewById(R.id.recyclerBookPay);
        }
    }

}
