package sla.tacoscloud.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Antony Genil Gregory on 11/28/2019 5:04 PM
 * For project : tacos-cloud
 **/

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static  enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE, SOUR;
    }
}
