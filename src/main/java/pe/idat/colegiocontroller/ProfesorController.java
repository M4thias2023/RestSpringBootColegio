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
import pe.idat.colegioentity.Profesor;
import pe.idat.colegioservice.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	public ProfesorController() {
		
	}
	
	
	//listar
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Profesor> collection=profesorService.findAll();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(collection,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection, HttpStatus.OK);
	}
	
	
	//registrar
	@PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Profesor profesor){
    	
    	int isExist=profesorService.isExistDni(profesor.getDniProfesor());
    	
    	if(isExist==0) {
    		    		
    		profesorService.insert(profesor);
    		return new ResponseEntity<>("Profesor registrado correctamente", HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<>("El profesor "+profesor.getNombreProfesor().toUpperCase()+" "+profesor.getApellidoProfesor().toUpperCase()+" ya existe",HttpStatus.CONFLICT);
    	
    }
	
	
	//editar
	@PutMapping("/editar/{profesorId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Profesor profesorNew, @PathVariable Integer profesorId){
    	Profesor profesorDb= profesorService.findById(profesorId);
    	
    	if(profesorDb!=null) {
    		
    		if (sonIguales(profesorDb, profesorNew)) {
                return new ResponseEntity<>("Por favor, realice al menos un cambio en los datos del profesor", HttpStatus.BAD_REQUEST);
            }
    		
    		profesorDb.setNombreProfesor(profesorNew.getNombreProfesor());
    		profesorDb.setApellidoProfesor(profesorNew.getApellidoProfesor());
    		profesorDb.setDniProfesor(profesorNew.getDniProfesor());
    		profesorDb.setTelefonoProfesor(profesorNew.getTelefonoProfesor());
    		profesorService.update(profesorDb);
    		return new ResponseEntity<>("El profesor fue editado correctamente",HttpStatus.OK);
    	}
    	return new ResponseEntity<>("El profesor "+profesorId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }
	
	private boolean sonIguales(Profesor profesorDb, Profesor profesorNew) {
        // Comparar cada campo del estudiante individualmente
        return profesorDb.getNombreProfesor().equals(profesorNew.getNombreProfesor())
                && profesorDb.getApellidoProfesor().equals(profesorNew.getApellidoProfesor())
                && profesorDb.getDniProfesor().equals(profesorNew.getDniProfesor())
                && profesorDb.getTelefonoProfesor().equals(profesorNew.getTelefonoProfesor());
    }
	
	
	//eliminar
	@DeleteMapping("/eliminar/{profesorId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer profesorId){
		Profesor profesorDb= profesorService.findById(profesorId);
    	
    	if(profesorDb!=null) {
    		profesorService.delete(profesorId);
    		return new ResponseEntity<>("El profesor "+profesorDb.getNombreProfesor().toUpperCase()+" "+profesorDb.getApellidoProfesor().toUpperCase()+" ha sido borrado",HttpStatus.OK);
    	}
    	return new ResponseEntity<>("El profesor "+profesorId+" no encontrado",HttpStatus.NOT_FOUND);
    }
	
	
	//buscar
	@GetMapping("/buscar/{profesorId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer profesorId){
		Profesor profesorDb= profesorService.findById(profesorId);
    	
    	if(profesorDb!=null) {
    		return new ResponseEntity<>(profesorDb,HttpStatus.FOUND);
    	}
    	return new ResponseEntity<>("El profesor con ID: "+profesorId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }

}
