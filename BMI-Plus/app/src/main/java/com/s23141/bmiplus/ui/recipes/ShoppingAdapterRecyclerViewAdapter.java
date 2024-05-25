package com.s23141.bmiplus.ui.recipes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.s23141.bmiplus.databinding.FragmentShoppingItemBinding;

import java.util.List;


public class ShoppingAdapterRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingAdapterRecyclerViewAdapter.ViewHolder> {

    private final List<String> mIngredients;



    public ShoppingAdapterRecyclerViewAdapter(List<String> ingredients) {
        mIngredients = ingredients;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentShoppingItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String ingredient = mIngredients.get(position);
        holder.mIngredients.setText(ingredient);
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }
    public void setIngredients(List<String> ingredients) {
        mIngredients.clear();
        mIngredients.addAll(ingredients);
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIngredients;

        public ViewHolder(FragmentShoppingItemBinding binding) {
            super(binding.getRoot());
            mIngredients = binding.shoppingItemName;
        }
    }

}
