package com.example.app22_scrollview;

import android.os.Parcel;
import android.os.Parcelable;

public class Frutas implements Parcelable {
    private String name;
    private float prize;

    public Frutas(String name, float prize) {
        this.name = name;
        this.prize = prize;
    }

    protected Frutas(Parcel in) {
        name = in.readString();
        prize = in.readFloat();
    }

    public static final Creator<Frutas> CREATOR = new Creator<Frutas>() {
        @Override
        public Frutas createFromParcel(Parcel in) {
            return new Frutas(in);
        }

        @Override
        public Frutas[] newArray(int size) {
            return new Frutas[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrize() {
        return this.prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return name + " " + prize +" €\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeFloat(prize);
    }
}
