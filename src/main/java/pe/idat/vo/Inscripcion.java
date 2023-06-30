package pe.idat.vo;

import pe.idat.colegioentity.ActividadExtracurricular;
import pe.idat.colegioentity.Estudiante;

public class Inscripcion {
	
	private Estudiante estudiante;
	private ActividadExtracurricular actividad;
	
	
	public Inscripcion() {
		
	}


	public Inscripcion(Estudiante estudiante, ActividadExtracurricular actividad) {
		super();
		this.estudiante = estudiante;
		this.actividad = actividad;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public ActividadExtracurricular getActividad() {
		return actividad;
	}


	public void setActividad(ActividadExtracurricular actividad) {
		this.actividad = actividad;
	}
	
	

}
