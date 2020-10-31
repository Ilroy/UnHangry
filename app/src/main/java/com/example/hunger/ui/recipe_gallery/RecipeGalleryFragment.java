package com.example.hunger.ui.recipe_gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hunger.databinding.FragmentRecipeGalleryBinding;

public class RecipeGalleryFragment extends Fragment {
    private FragmentRecipeGalleryBinding recipeGalleryBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recipeGalleryBinding = FragmentRecipeGalleryBinding.inflate(inflater,container,false);
        return recipeGalleryBinding.getRoot();
    }
}
