package pe.idat.mapper;

import pe.idat.colegioentity.Curso;

public class CursoMapper {
	
	private Integer cursoId;
	private String nombreCurso;
	private String descripcionCurso;
	private Integer profesorId;
	private String profesorNombre;
	private String profesorApellido;
	
	
	public CursoMapper() {
	}
	
	public CursoMapper(Curso curso) {
		this(curso.getCursoId(),curso.getNombreCurso(),curso.getDescripcionCurso(),curso.getProfesor().getProfesorId(),curso.getProfesor().getNombreProfesor(),curso.getProfesor().getApellidoProfesor());
	}

	public CursoMapper(Integer cursoId, String nombreCurso, String descripcionCurso, Integer profesorId,
			String profesorNombre, String profesorApellido) {
		super();
		this.cursoId = cursoId;
		this.nombreCurso = nombreCurso;
		this.descripcionCurso = descripcionCurso;
		this.profesorId = profesorId;
		this.profesorNombre = profesorNombre;
		this.profesorApellido = profesorApellido;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	public Integer getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Integer profesorId) {
		this.profesorId = profesorId;
	}

	public String getProfesorNombre() {
		return profesorNombre;
	}

	public void setProfesorNombre(String profesorNombre) {
		this.profesorNombre = profesorNombre;
	}

	public String getProfesorApellido() {
		return profesorApellido;
	}

	public void setProfesorApellido(String profesorApellido) {
		this.profesorApellido = profesorApellido;
	}
	
	
	
}
