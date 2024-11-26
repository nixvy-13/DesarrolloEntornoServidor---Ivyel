package com.example.saludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Formulario {
@GetMapping("/")
String inicio(@RequestParam(name="errMsg", required=false) String errMsg, Model modelo) {
	modelo.addAttribute("errMsg", errMsg);
	return "form";
}
@PostMapping("/saludo")
public String procesaForm(@RequestParam(name="nombre", required=false) String nombre, Model modelo) {
	if(nombre==null||nombre.isBlank()) {
		modelo.addAttribute("errMsg", "El nombre no puede estar vacio");
		//return "redirect:/?errMsg=\"El nombre no puede estar vacio\"";
		return "form";
	}else {
	modelo.addAttribute("nombre", nombre);
	return  "saludo";}
}
}
