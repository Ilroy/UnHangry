package com.example.hunger.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class Recipe  implements Parcelable {
   private int id;
   private String title;
   private String image;
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
      return image;
   }

   public void setImageUrl(String imageUrl) {
      this.image = imageUrl;
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

   public int getServings() {
      return servings;
   }

   public void setServings(int servings) {
      this.servings = servings;
   }

   public int getReadyInMinutes() {
      return readyInMinutes;
   }

   public void setReadyInMinutes(int readyInMinutes) {
      this.readyInMinutes = readyInMinutes;
   }

   public String getSpoonacularSourceUrl() {
      return spoonacularSourceUrl;
   }

   public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
      this.spoonacularSourceUrl = spoonacularSourceUrl;
   }

   public List<String> getDishTypes() {
      return dishTypes;
   }

   public void setDishTypes(List<String> dishTypes) {
      this.dishTypes = dishTypes;
   }

   public List<Ingredient> getExtendedIngredients() {
      return extendedIngredients;
   }

   public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
      this.extendedIngredients = extendedIngredients;
   }

   private Recipe(Parcel in){
      this.id = in.readInt();
      this.title = in.readString();
      this.image = in.readString();
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
      parcel.writeString(image);
      parcel.writeInt(servings);
      parcel.writeInt(readyInMinutes);
      parcel.writeString(spoonacularSourceUrl);
      parcel.writeList(dishTypes);
      parcel.writeList(extendedIngredients);
   }

   @Override
   public boolean equals(@Nullable Object obj) {
      if(this == obj) return true;
      if(obj == null || getClass() != obj.getClass()) return false;

      Recipe comparedRecipe = (Recipe) obj;

      return title.equals(comparedRecipe.getTitle()) &&
              image.equals(comparedRecipe.getImageUrl()) &&
              extendedIngredients.equals(comparedRecipe.getExtendedIngredients()) &&
              servings == comparedRecipe.getServings() &&
              readyInMinutes == comparedRecipe.getReadyInMinutes() &&
              dishTypes.equals(comparedRecipe.getDishTypes());
   }
}


