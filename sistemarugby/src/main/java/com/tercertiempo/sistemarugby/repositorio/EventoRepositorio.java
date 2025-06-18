package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

    List<Evento> buscaPorNombre(String nombre); 

    List<Evento> buscaPorFecha(LocalDate fecha); 

    List<Evento> buscaPorTipo(String tipo); 

    List<Evento> buscaPorEquipoNombre(String nombreEquipo); 

    List<Evento> buscaPorEstadioNombre(String nombreEstadio);
}

