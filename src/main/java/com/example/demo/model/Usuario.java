package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marca esta clase como una entidad de JPA, lo que indica que corresponde a una tabla en la base de datos.
public class Usuario {
    @Id // Define el campo `id` como la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de `id` será generado automáticamente usando la estrategia de "IDENTITY".
    private Long id; // Identificador único del usuario.

    private String nombre; // Nombre del usuario.
    private String correo; // Correo electrónico del usuario.

    // Métodos getter y setter para acceder y modificar los campos de la clase.

    public Long getId() {
        return id; // Devuelve el valor del ID del usuario.
    }
    public void setId(Long id) {
        this.id = id; // Establece un valor para el ID del usuario.
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del usuario.
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece un nuevo valor para el nombre del usuario.
    }

    public String getCorreo() {
        return correo; // Devuelve el correo electrónico del usuario.
    }
    public void setCorreo(String correo) {
        this.correo = correo; // Establece un nuevo valor para el correo electrónico del usuario.
    }
}