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
import pe.idat.colegioentity.CarnetEstudiantil;
import pe.idat.colegioentity.Estudiante;
import pe.idat.colegioservice.CarnetService;
import pe.idat.colegioservice.EstudianteService;
import pe.idat.util.Mapper;

@RestController
@RequestMapping("/carnet")
public class CarnetController {
	
	@Autowired
	private CarnetService carnetService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	//listar
	@GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<CarnetEstudiantil> collection=carnetService.findAll();
        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Mapper.toCarnet(collection),HttpStatus.OK);
    }
	
	//registrar
	@PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody CarnetEstudiantil carnet){
    	
    	int isExist=carnetService.isExistNum(carnet.getNumeroCarnet());
    	
    	if(isExist==0) {
    		carnetService.insert(carnet);
            return new ResponseEntity<>("Carnet creado correctamente",HttpStatus.CREATED);
    	}
    	
    	return new ResponseEntity<>("El carnet de número: "+carnet.getCarnetId()+" ya existe",HttpStatus.CONFLICT);
        
    }
	
	
	//editar
	@PutMapping("/editar/{carnetId}")
    public ResponseEntity<?> editar_PUT(@RequestBody CarnetEstudiantil carnetNew, @PathVariable Integer carnetId){
    	CarnetEstudiantil carnetDb= carnetService.findById(carnetId);
    	
    	if(carnetDb==null) {		
    		return new ResponseEntity<>("El curso con ID " + carnetId + " no encontrado",HttpStatus.NOT_FOUND);
    	}
    	
    	if (sonIguales(carnetDb, carnetNew)) {
            return ResponseEntity.badRequest().body("Por favor, realice al menos un cambio en los datos del carnet estudiantil");
        }
    	
    	Integer estudianteId = carnetNew.getEstudiante().getEstudianteId();
        Estudiante estudianteDb = estudianteService.findById(estudianteId);
        if (estudianteDb == null) {
            return ResponseEntity.badRequest().body("El estudiante con ID " + estudianteId + " no existe");
        }

        carnetDb.setNumeroCarnet(carnetNew.getNumeroCarnet());
        carnetDb.setFexpedicion(carnetNew.getFexpedicion());
        carnetDb.setEstudiante(carnetNew.getEstudiante());

        carnetService.update(carnetDb);
        return ResponseEntity.ok("El carnet fue editado correctamente");
    }
    
    private boolean sonIguales(CarnetEstudiantil carnetDb, CarnetEstudiantil carnetNew) {
        // Comparar cada campo del estudiante individualmente
        return carnetDb.getNumeroCarnet().equals(carnetNew.getNumeroCarnet())
                && carnetDb.getFexpedicion().equals(carnetNew.getFexpedicion())
                && carnetDb.getEstudiante().getEstudianteId().equals(carnetNew.getCarnetId());
    }
    
    
    //eliminar
    @DeleteMapping("/eliminar/{carnetId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer carnetId){
    	CarnetEstudiantil carnetDb=carnetService.findById(carnetId);
    	
    	if(carnetDb!=null) {
    		carnetService.delete(carnetId);
    		return new ResponseEntity<>("El carnet "+carnetDb.getNumeroCarnet()+" del estudiante "+carnetDb.getEstudiante().getNombre()+" "+ carnetDb.getEstudiante().getApellido()+" ha sido borrado",HttpStatus.OK);
    	}
    	return new ResponseEntity<>("Carnet "+carnetId+" no encontrado",HttpStatus.NOT_FOUND);
    }
    
    //buscar
    @GetMapping("/buscar/{carnetId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer carnetId){
    	CarnetEstudiantil carnetDb=carnetService.findById(carnetId);
    	
    	if(carnetDb!=null) {
    		return new ResponseEntity<>(carnetDb,HttpStatus.FOUND);
    	}
    	return new ResponseEntity<>("El carnet de ID: "+carnetId+" no fue encontrado",HttpStatus.NOT_FOUND);
    }

}
