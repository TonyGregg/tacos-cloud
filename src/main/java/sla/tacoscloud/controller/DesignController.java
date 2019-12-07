package sla.tacoscloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sla.tacoscloud.data.Ingredient;
import sla.tacoscloud.data.Ingredient.Type;
import sla.tacoscloud.data.IngredientRepository;
import sla.tacoscloud.data.Taco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil Gregory on 11/28/2019 5:20 PM
 * For project : tacos-cloud
 **/
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("Order")
public class DesignController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/custom")
    public String showDesignForm(Model model) {

        log.info("Inside showDesign form method ");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        Type[] types = Type.values();
        for ( Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
    }
}
