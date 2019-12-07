package sla.tacoscloud.data;

/**
 * Created by Antony Genil Gregory on 12/2/2019 6:36 AM
 * For project : tacos-cloud
 **/
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(int id);
    Ingredient save(Ingredient ingredient);
}
