package com.example.hunger.ui.recipe_gallery;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hunger.R;
import com.example.hunger.databinding.RecipeItemPhotoBinding;
import com.example.hunger.models.Recipe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

public class RecipeGalleryAdapter extends RecyclerView.Adapter<RecipeGalleryAdapter.RecipeViewHolder> {
    List<Recipe> recipes;

    public RecipeGalleryAdapter(List<Recipe> recipes){
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeViewHolder(RecipeItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent
                , false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);

        if(currentRecipe != null){
            holder.bind(currentRecipe);
        }

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        private RecipeItemPhotoBinding binding;
        public RecipeViewHolder(RecipeItemPhotoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Recipe recipe){
            Picasso.with(binding.getRoot().getContext())
                    .load(recipe.getImageUrl())
                    .centerCrop()
                    .error(R.drawable.ic_baseline_cancel_24)
                    .into(binding.itemImage);

            binding.itemName.setText(recipe.getTitle());

        }
    }
}
