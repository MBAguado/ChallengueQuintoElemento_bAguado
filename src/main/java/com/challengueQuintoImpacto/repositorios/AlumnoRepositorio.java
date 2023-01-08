package com.challengueQuintoImpacto.repositorios;

import com.challengueQuintoImpacto.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AlumnoRepositorio extends JpaRepository<Alumno,Long> {

 Alumno findById(long id);
Alumno findByNombre(String nombre);
}
