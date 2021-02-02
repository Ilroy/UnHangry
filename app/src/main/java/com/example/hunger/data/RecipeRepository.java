package com.example.hunger.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hunger.api.SpoonacularApi;
import com.example.hunger.api.SpoonacularResponse;
import com.example.hunger.models.Recipe;
import com.example.hunger.util.SpoonacularConstants;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class RecipeRepository {
    private SpoonacularApi spoonacularApi;

    @Inject
    public RecipeRepository(SpoonacularApi spoonacularApi){
        this.spoonacularApi = spoonacularApi;
    }

    public LiveData<List<Recipe>> getRandomRecipes(){
        MutableLiveData<List<Recipe>> randomRecipes = new MutableLiveData<>();
        spoonacularApi.getRandomRecipes(SpoonacularConstants.MAX_RANDOM_RECIPES)
                .enqueue(new Callback<SpoonacularResponse>() {
            @Override
            public void onResponse(Call<SpoonacularResponse> call, Response<SpoonacularResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    randomRecipes.setValue(response.body().getRecipes());
                }
            }

            @Override
            public void onFailure(Call<SpoonacularResponse> call, Throwable t) {
            }
        });

        return randomRecipes;
    }

    public LiveData<List<Recipe>> getQueryRecipes(String query){
        Log.d("SEARCH", "getQueryRecipes: in repo query recipe");
        MutableLiveData<List<Recipe>> searchedRecipes = new MutableLiveData<>();
        spoonacularApi.getRecipesByIngredients(query,SpoonacularConstants.MAX_SEARCHED_RECIPES)
                .enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful() && response.body() != null){
                    searchedRecipes.setValue(response.body());
                    Log.d("SEARCH", "onResponse: "+response.body().size());
                }

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d("SEARCH", "onFailure: failed");

            }
        });
        return searchedRecipes;
    }

}
