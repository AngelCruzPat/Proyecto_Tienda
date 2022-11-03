package com.proyecto.service;


import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.model.Productos;

@Service
public class ProductosServiceImpl implements IProductosService{

	@Override
	public List<Productos> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductosServiceImpl(){
		List<Productos> lista = new LinkedList<Productos>();
		Productos producto1 = new Productos();
		producto1.setId(1);
		producto1.setNombre("Chamarra");
		producto1.setDescripcion("Chamarra de piel de dinasaurio con partes humanas");
		producto1.setImagen("no-imagen.png");
		producto1.setPrecio(150.0);
		
		Productos producto2 = new Productos();
		producto2.setId(2);
		producto2.setNombre("Gorra");
		producto2.setDescripcion("Gorra de 1000 hilos de pelo de leon");
		producto2.setImagen("no-imagen.png");
		producto2.setPrecio(150.0);
		
		Productos producto3 = new Productos();
		producto3.setId(3);
		producto3.setNombre("Peluca");
		producto3.setDescripcion("Peluca de borregin, importados de benjaLandia");
		producto3.setImagen("no-imagen.png");
		producto3.setPrecio(4000.0);
		
		Productos producto4 =new Productos();
		producto4.setId(4);
		producto4.setNombre("Calcetas");
		producto4.setDescripcion("Calcetas para las patas");
		producto4.setImagen("no-imagen.png");
		producto4.setPrecio(25.0);
		
		Productos producto5 =new Productos();
		producto5.setId(5);
		producto5.setNombre("Calcetas");
		producto5.setDescripcion("Calcetas para las patas");
		producto5.setImagen("no-imagen.png");
		producto5.setPrecio(25.0);
		
		Productos producto6 =new Productos();
		producto6.setId(6);
		producto6.setNombre("Cubrebocas");
		producto6.setDescripcion("Cubrecobas con sabor a fresas");
		producto6.setImagen("no-imagen.png");
		producto6.setPrecio(70.0);
		
		Productos producto7 =new Productos();
		producto7.setId(7);
		producto7.setNombre("aretes");
		producto7.setDescripcion("aretes de mango con chile");
		producto7.setImagen("no-imagen.png");
		producto7.setPrecio(0.0);
		
		Productos producto8 =new Productos();
		producto8.setId(8);
		producto8.setNombre("anillos");
		producto8.setDescripcion("anillos normales");
		producto8.setImagen("no-imagen.png");
		producto8.setPrecio(40.0);
		
		Productos producto9 =new Productos();
		producto9.setId(9);
		producto9.setNombre("gorro");
		producto9.setDescripcion("esta hechos de piel de gallina de australia");
		producto9.setImagen("no-imagen.png");
		producto9.setPrecio(7000.0);
		
		
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
		
	}
/*
 
	private List<Productos> productos = null;
	
	public ProductosServiceImpl() {
			productos = new LinkedList<Productos>();
	try {
		Productos producto1 = new Productos();
		producto1.setId(1);
		producto1.setNombre("Streamer");
		
		
		productos.add(producto1);
		
	}
}
	
	@Override
	public List<Productos> buscarTodas() {
		return productos;
	}

	@Override
	public Productos buscarPorid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

*/

	@Override
	public void guardar(Productos producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Productos> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Productos> buscarByExample(Example<Productos> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Productos> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productos buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
