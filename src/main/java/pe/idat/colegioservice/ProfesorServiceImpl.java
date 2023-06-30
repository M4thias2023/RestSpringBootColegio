package pe.idat.colegioservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.colegioentity.Profesor;
import pe.idat.colegiorepository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorRepository repository;

	@Override
	@Transactional
	public void insert(Profesor profesor) {
		repository.save(profesor);
		
	}

	@Override
	@Transactional
	public void update(Profesor profesor) {
		repository.save(profesor);
		
	}

	@Override
	@Transactional
	public void delete(Integer profesorId) {
		repository.deleteById(profesorId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Profesor findById(Integer profesorId) {
		return repository.findById(profesorId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Profesor> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public int isExistDni(Integer dniProfesor) {
		// TODO Auto-generated method stub
		return repository.isExistDni(dniProfesor);
	}

	
	
	

}
