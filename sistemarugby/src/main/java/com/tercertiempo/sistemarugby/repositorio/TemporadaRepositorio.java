package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Temporada;
import com.tercertiempo.sistemarugby.modelo.util.EstadoTemporada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TemporadaRepositorio extends JpaRepository<Temporada, Integer> {

    List<Temporada> buscaPorNombre(String nombre);

    List<Temporada> buscaPorAnio(int anio);

    List<Temporada> buscaPorEstado(EstadoTemporada estado);

}
