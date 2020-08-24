package com.ore.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ore.model.LenguajeProgramacion;
import com.ore.repo.ILenguajeProgramacionRepo;
import com.ore.service.ILenguajeProgramacionService;

@Service
public class LenguajeProgramacionServiceImpl implements ILenguajeProgramacionService{

	@Autowired
	private ILenguajeProgramacionRepo repo;
	
	@Override
	public LenguajeProgramacion registrar(LenguajeProgramacion entity) {
		return repo.save(entity);
	}

	@Override
	public LenguajeProgramacion actualizar(LenguajeProgramacion entity) {
		return repo.save(entity);
	}

	@Override
	public List<LenguajeProgramacion> listar() {
		return repo.findAll();
	}

	@Override
	public LenguajeProgramacion listarId(Integer id) {
		Optional<LenguajeProgramacion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new LenguajeProgramacion();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
