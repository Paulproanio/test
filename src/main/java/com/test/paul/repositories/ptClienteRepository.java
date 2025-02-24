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

import com.test.paul.entities.ptCliente;

import java.util.Optional;

@Repository
public interface ptClienteRepository extends JpaRepository<ptCliente, String> {

	Optional <ptCliente> findByIdentificador(String identificador);
	
	@Transactional
	void deleteByIdentificador(String identificador);
	
}
