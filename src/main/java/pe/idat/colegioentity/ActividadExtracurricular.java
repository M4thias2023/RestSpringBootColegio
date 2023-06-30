package pe.idat.colegioentity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="actividad")
public class ActividadExtracurricular implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer actividadId;
	
	@Column(unique = true, nullable = false)
	private String nombreActividad;
	
	@Column
	private String descripcionActividad;
	
	@ManyToMany(mappedBy="itemsActividad")
	@JsonIgnore
	private Set<Estudiante> itemsEstudiante = new HashSet<>();
	
	public void addEstudiante(Estudiante estudiante) {
		itemsEstudiante.add(estudiante);
	}
	
	
	public ActividadExtracurricular() {
	}

	public ActividadExtracurricular(Integer actividadId, String nombreActividad, String descripcionActividad) {
		super();
		this.actividadId = actividadId;
		this.nombreActividad = nombreActividad;
		this.descripcionActividad = descripcionActividad;
	}

	public Integer getActividadId() {
		return actividadId;
	}

	public void setActividadId(Integer actividadId) {
		this.actividadId = actividadId;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public Set<Estudiante> getItemsEstudiante() {
		return itemsEstudiante;
	}

	public void setItemsEstudiante(Set<Estudiante> itemsEstudiante) {
		this.itemsEstudiante = itemsEstudiante;
	}
	
	

}
