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
package com.test.paul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.paul.entities.ptMovimientos;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ptMovimientosRepository extends JpaRepository<ptMovimientos, Long> {

	Optional <ptMovimientos> findByIdMovimiento(Long idMovimiento);
	
	@Transactional
	void deleteByIdMovimiento(Long idMovimiento);
	
	@Query(value = "SELECT PT_MOVIMIENTOS .FECHA_MOVIMIENTO,PT_MOVIMIENTOS .SALDO_MOVIMIENTO, PT_MOVIMIENTOS .VALOR_MOVIMIENTO, PT_MOVIMIENTOS .ID_MOVIMIENTO, PT_MOVIMIENTOS .ID_TIPO_MOVIMIENTO, PT_CUENTA.NUMERO_CUENTA, PT_CUENTA.SALDO_INICIAL, PT_CUENTA.ID_ESTADO_CUENTA, PT_CUENTA.IDENTIFICADOR   FROM PT_MOVIMIENTOS INNER JOIN PT_CUENTA ON PT_MOVIMIENTOS.NUMERO_CUENTA = PT_CUENTA.NUMERO_CUENTA  WHERE PT_CUENTA.IDENTIFICADOR =  ?1 AND PT_MOVIMIENTOS.FECHA_MOVIMIENTO BETWEEN ?2 AND ?3" , nativeQuery = true)
	List <ptMovimientos> getReporteEstadoCuenta(String cedulaCliente, Date fechaInicial, Date fechaFinal);
	
}
