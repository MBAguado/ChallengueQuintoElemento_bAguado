package com.challengueQuintoImpacto.modelos;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private Set<Alumno> listaAlumnos = new HashSet<>();

    @OneToOne
    private Profesor profesor;
    private NombreCurso nombre;
    private String turno;
    private String horario;

    private String descripcion;


    public Curso() {
    }

    public Curso(NombreCurso nombre, Profesor profesor, String turno, String horario, String descripcion) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.turno = turno;
        this.horario = horario;
        this.descripcion = descripcion;

    }

    public Curso(NombreCurso nombre, Profesor profesor, String turno, String horario) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.turno = turno;
        this.horario = horario;

    }

    public long getId() {
        return id;
    }


    public Set<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }


    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public NombreCurso getNombreCurso() {
        return nombre;
    }

    public void agregarAlumno(Alumno alumno) {
        this.listaAlumnos.add(alumno);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}