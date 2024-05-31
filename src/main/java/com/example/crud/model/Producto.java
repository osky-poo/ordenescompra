package com.example.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrden;
	
	private int idProducto;
	
	private String codigo;
	
	private String descripcion;
	
	private double precio;

}
