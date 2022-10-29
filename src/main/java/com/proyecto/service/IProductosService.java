package com.proyecto.service;

import java.util.List;

import com.proyecto.model.Productos;

public interface IProductosService {
	List<Productos> buscarTodas();
	Productos buscarPorid(Integer id);
	
}
