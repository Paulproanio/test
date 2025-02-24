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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptCuenta;
import com.test.paul.entities.ptMovimientos;
import com.test.paul.entities.dto.ptCuentaReporteDto;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ptCuentaService {

	@Autowired
	ptCuentaRepository repo;
	
	@Autowired
	ptMovimientosRepository movimientosRepo;

	public List<ptCuenta> getAll(){
		List<ptCuenta> ptCuentaList = repo.findAll();
		if(ptCuentaList.size() > 0) {
			return ptCuentaList;
		} else {
			return new ArrayList<ptCuenta>();
		}
	}
     		
	public ptCuenta findByNumeroCuenta(Long numeroCuenta) throws RecordNotFoundException{
		Optional<ptCuenta> ptCuenta = repo.findByNumeroCuenta(numeroCuenta);
		if(ptCuenta.isPresent()) {
			return ptCuenta.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<ptCuentaReporteDto> getReporteEstadoCuenta(String cedulaCliente, Date fechaInicial,Date fechaFinal) throws RecordNotFoundException, JsonProcessingException{
		
		List<ptMovimientos> ptCuentaDto = movimientosRepo.getReporteEstadoCuenta(cedulaCliente, fechaInicial, fechaFinal);
		
		List<ptCuentaReporteDto> ptCuentaReporteDto = new ArrayList<>();
		
		//ptCuentaReporteDto.stream().forEach(indice -> indice.getCliente());
		
		for (int i = 0; i < ptCuentaDto.size(); i++) {
			
			ptCuentaReporteDto ss = new ptCuentaReporteDto();
			
			ss.setFecha(ptCuentaDto.get(i).getFechaMovimiento());
			ss.setCliente(ptCuentaDto.get(i).getPtCuenta().getPtCliente().getNombre());
			ss.setNumeroCuenta(ptCuentaDto.get(i).getPtCuenta().getNumeroCuenta());
			ss.setTipo(ptCuentaDto.get(i).getPtCuenta().getPtTipoCuenta().getNombreTipoCuenta());
			ss.setSaldoInicial(ptCuentaDto.get(i).getPtCuenta().getSaldoInicial());
			ss.setEstado(ptCuentaDto.get(i).getPtCuenta().getPtEstadoCuenta().getNombreEstadoCuenta());
			ss.setMovimiento(ptCuentaDto.get(i).getValorMovimiento());
			ss.setDisponible(ptCuentaDto.get(i).getSaldoMovimiento());
			
			ptCuentaReporteDto.add(ss);
		}
		
		if(ptCuentaReporteDto.size() > 0) {
			return ptCuentaReporteDto;
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
		
	}

	public List<ptCuentaReporteDto> getReporteEstadoCuenta2(String cedulaCliente, Date fechaInicial,Date fechaFinal) throws RecordNotFoundException{
		
		List<ptMovimientos> ptCuentaDto = movimientosRepo.getReporteEstadoCuenta(cedulaCliente, fechaInicial, fechaFinal);
		
		List<ptCuentaReporteDto> ptCuentaReporteDto = new ArrayList<>();
		
		//ptCuentaReporteDto.stream().forEach(indice -> indice.getCliente());
		
		for (int i = 0; i < ptCuentaDto.size(); i++) {
			
			ptCuentaReporteDto ss = new ptCuentaReporteDto();
			
			ss.setFecha(ptCuentaDto.get(i).getFechaMovimiento());
			ss.setCliente(ptCuentaDto.get(i).getPtCuenta().getPtCliente().getNombre());
			ss.setNumeroCuenta(ptCuentaDto.get(i).getPtCuenta().getNumeroCuenta());
			ss.setTipo(ptCuentaDto.get(i).getPtCuenta().getPtTipoCuenta().getNombreTipoCuenta());
			ss.setSaldoInicial(ptCuentaDto.get(i).getPtCuenta().getSaldoInicial());
			ss.setEstado(ptCuentaDto.get(i).getPtCuenta().getPtEstadoCuenta().getNombreEstadoCuenta());
			ss.setMovimiento(ptCuentaDto.get(i).getValorMovimiento());
			ss.setDisponible(ptCuentaDto.get(i).getSaldoMovimiento());
			
			ptCuentaReporteDto.add(ss);
		}
		
		if(ptCuentaReporteDto.size() > 0) {
			return ptCuentaReporteDto;
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
		
	}
	
	public ptCuenta createptCuenta(ptCuenta ptCuenta){
		return repo.save(ptCuenta);
	}

	public ptCuenta updateptCuenta(ptCuenta ptCuenta) throws RecordNotFoundException {
		Optional<ptCuenta> ptCuentaTemp = repo.findByNumeroCuenta(ptCuenta.getNumeroCuenta());
	
		if(ptCuentaTemp.isPresent()){
			return repo.save(ptCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteptCuentaByNumeroCuenta(Long numeroCuenta) throws RecordNotFoundException{
		Optional<ptCuenta> ptCuenta = repo.findByNumeroCuenta(numeroCuenta);
		if(ptCuenta.isPresent()) {
		repo.deleteByNumeroCuenta(numeroCuenta);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		
}
