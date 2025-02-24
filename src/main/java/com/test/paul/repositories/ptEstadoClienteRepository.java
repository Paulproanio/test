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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.paul.entities.ptEstadoCliente;

import java.util.Optional;

@Repository
public interface ptEstadoClienteRepository extends JpaRepository<ptEstadoCliente, Long> {

	Optional <ptEstadoCliente> findByIdEstadoCliente(Long idEstadoCliente);
	
	@Transactional
	void deleteByIdEstadoCliente(Long idEstadoCliente);
	
}
