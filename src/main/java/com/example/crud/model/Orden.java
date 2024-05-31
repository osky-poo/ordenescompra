package com.example.crud.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "idProducto", "idSucursal", "idOrden" })
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int idOrden;
	
	private int idSucursal;
	
	private Date fecha;
	
	private double total;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable ( name = "orden_producto" , 
		joinColumns = { @JoinColumn ( name = " orden_id" )}, 
		inverseJoinColumns = { @JoinColumn ( name = " producto_id" )} )
	private List<Producto> productos;

}
