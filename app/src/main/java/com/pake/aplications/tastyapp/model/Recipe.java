package com.pake.aplications.tastyapp.model;

public class Recipe {
    private String title, thumbnailUrl;
    private int recipe_id;
    private String recipe_description;

    public Recipe() {
    }

    public Recipe(String name, String thumbnailUrl, int recipe_id, String recipe_description) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.recipe_id = recipe_id;
        this.recipe_description = recipe_description;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setID(int recipe_id){
        this.recipe_id = recipe_id;
    }

    public void setDescription(String description){
        this.recipe_description = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public int getId() {
        return recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return recipe_description;
    }
}
