package com.ore.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ore.exception.ModelNotFoundException;
import com.ore.model.Encuesta;
import com.ore.service.IEncuestaService;

@RestController
@RequestMapping("/encuestas")
public class EncuestaController {

	@Autowired
	private IEncuestaService service;
	
	@GetMapping
	public ResponseEntity<List<Encuesta>> listar(){
		List<Encuesta> lista = service.listar();
		
		
		if(lista.isEmpty()) {
			throw new ModelNotFoundException("No existe data");
		}
		
		return new ResponseEntity<List<Encuesta>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Encuesta> listarId(@PathVariable("id") Integer id){
		Encuesta encuesta = service.listarId(id);
		if(encuesta == null) {
			throw new ModelNotFoundException("ID no encontrado: " + id);
		}
		else {
		return new ResponseEntity<Encuesta>(encuesta, HttpStatus.OK);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Encuesta> registrar(@Valid @RequestBody Encuesta entity){
		
		Encuesta encuesta = service.registrar(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					   .buildAndExpand(encuesta.getIdEncuesta()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping()
	public ResponseEntity<Encuesta> actualizar(@Valid Encuesta entity){
		Encuesta encuesta = service.listarId(entity.getIdEncuesta());
		if (encuesta == null) {
			throw new ModelNotFoundException("ID: " + entity.getIdEncuesta() + "no existe");
		}
		else {
			service.actualizar(entity);			
		}
		return new ResponseEntity<Encuesta>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Encuesta> eliminar(@PathVariable("id") Integer id){
	
		Encuesta encuesta = service.listarId(id);
		
		if(encuesta == null) {
			throw new ModelNotFoundException("ID: " + id + "no existe"); 
		}
		else {
			service.eliminar(id);
		}
		
		return new ResponseEntity<Encuesta>(HttpStatus.ACCEPTED); 
	
		
	}
	
	
	
}
