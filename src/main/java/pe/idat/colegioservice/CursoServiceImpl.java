package pe.idat.colegioservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.colegioentity.Curso;
import pe.idat.colegiorepository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	
	@Autowired
	private CursoRepository repository;
	
	@Override
	@Transactional
	public void insert(Curso curso) {
		repository.save(curso);
		
	}

	@Override
	@Transactional
	public void update(Curso curso) {
		repository.save(curso);
		
	}

	@Override
	@Transactional
	public void delete(Integer cursoId) {
		repository.deleteById(cursoId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findById(Integer cursoId) {
		return repository.findById(cursoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Curso> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public int isExistName(String nombreCurso) {
		return repository.isExistName(nombreCurso);
	}

	@Override
	@Transactional(readOnly=true)
	public int isExistId(Integer profesorId) {
		
		return repository.isExistId(profesorId);
	}

	

}
