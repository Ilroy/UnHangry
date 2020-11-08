package com.example.hunger.api;

import com.example.hunger.models.Recipe;

import java.util.List;

public class SpoonacularResponse {
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
