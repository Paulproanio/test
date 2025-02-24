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

import com.test.paul.services.ptEstadoClienteService;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptEstadoCliente;

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
public class ptEstadoClienteController {
	@Autowired
	ptEstadoClienteService service;
	
	@GetMapping("/ptEstadoCliente")
	public ResponseEntity<List<ptEstadoCliente>> getAll() {
		List<ptEstadoCliente> list = service.getAll();
		return new ResponseEntity<List<ptEstadoCliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/ptEstadoCliente/{id}")
	public ResponseEntity<ptEstadoCliente> getptEstadoClienteByIdEstadoCliente(@PathVariable("id") Long idEstadoCliente) throws RecordNotFoundException {
		ptEstadoCliente entity = service.findByIdEstadoCliente(idEstadoCliente);
		return new ResponseEntity<ptEstadoCliente>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ptEstadoCliente")
	public ResponseEntity<ptEstadoCliente> createptEstadoCliente(@RequestBody ptEstadoCliente ptEstadoCliente){
		service.createptEstadoCliente(ptEstadoCliente);
		return new ResponseEntity<ptEstadoCliente>(ptEstadoCliente, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/ptEstadoCliente")
	public ResponseEntity<ptEstadoCliente> updateptEstadoCliente(@RequestBody ptEstadoCliente ptEstadoCliente) throws RecordNotFoundException{
		service.updateptEstadoCliente(ptEstadoCliente);
		return new ResponseEntity<ptEstadoCliente>(ptEstadoCliente, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/ptEstadoCliente/{id}")
	public HttpStatus deleteptEstadoClienteByIdEstadoCliente(@PathVariable("id") Long idEstadoCliente) throws RecordNotFoundException {
		service.deleteptEstadoClienteByIdEstadoCliente(idEstadoCliente);
		return HttpStatus.OK;
	}
}				
