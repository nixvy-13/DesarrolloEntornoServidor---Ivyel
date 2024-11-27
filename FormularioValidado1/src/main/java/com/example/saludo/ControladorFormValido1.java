package com.example.saludo;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ControladorFormValido1 implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/resultados").setViewName("resultados");
	}

	@GetMapping("/")
	public String showForm(FormPersona formPersona) {
		return "formPersona";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid FormPersona formPersona, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "formPersona";
		}

		return "redirect:/resultados";
	}
}
