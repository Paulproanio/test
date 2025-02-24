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
@Table(name = "ptEstadoCuenta")
public class ptEstadoCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoCuenta;
	
	private String nombreEstadoCuenta;
	
	public Long getIdEstadoCuenta() {
		return idEstadoCuenta;
	}
	
	public void setIdEstadoCuenta(Long idEstadoCuenta) {
		this.idEstadoCuenta = idEstadoCuenta;
	}
	
	public String getNombreEstadoCuenta() {
		return nombreEstadoCuenta;
	}
	
	public void setNombreEstadoCuenta(String nombreEstadoCuenta) {
		this.nombreEstadoCuenta = nombreEstadoCuenta;
	}
	
}
