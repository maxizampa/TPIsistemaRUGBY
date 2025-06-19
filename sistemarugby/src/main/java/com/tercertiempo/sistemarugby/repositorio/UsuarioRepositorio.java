package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Usuario;
import com.tercertiempo.sistemarugby.modelo.util.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    
    
       // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Usuario> findAll(); // LISTA TODOST
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Usuario> findByNombreUsuario(String nombreUsuario); // BUSCA POR NOMBRE
    List<Usuario> findByEmail(String email); // BUSCA POR APELLIDO
    List<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario); // BUSCA POR TIPO DE USUARIO
    long count(); // CUENTA TODOS LOS Usuario  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    

    void deleteById(@NonNull Integer id); // ELIMINA POR ID


    
}
