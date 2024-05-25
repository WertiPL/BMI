package com.s23141.bmiplus.ui.recipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s23141.bmiplus.databinding.FragmentShoppingItemBinding;

import java.util.List;

public class ShoppingAdapterRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingAdapterRecyclerViewAdapter.ViewHolder> {

    private final List<String> mIngredients;

    public ShoppingAdapterRecyclerViewAdapter(List<String> ingredients) {
        mIngredients = ingredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentShoppingItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        String ingredient = mIngredients.get(position);
        holder.mIngredients.setText(ingredient);

        holder.mDeleteButton.setOnClickListener(v -> {
            int adapterPosition = holder.getAdapterPosition();
            mIngredients.remove(adapterPosition);
            notifyItemRemoved(adapterPosition);
            notifyItemRangeChanged(adapterPosition, mIngredients.size());
        });
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIngredients;
        public final ImageView mDeleteButton;

        public ViewHolder(FragmentShoppingItemBinding binding) {
            super(binding.getRoot());
            mIngredients = binding.shoppingItemName;
            mDeleteButton = binding.shoppingItemDelete;
        }
    }
}
