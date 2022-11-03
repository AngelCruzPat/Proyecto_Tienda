package com.proyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.model.Productos;
import com.proyecto.repository.ProductosRepository;
import com.proyecto.service.IProductosService;

@Service
@Primary
public class ProductosServiceJpa implements IProductosService {

	@Autowired
	private ProductosRepository productosRepo; 
	
	
	@Override
	public List<Productos> buscarTodas() {
		
		return productosRepo.findAll();
	}

	@Override
	public Productos buscarPorId(Integer idProductos) {
		
		Optional<Productos> optional = productosRepo.findById(idProductos);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Productos productos) {
		productosRepo.save(productos);

	}

	@Override
	public List<Productos> buscarDestacadas() {
		// TODO Auto-generated method stub
		return productosRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(Integer idProductos) {
		// TODO Auto-generated method stub
		productosRepo.deleteById(idProductos);
		
	}

	@Override
	public List<Productos> buscarByExample(Example<Productos> example) {
		
		return productosRepo.findAll(example);
	}

	@Override
	public Page<Productos> buscarTodas(Pageable page) {
		
		return productosRepo.findAll(page);
	}

}