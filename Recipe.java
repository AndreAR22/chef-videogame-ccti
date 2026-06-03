import greenfoot.*;
import java.util.*;

public class Recipe
{
    public final String nombre;
    public final Map<IngredientType, Integer> ingredientes;

    public Recipe(String nombre, Map<IngredientType, Integer> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public int totalIngredientes() {
        int total = 0;
        for (int cant : ingredientes.values()) {
            total += cant;
        }
        return total;
    }

    public static Recipe hamburguesa() {
        Map<IngredientType, Integer> map = new HashMap<>();
        map.put(IngredientType.PAN, 3);
        map.put(IngredientType.CARNE, 2);
        map.put(IngredientType.LECHUGA, 2);
        map.put(IngredientType.TOMATE, 2);
        map.put(IngredientType.QUESO, 2);
        return new Recipe("Hamburguesa", map);
    }

    public static Recipe pizza() {
        Map<IngredientType, Integer> map = new HashMap<>();
        map.put(IngredientType.MASA, 2);
        map.put(IngredientType.SALSA, 2);
        map.put(IngredientType.QUESO, 3);
        map.put(IngredientType.PEPPERONI, 3);
        return new Recipe("Pizza", map);
    }

    public static Recipe taco() {
        Map<IngredientType, Integer> map = new HashMap<>();
        map.put(IngredientType.TORTILLA, 3);
        map.put(IngredientType.CARNE, 2);
        map.put(IngredientType.LECHUGA, 2);
        map.put(IngredientType.TOMATE, 2);
        map.put(IngredientType.SALSA, 1);
        return new Recipe("Taco", map);
    }

    public static Recipe[] todas() {
        return new Recipe[]{ hamburguesa(), pizza(), taco() };
    }
}
