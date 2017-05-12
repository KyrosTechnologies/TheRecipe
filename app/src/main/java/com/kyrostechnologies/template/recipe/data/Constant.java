package com.kyrostechnologies.template.recipe.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.kyrostechnologies.template.recipe.R;
import com.kyrostechnologies.template.recipe.model.Category;
import com.kyrostechnologies.template.recipe.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ResourceType")
public class Constant {
    private static Random rnd = new Random();

    public static List<Category> getItemCategory(Context ctx) {
        List<Category> items = new ArrayList<>();
        TypedArray img_cat = ctx.getResources().obtainTypedArray(R.array.category_photos);
        TypedArray ic_cat = ctx.getResources().obtainTypedArray(R.array.category_icon);
        String[] name_cat = ctx.getResources().getStringArray(R.array.category_names);
        for (int i = 0; i < img_cat.length(); i++) {
            Category item = new Category(Long.parseLong("0" + i), name_cat[i], img_cat.getResourceId(i, -1), ic_cat.getResourceId(i, -1), 5);
            items.add(item);
        }
        return items;
    }

    public static List<Recipe> getItemAppertize(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_appetizers);
        String[] name_ = ctx.getResources().getStringArray(R.array.appetizers_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.appetizers_duration);
        Category category = getItemCategory(ctx).get(0);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("1" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemAppertizeRandom(Context ctx){
        List<Recipe> items = getItemAppertize(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }


    public static List<Recipe> getItemMainDish(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_main_dish);
        String[] name_ = ctx.getResources().getStringArray(R.array.main_dish_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.main_dish_duration);
        Category category = getItemCategory(ctx).get(1);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("2" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemMainDishRandom(Context ctx){
        List<Recipe> items = getItemMainDish(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemSalads(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_salads);
        String[] name_ = ctx.getResources().getStringArray(R.array.salads_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.salads_duration);
        Category category = getItemCategory(ctx).get(2);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("3" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemSaladsRandom(Context ctx){
        List<Recipe> items = getItemSalads(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemDrinks(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_drinks);
        String[] name_ = ctx.getResources().getStringArray(R.array.drinks_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.drinks_duration);
        Category category = getItemCategory(ctx).get(3);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("4" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemDrinksRandom(Context ctx){
        List<Recipe> items = getItemDrinks(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemSideDish(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_side_dish);
        String[] name_ = ctx.getResources().getStringArray(R.array.side_dish_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.side_dish_duration);
        Category category = getItemCategory(ctx).get(4);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("5" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemSideDishRandom(Context ctx){
        List<Recipe> items = getItemSideDish(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemDessert(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        TypedArray img_ = ctx.getResources().obtainTypedArray(R.array.photos_dessert);
        String[] name_ = ctx.getResources().getStringArray(R.array.dessert_names);
        String[] duration_ = ctx.getResources().getStringArray(R.array.dessert_duration);
        Category category = getItemCategory(ctx).get(5);
        for (int i = 0; i < img_.length() ; i++) {
            Recipe item = new Recipe(Long.parseLong("6" + i), name_[i], img_.getResourceId(i, -1), duration_[i], category);
            items.add(item);
        }
        return items;
    }
    public static List<Recipe> getItemDessertRandom(Context ctx){
        List<Recipe> items = getItemDessert(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemAll(Context ctx) {
        List<Recipe> items = new ArrayList<>();
        items.addAll(getItemAppertize(ctx));
        items.addAll(getItemMainDish(ctx));
        items.addAll(getItemSalads(ctx));
        items.addAll(getItemDrinks(ctx));
        items.addAll(getItemSideDish(ctx));
        items.addAll(getItemDessert(ctx));
        Collections.shuffle(items, rnd);
        return items;
    }
    public static List<Recipe> getItemAllRandom(Context ctx){
        List<Recipe> items = getItemAll(ctx);
        Collections.shuffle(items, rnd);
        return items;
    }

    public static List<Recipe> getItemFavorites(Context ctx){
        List<Recipe> items_all = getItemAll(ctx);
        List<Recipe> items_fav = new ArrayList<>();
        List<String> items_id = Utils.getFavorites(ctx);
        for (int i = 0; i < items_all.size(); i++) {
            if(items_id.contains(items_all.get(i).getId()+"")){
                items_fav.add(items_all.get(i));
            }
        }
        return items_fav;
    }

}
