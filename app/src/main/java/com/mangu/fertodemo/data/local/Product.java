package com.mangu.fertodemo.data.local;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Product {

    String mName;
    double mPrice;
    String mCity;
    String mVendor;
    int mPicture;

    public Product() {

    }

    @ParcelConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.mPrice, mPrice) != 0) return false;
        if (mPicture != product.mPicture) return false;
        if (!mName.equals(product.mName)) return false;
        if (!mCity.equals(product.mCity)) return false;
        return mVendor.equals(product.mVendor);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = mName.hashCode();
        temp = Double.doubleToLongBits(mPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + mCity.hashCode();
        result = 31 * result + mVendor.hashCode();
        result = 31 * result + mPicture;
        return result;
    }

        public String toString() {
        return "result" +  result +
         "result" +  temp;
    }
}
