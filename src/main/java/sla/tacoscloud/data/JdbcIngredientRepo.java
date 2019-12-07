package sla.tacoscloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Antony Genil Gregory on 12/2/2019 6:42 AM
 * For project : tacos-cloud
 **/
@Repository
public class JdbcIngredientRepo  implements IngredientRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient where id=?", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(int id) {
        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredeient (id, name, type) values (?,?,?)", ingredient.getId(),
                ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(resultSet.getString(1), // id
                resultSet.getString(2), // name
                Ingredient.Type.valueOf(resultSet.getString(3))); // Type
    }
}
