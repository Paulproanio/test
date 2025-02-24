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

import com.test.paul.services.ptPersonaService;
import com.test.paul.RecordNotFoundException;
import com.test.paul.entities.ptPersona;

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
public class ptPersonaController {
	@Autowired
	ptPersonaService service;
	
	@GetMapping("/ptPersona")
	public ResponseEntity<List<ptPersona>> getAll() {
		List<ptPersona> list = service.getAll();
		return new ResponseEntity<List<ptPersona>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/ptPersona/{id}")
	public ResponseEntity<ptPersona> getptPersonaByIdPersona(@PathVariable("id") String identificador) throws RecordNotFoundException {
		ptPersona entity = service.findByIdentificacion(identificador);
		return new ResponseEntity<ptPersona>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ptPersona")
	public ResponseEntity<ptPersona> createptPersona(@RequestBody ptPersona ptPersona){
		service.createptPersona(ptPersona);
		return new ResponseEntity<ptPersona>(ptPersona, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/ptPersona")
	public ResponseEntity<ptPersona> updateptPersona(@RequestBody ptPersona ptPersona) throws RecordNotFoundException{
		service.updateptPersona(ptPersona);
		return new ResponseEntity<ptPersona>(ptPersona, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/ptPersona/{id}")
	public HttpStatus deleteptPersonaByIdPersona(@PathVariable("id") String identificador) throws RecordNotFoundException {
		service.deleteptPersonaByIdentificador(identificador);
		return HttpStatus.OK;
	}
}				
