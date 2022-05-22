import java.util.ArrayList;

public class Recipe {
    private int id;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> comments;

    public Recipe(String name, ArrayList<Ingredient> ingredients, ArrayList<String> comments) {
        this.name = name;
        this.ingredients = ingredients;
        this.comments = comments;
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

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public Recipe setComments(ArrayList<String> comments) {
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
