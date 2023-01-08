package com.challengueQuintoImpacto.repositorios;

import com.challengueQuintoImpacto.modelos.Curso;
import com.challengueQuintoImpacto.modelos.NombreCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoRepositorio extends JpaRepository<Curso, Long> {


}
