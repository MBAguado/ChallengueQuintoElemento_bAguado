package com.challengueQuintoImpacto.servicios.Implementacion;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Profesor;
import com.challengueQuintoImpacto.repositorios.ProfesorRepositorio;
import com.challengueQuintoImpacto.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
    public List<Profesor> getAllProfesores() {
        return profesorRepositorio.findAll();
    }

    @Override
    public Profesor getProfesorById(long id) {
        return profesorRepositorio.findById(id).get();
    }

    @Override
    public void saveProfesor(Profesor profesor) {
        profesorRepositorio.save(profesor);
    }


    @Override
    public void deleteProfesor(Profesor profesor) {
        try {
            profesorRepositorio.delete(profesor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    };

    @Override
    public Profesor getProfesorByNombre(String nombreProfesor) {
        return profesorRepositorio.findByNombreProfesor(nombreProfesor);
    }
}



