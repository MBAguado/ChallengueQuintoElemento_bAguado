package com.challengueQuintoImpacto.repositorios;

import com.challengueQuintoImpacto.modelos.Alumno;
import com.challengueQuintoImpacto.modelos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesorRepositorio extends JpaRepository<Profesor,Long> {

    Profesor findByNombreProfesor(String nombreProfesor);
}
