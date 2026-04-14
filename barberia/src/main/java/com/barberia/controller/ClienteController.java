package com.barberia.controller;

import com.barberia.model.Cliente;
import com.barberia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Este controlador es el que recibe las órdenes desde la web. 
 * Aquí definimos las rutas (URL) para que el sistema sepa qué responder.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // Aquí traemos el repositorio para poder usar los datos de la base de datos
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Cuando alguien entra a /api/clientes, este método busca a todos 
     * los clientes en la base de datos y los muestra en una lista.
     */
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }
}

