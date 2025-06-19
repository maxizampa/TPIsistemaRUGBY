package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Partido;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartidoRepositorio extends JpaRepository<Partido, Integer> {

    // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Partido> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Partido> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Partido> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS Partido  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID
    
    // Métodos personalizados
    List<Partido> findByEquipoLocalNombre(String nombreEquipoLocal);
    List<Partido> findByEquipoVisitanteNombre(String nombreEquipoVisitante);
    List<Partido> findByFecha(LocalDate fecha);
    List<Partido> findByEstadioNombre(String nombreEstadio);
    List<Partido> findByArbitroNombre(String nombreArbitro);
    List<Partido> findByEstadoPartido(EstadoPartido estadoPartido);
    List<Partido> findByResultadoPartido(ResultadoPartido resultadoPartido);
    
}
