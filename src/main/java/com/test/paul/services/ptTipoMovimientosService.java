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

import com.test.paul.repositories.ptTipoMovimientosRepository;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptTipoMovimientos;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptTipoMovimientosService {

	@Autowired
	ptTipoMovimientosRepository repo;

	public List<ptTipoMovimientos> getAll(){
		List<ptTipoMovimientos> ptTipoMovimientosList = repo.findAll();
		if(ptTipoMovimientosList.size() > 0) {
			return ptTipoMovimientosList;
		} else {
			return new ArrayList<ptTipoMovimientos>();
		}
	}
     		
	public ptTipoMovimientos findByIdTipoMovimiento(Long idTipoMovimiento) throws RecordNotFoundException{
		Optional<ptTipoMovimientos> ptTipoMovimientos = repo.findByIdTipoMovimiento(idTipoMovimiento);
		if(ptTipoMovimientos.isPresent()) {
			return ptTipoMovimientos.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public ptTipoMovimientos createptTipoMovimientos(ptTipoMovimientos ptTipoMovimientos){
		return repo.save(ptTipoMovimientos);
	}

	public ptTipoMovimientos updateptTipoMovimientos(ptTipoMovimientos ptTipoMovimientos) throws RecordNotFoundException {
		Optional<ptTipoMovimientos> ptTipoMovimientosTemp = repo.findByIdTipoMovimiento(ptTipoMovimientos.getIdTipoMovimiento());
	
		if(ptTipoMovimientosTemp.isPresent()){
			return repo.save(ptTipoMovimientos);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptTipoMovimientosByIdTipoMovimiento(Long idTipoMovimiento) throws RecordNotFoundException{
		Optional<ptTipoMovimientos> ptTipoMovimientos = repo.findByIdTipoMovimiento(idTipoMovimiento);
		if(ptTipoMovimientos.isPresent()) {
		repo.deleteByIdTipoMovimiento(idTipoMovimiento);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
