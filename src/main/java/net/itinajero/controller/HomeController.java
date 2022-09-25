package net.itinajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/detalles")
	public String MostrarDetalles() {
		return "/detalles";
	}
	@GetMapping("/formulario")
	public String MostrarFormulario() {
		return "/formulario";
	}
	@GetMapping("/productos")
	public String MostrarProductos() {
		return "/productos";
	}
}
