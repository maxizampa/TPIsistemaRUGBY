package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Temporada;
import com.tercertiempo.sistemarugby.modelo.util.EstadoTemporada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TemporadaRepositorio extends JpaRepository<Temporada, Integer> {

       // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Temporada> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Temporada> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Temporada> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS Temporada  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID

    // Métodos personalizados
    List<Temporada> findByAnio(int anio);
    List<Temporada> findByEstado(EstadoTemporada estado);

}
