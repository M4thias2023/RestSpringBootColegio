package pe.idat.colegiocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.colegioentity.ActividadExtracurricular;
import pe.idat.colegioentity.Estudiante;
import pe.idat.colegioservice.ActividadService;
import pe.idat.colegioservice.EstudianteService;
import pe.idat.vo.Inscripcion;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionRestController {
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private ActividadService actividadService;
	
	public InscripcionRestController(){
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		return new ResponseEntity<>(estudianteService.findAll_Inscripcion(),HttpStatus.OK);
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Inscripcion inscripcion )
	{
		Integer estudianteId = inscripcion.getEstudiante().getEstudianteId();
		Estudiante estudianteDb = estudianteService.findById(estudianteId);
		
		if(estudianteDb!= null) {
			Integer actividadId=inscripcion.getActividad().getActividadId();
			ActividadExtracurricular actividadDb = actividadService.findById(actividadId);
			
			if(actividadDb!= null) {
				estudianteDb.addActividad(actividadDb);
				estudianteService.update(estudianteDb);
				
				return new ResponseEntity<>("Inscripcion realizada!",HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Actividad no encontrada",HttpStatus.NOT_FOUND);	
		}
		return new ResponseEntity<>("El estudiante"+inscripcion.getEstudiante().getEstudianteId()+"no existe",HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
