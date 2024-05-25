package com.s23141.bmiplus.ui.recipes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.s23141.bmiplus.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<recipe> mValues;

    public MyItemRecyclerViewAdapter(ArrayList<recipe> items) {
        mValues = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDescriptionView.setText(mValues.get(position).description);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mIngredientsView.setText(mValues.get(position).ingredients);
        holder.mAddButton.setTag(position);
        holder.mAddButton.setOnClickListener(v -> {
            int pos = (int) v.getTag();
            recipe selectedRecipe = mValues.get(pos);

            List<String> ingredientsList = Arrays.asList(selectedRecipe.ingredients.split("\\r?\\n"));
            RecyclerView recyclerView = (RecyclerView) v.getParent();
            recyclerView.setAdapter(new ShoppingAdapterRecyclerViewAdapter(ingredientsList));
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mNameView;
        public final TextView mIngredientsView;
        public final TextView mDescriptionView;
        public recipe mItem;
        public final Button mAddButton;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mNameView = binding.name;
            mIngredientsView = binding.ingredientsall;
            mDescriptionView = binding.recipedescription;
            mAddButton = binding.addIngredientButton;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }

}