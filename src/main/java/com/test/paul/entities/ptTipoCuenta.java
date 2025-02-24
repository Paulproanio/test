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
@Table(name = "ptTipoCuenta")
public class ptTipoCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoCuenta;
	
	private String nombreTipoCuenta;
	
	public Long getIdTipoCuenta() {
		return idTipoCuenta;
	}
	
	public void setIdTipoCuenta(Long idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}
	
	public String getNombreTipoCuenta() {
		return nombreTipoCuenta;
	}
	
	public void setNombreTipoCuenta(String nombreTipoCuenta) {
		this.nombreTipoCuenta = nombreTipoCuenta;
	}
	
}
