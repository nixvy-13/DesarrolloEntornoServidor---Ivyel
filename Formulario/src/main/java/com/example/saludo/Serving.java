package com.example.saludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Serving {
	
	@GetMapping("/inicial")
	public String inicial(@RequestParam(name="nombre", required=false, defaultValue="persona misteriosa") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		return "inicial";
	}
}
