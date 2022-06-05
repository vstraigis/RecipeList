package GUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeList {

    private static final Map<Integer, Recipe> recipesMap = new HashMap<Integer, Recipe>();

    public static Recipe getRecipe(Integer recipeId) {
        return recipesMap.get(recipeId);
    }

    public static Recipe addRecipe(Recipe recipe) {
        recipesMap.put(recipe.getId(), recipe);
        //recipesMap.put(recipe.getId().toString(), recipe);
        return recipe;
    }

    public static Recipe updateRecipe(Recipe recipe) {
        recipesMap.put(recipe.getId(), recipe);
        //recipesMap.put(recipe.getId().toString(), recipe);
        return recipe;
    }

    public static void deleteRecipe(String recipeId) {
        recipesMap.remove(recipeId);
    }

    public static List<Recipe> getAllRecipes() {
        Collection<Recipe> values = recipesMap.values();
        List<Recipe> list = new ArrayList<Recipe>();
        list.addAll(values);
        return list;
    }
}