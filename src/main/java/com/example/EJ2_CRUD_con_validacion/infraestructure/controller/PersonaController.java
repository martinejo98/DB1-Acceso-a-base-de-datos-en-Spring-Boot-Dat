package com.example.EJ2_CRUD_con_validacion.infraestructure.controller;

import com.example.EJ2_CRUD_con_validacion.application.service.PersonaService;
import com.example.EJ2_CRUD_con_validacion.domain.Persona;
import com.example.EJ2_CRUD_con_validacion.infraestructure.dto.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/addPersona")
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO){
        Persona persona = personaService.addPersona(modelMapper.map(personaDTO, Persona.class));  //ModelMapper hace que pueda convertir de una clase a otra
        personaDTO.setId_persona(persona.getId_persona());
        return personaDTO;
    }

    @GetMapping("/getPersonaID/{id}")
    public PersonaDTO getPersonaByID(@PathVariable int id) throws Exception {
        return personaService.getPersonaByID(id);
    }


    @GetMapping("/getPersonaName/{name}")
    public List<PersonaDTO> getPersonaByName(@PathVariable String name){
        return personaService.getPersonaByName(name);
    }

    @GetMapping("/getAll")
    public List <PersonaDTO> getAll(){
        return personaService.getAll();
    }
}
