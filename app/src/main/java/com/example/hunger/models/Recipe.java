package com.example.hunger.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
public class Recipe  implements Parcelable {
   private int id;
   private String title;
   private String imageUrl;
   private int servings;
   private int readyInMinutes;
   private String spoonacularSourceUrl;
   private List<String> dishTypes;
   private List<Ingredient> extendedIngredients;

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>(){
      public Recipe createFromParcel(Parcel in){
         return new Recipe(in);
      }
      public Recipe[] newArray(int size) {
         return new Recipe[size];
      }
   };

   private Recipe(Parcel in){
      this.id = in.readInt();
      this.title = in.readString();
      this.imageUrl = in.readString();
      this.servings = in.readInt();
      this.readyInMinutes = in.readInt();
      this.spoonacularSourceUrl = in.readString();

      this.dishTypes = new ArrayList<>();
      in.readList(dishTypes,String.class.getClassLoader());

      this.extendedIngredients = new ArrayList<>();
      in.readList(extendedIngredients,Ingredient.class.getClassLoader());

   }

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel parcel, int i) {
      parcel.writeInt(id);
      parcel.writeString(title);
      parcel.writeString(imageUrl);
      parcel.writeInt(servings);
      parcel.writeInt(readyInMinutes);
      parcel.writeString(spoonacularSourceUrl);
      parcel.writeList(dishTypes);
      parcel.writeList(extendedIngredients);
   }
}


