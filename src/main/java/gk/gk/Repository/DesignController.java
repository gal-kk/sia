package gk.gk.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("design")
@SessionAttributes("order")
public class DesignController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TacoRepository tacoRepository;

    @Autowired
    private OrderRepository orderRepository;

    @ModelAttribute("design")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String ProcessGet(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filteredByType(type, ingredients));
        }
        return "design";
    }

    @PostMapping
    public String ProcessForm(@Valid @ModelAttribute("design") Taco taco, Errors errors, Order order){
        if(errors.hasErrors()){
            return "design";
        }
        tacoRepository.save(taco);
        order.addTaco(taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filteredByType(Ingredient.Type type, List<Ingredient> ingredients) {
        List<Ingredient> list = new ArrayList<>();
        for(Ingredient ingredient: ingredients){
            if (ingredient.getType().toString().equals(type.toString())){
                list.add(ingredient);
            }
        }
        return list;
    }
}
