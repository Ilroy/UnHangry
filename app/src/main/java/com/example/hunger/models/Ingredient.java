package com.example.hunger.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
    private int id;
    private String name;
    private String unit;
    private String aisle;
    private double amount;
    private String image;
    private Measure measures;

    protected Ingredient(Parcel in) {
        id = in.readInt();
        name = in.readString();
        unit = in.readString();
        aisle = in.readString();
        amount = in.readDouble();
        image = in.readString();
        measures = in.readParcelable(Measure.class.getClassLoader());
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(unit);
        parcel.writeString(aisle);
        parcel.writeDouble(amount);
        parcel.writeString(image);
        parcel.writeParcelable(measures,i);
    }

    private static class Measure implements Parcelable{
        private MeasureSystem metric;
        private MeasureSystem us;

        protected Measure(Parcel in) {
            metric = in.readParcelable(MeasureSystem.class.getClassLoader());
            metric = in.readParcelable(MeasureSystem.class.getClassLoader());
        }

        public static final Creator<Measure> CREATOR = new Creator<Measure>() {
            @Override
            public Measure createFromParcel(Parcel in) {
                return new Measure(in);
            }

            @Override
            public Measure[] newArray(int size) {
                return new Measure[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(metric,i);
            parcel.writeParcelable(us,i);
        }

        private static class MeasureSystem implements Parcelable {
            private String amount;
            private String unitLong;

            protected MeasureSystem(Parcel in) {
                amount = in.readString();
                unitLong = in.readString();
            }

            public static final Creator<MeasureSystem> CREATOR = new Creator<MeasureSystem>() {
                @Override
                public MeasureSystem createFromParcel(Parcel in) {
                    return new MeasureSystem(in);
                }

                @Override
                public MeasureSystem[] newArray(int size) {
                    return new MeasureSystem[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(amount);
                parcel.writeString(unitLong);
            }
        }
    }
}
