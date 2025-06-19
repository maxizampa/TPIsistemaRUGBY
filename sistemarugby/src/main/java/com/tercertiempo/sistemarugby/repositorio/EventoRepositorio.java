package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Integer> {
     // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Evento> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Evento> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Evento> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS Evento  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID

    // metodo personalizado 
    List<Evento> findByFecha(LocalDate fecha);
    List<Evento> findByEntreFechas(LocalDate inicio, LocalDate fin);
}

