package GUI;

import java.util.ArrayList;

public class Recipe {
    private int id;
    private String name;
    private static int count = 0;
    private ArrayList<String> ingredients;
    private String comments;

    public Recipe() {

    }

    public Recipe(String name, ArrayList<String> ingredients, String comments) {
        this.name = name;
        this.ingredients = ingredients;
        this.comments = comments;
        setId(++count);
    }

    public int getId() {
        return id;
    }

    public Recipe setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public Recipe setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", comments=" + comments +
                '}';
    }
}