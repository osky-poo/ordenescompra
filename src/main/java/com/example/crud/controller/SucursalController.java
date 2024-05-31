package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Sucursal;
import com.example.crud.service.SucursalService;

@RestController
@RequestMapping("/api")
public class SucursalController {
	
	@Autowired
	SucursalService service;

	@PostMapping("/sucursales")
	public ResponseEntity<Sucursal> create(@RequestBody Sucursal sucursal) {
		try {
			Sucursal _sucursal = service.save(sucursal);
			return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
