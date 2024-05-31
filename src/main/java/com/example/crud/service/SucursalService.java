package com.example.crud.service;

import java.util.Optional;

import com.example.crud.model.Producto;
import com.example.crud.model.Sucursal;

public interface SucursalService {
	
	Sucursal save(Sucursal sucursal);
	Optional<Sucursal> findById(int id);

}
