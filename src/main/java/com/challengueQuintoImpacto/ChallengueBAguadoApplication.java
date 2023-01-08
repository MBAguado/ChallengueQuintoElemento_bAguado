package com.challengueQuintoImpacto;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.modelos.NombreCurso;
import com.challengueQuintoImpacto.modelos.Profesor;
import com.challengueQuintoImpacto.repositorios.AlumnoRepositorio;
import com.challengueQuintoImpacto.repositorios.CursoRepositorio;
import com.challengueQuintoImpacto.repositorios.ProfesorRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ChallengueBAguadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengueBAguadoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (AlumnoRepositorio alumnoRepositorio, CursoRepositorio cursoRepositorio, ProfesorRepositorio profesorRepositorio){
		return (args) -> {


			Profesor profesor1 = new Profesor("Pedro","Perez", NombreCurso.JAVA);
			Curso curso1 = new Curso (NombreCurso.JAVA,profesor1, "mañana", "13hs", "Aprende con el mejor curso Java de cero con las mejores prácticas POO, Java EE 9, CDI, JPA, EJB, JSF, Web Services, JAAS");
			Alumno alumno1 = new Alumno("juan", 23, LocalDate.of(1988,10,19),"secundario finalizado",curso1,profesor1);
			Alumno alumno4 = new Alumno("Marcos", 42, LocalDate.of(1986,11,12),"secundario finalizado",curso1,profesor1);
			Alumno alumno5 = new Alumno("Maria", 24, LocalDate.of(1996,12,14),"secundario finalizado",curso1,profesor1);

			curso1.agregarAlumno(alumno1);
			alumno1.setCurso(curso1);
			alumno1.setProfesor(profesor1);
			profesor1.agregarAlumno(alumno1);

			curso1.agregarAlumno(alumno4);
			alumno4.setCurso(curso1);
			alumno4.setProfesor(profesor1);
			profesor1.agregarAlumno(alumno4);

			curso1.agregarAlumno(alumno5);
			alumno5.setCurso(curso1);
			alumno5.setProfesor(profesor1);
			profesor1.agregarAlumno(alumno5);



			profesorRepositorio.save((profesor1));
			cursoRepositorio.save(curso1);
			alumnoRepositorio.save(alumno1);
			alumnoRepositorio.save(alumno4);
			alumnoRepositorio.save(alumno5);


			Profesor profesor2 = new Profesor("Susana","Cabrera", NombreCurso.CSS);
			Curso curso2 = new Curso (NombreCurso.CSS,profesor2, "tarde", "11hs", "Aprende CSS, sin conocimientos previos. Conoce todo sobre esta semántica, CSS, como dar estilos a tu sitio web.");
			Alumno alumno2 = new Alumno("Franco", 21, LocalDate.of(1988,11,19),"secundario sin finalizar", curso2, profesor2);
			Alumno alumno6 = new Alumno("Marta", 28, LocalDate.of(1976,10,22),"secundario sin finalizar", curso2, profesor2);


			curso2.agregarAlumno(alumno2);
			curso2.agregarAlumno(alumno1);
			alumno2.setCurso(curso2);
			alumno2.setCurso(curso1);
			alumno1.setCurso(curso2);
			alumno2.setProfesor(profesor2);
			profesor2.agregarAlumno(alumno2);

			curso2.agregarAlumno(alumno6);
			alumno6.setCurso(curso2);
			alumno6.setProfesor(profesor2);
			profesor2.agregarAlumno(alumno6);

			profesorRepositorio.save((profesor2));
			cursoRepositorio.save(curso2);
			alumnoRepositorio.save(alumno2);
			alumnoRepositorio.save(alumno6);

			Profesor profesor3 = new Profesor("Hernan","Saz", NombreCurso.HTML);
			Curso curso3 = new Curso (NombreCurso.HTML,profesor3, "Tarde", "17hs","Aprende HTML y CSS desde cero, sin conocimientos previos. Conoce todo sobre etiquetas HTML.");
			Alumno alumno3 = new Alumno("Rodrigo", 33, LocalDate.of(1988,10,19),"secundario finalizado",curso3,profesor3);


			curso3.agregarAlumno(alumno3);
			alumno3.setCurso(curso3);
			alumno3.setProfesor(profesor3);
			profesor3.agregarAlumno(alumno3);
			profesorRepositorio.save((profesor3));
			cursoRepositorio.save(curso3);
			alumnoRepositorio.save(alumno3);



		};
	}
}
