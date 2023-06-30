package pe.idat.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.idat.colegioentity.CarnetEstudiantil;
import pe.idat.colegioentity.Curso;
import pe.idat.mapper.CarnetMapper;
import pe.idat.mapper.CursoMapper;

public class Mapper {
	
	
	public static Collection<CarnetMapper> toCarnet(Collection<CarnetEstudiantil> carnets){
		Collection<CarnetMapper> collection = new ArrayList<>();
		
		for(CarnetEstudiantil carnet:carnets) {
			CarnetMapper mapper = new CarnetMapper(carnet);
			collection.add(mapper);
		}
		return collection;
	}
	
	
	public static Collection<CursoMapper> toCursos(Collection<Curso> cursos){
		Collection<CursoMapper> collection = new ArrayList<>();
		
		for(Curso curso:cursos) {
			CursoMapper mapper = new CursoMapper(curso);
			collection.add(mapper);
		}
		return collection;
	}
	
}
