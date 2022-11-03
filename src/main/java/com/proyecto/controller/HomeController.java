package com.proyecto.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.model.Perfil;
import com.proyecto.model.Productos;
import com.proyecto.model.Usuario;
import com.proyecto.service.ICategoriasService;
import com.proyecto.service.IProductosService;
import com.proyecto.service.IUsuariosService;

@Controller
public class HomeController {
	

	@Autowired
   	private IUsuariosService serviceUsuarios;

	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private IProductosService serviceProductos;

	
	@GetMapping("/")
	public String MostrarHome() {
		return "/index";
	}
	@GetMapping("/detalles")
	public String MostrarDetalles(Model model) {
		Productos producto = new Productos();
		producto.setNombre("Chamarra");
		producto.setImagen("no-imagen.png");
		producto.setPrecio(150.0);
		return "/detalles";
	}
	@GetMapping("/formulario")
	public String MostrarFormulario() {
		return "/formulario";
	}
	@GetMapping("/productos")
	public String MostrarProductos(Model model) {
		List<Productos> lista = serviceProductos.buscarTodas();
		model.addAttribute("productos", lista);
		
		return "/productos";
	}

	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}

	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		
		String pwdPlano = usuario.getPassword();
		String  pwdEncriptado = passwordEncoder.encode(pwdPlano);
		usuario.setPassword(pwdEncriptado);
		
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor
		
		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);
		
		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		serviceUsuarios.guardar(usuario);
				
		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
		
		return "redirect:/usuarios/index";
	}
	
	
	@GetMapping("/base")
	public String MostrarBase() {
		return "/base";
	}
	
	
}
