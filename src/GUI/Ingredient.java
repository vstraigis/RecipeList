package GUI;

import java.util.ArrayList;

public class Ingredient {
    private int id;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> comments;

    public Ingredient() {
    }

    public Ingredient(String name, ArrayList<Ingredient> ingredients, ArrayList<String> comments) {
        this.name = name;
        this.ingredients = ingredients;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public Ingredient setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public Ingredient setComments(ArrayList<String> comments) {
        this.comments = comments;
        return this;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", comments=" + comments +
                '}';
    }
}