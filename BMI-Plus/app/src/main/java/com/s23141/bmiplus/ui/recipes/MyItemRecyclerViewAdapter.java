package com.s23141.bmiplus.ui.recipes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s23141.bmiplus.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<recipe> mValues;
    private final AddIngredientsListener addIngredientsListener;

    public MyItemRecyclerViewAdapter(ArrayList<recipe> items, AddIngredientsListener listener) {
        mValues = items;
        this.addIngredientsListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDescriptionView.setText(mValues.get(position).description);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mIngredientsView.setText(mValues.get(position).ingredients);
        holder.mAddButton.setOnClickListener(v -> {
            recipe selectedRecipe = mValues.get(position);
            List<String> ingredientsList = Arrays.asList(selectedRecipe.ingredients.split("\\r?\\n"));
            addIngredientsListener.onAddIngredients(ingredientsList);
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
        public final Button mAddButton;
        public recipe mItem;

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

    public interface AddIngredientsListener {
        void onAddIngredients(List<String> ingredients);
    }
}
