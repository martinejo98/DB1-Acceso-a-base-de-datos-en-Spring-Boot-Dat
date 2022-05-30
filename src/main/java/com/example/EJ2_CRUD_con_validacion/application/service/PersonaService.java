package com.example.EJ2_CRUD_con_validacion.application.service;

import com.example.EJ2_CRUD_con_validacion.application.repository.PersonaRepository;
import com.example.EJ2_CRUD_con_validacion.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public Persona addPersona(Persona persona){
        personaRepository.save(persona);
        return persona;
    }

    /*public Optional<Persona> getPersonaByID(int id){
        return personaRepository.findById(id);
    }

    public Persona getPersonaByName(){
        return (Persona) personaRepository.findAll();
    }*/
}
