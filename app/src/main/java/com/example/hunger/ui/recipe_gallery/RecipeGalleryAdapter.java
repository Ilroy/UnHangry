package com.example.hunger.ui.recipe_gallery;



import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hunger.R;
import com.example.hunger.databinding.RecipeItemPhotoBinding;
import com.example.hunger.models.Recipe;
import com.example.hunger.util.RecipeDiffUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;



public class RecipeGalleryAdapter extends ListAdapter<Recipe,RecipeGalleryAdapter.RecipeViewHolder> {

    protected RecipeGalleryAdapter() {
        super(new RecipeDiffUtil());
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
        Recipe currentRecipe = getItem(position);

        if(currentRecipe != null){
            holder.bind(currentRecipe);
        }

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
                    .fit()
                    .centerCrop()
                    .error(R.drawable.ic_baseline_cancel_24)
                    .into(binding.itemImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            binding.itemProgressBar.setVisibility(View.GONE);
                            binding.itemName.setText(recipe.getTitle());
                        }

                        @Override
                        public void onError() {
                            binding.itemProgressBar.setVisibility(View.GONE);

                        }
                    });



        }
    }
}
