package com.challengueQuintoImpacto.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profesor {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private long id;

        @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
        private Set<Alumno> listaAlumnos = new HashSet<>();

        @OneToOne
        private Curso curso;
        private String nombreProfesor;

        private String apellidoProfesor;
        private NombreCurso nombreCurso;

        public Profesor() {
        }
        public Profesor( String nombreProfesor, String apellidoProfesor, NombreCurso nombreCurso) {

            this.nombreProfesor = nombreProfesor;
            this.apellidoProfesor = apellidoProfesor;
            this.nombreCurso = nombreCurso;
        }

    public long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public Set<Alumno> getAlumno() {
        return listaAlumnos;
    }

    public Set<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setAlumno(Set<Alumno> alumnos) {
        this.listaAlumnos = alumnos;
    }
public void agregarAlumno(Alumno alumno){
            this.listaAlumnos.add(alumno);
}

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public NombreCurso getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(NombreCurso nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
