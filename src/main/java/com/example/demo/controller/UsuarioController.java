package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST y que todos los métodos devolverán JSON por defecto.
@RequestMapping("/api/usuarios") // Define la URL base para acceder a los métodos de este controlador.
public class UsuarioController {

    @Autowired // Inyecta una instancia de UsuarioRepository para interactuar con la base de datos.
    private UsuarioRepository usuarioRepository;

    @GetMapping // Maneja solicitudes GET a "/api/usuarios" y devuelve una lista de todos los usuarios.
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll(); // Usa el repositorio para obtener y devolver todos los usuarios.
    }

    @PostMapping // Maneja solicitudes POST a "/api/usuarios" y permite crear un nuevo usuario.
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario); // Guarda el nuevo usuario en la base de datos y lo devuelve.
    }

    @GetMapping("/{id}") // Maneja solicitudes GET a "/api/usuarios/{id}" para obtener un usuario específico.
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null); // Busca un usuario por ID y lo devuelve; si no existe, devuelve null.
    }

    @PutMapping("/{id}") // Maneja solicitudes PUT a "/api/usuarios/{id}" para actualizar un usuario específico.
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null); // Busca el usuario por ID.
        if (usuario != null) { // Si el usuario existe, actualiza sus detalles.
            usuario.setNombre(usuarioDetalles.getNombre()); // Actualiza el nombre del usuario.
            usuario.setCorreo(usuarioDetalles.getCorreo()); // Actualiza el correo del usuario.
            return usuarioRepository.save(usuario); // Guarda los cambios y devuelve el usuario actualizado.
        }
        return null; // Si el usuario no existe, devuelve null.
    }

    @DeleteMapping("/{id}") // Maneja solicitudes DELETE a "/api/usuarios/{id}" para eliminar un usuario específico.
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id); // Elimina el usuario con el ID especificado de la base de datos.
    }
}
