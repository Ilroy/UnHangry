package com.example.hunger.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hunger.api.SpoonacularApi;
import com.example.hunger.api.SpoonacularResponse;
import com.example.hunger.models.Recipe;
import com.example.hunger.util.SpoonacularConstants;

import java.util.ArrayList;
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
        randomRecipes.setValue(new ArrayList<>());
        spoonacularApi.getRandomRecipes(SpoonacularConstants.MAX_RANDOM_RECIPES).enqueue(new Callback<SpoonacularResponse>() {
            @Override
            public void onResponse(Call<SpoonacularResponse> call, Response<SpoonacularResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    randomRecipes.setValue(response.body().getRecipes());
                }
            }

            @Override
            public void onFailure(Call<SpoonacularResponse> call, Throwable t) {
                // NOTIFY VIEW OF ERROR
                randomRecipes.setValue(null);


            }
        });

        return randomRecipes;
    }

}
