package pe.idat.colegiorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.colegioentity.CarnetEstudiantil;

public interface CarnetRepository extends JpaRepository<CarnetEstudiantil, Integer> {
	
	@Query(value="select count(*) from carnet_estudiantil where carnet_id=?", nativeQuery=true)
	public abstract int isExistNum(Integer numeroCarnet);

	@Query(value="select count(*) from estudiantes where estudiante_id=?", nativeQuery=true)
	public abstract int isExistId(Integer estudianteId);
}
