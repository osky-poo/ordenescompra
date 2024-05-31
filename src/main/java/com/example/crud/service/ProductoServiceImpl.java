package com.example.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Producto;
import com.example.crud.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository repository;

	@Override
	public Producto save(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		Producto productoActualizar = repository.findById(producto.getIdProducto()).get();
		productoActualizar.setPrecio(producto.getPrecio());
		return repository.save(productoActualizar);
	}

	@Override
	public Optional<Producto> findById(int id) {
		return repository.findById(id);
	}

}
