package com.example.hunger.ui.recipe_gallery;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import com.example.hunger.data.RecipeRepository;

public class RecipeViewModel extends ViewModel {
    private RecipeRepository recipeRepository;

    @ViewModelInject
    public RecipeViewModel(RecipeRepository recipeRepository){
        super();
        this.recipeRepository = recipeRepository;

    }
}
