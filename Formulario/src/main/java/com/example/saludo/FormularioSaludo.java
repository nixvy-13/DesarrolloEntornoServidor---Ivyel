package com.example.saludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioSaludo {
	@GetMapping("/saludo2")
	  public String saludo2Form(Model model) {
	    model.addAttribute("saludo", new Saludo());
	    return "saludo2";
	  }

	  @PostMapping("/saludo2")
	  public String saludo2Submit(@ModelAttribute Saludo saludo, Model model) {
	    model.addAttribute("saludo", saludo);
	    return "resultado";
	  }
}
