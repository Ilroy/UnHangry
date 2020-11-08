package com.example.hunger.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class Ingredient implements Parcelable {
    private int id;
    private String name;
    private String unit;
    private String aisle;
    private double amount;
    private String image;
    private Measure measures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Measure getMeasures() {
        return measures;
    }

    public void setMeasures(Measure measures) {
        this.measures = measures;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Ingredient comparedIngredient = (Ingredient) obj;

        return id == comparedIngredient.getId() &&
                name.equals(comparedIngredient.getName()) &&
                aisle.equals(comparedIngredient.getAisle()) &&
                unit.equals(comparedIngredient.getUnit()) &&
                amount == comparedIngredient.getAmount() &&
                image.equals(comparedIngredient.getImage()) &&
                measures.equals(comparedIngredient.getMeasures());
    }

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

        public MeasureSystem getMetric() {
            return metric;
        }

        public void setMetric(MeasureSystem metric) {
            this.metric = metric;
        }

        public MeasureSystem getUs() {
            return us;
        }

        public void setUs(MeasureSystem us) {
            this.us = us;
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;

            Measure comparedMeasure = (Measure) obj;

            return metric.equals(comparedMeasure.getMetric())
                    && us.equals(comparedMeasure.getUs());
        }

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

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getUnitLong() {
                return unitLong;
            }

            public void setUnitLong(String unitLong) {
                this.unitLong = unitLong;
            }

            @Override
            public boolean equals(@Nullable Object obj) {
                if(this == obj) return true;
                if(obj == null || getClass() != obj.getClass()) return false;

                MeasureSystem comparedMeasureSystem = (MeasureSystem) obj;

                return amount.equals(comparedMeasureSystem.getAmount()) &&
                        unitLong.equals(comparedMeasureSystem.getUnitLong());
            }

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
