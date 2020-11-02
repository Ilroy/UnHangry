package com.example.hunger.data;

import com.example.hunger.api.SpoonacularApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RecipeRepository {
    private SpoonacularApi spoonacularApi;

    @Inject
    public RecipeRepository(SpoonacularApi spoonacularApi){
        this.spoonacularApi = spoonacularApi;
    }
}
