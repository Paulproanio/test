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

import com.test.paul.repositories.ptPersonaRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptPersona;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptPersonaService {

	@Autowired
	ptPersonaRepository repo;

	public List<ptPersona> getAll(){
		List<ptPersona> ptPersonaList = repo.findAll();
		if(ptPersonaList.size() > 0) {
			return ptPersonaList;
		} else {
			return new ArrayList<ptPersona>();
		}
	}
     		
	public ptPersona findByIdentificacion(String identificador) throws RecordNotFoundException{
		Optional<ptPersona> ptPersona = repo.findByIdentificador(identificador);
		if(ptPersona.isPresent()) {
			return ptPersona.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public ptPersona createptPersona(ptPersona ptPersona){
		return repo.save(ptPersona);
	}

	public ptPersona updateptPersona(ptPersona ptPersona) throws RecordNotFoundException {
		Optional<ptPersona> ptPersonaTemp = repo.findByIdentificador(ptPersona.getIdentificador());
	
		if(ptPersonaTemp.isPresent()){
			return repo.save(ptPersona);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptPersonaByIdentificador(String identificador) throws RecordNotFoundException{
		Optional<ptPersona> ptPersona = repo.findByIdentificador(identificador);
		if(ptPersona.isPresent()) {
		repo.deleteByIdentificador(identificador);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
