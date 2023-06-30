package pe.idat.colegiorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.colegioentity.ActividadExtracurricular;

public interface ActividadRepository extends JpaRepository<ActividadExtracurricular, Integer> {

	@Query(value="select count(*) from actividad where actividad_id=?",nativeQuery = true)
	public abstract int isExistId(Integer actividadId);
}
