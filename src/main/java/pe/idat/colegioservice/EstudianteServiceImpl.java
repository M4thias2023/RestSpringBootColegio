package pe.idat.colegioservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.colegioentity.Estudiante;
import pe.idat.colegiorepository.EstudianteRespository;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	private EstudianteRespository repository;

	@Override
	@Transactional
	public void insert(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void update(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer estudianteId) {
		repository.deleteById(estudianteId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Estudiante findById(Integer estudianteId) {
		return repository.findById(estudianteId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Estudiante> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public int isExistName(String nombre) {
		return repository.isExistName(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_Inscripcion() {
		return repository.findAll_Inscripcion();
	}
	
	

}
