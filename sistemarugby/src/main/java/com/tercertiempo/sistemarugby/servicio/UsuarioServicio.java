package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Usuario;
import com.tercertiempo.sistemarugby.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Obtener todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // Buscar usuario por ID con manejo seguro de Optional
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    // Guardar usuario con validación previa
    public Usuario guardarUsuario(Usuario usuario) {
        if (!usuarioRepositorio.findByNombre(usuario.getNombreUsuario()).isEmpty()) {
            throw new IllegalArgumentException("El usuario ya existe.");
        }
        return usuarioRepositorio.save(usuario);
    }

    // Buscar usuario por nombre de usuario
    public List<Usuario> obtenerPorNombreUsuario(String nombreUsuario) {
        return usuarioRepositorio.findByNombre(nombreUsuario);
    }
}
