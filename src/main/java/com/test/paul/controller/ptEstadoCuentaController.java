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

import com.test.paul.services.ptEstadoCuentaService;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptEstadoCuenta;

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
public class ptEstadoCuentaController {
	@Autowired
	ptEstadoCuentaService service;
	
	@GetMapping("/ptEstadoCuenta")
	public ResponseEntity<List<ptEstadoCuenta>> getAll() {
		List<ptEstadoCuenta> list = service.getAll();
		return new ResponseEntity<List<ptEstadoCuenta>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/ptEstadoCuenta/{id}")
	public ResponseEntity<ptEstadoCuenta> getptEstadoCuentaByIdEstadoCuenta(@PathVariable("id") Long idEstadoCuenta) throws RecordNotFoundException {
		ptEstadoCuenta entity = service.findByIdEstadoCuenta(idEstadoCuenta);
		return new ResponseEntity<ptEstadoCuenta>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ptEstadoCuenta")
	public ResponseEntity<ptEstadoCuenta> createptEstadoCuenta(@RequestBody ptEstadoCuenta ptEstadoCuenta){
		service.createptEstadoCuenta(ptEstadoCuenta);
		return new ResponseEntity<ptEstadoCuenta>(ptEstadoCuenta, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/ptEstadoCuenta")
	public ResponseEntity<ptEstadoCuenta> updateptEstadoCuenta(@RequestBody ptEstadoCuenta ptEstadoCuenta) throws RecordNotFoundException{
		service.updateptEstadoCuenta(ptEstadoCuenta);
		return new ResponseEntity<ptEstadoCuenta>(ptEstadoCuenta, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/ptEstadoCuenta/{id}")
	public HttpStatus deleteptEstadoCuentaByIdEstadoCuenta(@PathVariable("id") Long idEstadoCuenta) throws RecordNotFoundException {
		service.deleteptEstadoCuentaByIdEstadoCuenta(idEstadoCuenta);
		return HttpStatus.OK;
	}
}				
