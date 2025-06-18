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

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepositorio.buscaPorId(id).or(() -> Optional.empty());//maneja los valores null
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorNombreUsuario(String nombreUsuario) {
        return usuarioRepositorio.buscaPorNombreUsuario(nombreUsuario);
    }
}
