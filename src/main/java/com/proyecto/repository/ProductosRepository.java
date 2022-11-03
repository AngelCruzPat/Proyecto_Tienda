package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {

	List<Productos> findByEstatus(String estatus);
	
	
	List<Productos> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List<Productos> findByEstatusIn(String[] estatus);
}
