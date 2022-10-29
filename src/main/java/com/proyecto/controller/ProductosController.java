package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.model.Productos;
import com.proyecto.service.IProductosService;


public class ProductosController {
	@Autowired
	private IProductosService serviceProductos;
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, Model model) {
		System.out.println("Borrando vacante con ID: " + id);
		model.addAttribute("id", id);	
		
		return "mensaje";
	}

	@GetMapping("/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		
		Productos producto = serviceProductos.buscarPorid(id);
		
		System.out.println("id " + producto);
		model.addAttribute("id", producto);
		
		// buscar detalles de la vacante en la base de datos.......................
		
		return "detalle";
	}
}
