package pe.idat.colegiorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.colegioentity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	
	@Query(value="select count(*) from cursos where nombre_curso=?", nativeQuery=true)
	public abstract int isExistName(String nombreCurso);
	
	@Query(value="select count(*) from profesores where profesor_id=?", nativeQuery=true)
	public abstract int isExistId(Integer profesorId);

}
