package models;

import android.graphics.drawable.Drawable;

public class StoreRecyclerModel {

    private String bookName;
    private String bookPay;

    private Drawable bookImg;

    public StoreRecyclerModel(){

    }

    public StoreRecyclerModel(String bookName , String bookPay  , Drawable bookImg){
        this.bookName = bookName;
        this.bookPay = bookPay;
        this.bookImg = bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPay() {
        return bookPay;
    }

    public void setBookPay(String bookPay) {
        this.bookPay = bookPay;
    }


    public Drawable getBookImg() {
        return bookImg;
    }

    public void setBookImg(Drawable bookImg) {
        this.bookImg = bookImg;
    }

}
