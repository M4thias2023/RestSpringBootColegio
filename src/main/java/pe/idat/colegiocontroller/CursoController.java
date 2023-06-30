																																																																																																																																																																																																																																																																																									package pe.idat.colegiocontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.colegioentity.Curso;
import pe.idat.colegioentity.Profesor;
import pe.idat.colegioservice.CursoService;
import pe.idat.colegioservice.ProfesorService;
import pe.idat.util.Mapper;


@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfesorService profesorService;
	
	
	//listar
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Curso> collection = cursoService.findAll();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(collection,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(Mapper.toCursos(collection), HttpStatus.OK);
	}
	
	
	//registrar
	@PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Curso curso){
    	
    	int isExist=cursoService.isExistName(curso.getNombreCurso());
    	int profesorExist = cursoService.isExistId(curso.getProfesor().getProfesorId());
    	
    	if (profesorExist == 0) {
            return ResponseEntity.badRequest().body("El profesor con ID " + curso.getProfesor().getProfesorId() + " no existe");
        }
    	
    	if(isExist==0) {
    		cursoService.insert(curso);
            return new ResponseEntity<>("El curso fue registrado correctamente",HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<>("El curso "+curso.getNombreCurso().toUpperCase()+" ya existe",HttpStatus.CONFLICT);
    	
    }
	
	
	//editar
	@PutMapping("/editar/{cursoId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Curso cursoNew, @PathVariable Integer cursoId){
    	Curso cursoDb= cursoService.findById(cursoId);
    	
    	if (cursoDb == null) {
            return new ResponseEntity<>("El curso con ID " + cursoId + " no encontrado",HttpStatus.NOT_FOUND);
        }

        if (sonIguales(cursoDb, cursoNew)) {
            return ResponseEntity.badRequest().body("Por favor, realice al menos un cambio en los datos del curso");
        }

        // Verificar si el ID del profesor en cursoNew existe en la base de datos
        Integer profesorId = cursoNew.getProfesor().getProfesorId();
        Profesor profesorDb = profesorService.findById(profesorId);
        if (profesorDb == null) {
            return ResponseEntity.badRequest().body("El profesor con ID " + profesorId + " no existe");
        }

        cursoDb.setNombreCurso(cursoNew.getNombreCurso());
        cursoDb.setDescripcionCurso(cursoNew.getDescripcionCurso());
        cursoDb.setProfesor(cursoNew.getProfesor());

        cursoService.update(cursoDb);
        return ResponseEntity.ok("El curso fue editado correctamente");
    }
	
	private boolean sonIguales(Curso cursoDb, Curso cursoNew) {
        // Compara que cada campo del estudiante individualmente
        return cursoDb.getNombreCurso().equals(cursoNew.getNombreCurso())
                && cursoDb.getNombreCurso().equals(cursoNew.getNombreCurso())
                && cursoDb.getDescripcionCurso().equals(cursoNew.getDescripcionCurso())
                && cursoDb.getProfesor().getProfesorId().equals(cursoNew.getProfesor().getProfesorId());
    }
	
	
	//eliminar
	@DeleteMapping("/eliminar/{cursoId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer cursoId){
		Curso cursoDb= cursoService.findById(cursoId);
    	
    	if(cursoDb!=null) {
    		cursoService.delete(cursoId);
    		return new ResponseEntity<>("El curso "+cursoDb.getNombreCurso().toUpperCase()+" ha sido borrado",HttpStatus.OK);
    	}
    	return new ResponseEntity<>("El curso "+cursoId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }
	
																																
	//buscar
	@GetMapping("/buscar/{cursoId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer cursoId){
		Curso cursoDb= cursoService.findById(cursoId);
    	
    	if(cursoDb!=null) {
    		return new ResponseEntity<>(cursoDb,HttpStatus.FOUND);
    	}
    	return new ResponseEntity<>("El curso con ID: "+cursoId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }

}
