package pe.idat.mapper;

import java.time.LocalDate;

import pe.idat.colegioentity.CarnetEstudiantil;

public class CarnetMapper {

	private Integer carnetId;
	private Integer numeroCarnet;
	private LocalDate fexpedicion;
	private Integer estudianteId;
	private String estudianteNombre;
	private String estudianteApellido;
	
	
	public CarnetMapper() {
	}
	
	public CarnetMapper(CarnetEstudiantil carnet) {
		this(carnet.getCarnetId(),carnet.getNumeroCarnet(),carnet.getFexpedicion(),carnet.getEstudiante().getEstudianteId(), carnet.getEstudiante().getNombre(),carnet.getEstudiante().getApellido());
	}


	public CarnetMapper(Integer carnetId, Integer numeroCarnet, LocalDate fexpedicion, Integer estudianteId,
			String estudianteNombre, String estudianteApellido) {
		super();
		this.carnetId = carnetId;
		this.numeroCarnet = numeroCarnet;
		this.fexpedicion = fexpedicion;
		this.estudianteId = estudianteId;
		this.estudianteNombre = estudianteNombre;
		this.estudianteApellido = estudianteApellido;
	}

	public Integer getCarnetId() {
		return carnetId;
	}

	public void setCarnetId(Integer carnetId) {
		this.carnetId = carnetId;
	}

	public Integer getNumeroCarnet() {
		return numeroCarnet;
	}

	public void setNumeroCarnet(Integer numeroCarnet) {
		this.numeroCarnet = numeroCarnet;
	}

	public LocalDate getFexpedicion() {
		return fexpedicion;
	}

	public void setFexpedicion(LocalDate fexpedicion) {
		this.fexpedicion = fexpedicion;
	}

	public Integer getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
	}

	public String getEstudianteNombre() {
		return estudianteNombre;
	}

	public void setEstudianteNombre(String estudianteNombre) {
		this.estudianteNombre = estudianteNombre;
	}

	public String getEstudianteApellido() {
		return estudianteApellido;
	}

	public void setEstudianteApellido(String estudianteApellido) {
		this.estudianteApellido = estudianteApellido;
	}

	
	
	
	
}
