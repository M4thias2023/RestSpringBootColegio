package pe.idat.colegiorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.colegioentity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

	@Query(value="select count(*) from profesores where dni_profesor=?", nativeQuery=true)
	public abstract int isExistDni(Integer dniProfesor);
}
