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
import com.ore.model.LenguajeProgramacion;
import com.ore.service.ILenguajeProgramacionService;

@RestController
@RequestMapping("/lenguajes")
public class LenguajeProgramacionController {

	
	@Autowired
	private ILenguajeProgramacionService service;
	
	@GetMapping
	public ResponseEntity<List<LenguajeProgramacion>> listar(){
		List<LenguajeProgramacion> lista = service.listar();
		
		if(lista.isEmpty()) {
			throw new ModelNotFoundException("No existe data");
		}
		
		return new ResponseEntity<List<LenguajeProgramacion>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LenguajeProgramacion> listarId(@PathVariable("id") Integer id){
		LenguajeProgramacion lenguaje = service.listarId(id);
		if(lenguaje == null) {
			throw new ModelNotFoundException("ID no encontrado: " + id);
		}
		else {
		return new ResponseEntity<LenguajeProgramacion>(lenguaje, HttpStatus.OK);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<LenguajeProgramacion> registrar(@Valid @RequestBody LenguajeProgramacion entity){
		
		LenguajeProgramacion lenguaje = service.registrar(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					   .buildAndExpand(lenguaje.getIdLenguaje()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping()
	public ResponseEntity<LenguajeProgramacion> actualizar(@Valid LenguajeProgramacion entity){
		LenguajeProgramacion lenguaje = service.listarId(entity.getIdLenguaje());
		if (lenguaje == null) {
			throw new ModelNotFoundException("ID: " + entity.getIdLenguaje() + "no existe");
		}
		else {
			service.actualizar(entity);			
		}
		return new ResponseEntity<LenguajeProgramacion>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LenguajeProgramacion> eliminar(@PathVariable("id") Integer id){
	
		LenguajeProgramacion lenguaje = service.listarId(id);
		
		if(lenguaje == null) {
			throw new ModelNotFoundException("ID: " + id + "no existe"); 
		}
		else {
			service.eliminar(id);
		}
		
		return new ResponseEntity<LenguajeProgramacion>(HttpStatus.ACCEPTED); 
	
		
	}
	
	
}
