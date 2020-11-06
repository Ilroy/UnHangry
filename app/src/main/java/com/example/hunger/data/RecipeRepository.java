package com.example.hunger.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hunger.api.SpoonacularApi;
import com.example.hunger.models.Recipe;

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
        spoonacularApi.getRandomRecipes().enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful()){
                    randomRecipes.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

            }
        });

        return randomRecipes;
    }

//    public LiveData<List<Recipe>> getRecpeSearchResults(String query){
//
//    }


}
