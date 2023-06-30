package pe.idat.mapper;

import java.time.LocalDate;

import pe.idat.colegioentity.Estudiante;

public class EstudianteMapper {

	private Integer estudianteId;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer telefono;
	private LocalDate fnacimiento;
	private String deporte_favorito;
	private Integer carnetEstudiantil;

	public EstudianteMapper() {
	}

	public EstudianteMapper(Estudiante estudiante) {
	    this(estudiante.getEstudianteId(), estudiante.getNombre(), estudiante.getApellido(),
	            estudiante.getDni(), estudiante.getTelefono(), estudiante.getFnacimiento(),
	            estudiante.getDeporte_favorito(), estudiante.getCarnetEstudiantil().getCarnetId());
	}

	public EstudianteMapper(Integer estudianteId, String nombre, String apellido, Integer dni,
			Integer telefono, LocalDate fnacimiento, String deporte_favorito, Integer carnetEstudiantil) {

		this.estudianteId = estudianteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.fnacimiento = fnacimiento;
		this.deporte_favorito = deporte_favorito;
		this.carnetEstudiantil = carnetEstudiantil;
	}

	public Integer getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getDeporte_favorito() {
		return deporte_favorito;
	}

	public void setDeporte_favorito(String deporte_favorito) {
		this.deporte_favorito = deporte_favorito;
	}

	public Integer getCarnetEstudiantil() {
		return carnetEstudiantil;
	}

	public void setCarnetEstudiantil(Integer carnetEstudiantil) {
		this.carnetEstudiantil = carnetEstudiantil;
	}

}
