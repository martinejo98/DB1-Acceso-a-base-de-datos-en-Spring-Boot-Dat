package com.example.EJ2_CRUD_con_validacion.application.service;

import com.example.EJ2_CRUD_con_validacion.application.repository.PersonaRepository;
import com.example.EJ2_CRUD_con_validacion.domain.Persona;
import com.example.EJ2_CRUD_con_validacion.infraestructure.dto.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ModelMapper modelMapper;

    public Persona addPersona(Persona persona) throws Exception {
        if(persona.getUsuario() != null && persona.getUsuario().length() <= 10 && persona.getUsuario().length() >= 6){
            if(persona.getName() != null){
                if (persona.getSurname() != null) {
                    if (persona.getPassword() != null) {
                        if (persona.getCompany_email() != null) {
                            if(persona.getPersonal_email() != null){
                                if (persona.getCity() != null) {
                                    personaRepository.save(persona);
                                    return persona;
                                } else {
                                    throw new Exception("El campo email personal no puede estar vacío");
                                }
                            }else{
                                throw new Exception("El campo email personal no puede estar vacío");
                            }
                        } else {
                            throw new Exception("El campo email corporativo no puede estar vacío");
                        }
                    }else{
                        throw new Exception("El campo contraseña no puede estar vacío");
                    }
                }else{
                    throw new Exception("El campo apellido no puede estar vacío");
                }
            }else{
                throw new Exception("El campo nombre no puede estar vacío");
            }
        }else{
            throw new Exception("El campo usuario debe tener entre 6 y 10 caracteres");
        }
    }

    public PersonaDTO getPersonaByID(Integer id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(()-> new Exception("No se ha encontrado a nadie con el id: "+id));
        PersonaDTO peDTO = modelMapper.map(persona, PersonaDTO.class);
        return peDTO;
    }

    public List<PersonaDTO> getPersonaByName(String name){
        List <PersonaDTO> listaPersonas = new ArrayList<>();
        personaRepository.findAll().forEach(
                person -> {
                    if(person.getName().equals(name)){
                        PersonaDTO peDTO = modelMapper.map(person, PersonaDTO.class);
                        listaPersonas.add(peDTO);
                    }
                }
        );

        return listaPersonas;
    }

    public List<PersonaDTO> getAll(){
        List <PersonaDTO> listaPersonas = new ArrayList<>();
        personaRepository.findAll().forEach(
                person -> {
                    PersonaDTO peDTO = modelMapper.map(person, PersonaDTO.class);
                    listaPersonas.add(peDTO);
                }
        );
        return listaPersonas;
    }

    /**
     * Este metodo lo que hace esc convertirme todas las persona que encuentra el findAll() en personasDTO
     * y me lo añade a la lista de personasDTO que he creado y la retorna
     */

}
