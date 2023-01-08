package com.challengueQuintoImpacto.controladores;

import com.challengueQuintoImpacto.dtos.CursoDTO;
import com.challengueQuintoImpacto.dtos.ProfesorDTO;
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

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ProfesorControlador {

    @Autowired
    private ProfesorServicio profesorServicio;



    @GetMapping("/api/profesor/{id}")
    public ProfesorDTO getProfesor(@PathVariable Long id){
        return new ProfesorDTO(profesorServicio.getProfesorById(id));
    }

    @GetMapping ("/api/profesor")
    public List<ProfesorDTO> getProfesor(){
        return profesorServicio.getAllProfesores().stream().map(profesor -> new ProfesorDTO(profesor)).collect(toList());
    }


//Registrar un profesor: ok
    @PostMapping("/api/profesor/registrarProfesor")
    public ResponseEntity<Object> registrarProfesor(@RequestParam String nombreProfesor,@RequestParam String apellidoProfesor,@RequestParam String nombreCurso) {

        if (nombreProfesor.isEmpty()) {
            return new ResponseEntity<>("Introduce tu nombre Profesor", HttpStatus.FORBIDDEN);
        }
        if (apellidoProfesor.isEmpty()) {
            return new ResponseEntity<>("Introduce tu apellido Profesor", HttpStatus.FORBIDDEN);
        }
        Profesor profesorARegistrar= new Profesor(nombreProfesor, apellidoProfesor, NombreCurso.valueOf(nombreCurso));
        profesorServicio.saveProfesor(profesorARegistrar);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //Borrar un profesor: ok

    @DeleteMapping("/api/profesor")
    public ResponseEntity<Object> borrarProfesor(@RequestParam String nombreProfesor){

        if(nombreProfesor.isEmpty()){
            return new ResponseEntity<>("Seleccione profesor a borrar", HttpStatus.FORBIDDEN);
        }
        Profesor profesorABorrar = profesorServicio.getProfesorByNombre(nombreProfesor);

      profesorServicio.deleteProfesor(profesorABorrar);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    //Modificar un profesor: ok
    @PutMapping (path ="/api/profesor/nombreProfesor/{id}")
    public ResponseEntity<Object> modificarProfesor(@PathVariable Long id, @RequestParam String nombreProfesor){
        Profesor profesorModificar = profesorServicio.getProfesorById(id);

        if (nombreProfesor.isEmpty()){
            return new ResponseEntity<>("Por favor, ingrese el nombre del Profesor antes de modificar.", HttpStatus.FORBIDDEN);
        }
        profesorModificar.setNombreProfesor(nombreProfesor);
        profesorServicio.saveProfesor(profesorModificar);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}


