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

import com.test.paul.repositories.ptEstadoCuentaRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptEstadoCuenta;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptEstadoCuentaService {

	@Autowired
	ptEstadoCuentaRepository repo;

	public List<ptEstadoCuenta> getAll(){
		List<ptEstadoCuenta> ptEstadoCuentaList = repo.findAll();
		if(ptEstadoCuentaList.size() > 0) {
			return ptEstadoCuentaList;
		} else {
			return new ArrayList<ptEstadoCuenta>();
		}
	}
     		
	public ptEstadoCuenta findByIdEstadoCuenta(Long idEstadoCuenta) throws RecordNotFoundException{
		Optional<ptEstadoCuenta> ptEstadoCuenta = repo.findByIdEstadoCuenta(idEstadoCuenta);
		if(ptEstadoCuenta.isPresent()) {
			return ptEstadoCuenta.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public ptEstadoCuenta createptEstadoCuenta(ptEstadoCuenta ptEstadoCuenta){
		return repo.save(ptEstadoCuenta);
	}

	public ptEstadoCuenta updateptEstadoCuenta(ptEstadoCuenta ptEstadoCuenta) throws RecordNotFoundException {
		Optional<ptEstadoCuenta> ptEstadoCuentaTemp = repo.findByIdEstadoCuenta(ptEstadoCuenta.getIdEstadoCuenta());
	
		if(ptEstadoCuentaTemp.isPresent()){
			return repo.save(ptEstadoCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptEstadoCuentaByIdEstadoCuenta(Long idEstadoCuenta) throws RecordNotFoundException{
		Optional<ptEstadoCuenta> ptEstadoCuenta = repo.findByIdEstadoCuenta(idEstadoCuenta);
		if(ptEstadoCuenta.isPresent()) {
		repo.deleteByIdEstadoCuenta(idEstadoCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
