package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Usuario;
import com.tercertiempo.sistemarugby.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorNombreUsuario(String nombreUsuario) {
        return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }
}
