package com.example.hunger.models;

public class Ingredient {
    private int id;
    private String name;
    private String unit;
    private String aisle;
    private Double amount;
    private String image;
    private Measure measures;

    private class Measure {
        private MeasureSystem metric;
        private MeasureSystem us;

        private class MeasureSystem {
            private String amount;
            private String unitLong;
        }
    }
}
