package com.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.model.Productos;
import com.proyecto.service.ICategoriasService;
import com.proyecto.service.IProductosService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	
	@Autowired
	private IProductosService serviceProductos;
	
	@Autowired
	//@Qualifier("categoriasServiceJpa")
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, Model model) {
		System.out.println("Borrando vacante con ID: " + id);
		model.addAttribute("id", id);	
		
		return "mensaje";
	}

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Productos> lista = serviceProductos.buscarTodas();
    	model.addAttribute("productos", lista);
		return "productos/listProductos";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Productos> lista = serviceProductos.buscarTodas(page);
	model.addAttribute("productos", lista);
	return "productos/listProductos";
	}
	
	@GetMapping("/create")
	public String crear(Productos productos, Model model) {
		return "productos/formProductos";
	}
	
	
	
	
	
	@PostMapping("/save")
	public String guardar(Productos productos, BindingResult result, RedirectAttributes attributes, 
			@RequestParam("archivoImagen") MultipartFile multiPart ) {
		
		if (result.hasErrors()) {
			
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}
			
			return "productos/formProductos";
			}
		
		
		
		//if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
	//	String  ruta = "c:/empleos/img-vacantes/"; // windows
			//String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			//if(nombreImagen != null) {// la imagen si se subio
				//Procesamos la variable nombreImagen
				//vacante.setImagen(nombreImagen);
			//}
		//}
		
		
		
		
		serviceProductos.guardar(productos);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Productos: " + productos);
		return "redirect:/productos/index"; 
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") int idProducto, RedirectAttributes attributes) {
		System.out.println("Borrando producto con id: " +idProducto );
		serviceProductos.eliminar(idProducto);
		attributes.addFlashAttribute("msg", "El producto fue eliminado!");
		return "redirect:/productos/index";
		
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idProductos, Model model) {
		Productos productos = serviceProductos.buscarPorId(idProductos);
		model.addAttribute("productos", productos);
		
		return "productos/formProductos";
	}
	
	
	
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idProducto, Model model) {
		
		Productos productos =serviceProductos.buscarPorId(idProducto);
		
		System.out.println("Productos:" + productos);
		model.addAttribute("Producto", productos);
		
		//buscar los detalles de vacante id
		
		return "detalle";
		
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas() );	
	}

	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
