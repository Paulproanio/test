																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Sun Feb 23 17:28:46 ECT 2025
| 
 -------------------------------------------------------------------
																*/
package com.test.paul.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ptEstadoCliente")
public class ptEstadoCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoCliente;
	
	private String nombreEstadoCliente;
	
	public Long getIdEstadoCliente() {
		return idEstadoCliente;
	}
	
	public void setIdEstadoCliente(Long idEstadoCliente) {
		this.idEstadoCliente = idEstadoCliente;
	}
	
	public String getNombreEstadoCliente() {
		return nombreEstadoCliente;
	}
	
	public void setNombreEstadoCliente(String nombreEstadoCliente) {
		this.nombreEstadoCliente = nombreEstadoCliente;
	}
	
}
