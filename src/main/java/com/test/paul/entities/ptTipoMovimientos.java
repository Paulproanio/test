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
@Table(name = "ptTipoMovimientos")
public class ptTipoMovimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoMovimiento;
	
	private String nombreTipoMovimiento;
	
	public Long getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	
	public void setIdTipoMovimiento(Long idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getNombreTipoMovimiento() {
		return nombreTipoMovimiento;
	}

	public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
		this.nombreTipoMovimiento = nombreTipoMovimiento;
	}
}
