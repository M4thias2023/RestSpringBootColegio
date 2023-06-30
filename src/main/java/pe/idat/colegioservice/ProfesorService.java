package pe.idat.colegioservice;

import java.util.Collection;

import pe.idat.colegioentity.Profesor;

public interface ProfesorService {
	
	public abstract void insert(Profesor profesor);
	public abstract void update(Profesor profesor);
	public abstract void delete(Integer profesorId);
	public abstract Profesor findById(Integer profesorId);
	public abstract Collection<Profesor> findAll();
	public abstract int isExistDni(Integer dniProfesor);

}
