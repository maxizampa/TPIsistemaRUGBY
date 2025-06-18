package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Temporada;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.EstadoTemporada;
import com.tercertiempo.sistemarugby.repositorio.TemporadaRepositorio;
import org.springframework.stereotype.Service;
import com.tercertiempo.sistemarugby.modelo.entidades.Partido;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TemporadaServicio {

    private final TemporadaRepositorio temporadaRepositorio;

    public TemporadaServicio(TemporadaRepositorio temporadaRepositorio) {
        this.temporadaRepositorio = temporadaRepositorio;
    }

    public List<Temporada> obtenerTodas() {
        return temporadaRepositorio.findAll();
    }

    public Optional<Temporada> obtenerPorId(int id) {
        return temporadaRepositorio.findById(id);
    }

    public Temporada guardarTemporada(Temporada temporada) {
        return temporadaRepositorio.save(temporada);
    }

    public void eliminarTemporada(int id) {
        temporadaRepositorio.deleteById(id);
    }

    public EstadoTemporada obtenerEstadoTemporada(int temporadaId) {
    Optional<Temporada> temporadaOpt = temporadaRepositorio.findById(temporadaId);
    if (temporadaOpt.isPresent()) {
        Temporada temporada = temporadaOpt.get();
        List<Partido> partidos = temporada.getPartidos();

        if (partidos.isEmpty()) {
            return EstadoTemporada.INACTIVA;
        }

        LocalDate fechaActual = LocalDate.now();
        LocalDate inicioTemporada = partidos.get(0).getFecha();
        LocalDate finTemporada = partidos.get(0).getFecha();

        for (Partido partido : partidos) {
            LocalDate fechaPartido = partido.getFecha();
            if (fechaPartido.isBefore(inicioTemporada)) {
                inicioTemporada = fechaPartido;
            }
            if (fechaPartido.isAfter(finTemporada)) {
                finTemporada = fechaPartido;
            }
        }

        if (fechaActual.isBefore(inicioTemporada)) {
            return EstadoTemporada.INACTIVA;
        } else if (fechaActual.isAfter(finTemporada)) {
            return EstadoTemporada.FINALIZADA;
        } else {
            return EstadoTemporada.ACTIVA;
        }
    }

    return EstadoTemporada.INACTIVA;

}
public int contarPartidosFaltantes(int temporadaId) {
    Optional<Temporada> temporadaOpt = temporadaRepositorio.findById(temporadaId);
    if (temporadaOpt.isPresent()) {
        Temporada temporada = temporadaOpt.get();
        List<Partido> partidos = temporada.getPartidos();

        int partidosFaltantes = 0;
        for (Partido partido : partidos) {
            if (partido.getEstado() == EstadoPartido.PROGRAMADO) {
                partidosFaltantes++;
            }
        }

        return partidosFaltantes;
    }

    return 0; 

    }
}