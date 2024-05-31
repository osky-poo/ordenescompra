package com.example.crud.model;

import java.util.Date;
import java.util.List;

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
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrden;
	
	private int idSucursal;
	
	private Date fecha;
	
	private double total;
	
	@ManyToMany
	@JoinTable ( name = "orden_producto" , 
		joinColumns = { @JoinColumn ( name = " orden_id" )}, 
		inverseJoinColumns = { @JoinColumn ( name = " producto_id" )} )
	List<Producto> productos;

}
