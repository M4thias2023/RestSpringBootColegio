package pe.idat.colegioentity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profesorId;
	
	@Column
    private String nombreProfesor;
	
	@Column
    private String apellidoProfesor;
	
	@Column
    private Integer telefonoProfesor;
	
	@Column(nullable=false)
    private Integer dniProfesor;

	@OneToMany(mappedBy="profesor")
	@JsonIgnore
	private Collection<Curso> itemsCurso = new ArrayList<>();
	
	public Profesor() {
	}

	public Profesor(Integer profesorId, String nombreProfesor, String apellidoProfesor, Integer telefonoProfesor,
			Integer dniProfesor) {
		this.profesorId = profesorId;
		this.nombreProfesor = nombreProfesor;
		this.apellidoProfesor = apellidoProfesor;
		this.telefonoProfesor = telefonoProfesor;
		this.dniProfesor = dniProfesor;
	}

	public Integer getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Integer profesorId) {
		this.profesorId = profesorId;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getApellidoProfesor() {
		return apellidoProfesor;
	}

	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}

	public Integer getTelefonoProfesor() {
		return telefonoProfesor;
	}

	public void setTelefonoProfesor(Integer telefonoProfesor) {
		this.telefonoProfesor = telefonoProfesor;
	}

	public Integer getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(Integer dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	public Collection<Curso> getItemsCurso() {
		return itemsCurso;
	}

	public void setItemsCurso(Collection<Curso> itemsCurso) {
		this.itemsCurso = itemsCurso;
	}

	

}
