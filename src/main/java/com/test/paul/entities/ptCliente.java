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
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "ptCliente")
public class ptCliente extends ptPersona{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long idCliente;
	
	private String contraseniaCliente;
	private Long estadoCliente;
	public String getContraseniaCliente() {
		return contraseniaCliente;
	}
	public void setContraseniaCliente(String contraseniaCliente) {
		this.contraseniaCliente = contraseniaCliente;
	}
	public Long getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(Long estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
}
