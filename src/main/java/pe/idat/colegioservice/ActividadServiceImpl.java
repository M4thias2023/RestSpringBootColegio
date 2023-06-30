package pe.idat.colegioservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.colegioentity.ActividadExtracurricular;
import pe.idat.colegiorepository.ActividadRepository;

@Service
public class ActividadServiceImpl implements ActividadService {
	
	@Autowired
	private ActividadRepository repository;

	@Override
	@Transactional
	public void insert(ActividadExtracurricular actividad) {
		repository.save(actividad);
		
	}

	@Override
	@Transactional
	public void update(ActividadExtracurricular actividad) {
		repository.save(actividad);
		
	}

	@Override
	@Transactional
	public void delete(Integer actividadId) {
		repository.deleteById(actividadId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ActividadExtracurricular findById(Integer actividadId) {
		return repository.findById(actividadId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ActividadExtracurricular> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int isExistId(Integer actividadId) {
		return repository.isExistId(actividadId);
	}

	

}
