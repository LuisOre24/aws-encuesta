package com.ore.service;

import java.util.List;

public interface ICrudService<T> {

	T registrar(T entity);
	T actualizar(T entity);
	List<T> listar();
	T listarId(Integer id);
	void eliminar(Integer id);
	
}
