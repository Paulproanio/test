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

import com.test.paul.repositories.ptTipoCuentaRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptTipoCuenta;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptTipoCuentaService {

	@Autowired
	ptTipoCuentaRepository repo;

	public List<ptTipoCuenta> getAll(){
		List<ptTipoCuenta> ptTipoCuentaList = repo.findAll();
		if(ptTipoCuentaList.size() > 0) {
			return ptTipoCuentaList;
		} else {
			return new ArrayList<ptTipoCuenta>();
		}
	}
     		
	public ptTipoCuenta findByIdTipoCuenta(Long idTipoCuenta) throws RecordNotFoundException{
		Optional<ptTipoCuenta> ptTipoCuenta = repo.findByIdTipoCuenta(idTipoCuenta);
		if(ptTipoCuenta.isPresent()) {
			return ptTipoCuenta.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public ptTipoCuenta createptTipoCuenta(ptTipoCuenta ptTipoCuenta){
		return repo.save(ptTipoCuenta);
	}

	public ptTipoCuenta updateptTipoCuenta(ptTipoCuenta ptTipoCuenta) throws RecordNotFoundException {
		Optional<ptTipoCuenta> ptTipoCuentaTemp = repo.findByIdTipoCuenta(ptTipoCuenta.getIdTipoCuenta());
	
		if(ptTipoCuentaTemp.isPresent()){
			return repo.save(ptTipoCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptTipoCuentaByIdTipoCuenta(Long idTipoCuenta) throws RecordNotFoundException{
		Optional<ptTipoCuenta> ptTipoCuenta = repo.findByIdTipoCuenta(idTipoCuenta);
		if(ptTipoCuenta.isPresent()) {
		repo.deleteByIdTipoCuenta(idTipoCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
