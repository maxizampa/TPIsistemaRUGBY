package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {
     // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Jugador> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Jugador> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Jugador> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS Jugador  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID

}