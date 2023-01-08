package com.challengueQuintoImpacto.modelos;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;

    @ManyToOne
    private Curso curso = new Curso();

    @ManyToOne
    private Profesor profesor = new Profesor();

    private String nombre;

    private int edad;
    private LocalDate fechaNacimiento;

    private String historia;


    public Alumno() {
    }

    public Alumno(String nombre, int edad, LocalDate fechaNacimiento, String historia, Curso curso, Profesor profesor){

        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.historia = historia;
        this.curso = curso;
        this.profesor = profesor;
    }

    public Alumno(String nombre, LocalDate fechaNacimiento, String historia, Curso curso, Profesor profesor){

        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.historia = historia;
        this.curso = curso;
        this.profesor = profesor;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Curso getCurso() {
        return curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }



}

