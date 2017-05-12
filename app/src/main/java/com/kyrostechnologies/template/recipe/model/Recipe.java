package com.kyrostechnologies.template.recipe.model;

import java.io.Serializable;

public class Recipe implements Serializable{
    long id;
    String name;
    int photo;
    String duration;
    Category category;

    public Recipe(long id, String name, int photo, String duration, Category category) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.duration = duration;
        this.category = category;
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

    public String getDuration() {
        return duration;
    }

    public Category getCategory() {
        return category;
    }
}
