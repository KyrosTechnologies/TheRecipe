package com.kyrostechnologies.template.recipe.model;

import java.io.Serializable;

public class Category implements Serializable {
    long id;
    String name;
    int photo;
    int icon;
    int recipes;

    public Category(long id, String name, int photo, int icon, int recipes) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.icon = icon;
        this.recipes = recipes;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public int getIcon() {
        return icon;
    }

    public int getRecipes() {
        return recipes;
    }
}
