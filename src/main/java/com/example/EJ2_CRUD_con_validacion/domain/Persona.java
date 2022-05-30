package com.example.EJ2_CRUD_con_validacion.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //CREO UN ID AUTOGENERADO
    int id_persona;

    @Column
    private String user;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String company_email;

    @Column
    private String personal_email;

    @Column
    private String city;

    @Column
    private boolean active;

    @Column
    private String created_date;

    @Column
    private String imagen_url;
    @Column
    private String termination_date;
}
