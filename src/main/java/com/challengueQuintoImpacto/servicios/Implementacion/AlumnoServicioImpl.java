package com.challengueQuintoImpacto.servicios.Implementacion;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.repositorios.AlumnoRepositorio;
import com.challengueQuintoImpacto.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicioImpl implements AlumnoServicio {

    @Autowired
    AlumnoRepositorio alumnoRepositorio;


    @Override
    public List<Alumno> getAllALumnos() {
        return alumnoRepositorio.findAll();
    }

    @Override
    public Alumno getAlumnoById(long id) {
        return alumnoRepositorio.findById(id);
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepositorio.save(alumno);
    }
    @Override
    public void deleteAlumno(Alumno alumno) {
      try{
          alumnoRepositorio.delete(alumno);
      }
      catch(Exception e ){
          System.out.println(e.getMessage());
      }
    }

    @Override
    public Alumno getAlumnoByNombre(String nombre){
        return alumnoRepositorio.findByNombre(nombre);
    }
}