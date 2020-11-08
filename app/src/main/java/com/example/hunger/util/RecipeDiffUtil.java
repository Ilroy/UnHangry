package com.example.hunger.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.hunger.models.Recipe;

public class RecipeDiffUtil extends DiffUtil.ItemCallback<Recipe>{

    @Override
    public boolean areItemsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {

        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
        return oldItem.equals(newItem);
    }
}
