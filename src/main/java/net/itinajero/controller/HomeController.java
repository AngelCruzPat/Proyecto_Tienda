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
		
		Productos producto3 = new Productos();
		producto3.setId(3);
		producto3.setNombre("Peluca");
		producto3.setDescripcion("Peluca de borregin, importados de benjaLandia");
		producto3.setImagen("no-imagen.png");
		producto3.setPrecio("4000");
		producto3.setOferta("ninguna");
		
		Productos producto4 =new Productos();
		producto4.setId(4);
		producto4.setNombre("Calcetas");
		producto4.setDescripcion("Calcetas para las patas");
		producto4.setImagen("no-imagen.png");
		producto4.setPrecio("25");
		producto4.setOferta("95%");
		
		Productos producto5 =new Productos();
		producto5.setId(5);
		producto5.setNombre("abrigo");
		producto5.setDescripcion("abrigo de cuello de jirafas");
		producto5.setImagen("no-imagen.png");
		producto5.setPrecio("250");
		producto5.setOferta("ninguna");
		
		Productos producto6 =new Productos();
		producto6.setId(6);
		producto6.setNombre("Cubrebocas");
		producto6.setDescripcion("Cubrecobas con sabor a fresas");
		producto6.setImagen("no-imagen.png");
		producto6.setPrecio("70");
		producto6.setOferta("ninguna");
		
		Productos producto7 =new Productos();
		producto7.setId(7);
		producto7.setNombre("aretes");
		producto7.setDescripcion("aretes de mango con chile");
		producto7.setImagen("no-imagen.png");
		producto7.setPrecio("GRATISSS");
		producto7.setOferta("100%");
		
		Productos producto8 =new Productos();
		producto8.setId(8);
		producto8.setNombre("anillos");
		producto8.setDescripcion("anillos normales");
		producto8.setImagen("no-imagen.png");
		producto8.setPrecio("40");
		producto8.setOferta("ninguna");
		
		Productos producto9 =new Productos();
		producto9.setId(9);
		producto9.setNombre("gorro");
		producto9.setDescripcion("esta hechos de piel de gallina de australia");
		producto9.setImagen("no-imagen.png");
		producto9.setPrecio("7000");
		producto9.setOferta("ningu");
		
		
		// se Agregaron  mas productos pq solo teniamos 2 att: javi
		//julia ayudo 
		
		
		
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		lista.add(producto4);
		lista.add(producto5);
		lista.add(producto6);
		lista.add(producto7);
		lista.add(producto8);
		lista.add(producto9);
		return lista;
		
	}
	
	
	@GetMapping("/base")
	public String MostrarBase() {
		return "/base";
	}
}
