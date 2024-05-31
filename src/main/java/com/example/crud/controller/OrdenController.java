package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Orden;
import com.example.crud.service.OrdenService;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrdenController {
	
	@Autowired
	OrdenService service;

	@PostMapping("/ordenes")
	public ResponseEntity<Orden> create(@RequestBody Orden orden) {
		try {
			Orden _orden = service.save(orden);
			return new ResponseEntity<>(_orden, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ordenes/{id}")
	public ResponseEntity<Orden> findById(@PathVariable("id") int id) {
		Optional<Orden> ordenData = service.findById(id);

		if (ordenData.isPresent()) {
			return new ResponseEntity<>(ordenData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
