package com.example.hunger.ui.recipe_gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hunger.R;
import com.example.hunger.databinding.FragmentRecipeGalleryBinding;
import com.example.hunger.models.Recipe;


import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RecipeGalleryFragment extends Fragment {

    private RecipeViewModel recipeVm;
    private RecipeGalleryAdapter adapter;

    private FragmentRecipeGalleryBinding recipeGalleryBinding =  null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipeGalleryBinding = FragmentRecipeGalleryBinding.bind(view);
        recipeVm = new ViewModelProvider(this).get(RecipeViewModel.class);

        RecyclerView recyclerView = recipeGalleryBinding.galleryRecycleView;
        adapter = new RecipeGalleryAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        //LiveData<List<Recipe>> randomRecipes = recipeVm.getRandomRecipes();
        recipeVm.getRandomRecipes().observe(getViewLifecycleOwner(), recipes -> adapter.submitList(recipes));
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recipeGalleryBinding = FragmentRecipeGalleryBinding.inflate(inflater,container,false);

        return recipeGalleryBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.gallery_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.gallery_menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) {
                    Log.d("SEARCH_SUBMIT", "onQueryTextSubmit: "+query);
                    recipeGalleryBinding.galleryRecycleView.scrollToPosition(0);
                    recipeVm.getQueryRecipes(query)
                            .observe(getViewLifecycleOwner()
                                    , recipes -> adapter.submitList(recipes));
                    searchView.clearFocus();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("SEARCH_CHANGE", "onQueryTextChange: "+newText);
                return true;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recipeGalleryBinding = null;
    }
}
