package pe.idat.colegiorepository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.idat.colegioentity.Estudiante;

	public interface EstudianteRespository extends JpaRepository<Estudiante, Integer> {
		
		@Query(value="select count(*) from estudiantes where dni=?", nativeQuery=true)
		public abstract int isExistName(String nombre);
		
		@Query(value="select est.estudiante_id,CONCAT(est.nombre, ' ', est.apellido) AS Estudiante , act.actividad_id, act.nombre_actividad\r\n"
				+ "from inscripcion ins \r\n"
				+ "inner join estudiantes est on ins.estudiante_id = est.estudiante_id \r\n"
				+ "inner join actividad act on ins.actividad_id = act.actividad_id;",nativeQuery = true)
		public abstract Collection<Object[]> findAll_Inscripcion();
		
	}
