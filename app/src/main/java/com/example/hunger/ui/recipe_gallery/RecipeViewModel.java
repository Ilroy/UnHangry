package com.example.hunger.ui.recipe_gallery;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hunger.data.RecipeRepository;
import com.example.hunger.models.Recipe;

import java.util.List;

public class RecipeViewModel extends ViewModel {
    private RecipeRepository recipeRepository;
    private MutableLiveData<List<Recipe>> recipes;

    @ViewModelInject
    public RecipeViewModel(RecipeRepository recipeRepository){
        super();
        this.recipeRepository = recipeRepository;
    }

    public LiveData<List<Recipe>> getRandomRecipes(){
        if (recipes== null){
            recipes = new MutableLiveData<>();
            recipes = (MutableLiveData<List<Recipe>>) recipeRepository.getRandomRecipes();
        }
        return recipes;
    }

}
