package adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import CustomControls.CustomTextView;
import ir.punshop.book.App;
import ir.punshop.book.R;
import models.RecyclerModelMyAds;

public class RecyclerFavoriteAdapter extends RecyclerView.Adapter<RecyclerFavoriteAdapter.ViewHolder> {

    private List<RecyclerModelMyAds> list;

    public RecyclerFavoriteAdapter(List<RecyclerModelMyAds> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(App.CONTEXT ).inflate(R.layout.item_favorite_layout ,viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgMyAds.setImageDrawable(list.get(i).getImg());
        viewHolder.titleMyAds.setText(list.get(i).getTitle());
        viewHolder.priceMyAds.setText(list.get(i).getPrice());
        viewHolder.isSelledMyAds.setImageDrawable(list.get(i).getIsSelledMyAds());
        viewHolder.shareMyAds.setImageDrawable(list.get(i).getShareMyAds());
        viewHolder.shareMyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.ACTIVITY, "share button is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.isSelledMyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.ACTIVITY, "Ads is Selled.", Toast.LENGTH_SHORT).show();
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
        ImageView shareMyAds;
        ImageView isSelledMyAds;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            shareMyAds = itemView.findViewById(R.id.shareFavorite);
            isSelledMyAds = itemView.findViewById(R.id.isSellFavorite);
            imgMyAds = itemView.findViewById(R.id.imgBookFavorite);
            titleMyAds = itemView.findViewById(R.id.txtTitleFavorite);
            priceMyAds = itemView.findViewById(R.id.paymentFavorite);
        }
    }
}
