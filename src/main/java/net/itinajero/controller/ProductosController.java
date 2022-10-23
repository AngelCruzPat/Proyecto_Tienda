package net.itinajero.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.model.Productos;
import net.itinajero.service.IProductosService;

@Controller
public class ProductosController {
	
	
	@Autowired
	private IProductosService serviceProductos;
		
	@GetMapping("/productos")
	public String mostrarIndex(Model model) {
		List<Productos> lista = serviceProductos.buscarTodas();
    	model.addAttribute("vacantes", lista);
		return "/productos/listProductos";
	}
	@GetMapping("/mensaje")
	public String eliminar(@RequestParam("id") int id, Model model) {
		System.out.println("Borrando vacante con ID: " + id);
		model.addAttribute("id", id);	
		
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		
		Productos producto = serviceProductos.buscarPorid(id);
		
		System.out.println("id " + producto);
		model.addAttribute("id", producto);
		
		// buscar detalles de la vacante en la base de datos.......................
		
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
