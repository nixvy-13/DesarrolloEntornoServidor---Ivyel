package com.example.saludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SaludoController {
	
	
	public String saludo(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model modelo) {
		modelo.addAttribute("nombre", nombre);
		return "greeting";
	}
	
}
