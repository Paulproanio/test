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
package com.test.paul.controller;

import com.test.paul.services.ptTipoMovimientosService;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptTipoMovimientos;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/api/v1")
public class ptTipoMovimientosController {
	@Autowired
	ptTipoMovimientosService service;
	
	@GetMapping("/ptTipoMovimientos")
	public ResponseEntity<List<ptTipoMovimientos>> getAll() {
		List<ptTipoMovimientos> list = service.getAll();
		return new ResponseEntity<List<ptTipoMovimientos>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/ptTipoMovimientos/{id}")
	public ResponseEntity<ptTipoMovimientos> getptTipoMovimientosByIdTipoMovimiento(@PathVariable("id") Long idTipoMovimiento) throws RecordNotFoundException {
		ptTipoMovimientos entity = service.findByIdTipoMovimiento(idTipoMovimiento);
		return new ResponseEntity<ptTipoMovimientos>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ptTipoMovimientos")
	public ResponseEntity<ptTipoMovimientos> createptTipoMovimientos(@RequestBody ptTipoMovimientos ptTipoMovimientos){
		service.createptTipoMovimientos(ptTipoMovimientos);
		return new ResponseEntity<ptTipoMovimientos>(ptTipoMovimientos, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/ptTipoMovimientos")
	public ResponseEntity<ptTipoMovimientos> updateptTipoMovimientos(@RequestBody ptTipoMovimientos ptTipoMovimientos) throws RecordNotFoundException{
		service.updateptTipoMovimientos(ptTipoMovimientos);
		return new ResponseEntity<ptTipoMovimientos>(ptTipoMovimientos, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/ptTipoMovimientos/{id}")
	public HttpStatus deleteptTipoMovimientosByIdTipoMovimiento(@PathVariable("id") Long idTipoMovimiento) throws RecordNotFoundException {
		service.deleteptTipoMovimientosByIdTipoMovimiento(idTipoMovimiento);
		return HttpStatus.OK;
	}
}				
