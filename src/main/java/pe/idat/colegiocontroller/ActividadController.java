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
import pe.idat.colegioentity.ActividadExtracurricular;
import pe.idat.colegioservice.ActividadService;



@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private ActividadService actividadService;
	
		//listar
		@GetMapping("/listar")
	    public ResponseEntity<?> listar_GET(){
	        Collection<ActividadExtracurricular> collection=actividadService.findAll();
	        if(collection.isEmpty()){
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        
	        return new ResponseEntity<>(collection,HttpStatus.OK);
	    }
		
		//registrar
		@PostMapping("/registrar")
	    public ResponseEntity<?> registrar_POST(@RequestBody ActividadExtracurricular actividad){
	    	
	    	int isExist=actividadService.isExistId(actividad.getActividadId());
	    	
	    	if(isExist==0) {
	    		actividadService.insert(actividad);
	            return new ResponseEntity<>("Actividad extracurricular creada correctamente",HttpStatus.CREATED);
	    	}
	    	
	    	return new ResponseEntity<>("La actividad extracurricular con Id "+actividad.getActividadId()+" ya existe",HttpStatus.CONFLICT);
	        
	    }
		
		//editar
		@PutMapping("/editar/{actividadId}")
	    public ResponseEntity<?> editar_PUT(@RequestBody ActividadExtracurricular actividadNew, @PathVariable Integer actividadId){
	    	ActividadExtracurricular actividadDb= actividadService.findById(actividadId);
	    	
	    	if(actividadDb==null) {
	    		return new ResponseEntity<>("La actividad extracurricular con ID " + actividadId + " no ha sido encontrada",HttpStatus.NOT_FOUND);
	    	}
	    	
	    	if (sonIguales(actividadDb, actividadNew)) {
	            return ResponseEntity.badRequest().body("Por favor, realice al menos un cambio en los datos de la actividad extracurricular");
	        }
	    	
	    	
	        return ResponseEntity.ok("El carnet fue editado correctamente");
	    }
		
		private boolean sonIguales(ActividadExtracurricular actividadDb, ActividadExtracurricular actividadNew) {
	        // Comparar cada campo del estudiante individualmente
	        return actividadDb.getNombreActividad().equals(actividadNew.getNombreActividad())
	                && actividadDb.getDescripcionActividad().equals(actividadNew.getDescripcionActividad());
	    }
		
		//eliminar
	    @DeleteMapping("/eliminar/{actividadId}")
	    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer actividadId){
	    	ActividadExtracurricular actividadDb=actividadService.findById(actividadId);
	    	
	    	if(actividadDb!=null) {
	    		actividadService.delete(actividadId);
	    		return new ResponseEntity<>("La actividad "+actividadDb.getNombreActividad()+" ha sido borrada",HttpStatus.OK);
	    	}
	    	return new ResponseEntity<>("Actividad extracurricular "+actividadId+" no fue encontrada",HttpStatus.NOT_FOUND);
	    }

	  //buscar
	    @GetMapping("/buscar/{actividadId}")
	    public ResponseEntity<?> buscar_GET(@PathVariable Integer actividadId){
	    	ActividadExtracurricular actividadDb=actividadService.findById(actividadId);
	    	
	    	if(actividadDb!=null) {
	    		return new ResponseEntity<>(actividadDb,HttpStatus.FOUND);
	    	}
	    	return new ResponseEntity<>("La actividad con ID: "+actividadId+" no fue encontrada",HttpStatus.NOT_FOUND);
	    }
}
