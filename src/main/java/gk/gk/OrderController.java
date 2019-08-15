package gk.gk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {
    @GetMapping("current")
    public String OrderForm(Model model){
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String ProcessForm(@Valid Order order, Errors errors){
        if(errors.hasErrors()){
            return "orderForm";
        }
        return "redirect:/";
    }
}
