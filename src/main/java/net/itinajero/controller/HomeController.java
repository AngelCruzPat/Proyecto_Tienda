package net.itinajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String MostrarHome() {
		return "/index";
	}
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
	@GetMapping("/base")
	public String MostrarBase() {
		return "/base";
	}
}
