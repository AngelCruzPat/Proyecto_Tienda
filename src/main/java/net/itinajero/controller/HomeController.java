package net.itinajero.controller;


import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.itinajero.model.Productos;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String MostrarHome() {
		return "/index";
	}
	@GetMapping("/detalles")
	public String MostrarDetalles(Model model) {
		Productos producto = new Productos();
		producto.setNombre("Chamarra");
		producto.setImagen("no-imagen.png");
		producto.setPrecio("150");
		producto.setOferta("25%");
		return "/detalles";
	}
	@GetMapping("/formulario")
	public String MostrarFormulario() {
		return "/formulario";
	}
	@GetMapping("/productos")
	public String MostrarProductos(Model model) {
		List<Productos> lista = getProductos();
		model.addAttribute("productos_", lista);
		
		return "/productos";
	}
	
	private List<Productos> getProductos(){
		List<Productos> lista = new LinkedList<Productos>();
		Productos producto1 = new Productos();
		producto1.setId(1);
		producto1.setNombre("Chamarra");
		producto1.setDescripcion("Chamarra de piel de dinasaurio con partes humanas");
		producto1.setImagen("no-imagen.png");
		producto1.setPrecio("150");
		producto1.setOferta("25%");
		
		Productos producto2 = new Productos();
		producto2.setId(2);
		producto2.setNombre("Gorra");
		producto2.setDescripcion("Gorra de 1000 hilos de pelo de leon");
		producto2.setImagen("no-imagen.png");
		producto2.setPrecio("300");
		producto2.setOferta("ninguna");
		
		
		lista.add(producto1);
		lista.add(producto2);
		return lista;
		
	}
	
	
	@GetMapping("/base")
	public String MostrarBase() {
		return "/base";
	}
}
