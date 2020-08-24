package com.ore.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ore.model.Encuesta;
import com.ore.repo.IEncuestaRepo;
import com.ore.service.IEncuestaService;

@Service
public class EncuestaServiceImpl implements IEncuestaService{

	@Autowired
	private IEncuestaRepo repo;
	
	
	@Override
	public Encuesta registrar(Encuesta entity) {
		return repo.save(entity);
	}

	@Override
	public Encuesta actualizar(Encuesta entity) {
		return repo.save(entity);
	}

	@Override
	public List<Encuesta> listar() {
		return repo.findAll();
	}

	@Override
	public Encuesta listarId(Integer id) {
		Optional<Encuesta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Encuesta();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
