package com.example.EJ2_CRUD_con_validacion.application.repository;

import com.example.EJ2_CRUD_con_validacion.domain.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
