package com.challengueQuintoImpacto.servicios;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Curso;

import java.util.List;

public interface AlumnoServicio {

    public List<Alumno> getAllALumnos();
    public Alumno getAlumnoById(long id);
    public void saveAlumno(Alumno alumno);
    public void deleteAlumno(Alumno alumno);
    public Alumno getAlumnoByNombre(String nombre);
}
