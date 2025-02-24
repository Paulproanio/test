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

import com.test.paul.repositories.ptCuentaRepository;
import com.test.paul.repositories.ptMovimientosRepository;
import com.test.paul.exception.ptCuentaException;

import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptCuenta;
import com.test.paul.entities.ptMovimientos;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptMovimientosService {

	@Autowired
	ptMovimientosRepository repo;
	
	@Autowired
	ptCuentaRepository repoCuenta;

	public List<ptMovimientos> getAll(){
		List<ptMovimientos> ptMovimientosList = repo.findAll();
		if(ptMovimientosList.size() > 0) {
			return ptMovimientosList;
		} else {
			return new ArrayList<ptMovimientos>();
		}
	}
     		
	public ptMovimientos findByIdMovimiento(Long idMovimiento) throws RecordNotFoundException{
		Optional<ptMovimientos> ptMovimientos = repo.findByIdMovimiento(idMovimiento);
		if(ptMovimientos.isPresent()) {
			return ptMovimientos.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	private Float sumaNumerica(Float saldo, Float movimiento) {
		return saldo + movimiento;
	}
	
	public void createptMovimientos(ptMovimientos ptMovimientos) throws ptCuentaException{
		Optional<ptCuenta> existeCuenta = repoCuenta.findByNumeroCuenta(ptMovimientos.getPtCuenta().getNumeroCuenta());
		existeCuenta.get().getSaldoInicial();
		if (existeCuenta.isPresent()) {
			ptCuenta ptCuentaAux = new ptCuenta();
			ptCuentaAux = existeCuenta.get();

			if (ptMovimientos.getValorMovimiento() < 0) {
				if (ptCuentaAux.getSaldoInicial() >= ((-1) * (ptMovimientos.getValorMovimiento()))) {
					setValuesaldos(ptMovimientos, ptCuentaAux);
					

				} else {
					throw new ptCuentaException("Saldo no disponible");			
				}
			} else if (ptMovimientos.getValorMovimiento() == 0) {
				throw new ptCuentaException("Debe ingresar un valor diferente de cero");
			} else {
				setValuesaldos(ptMovimientos, ptCuentaAux);
			}
			repo.save(ptMovimientos);
			repoCuenta.save(ptCuentaAux);
		}else {
			 throw new ptCuentaException("Numero de cuenta no existente");
		}
		 
	}

	private void setValuesaldos(ptMovimientos ptMovimientos, ptCuenta ptCuentaAux) {
		Float saldo = sumaNumerica(ptCuentaAux.getSaldoInicial(), ptMovimientos.getValorMovimiento());
		ptMovimientos.setSaldoMovimiento(saldo);
		ptCuentaAux.setSaldoInicial(ptCuentaAux.getSaldoInicial());
	}

	//public ptMovimientos createptMovimientos(ptMovimientos ptMovimientos){
	//	return repo.save(ptMovimientos);
	//}

	public ptMovimientos updateptMovimientos(ptMovimientos ptMovimientos) throws RecordNotFoundException {
		Optional<ptMovimientos> ptMovimientosTemp = repo.findByIdMovimiento(ptMovimientos.getIdMovimiento());
	
		if(ptMovimientosTemp.isPresent()){
			return repo.save(ptMovimientos);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptMovimientosByIdMovimiento(Long idMovimiento) throws RecordNotFoundException{
		Optional<ptMovimientos> ptMovimientos = repo.findByIdMovimiento(idMovimiento);
		if(ptMovimientos.isPresent()) {
		repo.deleteByIdMovimiento(idMovimiento);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
