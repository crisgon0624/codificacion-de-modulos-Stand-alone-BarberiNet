package com.barberia.repository;

import com.barberia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este archivo es el puente entre Java y la base de datos MySQL.
 * Gracias a JpaRepository, ya tenemos listos los comandos para guardar, 
 * borrar o buscar clientes sin escribir mucho código.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
// Esta interfaz queda vacía porque JpaRepository ya trae todos los comandos
    // necesarios para manejar la tabla de clientes automáticamente.
    
     // Este método busca un cliente por su correo electrónico
    Cliente findByEmail(String email);
}