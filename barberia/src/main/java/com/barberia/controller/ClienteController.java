package com.barberia.controller;

import com.barberia.model.Cliente;
import com.barberia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

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
     * Este método muestra el formulario de registro
     */
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Registro"; // nombre del HTML
    }

   /**
     * Guarda el cliente cuando le dan clic al botón
     */
   @PostMapping("/guardar")
    public String guardarCliente(
            @Valid @ModelAttribute Cliente cliente,
            BindingResult result,
            @RequestParam("confirmarContrasena") String confirmarContrasena,
            org.springframework.web.servlet.mvc.support.RedirectAttributes flash, // Cambiamos esto
            Model model) {

        // Si hay errores (campos vacíos), volvemos al formulario SIN el mensaje de éxito
        if (result.hasErrors()) {
            return "Registro"; 
        }

        // Validar contraseñas
        if (!cliente.getContrasena().equals(confirmarContrasena)) {
            model.addAttribute("mensaje", "Las contraseñas no coinciden");
            return "Registro";
        }

        // Validar largo del celular (10 dígitos)
        if (cliente.getCelular() == null || cliente.getCelular().length() != 10) {
            model.addAttribute("mensaje", "El celular debe tener 10 números");
            return "Registro";
        }

        // Si todo está OK, guardamos
        clienteRepository.save(cliente);

        // Usamos flash para que el mensaje aparezca una sola vez y se borre solo
        flash.addFlashAttribute("mensajeExito", "¡Registro completado con éxito!");
        
        return "redirect:/clientes/registro"; 
    }
}