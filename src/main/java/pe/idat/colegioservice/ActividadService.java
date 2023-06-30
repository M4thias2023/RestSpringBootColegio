package pe.idat.colegioservice;

import java.util.Collection;

import pe.idat.colegioentity.ActividadExtracurricular;

public interface ActividadService {
	
	public abstract void insert(ActividadExtracurricular actividad);
	public abstract void update(ActividadExtracurricular actividad);
	public abstract void delete(Integer actividadId);
	public abstract ActividadExtracurricular findById(Integer actividadId);
	public abstract Collection<ActividadExtracurricular> findAll();
	public abstract int isExistId(Integer actividadId);

}
