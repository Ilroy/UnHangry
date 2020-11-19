package com.example.hunger.api;

import com.example.hunger.models.Recipe;
import com.example.hunger.models.SearchRecipe;
import com.example.hunger.util.SpoonacularConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SpoonacularApi {

    @Headers({SpoonacularConstants.API_KEY+":"+SpoonacularConstants.API_KEY_VALUE})
    @GET("random")
    Call<SpoonacularResponse> getRandomRecipes(@Query("number") int numOfResults);

    @GET("findByIngredients")
    Call<List<SearchRecipe>> getRecipesByIngredients(
            @Query("ingredients") String ingredients
            , @Query("number") int numOfRecipes);
}
