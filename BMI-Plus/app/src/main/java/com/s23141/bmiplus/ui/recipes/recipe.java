package com.s23141.bmiplus.ui.recipes;

public class recipe {
    public recipe(String name, String description,String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
    }

    public String name;
    public String description;
    public String ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
