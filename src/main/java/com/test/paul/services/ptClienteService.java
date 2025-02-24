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
package com.test.paul.services;

import com.test.paul.repositories.ptClienteRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptCliente;
import com.test.paul.exception.ptClienteException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptClienteService {

	@Autowired
	ptClienteRepository repo;

	public List<ptCliente> getAll(){
		List<ptCliente> ptClienteList = repo.findAll();
		if(ptClienteList.size() > 0) {
			return ptClienteList;
		} else {
			return new ArrayList<ptCliente>();
		}
	}
     		
	public ptCliente findByIdentificador(String identificador) throws ptClienteException{
		Optional<ptCliente> ptCliente = repo.findByIdentificador(identificador);
		if(ptCliente.isPresent()) {
			return ptCliente.get();
		} else {
			throw new ptClienteException("No existe un cliente con ese identificador!");
		}
	}

	public ptCliente createptCliente(ptCliente ptCliente){
		return repo.save(ptCliente);
	}

	public ptCliente updateptCliente(ptCliente ptCliente) throws RecordNotFoundException {
		Optional<ptCliente> ptClienteTemp = repo.findByIdentificador(ptCliente.getIdentificador());
	
		if(ptClienteTemp.isPresent()){
			return repo.save(ptCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptClienteByIdCliente(String identificador) throws RecordNotFoundException{
		Optional<ptCliente> ptCliente = repo.findByIdentificador(identificador);
		if(ptCliente.isPresent()) {
		repo.deleteByIdentificador(identificador);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
