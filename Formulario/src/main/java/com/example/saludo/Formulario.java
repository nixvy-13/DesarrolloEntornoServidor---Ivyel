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
@PostMapping("/imc")
public String procesaForm(@RequestParam(name="altura", required=false) double altura,
												@RequestParam(name="peso", required=false) double peso,
												Model modelo) {
	if((altura<=0||altura>250)||(peso<=0||peso>=100)) {
		modelo.addAttribute("errMsg", "El nombre no puede estar vacio");
		//return "redirect:/?errMsg=\"El nombre no puede estar vacio\"";
		return "form";
	}else {
	String imc = "";
	double alt1 = (altura%100);
	double alt_fin = alt1*alt1;
	if(peso/alt_fin < 18.5) {
		imc = "Bajo";
	}else if(peso/alt_fin >=18.5 && peso/alt_fin < 25) {
		imc = "Normal";
	}else if(peso/alt_fin>=25&&peso/alt_fin<=30) {
		imc = "Sobrepeso";
	}else {
		imc = "Obeso";
	}
	modelo.addAttribute("imc", imc);
	return  "imc";}
}
}
