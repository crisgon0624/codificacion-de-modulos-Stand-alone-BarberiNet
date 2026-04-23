package com.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Esta clase es la que crea la tabla de clientes en la base de datos.
 * Aquí guardamos toda la info de las personas que vienen a la barbería.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    // El ID es el número único de cada cliente, se pone solo (autoincrementable)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Información personal del cliente
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
   
    @NotBlank(message = "El segundo nombre es obligatorio")
    private String segundoNombre;
    
    @NotBlank(message = "El primer allido es obligatorio")
    private String primerApellido;
    
    @NotBlank(message = "El segundo apillido es obligatorio")
    private String segundoApellido;

    // Datos adicionales
    @NotBlank(message = "la fecha de nacimiento es obligatoria")
    private String fechaNacimiento;
    
    @NotBlank(message = "El documento es obligatorio")
    private String documento;
    
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    
    @NotBlank(message = "La ciudad es obligatoria")
    private String ciudad;

    // Contacto
    @NotBlank(message = "El celular es obligatorio")
    private String celular;
    
    
     @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    private String email;

    // Seguridad (contraseña del usuario)
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
    private String contrasena;

    // Constructor vacío: Spring lo necesita para que el proyecto no saque error
    public Cliente() {
    }

    // Este constructor nos sirve para crear un cliente nuevo con sus datos de una vez
    public Cliente(String nombre, String segundoNombre, String primerApellido, String segundoApellido,
                   String fechaNacimiento, String documento, String direccion, String ciudad,
                   String celular, String email, String contrasena) {

        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters y Setters: Son las funciones para leer o cambiar la info de cada cliente

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}