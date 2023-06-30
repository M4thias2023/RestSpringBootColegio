package pe.idat.colegioservice;

import java.util.Collection;

import pe.idat.colegioentity.Estudiante;

public interface EstudianteService {
	
	public abstract void insert(Estudiante estudiante);
	public abstract void update(Estudiante estudiante);
	public abstract void delete(Integer estudianteId);
	public abstract Estudiante findById(Integer estudianteId);
	public abstract Collection<Estudiante> findAll();
	public abstract int isExistName(String nombre);
	public abstract Collection<Object[]> findAll_Inscripcion();
}
