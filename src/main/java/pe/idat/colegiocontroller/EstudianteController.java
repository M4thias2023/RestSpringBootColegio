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
import pe.idat.colegioentity.Estudiante;
import pe.idat.colegioservice.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
    private EstudianteService estudianteService;
	
	
	public EstudianteController() {
		
	}

	//listar
    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Estudiante> collection=estudianteService.findAll();
        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection,HttpStatus.OK);
    }
    
    
    //registrar
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Estudiante estudiante){
    	
    	int isExist=estudianteService.isExistName(estudiante.getNombre());
    	
    	if(isExist==0) {
    		
    		estudianteService.insert(estudiante);
            return new ResponseEntity<>("Estudiante creado correctamente",HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<>("El estudiante "+estudiante.getNombre().toUpperCase()+" "+estudiante.getApellido().toUpperCase()+" ya existe",HttpStatus.CONFLICT);
        
    }
    
    
    //editar
    @PutMapping("/editar/{estudianteId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Estudiante estudianteNew, @PathVariable Integer estudianteId){
    	Estudiante estudianteDb= estudianteService.findById(estudianteId);
    	
    	if(estudianteDb!=null) {
    		
    		// Verificar si el nombre del estudiante ya existe
    		if (sonIguales(estudianteDb, estudianteNew)) {
                return new ResponseEntity<>("Por favor, realice al menos un cambio en los datos del estudiante", HttpStatus.BAD_REQUEST);
            }
            estudianteDb.setNombre(estudianteNew.getNombre());
    		estudianteDb.setApellido(estudianteNew.getApellido());
    		estudianteDb.setDni(estudianteNew.getDni());
    		estudianteDb.setFnacimiento(estudianteNew.getFnacimiento());
    		estudianteDb.setTelefono(estudianteNew.getTelefono());
    		estudianteDb.setDeporte_favorito(estudianteNew.getDeporte_favorito());
    		estudianteService.update(estudianteDb);
    		return new ResponseEntity<>("Estudiante editado correctamente",HttpStatus.OK);
            }
    		
    	return new ResponseEntity<>("El estudiante "+estudianteId+" no encontrado",HttpStatus.NOT_FOUND);
    }
    
    private boolean sonIguales(Estudiante estudianteDb, Estudiante estudianteNew) {
        // Comparar cada campo del estudiante individualmente
        return estudianteDb.getNombre().equals(estudianteNew.getNombre())
                && estudianteDb.getApellido().equals(estudianteNew.getApellido())
                && estudianteDb.getDni().equals(estudianteNew.getDni())
                && estudianteDb.getFnacimiento().equals(estudianteNew.getFnacimiento())
                && estudianteDb.getTelefono().equals(estudianteNew.getTelefono())
                && estudianteDb.getDeporte_favorito().equals(estudianteNew.getDeporte_favorito());
    }
    
    
    
    //eliminar
    @DeleteMapping("/eliminar/{estudianteId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer estudianteId){
    	Estudiante estudianteDb=estudianteService.findById(estudianteId);
    	
    	if(estudianteDb!=null) {
    		estudianteService.delete(estudianteId);
    		return new ResponseEntity<>("El estudiante "+estudianteDb.getNombre().toUpperCase()+" "+estudianteDb.getApellido().toUpperCase()+" ha sido borrado",HttpStatus.OK);
    	}
    	return new ResponseEntity<>("El estudiante "+estudianteId+" no encontrado",HttpStatus.NOT_FOUND);
    }
    
    //buscar
    @GetMapping("/buscar/{estudianteId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer estudianteId){
    	Estudiante estudianteDb=estudianteService.findById(estudianteId);
    	
    	if(estudianteDb!=null) {
    		return new ResponseEntity<>(estudianteDb,HttpStatus.FOUND);
    	}
    	return new ResponseEntity<>("El estudiante con ID: "+estudianteId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }

}
