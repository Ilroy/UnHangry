package com.example.hunger.data;

import android.util.Log;

import androidx.annotation.NonNull;

import androidx.paging.PositionalDataSource;


import com.example.hunger.api.SpoonacularApi;
import com.example.hunger.models.Recipe;
import com.example.hunger.util.SpoonacularConstants;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class RandomRecipePagingSource extends PositionalDataSource<Recipe> {

    private SpoonacularApi spoonacularApi;

    public RandomRecipePagingSource(SpoonacularApi spoonacularApi){
        super();
        this.spoonacularApi = spoonacularApi;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Recipe> callback) {
        try{
            spoonacularApi
                    .getRandomRecipes(SpoonacularConstants.MAX_RANDOM_RECIPES)
                    .enqueue(new Callback<List<Recipe>>() {
                        @Override
                        public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                            if(response.isSuccessful()) {
                                List<Recipe> recipes = response.body();
                                int totalRecipes = (recipes == null) ? 0 : recipes.size();

                                if(recipes != null) callback
                                        .onResult(recipes
                                                , SpoonacularConstants.SPOONACULAR_STARTING_INDEX
                                                , totalRecipes);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Recipe>> call, Throwable t) {
                            Log.d("PAGING_DATA", "onFailure: CALL TO API FAILED");
                        }
                    });
        }
        catch (HttpException exception){
            throw exception;
        }
        catch (IOException exception){
            throw exception;
        }
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Recipe> callback) {
        try{

        }

    }
}



