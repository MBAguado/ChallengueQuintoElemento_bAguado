package com.challengueQuintoImpacto.servicios;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.modelos.Profesor;

import java.util.List;

public interface ProfesorServicio {
    public List<Profesor> getAllProfesores();
    public Profesor getProfesorById(long id);
    public void saveProfesor(Profesor profesor);
    public Profesor getProfesorByNombre(String nombreProfesor);

    public void deleteProfesor(Profesor profesor);
}
