package models;

import android.graphics.drawable.Drawable;

public class RecyclerModelMyAds {

    private String title;
    private String price;
    private Drawable img;
    private Drawable editMyAds;
    private Drawable isSelledMyAds;
    private Drawable shareMyAds;


    public RecyclerModelMyAds() {

    }

    public Drawable getShareMyAds() {
        return shareMyAds;
    }

    public void setShareMyAds(Drawable shareMyAds) {
        this.shareMyAds = shareMyAds;
    }

    public Drawable getEditMyAds() {
        return editMyAds;
    }

    public void setEditMyAds(Drawable editMyAds) {
        this.editMyAds = editMyAds;
    }

    public Drawable getIsSelledMyAds() {
        return isSelledMyAds;
    }

    public void setIsSelledMyAds(Drawable isSelledMyAds) {
        this.isSelledMyAds = isSelledMyAds;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
