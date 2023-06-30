package pe.idat.colegioentity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="carnet_estudiantil")
public class CarnetEstudiantil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carnetId;
	
	@Column
    private Integer numeroCarnet;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    private LocalDate fexpedicion;
	
	@OneToOne
	@JoinColumn(name="estudiante_id",unique=true,nullable=false)
	private Estudiante estudiante;
	

	public CarnetEstudiantil() {
	}


	public CarnetEstudiantil(Integer carnetId, Integer numeroCarnet, LocalDate fexpedicion) {
		this.carnetId = carnetId;
		this.numeroCarnet = numeroCarnet;
		this.fexpedicion = fexpedicion;
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


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	

	
}
