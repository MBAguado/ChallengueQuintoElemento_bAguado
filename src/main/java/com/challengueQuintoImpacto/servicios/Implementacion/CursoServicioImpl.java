package com.challengueQuintoImpacto.servicios.Implementacion;

import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.repositorios.CursoRepositorio;
import com.challengueQuintoImpacto.servicios.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoServicioImpl implements CursoServicio {

    @Autowired
    CursoRepositorio cursoRepositorio;


    @Override
    public Curso getCursoById(long id) {
        return cursoRepositorio.findById(id).get();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepositorio.save(curso);
    }

    @Override
    public List<Curso> getAllCursos(){

     return cursoRepositorio.findAll();
    }
}