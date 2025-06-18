package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Partido;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartidoRepositorio extends JpaRepository<Partido, Integer> {

    List<Partido> buscaPorEquipoLocalNombre(String nombreEquipoLocal);

    List<Partido> buscaPorEquipoVisitanteNombre(String nombreEquipoVisitante);

    List<Partido> buscaPorFecha(LocalDate fecha);

    List<Partido> buscaPorEstadioNombre(String nombreEstadio);

    List<Partido> buscaPorArbitroNombre(String nombreArbitro);

    List<Partido> buscaPorEstadoPartido(EstadoPartido estadoPartido);

    List<Partido> buscaPorResultaPartido(ResultadoPartido resultadoPartido);
    
}
