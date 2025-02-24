package com.test.paul.entities.dto;

import java.sql.Date;

public class ptCuentaReporteDto {
	private Date fecha;
	private String cliente;
	private Long numeroCuenta;
	private String tipo;
	private float saldoInicial;
	private String estado;
	private float movimiento;
	private float disponible;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(float movimiento) {
		this.movimiento = movimiento;
	}
	public float getDisponible() {
		return disponible;
	}
	public void setDisponible(float disponible) {
		this.disponible = disponible;
	}
	
	
}
