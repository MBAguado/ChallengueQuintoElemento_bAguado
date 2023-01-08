package com.challengueQuintoImpacto.controladores;

import com.challengueQuintoImpacto.dtos.AlumnosDTO;
import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.modelos.NombreCurso;
import com.challengueQuintoImpacto.modelos.Profesor;
import com.challengueQuintoImpacto.servicios.AlumnoServicio;
import com.challengueQuintoImpacto.servicios.CursoServicio;
import com.challengueQuintoImpacto.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio alumnoServicio;

    @Autowired
    private ProfesorServicio profesorRepositorio;
    @Autowired
    private CursoServicio cursoRepositorio;

    @GetMapping("/api/alumno/{id}")
    public AlumnosDTO getAlumnos(@PathVariable Long id) {
        return new AlumnosDTO(alumnoServicio.getAlumnoById(id));
    }

    @GetMapping ("/api/alumno")
    public List<AlumnosDTO> getAlumnos(){
        return alumnoServicio.getAllALumnos().stream().map(alumno -> new AlumnosDTO(alumno)).collect(toList());
    }


//Registrar alumno: OK
    @PostMapping("/api/alumno/registrarAlumno")
    public ResponseEntity<Object> registrarAlumno(@RequestParam String nombre, @RequestParam int edad, @RequestParam LocalDate fechaNacimiento, @RequestParam String historia) {

        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Introduce tu nombre", HttpStatus.FORBIDDEN);
        }
        if (edad <= 0) {
            return new ResponseEntity<>("Debes ingresar tu edad", HttpStatus.FORBIDDEN);
        }
        if (fechaNacimiento == null) {
            return new ResponseEntity<>("Introduce tu fecha de nacimiento", HttpStatus.FORBIDDEN);
        }

        if (historia.isEmpty()) {
            return new ResponseEntity<>("Introduce tu historia", HttpStatus.FORBIDDEN);
        }

        Profesor profesor11 = new Profesor("Pedro","Perez", NombreCurso.JAVA);
        profesorRepositorio.saveProfesor((profesor11));

        Curso curso11 = new Curso (NombreCurso.JAVA,profesor11, "mañana", "13hs");
        cursoRepositorio.saveCurso(curso11);

        Alumno alumnoRegistrado = new Alumno(nombre, edad, fechaNacimiento, historia,curso11,profesor11);
        alumnoServicio.saveAlumno(alumnoRegistrado);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//Modificar el nombre a un alumno: OK
    @PutMapping (path = "api/alumno/nombre/{id}")
    public ResponseEntity<Object> modificarNombreAlumno(@RequestParam String nombre, @PathVariable Long id){

        Alumno alumnoModificar = alumnoServicio.getAlumnoById(id);

        if (nombre.isEmpty()){
            return new ResponseEntity<>("Por favor, ingrese el nombre antes de modificar.", HttpStatus.FORBIDDEN);
        }
        alumnoModificar.setNombre(nombre);
        alumnoServicio.saveAlumno(alumnoModificar);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Eliminar un alumno: OK
    @DeleteMapping("/api/alumno")
    public ResponseEntity<Object> borrarAlumno(@RequestParam String nombre){

        if(nombre.isEmpty()) {
            return new ResponseEntity<>("Seleccione un alumno para borrar", HttpStatus.FORBIDDEN);
        }
        Alumno alumnoABorrar = alumnoServicio.getAlumnoByNombre(nombre);

            alumnoServicio.deleteAlumno(alumnoABorrar);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}