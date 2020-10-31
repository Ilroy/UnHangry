package com.example.hunger.api;

import com.example.hunger.models.Recipe;
import com.example.hunger.util.SpoonacularConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SpoonacularApi {

    @Headers({
            SpoonacularConstants.API_HOST+": "+SpoonacularConstants.API_HOST_VALUE
            ,SpoonacularConstants.API_KEY+": "+SpoonacularConstants.API_KEY_VALUE})
    @GET("recipes/random")
    Call<List<Recipe>> getRandomRecipes(@Query("number") int numOfRecipes);

    @GET("recipes/findByIngredients")
    Call<List<Recipe>> getRecipesByIngredients(
            @Query("ingredients") String ingredients
            , @Query("number") int numOfRecipes);
}
