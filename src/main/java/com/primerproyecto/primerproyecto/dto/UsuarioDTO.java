package com.primerproyecto.primerproyecto.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
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
