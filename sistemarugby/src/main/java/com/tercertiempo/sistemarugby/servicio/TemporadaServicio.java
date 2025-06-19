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

    // Obtener todas las temporadas
    public List<Temporada> obtenerTodas() {
        return temporadaRepositorio.findAll();
    }

    // temporada por ID
    public Optional<Temporada> obtenerPorId(int id) {
        return temporadaRepositorio.findById(id);
    }

    // Guarda temporada 
    public Temporada guardarTemporada(Temporada temporada) {
        if (temporadaRepositorio.existsById(temporada.getId())) {
            throw new IllegalArgumentException("La temporada ya está registrada.");
        }
        return temporadaRepositorio.save(temporada);
    }

    // Eliminar temporada por ID 
    public void eliminarTemporada(int id) {
        if (!temporadaRepositorio.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar, la temporada no existe.");
        }
        temporadaRepositorio.deleteById(id);
    }

    // Buscar temporadas por año
    public List<Temporada> buscarPorAnio(int anio) {
        return temporadaRepositorio.findByAnio(anio);
    }


    public List<Temporada> buscarPorEstado(EstadoTemporada estado) {
        return temporadaRepositorio.findByEstado(estado);
    }

    // estado de una temporada
    public EstadoTemporada obtenerEstadoTemporada(int temporadaId) {
        Optional<Temporada> temporadaOpt = temporadaRepositorio.findById(temporadaId);
        if (temporadaOpt.isEmpty()) {
            return EstadoTemporada.INACTIVA;
        }

        Temporada temporada = temporadaOpt.get();
        List<Partido> partidos = temporada.getPartidos();

        if (partidos.isEmpty()) {
            return EstadoTemporada.INACTIVA;
        }

        LocalDate fechaActual = LocalDate.now();
        LocalDate inicioTemporada = partidos.stream().map(Partido::getFecha).min(LocalDate::compareTo).orElse(fechaActual);
        LocalDate finTemporada = partidos.stream().map(Partido::getFecha).max(LocalDate::compareTo).orElse(fechaActual);

        if (fechaActual.isBefore(inicioTemporada)) {
            return EstadoTemporada.INACTIVA;
        } else if (fechaActual.isAfter(finTemporada)) {
            return EstadoTemporada.FINALIZADA;
        } else {
            return EstadoTemporada.ACTIVA;
        }
    }

    // Contar partidos faltantes en la temporada
    public int contarPartidosFaltantes(int temporadaId) {
        Optional<Temporada> temporadaOpt = temporadaRepositorio.findById(temporadaId);
        if (temporadaOpt.isEmpty()) {
            return 0;
        }

        Temporada temporada = temporadaOpt.get();
        return (int) temporada.getPartidos().stream()
                .filter(partido -> partido.getEstado() == EstadoPartido.PROGRAMADO)
                .count();
    }
}

