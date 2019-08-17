package gk.gk.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("orders")
@SessionAttributes("order")
public class OrderController {
    @Autowired
    private TacoRepository tacoRepository;

    @ModelAttribute("order")
    Order order(){
        return new Order();
    }


    @GetMapping("/current")
    public String Procee(){
        return "orderform";
    }

    @PostMapping
    public String ProcessOrder(@Valid @ModelAttribute("order") Order order, Errors errors, Model model){

        return "redirect:/design";
    }
}
