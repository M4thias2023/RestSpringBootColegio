package pe.idat.colegioentity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.PostPersist;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer estudianteId;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column
	private Integer dni;
	
	@Column
	private Integer telefono;

	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fnacimiento;
	
	@Column
	private String deporte_favorito;
	
	public void addActividad(ActividadExtracurricular actividad) {
		itemsActividad.add(actividad);
	}
	
	
	public Estudiante() {
	}

	public Estudiante(Integer estudianteId, String nombre, String apellido, String deporte_favorito,LocalDate fnacimiento, Integer telefono, Integer dni ) {
		this.estudianteId = estudianteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fnacimiento = fnacimiento;
		this.telefono = telefono;
		this.deporte_favorito = deporte_favorito;
	}
	
	
	@ManyToMany
	@JoinTable(name="Inscripcion",
	joinColumns=@JoinColumn(name="estudianteId"),
	inverseJoinColumns=@JoinColumn(name="actividadId"))
	@JsonIgnore
	private Set<ActividadExtracurricular> itemsActividad= new HashSet<>();
	
	
	@OneToOne(mappedBy="estudiante")
	@JsonIgnore
	private CarnetEstudiantil carnetEstudiantil;
	
	
	@PostPersist
	public void PostPersist() {
		fnacimiento = LocalDate.now();
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

	public CarnetEstudiantil getCarnetEstudiantil() {
		return carnetEstudiantil;
	}

	public void setCarnetEstudiantil(CarnetEstudiantil carnetEstudiantil) {
		this.carnetEstudiantil = carnetEstudiantil;
	}

	public Set<ActividadExtracurricular> getItemsActividad() {
		return itemsActividad;
	}

	public void setItemsActividad(Set<ActividadExtracurricular> itemsActividad) {
		this.itemsActividad = itemsActividad;
	}

}
