package com.challengueQuintoImpacto.dtos;

import com.challengueQuintoImpacto.modelos.NombreCurso;
import com.challengueQuintoImpacto.modelos.Profesor;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfesorDTO {
    private long id;

    private String nombreProfesor;

    private String apellidoProfesor;

    private NombreCurso nombreCurso;

    private Set<AlumnosDTO> listaAlumnos;

    public ProfesorDTO() {
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.nombreProfesor = profesor.getNombreProfesor();
        this.apellidoProfesor = profesor.getApellidoProfesor();
        this.nombreCurso = profesor.getNombreCurso();
        this.listaAlumnos = profesor.getListaAlumnos().stream().map(listaAlumno-> new AlumnosDTO(listaAlumno)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public NombreCurso getListaCursos() {
        return nombreCurso;
    }

    public Set<AlumnosDTO> getListaAlumnos() {
        return listaAlumnos;
    }


}
