package net.itinajero.service;

import java.util.List;

import net.itinajero.model.Productos;

public interface IProductosService {
	List<Productos> buscarTodas();
	Productos buscarPorid(Integer id);
	
}
