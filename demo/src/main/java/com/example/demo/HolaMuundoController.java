package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMuundoController {
	AtomicInteger cuenta = new AtomicInteger(1);
	
	@PostMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello <b>%s<b>!", name);
      }
	@GetMapping("/hello")
    public String hola(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello <b>%s<b>!", name);
      }
	@GetMapping("/")
    public String contador() {
      return "" + cuenta.incrementAndGet();
      }
	
}
