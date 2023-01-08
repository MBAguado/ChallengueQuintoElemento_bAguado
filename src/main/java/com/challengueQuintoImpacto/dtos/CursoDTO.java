package com.challengueQuintoImpacto.dtos;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Curso;

import com.challengueQuintoImpacto.modelos.NombreCurso;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CursoDTO {
    private Long id;
    private NombreCurso nombre;
    private String profesor;
    private String turno;
    private String horario;
    private Set<AlumnosDTO> listaAlumnos ;

    private String descripcion;

    public CursoDTO() {
    }

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nombre = curso.getNombreCurso();
        this.turno = curso.getTurno();
        this.horario = curso.getHorario();
        this.listaAlumnos = curso.getListaAlumnos().stream().map(listaAlumno-> new AlumnosDTO(listaAlumno)).collect(Collectors.toSet());
        this.profesor=curso.getProfesor().getNombreProfesor() + " " + curso.getProfesor().getApellidoProfesor() ;
        this.descripcion = curso.getDescripcion();
    }

    public NombreCurso getCurso() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getTurno() {
        return turno;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getId() {
        return id;

    }

    public NombreCurso getNombre() {
        return nombre;
    }

    public Set<AlumnosDTO> getListaAlumnos() {
        return listaAlumnos;
    }
}
