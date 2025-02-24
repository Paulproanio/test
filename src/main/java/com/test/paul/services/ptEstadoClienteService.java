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

import com.test.paul.repositories.ptEstadoClienteRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptEstadoCliente;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptEstadoClienteService {

	@Autowired
	ptEstadoClienteRepository repo;

	public List<ptEstadoCliente> getAll(){
		List<ptEstadoCliente> ptEstadoClienteList = repo.findAll();
		if(ptEstadoClienteList.size() > 0) {
			return ptEstadoClienteList;
		} else {
			return new ArrayList<ptEstadoCliente>();
		}
	}
     		
	public ptEstadoCliente findByIdEstadoCliente(Long idEstadoCliente) throws RecordNotFoundException{
		Optional<ptEstadoCliente> ptEstadoCliente = repo.findByIdEstadoCliente(idEstadoCliente);
		if(ptEstadoCliente.isPresent()) {
			return ptEstadoCliente.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public ptEstadoCliente createptEstadoCliente(ptEstadoCliente ptEstadoCliente){
		return repo.save(ptEstadoCliente);
	}

	public ptEstadoCliente updateptEstadoCliente(ptEstadoCliente ptEstadoCliente) throws RecordNotFoundException {
		Optional<ptEstadoCliente> ptEstadoClienteTemp = repo.findByIdEstadoCliente(ptEstadoCliente.getIdEstadoCliente());
	
		if(ptEstadoClienteTemp.isPresent()){
			return repo.save(ptEstadoCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptEstadoClienteByIdEstadoCliente(Long idEstadoCliente) throws RecordNotFoundException{
		Optional<ptEstadoCliente> ptEstadoCliente = repo.findByIdEstadoCliente(idEstadoCliente);
		if(ptEstadoCliente.isPresent()) {
		repo.deleteByIdEstadoCliente(idEstadoCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
