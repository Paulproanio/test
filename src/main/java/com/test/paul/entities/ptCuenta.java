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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ptCuenta")
public class ptCuenta {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroCuenta;
	
	private Float saldoInicial;
	@ManyToOne
	@JoinColumn(name = "idEstadoCuenta")
	private ptEstadoCuenta ptEstadoCuenta;
	
	@ManyToOne
	@JoinColumn(name = "idTipoCuenta")
	private ptTipoCuenta ptTipoCuenta;
	
	@ManyToOne
	@JoinColumn(name = "identificador")
	public ptCliente ptCliente;

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public ptEstadoCuenta getPtEstadoCuenta() {
		return ptEstadoCuenta;
	}

	public void setPtEstadoCuenta(ptEstadoCuenta ptEstadoCuenta) {
		this.ptEstadoCuenta = ptEstadoCuenta;
	}

	public ptTipoCuenta getPtTipoCuenta() {
		return ptTipoCuenta;
	}

	public void setPtTipoCuenta(ptTipoCuenta ptTipoCuenta) {
		this.ptTipoCuenta = ptTipoCuenta;
	}

	public ptCliente getPtCliente() {
		return ptCliente;
	}

	public void setPtCliente(ptCliente ptCliente) {
		this.ptCliente = ptCliente;
	}
}
