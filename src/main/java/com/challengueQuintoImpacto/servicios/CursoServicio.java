package com.challengueQuintoImpacto.servicios;

import com.challengueQuintoImpacto.modelos.Curso;

import java.util.List;


public interface CursoServicio {

    public Curso getCursoById(long id);
    public void saveCurso(Curso curso);

    public List<Curso> getAllCursos ();

}
