package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> buscaPorEmail(String email);
    Optional<Usuario> buscaPorNombreUsuario(String nombreUsuario);
    Optional<Usuario> buscaPorId(int id);
    
}
