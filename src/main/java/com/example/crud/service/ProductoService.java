package com.example.crud.service;

import java.util.Optional;

import com.example.crud.model.Orden;
import com.example.crud.model.Producto;

public interface ProductoService {
	
	Producto save(Producto producto);
	Producto update(Producto producto);
	Optional<Producto> findById(int id);

}
