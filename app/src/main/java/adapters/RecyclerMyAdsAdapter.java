package adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import CustomControls.CustomTextView;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.RecyclerModelMyAds;

public class RecyclerMyAdsAdapter extends RecyclerView.Adapter<RecyclerMyAdsAdapter.ViewHolder> {

    private List<RecyclerModelMyAds> list;

    public RecyclerMyAdsAdapter(List<RecyclerModelMyAds> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(App.CONTEXT ).inflate(R.layout.item_my_ads_layout,viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgMyAds.setImageDrawable(list.get(i).getImg());
        viewHolder.titleMyAds.setText(list.get(i).getTitle());
        viewHolder.priceMyAds.setText(list.get(i).getPrice());
        viewHolder.editMyAds.setImageDrawable(list.get(i).getEditMyAds());
        viewHolder.isSelledMyAds.setImageDrawable(list.get(i).getIsSelledMyAds());
        viewHolder.shareMyAds.setImageDrawable(list.get(i).getShareMyAds());
        viewHolder.shareMyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.toast("share button is clicked.");
            }
        });
        viewHolder.editMyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.toast("edit My Ads clicked.");
            }
        });

        viewHolder.isSelledMyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.toast("Ads is Sell");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMyAds;
        CustomTextView titleMyAds;
        CustomTextView priceMyAds;
        ImageView editMyAds;
        ImageView shareMyAds;
        ImageView isSelledMyAds;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            shareMyAds = itemView.findViewById(R.id.shareAds);
            editMyAds = itemView.findViewById(R.id.editMyAds);
            isSelledMyAds = itemView.findViewById(R.id.isSell);
            imgMyAds = itemView.findViewById(R.id.imgBookMyAds);
            titleMyAds = itemView.findViewById(R.id.txtTitleMyAds);
            priceMyAds = itemView.findViewById(R.id.paymentMyAds);
        }
    }
}
