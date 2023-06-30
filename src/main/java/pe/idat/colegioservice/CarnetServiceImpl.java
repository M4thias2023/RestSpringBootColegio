package pe.idat.colegioservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.colegioentity.CarnetEstudiantil;
import pe.idat.colegiorepository.CarnetRepository;

@Service
public class CarnetServiceImpl implements CarnetService {

	@Autowired
	private CarnetRepository repository;
	
	@Override
	@Transactional
	public void insert(CarnetEstudiantil carnet) {
		repository.save(carnet);
		
	}

	@Override
	@Transactional
	public void update(CarnetEstudiantil carnet) {
		repository.save(carnet);
		
	}

	@Override
	@Transactional
	public void delete(Integer carnetId) {
		repository.deleteById(carnetId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CarnetEstudiantil findById(Integer carnetId) {
		return repository.findById(carnetId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CarnetEstudiantil> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int isExistNum(Integer numeroCarnet) {
		return repository.isExistNum(numeroCarnet);
	}

	@Override
	@Transactional(readOnly = true)
	public int isExistId(Integer etudianteId) {
		return repository.isExistId(etudianteId);
	}

}
