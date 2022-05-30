package com.example.EJ2_CRUD_con_validacion.infraestructure.dto;

import lombok.Data;

@Data
public class PersonaDTO {

    //Los DTO sólo tienen GETTER y SETTERS ya que sólo tratan datos
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private String created_date;
    private String imagen_url;
    private String termination_date;
}
