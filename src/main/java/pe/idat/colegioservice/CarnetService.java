package pe.idat.colegioservice;

import java.util.Collection;

import pe.idat.colegioentity.CarnetEstudiantil;

public interface CarnetService {

	public abstract void insert(CarnetEstudiantil carnet);
	public abstract void update(CarnetEstudiantil carnet);
	public abstract void delete(Integer carnetId);
	public abstract CarnetEstudiantil findById(Integer carnetId);
	public abstract Collection<CarnetEstudiantil> findAll();
	public abstract int isExistNum(Integer carnetId);
	public abstract int isExistId(Integer etudianteId);
	
}
