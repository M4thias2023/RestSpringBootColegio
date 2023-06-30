package pe.idat.colegioservice;

import java.util.Collection;

import pe.idat.colegioentity.Curso;

public interface CursoService {
	
	public abstract void insert(Curso curso);
	public abstract void update(Curso curso);
	public abstract void delete(Integer cursoId);
	public abstract Curso findById(Integer cursoId);
	public abstract Collection<Curso> findAll();
	public abstract int isExistName(String nombreCurso);
	public abstract int isExistId(Integer profesorId);

}
