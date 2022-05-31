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
    public String addPersona(@RequestBody Persona persona) throws Exception {
        personaService.addPersona(persona);
        return "Persona añadida";
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

    @PutMapping("/update/{id}")
    public String addPersona(@RequestBody Persona persona, @PathVariable int id){
        personaService.updatePersona(id, persona);
        return "Persona actualziada";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable int id){
        personaService.deletePersona(id);
        return "Persona eliminada";
    }
}
