package com.example.crud.service;

import java.util.Optional;

import com.example.crud.model.Orden;

public interface OrdenService {
	
	Orden save(Orden orden);
	Optional<Orden> findById(int id);

}
