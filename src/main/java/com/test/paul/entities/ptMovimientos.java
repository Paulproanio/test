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

import java.sql.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ptMovimientos")
public class ptMovimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	
	@Basic
	private Date fechaMovimiento;
	private Float valorMovimiento;
	private Float saldoMovimiento;
	private Long idTipoMovimiento;
	
	@ManyToOne
	@JoinColumn(name = "numeroCuenta")
	public ptCuenta ptCuenta;
	
	public Long getIdMovimiento() {
		return idMovimiento;
	}
	
	public void setIdMovimiento(Long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	
	public Float getValorMovimiento() {
		return valorMovimiento;
	}
	
	public void setValorMovimiento(Float valorMovimiento) {
		this.valorMovimiento = valorMovimiento;
	}
	
	public Float getSaldoMovimiento() {
		return saldoMovimiento;
	}
	
	public void setSaldoMovimiento(Float saldoMovimiento) {
		this.saldoMovimiento = saldoMovimiento;
	}
	
	public Long getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	
	public void setIdTipoMovimiento(Long idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public ptCuenta getPtCuenta() {
		return ptCuenta;
	}

	public void setPtCuenta(ptCuenta ptCuenta) {
		this.ptCuenta = ptCuenta;
	}
}
