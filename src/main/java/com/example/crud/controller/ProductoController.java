package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Producto;
import com.example.crud.service.ProductoService;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoService service;

	@PostMapping("/productos")
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		try {
			Producto _producto = service.save(producto);
			return new ResponseEntity<>(_producto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> findById(@PathVariable("id") int id) {
		Optional<Producto> productoData = service.findById(id);

		if (productoData.isPresent()) {
			return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> update(@PathVariable("id") int id, 
			@RequestBody Producto producto) {
		Optional<Producto> productoData = service.findById(id);
		
		if (productoData.isPresent()) {
			Producto _producto = productoData.get();
			_producto.setPrecio(producto.getPrecio());
			return new ResponseEntity<>(service.save(_producto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
