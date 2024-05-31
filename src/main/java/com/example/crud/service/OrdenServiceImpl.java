package com.example.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Orden;
import com.example.crud.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {
	
	@Autowired
	OrdenRepository repository;

	@Override
	public Orden save(Orden orden) {
		return repository.save(orden);
	}

	@Override
	public Optional<Orden> findById(int id) {
		return repository.findById(id);
	}

}
