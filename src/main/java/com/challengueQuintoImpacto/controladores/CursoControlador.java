package com.challengueQuintoImpacto.controladores;

import com.challengueQuintoImpacto.dtos.AlumnosDTO;
import com.challengueQuintoImpacto.dtos.CursoDTO;
import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.modelos.NombreCurso;
import com.challengueQuintoImpacto.modelos.Profesor;
import com.challengueQuintoImpacto.servicios.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
public class CursoControlador {

    @Autowired
    private CursoServicio cursoServicio;


    @GetMapping("/api/curso/{id}")
    public CursoDTO getCurso(@PathVariable Long id){
        return new CursoDTO(cursoServicio.getCursoById(id));
    }

    @GetMapping ("/api/curso")
    public List<CursoDTO> getCurso(){
        return cursoServicio.getAllCursos().stream().map(curso -> new CursoDTO(curso)).collect(toList());
    }

    //Crear curso nuevo:
    @PostMapping("/api/curso/registrarCurso")
    public ResponseEntity<Object> registrarCurso(@RequestParam NombreCurso nombreCurso, @RequestParam Profesor profesor, @RequestParam String turno, @RequestParam String horario){

        if(nombreCurso == null){
            return new ResponseEntity<>("Introduce el nombre curso a realizar", HttpStatus.FORBIDDEN);
        }

        if (turno.isEmpty()){
            return new ResponseEntity<>("Seleccione el turno del curso", HttpStatus.FORBIDDEN);
        }
        if (horario.isEmpty()){
            return new ResponseEntity<>("Completa el horario del curso", HttpStatus.FORBIDDEN);
        }

        Curso CursoARegistrar = new Curso(nombreCurso, profesor, turno, horario);
        cursoServicio.saveCurso((CursoARegistrar));

        return new ResponseEntity<>(HttpStatus.CREATED);}

    //Modificar un Curso:
   // @RequestMapping (path = "/api/curso", method = RequestMethod.PATCH)
   // public ResponseEntity<Object> modificarCurso(@RequestParam NombreCurso nombreCurso, String turno, String horario ) {

   //     Curso modificarCurso = cursoServicio.getCursoByNombre(nombreCurso);
    //    if (nombreCurso == null){
     //       return new ResponseEntity<>("Indique el curso a eliminar", HttpStatus.FORBIDDEN);
     //   }
     //  modificarCurso.setNombreCurso(nombreCurso);
     //   cursoServicio.saveCurso(modificarCurso);

     //   return new ResponseEntity<>(HttpStatus.CREATED);
   // }

    //Eliminar un curso existente:

/*  @DeleteMapping("/api/curso")
    public ResponseEntity<Object> borrarCurso(@RequestParam String nombreCurso){
        if(nombreCurso.isEmpty()){
            return new ResponseEntity<>("Seleccione el curso a borrar", HttpStatus.FORBIDDEN);
        }
        Curso cursoABorrar = cursoServicio.
  }*/

}
