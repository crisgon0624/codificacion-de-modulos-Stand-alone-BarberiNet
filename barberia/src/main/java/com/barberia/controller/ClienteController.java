package com.barberia.controller;

import com.barberia.model.Cliente;
import com.barberia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Este controlador es el que recibe las órdenes desde la web.
 * Aquí definimos las rutas (URL) para que el sistema sepa qué responder.
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    // Aquí traemos el repositorio para poder usar los datos de la base de datos
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Este método es opcional.
     * Sirve para ver todos los clientes en formato JSON desde el navegador.
     * URL: http://localhost:8085/clientes/api
     */
    @GetMapping("/api")
    @ResponseBody
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Este método se ejecuta cuando el usuario envía el formulario de registro.
     * Recibe los datos, crea un objeto Cliente automáticamente
     * y lo guarda en la base de datos.
     */
    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente); // Guarda el cliente en la BD
        return "redirect:/"; // Redirige al inicio después de guardar
    }
}