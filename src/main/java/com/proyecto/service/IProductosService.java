package com.proyecto.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.model.Productos;

public interface IProductosService {
	List<Productos> buscarTodas();
	Productos buscarPorId(Integer id);
	void guardar(Productos producto);
	List<Productos> buscarDestacadas();
	void eliminar(Integer idProducto);
	List<Productos>buscarByExample(Example<Productos> example);
	Page<Productos> buscarTodas(Pageable page);
}
