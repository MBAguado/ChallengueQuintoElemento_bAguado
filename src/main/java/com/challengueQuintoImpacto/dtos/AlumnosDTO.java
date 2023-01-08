package com.challengueQuintoImpacto.dtos;


import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.NombreCurso;
import com.challengueQuintoImpacto.modelos.Profesor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class AlumnosDTO {
    private long id;
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private String historia;

    private NombreCurso cursos;


    public AlumnosDTO() {
    }

    public AlumnosDTO(Alumno alumno) {
        this.id = alumno.getId();
        this.nombre = alumno.getNombre();
        this.edad = alumno.getEdad();
        this.fechaNacimiento = alumno.getFechaNacimiento();
        this.historia = alumno.getHistoria();
        this.cursos= alumno.getCurso().getNombreCurso();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getHistoria() {
        return historia;
    }

    public NombreCurso getCursos() {
        return cursos;
    }
}