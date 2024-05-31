package com.example.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Sucursal;
import com.example.crud.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	SucursalRepository repository;

	@Override
	public Sucursal save(Sucursal sucursal) {
		return repository.save(sucursal);
	}

	@Override
	public Optional<Sucursal> findById(int id) {
		return repository.findById(id);
	}

}
