package com.mangu.fertodemo.data.local;

public class Product {

    private String mName;
    private double mPrice;
    private String mCity;
    private String mVendor;
    private int mPicture;

    public Product() {

    }

    public Product(String mName, double mPrice, String mCity, String mVendor, int mPicture) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mCity = mCity;
        this.mVendor = mVendor;
        this.mPicture = mPicture;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getVendor() {
        return mVendor;
    }

    public void setVendor(String mVendor) {
        this.mVendor = mVendor;
    }

    public int getPicture() {
        return mPicture;
    }

    public void setPicture(int mPicture) {
        this.mPicture = mPicture;
    }
}
