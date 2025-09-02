package com.primerproyecto.primerproyecto.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data

public class Usuario {
    public Usuario() {
        //TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     * ID del usuario
     */
    private Long id;
    /*
     * Nombre del usuario
     */
    private String nombre;
    /*
     * correo del usuario
     */
    private String correo;
    /*
     * clave del usuario
     */
    private String clave;

    /*
     * Fecha de creacion del usuario
     */
    private Timestamp fechaCreacion;
}
